package com.ecstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecstore.base.BaseClass;
import com.ecstore.webdriveractions.WebActions;

public class MyAccountPage extends BaseClass{
	WebActions action = new WebActions();

	@FindBy(xpath = "//a[text()='My Wish List']")
	private WebElement myWishList;

	@FindBy(xpath = "//a[text()='My Orders']")
	private WebElement myOrders;

	public MyAccountPage () {
		PageFactory.initElements(getDriver(), this);
	}

	public boolean validateMyWishList() throws Throwable {
		return action.isDisplayed(getDriver(), myWishList);
	}

	public boolean validateOrderHistory() throws Throwable {
		return action.isDisplayed(getDriver(), myOrders);
	}

	public String getCurrURL() throws Throwable {
		String myAccountPageURL = action.getCurrentURL(getDriver());
		return myAccountPageURL;
	}

}
