package com.p6.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.p6.qa.base.*;

public class DashboardPage extends TestBase{
	
	@FindBy(xpath = "//a[@title = 'Corporate']")
	WebElement corporateLink;
	
	@FindBy(xpath = "//a[@title = 'IT']")
	WebElement itLink;
	
	@FindBy(xpath = "//a[@title = 'Product R&D']")
	WebElement RandDLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Construction')]")
	WebElement constuctionLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Energy')]" )
	WebElement energyLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Manufacturing')]")
	WebElement manufacturingLink;
	
	@FindBy(xpath = "//a[contains(text(), 'WorkFlow')]")
	WebElement workFlowLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Strategic Programs')]")
	WebElement stgPrgmsLink;
	
	@FindBy(xpath = "//div[@id='pageTitle']")
	WebElement corpText;
	
	@FindBy(xpath = "//img[@id='mru_image_dashboards']")
	WebElement dashboardsDropDown;
	
	@FindBy(xpath = "//img[@id='selectPortfolioIcon']")
	WebElement portfolioSelector;
	
	@FindBy(xpath = "//a[@id='action_url_ManageDashboards']")
	WebElement manageDashboards;
	
	
	DashboardPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitleTest(){
		return driver.getTitle();
	}
	
	public void clickOnWorkFlow(){
		workFlowLink.click();
	}
	
	public void clickOnConstruction() {
		constuctionLink.click();
	}
}