package com.apple.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.apple.base.TestBase;


public class LoginPage extends TestBase {
	// Page Factory - OR:
	WebDriver driver=null;
	
	@FindBy(xpath = "//*[@id='login-appleId']")
	WebElement appleID;

	@FindBy(xpath = "//*[@id='login-password']")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"sign-in\"]/span/span[2]")
	WebElement signinButton;

	@FindBy(xpath = "//p[@id='login-errorText']")
	WebElement alertText;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		System.out.println(appleID);
		this.driver = driver;
		oBaseUtil.setoDriver(driver);

	}

	public String getLoginPageTitle() {
		return oBaseUtil.getTitle();
	}

	
	public HomePage login(String un, String pwd) {
		oBaseUtil.waitTillElementIsVisible(appleID, 5);
		appleID.sendKeys(un);
		oBaseUtil.waitTillElementIsVisible(password, 5);
		password.sendKeys(pwd);
		oBaseUtil.waitTillElementIsVisible(signinButton, 5);
		signinButton.click();
		return new HomePage(driver);
	}
	
	public String alertTextPresent(){
		String sAlertText = "Your AppleConnect account or password was entered incorrectly.";
		String a = "This Apple ID has been locked for security reasons. Visit iForgot to reset your account (https://iforgot.apple.com).Verification Failed";
		return oBaseUtil.verifyText(alertText, sAlertText);
	}
	
	

}
