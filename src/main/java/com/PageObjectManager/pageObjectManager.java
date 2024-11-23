package com.PageObjectManager;
import com.baseclass.Base_Class;
import com.pageobjectmodel.AdactinBookHotel;
import com.pageobjectmodel.Adactinloginpage;
import com.pageobjectmodel.SearchPage;
import com.srcmainresources.FileReaderManager;


public class pageObjectManager extends Base_Class {
    
	
	private Adactinloginpage loginPage;
	private FileReaderManager fileReader;
    private SearchPage searchPage;
	private AdactinBookHotel bookHotelPage;

	public Adactinloginpage getLoginPage() {
		if(loginPage == null) {
			loginPage = new Adactinloginpage(driver);
		}
		return loginPage;
	}

	public FileReaderManager getFileReader() {
		if(fileReader == null) {
			fileReader = new FileReaderManager();
		}
		return fileReader;
	}	
	public SearchPage getSearchPage() {
		if(searchPage == null) {
		searchPage = new SearchPage(driver);
		}
		return searchPage;
		}
	public AdactinBookHotel getBookHotelPage() {
		if(bookHotelPage ==null) {
			bookHotelPage = new AdactinBookHotel(driver);
		}
	    return bookHotelPage;
	}
}
