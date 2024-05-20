package com.test.pages;

import org.openqa.selenium.By;

import com.test.drivers.ActionDriver;
import com.test.drivers.Driver;

public class LoginPage extends ActionDriver{
	
	private final By username_textbox = By.id(Driver.loc.getProperty("userNameField"));
	private final By password_textbox = By.id(Driver.loc.getProperty("passwordField"));
	private final By login_button = By.id(Driver.loc.getProperty("loginButton"));
	
	public void enterUsername(String username) {
		sendKeys(username_textbox, username, "Username");
	}
	
	public void enterPassword(String password) {
		sendKeys(password_textbox, password, "Password");
	}
	
	public void clickLoginButton() {
		clickElement(login_button, "Login Button");
	}

}
