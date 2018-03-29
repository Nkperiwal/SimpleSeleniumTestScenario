package com.apple.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.apple.base.TestBase;
import com.apple.pages.HomePage;
import com.apple.pages.LocatorsFactory;
import com.apple.pages.LoginPage;
import com.apple.util.JsonFileHandler;

public class AppleStep1Flow extends TestBase {
	public HomePage oHomePage;
	public LoginPage oLoginPage;
	public String sSheetName = "Credentials";
	public String browserName;
	public WebDriver driver = null;
	public LocatorsFactory oLocatorsFactory;
	public JsonFileHandler oJsonFileHandler;

	public AppleStep1Flow() {
		super();
	}

	@BeforeMethod
	public void initiallize() {
		driver = initialize();
		oLocatorsFactory = new LocatorsFactory();
		oLocatorsFactory.locators();
		oJsonFileHandler = new JsonFileHandler();
		oJsonFileHandler.readJsonFile();
		oBaseUtil.setoDriver(driver);
		
	}
	@Test
	public void LoginTest() {
		
		System.out.println("after intialize the driver is : " + driver);
		oHomePage = new HomePage(driver);
		System.out.println(oHomePage.getHomePageTitle());
		oBaseUtil.verifyTitle(oHomePage.getHomePageTitle(), "Apple");

		oBaseUtil.clickElement(oLocatorsFactory.macLinkLocator);
		oBaseUtil.clickElement(oLocatorsFactory.macBookProLocator);
		oBaseUtil.clickElement(oLocatorsFactory.buyButtonLocator);
		oBaseUtil.clickElement(oLocatorsFactory.firstProductSelectButtonLocator);
		oBaseUtil.clickElement(oLocatorsFactory.AddToBagButtonLocator);
		oBaseUtil.clickElement(oLocatorsFactory.ReviewBagButtonLocator);
		oBaseUtil.clickElement(oLocatorsFactory.CheckOutButtonLocator);
		oBaseUtil.clickElement(oLocatorsFactory.ContinueAsGuestButtonLocator);
		oBaseUtil.clickElement(oLocatorsFactory.DeliveryAndOptions_ContinueButtonLocator);
		oBaseUtil.setText(oLocatorsFactory.firstNameLocator, oJsonFileHandler.firstName);
		oBaseUtil.setText(oLocatorsFactory.lastNameLocator, oJsonFileHandler.lastName);
		oBaseUtil.setText(oLocatorsFactory.areaCodeLocator, oJsonFileHandler.areaCode);
		oBaseUtil.setText(oLocatorsFactory.primaryPhoneNumberLocator, oJsonFileHandler.primaryPhoneNumber);
		oBaseUtil.setText(oLocatorsFactory.address1Locator, oJsonFileHandler.address1);
		oBaseUtil.setText(oLocatorsFactory.address2Locator, oJsonFileHandler.address2);
		oBaseUtil.setText(oLocatorsFactory.zipCodeLocator, oJsonFileHandler.zipCode);
		oBaseUtil.clickElement(oLocatorsFactory.ShippingAddress_ContinueButtonLocator);

	}

	@AfterMethod
	public void tearDown() {
		oBaseUtil.closeBrowser();
	}
	/*
	 * @DataProvider() public Object[][] UserCredentials(){ Object data[][] =
	 * DataProviderUtil.getSheetData(testDataFile,sSheetName); return data; }
	 */

}
