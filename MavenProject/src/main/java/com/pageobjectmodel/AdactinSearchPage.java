package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
import com.interfaceelements.AdactinApplicationElements;
import com.srcmainresources.FileReaderManager;

public class AdactinSearchPage extends BaseClass implements AdactinApplicationElements {

	@FindBy(id= location_id)
	private WebElement location;
	
	@FindBy(xpath=hotel_xpath)
	private WebElement hotel;
	
	@FindBy(id=room_type_id)
	private WebElement room_type;
	
	@FindBy(id=noofRooms_id)
	private WebElement room_nos;
	
	@FindBy(id=checkindate_id)
	private WebElement checkin;
	
	@FindBy(id=checkoutdt_id)
	private WebElement checkout;
	
	@FindBy(id=adult_room_id)
	private WebElement adult_room;
	
	@FindBy(id=child_room_id)
	private WebElement child_room;
	
	@FindBy(id=search_btn_id)
	private WebElement searchbtn;
	
	@FindBy(id=selectbtn_id)
	private WebElement selectbtn;
	
	@FindBy(id=continue_id)
	private WebElement continuebtn;

public AdactinSearchPage(WebDriver driver){
	PageFactory.initElements(driver, this);
}

public  void searchHotel() throws IOException {
FileReaderManager search= new FileReaderManager();
selectByVisibiletext(location,search.getDataProperty("location") );
selectByVisibiletext(hotel,search.getDataProperty("hotels"));
selectByVisibiletext(room_type, search.getDataProperty("roomtype"));
selectByVisibiletext(room_nos, search.getDataProperty("roomnos"));
passInput(checkin, search.getDataProperty("checkindate"));
passInput(checkout,search.getDataProperty("checkoutdate"));
selectByVisibiletext(adult_room, search.getDataProperty("noofadultroom"));
selectByVisibiletext(child_room, search.getDataProperty("childroom"));
elementClic(searchbtn);
elementClic(selectbtn);
elementClic(continuebtn);
;

}

}