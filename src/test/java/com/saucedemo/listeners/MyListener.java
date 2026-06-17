package com.saucedemo.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

	static ExtentReports extent;
	ExtentTest test;

	public void onStart(ITestContext context) {
		if (extent == null) {
			ExtentSparkReporter spark =
					new ExtentSparkReporter("reports/myReport.html");

			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
	}

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.pass("Test case PASSED is: " + result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		test.fail("Test case FAILED is: " + result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		test.skip("Test case SKIPPED is: " + result.getMethod().getMethodName());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}