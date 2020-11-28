package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.testutil.TestUtil;

public class Base {
	public static Properties prop;
	public static WebDriver driver;
	public static Logger log;
	public Base()
	{	
		try {
			log = LogManager.getLogger(Base.class.getClass());
			File file = new File("./" + "Configuration/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
						
		} catch (Exception e) {
			  e.printStackTrace();
		}	
		
	}
	
	public static void initialization()
	{
		String browsername = prop.getProperty("Browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./" + "Drivers/chromedriver.exe");
		    driver = new ChromeDriver();
		    log.debug("ChromeBrowser has been initialized");
			 			 
		}
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./" + "Drivers/geckodriver.exe");
		    driver = new FirefoxDriver();
		    log.debug("firefoxbrowser has been initialized");
			 			 
		}
		else if(browsername.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "./" + "Drivers/IEDriverServer.exe");
		    driver = new InternetExplorerDriver();
		    log.debug("IEbrowser has been initialized"); 			 
		}
		
		driver.get(prop.getProperty("URL"));
		log.debug("HPGas URL has  been launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEWAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		
	}
	
		

}
