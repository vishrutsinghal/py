package com.locators.selenium.accesspoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.locators.selenium.util.Createlocators;
import com.locators.selenium.util.Xlprocessing;

import jxl.JXLException;

public class ExecutionPoint {
	public static WebDriver driver = null;
	public static List<String> Tagnames = new ArrayList<String>();
	static  String  xpathlocator = null;
	public static void main(String[] args) throws Exception {
		//createxpathwithhappypath();
			onlyhappypath();
		//Xlprocessing xlsp = new Xlprocessing();
	//	xlsp.comparetwoexlsfiles("X:/createdxpaths34.xls","locator","X:/createdxpaths34.xls","locators");

	}
	
	//////////////////////////////////////////////////////////////////////
	
	public static void createxpathwithhappypath() throws IOException, JXLException, InterruptedException
	{//page 1
		Locatorcreator locc = new Locatorcreator();
		Createlocators cret = new Createlocators();
		Xlprocessing xlsp = new Xlprocessing();
		Tagnames=xlsp.xlsreader("X:/Tagname.xls","Locators");
		xlsp.writelocatorxls(Tagnames,"X:/Newxpath12.xls","Tagnames");
		driver = locc.driverlauncher();	
		cret.ByTagxpathcreate(driver,Tagnames);
		xlsp.writelocatorxls(cret.relxpath,"X:/Newxpath12.xls","Loginpage");
		xpathlocator=xlsp.getxpathByIndex("X:/xpathinproject.xls","Locators",driver,"index_10");
		System.out.println(xpathlocator);
		driver.findElement(By.xpath(xpathlocator)).sendKeys("y8x0v0v5");
		//Thread.sleep(6000);
		driver.findElement(By.xpath(xpathlocator)).sendKeys(Keys.ENTER);
		cret.ByTagxpathcreate(driver,Tagnames);
		xlsp.writelocatorxls(cret.relxpath,"X:/Newxpath12.xls","Loginpage");
		
		xpathlocator=xlsp.getxpathByIndex("X:/xpathinproject.xls","Locators",driver,"index_209");
		
		driver.findElement(By.xpath(xpathlocator)).sendKeys("Basket0002");
		driver.findElement(By.xpath(xpathlocator)).sendKeys(Keys.ENTER);
		Thread.sleep(6000);
		//page2
		cret.ByTagxpathcreate(driver,Tagnames);
		xlsp.writelocatorxls(cret.relxpath,"X:/Newxpath12.xls","fincacialcenter");
		try{
		xpathlocator=xlsp.getxpathByIndex("X:/xpathinproject.xls","Locators",driver,"index_1228");
		driver.findElement(By.xpath(xpathlocator)).click();
		}catch(Exception e){}
		//cret.ByTagxpathcreate(driver,Tagnames);
		//xlsp.writelocatorxls(cret.relxpath,"X:/Newxpath12.xls","fincacialcenter");
	//	BottomFrame
		driver.switchTo().frame("BottomFrame");
		cret.ByTagxpathcreate(driver,Tagnames);
		xlsp.writelocatorxls(cret.relxpath,"X:/Newxpath12.xls","profilepage");
		driver.quit();
		
	}
	
	
	
	public static void  onlyhappypath() throws IOException, InterruptedException, Exception
	{
		Locatorcreator locc = new Locatorcreator();
		Createlocators cret = new Createlocators();
		Xlprocessing xlsp = new Xlprocessing();
		Tagnames=xlsp.xlsreader("X:/Tagname.xls","Locators");
		driver = locc.driverlauncher();
		try{
		
				
		//cret.ByTagxpathcreate(driver,Tagnames);
		//xlsp.writelocatorxls(cret.relxpath,"X:/createdxpaths.xls");
		
		xpathlocator=xlsp.getxpathByIndex("X:/Newxpath12.xls","Loginpage",driver,"index_5");
		System.out.println(xpathlocator);
		driver.findElement(By.xpath(xpathlocator)).sendKeys("y8x0v0v5");
		String xpath=xlsp.getxpathByIndex("X:/Newxpath12.xls","Loginpage",driver,"index_4");
		System.out.println(driver.findElement(By.xpath(xpathlocator)).isDisplayed());
		driver.findElement(By.xpath(xpathlocator)).sendKeys(Keys.ENTER);
		//Thread.sleep(6000);
		//cret.ByTagxpathcreate(driver,Tagnames);
		//xlsp.writelocatorxls(cret.relxpath,"X:/createdxpaths.xls");
	
		xpathlocator=xlsp.getxpathByIndex("X:/Newxpath12.xls","Loginpage",driver,"index_70");
		
		driver.findElement(By.xpath(xpathlocator)).sendKeys("Basket0002");
		driver.findElement(By.xpath(xpathlocator)).sendKeys(Keys.ENTER);
		//Thread.sleep(6000);
		
		//cret.ByTagxpathcreate(driver,Tagnames);
		//xlsp.writelocatorxls(cret.relxpath,"X:/createdxpaths.xls");
		
		xpathlocator=xlsp.getxpathByIndex("X:/Newxpath12.xls","fincacialcenter",driver,"index_26");
		driver.findElement(By.xpath(xpathlocator)).click();
		
		
		driver.switchTo().frame("BottomFrame");
		//cret.ByTagxpathcreate(driver,Tagnames);
		//xlsp.writelocatorxls(cret.relxpath,"X:/Newxpath12.xls","profilepage");
		xpathlocator=xlsp.getxpathByIndex("X:/Newxpath12.xls","profilepage",driver,"index_68");
		driver.findElement(By.xpath(xpathlocator)).click();
		//cret.ByTagxpathcreate(driver,Tagnames);
		//xlsp.writelocatorxls(cret.relxpath,"X:/Newxpath12.xls","Passwordpage");
		//index_46
		xpathlocator=xlsp.getxpathByIndex("X:/Newxpath12.xls","Passwordpage",driver,"index_2");
		driver.findElement(By.xpath(xpathlocator)).sendKeys("OldPass");
		
		xpathlocator=xlsp.getxpathByIndex("X:/Newxpath12.xls","Passwordpage",driver,"index_5");
		driver.findElement(By.xpath(xpathlocator)).sendKeys("NewPass");
		Thread.sleep(5000);
		driver.quit();
		}catch(Exception e)
		{	xlsp.recoverxpath();
			System.out.println("Test Case is failed");
			//driver.quit();
		}
	}


}
