package com.netbanking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Class for Add New Customer Page Containing web elements locators using
 * PageFactory.
 * 
 * @author Kavitha M
 *
 */
public class CustomerPageObject {

	WebDriver driver;

	@CacheLookup
	@FindBy(linkText = "New Customer")
	WebElement addCustLinkElement;

	@CacheLookup
	@FindBy(name = "name")
	WebElement custNameElement;

	@CacheLookup
	@FindBy(id = "message")
	WebElement invalidNameMsg;

	@CacheLookup
	@FindBy(xpath = "//input[@name=\"rad1\" and  @value=\"m\"]")
	WebElement genderMaleRadioElement;

	@CacheLookup
	@FindBy(xpath = "//input[@name=\"rad1\" and  @value=\"f\"]")
	WebElement genderfemaleRadioElement;

	@CacheLookup
	@FindBy(id = "dob")
	WebElement dobElement;

	@CacheLookup
	@FindBy(name = "addr")
	WebElement addressElement;

	@CacheLookup
	@FindBy(id = "message3")
	WebElement invalidAddrMsg;

	@CacheLookup
	@FindBy(name = "city")
	WebElement cityElement;

	@CacheLookup
	@FindBy(name = "state")
	WebElement stateElement;

	@CacheLookup
	@FindBy(name = "pinno")
	WebElement pinNoElement;

	@CacheLookup
	@FindBy(name = "telephoneno")
	WebElement teleNoElement;

	@CacheLookup
	@FindBy(name = "emailid")
	WebElement emailIdElement;

	@CacheLookup
	@FindBy(name = "password")
	WebElement pwdElement;

	@CacheLookup
	@FindBy(name = "sub")
	WebElement submitElement;

	@CacheLookup
	@FindBy(name = "res")
	WebElement resElement;

	/**
	 * Constructor to obtain driver instance and initialise webelements
	 * 
	 * @param driver
	 */
	public CustomerPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Action method to click Add Customer link
	 */
	public void clickAddCustLink() {
		addCustLinkElement.click();
	}

	/**
	 * Action method to set Customer Name
	 * @param custName
	 */
	public void setCustName(String custName) {
		custNameElement.sendKeys(custName);
	}

	/**
	 * Action method to check if error message for name is visible
	 * 
	 * @return
	 */
	public boolean isNameInvalidVisible() {
		return invalidNameMsg.isDisplayed();
	}

	/**
	 * Action method to get error message for name
	 * 
	 * @return
	 */
	public String getNameInvalidText() {
		return invalidNameMsg.getText();
	}

	/**
	 * Action method to select the radio button for male
	 */
	public void selectMaleGender() {
		genderMaleRadioElement.click();
	}

	/**
	 * Action method to select the radio button for female
	 */
	public void selectfemaleGender() {
		genderfemaleRadioElement.click();
	}

	/**
	 * Action method to set customer date of birth
	 * 
	 * @param dateOfBirth
	 */
	public void setDOB(String dateOfBirth) {
		dobElement.sendKeys(dateOfBirth);
	}

	/**
	 * Action method to set Customer Address
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		addressElement.sendKeys(address);
	}

	/**
	 * Action method to check if error message for Address is visible
	 * 
	 * @param address
	 */
	public boolean isAddrInvalidVisible() {
		return invalidAddrMsg.isDisplayed();
	}

	/**
	 * Action method to get error message for address
	 * 
	 * @return
	 */
	public String getAddrInvalidText() {
		return invalidAddrMsg.getText();
	}

	/**
	 * Action method to set Customer city
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		cityElement.sendKeys(city);
	}

	/**
	 * Action method to set Customer State
	 * 
	 * @param state
	 */
	public void setState(String state) {
		stateElement.sendKeys(state);
	}

	/**
	 * Action method to set Customer PinCode
	 * 
	 * @param pinNo
	 */
	public void setPinNo(String pinNo) {
		pinNoElement.sendKeys(pinNo);
	}

	/**
	 * Action method to set Customer telephone number
	 * 
	 * @param teleNo
	 */
	public void setTeleNo(String teleNo) {
		teleNoElement.sendKeys(teleNo);
	}

	/**
	 * Action method to set Customer Email Id
	 * 
	 * @param emailId
	 */
	public void setEmailId(String emailId) {
		emailIdElement.sendKeys(emailId);
	}

	/**
	 * Action method to set Customer password
	 * 
	 * @param pwd
	 */
	public void setPwd(String pwd) {
		pwdElement.sendKeys(pwd);
	}

	/**
	 * Action method to click Submit button once all the fields are entered.
	 */
	public void clickSubmit() {
		submitElement.click();
	}

	/**
	 * Action method to click reset button to clear the fields entered.
	 */
	public void clickReset() {
		resElement.click();
	}

}
