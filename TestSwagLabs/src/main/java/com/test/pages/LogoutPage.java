package com.test.pages;

import org.openqa.selenium.By;

import com.test.drivers.ActionDriver;
import com.test.drivers.Driver;

public class LogoutPage extends ActionDriver{
	private final By navigation_menu_icon = By.id(Driver.loc.getProperty("navMenu"));
	private final By logout_button = By.id(Driver.loc.getProperty("logoutLink"));
	
	public void openNavigationMenu() {
		clickElement(navigation_menu_icon, "Navigation Menu");
	}
	
	public void clickLogoutButton() {
		clickElement(logout_button, "Logout Button");
	}
}
