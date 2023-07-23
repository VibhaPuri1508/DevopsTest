package com.ecstore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.ecstore.base.BaseClass;
import com.ecstore.pageobjects.HomePage;
import com.ecstore.pageobjects.LoginPage;
import com.ecstore.pageobjects.MyAccountPage;
import com.ecstore.utility.Log;

public class MyAccountPageTest extends BaseClass {
	private LoginPage loginPage;
	private HomePage homePage;
	private MyAccountPage myAccountPage ;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void validateWishList() throws Throwable {
		Log.startTestCase("wishListTest");
		homePage= new HomePage();
		loginPage=homePage.clickOnSignIn();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnWelcomeDropdown();
		myAccountPage=homePage.clickOnAccountLink();
		boolean result=myAccountPage.validateMyWishList();
		AssertJUnit.assertTrue(result);
		Log.endTestCase("wishListTest");
	}
	

	@Test(groups = "Smoke")
	public void validateOrderHistory() throws Throwable {
		Log.startTestCase("validateOrderHistory");
		homePage= new HomePage();
		loginPage=homePage.clickOnSignIn();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage.clickOnWelcomeDropdown();
		myAccountPage=homePage.clickOnAccountLink();
		boolean result=myAccountPage.validateOrderHistory();
		AssertJUnit.assertTrue(result);
		Log.endTestCase("validateOrderHistory");
	}

}
