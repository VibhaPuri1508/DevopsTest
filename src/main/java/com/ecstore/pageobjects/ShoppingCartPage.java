package com.ecstore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ecstore.base.BaseClass;
import com.ecstore.webdriveractions.WebActions;


public class ShoppingCartPage extends BaseClass{
	WebActions action = new WebActions();
	
	@FindBy(xpath="//td[@class='col price']//span[@class='price']")
	private WebElement price;
	
	@FindBy(xpath="//td[@class='col subtotal']//span[@class='price']")
	private WebElement subTotal;
	
	@FindBy(xpath="//span[text()='Proceed to Checkout']")
	private WebElement proceedToCheckOut;
	
	@FindBy(xpath="//tr[@class='grand totals']//span[@class='price']")
	private WebElement orderTotal;
	
	public ShoppingCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public Double getPrice() {
		String unitPrice1=price.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		Double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public Double getTotalPrice() {
		String totalPrice1= subTotal.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		Double finalTotalPrice=Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public Double getOrderTotal() {
		String totalPrice1= orderTotal.getText();
		String total=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		Double orderTotalPrice=Double.parseDouble(total);
		return orderTotalPrice/100;
	}
	
	public CheckoutShippingPage proceedToCheckOut() throws Throwable {
		action.click(getDriver(), proceedToCheckOut);
		return new CheckoutShippingPage();
	}
	

}
