package com.netbanking.tests;
import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.testng.IDataProviderMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netbanking.constants.Constants;
import com.netbanking.pages.LoginPageObject;
import com.netbanking.utils.ExcelUtility;
import com.netbanking.utils.WaitUtility;


/**
 * Class to test login for NetBanking
 * @author Kavitha M
 *
 */
public class LoginTC001 extends NetBanking{
	LoginPageObject loginPageObj;
	
	/**
	 * Test to method to verify login page
	 * @param customerFieldsMap
	 */
	@Test(groups={"LoginTC001.login"}, dataProvider="userCredentialsData")
	public void login(Map<String, String> customerFieldsMap){
		String alertText=null;
		Alert alertObj=null;
		//launches the base url
		driver.get(propConf.getBaseUrl());
		logger.info("Base Url is launched");
		
		loginPageObj= new LoginPageObject(driver);
		//Sets the login credentials
		loginPageObj.setUserId(customerFieldsMap.get(Constants.USER_NAME_FIELD));
		loginPageObj.setPwd(customerFieldsMap.get(Constants.PASSWORD_FIELD));
		loginPageObj.clickLogin();
		
		try {
			alertObj = driver.switchTo().alert();
			//gets the error alert for invalid credentials
			alertText=alertObj.getText();
			logger.info("Alert Present. Invalid User - "+customerFieldsMap.get(Constants.USER_NAME_FIELD));
			alertObj.accept();
			assertEquals(customerFieldsMap.get(Constants.EXPECTED_OUTPUT), alertText);
			
		}catch(NoAlertPresentException e) {
			//Validates the login based on the web page title
			assertEquals( customerFieldsMap.get(Constants.EXPECTED_OUTPUT),driver.getTitle());
			logger.info("Login Successful");
		}
					
	}
	
	/**
	 * gets the user credentials from excel file
	 * @return
	 */
	@DataProvider(name="userCredentialsData")
	public Iterator<Object[]>   getUserCredentials() {
		return getExcelDataAsIterObjArray(Constants.LOGIN_SHEET);
	}
	
	
	
	

}
