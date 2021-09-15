package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]") WebElement contactsLable;
	
	@FindBy(name="first_name") WebElement firstName;
	@FindBy(name ="surname") WebElement lastName;
	@FindBy(name ="client_lookup") WebElement compName;
	@FindBy(id ="mobile") WebElement mobileNo;
	@FindBy(xpath = "//input[@value = 'Save' and tyep ='submit']") WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){
		return contactsLable.isDisplayed();
	}
	
	public void createNewContact(String Title, String fName, String lName,String cName, String mNo)
	{
		Select select = new Select(driver.findElement(By.name("title"))); 
		select.selectByVisibleText(Title);
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		compName.sendKeys(cName);
		mobileNo.sendKeys(mNo);
		saveBtn.click();
	}
	
	
	
}
