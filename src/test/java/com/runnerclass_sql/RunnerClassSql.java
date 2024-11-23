package com.runnerclass_sql;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.JdbcConnector;
import com.utility.JdbcConnector2;

public class RunnerClassSql {
	
	public static void main(String[] args) throws SQLException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.youtube.com/");
	String value = JdbcConnector2.getParticularData();
	driver.findElement(By.name("search_query")).sendKeys(value);
	
	}

}
