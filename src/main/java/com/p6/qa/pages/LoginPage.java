package com.p6.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.p6.qa.base.*;

public class LoginPage extends TestBase{
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[@id='login']")
	WebElement loginBtn;
	
	@FindBy(id = "advancedOptionsToggle")
	WebElement advancedToggle;
	
	@FindBy(xpath = "//img[@class='primavera-logo']")
	WebElement  p6Logo;
	
	@FindBy(id = "databaseId")
	WebElement dbCmbBox;
	
	@FindBy(id = "languageCode")
	WebElement langCmbBox;
	
	@FindBy(xpath = "//label[contains(text(),'Database')]")
	WebElement dbText;
	
	@FindBy(xpath = "//label[contains(text(),'Language')]")
	WebElement langText;
	
	//Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean validateP6Logo() {
		return p6Logo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		loginBtn.click();
		
		return new HomePage();
	}
}
