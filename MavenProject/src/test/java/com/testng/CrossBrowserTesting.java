package com.testng;

import org.testng.annotations.Test;

import com.baseclass.BaseClass;

public class CrossBrowserTesting extends BaseClass  {

	@Test(priority = 5)
	private void edgeBrowser() {
		
		launchBrowser("edge");
		launchUrl("https://www.google.com/");
		System.out.println("Browser ID:"+ Thread.currentThread().getId());
		System.out.println("edge brow");
		terminatebrow();
		}

	@Test(priority = 2)
	private void chromeBrowser() {

		launchBrowser("chrome");
		launchUrl("https://www.google.com/");
		System.out.println("Browser ID:"+ Thread.currentThread().getId());
		System.out.println("chrome brow");
		terminatebrow();
	}

	@Test(priority = -5)
	private void firefoxBrowser() {
		launchBrowser("firefox");
		launchUrl("https://www.google.com/");
		System.out.println("Browser ID:"+ Thread.currentThread().getId());
		System.out.println("firefox brow");
		terminatebrow();
		
	}



}
