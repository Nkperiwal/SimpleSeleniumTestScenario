package com.apple.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.apple.util.DatabaseLocatorProvider;
import com.mongodb.DBCollection;

public class LocatorsFactory extends DatabaseLocatorProvider {
	DatabaseLocatorProvider oDatabaseLocatorProvider;
	DBCollection coll;

	public By macLinkLocator, macBookProLocator, buyButtonLocator, firstProductSelectButtonLocator, AddToBagButtonLocator,
			ReviewBagButtonLocator, CheckOutButtonLocator, ContinueAsGuestButtonLocator,
			DeliveryAndOptions_ContinueButtonLocator, ShippingAddress_ContinueButtonLocator;
	public By firstNameLocator, lastNameLocator, areaCodeLocator, primaryPhoneNumberLocator, address1Locator, address2Locator,
			zipCodeLocator;

	public LocatorsFactory() {

		oDatabaseLocatorProvider = new DatabaseLocatorProvider();
		coll = oDatabaseLocatorProvider.getCollection();
	}

	public void locators() {

		macLinkLocator = By.xpath(oDatabaseLocatorProvider.getFieldValue(coll, "HeaderPane.Elements.MacLink.xpath"));

		macBookProLocator = By
				.xpath(oDatabaseLocatorProvider.getFieldValue(coll, "HomePage.ProductsPane.Elements.MacBookPro.xpath"));

		buyButtonLocator = By.xpath(oDatabaseLocatorProvider.getFieldValue(coll,
				"Item_Shop_BuyPage.ItemNavigationPane.Elements.BuyButton.xpath"));

		firstProductSelectButtonLocator = By.xpath(oDatabaseLocatorProvider.getFieldValue(coll,
				"Item_Shop_BuyPage.BuyPane.Elements.FirstProductSelectButton.xpath"));

		AddToBagButtonLocator = By.xpath(oDatabaseLocatorProvider.getFieldValue(coll,
				"Item_Shop_BuyPage.actiontrayPane.Elements.AddToBagButton.xpath"));

		ReviewBagButtonLocator = By.xpath(oDatabaseLocatorProvider.getFieldValue(coll,
				"Attach_BagPage.ReviewBagPane.Elements.ReviewBagButton.xpath"));

		CheckOutButtonLocator = By.xpath(
				oDatabaseLocatorProvider.getFieldValue(coll, "BagPage.BagItemPane.Elements.CheckOutButton.xpath"));

		ContinueAsGuestButtonLocator = By.xpath(oDatabaseLocatorProvider.getFieldValue(coll,
				"LoginPage.SignInPane.Elements.ContinueAsGuestButton.xpath"));

		DeliveryAndOptions_ContinueButtonLocator = By.xpath(oDatabaseLocatorProvider.getFieldValue(coll,
				"CheckOutPage.DeliveryOptionsPane.Elements.ContinueButton.xpath"));

		firstNameLocator = By.xpath(oDatabaseLocatorProvider.getFieldValue(coll,
				"CheckOutPage.ShippingAddressPane.Elements.firstName.xpath"));

		lastNameLocator = By.xpath(oDatabaseLocatorProvider.getFieldValue(coll,
				"CheckOutPage.ShippingAddressPane.Elements.lastName.xpath"));

		areaCodeLocator = By.xpath(oDatabaseLocatorProvider.getFieldValue(coll,
				"CheckOutPage.ShippingAddressPane.Elements.areaCode.xpath"));

		primaryPhoneNumberLocator = By.xpath(oDatabaseLocatorProvider.getFieldValue(coll,
				"CheckOutPage.ShippingAddressPane.Elements.primaryPhoneNumber.xpath"));

		address1Locator = By.xpath(oDatabaseLocatorProvider.getFieldValue(coll,
				"CheckOutPage.ShippingAddressPane.Elements.address1.xpath"));

		address2Locator = By.xpath(oDatabaseLocatorProvider.getFieldValue(coll,
				"CheckOutPage.ShippingAddressPane.Elements.address2.xpath"));

		zipCodeLocator = By.xpath(oDatabaseLocatorProvider.getFieldValue(coll,
				"CheckOutPage.ShippingAddressPane.Elements.zipCode.xpath"));

		ShippingAddress_ContinueButtonLocator = By.xpath(oDatabaseLocatorProvider.getFieldValue(coll,
				"CheckOutPage.ShippingAddressPane.Elements.continueButton.xpath"));

	}
}
