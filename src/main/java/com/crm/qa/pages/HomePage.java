package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	ContactsPage contactsPage;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);	
	}
	
	
	@FindBy(xpath ="//td[contains(text(),'User: JAYDEEP MORE ')]") WebElement userName;
	
	@FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[4]/a") WebElement contactPage;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]") WebElement newContactLink;
	
	
	public ContactsPage clickOnContactsPageLink()
	{	
		contactPage.click();
		return new ContactsPage();
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}

	public boolean verifyUserName()
	{
		return userName.isDisplayed();
	}
	
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(newContactLink).build().perform();
		newContactLink.click();
	}
}
