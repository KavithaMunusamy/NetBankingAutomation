package com.netbanking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Class for Login Page Containing web elements locators using
 * PageFactory
 * @author Kavitha M
 *
 */
public class LoginPageObject {
	WebDriver driver;
	
	@CacheLookup
	@FindBy(name="uid" )
	WebElement userIdElement;
	
	@CacheLookup
	@FindBy(name="password")
	WebElement pwdElement;
	
	@CacheLookup
	@FindBy(name="btnLogin" )
	WebElement loginElement;
	
	@CacheLookup
	@FindBy(name="btnReset")
	WebElement resetElement;
	
	/**
	 * Constructor to obtain driver instance and initialise web elements
	 * @param driver
	 */
	public LoginPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Action method to set User Id
	 * @param userID
	 */
	public void setUserId(String userID) {
		userIdElement.sendKeys(userID);
		
	}
	
	/**
	 * Action method to set User password
	 * @param password
	 */
	public void setPwd(String password) {
		pwdElement.sendKeys(password);
		
	}
	
	/**
	 * Action method to click Submit button to login.
	 */
	public void clickLogin() {
		loginElement.click();
		
	}
	
	/**
	 * Action method to click reset button to clear the fields entered.
	 */
	public void clickReset() {
		resetElement.click();
		
	}
	
	

}
