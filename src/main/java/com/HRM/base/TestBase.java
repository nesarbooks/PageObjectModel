package com.HRM.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.HRM.Utility.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase () {
		try {
			prop = new Properties ();
			FileInputStream ip = new FileInputStream ("C:\\Users\\Yoga\\eclipse-workspace\\POMDemo\\src\\main\\java\\com\\HRM\\configuration\\config.properties");
				prop.load(ip);	
		} 
		catch (FileNotFoundException e ) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization () {
		String browserName=prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Yoga\\Desktop\\Drivers&Jars\\Browser drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Yoga\\Desktop\\Drivers&Jars\\Browser drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
		
	}

}
