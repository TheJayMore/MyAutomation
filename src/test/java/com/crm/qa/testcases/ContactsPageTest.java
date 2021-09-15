package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("passward"));
		testUtil.switchToMainFrame();
		contactsPage = homePage.clickOnContactsPageLink();
	}
	
	
	@Test
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	@Test
	public void validateCreateNewContact()
	{
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.", "Rahul", "Shetty", "Wipro", "1880088009");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
