package com.test.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.test.base.BaseTest;
import com.test.drivers.Driver;
import com.test.pages.CheckoutPage;
import com.test.pages.ProductPage;
import com.test.reports.ExtentReport;
import com.test.utilities.ManageCookies;

@TestMethodOrder(OrderAnnotation.class)
public class TestCheckout extends BaseTest{
	
	final Logger testLogger = LogManager.getLogger(TestCheckout.class.getName());
	CheckoutPage checkout = new CheckoutPage();
	ProductPage product = new ProductPage();

	@Test
	@Order(1)
	@DisplayName("Add Product to Cart test case")
	public void VerifyCartTest() throws InterruptedException {

		ExtentReport.createTests("Add Product to Cart test case");

		try {
			ManageCookies.addCookie();
	
			Driver.driver.get("https://www.saucedemo.com/inventory.html");
			testLogger.info("Navigated to Inventory Page");
			
			product.clickProductName();
			testLogger.info("Product name clicked");
			
			product.clickAddToCartButton();
			testLogger.info("Product name clicked");
			product.openCart();
			testLogger.info("Cart Icon clicked");
			
		}catch(Exception e){
			ExtentReport.test.fail(e.toString());
		}

	}
	
	
	@ParameterizedTest
	@MethodSource("com.test.utilities.TestDataProvider#provideCheckoutData")
	@Order(2)
	@DisplayName("Checkout test case")
	public void CheckoutTest(String firstname, String lastname, String postcode) throws InterruptedException {

		ExtentReport.createTests("Checkout Test");
		try {

			checkout.clickCheckoutButton();
			testLogger.info("Checkout Button clicked");
			
			checkout.enterFirstName(firstname);
			checkout.enterLastName(lastname);
			checkout.enterPostCode(postcode);
			
			checkout.clickContinueButton();
			
			Driver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			assertEquals(product.getCartItemName(), "Sauce Labs Backpack");
			assertEquals(product.getCartItemPrice(), "$29.99");
			assertEquals(checkout.getTaxAmount(), "Tax: $2.40");
			assertEquals(checkout.getTotalAmount(), "Total: $32.39");
			
			checkout.clickFinishButton();
			assertEquals(checkout.getCheckoutHeader(), "Thank you for your order!");
			
			testLogger.info("Checkout Successful");
			ExtentReport.test.pass("Checkout Successful");
			
		} catch (Exception e) {

			ExtentReport.test.fail(e.toString());

		}

	}
	

}
