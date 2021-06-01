package com.netbanking.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.netbanking.constants.Constants;	

/**
 * Class to get the configuration from properties file
 * @author Kavitha M
 *
 */
public class PropertiesConfiguration {
	
	static Properties propFile;
	private static Logger logger = LogManager.getLogger(PropertiesConfiguration.class);
	
	/**
	 * Constructor to load the properties file
	 * @param fileName
	 */
	public PropertiesConfiguration(String fileName){
		File file = new File(Constants.CONFIG_PATH+fileName);
		try {
			FileInputStream inputStream = new FileInputStream(file);
			propFile = new Properties();
			propFile.load(inputStream);
			logger.info("file loaded successfully", this);
		} catch (FileNotFoundException e) {
			logger.error("unable to load properties file:" + e.getMessage(), e);
			
		} catch (IOException e) {
			logger.error("unable to load properties file:" + e.getMessage(), e);
		}
		
	}
	
	/**
	 * Gets the property value for given property name
	 * @param propertyName
	 * @return
	 */
	public  String getProperty(String propertyName) {
		return propFile.getProperty(propertyName);
	}
	
	/**
	 * Gets the base url from properties file
	 * @return
	 */
	public  String getBaseUrl() {
		return propFile.getProperty(Constants.BASE_URL);
	}
	
	/**
	 * Gets the GECKO DRIVER from properties file
	 * @return
	 */
	public String getGeckoDriver() {
		return propFile.getProperty(Constants.GECKO_DRIVER);
	}
	
	/**
	 * Gets the CHROME DRIVER from properties file
	 * @return
	 */
	public String getChromeDriver() {
		return propFile.getProperty(Constants.CHROME_DRIVER);
	}
	
	/**
	 * Gets the GECKO DRIVER PATH from properties file
	 * @return
	 */
	public  String getGeckoDriverPath() {
		return propFile.getProperty(Constants.GECKO_DRIVER_PATH);
	}
	
	/**
	 * Gets the CHROME DRIVER PATH from properties file
	 * @return
	 */
	public  String getChromeDriverPath() {
		return propFile.getProperty(Constants.CHROME_DRIVER_PATH);
	}
	
	/**
	 * Gets the Excel path from properties file
	 * @return
	 */
	public  String getExcelPath() {
		return propFile.getProperty(Constants.EXCEL_PATH);
	}
	
	

}
