package com.api.liteners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ApiListeners implements ITestListener {

	public static final Logger logger = LogManager.getLogger(ApiListeners.class);
	@Override
	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " Started successfully");
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + "Test Passed");
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + "Test Failed");
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + "Test Skipped");
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Finished");
		ITestListener.super.onFinish(context);
	}
	
	

}
