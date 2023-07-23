package com.ecstore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import com.ecstore.base.BaseClass;
import com.ecstore.pageobjects.AddToCartPage;
import com.ecstore.pageobjects.HomePage;
import com.ecstore.pageobjects.SearchResultPage;
import com.ecstore.utility.ExcelReaderLibrary;
import com.ecstore.utility.Log;

public class AddToCartTest extends BaseClass {
	private HomePage homePage;
	private AddToCartPage addToCartPage ;
	private SearchResultPage searchResultPage ;
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
	
	@Test(groups = {"Regression","Sanity"},dataProvider = "getProduct")
	public void addToCartTest(String productName, String quantity, String size ,String color) throws Throwable {
		Log.startTestCase("addToCartTest");
		homePage= new HomePage();
		searchResultPage=homePage.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity( quantity);
		addToCartPage.selectSize(size);
		addToCartPage.selectColor(color);
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddtoCart();
		AssertJUnit.assertTrue(result);
		Log.endTestCase("addToCartTest");
		
	}

}
