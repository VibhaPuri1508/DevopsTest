package com.ecstore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import com.ecstore.base.BaseClass;
import com.ecstore.pageobjects.AddToCartPage;
import com.ecstore.pageobjects.CheckoutShippingPage;
import com.ecstore.pageobjects.HomePage;
import com.ecstore.pageobjects.OrderSuccessPage;
import com.ecstore.pageobjects.ReviewAndPaymentPage;
import com.ecstore.pageobjects.SearchResultPage;
import com.ecstore.pageobjects.ShoppingCartPage;
import com.ecstore.utility.ExcelReaderLibrary;
import com.ecstore.utility.Log;

public class OrderConfirmedTest extends BaseClass {
	private HomePage homePage;
	private AddToCartPage addToCartPage ;
	private SearchResultPage searchResultPage ;
	private ShoppingCartPage shoppingCartPage;
	private CheckoutShippingPage checkoutShippingPage;
	private ReviewAndPaymentPage reviewAndPaymentPage;
	private OrderSuccessPage orderSuccessPage;
	ExcelReaderLibrary excelReader = new ExcelReaderLibrary();
	
	@DataProvider(name = "getProduct")
	public Object[][] getProduct() {
		// Totals rows count
		int rows = excelReader.getRowCount("ProductDetails");
		// Total Columns
		int column = excelReader.getColumnCount("ProductDetails");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = excelReader.getCellData("ProductDetails", j, i + 2);
			}
		}
		return data;
	}
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	

	@Test(groups = "Regression" , dataProvider="getProduct")
	public void verifyOrderConfirmation(String productName, String quantity, String size ,String color) throws Throwable {
		Log.startTestCase("verifyOrderConfirmation");
		homePage= new HomePage();
		searchResultPage=homePage.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity( quantity);
		addToCartPage.selectSize(size);
		addToCartPage.selectColor(color);
		addToCartPage.clickOnAddToCart();
		shoppingCartPage=addToCartPage.clickOnCheckOut();
		checkoutShippingPage=shoppingCartPage.proceedToCheckOut();
		checkoutShippingPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		checkoutShippingPage.shippingMethodFixedRate();
		Log.info("User will navigate to Review and Payment page");
		reviewAndPaymentPage=checkoutShippingPage.clickNextButton();
		orderSuccessPage=reviewAndPaymentPage.clickOnSignIn();
		Log.info("order confirmation");
		orderSuccessPage.validateConfirmMessage();
		Log.endTestCase("verifyOrderConfirmation");
	}

}
