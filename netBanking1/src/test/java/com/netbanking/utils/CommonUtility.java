package com.netbanking.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.netbanking.constants.Constants;

/**
 * Utility Class having common reusable methodss
 * @author Kavitha M
 *
 */
public class CommonUtility {
	static String PROJECT_PATH = System.getProperty("user.dir");
	static Logger logger = LogManager.getLogger();
	
	/**
	 * takes screenshot of the browser screen
	 * 
	 * @param driver
	 * @param filePath
	 */
	 public static void takeScreenshot(WebDriver driver, String testName) {
		
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			//copies the screenshot to the given file with path
			FileUtils.copyFile(file, new File(PROJECT_PATH + Constants.SCREENSHOT_FOLDER + testName + Constants.PNG_EXTENSION));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 /**
	  * Checks and returns true if alert is present
	  * @param driver
	  * @return
	  */
	 public static boolean isAlertPresent(WebDriver driver) {
		boolean isAlert = false;
		Alert alertObj =null;
		try {
			//gets the error alert 
			alertObj = driver.switchTo().alert();
			logger.info("Alert Present."+alertObj.getText());
			alertObj.accept();
			isAlert=true;
		}catch(NoAlertPresentException e) {
			logger.info("No Alert");
		}
		return isAlert;
		}

}
