package com.apple.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.apple.base.TestBase;
import com.apple.pages.HomePage;
import com.apple.pages.LoginPage;
import com.apple.util.DataProviderUtil;

public class LoginTestScenario extends TestBase {
	public  HomePage oHomePage;
	public  LoginPage oLoginPage;
	public  String sSheetName = "Credentials";
	public String browserName;
	public WebDriver driver=null;
	
	public LoginTestScenario()
	{
		super();
	}
	
	/*@BeforeMethod(alwaysRun=true)
	public void initiallization() {

		//System.out.println("running");
		driver = initialize();
	}*/

	
	@Test(dataProvider="UserCredentials")
	public void LoginTest(String sUserID, String sPassword){
		driver = initialize();
		System.out.println("after intialize the driver is : "+driver);
		oHomePage = new HomePage(driver);
		System.out.println(oHomePage.getHomePageTitle());
		oBaseUtil.verifyTitle(oHomePage.getHomePageTitle(), "Apple");
		
		oHomePage.clickOnBagIcon();
		oLoginPage = oHomePage.clickOnSignInLink();
		oBaseUtil.waitForSeconds(5);
		System.out.println(oLoginPage.getLoginPageTitle());
		oBaseUtil.verifyTitle(oLoginPage.getLoginPageTitle(), "Sign in - Apple");
		
		oLoginPage.login(sUserID,sPassword);
		oBaseUtil.waitForSeconds(5);
		System.out.println(oLoginPage.alertTextPresent());
		
		oBaseUtil.savePageSnapshot();
		oBaseUtil.closeBrowser();
		
	}
	
	/*@AfterMethod(alwaysRun=true)
	public void tearDown() {
		//System.out.println("closing");
		oBaseUtil.closeBrowser();
		
	}*/

	
	
	@DataProvider(parallel=true)
	public Object[][] UserCredentials(){
		Object data[][] = DataProviderUtil.getSheetData(testDataFile,sSheetName);
		return data;
	}
	
	

}
