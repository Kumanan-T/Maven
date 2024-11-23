package com.runner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;
import com.listeners.ExtentReport_Test;
import com.listeners.ITestListenerClass;
import com.pageobjecmanager.OpenMrsPageObjectManager;
import com.pageobjecmanager.PageObjectManager;

@Listeners(ITestListenerClass.class)
public class OpenMrsRunner extends BaseClass {

	//OpenMrsPageObjectManager pageObjectManager = new OpenMrsPageObjectManager();
	OpenMrsPageObjectManager pageobjman=new OpenMrsPageObjectManager();
	
	@BeforeMethod
	public void setUp() throws IOException {
		launchBrowser(pageobjman.getFileReader().getDataProperty("browser"));
	}
	
	@Test
	public void validLogin() throws Throwable {

		ExtentReport_Test.extenttest=extentReports.createTest("Login Test"+ " "+ Thread.currentThread().getStackTrace()[1]
				.getMethodName().toString()).info("ValidLogin");
		Assert.assertTrue(pageobjman.getLoginPage().validLogin(ExtentReport_Test.extenttest));
		
	
	}
	
	
	
	/*@Test(dependsOnMethods = "withoutLocationTest")
	private void validLoginTest() {
		Assert.assertTrue(pageObjectManager.getLoginPage().validLogin());
	}

	@Test
	public void validUserAndInvalidPass() {
		Assert.assertTrue(pageObjectManager.getLoginPage().LoginWithValidUserNameAndInvalidPassword());
	}

	@Test(dependsOnMethods = "validUserAndInvalidPass")
	private void invalidUserAndValidPass() {
		Assert.assertTrue(pageObjectManager.getLoginPage().loginWithInvalidUsernameAndValidPassword());
	}
	
	@Test(dependsOnMethods = "invalidUserAndValidPass")
	private void invalidUserAndInvalidPass() {
		Assert.assertTrue(pageObjectManager.getLoginPage().loginWithInvalidUsernameAndInvalidPassword());
	}
	
	@Test(dependsOnMethods = "invalidUserAndInvalidPass")
	private void withoutLocationTest() {
		Assert.assertTrue(pageObjectManager.getLoginPage().withOutLocation());*/
	
	@AfterTest
	private void termination() {
		terminatebrow();
	}
	
	@BeforeSuite
	private void extendReportStartUp() {

		extentReportStart("F:\\eclipse workspace 24\\MavenProject\\Reports");
	}
	
	@AfterSuite
	private void extentReportEnd() throws IOException {

		extentReportTearDown("F:\\eclipse workspace 24\\MavenProject\\Reports\\index.html");
	}
}
