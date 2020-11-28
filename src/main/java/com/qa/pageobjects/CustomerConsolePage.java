package com.qa.pageobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;
import com.qa.testutil.TestUtil;

public class CustomerConsolePage extends Base {
	
	String[] itemslist = {"603262", "SARKAR SISHIR", "8777244144"};
	@FindBy(xpath= "//span[@id = 'lblUsername'][contains(text(), 'SISHIR')]")
	WebElement oncustomername;
	@FindBy(xpath = "//*[@class = 'Maintbl']//td//span[@id= 'ContentPlaceHolder1_lblDistributorCode']")
	WebElement distcode;
	@FindBy(xpath = "//*[@class = 'Maintbl']//td//span[@id= 'ContentPlaceHolder1_lblDistributorName']")
	WebElement distname;
	@FindBy(xpath = "//*[@class = 'Maintbl']//td//span[@id= 'ContentPlaceHolder1_lblDistAddress']")
	WebElement distaddress;
	@FindBy(xpath = "//*[@class = 'Maintbl']//td//span[@id= 'ContentPlaceHolder1_lblDistContact']")
	WebElement distcontact;
	@FindBy(xpath = "//*[@class = 'footerMain']/div")
	List<WebElement> disclaimertexts; 
	@FindBy(xpath = "//*[@class = 'footerMain']")
	WebElement footerdriver ;
	@FindBy(xpath = "//*[contains(text(), 'MECHANIC')]")
	WebElement mechaniclink;
		
	public CustomerConsolePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String onGetTitleConsole()
	{
        log.debug("Console page title is retrived " +driver.getTitle());
		return driver.getTitle();       
	}
	
	public Boolean onMechanicLinkVerification()
	{
		log.debug("Mechanic page title is retrived " +driver.getTitle());
		return mechaniclink.isDisplayed();
	}
	
	public MechanicServicePage onClickMechanicLink()
	{
	 	mechaniclink.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
	 	log.debug("MechanicSerice link is clicked on anotehr tab");
	 	TestUtil.windows = driver.getWindowHandles();
	 	TestUtil.list = new ArrayList<String>(TestUtil.windows);	 	
	 	driver.switchTo().window(TestUtil.list.get(1));
	 	return new MechanicServicePage();
	}
	public Boolean onCustomerNameVerification()
	{
		log.debug("CustomerConsole page title is verified ");
		return oncustomername.isDisplayed();			
	}
	
	public String onDistCodeRetrieval()
	{
		log.info("Distributor code is " + distcode.getText());
		System.out.println("distcode is " + distcode.getText());
		return distcode.getText();
	}
	public String onDistNameRetrieval()
	{
		log.info("Distributor name is " + distname.getText());
		System.out.println("distname is " + distname.getText());
		return distname.getText();
	}
	public String onDistAddrssRetrieval()
	{
		log.info("Distributor address is " + distaddress.getText());
		System.out.println("distaddress is " + distaddress.getText());
		return distaddress.getText();
	
	}
	public String onDistContctRetrieval()
	{
		log.info("Distributor contact is " + distcontact.getText());
		System.out.println("distcontact is " + distcontact.getText());
		return distcontact.getText();
	}
	public void onDisclaimerTxtVerification()
	{
		for(int i = 1; i<disclaimertexts.size();i++)
		{
			log.info("Disclaimer text is " + disclaimertexts.get(i).getText());
			String disclaimertext = disclaimertexts.get(i).getText();
			System.out.println(disclaimertext);
		}
	}
	
	public HomePage onClickLogoVerification()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");
		js.executeScript("window.scrollBy(250,500)");
		List<WebElement> links = footerdriver.findElements(By.tagName("a"));
		System.out.println("number of links are " + links.size());
		links.get(0).click();
		return new HomePage();	
	}
	public void onHomePageWindowVerification()
	{
		TestUtil.windows = driver.getWindowHandles();
		Iterator<String> itr = TestUtil.windows.iterator();
		while(itr.hasNext())
		{
			String nextwindow = itr.next();
			System.out.println("window is " + nextwindow);		
		}
		
		TestUtil.list = new ArrayList<String>(TestUtil.windows);
		driver.switchTo().window(TestUtil.list.get(1));
		
	}
	
	public String onGetTitleHome()
	{
		return driver.getTitle();
	}
	
	public CustomerConsolePage onBacktoConsole()
	{
		driver.switchTo().window(TestUtil.list.get(0));
		return new CustomerConsolePage();
	}
	

	public void ongetCustomerDetailsVerification()
	{
		List<WebElement> row = driver.findElements(By.xpath("//*[@class = 'Maintbl']/tbody/tr"));
	for(int i = 1;i<=row.size()-14;i++)
		{
			for(int j = 1; j<=2;j++)
			{
				WebElement elementvalue = driver.findElement(By.xpath("//*[@class = 'Maintbl']/tbody/tr["+i+"]/td["+j+"]"));
				String value = elementvalue.getText();
				System.out.print(value + " " + " " );
				TestUtil.list = new ArrayList<String>();
				TestUtil.list.add(value);
			}
			
			System.out.println();
		}	
		
		List<String> listadded= Arrays.asList(itemslist);
		if(TestUtil.list.containsAll(listadded))
		{
			System.out.println("Correct entry is displayed");
		}
		else 
		{
			System.out.println("Incorrect entry");
		}
		
	}
		
	
}
