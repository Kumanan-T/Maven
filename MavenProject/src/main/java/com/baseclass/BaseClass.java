package com.baseclass;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class BaseClass {

	public static WebDriver driver;
	
	public static ExtentReports extentReports;
	
	public static File file;

	protected static WebDriver launchBrowser(String browsername) {

	//	try {
			if (browsername.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browsername.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browsername.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
//		} catch (Exception e) {
//			Assert.fail("ERROR OCCUR  DURING BROWSER LAUNCH");
//		}
		driver.manage().window().maximize();
		return driver;
	}

	protected static WebDriver launchUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR DURING URL LAUNCH");

		}
		return driver;
	}

	protected static WebDriver closeBrow() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("ERROR DURING BROWSER CLOSE");
		}
		return driver;

	}

	protected static WebDriver terminatebrow() {

		try {
			driver.quit();

		} catch (Exception e) {
			Assert.fail("ERROR DURING QUITING BROWSER");
		}
		return driver;
	}

	protected static WebDriver passInput(WebElement el, String str) {
		try {
			el.sendKeys(str);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING PASSING VALUES");
		}
		return driver;
	}

	protected static WebDriver navigatePage(String url) {
		try {
			driver.navigate().to(url);

		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING NAVIGATE TO URL");
		}
		return driver;

	}

	protected static WebDriver elementClic(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING ELEMENT CLICK");
		}
		return driver;
	}

	protected static Select dropdown(WebElement element) {
		Select s = new Select(element);
		return s;

	}

	protected static void selectByVisibiletext(WebElement element, String text) {

		try {
			dropdown(element).selectByVisibleText(text);

		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING SELECT BY VISIBLE TEXT");
		}
	}

	protected static void selectByIndex(WebElement element, int num) {
		try {
			dropdown(element).selectByIndex(num);

		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING SELECT BY INDEX");
		}
	}

	protected static void windowHandles(int num) {
		try {
			List<String> allWindow = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(allWindow.get(num));

		} catch (Exception e) {
			Assert.fail("ERROR : OCCUR DURING WINDOW HANDLES");
		}
	}

	protected static void clearValue(WebElement element) {
		element.clear();
	}

	protected static void takeScreenshot() throws IOException {

		// try {
		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File des = new File("F:\\eclipse workspace 24\\MavenProject\\screenshots\\book.png");
		FileHandler.copy(src, des);

//		} catch (Exception e) {
//			Assert.fail("ERROR : OCCUR DURING TAKING SCREENSHOT");
//		}

	}

	public void scrolldown() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,3000)");
		} catch (Exception e) {
			Assert.fail("ERROR: DURING SCROLL DOWN");
		}
	}
	
	protected static void implicitWait(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		} catch (Exception e) {
		Assert.fail("ERROR: PAGE IS NOT LOADING IN GIVEN SECONDS");
			}
		
		
	}

	protected static void explicitWait(WebElement element, int sec) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			Assert.fail("ERROR: PAGE IS NOT LOADING IN GIVEN SECONDS");
		}
	}

	protected static void validation(String actual, String expected) {

		try {

			Assert.assertEquals(actual, expected);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCUR DURING VALIDATION");
		}
	}
	
	public static  void extentReportStart(String location) {

		try {
			extentReports= new ExtentReports();
			file= new File(location);
			ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
			extentReports.attachReporter(sparkReporter);
			extentReports.setSystemInfo("OS",System.getProperty("os.name"));
			extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		} catch (Exception e) {
			
			Assert.fail("ERROR DURING EXTENT REPORT starting ");
		}
	
	}
		public void extentReportTearDown(String location) {

			try {
				extentReports.flush();
				file= new File(location);
				Desktop.getDesktop().browse((file).toURI());
			} catch (IOException e) {
				Assert.fail("ERROR DURING Extent Report tear down creation");
			}
	}
	
		public  String getScreensho() {

			try {
				TakesScreenshot screenshot= (TakesScreenshot) driver;
				String timeStamp= new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
				File srcfile= screenshot.getScreenshotAs(OutputType.FILE);
				File destfile= new File("Screenshot\\.png"+"_"+timeStamp+".png");
				FileUtils.copyFile(srcfile, destfile);
				return destfile.getAbsolutePath();
			} catch (Exception e) {
				Assert.fail("ERROR DURING TAKING SCREENSHOT");
			}
			return null;
					
		}
	}	

	
	


