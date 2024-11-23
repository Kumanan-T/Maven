package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
import com.interfaceelements.AdactinApplicationElements;
import com.srcmainresources.FileReaderManager;

public class AdactinBooknowPage extends BaseClass implements AdactinApplicationElements{

	@FindBy(id= firstname_id)
	private WebElement firstname;
	
	@FindBy(id=lastname_id)
	private WebElement lastname;
	
	@FindBy(id=address_id)
	private WebElement address;
	
	@FindBy(id=ccno_id)
	private WebElement ccnumber;
	
	@FindBy(id=cctype_id)
	private WebElement cctype;
	
	@FindBy(id=month_id)
	private WebElement selectmonth;
	
	@FindBy(id=year_id)
	private WebElement select_year;
	
	@FindBy(id=cvvno_id)
	private WebElement cvvnumber;
	
	@FindBy(id=book_id)
	private WebElement booknow;
	
	@FindBy(id=logout_xpath)
	private WebElement logout;
	
	public AdactinBooknowPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	
	}
	
	public  void bookHotel() throws IOException {

		FileReaderManager book= new FileReaderManager();
		passInput(firstname, book.getDataProperty("firstname"));
		passInput(lastname, book.getDataProperty("lastname"));
		passInput(address, book.getDataProperty("address"));
		passInput(ccnumber, book.getDataProperty("creditno"));
		selectByVisibiletext(cctype,book.getDataProperty("credittype"));
		selectByVisibiletext(selectmonth, book.getDataProperty("month"));
		selectByVisibiletext(select_year, book.getDataProperty("year"));
		passInput(cvvnumber, book.getDataProperty("cvv"));
		elementClic(booknow);
		explicitWait(booknow,30);
		scrolldown();
		takeScreenshot();
		elementClic(logout);
		explicitWait(logout,30);
	}
	
}
