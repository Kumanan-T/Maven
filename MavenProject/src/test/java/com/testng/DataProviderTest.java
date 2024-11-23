package com.testng;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;

public class DataProviderTest extends BaseClass {

	@Test(dataProvider = "login")
	public  void login(String username,String password) {

		launchBrowser("chrome");
		launchUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		implicitWait(30);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		terminatebrow();
	
	}

	@DataProvider(name="login")
	public Object[][] dataset() {
			return new Object[][]
	{{"Admin","admin123"},{"Abc","123"},{"Admin","1234"},{" "," "}};	
	
	}


}
