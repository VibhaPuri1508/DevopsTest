package com.ecstore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.ecstore.base.BaseClass;
import com.ecstore.pageobjects.AddToCartPage;
import com.ecstore.pageobjects.HomePage;
import com.ecstore.pageobjects.SearchResultPage;
import com.ecstore.pageobjects.ShoppingCartPage;
import com.ecstore.utility.Log;

public class ShoppingCartTest  extends BaseClass {
	private HomePage homePage;
	private AddToCartPage addToCartPage ;
	private SearchResultPage searchResultPage ;
	private ShoppingCartPage shoppingCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	

	@Test(groups = "Regression")
	public void verifyTotalPrice() throws Throwable {
		Log.startTestCase("verifyTotalPrice");
		homePage= new HomePage();
		searchResultPage=homePage.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.selectSize("S");
		addToCartPage.selectColor("Blue");
		addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddToCart();
		shoppingCartPage=addToCartPage.clickOnCheckOut();
		Double unitPrice=shoppingCartPage.getPrice();
		String totalActualPrice=Double.toString(shoppingCartPage.getTotalPrice());
		String totalExpectedPrice=Double.toString((unitPrice*2));
		AssertJUnit.assertEquals(totalActualPrice , totalExpectedPrice);
		Log.endTestCase("verifyTotalPrice");
	}

}
