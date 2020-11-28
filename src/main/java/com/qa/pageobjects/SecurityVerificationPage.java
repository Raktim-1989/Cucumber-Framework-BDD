package com.qa.pageobjects;

import javax.swing.JOptionPane;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class SecurityVerificationPage extends Base {
	@FindBy(xpath = "//*[@name = 'ctl00$ContentPlaceHolder1$txtUserNameEmail']")
	WebElement onemail;
	@FindBy(xpath= "//*[@value = 'Login']")
	WebElement onlogin;
	@FindBy(xpath = "//*[@name = 'ctl00$ContentPlaceHolder1$loginCaptcha$tbCaptchaInput']")
	WebElement oncapcha;
	@FindBy(xpath="//*[@value = 'Sign in']")
	WebElement onsignin;
	
	public SecurityVerificationPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	public LoginPage onSecurityCheck()
	{
		onsignin.click();
		log.info("SignIn button is clicked on Securities Verification page");
		onemail.sendKeys(prop.getProperty("EmailID"));
		log.debug("Valid emailID has been entered in the securities verification page");
		
		try{
			String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
		oncapcha.sendKeys(captchaVal);
		log.debug("capcha is entered in the panelbox");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error("invalid capcha is entered");
		}
		onlogin.click();	
		return new LoginPage();
	}
	
	

}
