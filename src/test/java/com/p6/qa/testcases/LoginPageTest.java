package com.p6.qa.testcases;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.p6.qa.base.TestBase;
import com.p6.qa.pages.HomePage;
import com.p6.qa.pages.LoginPage;
import com.p6.qa.utils.TestUtil;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		Assert.assertEquals(loginPage.validateLoginPageTitle(), TestUtil.PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void p6LogoTest() {
		Assert.assertTrue(loginPage.validateP6Logo());
	}
	
	@Test(priority = 3)
	public void loginTest() {
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		//Assert.assertEquals(homePage.validatePageTitleTest(), TestUtil.DASHBOARD_PAGE_TITLE);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	

}
