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
	private void PropertySetting() {
		System.out.println("Property setting");
	}
	@BeforeTest
	private void browserLaunch() {
		System.out.println("Browser Launch");
	}
	@BeforeClass
	private void urlLaunch() {
		System.out.println("urlLaunch");
	}
	@BeforeMethod
	private void login() {
		System.out.println("Login");
	}
	@Test
	private void women() {
		System.out.println("Women");
	}
	@Test
	private void men() {
		System.out.println("Men");
	}
	@Test
	private void kids() {
		System.out.println("kids");
	}
	@AfterMethod
	private void logout() {
		System.out.println("logout");
	}
	@AfterClass
	private void screenshot() {
		System.out.println("Screenshot");
	}
	@AfterTest
	private void closeBrowser() {
		System.out.println("closeBrowser");
	}
	@AfterSuite
	private void terminateBrowser() {
		System.out.println("Terminate browser");
	}
}
