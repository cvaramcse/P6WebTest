package com.p6.qa.pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.p6.qa.base.TestBase;


public class AdministrationPage extends TestBase{

	
	@FindBy(xpath = "//a[contains(text(),'Application Settings')]")
	WebElement appPrefLink;
	
	@FindBy(xpath = "//a[contains(text(),'User Administration')]")
	WebElement userAdminLink;
	
	
	AdministrationPage(){
		PageFactory.initElements(driver, this);
	}
	
	public UserAdministration clickOnUserAdministration() {
		userAdminLink.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return new UserAdministration();
	}
	
}
