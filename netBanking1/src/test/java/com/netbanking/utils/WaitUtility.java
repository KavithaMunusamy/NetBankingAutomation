package com.netbanking.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Utility Class having wait methods in a single place for reusability.
 * @author Kavitha M
 *
 */
public class WaitUtility {
	
	static WebDriverWait wait;
	
	/**
	 * Set driver implicit wait time. 
	 */
	public static void setImplicitWait(WebDriver driver, int waitTimeInSeconds) {
		driver.manage().timeouts().implicitlyWait(waitTimeInSeconds, TimeUnit.SECONDS);  
	}
	
	/**
	 * Waits till the alert pops up.
	 * @param driver
	 * @param waitTimeInSeconds
	 * @return
	 */
	public static Alert waitForAlert(WebDriver driver, int waitTimeInSeconds) {
		wait = new WebDriverWait(driver, 10);
		return (Alert) wait.until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * waits for the element until it is clickable
	 * @param driver
	 * @param waitTimeInSeconds
	 * @param element
	 * @return
	 */
	public static WebElement waitForClickableElement(WebDriver driver, int waitTimeInSeconds, WebElement element) {
		wait= new WebDriverWait(driver, 10);
		return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
