package com.test.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.test.base.BaseTest;
import com.test.drivers.Driver;
import com.test.pages.ProductPage;
import com.test.reports.ExtentReport;
import com.test.utilities.ManageCookies;

@TestMethodOrder(OrderAnnotation.class)
public class TestCart extends BaseTest {

	final Logger testLogger = LogManager.getLogger(TestCart.class.getName());
	ProductPage product = new ProductPage();

	@Test
	@Order(1)
	@DisplayName("View Details test case")
	public void ViewDetailsTest() throws InterruptedException {

		ExtentReport.createTests("View Details Test");
		try {

			ManageCookies.addCookie();

			Driver.driver.get("https://www.saucedemo.com/inventory.html");
			testLogger.info("Navigated to Inventory Page");
			
			product.clickProductName();
			testLogger.info("Product name clicked");

			testLogger.info("Details Viewed");
			ExtentReport.test.pass("Details View Successful");
		} catch (Exception e) {

			ExtentReport.test.fail(e.toString());

		}

	}

	@Test
	@Order(2)
	@DisplayName("Add to cart test case")
	public void AddToCartTest() throws InterruptedException {

		ExtentReport.createTests("Add to Cart Test");

		try {
			product.clickAddToCartButton();
			testLogger.info("Product name clicked");

			testLogger.info("Added to cart");
			ExtentReport.test.pass("Add to cart Successful");

		} catch (Exception e) {

			ExtentReport.test.fail(e.toString());

		}

	}

	@Test
	@Order(3)
	@DisplayName("Verify cart test case")
	public void VerifyCartTest() throws InterruptedException {

		ExtentReport.createTests("Verify Cart Test");

		try {
			product.openCart();

			testLogger.info("Cart Icon clicked");

			Thread.sleep(3000);

			assertEquals(product.getCartItemName(), "Sauce Labs Backpack");

			testLogger.info("Verified cart");
			ExtentReport.test.pass("Add to cart Successful");

		} catch (Exception e) {

			ExtentReport.test.fail(e.toString());

		}

	}
	
	


}
