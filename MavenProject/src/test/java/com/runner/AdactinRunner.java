package com.runner;

import java.io.IOException;

import com.baseclass.BaseClass;
import com.pageobjecmanager.PageObjectManager;

public class AdactinRunner extends BaseClass{
public static void main(String[] args) throws IOException {
	
	PageObjectManager pageObjectManager= new PageObjectManager();
	
	launchBrowser(pageObjectManager.getFileReader().getDataProperty("browser"));
	launchUrl(pageObjectManager.getFileReader().getDataProperty("url"));
	
	pageObjectManager.getLoginPage().validUserAndvalidPassword();
	
	pageObjectManager.getSearchPage().searchHotel();
	pageObjectManager.getBookPage().bookHotel();
}

}
