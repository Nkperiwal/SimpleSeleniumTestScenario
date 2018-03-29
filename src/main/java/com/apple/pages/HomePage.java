package com.apple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apple.base.TestBase;
import com.apple.util.DatabaseLocatorProvider;
import com.mongodb.DBCollection;

public class HomePage extends TestBase {
	// Page Factory - OR:
	public WebDriver driver=null;
	
	DatabaseLocatorProvider oDatabaseLocatorProvider = new DatabaseLocatorProvider();
	DBCollection coll = oDatabaseLocatorProvider.getCollection();
    String bagIcon_locValue = oDatabaseLocatorProvider.getFieldValue(coll,"HeaderPane.Elements.bagIcon.xpath");

	/*@FindBy(how = How.XPATH, using = a)
	//WebElement a;
*/	
	By bag = By.xpath(bagIcon_locValue);
	WebElement bagIcon;
	

	@FindBy(xpath = "//*[@id='ac-gn-bagview-content']/nav/ul/li[5]/a[contains(text(),'Sign in')]")
	WebElement signinLink;

	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
		oBaseUtil.setoDriver(driver);
	}

	public String getHomePageTitle() {
		
		return oBaseUtil.getTitle();
	}
	
	public void clickOnBagIcon(){
		System.out.println(bagIcon_locValue);
		bagIcon = driver.findElement(bag);
		oBaseUtil.waitTillElementIsVisible(bagIcon, 5);
		bagIcon.click();
	}
	
	public LoginPage clickOnSignInLink(){
		oBaseUtil.waitTillElementIsVisible(signinLink, 5);
		signinLink.click();
		return new LoginPage(driver);
		
	}


}
