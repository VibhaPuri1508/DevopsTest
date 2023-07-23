package com.ecstore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.ecstore.base.BaseClass;
import com.ecstore.pageobjects.HomePage;
import com.ecstore.pageobjects.SearchResultPage;
import com.ecstore.utility.Log;


public class SearchResultTest extends BaseClass {
	private HomePage homePage;
	private SearchResultPage  searchResultPage;
	
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
	public void searchProduct() throws Throwable {
		Log.startTestCase("productAvailabilityTest");
		homePage= new HomePage();
		searchResultPage=homePage.searchProduct("t-shirt");
		boolean result=searchResultPage.isProductAvailable();
		AssertJUnit.assertTrue(result);
		Log.endTestCase("productAvailabilityTest");
	}

}
