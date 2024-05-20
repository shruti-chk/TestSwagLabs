package com.test.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public ExtentReport() {}
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void initReports() {

		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/reports/extentReport.html");
			extent.attachReporter(spark);
			System.out.println("Setup Report");
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("Test Swaglab Automation Report");
		}
	}
	
	public static void flushReports() {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
	}
	
	public static void createTests(String testCaseName) {
		test = extent.createTest(testCaseName);
	}

}
