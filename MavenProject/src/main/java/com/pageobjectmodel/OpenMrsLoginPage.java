package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.baseclass.BaseClass;
import com.interfaceelements.OpenMrsElements;
import com.srcmainresources.FileReaderManager;
import com.srcmainresources.OpenMrsFileReaderManager;

public class OpenMrsLoginPage extends BaseClass implements OpenMrsElements {

	@FindBy(id= username_id)
	private WebElement username;
	
	@FindBy(id=password_name_id)
	private WebElement password;
	
	@FindBy(id=location_id)
	private WebElement location;
	
	@FindBy(id=login_id)
	private WebElement signin;
	
	@FindBy(xpath=error_message)
	private WebElement errorMessage;
	
	@FindBy(xpath=location_err_message )
	private WebElement locationerrormessage;
	
	public OpenMrsLoginPage(WebDriver driver){
		
		PageFactory.initElements(driver,this);		
	}
	
	public boolean validLogin(ExtentTest extenttext)  {
		try {
			//FileReaderManager data=new FileReaderManager();
			OpenMrsFileReaderManager data= new OpenMrsFileReaderManager();
			launchUrl(data.getDataProperty("url"));
			passInput(username,data.getDataProperty("loginusername"));
			passInput(password,data.getDataProperty("loginpassword"));
			elementClic(location);
			elementClic(signin);
			validation(driver.getTitle(), data.getDataProperty("title"));
			extenttext.log(Status.PASS, "Login Successful");
		} catch (Exception e) {

			extenttext.log(Status.FAIL,"LoginFailed"+e.getMessage());
			return false;
		}
		return true;
}
	
	public  boolean LoginWithValidUserNameAndInvalidPassword() {

		try {
			OpenMrsFileReaderManager data= new OpenMrsFileReaderManager();
			launchUrl(data.getDataProperty("url"));
			passInput(username,data.getDataProperty("loginusername"));
			passInput(password,data.getDataProperty("invalidpassword"));
			elementClic(location);
			elementClic(signin);
			validation(errorMessage.getText(), data.getDataProperty("errorMessage"));
					
			
		} catch (Exception e) {

			Assert.fail("ERROR: OCCUR DURING VALIDATION");
			
		}
		
		return true;
		
	}
	
	public boolean loginWithInvalidUsernameAndValidPassword() {

		try {
			OpenMrsFileReaderManager data= new OpenMrsFileReaderManager();
			launchUrl(data.getDataProperty("url"));
			passInput(username,data.getDataProperty("invalidusername"));
			passInput(password,data.getDataProperty("loginpassword"));
			elementClic(location);
			elementClic(signin);
			validation(errorMessage.getText(), data.getDataProperty("errorMessage"));
					
			
		} catch (Exception e) {

			Assert.fail("ERROR: OCCUR DURING VALIDATION");
			
		}
		
		return true;
		
	}
	
	public  boolean loginWithInvalidUsernameAndInvalidPassword() {

		try {
			OpenMrsFileReaderManager data= new OpenMrsFileReaderManager();
			launchUrl(data.getDataProperty("url"));
			passInput(username,data.getDataProperty("invalidusername"));
			passInput(password,data.getDataProperty("invalidpassword"));
			elementClic(location);
			elementClic(signin);
			validation(errorMessage.getText(), data.getDataProperty("errorMessage"));
					
			
		} catch (Exception e) {

			Assert.fail("ERROR: OCCUR DURING VALIDATION");
			
		}
		
		return true;
		
	
	}
	
	public boolean withOutLocation() {
		try {
			OpenMrsFileReaderManager data= new OpenMrsFileReaderManager();
			launchUrl(data.getDataProperty("url"));
			passInput(username,data.getDataProperty("loginusername"));
			passInput(password,data.getDataProperty("loginpassword"));
			elementClic(signin);
			validation(locationerrormessage.getText(), data.getDataProperty("locationMessage"));
					
			
		} catch (Exception e) {

			Assert.fail("ERROR: OCCUR DURING LOCATION");
		}
		
		return true;
}
	
}
