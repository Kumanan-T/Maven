package com.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleAnnotations {

	@BeforeSuite
	private void propertySetting() {
		System.out.println("PropertySetting");
	}
	
	@BeforeTest
	private void browserLaunch() {
		System.out.println("Browser Launching");

	}
	@BeforeClass
	private void urlLaunch() {

		System.out.println("Url Launching");
	}
	
	@BeforeMethod
	private void login() {

		System.out.println("Login");
	}
	
	@Test(priority = 5)
	private void shirts() {

		System.out.println("Shirts");
	}
	
	@Test(priority = 2)
	private void pants() {
		System.out.println("Pants");
	}
	
	@Test(priority = -5)
	private void kids() {
		System.out.println("Kids");
	}
		
	@AfterMethod
	private void logout() {
		 System.out.println("Logout");
	}
	
	@AfterClass
	private void screenshot() {
		System.out.println("screenshot");
	}
	
	@AfterTest
	private void closeBrowser() {

		System.out.println("Close browser");
	}
	
	@AfterSuite
	private void terminatebrowser() {

		System.out.println("Terminate broser");
	}
}
