package com.HRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;

public class LoginPage extends TestBase  {

	//PageFactory
	
	@FindBy(name="txtUsername")
	WebElement username;
	
	@FindBy (name="txtPassword")
	WebElement password;
	
	@FindBy (name="Submit")
	WebElement loginbtn;
	
	@FindBy (xpath="//body/div[@id='wrapper']/div[@id='content']/div[@id='divLogin']/div[@id='divLogo']/img[1]")
	WebElement hrmlogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Initializing the Page Objects:
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateHRMlogo() {
		return hrmlogo.isDisplayed();
	}
	
	public HomePage login (String usnm, String pswd) {
		username.sendKeys(usnm);
		password.sendKeys(pswd);
		loginbtn.click();
		
		return new HomePage();
		
	}
}
