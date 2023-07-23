package com.ecstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ecstore.base.BaseClass;
import com.ecstore.webdriveractions.WebActions;

public class SearchResultPage extends BaseClass  {
	
	WebActions action = new WebActions();
	
	@FindBy(xpath="//img[@class='product-image-photo' and @alt='Radiant Tee']")
	private WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		return action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct() throws Throwable {
		action.click(getDriver(), productResult);
		return new AddToCartPage();
	}

}
