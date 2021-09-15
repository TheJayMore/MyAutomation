package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory or Object repository
	
	@FindBy(name = "username") WebElement username;
	@FindBy(name = "password") WebElement passward;
	@FindBy(xpath = "//input[@type ='submit']") WebElement loginBtn;
	@FindBy(xpath="//button[contains(text(),'Sign Up')]") WebElement signUpBtn;
	
	//initializing he page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public HomePage login(String uName, String pass)
	{
		username.sendKeys(uName);
		passward.sendKeys(pass);
		loginBtn.click();
		return new HomePage();
	}
}
