package com.locators.selenium.accesspoint;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Locatorcreator {
	/**
	 * @param args
	 */
	  
	 public static WebDriver driver = null;
	public static List<String> locators = new ArrayList<String>();
	public static List<String> Tagnames = new ArrayList<String>();
	 
	static String drivers = "X:\\Chrome\\selenium\\src\\main\\resources\\Drivers";
	
	
	
	public static void main(String[] args) throws IOException, JXLException  {
		
		/*Createlocators cret = new Createlocators();
		Xlprocessing xlsp = new Xlprocessing();
		Tagnames=xlsp.xlsreader("X:/Tagname.xls");
		//driver = driverlauncher();
		cret.ByTagxpathcreate(driver,Tagnames);
		//xlsp.writelocatorxls(cret.relxpath);
		 * 
		 * 
		*/
		
		
		List<String> items = Lists.newArrayList("a","b","c","d");
		for(String item:Iterables.cycle(items))
		{
			System.out.println(item);
		}
		
		
		
		
	}
	
	
	
////////////////////////////////////////////	
	public  WebDriver driverlauncher()
	{
		
		 ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        options.addArguments("disable-popup-blocking");
        options.addArguments("--disable-extensions");
        
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        File file = new File(drivers + "\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",
                      file.getAbsolutePath());
        driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        driver.get("https://sso-tst3.unionbank.com/obc/forms/login.fcc");
		return driver;
	}
	
/////////////////////////////////////////////////////////	
	public static List<String> xpathcreator(WebDriver driver) throws IOException, RowsExceededException, WriteException, BiffException
	{
		
         
         //capturs input tag , name
        List<WebElement> elementsinputn = driver.findElements(By.tagName("input"));
        System.out.println(elementsinputn.size());
        for(WebElement ele : elementsinputn)
        {
        	String temp = ele.getAttribute("name");
        	locators.add("//*[@name='"+temp+"']");
        	System.out.println(temp);
        }
        
        //captures  input tag id
        List<WebElement> elementsinputid = driver.findElements(By.tagName("input"));
        System.out.println(elementsinputid.size());
        for(WebElement ele : elementsinputid)
        {
        	String temp = ele.getAttribute("id");
        	locators.add("//*[@id='"+temp+"']");
        	System.out.println(temp);
        }
        
        //captures a tag , name
        List<WebElement> elementsan = driver.findElements(By.tagName("a"));
        System.out.println(elementsan.size());
        for(WebElement ele : elementsan)
        {
        	String temp = ele.getAttribute("name");
        	locators.add("//*[@name='"+temp+"']");
        	System.out.println(temp);
        }
        
        List<WebElement> elementsaid = driver.findElements(By.tagName("a"));
        System.out.println(elementsaid.size());
        for(WebElement ele : elementsaid)
        {
        	String temp = ele.getAttribute("id");
        	locators.add("//*[@id='"+temp+"']");
        	System.out.println(temp);
        }
        //captures a and href
        List<WebElement> elementsah = driver.findElements(By.tagName("a"));
        System.out.println(elementsah.size());
        for(WebElement ele : elementsah)
        {
        	String temp = ele.getAttribute("href");
        	locators.add("//*[@href='"+temp+"']");
        	System.out.println(temp);
        }
        ///captures a text
        List<WebElement> elementsat = driver.findElements(By.tagName("a"));
        System.out.println(elementsat.size());
        for(WebElement ele : elementsat)
        {
        	String temp = ele.getText();
        	locators.add("//*[text()='"+temp+"']");
        	System.out.println(temp);
        }
        //captures div id
        List<WebElement> elementsidivid = driver.findElements(By.tagName("div"));
        System.out.println(elementsidivid.size());
        for(WebElement ele : elementsidivid)
        {
        	String temp = ele.getAttribute("id");
        	locators.add("//*[@id='"+temp+"']");
        	System.out.println(temp);
        
        }
        
        //capturs table in web page
        List<WebElement> elementstablec = driver.findElements(By.tagName("table"));
        System.out.println(elementstablec.size());
        for(WebElement ele : elementstablec)
        {
        	String temp = ele.getAttribute("class");
        	locators.add("//*[@class='"+temp+"']");
        	System.out.println(temp);
        }
        
        //capturs frame name
        List<WebElement> elementsframe = driver.findElements(By.tagName("frame"));
        System.out.println(elementsframe.size());
        for(WebElement ele : elementsframe)
        {
        	String temp = ele.getAttribute("name");
        	
        	System.out.println(temp);
        }
        
        
      //capturs frame id
        List<WebElement> elementsframeid = driver.findElements(By.tagName("frame"));
        System.out.println(elementsframeid.size());
        for(WebElement ele : elementsframeid)
        {
        	String temp = ele.getAttribute("id");
        	locators.add(temp);
        	System.out.println(temp);
        }
        driver.quit();
		return locators;
        
        	
	}
	
	
	public static void GetallattributesofTag(){
		
	}
	
	public static void writelocatorxls(List<String> locators) throws IOException, RowsExceededException, JXLException
	{
		FileOutputStream fo = new FileOutputStream("X:/xpathlocators.xls");
        WritableWorkbook wb = Workbook.createWorkbook(fo);
        WritableSheet ws = wb.createSheet("Locators", 1);
        int row=1;
        for(String locator : locators)
        {
        Label label1 = new Label(0,row,"locator_index_"+row);
        Label label = new Label(1,row,locator);
        
        row = row +1;
        ws.addCell(label);
        ws.addCell(label1);
        }
        wb.write();
        wb.close();
        xlsreader(); 
	}
	
	
	public static List<String> xlsreader() throws BiffException, IOException
	{
		Map<String, List<String>> map = new HashMap<String, List<String>>(); 
		List<String> testcases = new ArrayList<String>();
	    Workbook workBook=Workbook.getWorkbook(new File ("X:/xpathlocators.xls"));
	    String [] sheetNames = workBook.getSheetNames();
	    Sheet sheet=null;
	    for (int sheetNumber =0; sheetNumber < sheetNames.length; sheetNumber++){
	       List<String > fields = new ArrayList<String>();
	       sheet=workBook.getSheet(sheetNames[sheetNumber]);
	       int row = sheet.getRows();
	       if(sheetNames[sheetNumber].equals("Locators"))
	       for (int columns=1;columns < row;columns++){
	    	   testcases.add(sheet.getCell(1,columns ).getContents());
	    	   
	           fields.add( sheet.getCell(1,columns).getContents()); 
	           System.out.println( sheet.getCell(0,columns).getContents()+" = "+sheet.getCell(1,columns).getContents());
	       }
	       map.put(sheetNames[sheetNumber],fields); 
	    }
	   
	    return testcases;
	}


}
