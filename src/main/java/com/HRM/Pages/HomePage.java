package com.HRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRM.base.TestBase;

public class HomePage extends TestBase {

	@FindBy (xpath="//a[contains(text(),'Welcome')]")
	WebElement userNameLabel;
	
	@FindBy (xpath="//b[contains(text(),'Recruitment')]")
	WebElement recruit;
	
	@FindBy (xpath="//b[contains(text(),'My Info')]")
	WebElement myinfo;
	
	@FindBy (xpath="//b[contains(text(),'Directory')]")
	WebElement directory;
	
	//Initializing the page objects 
	
	public HomePage () {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean UserVerification () {
	return	userNameLabel.isDisplayed();
	}
	
	public DirectoryPage ClickOnDirectory() {
		directory.click();
		return new DirectoryPage();	
	}
	
	public MyInfoPage clickOnMyInfo () {
		myinfo.click();
		return new MyInfoPage();
		
	}
	public RecruitmentPage clickOnRecruitment() {
		recruit.click();
		return new RecruitmentPage ();
	}
	
	
	
}
