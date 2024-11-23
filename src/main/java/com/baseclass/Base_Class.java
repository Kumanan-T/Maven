package com.baseclass;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.module.ModuleDescriptor.Exports;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.devtools.v115.io.IO;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public abstract class Base_Class {
	public static WebDriver driver;
	
	public static ExtentReports extentReports;

	public static File file;
	
	protected static WebDriver launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
		} catch (Exception e) {
			Assert.fail("Error: OCCUR DURING BROWSER LAUNCH");
		}
		driver.manage().window().maximize();
		return driver;
	}

	protected static WebDriver launchurl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("Error: OCCUR DURING URL LAUNCH");
		}
		return driver;
	}

	protected static void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("Error: OCCUR DURING CLOSING THE BROWSER");
		}
	}

	protected static void terminateBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("Error: OCCUR DURING BROWSER QUIT");
		}
	}

	protected static void passInput(WebElement element, String input) {
		try {
			element.sendKeys(input);
		} catch (Exception e) {
			Assert.fail("Error: OCCUR DURING VALUE PASSING");
		}
	}

	protected static void navigationPage(String url ) {
		try {
			driver.navigate().to(url);	
		}catch (Exception e) {
			Assert.fail("Error: OCCUR DURING VALUE PASSING");
		}
	}
	protected static void elementClick(WebElement element ) {
		try {
			element.click();;	
		}catch (Exception e) {
			Assert.fail("Error: OCCUR DURING ELEMENT CLICK");
		}
	}
	protected static Select dropDownObject(WebElement element ) {
		Select select  = new Select(element);
		return select;
		}
	protected static void selectByVisibletext(WebElement element, String text ) {
		try {
			dropDownObject(element).selectByVisibleText(text);	
		}catch (Exception e) {
			Assert.fail("Error: OCCUR DURING SELECT BY TEXT");
		}
	}
	protected static void selectByIndex(WebElement element, int num ) {
		try {
			dropDownObject(element).selectByIndex(num);	
		}catch (Exception e) {
			Assert.fail("Error: OCCUR DURING SELECT BY INDEX");
		}
	}
	protected static void windowHandles(int num ) {
		try {
			List<String> allWindow = new ArrayList (driver.getWindowHandles());
			driver.switchTo().window(allWindow.get(num));
		}catch (Exception e) {
			Assert.fail("Error: OCCUR DURING WINDOW HANDELS");
		}
	}
	protected static void clearValue(WebElement element) {
		element.clear();
	}
	//protected static void takeScreenshot(String filepath){
	//TakesScreenshot screenshot = (TakesScreenshot) driver;
	//try {
	//File source = screenshot.getScreenshotAs(OutputType.FILE);
	//File destination = new File(filepath);
	//	FileHandler.copy(source,destination);
	//}catch (Exception e) {
	//	Assert.fail("ERROR: OCCUR DURING TAKING SCREENSHOT");
	//	}
	//}
				
		protected static void explicitwaitClickable(WebElement element, int seconds) {
			try {	
				WebDriverWait Wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
				Wait.until(ExpectedConditions.elementToBeClickable(element));
			}catch (Exception e) {
			Assert.fail("ERROR: PAGE IS NOT LOADING IN A GIVEN SECONDS");
			}
			
		}

		protected void scrolldown() {
			try {
				JavascriptExecutor js= (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0, 3000)");
			}catch (Exception e) {
				Assert.fail("ERROR: OCCURE DURING PAGE SCROLL DOWN");
			}
			
		}
			
		protected static void selectedByValue(WebElement element, String value) {
			try {
				dropDownObject (element).selectByValue(value);
				}catch (Exception e) {
				Assert.fail("ERROR: OCCURED DURING SELECTING VALUE");
				}
		}
		
		
		
		public static void extentReportStart (String location){
			extentReports = new ExtentReports();
			file = new File (location);
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
			extentReports.attachReporter(sparkReporter);
			extentReports.setSystemInfo("os", System.getProperty("os.name"));
			extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		}
		
		public static void extentReportTearDown(String location) throws IOException{
			extentReports.flush();
			file = new File(location);
			Desktop.getDesktop().browse((file).toURI());
		}
		
		
		public String takeScreenshot() throws IOException {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format (new Date());
			File scrfile = screenshot.getScreenshotAs(OutputType.FILE);
			File destfile = new File("Screenshot\\.png"  + "_"+ timeStamp + ".png");
			FileUtils.copyFile(scrfile, destfile);
			return destfile.getAbsolutePath();
		}
}
	
	
