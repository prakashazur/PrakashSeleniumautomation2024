package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Library;

public class GmoOnlinePom extends Library {

	public GmoOnlinePom(WebDriver driver) {
		PageFactory.initElements(driver, this);
}
  @FindBy(name="bSubmit")  public WebElement EnterGMOOnLine;
 
  
  @FindBy(name="QTY_SOCKS")
  public WebElement PaddedSocks;
  
  @FindBy(name="bSubmit")
  public WebElement PlaceAnOrder;
 
  @FindBy(xpath="//tbody/tr[2]/td[4]")
  public WebElement UnitPricefromapp;

  @FindBy(xpath="//tbody/tr[2]/td[5]")
  public WebElement Totalpricefromapp;
  
 
}

