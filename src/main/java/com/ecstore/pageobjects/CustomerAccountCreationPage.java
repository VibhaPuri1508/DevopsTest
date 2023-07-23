package com.ecstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecstore.base.BaseClass;
import com.ecstore.webdriveractions.WebActions;

public class CustomerAccountCreationPage extends BaseClass {
	WebActions action = new WebActions();

	@FindBy(xpath = "//span[text()='Create New Customer Account']")
	private WebElement pageTitle;
	
	@FindBy(id="firstname")
	private WebElement firstName;
	
	@FindBy(id="lastname")
	private WebElement lastName;
	
	@FindBy(xpath="//fieldset[@class='fieldset create account']//input[@id='email_address']")
	private WebElement emailAddress;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="password-confirmation")
	private WebElement passwordConfirmation;
	
	@FindBy(xpath="(//span[text()='Create an Account']) [1]")
	private WebElement createAccountBtn;
	
	
	public CustomerAccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateAcountCreatePage() throws Throwable {
		 return action.isDisplayed(getDriver(), pageTitle);
	}
	
	public void createAccount(String fName, 
			String lName, 
			String email, 
			String pwd, 
			String confirmPwd
		) throws Throwable {
	
		action.type(firstName, fName);
		action.type(lastName, lName);
		action.explicitWait(getDriver(), emailAddress, 20);
		action.mouseOverElement(getDriver(),emailAddress);
		action.type(emailAddress, email);
		action.type(password, pwd);
		action.type(passwordConfirmation, confirmPwd);
		
	}
	
	public MyAccountPage validateRegistration() throws Throwable {
		action.mouseHoverByJavaScript(createAccountBtn);
		return new MyAccountPage();
	}
}
