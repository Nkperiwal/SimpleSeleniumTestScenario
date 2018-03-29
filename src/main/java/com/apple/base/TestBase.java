package com.apple.base;

import org.openqa.selenium.WebDriver;

/*
 * 
 * @author = Nandkishor Periwal
 * 
 */


import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.apple.util.BaseUtil;
import com.apple.util.ConfigProperties;
import com.apple.util.WebEventListener;

public class TestBase extends ConfigProperties{
	public BaseUtil oBaseUtil;
	public   EventFiringWebDriver e_driver;
	public  WebEventListener oWebEventListener;

	public TestBase() {
		oBaseUtil = new BaseUtil();
	}
	
	public WebDriver initialize() {
		 WebDriver driver = oBaseUtil.openBrowser(browser, appleURL);
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		oWebEventListener = new WebEventListener();
		e_driver.register(oWebEventListener);
		driver = e_driver;
		 return driver;
		
	}
	
	
	

}
