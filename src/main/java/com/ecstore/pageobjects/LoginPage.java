package com.ecstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ecstore.base.BaseClass;
import com.ecstore.webdriveractions.WebActions;



public class LoginPage extends BaseClass {
	
	WebActions action = new WebActions();
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="pass")
	private WebElement password;

	@FindBy(id="send2")
	private WebElement signInBtn;
	
	@FindBy(xpath="//a[@class='action create primary']")
	private WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uname, String pswd) throws Throwable {
		action.scrollByVisibilityOfElement(getDriver(), userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.javascriptButtonClick(getDriver(), signInBtn);
		Thread.sleep(2000);
		//myAccountPage=);
		return new HomePage();
	}
	
	public CustomerAccountCreationPage createNewAccount() throws Throwable {
		action.click(getDriver(), createNewAccountBtn);
		return new CustomerAccountCreationPage();
	}

}
