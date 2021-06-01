package com.netbanking.tests;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IDataProviderMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netbanking.constants.Constants;
import com.netbanking.pages.CustomerPageObject;
import com.netbanking.utils.WaitUtility;

/**
 * Class to Test Add New Customer Page.
 * @author Kavitha M
 *
 */
public class AddNewCustomerTC002 extends NetBanking {
	CustomerPageObject newCustPageObj;
	
	/**
	 * Test method to add new customer which depends on login method and 
	 * has data provider to get customer data
	 * @param customerFieldsMap
	 */
	@Test(dependsOnGroups = {"LoginTC001.login"}, dataProvider = "newCustData")
	public void addNewCustomer(Map<String, String> customerFieldsMap) {
		logger.debug("Into Add New Customer Test Method");
		newCustPageObj = new CustomerPageObject(driver);
		
		//Clicks addCustomer link to move to Add Customer page
		newCustPageObj.clickAddCustLink();
		logger.info("Into New Customer Details Entry Page");
		//Enters the customer data in web page
		logger.debug("Getting Customer Test Data");
		setCustomerFields(customerFieldsMap);

		newCustPageObj.clickSubmit();
		
		//Validates the test based on the web page title
		assertEquals(customerFieldsMap.get(Constants.EXPECTED_OUTPUT), driver.getTitle());
		//try to add customer ID and name here
		logger.info("Customer is added successfully");

	}

	/**
	 * Test method to check error messages for invalid data 
	 * which depends on login method and 
	 * has data provider to get  invalid customer data
	 * @param customerFieldsMap
	 */
	@Test(dependsOnGroups = {"LoginTC001.login"}, dataProvider = "invalidCustData")
	public void invalidCustomerFields(Map<String, String> customerFieldsMap) {
		logger.debug("Into Invalid Customer Fields Test Method");
		newCustPageObj = new CustomerPageObject(driver);
		logger.debug("Web Page Title:" + driver.getTitle());
		
		newCustPageObj.clickAddCustLink();
		//resets before entering data for multiple tests
		newCustPageObj.clickReset();
		logger.info("Getting Customer Test Data");
		
		//Enters the customer data in web page
		setCustomerFields(customerFieldsMap);
		
		if (newCustPageObj.isNameInvalidVisible()) {
			logger.debug("Invalid text for Name is dsiplayed:" + newCustPageObj.getNameInvalidText());
			//compares the error message for invalid name
			assertEquals(newCustPageObj.getNameInvalidText(), customerFieldsMap.get(Constants.EXPECTED_OUTPUT));
		}
		if (newCustPageObj.isAddrInvalidVisible()) {
			logger.debug("Invalid text for Address is dsiplayed:" + newCustPageObj.getAddrInvalidText());
			//compares the error message for invalid address
			assertEquals(newCustPageObj.getAddrInvalidText(), customerFieldsMap.get(Constants.EXPECTED_OUTPUT));
		}
		newCustPageObj.clickSubmit();
		
		//waits for error alert message.
		Alert alert = WaitUtility.waitForAlert(driver, 10);
		logger.debug("Alert Message For the Invalid Csutomer Details:" + alert.getText());
		//Validates the test using alert text
		assertEquals(alert.getText(), customerFieldsMap.get(Constants.ALERT_TEXT));
		alert.accept();

	}

	/**
	 * gets the customer data from excel file for new customer creation
	 * 
	 * @return
	 */
	@DataProvider(name = "newCustData")
	public Iterator<Object[]> getCustDetails() {
		logger.debug("Into Data Provider:"+ IDataProviderMethod.class.getSimpleName());
		return getExcelDataAsIterObjArray(Constants.NEW_CUSTOMERS_SHEET);
	}
	
	/**
	 * gets the customer data from excel file for Invalid Customer Data
	 * 
	 * @return
	 */
	@DataProvider(name="invalidCustData")
	public Iterator<Object[]> getInvalidCustDetails() {
		return getExcelDataAsIterObjArray(Constants.INVALID_NEW_CUSTOMERS_SHEET);
	}
	
	/**
	 * Enters the customer fields in the web page
	 * @param customerFieldsMap
	 */
	private void setCustomerFields(Map<String, String> customerFieldsMap) {
		
		logger.debug("Into Set Customer Fields Class Method");
		logger.debug("entering customer data fields");
		newCustPageObj.setCustName(customerFieldsMap.get(Constants.NAME_FIELD));
		if (Constants.MALE_FIELD.equalsIgnoreCase(customerFieldsMap.get(Constants.GENDER_FIELD))) {
			newCustPageObj.selectMaleGender();
		} else {
			newCustPageObj.selectfemaleGender();
		}
		newCustPageObj.setDOB(customerFieldsMap.get(Constants.DATE_OF_BIRTH_FIELD));
		newCustPageObj.setAddress(customerFieldsMap.get(Constants.ADDRESS_FIELD));
		newCustPageObj.setCity(customerFieldsMap.get(Constants.CITY_FIELD));
		newCustPageObj.setState(customerFieldsMap.get(Constants.STATE_FIELD));
		newCustPageObj.setPinNo(customerFieldsMap.get(Constants.PIN_NO_FIELD));
		newCustPageObj.setTeleNo(customerFieldsMap.get(Constants.TELEPHONE_NO_FIELD));
		newCustPageObj.setEmailId(customerFieldsMap.get(Constants.EMAIL_ID_FIELD));
		newCustPageObj.setPwd(customerFieldsMap.get(Constants.PASSWORD_FIELD));
	}

}
