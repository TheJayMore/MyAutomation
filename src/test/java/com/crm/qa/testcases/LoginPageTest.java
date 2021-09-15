package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test
	public void testLoginPage()
	{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("passward"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
