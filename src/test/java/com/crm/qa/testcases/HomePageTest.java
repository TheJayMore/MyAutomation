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

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String homePageTitle, userName;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage =new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("passward"));
	}
	
	@Test
	public void verifyHomePageTitleTest()
	{
		homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home Page Title Dosent Match");
	}
	
	@Test
	public void verifyUserNameTest()
	{
		testUtil.switchToMainFrame();
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test
	public void verifyContactsPageLink() throws InterruptedException
	{
		testUtil.switchToMainFrame();
		contactsPage = homePage.clickOnContactsPageLink();
		System.out.println(contactsPage);
		Thread.sleep(1000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
