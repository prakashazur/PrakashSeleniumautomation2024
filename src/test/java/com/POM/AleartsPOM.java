package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Library;

public class AleartsPOM extends Library {
	public AleartsPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	 @FindBy(id="alert")
	  public WebElement clickme;
	 
	 @FindBy(id="empty-alert")
	  public WebElement click;
	 
	  @FindBy(id="prompt")
	  public WebElement promptkey;

	  @FindBy(id="prompt-with-default")
	  public WebElement promptkeywithdefault;
}
