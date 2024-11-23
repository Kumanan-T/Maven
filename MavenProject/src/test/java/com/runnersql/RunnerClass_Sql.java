package com.runnersql;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utitlity.JDBC_Connector;
import com.utitlity.ReadExcelData;

public class RunnerClass_Sql {
public static void main(String[] args) throws InvalidFormatException, IOException   {
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	//driver.get("https://www.youtube.com/");
	driver.get("https://www.facebook.com/");
	
	//String value = JDBC_Connector.getParticularData();
	String username = ReadExcelData.readParticularCellData("Sheet1",3,0);
	driver.findElement(By.id("email")).sendKeys(username);
	
	String pass = ReadExcelData.readParticularCellData("Sheet1",3,1);
	driver.findElement(By.id("pass")).sendKeys(pass);
	
}
}
