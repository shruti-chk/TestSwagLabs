package com.test.testcases;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.test.base.BaseTest;
import com.test.drivers.Driver;
import com.test.pages.LoginPage;
import com.test.pages.LogoutPage;
import com.test.reports.ExtentReport;
import com.test.utilities.ManageCookies;

public class TestLoginLogout extends BaseTest {

	final Logger testLogger = LogManager.getLogger(TestLoginLogout.class.getName());
	// System.setProperty("log4j.configurationFile","C:/Users/abanti/eclipse-workspace/test-project/src/test/resources/configfiles/log4j2-test.xml");

	@ParameterizedTest
	@MethodSource("com.test.utilities.TestDataProvider#provideLoginData")
	@DisplayName("Login test case")
	public void LoginTest(String userName, String password) throws InterruptedException {

		ExtentReport.createTests("Login Test");

		LoginPage login = new LoginPage();

		assertEquals("Swag Labs", Driver.driver.getTitle(), "Title check Failed!");

		login.enterUsername(userName);
		testLogger.info("Username Entered");
		login.enterPassword(password);
		testLogger.info("Password Entered");
		login.clickLoginButton();
		testLogger.info("Login Button Clicked");

		ManageCookies.saveCookie();

		testLogger.info("Login Successful");
		ExtentReport.test.pass("Login Successful");

	}

	@Test
	@DisplayName("Logout test case")
	public void LogoutTest() throws InterruptedException {

		ExtentReport.createTests("Logout Test");

		LogoutPage logout = new LogoutPage();

		logout.openNavigationMenu();
		testLogger.info("Navigation Menu Clicked");
		Thread.sleep(3000);
		logout.clickLogoutButton();
		testLogger.info("Logout Clicked");

		testLogger.info("Logout Successful");
		ExtentReport.test.pass("Logout Successful");

	}

}
