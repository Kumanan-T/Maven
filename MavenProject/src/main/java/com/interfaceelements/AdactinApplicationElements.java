package com.interfaceelements;

public interface AdactinApplicationElements {
	//Login 
	String username_id="username";
	String password_name="password";
	String login_xpath= "//input[@type='Submit']";
	
	//Search
	String location_id="location";
	String hotel_xpath="//select[@id='hotels']";
	String room_type_id="room_type";
	String noofRooms_id="room_nos";
	String checkindate_id="datepick_in";
	String checkoutdt_id="datepick_out";
	String adult_room_id="adult_room";
	String child_room_id="child_room";
	
	String search_btn_id="Submit";
	String selectbtn_id="radiobutton_0";
	String continue_id="continue";
	
	//Book
	String firstname_id="first_name";
	String lastname_id="last_name";
	String address_id="address";
	String ccno_id="cc_num";
	String cctype_id="cc_type";
	String month_id="cc_exp_month";
	String year_id="cc_exp_year";
	String cvvno_id="cc_cvv";
	String book_id="book_now";
	
	
	String logout_xpath="//input[@id='logout']";
}
