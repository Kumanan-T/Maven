package com.pageobjecmanager;

import com.baseclass.BaseClass;
import com.pageobjectmodel.AdactinBooknowPage;
import com.pageobjectmodel.AdactinLoginPag;
import com.pageobjectmodel.AdactinSearchPage;
import com.srcmainresources.FileReaderManager;

public class PageObjectManager extends BaseClass{

	private AdactinLoginPag loginPage;
	private FileReaderManager fileReader;
	private AdactinSearchPage searchPage;
	private AdactinBooknowPage bookPage;
	
	public AdactinLoginPag getLoginPage() {
		if(loginPage== null) {
			loginPage= new AdactinLoginPag(driver);
		}
		
		return loginPage;
	} 	
	public FileReaderManager getFileReader() {
		if (fileReader== null) {
			fileReader= new FileReaderManager();
		}
		
		return fileReader;
		
		
		
	}
	public AdactinSearchPage getSearchPage() {
		if(searchPage== null) {
			searchPage=new AdactinSearchPage(driver);
		}
		return searchPage;
	}
	public AdactinBooknowPage getBookPage() {
		if(bookPage==null) {
			
			bookPage=new AdactinBooknowPage(driver);
		}
		return bookPage;
	}
	
}
