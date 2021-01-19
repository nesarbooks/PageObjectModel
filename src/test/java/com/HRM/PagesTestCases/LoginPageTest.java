package com.HRM.PagesTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HRM.Pages.HomePage;
import com.HRM.Pages.LoginPage;
import com.HRM.base.TestBase;

public class LoginPageTest extends TestBase {
LoginPage loginpage;
HomePage homepage;

	//constructor of loginpagetest
	
	public LoginPageTest () {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		
	}
	
	@Test (priority=1) 
	public void loginPageTitleTest() {
		String title =loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test (priority=2)
	public void hrmLogoTest() {
		boolean logo = loginpage.validateHRMlogo();
		Assert.assertTrue(logo);
		
	}
	
	@Test (priority=3)
	public void loginTest () {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod 
	public void tearDown() {
		driver.quit();
	}
	
	
}
