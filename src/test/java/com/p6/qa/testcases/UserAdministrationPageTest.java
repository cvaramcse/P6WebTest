package com.p6.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.p6.qa.base.TestBase;
import com.p6.qa.pages.AdministrationPage;
import com.p6.qa.pages.HomePage;
import com.p6.qa.pages.LoginPage;
import com.p6.qa.pages.UserAdministration;
import com.p6.qa.utils.TestUtil;

public class UserAdministrationPageTest extends TestBase{
	
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	AdministrationPage adminPage;
	UserAdministration userAdminPage;
	TestUtil util = new TestUtil();
	
	Logger log = Logger.getLogger(UserAdministrationPageTest.class);
	
	UserAdministrationPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		log.info("Initialization");
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//@Test(priority = 1)
	public void verifyAdministrationLabelText() {
		adminPage = homePage.clickOnAdministration();
		userAdminPage = adminPage.clickOnUserAdministration();

		Assert.assertTrue(userAdminPage.verifyUserAdministrationDisplayed());
	}
	
	//@Test(priority = 2)
	public void verifyUsersTest() throws InterruptedException {
		adminPage = homePage.clickOnAdministration();
		userAdminPage = adminPage.clickOnUserAdministration();

		Assert.assertTrue(userAdminPage.verifyUserAdministrationDisplayed());
		Assert.assertTrue(userAdminPage.findUserByName("rams"));
	}
	
	//@DataProvider
	public Object[][] getTestData() throws InvalidFormatException, IOException {
		Object[][] data = TestUtil.getDataFromExcel("Users");
		return data;
	}
	
	//@Test(priority = 3, dataProvider="getTestData")
	public void verifyAddUserTest(String username, String personalname, String pwd){
		adminPage = homePage.clickOnAdministration();
		userAdminPage = adminPage.clickOnUserAdministration();	
		
		String tmstp = util.getCurrentTimeStamp();
		String user = username+tmstp;
		
		/*
		 * if(userAdminPage.DeleteUser(username)){ userAdminPage.CreateUser(username,
		 * personalname, pwd); }
		 */
		
		userAdminPage.CreateUser(user, personalname, pwd);
		
		//Assert.assertTrue(userAdminPage.findUserByName(user));
		 
	}
	
	//@Test
	public void verifyClickOnTimeSheetCheckboxTest() throws InterruptedException{
		adminPage = homePage.clickOnAdministration();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		userAdminPage = adminPage.clickOnUserAdministration();
		
		Thread.sleep(3000);
		TestUtil.ClickonSelectedRowInaGrid("TimeSheet", "admin"); 
	}
	
	@Test
	public void verifyRowCountTest() throws InterruptedException {
		adminPage = homePage.clickOnAdministration();
		userAdminPage = adminPage.clickOnUserAdministration();
		
		Thread.sleep(3000);
		
		int rowCount = util.getRowCount("//table[@class='pgbu-grid']//thead[@role='presentation']//tr");
		System.out.println("Row count:" +rowCount);
	}
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	

}
