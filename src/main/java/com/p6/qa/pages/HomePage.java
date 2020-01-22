package com.p6.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.p6.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
	@FindBy(xpath = "//span[contains(text(),'Welcome, admin')]")
	WebElement welcomeText;
	
	@FindBy(xpath = "//a[contains(text(), 'Dashboards')]")
	WebElement dashboardsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Portfolios')]")
	WebElement portfoliosLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Projects')]")
	WebElement projectsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Resources')]")
	WebElement resourcesLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Approvals')]")
	WebElement approvalsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Administration')]")
	WebElement adminLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public AdministrationPage clickOnAdministration() {
		adminLink.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return new AdministrationPage();
	}
	
	public ProjectsPage clickOnProjects() {
		projectsLink.click();
		return new ProjectsPage();
	}
	
	public ResourcesPage clickOnResources() {
		resourcesLink.click();
		return new ResourcesPage();
	}
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	public boolean verifyWelcomeText() {
		return welcomeText.isDisplayed();
	}
}
