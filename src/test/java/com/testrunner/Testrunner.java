package com.testrunner;

import java.io.IOException;

import com.PageObjectManager.pageObjectManager;
import com.baseclass.Base_Class;

public class Testrunner extends Base_Class {
	public static void main(String[] args) throws IOException, InterruptedException {
		
pageObjectManager pom = new pageObjectManager();
//Login testing
launchBrowser(pom.getFileReader().getDataProperty("browser"));
launchurl(pom.getFileReader().getDataProperty("url"));
pom.getLoginPage().validateUserNameAndValidPassword();

//search hotel
pom.getSearchPage().SearchPage();

//book hotel
pom.getBookHotelPage().bookHotel();
	}
	}
