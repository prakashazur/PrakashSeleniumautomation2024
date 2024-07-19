package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Library {
	public static WebDriver driver;
	public static Properties objprop;

	public static void ReadPropartiesFile() throws IOException {
		try {
			File objfile = new File(System.getProperty("user.dir") + "//src//test/resources//Config.PropertiesFile");
			FileInputStream objinputfile = new FileInputStream(objfile);
			 objprop = new Properties();
			objprop.load(objinputfile);
			System.out.println(objprop.getProperty("browser"));
			System.out.println(objprop.getProperty("GmoOnLineAppURL"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void LaunchBrowser() {
		String browserFromPropFile = objprop.getProperty("browser");
		switch (browserFromPropFile.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "ie":
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.print("Please provide broswer name");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(constants.ImplicitWaitTimeOut));
	
	}
}
