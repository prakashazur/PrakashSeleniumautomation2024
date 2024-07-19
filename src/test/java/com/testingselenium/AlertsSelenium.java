package com.testingselenium;

import org.testng.annotations.Test;

import com.POM.AleartsPOM;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AlertsSelenium extends Library{
  @Test(priority=0)
  public void ValidatingAlerts() {
	driver.get(objprop.getProperty("AlertsURL"));
	String Title=driver.getTitle();
	Assert.assertEquals(Title, objprop.getProperty("UrlTitlepage"));
	
  }
  @Test(priority=1 ,dependsOnMethods= {"ValidatingAlerts"} )
	 public void Validatechesse() throws Exception  {
		 System.out.println("inside Validatechesse");
		 AleartsPOM objaleart=new AleartsPOM(driver);
		 objaleart.clickme.click();
		 Alert objAlert= driver.switchTo().alert();
		  Thread.sleep(3000);
		  String titlealerttext=objAlert.getText();
		  Thread.sleep(3000);
		  Assert.assertEquals(titlealerttext, objprop.getProperty("AlertText"));
		  objAlert.accept();
		  Thread.sleep(3000);
  }
		
		  @Test(priority=2 ,dependsOnMethods= {"ValidatingAlerts", "Validatechesse"})
		  public void ValidateEmptytext() throws InterruptedException {
			  System.out.println("inside ValidateEmptytext");
			  AleartsPOM objaleart=new AleartsPOM(driver);
			  objaleart.click.click();
			  Alert objAlert= driver.switchTo().alert();
			  Thread.sleep(3000);
			  String titlealerttext=objAlert.getText();
			  Thread.sleep(3000);
			  Assert.assertEquals(titlealerttext, objprop.getProperty("EmptyText"));
			  objAlert.accept();
			  
			  
			  
		  }
		  @Test(priority=3,dependsOnMethods= {"ValidatingAlerts", "Validatechesse","ValidateEmptytext"})
		  public void validatepromt() throws InterruptedException {
			  System.out.println("validatepromt");
			  AleartsPOM objaleart=new AleartsPOM(driver);
			  objaleart.promptkey.click();
			  Alert objAlert= driver.switchTo().alert();
			  Thread.sleep(3000);
			  String titlealerttext=objAlert.getText();
			  Thread.sleep(3000);
			  objAlert.sendKeys(objprop.getProperty("TextOfToEnter"));
			  Thread.sleep(3000);
			  Assert.assertEquals(titlealerttext, objprop.getProperty("PromptText"));
			  objAlert.accept();
			  
					 
		  }
		  
		  @Test(priority=3,dependsOnMethods= {"ValidatingAlerts", "Validatechesse","ValidateEmptytext","validatepromt"})
		  public void validatepromtwithdefault() throws InterruptedException {
			  System.out.println("validatepromtwithdefault");
			  AleartsPOM objaleart=new AleartsPOM(driver);
			  objaleart.promptkeywithdefault.click();
			  Alert objAlert= driver.switchTo().alert();
			  Thread.sleep(3000);
			  String titlealerttext=objAlert.getText();
			  Thread.sleep(3000);
			  objAlert.sendKeys(objprop.getProperty("EnterTextOfPromptWithDefault"));
			  Thread.sleep(3000);
			  Assert.assertEquals(titlealerttext, objprop.getProperty("TextOfPromptWithDefault"));
			  objAlert.dismiss();
		  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  LaunchBrowser();
  }

  @AfterTest
  public void afterTest() {
	  
  }

  @BeforeSuite
  public void beforeSuite() throws IOException {
	  ReadPropartiesFile();
	  
  }

  @AfterSuite
  public void afterSuite() {
  }

}
