package com.ecstore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.ecstore.base.BaseClass;
import com.ecstore.pageobjects.HomePage;
import com.ecstore.utility.Log;

public class HomePageTest extends BaseClass {
	private HomePage homePage;
    
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
	public void verifyLogo() throws Throwable {
		Log.startTestCase("verifyLogo");
		homePage= new HomePage();
		boolean result=homePage.validateLogo();
		AssertJUnit.assertTrue(result);
		Log.endTestCase("verifyLogo");
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		Log.startTestCase("verifyTitle");
		homePage= new HomePage();
		String actTitle=homePage.getMyPageTitle();
		AssertJUnit.assertEquals(actTitle, "Home Page");
		Log.endTestCase("verifyTitle");
	}
}
