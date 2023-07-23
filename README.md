# MyECStoreAutomationTesting

# Pre-requisites :

1. Install the latest versions of `Chrome` and `Firefox` browsers.

2. Install Eclipse IDE : https://www.eclipse.org/downloads/packages/

3. Install TestNG plugin in Eclipse 

# Automation framework details:
  * src: 
    * Core framework:  Here we kept the “BaseClass.java”, "WebActions.java" 
    * WebActions.java: Here we put the web driver methods that are used in helper files like: “isDisplayed()”, 
    “waitForElementPresent()”, “dragAndDrop()”, “sendKeys()” etc. Also it has method “byLocator()” to locate the page element by css, xpath, name, link or id.
    * BaseClass.java: Here we initialize the web driver drivers for the browsers.
    * Page Objects:  We have created one Pages file for each module and put small-2 methods in the same file. It also parses the contains element locator with @FindBy annotations 
      For example we created “LoginPage.java” file and defined “login()”, “createNewAccount()”  methods and called these functions in test scripts file wherever it is required. 
      This contains all the Pages files like Login.java, HomePage.java and several others with corresponding elements locators. These files extends “BaseClass.java” class, and have methods for each test steps 
    * Utilities: 
      * ExcelReaderLibrary.java contain methods to read data from excel sheets
      * ExtentManager.java desinged for detailed reports for your tests
      * Listeners.java customization of reports and logs
      * Log.java to config file for log4j
      * DataProviders.java for parameterization our test scipts
    * Test Scripts: This folder contains the actual test automation scripts files. In each of the file we used 
    corresponding page functions  
    * Resources:
     * Test Data: This folder contains excel file that contains test data of application
  * Configuration:  It has property file where we are defining user defined values i.e. application server URL, 
    user’s credentials  
  * Screenshots folder: This folder contains the screenshot of failure page, if the scripts fails a screenshot of 
    the failure page gets stored in “screenshot” folder.
  * Extent Report:  “/MyReport.html” folder is generated automatically once the execution is completed and has 
    the execution report in HTML format.
  * Log : This contains the execution log
  * Pom.xml file: This file is used by the build tool maven, Maven will build and run the automation tests and create 
    the html reports. This file also has all the dependencies of required libraries.
  * TestNg XMl files: It contains .xml files, these are configuration TestNG file, which has the classes’ name/methods 
    name which needs to be executed.

# Execution of Test scripts 
  * Right-click on the xml file and navigate to Run As >> TestNG Suite
