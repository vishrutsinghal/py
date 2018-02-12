package com.locators.selenium.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.CellType;
import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Xlprocessing extends Createlocators{

	public static String exsheet=null;
	public static int counter=0;
	public static int repcounter=0;
	public static String recsheet=null;
	public static String recindex=null;
	public static String recpath=null;
	public static String recxpath=null;
	public static int recorowno;
	
	public static boolean sheetchangeflage=false;
	public static HashMap<String,String> templocators = new HashMap<String,String>();
	
	
	
	public  void writelocatorxls(List<String> locators, String path,String sheetname) throws IOException, RowsExceededException, JXLException
	{
		boolean createflag=true;
		
		File file = new File(path);
		FileOutputStream fo = null;
		WritableWorkbook wb=null;
		WritableSheet ws=null;
		if(file.exists()){
		Workbook workBook=Workbook.getWorkbook(new File (path));
		String [] sheetNames = workBook.getSheetNames();
		   
		for(String sheetname1:sheetNames) 
		{
		if(file.exists()&&sheetname1.equals(sheetname)){
			appendtoxls(locators,path,sheetname);
			createflag=false;
			break;
		}else
		{
			newsheetcreation(locators,path,sheetname);
		}
		}
		
		
		}else{	
	        
		if(!file.exists())
		{
		fo = new FileOutputStream(path);
        wb = Workbook.createWorkbook(fo);
		 if(createflag){
        
        ws = wb.createSheet(sheetname, 1);
		
        int row=0;
     
        for(int i=0;i<locators.size();i++){
        	if(locators.get(i).contains("=null"))
        		locators.remove(i);
        	
        }
        for(String locator : locators)
        {
    
        
        Label label1 = new Label(0,row,"index_"+row);
        Label label = new Label(1,row,locator);
        
        row = row +1;
        ws.addCell(label);
        ws.addCell(label1);
        
        }
		
        wb.write();
        wb.close();
		}
		}
		}
		
		
	}
	
	
	public  void writelocatorxlsrepair(List<String> locators, String path,String sheetname,String existingsheet) throws IOException, RowsExceededException, JXLException
	{
		boolean createflag=true;
		
		File file = new File(path);
		FileOutputStream fo = null;
		WritableWorkbook wb=null;
		WritableSheet ws=null;
		if(file.exists()){
		Workbook workBook=Workbook.getWorkbook(new File (path));
		String [] sheetNames = workBook.getSheetNames();
		   
		for(String sheetname1:sheetNames) 
		{
		if(file.exists()&&sheetname1.equals(sheetname)){
			
			appendtoxls(locators,path,sheetname);
			createflag=false;
			break;
		}else
		{
			newsheetcreation(locators,path,sheetname);
		}
		}
		
		
		}else{	
	        
		if(!file.exists())
		{
		fo = new FileOutputStream(path);
        wb = Workbook.createWorkbook(fo);
		 if(createflag){
        
        ws = wb.createSheet(sheetname, 1);
		
        int row=1;
     
        for(int i=0;i<locators.size();i++){
        	if(locators.get(i).contains("=null"))
        		locators.remove(i);
        	
        }
        for(String locator : locators)
        {
    
        
        Label label1 = new Label(0,row,"index_"+row);
        Label label = new Label(1,row,locator);
        
        row = row +1;
        ws.addCell(label);
        ws.addCell(label1);
        
        }
		
        wb.write();
        wb.close();
		}
		}
		}
		
		
	}
	
	
	
	public  List<String> xlsreader(String path,String Sheetname) throws BiffException, IOException
	{
		Map<String, List<String>> map = new HashMap<String, List<String>>(); 
		List<String> testcases = new ArrayList<String>();
	    Workbook workBook=Workbook.getWorkbook(new File (path));
	    String [] sheetNames = workBook.getSheetNames();
	    Sheet sheet=null;
	    for (int sheetNumber =0; sheetNumber < sheetNames.length; sheetNumber++){
	       
	       sheet=workBook.getSheet(sheetNames[sheetNumber]);
	       int row = sheet.getRows();
	       if(sheetNames[sheetNumber].equals(Sheetname))
	       for (int columns=0;columns < row;columns++)
	       {
	           //System.out.println( sheet.getCell(0,columns).getContents()+" = "+sheet.getCell(1,columns).getContents());
	           testcases.add(sheet.getCell(1,columns).getContents());
	       }
	      
	    }
	    workBook.close();
	    return testcases;
	}
	
	/////////////////////////////////////////////////////////////////////////////
	public  List<String> xlstagsheet(String path,String Sheetname) throws BiffException, IOException
	{
		Map<String, List<String>> map = new HashMap<String, List<String>>(); 
		List<String> testcases = new ArrayList<String>();
	    Workbook workBook=Workbook.getWorkbook(new File (path));
	    String [] sheetNames = workBook.getSheetNames();
	    Sheet sheet=null;
	    for (int sheetNumber =0; sheetNumber < sheetNames.length; sheetNumber++){
	       
	       sheet=workBook.getSheet(sheetNames[sheetNumber]);
	       int row = sheet.getRows();
	       if(sheetNames[sheetNumber].equals(Sheetname))
	       for (int columns=0;columns < row;columns++)
	       {
	           //System.out.println( sheet.getCell(0,columns).getContents()+" = "+sheet.getCell(1,columns).getContents());
	           testcases.add(sheet.getCell(0,columns).getContents());
	       }
	      
	    }
	    workBook.close();
	    return testcases;
	}
	
	///////////////////////////////////////////////////////
	//Function get value and repair xpath
	
	public  String getxpathByIndex(String path, String sheetname, WebDriver driver1, String index) throws IOException, InterruptedException, JXLException
	{
		
		Map<String, List<String>> map = new HashMap<String, List<String>>(); 
		String xpath = null;
	    Workbook workBook=Workbook.getWorkbook(new File (path));
	    String [] sheetNames = workBook.getSheetNames();
	    Sheet sheet=null;
	    String tagnames1=null;
	    if(exsheet!=null)
	    {
	    	// System.out.println("=========================before change "+exsheet+"==========================");
	    	// System.out.println("=========================after change "+sheetname+"==========================");
	    	if(exsheet!=sheetname)
	    	{
	    		sheetchangeflage=true;
	    	}
	    		
	    }
	    exsheet=sheetname;
	    for(String name:sheetNames)
	    {
	    	if(name.equals("Tagnames"))
	    	{
	    		tagnames1=name;	
	    		break;
	    	}
	    }
	    for (int sheetNumber=0; sheetNumber < sheetNames.length; sheetNumber++){
	       
	       sheet=workBook.getSheet(sheetNames[sheetNumber]);
	       int row = sheet.getRows();
	       if(sheetNames[sheetNumber].equals(sheetname))
	       for (int columns=1;columns < row;columns++)
	       {
	        if(sheet.getCell(0,columns).getContents().equalsIgnoreCase(index)){
	        	xpath=sheet.getCell(1,columns).getContents();
	    	   System.out.println( sheet.getCell(0,columns).getContents()+" = "+sheet.getCell(1,columns).getContents());
	    	  
	    	   try{
	    		   WebDriverWait wait = new WebDriverWait(driver1,4);
	    		   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	    		  // driver.findElement(By.xpath(xpath));
	    		   System.out.println("Xpath found on page");
	    	 
	    	   //boolean flagindex=getIndex(path,"Temp"+sheetname,sheet.getCell(0,columns).getContents());
	    	  // System.out.println(flagindex);
	    	   
	    	   if(tagnames1!=null&&getIndex(path,"TempLocators",sheet.getCell(0,columns).getContents())){
	    		   
	    		//   System.out.println("Xpath found on Tempheet");
	    		   
	    	   }else if(tagnames1!=null){
	    		   
	    		   List<String> Tagnames = new ArrayList<String>();
	    		   Tagnames = xlsreader(path,"Tagnames");
	    		   ByTagxpathcreate(driver1,Tagnames);
	    		   writelocatorxlsrepair(relxpath,path,"TempLocators",sheetname);
	    		   counter++;
	    		    
	    	   }else{
	    		   System.err.println("Tagnames sheet is missing. Hence cant repaire xpath"); 
	    	   }
	    	   }catch(Exception e)
	    	   {
	    		   System.out.println("Xpath does not exist on given page !!!");
	    		   if(tagnames1!=null&&getIndex(path,"TempLocators",sheet.getCell(0,columns).getContents())){
	    		  
	    		   
	    		   System.out.println("Inbuild System utility is trying to repair the xpath wait...");
	    		   ///////////////////////////////////////////////////
	    		   recsheet=sheetname;
	    		   recindex=sheet.getCell(0,columns).getContents();
	    		   recpath=path;
	    		   recxpath=sheet.getCell(1,columns).getContents();
	    		   driver=driver1;
	    		  xpath= comparetwoexlsSheet(path,"TempLocators",path,sheetname,sheet.getCell(0,columns).getContents());
	    		   ///////////////////////////////////////////////////
	    		  
	    		   System.out.println("Repairing is done. Re-Attempting to perform action on repaired xpath1");
	    		  
	    		   System.out.println("Repaired xpath = "+xpath);
	    		   
	    		   }else if (tagnames1!=null){
	    			   List<String> Tagnames = new ArrayList<String>();
		    		   Tagnames = xlsreader(path,"Tagnames");
		    		   ByTagxpathcreate(driver1,Tagnames);
		    		   writelocatorxlsrepair(relxpath,path,"TempLocators",sheetname);
		    		   counter++;
		    		  // Thread.sleep(4000);
		    		   
		    		   System.out.println("Inbuild System utility is trying to repair the xpath wait...");
		    		   ////////////////////////////////////////////////////
		    		   recsheet=sheetname;
		    		   recindex=sheet.getCell(0,columns).getContents();
		    		   recpath=path;
		    		   recxpath=sheet.getCell(1,columns).getContents();
		    		   driver=driver1;
		    		   xpath= comparetwoexlsSheet(path,"TempLocators",path,sheetname,sheet.getCell(0,columns).getContents());
		    		   System.out.println("Repairing is done. Re-Attempting to perform action on repaired xpath2");
		    		   /////////////////////////////////////////////////// 
		    		   System.out.println("Repaired xpath = "+xpath);
	    			  
	    		   }else{
	    			   System.err.println("Tagnames sheet is missing. Hence cant repaire xpath");
	    		   }
	    		   
	    	   }
	        break;
	        }
	          
	       }
	      
	    }
	    workBook.close();
	    if(xpath==null)
	    {
	    	System.err.println("Xpath is null. Please verify sheet name or worbook path. Test stops");
	    	System.exit(0);
	    }
	    return xpath;
	}
	
	
	
/////////////////////////////////////////////////////////////////
	
	public  boolean getIndex(String path, String sheetname, String index) throws IOException, InterruptedException, JXLException
	{ 
		boolean indexflage=false;
	    Workbook workBook=Workbook.getWorkbook(new File (path));
	    WritableWorkbook copy = Workbook.createWorkbook(new File(path), workBook);
	   
	    String [] sheetNames = workBook.getSheetNames();
	    Sheet sheet=null;
	   
	    for (int sheetNumber=0; sheetNumber < sheetNames.length; sheetNumber++){
	       sheet=workBook.getSheet(sheetNames[sheetNumber]);
	       int row = sheet.getRows();
	       if(sheetNames[sheetNumber].equals(sheetname)){
	       for (int columns=1;columns < row;columns++)
	       {
	    	   if(sheetchangeflage){
	    		   WritableSheet ws = copy.getSheet(sheetname);
	    		   for(int i=row-1;i>=0;i--){
	    		   ws.removeRow(i);
	    		   }
	    		//   System.out.println("All rows are removed from Templocator Sheet !!!");
	    		  copy.write();
	    		 
	    		  sheetchangeflage=false;  
	    		  break;
	    		  }
	    	   if(counter==0)
	    	   {
	    		   WritableSheet ws = copy.getSheet(sheetname);
	    		   for(int i=row-1;i>=0;i--){
	    		   ws.removeRow(i);
	    		   
	    		   }
	    		   counter++;
	    		//   System.out.println("Temp locator file cleaned !!!");
	    		  copy.write();
	    		 
	    		  break;
	    	   }
	    		   
	    	   
	    		   
	        if(sheet.getCell(0,columns).getContents().equalsIgnoreCase(index)){
	        	indexflage=true; 
	        	 break;
	    	   }
	       
	        }
	       break;   
	       }
	
	    }
	    copy.write();
	    copy.close();
	    workBook.close();
	   
	    return indexflage;
	}
	
	//////////////////////////////////////////////////////////////////
	
	public static void appendtoxls(List<String> locators, String path,String sheetname) throws BiffException, IOException, RowsExceededException, WriteException
	{
			Workbook workbook1 = Workbook.getWorkbook(new File(path));
		    WritableWorkbook copy = Workbook.createWorkbook(new File(path), workbook1);
		    WritableSheet ws = copy.getSheet(sheetname);
		   
		    int row=ws.getRows(); //last rows
	        for(String locator : locators)
	        {
	        Label label1 = new Label(0,row,"index_"+row);
	        Label label = new Label(1,row,locator);
	        
	        row = row +1;
	        ws.addCell(label);
	        ws.addCell(label1);
	        }
		    copy.write();
		    copy.close();

	}
	//////////////////////////////////////////////////////////////
	
	public static void newsheetcreation(List<String> locators, String path,String sheetname) throws BiffException, IOException, RowsExceededException, WriteException
	
	{
		boolean createflag = false;
		Workbook workbook1 = Workbook.getWorkbook(new File(path));
	    WritableWorkbook copy = Workbook.createWorkbook(new File(path), workbook1);
	  
	    String sheets[]=copy.getSheetNames(); 
	    for(String sheet:sheets)
	    {
	    	if(sheet.equals(sheetname))
	    		createflag=true;
	    }
	   
	    
	    if(!createflag){
	    	 WritableSheet ws = copy.createSheet(sheetname,1);
	    int row=ws.getRows(); //last rows
        for(String locator : locators)
        {
        Label label1 = new Label(0,row,"index_"+row);
        Label label = new Label(1,row,locator);
        
        row = row +1;
        ws.addCell(label);
        ws.addCell(label1);
        }}
	    copy.write();
	    copy.close();
	    
	}
	
	
	//////////////////////////////////////////////////////////////
	
	public static void templocatorfun(List<String> locators)
	{
		 int i=0;
		for(String locator:locators)
		{
			templocators.put("index_", locator);
		}
	}
	
	///////////////////////////////////////////////////////
	public static void writetogivenposition(int col,int row,String value, String path,String sheetname) throws BiffException, IOException, RowsExceededException, WriteException
	{
			Workbook workbook1 = Workbook.getWorkbook(new File(path));
		    WritableWorkbook copy = Workbook.createWorkbook(new File(path), workbook1);
		    WritableSheet ws = copy.getSheet(sheetname);
		    WritableCell cell = ws.getWritableCell(col, row);
		   
		  //  System.out.println("Value "+value);
		   // int row=ws.getRows(); //last rows
		    if(cell.getType()==CellType.LABEL){
	        Label label = (Label)cell;
	        
	        label.setString(value);
	        System.out.println("Successfully updated");
		    copy.write();
		    copy.close();
		    }else{
		    	copy.write();
			    copy.close();
		    	System.err.print("Not updated since cell type is mismatched !!!!");
		    	//return;
		    }
	       // ws.addCell(label1);
	       

	}
	///////////////////////////////////////////////
	public void recoverxpath() throws BiffException, IOException, RowsExceededException, WriteException
	{
			Workbook workbook1 = Workbook.getWorkbook(new File(recpath));
		    WritableWorkbook copy = Workbook.createWorkbook(new File(recpath), workbook1);
		    WritableSheet ws = copy.getSheet(recsheet);
		    WritableCell cell = ws.getWritableCell(1, recorowno);
		   
		  //  System.out.println("Value "+value);
		   // int row=ws.getRows(); //last rows
		    if(cell.getType()==CellType.LABEL){
	        Label label = (Label)cell;
	        
	        label.setString(recxpath);
	        System.out.println("Successfully recovered to old xpath");
		    copy.write();
		    copy.close();
		    }else{
		    	copy.write();
			    copy.close();
		    	System.err.print("Not updated since cell type is mismatched !!!!");
		    	//return;
		    }
	       // ws.addCell(label1);
	      driver.quit(); 
	}
	
	
	public void comparetwoexlsfiles(String path1,String sheetnamesrc,String path2,String sheetnametarg) throws BiffException, IOException, RowsExceededException, WriteException
	{
		//Target sheet
		 Workbook workBooksrc=Workbook.getWorkbook(new File (path1));
		 Workbook workBooktrg=Workbook.getWorkbook(new File (path2));
		    String [] sheetNamessrc = workBooksrc.getSheetNames();
		    Sheet sheetsrc=null;
		    String sheetnamesrc1 = null;
		    String [] sheetNamestrg = workBooktrg.getSheetNames();
		    Sheet sheettrg=null;
		    String sheetnametrg=null;
		    for(String name: sheetNamessrc)
		    {
		    	if(name.equals(sheetnamesrc)){
		    		sheetnamesrc1=name;
		    	//	System.out.println(name);
		    		break;
		    	}
		    		
		    }
		    for(String name: sheetNamestrg)
		    {
		    	if(name.equals(sheetnametarg)){
		    		sheetnametrg=name;
		    		//System.out.println(name);
		    		break;
		    	}
		    		
		    }
		   // HashMap<String,String > fieldssrc = new HashMap<String,String>();
		  if((sheetnametrg!=null)&&(sheetnamesrc1!=null)){
		    	sheettrg=workBooktrg.getSheet(sheetnametrg);	
		    	sheetsrc=workBooksrc.getSheet(sheetnamesrc1);
		       int row = sheetsrc.getRows();
		     //  if(sheetNamessrc[sheetNumber].equals(sheetnamesrc)&&sheetNamestrg[sheetNumber].equals(sheetnametarg))
		       for (int columns=1;columns < row;columns++){
		    	   //for debug purpose
		    	   //System.out.println(sheetsrc.getCell(1,columns).getContents()+" === "+sheettrg.getCell(1,columns).getContents());
		          if(!(sheetsrc.getCell(1,columns).getContents().equals(sheettrg.getCell(1,columns).getContents()))) {
		          System.out.println( sheetsrc.getCell(0,columns).getContents()+"="+sheetsrc.getCell(1,columns).getContents());
		          System.out.println( sheettrg.getCell(0,columns).getContents()+"="+sheettrg.getCell(1,columns).getContents());
		          writetogivenposition(1,columns,sheetsrc.getCell(1,columns).getContents(),path2,sheetnametarg);
		          }
		       }
		     
		    }	
		    
		 
	}
	
	public String comparetwoexlsSheet(String path1,String sheetnamesrc,String path2,String sheetnametarg,String index) throws BiffException, IOException, RowsExceededException, WriteException
	{
		//Target sheet
		 Workbook workBooksrc=Workbook.getWorkbook(new File (path1));
		 Workbook workBooktrg=Workbook.getWorkbook(new File (path2));
		    String [] sheetNamessrc = workBooksrc.getSheetNames();
		    Sheet sheetsrc=null;
		    String sheetnamesrc1 = null;
		    String [] sheetNamestrg = workBooktrg.getSheetNames();
		    Sheet sheettrg=null;
		    String sheetnametrg=null;
		    String xpath=null;
		    for(String name: sheetNamessrc)
		    {
		    	if(name.equals(sheetnamesrc)){
		    		sheetnamesrc1=name;
		    	//	System.out.println(name);
		    		break;
		    	}
		    		
		    }
		    for(String name: sheetNamestrg)
		    {
		    	if(name.equals(sheetnametarg)){
		    		sheetnametrg=name;
		    		//System.out.println(name);
		    		break;
		    	}
		    		
		    }
		 
		  if((sheetnametrg!=null)&&(sheetnamesrc1!=null)){
		    	sheettrg=workBooktrg.getSheet(sheetnametrg);	
		    	sheetsrc=workBooksrc.getSheet(sheetnamesrc1);
		       int row = sheetsrc.getRows();
		   
		       for (int columns=1;columns < row;columns++){
		    	   //for debug purpose
		    	   //System.out.println(sheetsrc.getCell(1,columns).getContents()+" === "+sheettrg.getCell(1,columns).getContents());
		    	   if(sheetsrc.getCell(0,columns).getContents().equals(index)){
		          if(!(sheetsrc.getCell(1,columns).getContents().equals(sheettrg.getCell(1,columns).getContents()))) {
		        	 //type code need to insert 
		          System.out.println( sheettrg.getCell(0,columns).getContents()+"="+sheettrg.getCell(1,columns).getContents());
		          System.out.println(" Change to ");
		          System.out.println( sheetsrc.getCell(0,columns).getContents()+"="+sheetsrc.getCell(1,columns).getContents());
		          xpath=sheetsrc.getCell(1,columns).getContents();
		          recorowno=columns;
		          writetogivenposition(1,columns,sheetsrc.getCell(1,columns).getContents(),path2,sheetnametarg);
		          }
		          break;
		    	   }
		       }
		     
		    }	
		return xpath;    
		 
	}
	
	
	//compare the value only
	
	public String comparetwoexlsSheetvalue(String path1,String sheetnamesrc,String path2,String sheetnametarg,String index) throws BiffException, IOException, RowsExceededException, WriteException
	{
		//Target sheet
		 Workbook workBooksrc=Workbook.getWorkbook(new File (path1));
		 Workbook workBooktrg=Workbook.getWorkbook(new File (path2));
		    String [] sheetNamessrc = workBooksrc.getSheetNames();
		    Sheet sheetsrc=null;
		    String sheetnamesrc1 = null;
		    String [] sheetNamestrg = workBooktrg.getSheetNames();
		    Sheet sheettrg=null;
		    String sheetnametrg=null;
		    String xpath=null;
		    for(String name: sheetNamessrc)
		    {
		    	if(name.equals(sheetnamesrc)){
		    		sheetnamesrc1=name;
		    	//	System.out.println(name);
		    		break;
		    	}
		    		
		    }
		    for(String name: sheetNamestrg)
		    {
		    	if(name.equals(sheetnametarg)){
		    		sheetnametrg=name;
		    		//System.out.println(name);
		    		break;
		    	}
		    		
		    }
	
		  if((sheetnametrg!=null)&&(sheetnamesrc1!=null)){
		    	sheettrg=workBooktrg.getSheet(sheetnametrg);	
		    	sheetsrc=workBooksrc.getSheet(sheetnamesrc1);
		       int row = sheetsrc.getRows();
		    
		       for (int columns=1;columns < row;columns++){
		    	   //for debug purpose
		    	   //System.out.println(sheetsrc.getCell(1,columns).getContents()+" === "+sheettrg.getCell(1,columns).getContents());
		    	   if(sheetsrc.getCell(0,columns).getContents().equals(index)){
		          if(!(sheetsrc.getCell(1,columns).getContents().equals(sheettrg.getCell(1,columns).getContents()))) {
		        	  
		          System.out.println( sheettrg.getCell(0,columns).getContents()+"="+sheettrg.getCell(1,columns).getContents());
		          System.out.println(" Change to ");
		          System.out.println( sheetsrc.getCell(0,columns).getContents()+"="+sheetsrc.getCell(1,columns).getContents());
		          xpath=sheetsrc.getCell(1,columns).getContents();
		          writetogivenposition(1,columns,sheetsrc.getCell(1,columns).getContents(),path2,sheetnametarg);
		          }
		          break;
		    	   }
		       }
		     
		    }	
		return xpath;    
		 
	}
	
	public void indexmisplacerepaire()
	{
		String xpath = "//button[@type='button' and text()='Submit']";
		
		
	}
}


