package com.HRM.PagesTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HRM.Pages.HomePage;
import com.HRM.Pages.LoginPage;
import com.HRM.base.TestBase;



public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	
	public HomePageTest () {
		super ();
	}
	
 // test cases should be separated -- independent from each other 
 // launch the browser and login before each test case. 
	//@Test -- executes test cases AND after each test case, close the browser 
	
	@BeforeMethod 
	public void setUp() {
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority=1)
	public void verifyHomePageTitle () {
		String homepagetitle=homepage.verifyHomePageTitle();
		System.out.println(homepagetitle);
		Assert.assertEquals(homepagetitle, "OrangeHRM", "Home Page Title not matched");
	}
	
	@Test (priority =2)
	public void verifyUserName () {
		Assert.assertTrue (homepage.UserVerification());
	}
	
	@Test (priority=3)
	public void verifyMyInfoLink() {
		homepage.clickOnMyInfo();
	}
	
	@AfterMethod 
	public void tearDown() {
		driver.quit();
	}

	
}
