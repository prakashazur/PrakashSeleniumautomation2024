package com.testingselenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.utility.Library;

public class GmoOnline extends Library {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated methotub
		driver = new ChromeDriver();
		driver.get("https://demo.borland.com/gmopost/");
		driver.manage().window().maximize();
		driver.findElement(By.name("bSubmit")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("QTY_SOCKS")).sendKeys("3");
		Thread.sleep(3000);
		driver.findElement(By.name("bSubmit")).click();
		String TitleOfPage = driver.getTitle();
		Assert.assertEquals(TitleOfPage, "Place Order");
		String unitPricefromapp = driver.findElement(By.xpath("//tbody/tr[2]/td[4]")).getText();
		System.out.println("unitPricefromapp" + unitPricefromapp);
		String UnitPriceWithOutDoller = unitPricefromapp.substring(2);
		System.out.println("UnitPriceWithOutDoller" + UnitPriceWithOutDoller);
		float UnitValueInInt = Float.parseFloat(UnitPriceWithOutDoller);
		float CalculatedValuePrice = UnitValueInInt * 3;
		System.out.println("CalculatedValuePrice" + CalculatedValuePrice);

		
		String TotaltPricefromapp = driver.findElement(By.xpath("//tbody/tr[2]/td[5]")).getText();
		System.out.println("TotaltPricefromapp" + TotaltPricefromapp);
		String TotalPriceWithOutDoller = TotaltPricefromapp.substring(2);
		System.out.println("TotalPriceWithOutDoller" + TotalPriceWithOutDoller);
		float totalcalculatedValue = Float.parseFloat(TotalPriceWithOutDoller);
		System.out.println("totalcalculatedValue" + totalcalculatedValue);
		
		Assert.assertEquals(CalculatedValuePrice, totalcalculatedValue);
		
	}

}
