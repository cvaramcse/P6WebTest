package com.p6.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.p6.qa.base.TestBase;
import com.p6.qa.pages.AdministrationPage;
import com.p6.qa.pages.HomePage;
import com.p6.qa.pages.LoginPage;
import com.p6.qa.pages.UserAdministration;
import com.p6.qa.utils.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	AdministrationPage adminPage;
	UserAdministration userAdminPage;
	
	HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 2)
	public void verifyHomePageTitleTest() {
		Assert.assertEquals(homePage.verifyHomePageTitle(), TestUtil.DASHBOARD_PAGE_TITLE, "Home Page title is not matched"); 
	}
	
	@Test(priority = 1)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyWelcomeText());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
