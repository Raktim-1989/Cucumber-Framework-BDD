package com.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class LoginPage extends Base {
	
	@FindBy(xpath= "//*[@name = 'ctl00$ContentPlaceHolder1$txtPassword']")
	WebElement onpassword;
	@FindBy(xpath= "//*[@value = 'Login']")
	WebElement onlogin;
	@FindBy(xpath = "//*[@value = 'OK']")
	WebElement onconfirm;
	
	 LoginPage()
	{
		PageFactory.initElements(driver, this);
	} 
	
	public String onGetTitleLogin()
	{
		log.info("LoginPage title is retrieved" + driver.getTitle());
		return driver.getTitle();
		
	}
	public CustomerConsolePage onLoginsuccess()
	{
		
		onpassword.sendKeys(prop.getProperty("Password"));
		log.debug("User has entered a valid password in the login page");
		onlogin.click();
		log.debug("login button is clicked");
		onconfirm.click();
		return new CustomerConsolePage();
	}
}
