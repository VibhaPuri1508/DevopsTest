package com.ecstore.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.ecstore.base.BaseClass;
import com.ecstore.pageobjects.HomePage;
import com.ecstore.pageobjects.LoginPage;
import com.ecstore.utility.ExcelReaderLibrary;

public class LoginPageTest extends BaseClass {
	private LoginPage loginPage;
	private HomePage homePage;
	ExcelReaderLibrary excelReader = new ExcelReaderLibrary();
	
	@DataProvider(name = "credentials")
	public Object[][] getCredentials() {
		// Totals rows count
		int rows = excelReader.getRowCount("Credentials");
		// Total Columns
		int column = excelReader.getColumnCount("Credentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = excelReader.getCellData("Credentials", j, i + 2);
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
	
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials")
	public void loginTest(String uname, String pswd) throws Throwable {
		//Log.startTestCase("loginTest");
		homePage= new HomePage();
		//Log.info("user is going to click on SignIn");
		loginPage=homePage.clickOnSignIn();
		//Log.info("Enter Username and Password");
		homePage=loginPage.login(uname,pswd);
	    String actualURL=homePage.getCurrentURL();
	    String expectedURL="https://magento.softwaretestingboard.com/";
	   // Log.info("Verifying if user is able to login");
	    AssertJUnit.assertEquals(actualURL, expectedURL);
	    //Log.info("Login is Sucess");
	    //Log.endTestCase("loginTest");
	}

}
