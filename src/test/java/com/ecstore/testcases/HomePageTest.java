package com.ecstore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import com.ecstore.base.BaseClass;
import com.ecstore.pageobjects.HomePage;

public class HomePageTest extends BaseClass {
	private HomePage homePage;
    
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp(); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Smoke")
	public void verifyLogo() throws Throwable {
		homePage= new HomePage();
		boolean result=homePage.validateLogo();
		AssertJUnit.assertTrue(result);
	}
}
