package com.qa.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;
import com.qa.testutil.TestUtil;

public class MechanicServicePage extends Base {
	
	@FindBy(xpath= "//*[@class = 'breadcrumb']//span[contains(text(), 'Mechanic Service')]")
	WebElement mechanicServicelink;

	MechanicServicePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String onGetTitleMechanicServiceVerification()
	{	
		return driver.getTitle();
	}
	
	
	public Boolean onMechanicLinkVerification()
	{
		return mechanicServicelink.isDisplayed();
	}
	
	public CustomerConsolePage onGetBackToConsoleVerification()
	{
		TestUtil.windows = driver.getWindowHandles();
	 	TestUtil.list = new ArrayList<String>(TestUtil.windows);	 	
	 	driver.switchTo().window(TestUtil.list.get(0));	 	
	    return new CustomerConsolePage();
	}
	
}

