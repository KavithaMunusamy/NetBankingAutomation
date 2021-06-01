package com.netbanking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.netbanking.utils.WaitUtility;

/**
 * Page Class for Login Page Containing web elements locators using
 * PageFactory
 * @author Kavitha M
 *
 */
public class EditCustomerPageObject {
	
	WebDriver driver;
	
	@CacheLookup
	@FindBy(linkText="Edit Customer")
	WebElement editCustLinkElement;
	
	@CacheLookup
	@FindBy(name="cusid")
	WebElement customerIDElement;
	
	@CacheLookup
	@FindBy(name="AccSubmit")
	WebElement submitElement;
	
	@CacheLookup
	@FindBy(name="res")
	WebElement resElement;
	
	@CacheLookup
	@FindBy(name="name")
	WebElement custNameElement;
	
	@CacheLookup
	@FindBy(name="gender")
	WebElement genderElement;
	
	@CacheLookup
	@FindBy(id="dob" )
	WebElement dobElement;
	
	@CacheLookup
	@FindBy(name="addr" )
	WebElement addressElement;
	
	@CacheLookup
	@FindBy(name="city" )
	WebElement cityElement;
	
	@CacheLookup
	@FindBy(name="state" )
	WebElement stateElement;
	
	@CacheLookup
	@FindBy(name="pinno" )
	WebElement pinNoElement;
	
	@CacheLookup
	@FindBy(name="telephoneno" )
	WebElement teleNoElement;
	
	@CacheLookup
	@FindBy(name="emailid" )
	WebElement emailIdElement;
	
	@CacheLookup
	@FindBy(name="sub")
	WebElement editSubmitElement;
	
	@CacheLookup
	@FindBy(name="res")
	WebElement editResstElement;
	
	@CacheLookup
	@FindBy(xpath= "//p[contains(text(),'Customer details updated Successfully!!!')]")
	WebElement UpdateSuccessEle;
	
	/**
	 * Constructor to obtain driver instance and initialise web elements
	 * @param driver
	 */
	public EditCustomerPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Action method to click Edit link to navigate to
	 * Edit Customer Page
	 */
	public void clickEditCustLink() {
		editCustLinkElement.click();
	}
	
	/**
	 * Action method to set Customer ID
	 * @param custName
	 */
	public void setCustId(String custName) {
		customerIDElement.sendKeys(custName);
	}
	
	/**
	 * Action method to click Edit button to navigate to
	 * Edit Customer Fields Page
	 */
	public void clickSubmit() {
		submitElement.click();
	}
	
	/**
	 * Action method to reset the customer Id entered 
	 */
	public void clickReset() {
		resElement.click();
	}
	
	/**
	 * Action method to set the gender
	 * @param gender
	 */
	public void setGender(String gender) {
		genderElement= WaitUtility.waitForClickableElement(driver, 0, genderElement);
		genderElement.clear();
		genderElement.sendKeys(gender);
	}
	
	/**
	 * Action method to set the Name
	 * @param custName
	 */
	public void setCustName(String custName) {
		custNameElement= WaitUtility.waitForClickableElement(driver, 0, custNameElement);
		custNameElement.clear();
		custNameElement.sendKeys(custName);
	}
	
	/**
	 * Action method to set the Customer Date of Birth
	 * @param dateOfBirth
	 */
	public void setDOB(String dateOfBirth) {
		dobElement= WaitUtility.waitForClickableElement(driver, 0, dobElement);
		dobElement.clear();
		dobElement.sendKeys(dateOfBirth);
	}
	
	/**
	 * Action method to set the Customer Address
	 * @param address
	 */
	public void setAddress(String address) {
		addressElement= WaitUtility.waitForClickableElement(driver, 0, addressElement);
		addressElement.clear();
		addressElement.sendKeys(address);
	}
	
	/**
	 * Action method to set the Customer City
	 * @param city
	 */
	public void setCity(String city) {
		cityElement= WaitUtility.waitForClickableElement(driver, 0, cityElement);
		cityElement.clear();
		cityElement.sendKeys(city);
	}
	
	/**
	 * Action method to set the Customer State
	 * @param state
	 */
	public void setState(String state) {
		stateElement= WaitUtility.waitForClickableElement(driver, 0, stateElement);
		stateElement.clear();
		stateElement.sendKeys(state);
	}
	
	/**
	 * Action method to set the Customer PinCode
	 * @param pinNo
	 */
	public void setPinNo(String pinNo) {
		pinNoElement= WaitUtility.waitForClickableElement(driver, 0, pinNoElement);
		pinNoElement.clear();
		pinNoElement.sendKeys(pinNo);
	}
	
	/**
	 * Action method to set the Customer Telephone Number
	 * @param teleNo
	 */
	public void setTeleNo(String teleNo) {
		teleNoElement= WaitUtility.waitForClickableElement(driver, 0, teleNoElement);
		teleNoElement.clear();
		teleNoElement.sendKeys(teleNo);
	}
	
	/**
	 * Action method to set the Customer Email ID
	 * @param emailId
	 */
	public void setEmailId(String emailId) {
		emailIdElement= WaitUtility.waitForClickableElement(driver, 0, emailIdElement);
		emailIdElement.clear();
		emailIdElement.sendKeys(emailId);
	}
	
	/**
	 * Action Method to click Edit Submit button
	 */
	public void clickEditSubmit() {
		editSubmitElement.click();
	}
	
	/**
	 * Action Method to click reset button to clear the fields entered 
	 */
	public void clickEditReset() {
		editResstElement.click();
	}
	
	/**
	 * Action method to check if update successful element present
	 * @return
	 */
	public boolean isUpdateSucessEle() {
		return UpdateSuccessEle.isDisplayed();
	}
	
	
	
	

}
