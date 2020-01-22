package com.p6.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.p6.qa.base.TestBase;

public class UserAdministration extends TestBase{

	@FindBy(xpath = "//div[contains(text(), 'User Administration')]")
	@CacheLookup
	WebElement userAdminText;
	
	@FindBy(xpath = "//button[@id='addUser']")
	@CacheLookup
	WebElement addBtn;
	
	@FindBy(xpath = "//input[@id='loginName']")
	@CacheLookup
	WebElement loginNameTxt;
	
	@FindBy(xpath = "//input[@id='personalName']")
	WebElement personalNameTxt;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordTxt;
	
	@FindBy(xpath = "//input[@id='confirmPassword']")
	WebElement confirmPasswordTxt;
	
	@FindBy(xpath = "//button[contains(@class,'btn-save')]")
	WebElement saveBtn;

	@FindBy(xpath = "//div//i[contains(@class,'pgbu-icon pgbu-icon-cog')]")
	WebElement gearIcon;
	
	@FindBy(xpath = "//a[contains(text(),'Delete')]")
	WebElement deleteBtn;
	
	@FindBy(xpath = "//button[contains(@class,'proceedModal')]")
	WebElement yesBtn;
	
	
	UserAdministration(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyUserAdministrationDisplayed() {
		return userAdminText.isDisplayed();
	}
	public boolean findUserByName(String name) {
		System.out.println("User name:" +name);
		WebElement userrow = driver.findElement(By.xpath("//td//div[contains(@class,'')][contains(text(),'"+name+"')]"));
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		userrow.click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return userrow.isDisplayed();
	}
	public void CreateUser(String userName, String perName, String pwd) {
		
		addBtn.click();
		
		loginNameTxt.sendKeys(userName);
		personalNameTxt.sendKeys(perName);
		passwordTxt.sendKeys(pwd);
		confirmPasswordTxt.sendKeys(pwd);
		
		saveBtn.click();
		
		driver.findElement(By.xpath("//button[contains(@class,'btn btn-action save-button unsaved')]")).click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	public boolean DeleteUser(String userName) {
		
		//CollapseControl();
		
		if(findUserByName(userName)) {
			
			/*
			 * TestUtil.ClickonSelectedRowInaGrid(userName);
			 * driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			 * 
			 * deleteBtn.click();
			 */
			
			driver.findElement(By.xpath("//td//div[contains(@class,'')][contains(text(),'"+userName+"')]")).sendKeys("{DEL}");
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			yesBtn.click();
		}
		return true;
		
	}
	public void CollapseControl() {
		driver.findElement(By.xpath("//a[@class='collapse-handle']")).click();
	}
	
}
