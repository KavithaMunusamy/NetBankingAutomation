**Project Title:**
Automation of web based internet banking features testing

**Motivation:**
Project is developed to refresh my automation skills in my career break adhering to coding standards and design framework.

**Design:**
1. Framework : Data Driven Framework where test data combinations and expected results are maintained in Excel dcoument.
2. Report and Logging: Extent reports are used to capture the failure test cases with screenshot. Logging are performed using log4j capturing debug and info level logs for debugging purpose.
3. Utility: Utility Modules contains resuable files like Properties files configuration, test reporting, Wait methods, Excel Utility(Apache POI) and other common functionalities.
4. Testing Framework: TestNG is used to efficiently use its annatation features in the test case and executing test scripts using testng.xml.
5. Test scripts : Test scripts are developed using Java 1.8 anf Selenium webdriver 3. Test cases and Pages are desgined seperately. Pages are defined using Page Object Model with page factory approach with 1:1 mapping of Page and Test class.
6. Build Tool: Maven is used to build the project using POM.xml and also add the project dependencies.
7. CI tool: The build is configured and run using Jenkins
8. Version Control System: The project is maintained in GitHub for versioning and updating the future changes.

**Features of the Project:**
1.	Project is developed for the website:http://www.demo.guru99.com/V4/
2.	Automated the following pages:
i.	Login
ii.	Add New Customer
iii.	 Edit Customer
3.	Handled both Positive and Negative test scenarios.
4.	The test datas and expected results are maintained in the excel document: /netBanking1/excel/netBanking.xlsx.
5.	The configurations like base URI, drivers, necessary folder paths are maintained in netBanking1\config\config.properties.
6.	Adhered to best practices of Java and selenium automation.








