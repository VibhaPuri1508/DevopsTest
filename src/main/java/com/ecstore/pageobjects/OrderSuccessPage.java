package com.ecstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecstore.base.BaseClass;
import com.ecstore.webdriveractions.WebActions;

public class OrderSuccessPage extends BaseClass{
	WebActions action = new WebActions();
	

	@FindBy(xpath="//span[text()='Thank you for your purchase!']")
	private WebElement confirmMessage ;
	
	public OrderSuccessPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateConfirmMessage() {
		action.explicitWait(getDriver(),  confirmMessage, 60);
		String confirmMsg=confirmMessage.getText();
		return confirmMsg;
	}

}
