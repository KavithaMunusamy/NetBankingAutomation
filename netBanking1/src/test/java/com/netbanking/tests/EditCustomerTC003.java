package com.netbanking.tests;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netbanking.constants.Constants;
import com.netbanking.pages.EditCustomerPageObject;
import com.netbanking.utils.CommonUtility;

import junit.framework.Assert;

/**
 * Class to test Edit Customer Page.
 * @author Kavitha M
 *
 */
public class EditCustomerTC003 extends NetBanking{
	EditCustomerPageObject editCustPage;
	
	/**
	 * Test method to edit customer data
	 * @param customerId
	 */
	@Test(dependsOnGroups = {"LoginTC001.login"}, dataProvider = "editCustData")
	public void editCustomer(Map<String, String> customerFieldsMap) {
		String customerId= customerFieldsMap.get(Constants.CUSTOMER_ID_FIELD);
		logger.info("Edit Customer Data for:"+customerId);
		editCustPage= new EditCustomerPageObject(driver);
		
		editCustPage.clickEditCustLink();
		editCustPage.setCustId(customerId);
		//Click submit button to get the edit page of Customer
		editCustPage.clickSubmit();
		if(!CommonUtility.isAlertPresent(driver)) {
			logger.debug("In Web Page:"+driver.getTitle());
			updateCustomerFields(customerFieldsMap);
			editCustPage.clickEditSubmit();
			if(!CommonUtility.isAlertPresent(driver)) {
				assertEquals(true, editCustPage.isUpdateSucessEle());
			}else {
				Assert.fail(customerId + ":"+ customerFieldsMap.get(Constants.ALERT_TEXT));
			}
		}else {
			logger.info(customerId +" : Customer does not exist");
			Assert.fail(customerId + ":"+ customerFieldsMap.get(Constants.ALERT_TEXT1));
		}
		logger.info("Customer data updated for: "+customerId);
	}

	/**
	 * Class method to enter customer fields to edit
	 * @param customerFieldsMap
	 */
	private void updateCustomerFields(Map<String, String> customerFieldsMap) {
		editCustPage= new EditCustomerPageObject(driver);
		
		//iterates to get the customer fields to be edited
		customerFieldsMap.forEach(
				(field, value) ->{
					logger.info(field + ":"+ value + " to be edited");
				//checks which field to be updated and routes to corresponding case block	
				switch (field) {
				case "name":
					editCustPage.setCustName(value);
					break;
				case "gender":
					editCustPage.setGender(value);
					break;
				case "dateOfBirth":
					editCustPage.setDOB(value);
					break;
				case "address":
					editCustPage.setAddress(value);
					break;
				case "city":
					editCustPage.setCity(value);
					break;
				case "state":
					editCustPage.setState(value);
					break;
				case "pinNo":
					editCustPage.setPinNo(value);
					break;
				case "telephoneNo":
					editCustPage.setTeleNo(value);
					break;
				case "emailId":
					editCustPage.setEmailId(value);
					break;
				}
				}
		);
		
		
	}
	
	/**
	 * gets the customer details from excel file from new customer creation
	 * @return
	 */
	@DataProvider(name="editCustData")
	public Iterator<Object[]> getCustDetails() {
		return getExcelDataAsIterObjArray(Constants.EDIT_CUSTOMERS_SHEET);
	}

}
