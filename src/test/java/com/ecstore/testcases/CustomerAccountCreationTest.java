package com.ecstore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import com.ecstore.base.BaseClass;
import com.ecstore.pageobjects.CustomerAccountCreationPage;
import com.ecstore.pageobjects.HomePage;
import com.ecstore.pageobjects.LoginPage;
import com.ecstore.pageobjects.MyAccountPage;
import com.ecstore.utility.ExcelReaderLibrary;
import com.ecstore.utility.Log;

public class CustomerAccountCreationTest extends BaseClass{
	private LoginPage loginPage;
	private HomePage homePage;
	private MyAccountPage myAccountPage ;
	private CustomerAccountCreationPage customerAccountCreationPage;
	ExcelReaderLibrary excelReader = new ExcelReaderLibrary();
	
	@DataProvider(name = "newAcountCreationData")
	public Object[][] accountCreation() {

		// Totals rows count
		int rows = excelReader.getRowCount("AccountCreationData");
		// Total Columns
		int column = excelReader.getColumnCount("AccountCreationData");
		int actRows = rows - 1;
		//Created an object of array to store data
		Object[][] data = new Object[actRows][1];
		
		for (int i = 0; i < actRows; i++) {
			Map<String, String> hashMap = new HashMap<>();
			for (int j = 0; j < column; j++) {
				hashMap.put(excelReader.getCellData("AccountCreationData", j, 1),
						excelReader.getCellData("AccountCreationData", j, i + 2));
			}
			data[i][0]=hashMap;
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
	
	@Test(groups = "Sanity")
		public void verifyCustomerNewAccountCreation() throws Throwable {
		Log.startTestCase("accountCreationTest");
		homePage= new HomePage();
		loginPage=homePage.clickOnSignIn();
		customerAccountCreationPage=loginPage.createNewAccount();
		boolean result= customerAccountCreationPage.validateAcountCreatePage();
		AssertJUnit.assertTrue(result);
	    Log.endTestCase("accountCreationTest");
	}
	
	@Test(groups = "Regression",dataProvider = "newAcountCreationData")
	public void createAccountTest(HashMap<String,String> hashMapValue) throws Throwable {
		Log.startTestCase("createAccountTest");
		homePage= new HomePage();
		loginPage=homePage.clickOnSignIn();
		customerAccountCreationPage=loginPage.createNewAccount();
		customerAccountCreationPage.createAccount(
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("Email"),
				hashMapValue.get("Password"),
				hashMapValue.get("ConfirmPassword")
				);
		myAccountPage=customerAccountCreationPage.validateRegistration();
		Thread.sleep(3000);;
		Assert.assertEquals("https://magento.softwaretestingboard.com/customer/account/", myAccountPage.getCurrURL());
		Log.endTestCase("createAccountTest");
	}

}
