package com.ecstore.webinterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface WebInterface {
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele);
	public void click(WebDriver ldriver, WebElement ele);
	public boolean isDisplayed(WebDriver ldriver, WebElement ele);
	public boolean type(WebElement ele, String text);
	public boolean findElement(WebDriver ldriver, WebElement ele);
	public boolean isSelected(WebDriver ldriver, WebElement ele);
	public boolean isEnabled(WebDriver ldriver, WebElement ele);
	public boolean selectBySendkeys(String value,WebElement ele);
	public boolean selectByIndex(WebElement element, int index);
	public boolean selectByValue(WebElement element,String value);
	public boolean selectByVisibleText(String visibletext, WebElement ele);
	public boolean mouseHoverByJavaScript(WebElement locator);
	public boolean javascriptButtonClick(WebDriver driver, WebElement ele);
	public boolean launchUrl(WebDriver driver,String url);
	public boolean isAlertPresent(WebDriver driver);
	public String getCurrentURL(WebDriver driver);
	public String getTitle(WebDriver driver);
	public boolean click1(WebElement locator, String locatorName);
	public void implicitWait(WebDriver driver, int timeOut);
	public void explicitWait(WebDriver driver, WebElement element, int timeOut);
	public void pageLoadTimeOut(WebDriver driver, int timeOut);
	public void screenShot(WebDriver driver, String filename);


}
