package com.p6.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.p6.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static String PAGE_TITLE = "Oracle Primavera P6 EPPM";
	public static String DASHBOARD_PAGE_TITLE = "Primavera P6 - Dashboards";
	
	public static String INPUT_FILE_PATH = "C:\\Users\\sinagire.ORADEV\\eclipse-workspace\\P6Web\\src\\main\\java\\com\\p6\\qa\\testdata\\CreateUsers.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	public static Object[][] getDataFromExcel(String sheetName) throws InvalidFormatException, IOException {
		
		FileInputStream file = null;
		try {
			file = new FileInputStream(INPUT_FILE_PATH);
		}
		catch(FileNotFoundException e) {
		
		}
		try {
			book = WorkbookFactory.create(file);
		}
		catch(IOException e) {
		}
		catch(InvalidFormatException e) {
		}
		
		
		sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		System.out.println("Row Count:" +sheet.getLastRowNum());
		System.out.println("Column count:" +sheet.getRow(0).getLastCellNum());
		for(int i=0;i<sheet.getLastRowNum();i++)
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
		
		return data;
		
	}
	public static void ClickonSelectedRowInaGrid(String columnName, String text) {
		
		System.out.println("In checkox");
		WebElement checkbox = driver.findElement(By.xpath("//td[@data-index = 'ActualName']//div[contains(text(),'admin')]//ancestor::td[@data-index = 'ActualName']//following-sibling::td[@data-index='TS_ONLY']//input[@type='checkbox']"));
		if(!checkbox.isSelected())
			checkbox.click();
		
				
		//td[@data-index = 'ActualName']//div[contains(text(),'admin')]//ancestor::td[@data-index = 'ActualName']//following-sibling::td[@data-index='TS_ONLY']//input[@type='checkbox']
		
		//driver.findElement(By.xpath("//div[contains(text(),'"+text+"')]/preceding-sibling::td/i[contains(@class,'pgbu-icon pgbu-icon-cog')")).click();

	}
	public String getCurrentTimeStamp() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyHHmmss");  
	    Date date = new Date();  
	    return formatter.format(date); 
	}
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	public int getRowCount(String xpath) {
		List<WebElement> rows = driver.findElements(By.xpath(xpath));
		return rows.size();
	
	}
	

}
