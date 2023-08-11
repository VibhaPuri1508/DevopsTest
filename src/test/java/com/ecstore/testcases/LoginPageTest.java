package com.ecstore.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.ecstore.base.BaseClass;
import com.ecstore.pageobjects.HomePage;
import com.ecstore.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	private LoginPage loginPage;
	private HomePage homePage;

	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp(); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Smoke","Sanity"})
	public void loginTest() throws Throwable {
		homePage= new HomePage();
		loginPage=homePage.clickOnSignIn();
		homePage=loginPage.login("vpdp@gmail.com","vpdp@12345P");
	    String actualURL=homePage.getCurrentURL();
	    String expectedURL="https://magento.softwaretestingboard.com/";
	    AssertJUnit.assertEquals(actualURL, expectedURL);
	}

}
