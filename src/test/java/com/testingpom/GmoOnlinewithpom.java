package com.testingpom;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.POM.GmoOnlinePom;
import com.utility.Library;
import com.utility.constants;

public class GmoOnlinewithpom extends Library {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated methotub
		ReadPropartiesFile();
		//driver = new ChromeDriver();
		//driver.get("https://demo.borland.com/gmopost/");
		driver.manage().window().maximize();
		GmoOnlinePom objGmoOnlinePom=new GmoOnlinePom(driver);
		objGmoOnlinePom.EnterGMOOnLine.click();
		//driver.findElement(By.name("bSubmit")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(constants.ImplicitWaitTimeOut));
		objGmoOnlinePom.PaddedSocks.sendKeys("3");
		//driver.findElement(By.name("QTY_SOCKS")).sendKeys("3");
		Thread.sleep(3000);
		//driver.findElement(By.name("bSubmit")).click();
		objGmoOnlinePom.PlaceAnOrder.click();
		String TitleOfPage = driver.getTitle();
		Assert.assertEquals(TitleOfPage, "Place Order");
		String unitPricefromapp = objGmoOnlinePom.UnitPricefromapp.getText();
		System.out.println("unitPricefromapp" + unitPricefromapp);
		String UnitPriceWithOutDoller = unitPricefromapp.substring(2);
		System.out.println("UnitPriceWithOutDoller" + UnitPriceWithOutDoller);
		float UnitValueInInt = Float.parseFloat(UnitPriceWithOutDoller);
		float CalculatedValuePrice = UnitValueInInt * 3;
		System.out.println("CalculatedValuePrice" + CalculatedValuePrice);

		
		String TotaltPricefromapp = objGmoOnlinePom.Totalpricefromapp.getText();
		System.out.println("TotaltPricefromapp" + TotaltPricefromapp);
		String TotalPriceWithOutDoller = TotaltPricefromapp.substring(2);
		System.out.println("TotalPriceWithOutDoller" + TotalPriceWithOutDoller);
		float totalcalculatedValue = Float.parseFloat(TotalPriceWithOutDoller);
		System.out.println("totalcalculatedValue" + totalcalculatedValue);
		
		Assert.assertEquals(CalculatedValuePrice, totalcalculatedValue);
		
	}

}
