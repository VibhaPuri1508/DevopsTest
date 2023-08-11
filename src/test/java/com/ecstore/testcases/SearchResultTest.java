package com.ecstore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import com.ecstore.base.BaseClass;
import com.ecstore.pageobjects.HomePage;
import com.ecstore.pageobjects.SearchResultPage;

public class SearchResultTest extends BaseClass {

    private HomePage homePage;

    private SearchResultPage  searchResultPage;

    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup() {
		launchApp(); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}

    @Test(groups = "Smoke")
    public void searchProduct() throws Throwable {

        homePage= new HomePage();

        searchResultPage=homePage.searchProduct("t-shirt");

        boolean result=searchResultPage.isProductAvailable();

        AssertJUnit.assertTrue(result);

    }

}
