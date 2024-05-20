package com.test.pages;

import org.openqa.selenium.By;

import com.test.drivers.ActionDriver;
import com.test.drivers.Driver;

public class ProductPage extends ActionDriver{
	
	private final By product_name_link = By.id(Driver.loc.getProperty("itemNameLink"));
	private final By add_to_cart_button = By.id(Driver.loc.getProperty("addToCartButton"));
	private final By cart_icon = By.id(Driver.loc.getProperty("cartIcon"));
	private final By item_name = By.className(Driver.loc.getProperty("cart_item_name"));
	private final By item_price = By.className(Driver.loc.getProperty("cart_item_price"));
	
	public void clickProductName() {
		clickElement(product_name_link, "Product Name");
	}
	
	public void clickAddToCartButton() {
		clickElement(add_to_cart_button, "Add to cart Button");
	}
	
	public void openCart() {
		clickElement(cart_icon, "Cart Icon");
	}
	
	public String getCartItemName() {
		return getElementText(item_name, "Item name");
	}
	
	public String getCartItemPrice() {
		return getElementText(item_price, "Item price");
	}

}
