package com.pageobjectmodel;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
import com.interfaceelements.AdactinApplicationElements;
import com.srcmainresources.FileReaderManager;

public class AdactinLoginPag extends BaseClass implements AdactinApplicationElements{

	@FindBy(id= username_id)
	private WebElement username;
	
	@FindBy(name= password_name)
	private WebElement password;
	
	@FindBy(xpath= login_xpath)
	private WebElement login;
	
	
	
	
	public AdactinLoginPag(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public  void validUserAndvalidPassword() throws IOException {
		FileReaderManager data= new FileReaderManager();
		passInput(username,data.getDataProperty("loginusername"));
		passInput(password,data.getDataProperty("loginpassword"));
		elementClic(login);
		
	}

}
