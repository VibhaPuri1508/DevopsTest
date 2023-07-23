package com.ecstore.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecstore.base.BaseClass;
import com.ecstore.webdriveractions.WebActions;

public class HomePage extends BaseClass {
	

	WebActions action = new WebActions();
	
	@FindBy(xpath = "//a[contains(text(),'Sign In')]") 
	private WebElement signInBtn;
	
	@FindBy(xpath = "//a[@class='logo']/img")
	private WebElement brandLogo;
	
	@FindBy(id="search")
	private WebElement searchProductBox;
	
	@FindBy(xpath="//button[@class='action search']")
	private WebElement searchButton;
	
	@FindBy(xpath="(//span[@class='customer-name'])[1]")
	private WebElement welcomeDropdown ;
	
	@FindBy(xpath="(//a[text()='My Account'])[1]")
	private WebElement myAccountLink;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() throws Throwable {
		action.explicitWait(getDriver(), signInBtn, 10);
		action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(getDriver(), brandLogo);
	}
	
	public String getMyPageTitle() {
		String pageTitle=getDriver().getTitle();
		return pageTitle;
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		action.type(searchProductBox, productName);
		action.scrollByVisibilityOfElement(getDriver(), searchButton);
		action.click(getDriver(), searchButton);
		Thread.sleep(3000);
		return new SearchResultPage();
	}
	
	public String getCurrentURL() throws Throwable {
		String myAccountPageURL = action.getCurrentURL(getDriver());
		return myAccountPageURL;
	}
	
	public void clickOnWelcomeDropdown() throws Throwable {
		action.explicitWait(getDriver(), welcomeDropdown, 10);
		action.click(getDriver(), welcomeDropdown);
		Thread.sleep(2000);
	}
	
	public MyAccountPage clickOnAccountLink() throws Throwable {
		action.explicitWait(getDriver(), myAccountLink, 10);
		action.click(getDriver(), myAccountLink);
		return new MyAccountPage();
	}

}
