package com.netbanking.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.netbanking.constants.Constants;
import com.netbanking.tests.NetBanking;
/**
 * Test Listener class to generate report on the test events
 * using Extent Reports
 * @author Kavitha M
 *
 */
public class TestReporting extends TestListenerAdapter {
	
	public static final String AUTOMATION_TEST_REPORT = "Automation Test Report";
	public static final String INTERNET_BANKING_PROJECT = "Internet Banking Project";
	public static final String QA_ANALYST = "QA_ANALYST";
	public static final String USER = "user";
	public static final String QA = "QA";
	public static final String ENVIRONEMNT = "Environemnt";
	public static final String LOCALHOST = "localhost";
	public static final String HOST_NAME = "Host name";
	static String PROJECT_PATH = System.getProperty(Constants.USER_DIRECTORY);
	ExtentSparkReporter reporterFile;
	ExtentReports extent;
	ExtentTest reportLogger;
	String testResultName;
	
	/**
	 * Generates reports on start of the test
	 */
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat(Constants.YYYY_MM_DD_HH_MM_SS).format(new Date());
		String reportName=Constants.TEST_REPORT+timeStamp+Constants.HTML_EXTENSION;
		
		reporterFile= new ExtentSparkReporter(PROJECT_PATH+Constants.TEST_OUTPUT_FOLDER+reportName);
		
		extent = new ExtentReports();
		extent.attachReporter(reporterFile);
		extent.setSystemInfo(HOST_NAME,LOCALHOST);
		extent.setSystemInfo(ENVIRONEMNT,QA);
		extent.setSystemInfo(USER,QA_ANALYST);
		
		reporterFile.config().setDocumentTitle(INTERNET_BANKING_PROJECT);
		reporterFile.config().setReportName(AUTOMATION_TEST_REPORT);
		reporterFile.config().setTheme(Theme.DARK);
		
	}
	
	/**
	 * Generates reports on success of the test
	 */
	public void onTestSuccess(ITestResult testResult) {
		testResultName=testResult.getName();
		reportLogger= extent.createTest(testResultName);
		reportLogger.log(Status.PASS, MarkupHelper.createLabel(testResultName, ExtentColor.GREEN));
	}
	
	/**
	 * Generates reports on failure of the test and captures screenshot
	 */
	public void onTestFailure(ITestResult testResult) {
		
		testResultName=testResult.getName();
		reportLogger= extent.createTest(testResultName);
		reportLogger.log(Status.FAIL, MarkupHelper.createLabel(testResultName, ExtentColor.RED));
		
		 //Get driver from BaseTest and assign to local webdriver variable.
		ITestContext context = testResult.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute(Constants.WEB_DRIVER);
		
		//takes screenshot on failure of test method
		CommonUtility.takeScreenshot(driver, testResultName);
		String screenshotPath=PROJECT_PATH+ Constants.SCREENSHOT_FOLDER+testResultName+Constants.PNG_EXTENSION;
		File file = new File(screenshotPath);
		if(file.exists()) {
			try {
				//captures screenshot in the report if screenshot file exists
				reportLogger.fail("Screenshot is above:" + reportLogger.addScreenCaptureFromPath(screenshotPath));
			}catch (Exception e) {
				reportLogger.fail("Issue in getting error screenshot");
			}
		}else {
			reportLogger.info("file doesnt exist:" + screenshotPath);
		}
	}
	
	/**
	 * Generates reports when test is skipped
	 * @param testResult
	 */
	public void onTestSkip(ITestResult testResult) {
		testResultName=testResult.getName();
		reportLogger= extent.createTest(testResultName);
		reportLogger.log(Status.SKIP, MarkupHelper.createLabel(testResultName, ExtentColor.ORANGE));
	}
	
	/**
	 * Write the report to the output view of extent report on
	 * completion of test
	 */
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
	

}
