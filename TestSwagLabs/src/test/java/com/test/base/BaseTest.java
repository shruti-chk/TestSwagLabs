package com.test.base;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


import com.test.drivers.Driver;
import com.test.reports.ExtentReport;
import com.test.testcases.TestLoginLogout;

public class BaseTest extends Driver{

	static Logger testLogger = LogManager.getLogger(TestLoginLogout.class.getName());

	@BeforeAll
	public static void setUp() throws IOException {
		ExtentReport.initReports();
		System.out.println("Setup");
		testLogger.info("Setup Successful");
		initDriver();
	}

	@AfterAll
	public static void tearDown() {
		closeDriver();
		System.out.println("Tear down Successful");
		testLogger.info("Teardown Successful");
		ExtentReport.flushReports();
	}

}
