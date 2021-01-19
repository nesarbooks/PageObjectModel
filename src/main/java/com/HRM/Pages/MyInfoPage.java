package com.HRM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.HRM.base.TestBase;

public class MyInfoPage extends TestBase {

	@FindBy (xpath="//h1[contains(text(), 'Personal Details')]")
	WebElement persDetails;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement edit;
	
	@FindBy (id="personal_txtEmpFirstName")
	WebElement ftname;
	
	@FindBy (id="personal_txtEmpLastName")
	WebElement ltname;
	
	@FindBy (id="personal_txtEmployeeId")
	WebElement empid;
	
	@FindBy (id="personal_txtLicenNo")
	WebElement driverlicnum;
	
	@FindBy (id="personal_optGender_2")
	WebElement genderfemale;
	
	@FindBy (xpath="//input[@id='personal_txtNICNo']")
	WebElement ssnum;
	
	@FindBy (id="personal_cmbNation")
	WebElement natlty;
	
	@FindBy (id="personal_cmbMarital")
	WebElement maristatus;
	
	
	@FindBy (xpath="(//a[contains(text(), 'Job')])[4]")
	WebElement jobtab;
	
	public MyInfoPage () {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyPersonalDetails () {
		return persDetails.isDisplayed();
	}
	
	public void EditDetails(String firstname, String lastname, String emplid, String driverlic,
			 String ssn, String maritalstatus, String nationality) {
		
		edit.click();
		ftname.clear();
		ftname.sendKeys(firstname);
		ltname.clear();
		ltname.sendKeys(lastname);
		empid.clear();
		empid.sendKeys(emplid);
		driverlicnum.clear();
		driverlicnum.sendKeys(driverlic);
		
		Select select = new Select (maristatus);
		select.selectByVisibleText(maritalstatus);
		
		genderfemale.click();
		ssnum.clear();
		ssnum.sendKeys(ssn);
		
		Select selectNat = new Select (natlty);
		selectNat.selectByVisibleText(nationality);
		
		edit.click();
		
	}
	
	
	public void JobTab() {
		jobtab.click();
		
	}
}
