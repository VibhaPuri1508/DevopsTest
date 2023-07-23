package com.ecstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ecstore.base.BaseClass;
import com.ecstore.webdriveractions.WebActions;


public class AddToCartPage extends BaseClass{
	WebActions action = new WebActions();

	@FindBy(id="qty")
	private WebElement quantity;

	@FindBy(id="option-label-size-143-item-167")
	private WebElement sizeS;

	@FindBy(id="option-label-size-143-item-168")
	private WebElement sizeM;

	@FindBy(id="option-label-size-143-item-169")
	private WebElement sizeL;

	@FindBy(xpath="//div[@class='swatch-option color' and @option-label='Blue']")
	private WebElement Blue;

	@FindBy(xpath="//div[@class='swatch-option color' and @option-label='Orange']")
	private WebElement Orange;

	@FindBy(xpath="//div[@class='swatch-option color' and @option-label='Purple']")
	private WebElement Purple;

	@FindBy(id="product-addtocart-button")
	private WebElement addToCartBtn;

	@FindBy(xpath="//div[@class='messages']//div[contains(text(), 'You added')]")
	private WebElement addToCartMessag;

	@FindBy(xpath="//a[contains(text(),'shopping cart')]")
	private WebElement proceedToShoppingCart;

	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterQuantity(String quant) throws Throwable {
		action.type(quantity, quant);
	}

	public void selectSize(String size) throws Throwable {
		switch (size) {
		case "S":
			action.explicitWait(getDriver(), sizeS, 20);
			action.javascriptButtonClick(getDriver(), sizeS);
			break;
		case "M":
			action.explicitWait(getDriver(), sizeM, 20);
			action.javascriptButtonClick(getDriver(), sizeM);
			break;
		case "L":
			action.explicitWait(getDriver(), sizeL, 20);
			action.javascriptButtonClick(getDriver(), sizeL);
			break;
		}
	}

	public void selectColor(String color) throws Throwable {
		switch (color) {
		case "Blue":
			action.explicitWait(getDriver(), Blue, 20);
			action.javascriptButtonClick(getDriver(), Blue);
			break;
		case "Orange":
			action.explicitWait(getDriver(), Orange, 20);
			action.javascriptButtonClick(getDriver(), Orange);
			break;
		case "Purple":
			action.explicitWait(getDriver(), Purple, 20);
			action.javascriptButtonClick(getDriver(), Purple);
			break;
		}
	}

	public void clickOnAddToCart() throws Throwable {
		action.javascriptButtonClick(getDriver(), addToCartBtn);
	}

	public boolean validateAddtoCart() throws Throwable {
		action.explicitWait(getDriver(), addToCartMessag, 20);
		return action.isDisplayed(getDriver(), addToCartMessag);
	}

	public ShoppingCartPage clickOnCheckOut() throws Throwable {
		action.explicitWait(getDriver(), proceedToShoppingCart, 30);
		action.javascriptButtonClick(getDriver(), proceedToShoppingCart);
		return new ShoppingCartPage();
	}

}
