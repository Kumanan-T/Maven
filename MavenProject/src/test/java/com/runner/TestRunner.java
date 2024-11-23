package com.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;

public class TestRunner extends BaseClass {

	public static void main(String[] args) {
		
		launchBrowser("chrome");
		launchUrl("https://www.google.com/");
		WebElement el = driver.findElement(By.name("q"));
		passInput(el, "Fruits");
		takeScreenshot("F:\\eclipse workspace 24\\MavenProject\\screenshots\\new.png");
		terminatebrow();
		
		
		
	}
}
