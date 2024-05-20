package com.test.pages;

import org.openqa.selenium.By;

import com.test.drivers.ActionDriver;
import com.test.drivers.Driver;

public class CheckoutPage extends ActionDriver {
	
	private final By checkout_button = By.id(Driver.loc.getProperty("checkout_button"));
	private final By firstname_field = By.id(Driver.loc.getProperty("firstname_field"));
	private final By lastname_field = By.id(Driver.loc.getProperty("lastname_field"));
	private final By postcode_field = By.id(Driver.loc.getProperty("postcode_field"));
	private final By continue_button = By.id(Driver.loc.getProperty("continue_button"));
	private final By tax_amount = By.className(Driver.loc.getProperty("tax_amount"));
	private final By total_amount = By.className(Driver.loc.getProperty("total_amount"));
	private final By finish_button = By.id(Driver.loc.getProperty("finish_button"));
	private final By successful_header = By.className(Driver.loc.getProperty("checkout_successful_header"));
	
	public void clickCheckoutButton() {
		clickElement(checkout_button, "Checkout Button");
	}
	
	public void enterFirstName(String firstname) {
		sendKeys(firstname_field, firstname, "Firstname");
	}
	
	public void enterLastName(String lastName) {
		sendKeys(lastname_field, lastName, "Firstname");
	}
	
	
	public void enterPostCode(String postcode) {
		sendKeys(postcode_field, postcode, "Firstname");
	}
	
	public void clickContinueButton() {
		clickElement(continue_button, "Continue Button");
	}
	
	public String getTaxAmount() {
		return getElementText(tax_amount, "Tax Amount");
	}
	
	public String getTotalAmount() {
		return getElementText(total_amount, "Total Amount");
	}
	
	public void clickFinishButton() {
		clickElement(finish_button, "Finish Button");
	}
	
	public String getCheckoutHeader() {
		return getElementText(successful_header, "Successful Header");
	}

}
