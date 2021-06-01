package com.netbanking.tests;

import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.netbanking.constants.Constants;
import com.netbanking.utils.ExcelUtility;
import com.netbanking.utils.PropertiesConfiguration;
import com.netbanking.utils.WaitUtility;

/**
 * Base class for the test methods having common test functionalities required
 * for testing.
 * 
 * @author Kavitha M
 *
 */
public class NetBanking {

	static WebDriver driver = null;
	PropertiesConfiguration propConf = new PropertiesConfiguration("config.properties");
	static String PROJECT_PATH = System.getProperty("user.dir");
	Logger logger = LogManager.getLogger();

	/**
	 * sets browser driver based on the input
	 * 
	 * @param browser
	 */
	@Parameters("browser")
	@BeforeSuite
	public void setUp(String browser, ITestContext context) {

		// sets the driver reference to appropriate browser class based on input
		if (Constants.CHROME.equalsIgnoreCase(browser)) {
			System.setProperty(propConf.getChromeDriver(), PROJECT_PATH + propConf.getChromeDriverPath());
			driver = new ChromeDriver();
		} else if (Constants.FIREFOX.equalsIgnoreCase(browser)) {
			System.setProperty(propConf.getChromeDriver(), PROJECT_PATH + propConf.getChromeDriverPath());
			driver = new ChromeDriver();
		} else if (Constants.IE.equalsIgnoreCase(browser)) {
			System.setProperty(propConf.getChromeDriver(), PROJECT_PATH + propConf.getChromeDriverPath());
			driver = new ChromeDriver();
		}
		context.setAttribute("WebDriver", driver);
		WaitUtility.setImplicitWait(driver, 30);
		logger.debug("Browser configuration set to " + browser + " Driver");
	}

	/**
	 * test method for login to application
	 * 
	 * @param userName
	 * @param password
	 *//*
		 * @Parameters({"userName","password"})
		 * 
		 * @Test public void loginTC(String userName, String password){
		 * logger.debug("Into Login Test method"); driver.get(propConf.getBaseUrl());
		 * logger.info("Base url Launched"); LoginPageObject loginPageObj= new
		 * LoginPageObject(driver); loginPageObj.setUserId(userName);
		 * loginPageObj.setPwd(password);
		 * 
		 * loginPageObj.clickLogin(); logger.info("login successful for user: "+
		 * userName);
		 * 
		 * //Validates the login based on the webpage title assertEquals(
		 * propConf.getProperty(Constants.HOME_EXPECTED_TITLE),driver.getTitle()); }
		 */

	/**
	 * gets the customer details from excel file from new customer creation
	 * 
	 * @return
	 */
	@DataProvider(name = "getCustDetails")
	public Iterator<Object[]> getInvalidCustDetails(ITestContext context) {
		System.out.println("Receiving customer data");
		System.out.println(context.getCurrentXmlTest().getParameter("excel-sheet"));
		ExcelUtility excelUtilsObj = new ExcelUtility(PROJECT_PATH + propConf.getExcelPath(), "InvalidNewCustFields");
		Iterator<Object[]> customerDetails = excelUtilsObj.getExcelDataAsIterObjArray();
		System.out.println("Received customer data");
		return customerDetails;
	}

	/**
	 * method to retrieve data from excel given excel path and sheet name
	 * 
	 * @param sheetName
	 * @return
	 */
	protected Iterator<Object[]> getExcelDataAsIterObjArray(String sheetName) {
		logger.info("Retrieve  Test Data from Excel");
		ExcelUtility excelUtilsObj = new ExcelUtility(PROJECT_PATH + propConf.getExcelPath(), sheetName);
		Iterator<Object[]> excelDetails = excelUtilsObj.getExcelDataAsIterObjArray();
		return excelDetails;
	}

	/**
	 * method to retrieve data from excel given excel path and sheet name
	 * 
	 * @param sheetName
	 * @return
	 */
	protected Object[][] getExcelDataAsObjArray(String sheetName) {
		logger.info("Retrieve  Test Data from Excel");
		ExcelUtility excelUtilsObj = new ExcelUtility(PROJECT_PATH + propConf.getExcelPath(), sheetName);
		Object[][] excelDetails = excelUtilsObj.getExcelDataAsObjArray();
		return excelDetails;
	}

	/**
	 * closes the opened browsers
	 */
	@AfterSuite
	public void tearDown() {
		logger.info("Closing All Browsers");
		driver.quit();
	}

}
