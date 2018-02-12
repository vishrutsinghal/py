package com.locators.selenium.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Createlocators {
	public  List<String> relxpath = null;
	public static WebDriver driver = null;

	public  String getText(WebDriver driver, WebElement element){
		
        return (String) ((JavascriptExecutor) driver).executeScript(
            "return jQuery(arguments[0]).text();", element);
    }

    public  void ByTagxpathcreate(WebDriver driver, List<String> tagnames) throws IOException, RowsExceededException, WriteException, BiffException
    {
           try{
           relxpath= new ArrayList<String>();
      //capturs  tag , name
           
           for(String tagname:tagnames){
     List<WebElement> elementsinputn = driver.findElements(By.tagName(tagname));
    // System.out.println(elementsinputn.size());
     for(WebElement ele : elementsinputn)
           
     {     
           String temp1;
           String temp = ele.getAttribute("name");
           if(temp!=null)
                  if(temp.length()!=0){
                  
           relxpath.add("//"+tagname+"[@name=\""+temp+"\"]");
                  }
           temp = ele.getAttribute("id");
           if(temp!=null)
                  if(temp.length()!=0){
           relxpath.add("//"+tagname+"[@id=\""+temp+"\"]");
                  }
           
           
           temp = ele.getAttribute("href");
           /*String script = "document.element.getAttribute('href')";
           temp=(String) ((JavascriptExecutor) driver).executeScript(script,ele);
           System.out.println(temp);*/
           if(temp!=null)
                  if(temp.length()!=0){
           relxpath.add("//"+tagname+"[@href=\""+temp+"\"]");
                  }
           
           //temp = ele.getText();
           //temp=(String) ((JavascriptExecutor) driver).executeScript(script, ele);
           
           temp=getText(driver,ele);
           if(temp!=null)
                  if(!temp.isEmpty()){
                        //System.out.println(temp+"------------------");
                        char ch[] = temp.toCharArray();
                        int count=0;
                        for(Character c:ch)
                        {      count++;
                               int i=c;
                               //System.out.print(i+"-");
                               if((i==32)|(i==10)|(i==9))
                               {
                                      if(i==10|i==9)
                                      {
                                             temp=" ";
                                             break;
                                      }
                                      if(count>2){
                                             temp=" ";
                                             break;
                                      }
                               }
                               if(count>2)
                                      break;
                        }
                        if(!temp.equals(" ")){
                        if(temp.length()<125){
                               //String path = "//"+tagname+"[text()=\""+temp+"\"]";
                               relxpath.add("//"+tagname+"[text()=\""+temp+"\"]");
                               //System.out.println(path);
                               
                        }}
                  }
           temp = ele.getAttribute("class");
           if(temp!=null)
                  if(temp.length()!=0){
           relxpath.add("//"+tagname+"[@class=\""+temp+"\"]");
                  }
           temp = ele.getAttribute("src");
           if(temp!=null)
                  if(temp.length()!=0){
           relxpath.add("//"+tagname+"[@src=\""+temp+"\"]");
                  }
           temp = ele.getAttribute("alt");
           if(temp!=null)
                  if(temp.length()!=0){
           relxpath.add("//"+tagname+"[@alt=\""+temp+"\"]");
                  }
           temp = ele.getAttribute("title");
           if(temp!=null)
                  if(temp.length()!=0){
           relxpath.add("//"+tagname+"[@title=\""+temp+"\"]");
                  }
           temp = ele.getAttribute("name");  //for version 1 commment line 71  to 81 this code
           temp1 = ele.getAttribute("type");
           if(temp!=null&&temp1!=null)
                  if(temp.length()!=0){
           relxpath.add("//"+tagname+"[@type=\""+temp1+"\" and @name=\""+temp+"\"]");
                  }
           temp = ele.getAttribute("id");
           temp1 = ele.getAttribute("type");
           if(temp!=null&&temp1!=null)
                  if(temp.length()!=0){
           relxpath.add("//"+tagname+"[@type=\""+temp1+"\" and @id=\""+temp+"\"]");
                  }
     }
           }}catch(Exception e)
     {
           e.printStackTrace();
     }
     
     
           
           //removeemptyfromlist(relxpath);
           
    }
    public void removeemptyfromlist(List<String> li)  
 {
     for(int i=0;i<li.size();i++)
            if(li.get(i).contains("=''")){
            li.remove(i);
            System.out.println("Index removed : "+li.get(i));
            }
 }
    

	
	
	public static void exeptionhandlingcap()
	{
		
	}
	

}
