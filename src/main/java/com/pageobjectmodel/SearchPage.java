package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.Base_Class;
import com.interfaceelements.AdactinApplicationElements;
import com.srcmainresources.FileReaderManager;

public class SearchPage extends Base_Class implements AdactinApplicationElements {

	@FindBy(id = location_id)
	private WebElement Location;
	
	@FindBy(id = hotels_id)
	private WebElement hotels;
	
	@FindBy(id = roomType_xpath)
	private WebElement room_type;
	
	@FindBy(id = numberofrooms)
	private WebElement room_nos;
	
	@FindBy(id = checkin_name)
	private WebElement datepick_in;
	
	@FindBy(id = checkout_name)
	private WebElement datepick_out;
	
	@FindBy(id = adultsperroom)
	private WebElement adults_room;
	
	@FindBy(id = childperroom)
	private WebElement child_room;
	
	@FindBy(id = search_id)
	private WebElement Submit;
	
	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void SearchPage() throws IOException{
		FileReaderManager search = new FileReaderManager();
		selectByVisibletext(Location, search.getDataProperty("Location"));
		selectByVisibletext(hotels, search.getDataProperty("Hotels"));
		selectByVisibletext(room_type, search.getDataProperty("RoomType"));
		selectByVisibletext(room_nos, search.getDataProperty("NoofRooms"));
		clearValue(datepick_in);
		passInput(datepick_in, search.getDataProperty("CheckInDate"));
		clearValue(datepick_out);
		passInput(datepick_out, search.getDataProperty("CheckOutDate"));
	}
	}
	

