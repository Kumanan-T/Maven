package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.Base_Class;
import com.interfaceelements.AdactinApplicationElements;
import com.srcmainresources.FileReaderManager;

public class AdactinBookHotel extends Base_Class implements AdactinApplicationElements{
	@FindBy(id = firstName_id)
	private WebElement firstName;
	
	@FindBy(id = lastName_id)
	private WebElement lastName;
	
	@FindBy(id = billingAddress_id)
	private WebElement addres;
	
	@FindBy(id = credirtCardNo_id)
	private WebElement creditNo;
	
	@FindBy(id = creditCardType_id)
	private WebElement cc_type;
	
	@FindBy(id = selectMonth_id)
	private WebElement cc_exp_month;
	
	@FindBy(id = selectYear_id)
	private WebElement cc_exp_year;
	
	@FindBy(id = cvvNo_id )
	private WebElement cc_cvv;
	
	@FindBy(id = bookNow_id )
	private WebElement book_now;
	
	@FindBy(id = logOut_id )
	private WebElement logout;
	
	public AdactinBookHotel(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	public void bookHotel() throws IOException, InterruptedException {
		FileReaderManager book = new FileReaderManager();
		passInput(firstName, book.getDataProperty("firstName"));
		passInput(lastName, book.getDataProperty("lastName"));
		passInput(addres, book.getDataProperty("address"));
		passInput(creditNo, book.getDataProperty("creditNo"));
		selectByVisibletext(cc_type,book.getDataProperty("creditType"));
		selectByVisibletext(cc_exp_month,book.getDataProperty("expiryMonth"));
		selectByVisibletext(cc_exp_year,book.getDataProperty("year"));
		passInput(cc_cvv, book.getDataProperty("cvv"));
		elementClick(book_now);
		explicitwaitClickable(book_now,30);
		scrolldown();
		takeScreenshot(book.getDataProperty("path"));
		elementClick(logout);
		explicitwaitClickable(logout, 30);
		}
}
