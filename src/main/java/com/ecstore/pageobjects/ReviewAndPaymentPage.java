package com.ecstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecstore.base.BaseClass;
import com.ecstore.webdriveractions.WebActions;

public class ReviewAndPaymentPage  extends BaseClass{
	WebActions action = new WebActions();
	

	@FindBy(xpath="//span[text()='Place Order']")
	private WebElement placeOrderBtn ;
	
	public ReviewAndPaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public  OrderSuccessPage clickOnSignIn() throws Throwable {
		action.explicitWait(getDriver(), placeOrderBtn, 60);
		action.javascriptButtonClick(getDriver(), placeOrderBtn);
		return new OrderSuccessPage();
	}

}
