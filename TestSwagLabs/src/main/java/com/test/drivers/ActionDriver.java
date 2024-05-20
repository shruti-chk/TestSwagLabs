package com.test.drivers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.reports.ExtentReport;

public class ActionDriver extends Driver{
	
	// Declaration of explicit wait
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	
	public void sendKeys(By element, String valueToSend, String fieldName) {
		try {
			// wait for the element to be visible and the perform action
			WebElement webelement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			webelement.sendKeys(valueToSend);
			
			// report the passing 
			ExtentReport.test.pass("Value entered on "+fieldName+" is Successful");
		}
		catch(Exception e){
			// report the failing 
			ExtentReport.test.fail("Value entered on "+fieldName+" failed due to exception"+e);
			
		}
		
	}
	
	public void clickElement(By element, String fieldName) {
		try {
			// wait for the element to be clickable and the perform action
			WebElement webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
			webelement.click();
			ExtentReport.test.pass(fieldName+" clicked successfully");
		}
		catch(Exception e){
			ExtentReport.test.fail("Click faied on "+fieldName+" due to exception"+e);
			
		}
		
	}
	
	public String getElementText(By element, String fieldName) {
		try {
			String text = driver.findElement(element).getText();
			ExtentReport.test.pass("Text fetched from "+fieldName+" successfully");
			return text;
		}
		catch(Exception e){
			ExtentReport.test.fail("Text fetching from "+fieldName+" failed due to exception"+e);
			return null;
		}
		
		
	}

}
