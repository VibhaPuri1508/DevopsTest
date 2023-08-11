package com.ecstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ecstore.base.BaseClass;
import com.ecstore.webdriveractions.WebActions;


public class CheckoutShippingPage extends BaseClass{
	WebActions action = new WebActions();
	

	@FindBy(xpath="//button[@class='action action-auth-toggle']//span[text()='Sign In']")
	private WebElement signInLink;
	
	@FindBy(id="login-email")
	private WebElement loginEmail;
	
	@FindBy(id="login-password")
	private WebElement loginPwd;

	@FindBy(xpath="(//button[@type='submit']/span[text()='Sign In']) [1]")
	private WebElement submitBtn;
	
	@FindBy(xpath="//span[text()='Order Summary']")
	private WebElement orderSummary ;
	
	@FindBy(xpath="//input[@id='QDIFYSS']")
	private WebElement street;
	
	@FindBy(xpath="//input[@id='RN6OST4']")
	private WebElement city;
	
	@FindBy(xpath="//input[@id='SY1E079']")
	private WebElement postalCode;
	
	@FindBy(name="region_id")
	private WebElement selectRegion;
	
	@FindBy(name="country_id")
	private WebElement selectCountry;
	
	@FindBy(name="telephone")
	private WebElement telephone;
	
	@FindBy(xpath="//input[@class='radio' and @value='tablerate_bestway']")
	private WebElement shippingMethodTableRate;
	
	@FindBy(xpath="//input[@class='radio' and @value='flatrate_flatrate']")
	private WebElement shippingMethodFixedRate;
	
	@FindBy(xpath="//span[text()='Next']")
	private WebElement nextButton;
	
	
	
	
	public CheckoutShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void signIn(String uname, String pswd) throws Throwable {
		action.explicitWait(getDriver(), signInLink, 30);
		action.javascriptButtonClick(getDriver(), signInLink);
		action.explicitWait(getDriver(), loginEmail, 20);
		action.scrollByVisibilityOfElement(getDriver(), loginEmail);
		action.type(loginEmail, uname);
		action.type(loginPwd, pswd);
		action.click(getDriver(), submitBtn);
		Thread.sleep(2000);
	}
	
	public void shippingMethodTableRate() throws Throwable {
		action.explicitWait(getDriver(), shippingMethodTableRate, 30);
		action.click(getDriver(), shippingMethodTableRate);
	}
	
	public void shippingMethodFixedRate() {
		action.explicitWait(getDriver(), shippingMethodFixedRate, 30);
		action.javascriptButtonClick(getDriver(), shippingMethodFixedRate);
	}
	
	public ReviewAndPaymentPage clickNextButton() {
		action.explicitWait(getDriver(), nextButton, 10);
		action.javascriptButtonClick(getDriver(), nextButton);
		return new ReviewAndPaymentPage();
	}

}
