package com.HRM.PagesTestCases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.Pages.HomePage;
import com.HRM.Pages.LoginPage;
import com.HRM.Pages.MyInfoPage;
import com.HRM.Utility.TestUtil;
import com.HRM.base.TestBase;

public class MyInfoPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	MyInfoPage myinfopage;
	
	String sheetName= "personalDetails";
	
	
	public MyInfoPageTest () {
		super ();
		}
	
	
	@BeforeMethod 
	public void setUp() {
		initialization();
		myinfopage = new MyInfoPage();
		loginpage = new LoginPage();
		homepage = new HomePage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickOnMyInfo();
		
		
	}
	
	
	@Test (priority=1)
	public void verifyPersonalDetailsLabel () {
		
		Assert.assertTrue(myinfopage.verifyPersonalDetails(), "Personal Details label is not displayed");
	}
	
	@DataProvider 
	public Object [][] getHRMTestData () throws InvalidFormatException {
	Object data [][]=TestUtil.getTestData(sheetName);
	return data;
		
	}
	
	@Test (priority=2, dataProvider="getHRMTestData")
	public void editPersonalDetails(String firstname, String lastname, String emplid, String driverlic, String ssn, String maritalstatus, String nationality) {
	//	myinfopage.EditDetails(prop.getProperty("ssn");
		myinfopage.EditDetails(firstname, lastname, emplid, driverlic, ssn, maritalstatus, nationality);
	}
	
	@Test (priority=3)
	public void clickOnJobTab () { 
		myinfopage.JobTab();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
