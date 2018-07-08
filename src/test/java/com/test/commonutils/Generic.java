package com.test.commonutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JLabel;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

public class Generic extends com.test.basesetup.BaseSetup {

	int intRandomNum;
	String strGeneratedUcaseRandomString;
	String strAlertMessage;
	AndroidDriver driver = null;
	ExtentTest logger = null;
	WebDriverWait globalWait = null;
	PropertyReader properties = null;
	ExcelLib webElementExcel = null;
	final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public Generic() {

	}

	public Generic(AndroidDriver driver, ExtentTest logger, PropertyReader properties, ExcelLib webElementExcel,
			WebDriverWait globalWait) {
		this.driver = driver;
		this.logger = logger;
		this.properties = properties;
		this.webElementExcel = webElementExcel;
		this.globalWait = globalWait;
	}

	// ============================================================================================
	// FunctionName : current_dateinfo_utility
	// Description : To Retrieve The Current System Date in "yyyyMMdd"
	// Input Parameter : None
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public String currentDateInfoUtility() throws Exception, Error {
		String Strdated = null;
		try {
			DateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			Strdated = dateformat.format(date);

		} catch (Exception | Error e) {
			throw (e);
		}
		return Strdated;
	}

	// ============================================================================================
	// FunctionName : current_timeinfo_utility
	// Description : To Retrieve The Current System Time in "hhmmss" format
	// Input Parameter : None
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public String currentTimeInfoUtility() throws Exception, Error {
		String Strdated = null;
		try {
			DateFormat dateformat = new SimpleDateFormat("hhmmss");
			Date date = new Date();
			Strdated = dateformat.format(date);
		} catch (Exception | Error e) {
			throw (e);
		}
		return Strdated;
	}

	// ============================================================================================
	// FunctionName : random_intgeneration_utility
	// Description : To Generate A Random Number Based On The Maximum And
	// Minimum Integer Limit Provided
	// Input Parameter : IntMinRange, IntMaxRange Of The Type Integer To Specify
	// The Range Of The Generated Random Number
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public int random_intgeneration_utility(int intMinRange, int intMaxRange) throws Exception, Error {
		try {
			Random rand = new Random();
			intRandomNum = rand.nextInt((intMaxRange - intMinRange) + 1) + intMinRange;
		} catch (Exception | Error e) {
			throw (e);
		}
		return intRandomNum;
	}

	// ============================================================================================
	// FunctionName : random_stringgeneration_utility
	// Description : To Generate A Random String
	// Input Parameter : IntStringLength Of The Type Integer Which Specifies
	// Character Length Of The Generated Random String, AppendString Of Type
	// String Which Is Appended To The Generated Random String
	// Revision : 0.1 - ImteyazAhmad-13-10-2016 - Added Code To Append Any
	// String Provided By The User To The Generated Random String
	// : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public String random_stringgeneration_utility(int intStringLength, String appendString) throws Exception, Error {
		try {
			String GeneratedRandomString = RandomStringUtils.random(intStringLength, true, false);
			strGeneratedUcaseRandomString = GeneratedRandomString.toUpperCase();
			strGeneratedUcaseRandomString = appendString + strGeneratedUcaseRandomString;

		} catch (Exception | Error e) {
			throw (e);
		}
		return strGeneratedUcaseRandomString;
	}

	// ============================================================================================
	// FunctionName : changecolor_utility
	// Description : Changes Text Color, Parameter 1 Is For Red, 2 For Green, 3
	// For Blue, 4 For Orange
	// Input Parameter : None
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public String changeColorUtility(String text, int num) throws Exception, Error {
		String colouredText = null;
		JLabel label = new JLabel();
		try {
			switch (num) {
			case 1: // text color is changed to Red
				label.setText("<span style='color:red'><b>" + text + "</b></script></span>");
				colouredText = label.getText();
				break;
			case 2: // text color is changed to Green
				label.setText("<span style='color:green'><b>" + text + "</b></script></span>");
				colouredText = label.getText();
				break;
			case 3: // text color is changed to Blue
				label.setText("<span style='color:blue'><b>" + text + "</b></script></span>");
				colouredText = label.getText();
				break;
			case 4: // text color is changed to Orange
				label.setText("<span style='color:orange'><b>" + text + "</b></script></span>");
				colouredText = label.getText();
				break;
			}
		} catch (Exception | Error e) {
			throw (e);
		}
		return colouredText;
	}

	// ============================================================================================
	// FunctionName : getdata_fromdatabase_utility
	// Description : To Update,Delete,Match,Match Partially,Fetch Record From
	// DataBase
	// Input Parameter : Provide
	// DsnName,sqlQuery,OperationType,expectedvalue,ColumnName,logVal
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================

	public String getDataFromDataBaseUtility(String sqlQuery, String dataBaseName, String connectionString,
			String userName, String password, String operationType, String expectedvalue, String columnName)
			throws Exception, Error {
		Connection conn = null;
		try {
			ResultSet results;

			String value;
			int recordNumber;
			boolean found;
			found = false;
			// sqlQuery = sqlQuery.trim().toUpperCase();
			operationType = operationType.trim().toUpperCase();
			expectedvalue = expectedvalue.trim().toUpperCase();
			columnName = columnName.trim().toUpperCase();

			// Loading the required JDBC Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Creating a connection to the database
			conn = DriverManager.getConnection(connectionString, userName, password);
			if (conn == null) {
				logger.log(LogStatus.FAIL, changeColorUtility("The Connection To Database Is Not Established", 1));
			}
			Statement stat = conn.createStatement();
			switch (operationType) {
			case "UPDATE":

				recordNumber = stat.executeUpdate(sqlQuery);
				logger.log(LogStatus.PASS,
						"The Update Sql Query :" + " " + changeColorUtility(sqlQuery, 3) + ",  "
								+ "Is Executed Successfully On DataBase :" + " " + dataBaseName + ",  "
								+ "And Number Of Rows Updated Is :" + " "
								+ changeColorUtility(String.valueOf(recordNumber), 2));
				break;

			case "DELETE":

				recordNumber = stat.executeUpdate(sqlQuery);
				logger.log(LogStatus.PASS,
						"The Delete Sql Query :" + " " + changeColorUtility(sqlQuery, 3) + ",  "
								+ "Is Executed Successfully On DataBase :" + " " + dataBaseName + ",  "
								+ "And Number Of Rows Deleted Is :" + " "
								+ changeColorUtility(String.valueOf(recordNumber), 2));
				break;

			case "MATCH":

				results = stat.executeQuery(sqlQuery);
				if (results.next()) {
					do {
						value = results.getString(columnName);
						if (value.trim().equalsIgnoreCase(expectedvalue)) {
							logger.log(LogStatus.PASS, "The Sql Query :" + " " + changeColorUtility(sqlQuery, 3) + ",  "
									+ "Is Executed Successfully On Dsn :" + " " + dataBaseName + ",  "
									+ "And Expected value : " + " " + changeColorUtility(expectedvalue, 3) + ",  "
									+ "Is Matched With Actual value :" + " " + changeColorUtility(value, 2));
						}
						found = true;
						break;

					} while (results.next());

					if (found == false) {
						logger.log(LogStatus.FAIL,
								"The Sql Query :" + " " + changeColorUtility(sqlQuery, 3) + ",  "
										+ "Is Executed Successfully On Dsn :" + " " + dataBaseName + ",  "
										+ "But Expected value : " + " " + changeColorUtility(expectedvalue, 3) + "  "
										+ changeColorUtility(
												", Does Not Exists In ResultSet Hence Verification Can Not Be Done",
												1));
					}
				} else {
					logger.log(LogStatus.FAIL, "The Sql Query :" + " " + changeColorUtility(sqlQuery, 3) + ",  "
							+ "Is Executed Successfully On Dsn :" + " " + dataBaseName + ",  "
							+ changeColorUtility("But ResultSet Has No Record Hence Verification Can Not Be Done", 1));

				}

				break;

			case "MATCH PARTIALLY":

				results = stat.executeQuery(sqlQuery);
				if (results.next()) {
					do {
						value = results.getString(columnName);
						if (value.trim().toUpperCase().contains(expectedvalue)) {
							logger.log(LogStatus.PASS, "The Sql Query :" + " " + changeColorUtility(sqlQuery, 3) + ",  "
									+ "Is Executed Successfully On Dsn :" + " " + dataBaseName + ",  "
									+ "And Expected value : " + " " + changeColorUtility(expectedvalue, 3) + ",  "
									+ "Is Available In Actual value :" + " " + changeColorUtility(value, 2));

							found = true;
							break;
						}

					} while (results.next());

					if (found == false) {
						logger.log(LogStatus.FAIL,
								"The Sql Query :" + " " + changeColorUtility(sqlQuery, 3) + ",  "
										+ "Is Executed Successfully On Dsn :" + " " + dataBaseName + ",  "
										+ "But Expected value : " + " " + changeColorUtility(expectedvalue, 3) + "  "
										+ changeColorUtility(
												", Does Not Exists In ResultSet Hence Verification Can Not Be Done",
												1));

					}
				} else {
					logger.log(LogStatus.FAIL, "The Sql Query :" + " " + changeColorUtility(sqlQuery, 3) + ",  "
							+ "Is Executed Successfully On Dsn :" + " " + dataBaseName + ",  "
							+ changeColorUtility("But ResultSet Has No Record Hence Verification Can Not Be Done", 1));

				}
				break;

			case "FETCH":

				results = stat.executeQuery(sqlQuery);
				if (results.next()) {

					value = results.getString(columnName);
					logger.log(LogStatus.PASS,
							"The Sql Query :" + " " + changeColorUtility(sqlQuery, 3) + ",  "
									+ "Is Executed Successfully On DataBase :" + " " + dataBaseName + ",  "
									+ " And Fetched value Is :" + " " + changeColorUtility(value, 2));

					return value;
				}

				else {
					logger.log(LogStatus.INFO, "The Sql Query :" + " " + changeColorUtility(sqlQuery, 3) + ",  "
							+ "Is Executed Successfully On Dsn :" + " " + dataBaseName + ",  "
							+ changeColorUtility("But ResultSet Has No Record Hence value Can Not Be Fetched", 1));

				}
				break;

			case "MULTIPLEFETCH":

				results = stat.executeQuery(sqlQuery);
				value = "";
				while (results.next()) {
					if (value != "")
						value = value + "," + results.getInt(columnName);
					else
						value = Integer.toString(results.getInt(columnName));
				}
				if (value != "") {
					logger.log(LogStatus.PASS,
							"The Sql Query :" + " " + changeColorUtility(sqlQuery, 3) + ",  "
									+ "Is Executed Successfully On DataBase :" + " " + dataBaseName + ",  "
									+ " And Fetched value Is :" + " " + changeColorUtility(value, 2));

					return value;
				}

				else {
					logger.log(LogStatus.FAIL, "The Sql Query :" + " " + changeColorUtility(sqlQuery, 3) + ",  "
							+ "Is Executed Successfully On Dsn :" + " " + dataBaseName + ",  "
							+ changeColorUtility("But ResultSet Has No Record Hence value Can Not Be Fetched", 1));

				}
				break;

			case "MULTIPLEFETCHSTRING":
				results = stat.executeQuery(sqlQuery);
				value = "";
				while (results.next()) {
					if (value != "")
						value = value + "," + results.getString(columnName);
					else
						value = results.getString(columnName);
				}
				return value;

			}

		} catch (Exception | Error e) {
			logger.log(LogStatus.FAIL,
					"The Sql Query :" + " " + changeColorUtility(sqlQuery, 3) + ",  "
							+ "Is Not Executed Successfully, And Error Message Is : " + " "
							+ changeColorUtility(e.getMessage(), 1));

			throw (e);
		} finally {
			if (conn == null) {
			} else {
				conn.close();
			}
		}
		return null;
	}

	// ============================================================================================
	// FunctionName : getElement
	// Description : To Fetch the locator type and it's value from Excel file
	// Input Parameter : String Type of SheetName, ElementName
	// Author : Imteyaz Ahmad

	public WebElement getElement(String sheetName, String elementName) throws Exception, Error {

		try {

			WebElement Element = null;
			int customPoling;
			String LocatorType;
			String Locatorvalue;
			LocatorType = webElementExcel.excelStringFetchDataUtility(sheetName, elementName, "LocatorType");
			Locatorvalue = webElementExcel.excelStringFetchDataUtility(sheetName, elementName, "LocatorValue");
			Locatorvalue = Locatorvalue.trim();
			LocatorType = LocatorType.toUpperCase().trim(); // Convert the
															// Locator type
			customPoling = Integer.valueOf(properties.getPropertyValue("GetElementPoling"));
			loop: for (int i = 0; i <= Integer.valueOf(properties.getPropertyValue("GetElementLoopCounter")); i++) {
				try {

					switch (LocatorType) {

					case "XPATH": // Find the Element using Xpath
						Element = driver.findElement(By.xpath(Locatorvalue));
						break;

					case "ID": // Find the Element using ID
						Element = driver.findElement(By.id(Locatorvalue));
						break;

					case "NAME": // Find the Element using NAME
						Element = driver.findElement(By.name(Locatorvalue));
						break;

					case "CLASSNAME": // Find the Element using ClassName
						Element = driver.findElement(By.className(Locatorvalue));
						break;

					case "CSS": // Find the Element using CSS
						Element = driver.findElement(By.cssSelector(Locatorvalue));
						break;

					case "LINKTEXT": // Find the Element using LinkText
						Element = driver.findElement(By.linkText(Locatorvalue));
						break;

					case "PARTIALLINKTEXT": // // Find the Element using Partial
											// Link
						// text
						Element = driver.findElement(By.partialLinkText(Locatorvalue));
						break;

					case "TAGNAME": // Find the Element using Tag Name
						Element = driver.findElement(By.tagName(Locatorvalue));
						break;
					}

					if (Element.isDisplayed()) {
						// Thread.sleep(customPoling);
						break loop;
					} else {
						Thread.sleep(customPoling);
						continue;
					}

				} catch (NoSuchElementException | StaleElementReferenceException e) {
					Thread.sleep(customPoling);
					if (i < Integer.valueOf(properties.getPropertyValue("GetElementLoopCounter"))) {
						continue;
					} else if (i == Integer.valueOf(properties.getPropertyValue("GetElementLoopCounter"))) {
						throw e;
					}

				}
			}

			return Element;
		} catch (Exception | Error e) {

			throw (e);
		}

	}

	// ============================================================================================
	// FunctionName : getElements
	// Description : To Fetch the locator type and it's value from Excel file
	// Input Parameter : String Type of SheetName, ElementName
	// Author : Navneet Singhal

	public List<WebElement> getElements(String sheetName, String elementName) throws Exception, Error {

		try {
			List<WebElement> Element = null;
			String LocatorType;
			String Locatorvalue;
			LocatorType = webElementExcel.excelStringFetchDataUtility(sheetName, elementName, "LocatorType");
			Locatorvalue = webElementExcel.excelStringFetchDataUtility(sheetName, elementName, "LocatorValue");
			Locatorvalue = Locatorvalue.trim();
			LocatorType = LocatorType.toUpperCase().trim();
			// value into UpperCase
			switch (LocatorType) {

			case "XPATH": // Find the Element using Xpath
				Element = driver.findElements(By.xpath(Locatorvalue));
				break;

			case "ID": // Find the Element using ID
				Element = driver.findElements(By.id(Locatorvalue));
				break;

			case "NAME": // Find the Element using NAME
				Element = driver.findElements(By.name(Locatorvalue));
				break;

			case "CLASSNAME": // Find the Element using ClassName
				Element = driver.findElements(By.className(Locatorvalue));

				break;

			case "CSS": // Find the Element using CSS
				Element = driver.findElements(By.cssSelector(Locatorvalue));
				break;

			case "LINKTEXT": // Find the Element using LinkText
				Element = driver.findElements(By.linkText(Locatorvalue));
				break;

			case "PARTIALLINKTEXT": // // Find the Element using Partial Link
				// text
				Element = driver.findElements(By.partialLinkText(Locatorvalue));
				break;

			case "TAGNAME": // Find the Element using Tag Name
				Element = driver.findElements(By.tagName(Locatorvalue));
				break;
			}

			return Element;
		} catch (Exception | Error e) {

			throw (e);
		}
	}

	// ============================================================================================
	// FunctionName : random_intgeneration_utility
	// Description : To Generate A Random Number Based On Number of Digit
	// Minimum Integer Limit Provided
	// Input Parameter : num Of The Type Integer To Specify
	// The number of digit of The Generated Random Number
	// Revision : 0.0 - Sumit Huria-23-11-2016
	// ============================================================================================
	public int randomIntGenerationUtility(int num) throws Exception, Error {
		int RandomNum = 1;
		int temp = 1;
		try {
			Random rand = new Random();
			for (int i = 1; i <= num; i++) {
				temp = temp * 10;

			}
			RandomNum = rand.nextInt(temp);

		} catch (Exception | Error e) {
			throw e;
		}
		return RandomNum;
	}

	/**
	 * @author iahmad Summary this is a custom wait method , this will check
	 *         visibility of element with delay of 1 seconds with max attempt of
	 *         500 else loop will break
	 */
	public void customWait(String sheetName, String elementName) throws Exception, Error {
		boolean found = false;
		int customPoling;
		try {
			customPoling = Integer.valueOf(properties.getPropertyValue("CustomeWaitPoling"));
			WebElement Element = null;
			String LocatorType;
			String Locatorvalue;
			LocatorType = webElementExcel.excelStringFetchDataUtility(sheetName, elementName, "LocatorType");
			Locatorvalue = webElementExcel.excelStringFetchDataUtility(sheetName, elementName, "LocatorValue");
			Locatorvalue = Locatorvalue.trim();
			LocatorType = LocatorType.toUpperCase().trim(); // Convert the
															// Locator type
			// value into UpperCase
			loop: for (int i = 0; i < Integer.valueOf(properties.getPropertyValue("CustomWaitLoopCounter")); i++) {
				try {

					switch (LocatorType) {

					case "XPATH": // Find the Element using Xpath
						Element = driver.findElement(By.xpath(Locatorvalue));
						break;

					case "ID": // Find the Element using ID
						Element = driver.findElement(By.id(Locatorvalue));
						break;

					case "NAME": // Find the Element using NAME
						Element = driver.findElement(By.name(Locatorvalue));
						break;

					case "CLASSNAME": // Find the Element using ClassName
						Element = driver.findElement(By.className(Locatorvalue));
						break;

					case "CSS": // Find the Element using CSS
						Element = driver.findElement(By.cssSelector(Locatorvalue));
						break;

					case "LINKTEXT": // Find the Element using LinkText
						Element = driver.findElement(By.linkText(Locatorvalue));
						break;

					case "PARTIALLINKTEXT": // // Find the Element using Partial
											// Link
						// text
						Element = driver.findElement(By.partialLinkText(Locatorvalue));
						break;

					case "TAGNAME": // Find the Element using Tag Name
						Element = driver.findElement(By.tagName(Locatorvalue));
						break;
					}

					if (Element.isDisplayed()) {
						found = true;
					} else {
						found = false;
						Thread.sleep(customPoling);
						continue;
					}

				} catch (NoSuchElementException | StaleElementReferenceException e) {
					found = false;
					Thread.sleep(customPoling);
					continue;
				}
				if (found == true) {
					Thread.sleep(customPoling);
					break loop;
				}
			}

		} catch (Exception | Error e) {

			throw e;
		}

	}

	// ============================================================================================
	// FunctionName : getElementWithNoDelay
	// Description : To Fetch the locator type and it's value from Excel file
	// Input Parameter : String Type of SheetName, ElementName
	// Author : Sumit Huria

	public WebElement getElementWithNoDelay(String sheetName, String elementName) throws Exception, Error {

		try {
			WebElement Element = null;
			String LocatorType;
			String Locatorvalue;
			LocatorType = webElementExcel.excelStringFetchDataUtility(sheetName, elementName, "LocatorType");
			Locatorvalue = webElementExcel.excelStringFetchDataUtility(sheetName, elementName, "LocatorValue");
			Locatorvalue = Locatorvalue.trim();
			LocatorType = LocatorType.toUpperCase().trim(); // Convert the
															// Locator type
			// value into UpperCase
			switch (LocatorType) {

			case "XPATH": // Find the Element using Xpath
				Element = driver.findElement(By.xpath(Locatorvalue));
				break;

			case "ID": // Find the Element using ID
				Element = driver.findElement(By.id(Locatorvalue));
				break;

			case "NAME": // Find the Element using NAME
				Element = driver.findElement(By.name(Locatorvalue));
				break;

			case "CLASSNAME": // Find the Element using ClassName
				Element = driver.findElement(By.className(Locatorvalue));
				break;

			case "CSS": // Find the Element using CSS
				Element = driver.findElement(By.cssSelector(Locatorvalue));
				break;

			case "LINKTEXT": // Find the Element using LinkText
				Element = driver.findElement(By.linkText(Locatorvalue));
				break;

			case "PARTIALLINKTEXT": // // Find the Element using Partial Link
				// text
				Element = driver.findElement(By.partialLinkText(Locatorvalue));
				break;

			case "TAGNAME": // Find the Element using Tag Name
				Element = driver.findElement(By.tagName(Locatorvalue));
				break;
			}

			return Element;
		} catch (Exception | Error e) {

			throw (e);
		}
	}

	/**
	 * @author Imteyaz
	 * @Summary : This is used to kill driver instance
	 */
	public void closeApplication() throws Exception, Error {
		try {
			driver.closeApp();
			driver.quit();
		} catch (Exception | Error e) {
			throw (e);
		}
	}

	/**
	 * @param key
	 * @param This
	 *            is used to simulate android events
	 * @throws Throwable
	 */
	public void androidKeyBoardEvents(int key, String androidKeyCodeDes) throws Throwable {
		try {
			driver.pressKeyCode(key);
			logger.log(LogStatus.INFO, changeColorUtility(androidKeyCodeDes, 4) + "" + "Is Performed Successfully");
		} catch (Throwable t) {

		}
	}

	/**
	 * @author Imteyaz
	 * @Summary To bring particular element into view , applicable for non
	 *          native app
	 * @param el
	 * @throws Throwable
	 */
	public void scrollIntoView(String sheetName, String elementName) throws Throwable {
		try {
			JavascriptExecutor scriptExecutor = (JavascriptExecutor) driver;
			scriptExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(sheetName, elementName));

		} catch (Throwable t) {
			throw t;
		}
	}

	/**
	 * 
	 * Summary , to return By reference
	 */
	public By getByLocator(String sheetName, String elementName) throws Exception, Error {

		try {

			By locator = null;
			String LocatorType;
			String Locatorvalue;
			LocatorType = webElementExcel.excelStringFetchDataUtility(sheetName, elementName, "LocatorType");
			Locatorvalue = webElementExcel.excelStringFetchDataUtility(sheetName, elementName, "LocatorValue");
			Locatorvalue = Locatorvalue.trim();
			LocatorType = LocatorType.toUpperCase().trim(); // Convert the
															// Locator type

			switch (LocatorType) {

			case "XPATH": // Find the Element using Xpath
				locator = By.xpath(Locatorvalue);
				break;

			case "ID": // Find the Element using ID
				locator = By.id(Locatorvalue);
				break;

			case "NAME": // Find the Element using NAME
				locator = By.name(Locatorvalue);
				break;

			case "CLASSNAME": // Find the Element using ClassName
				locator = By.className(Locatorvalue);
				break;

			case "CSS": // Find the Element using CSS
				locator = By.cssSelector(Locatorvalue);
				break;

			case "LINKTEXT": // Find the Element using LinkText
				locator = By.linkText(Locatorvalue);
				break;

			case "PARTIALLINKTEXT": // // Find the Element using Partial
									// Link
				// text
				locator = By.partialLinkText(Locatorvalue);
				break;

			case "TAGNAME": // Find the Element using Tag Name
				locator = By.tagName(Locatorvalue);
				break;
			}

			return locator;
		} catch (Exception | Error e) {

			throw (e);
		}
	}

	
	
	/**
	 * @Summary : To Switch Mobile Context
	 */
	public void contextSwitching() throws Throwable {
		String currentContext;
		Set<String> contextHandles;
		try {
			currentContext = driver.getContext();
			contextHandles = driver.getContextHandles();
			for (String handle : contextHandles) {
				if (!handle.equalsIgnoreCase(currentContext)) {
					driver.context(handle);
					logger.log(LogStatus.INFO,
							"Context Is Switched From :" + " " + changeColorUtility(currentContext, 4) + " " + "To:"
									+ " " + changeColorUtility(handle, 4));
				}
			}
		} catch (Throwable t) {
			throw t;
		}
	}
	
	/**
	 *@Summary To sort the provided array
	 *Pass objectList of type generic ArrayList
	 */
	public  ArrayList sortOrder(ArrayList objectList, String sortingOrder) throws Throwable {
		try {

			switch (sortingOrder) {

			case "Ascending":
				Collections.sort(objectList);
				break;

			case "Descending":
				Collections.sort(objectList, Collections.reverseOrder());
				break;
			}
		} catch (Throwable t) {
			throw t;
		}
		return objectList;
	}
	
	/**
	 * To Validate Sort Order 
	 * Pass objectList of type generic ArrayList
	 */
	public  void validateSortOrder(ArrayList objectList, String sortedOrder) throws Throwable {
		ArrayList cloneObjectList;
		try {
			
			switch (sortedOrder) {
			case "Ascending" :
				cloneObjectList = (ArrayList) objectList.clone();
				Collections.sort(cloneObjectList);
				
				if (cloneObjectList.equals(objectList)) {
					logger.log(LogStatus.PASS, "The Given ArrayList "+" "+changeColorUtility(objectList.toString(),3)+" "+"Is In Ascending Order Hence Testing Can Be Continued");
				}
				
				else {
					logger.log(LogStatus.FAIL, "The Given ArrayList "+" "+changeColorUtility(objectList.toString(),3)+" "+"Is Not In Ascending Order Hence Testing Can Not Be Continued");	
				Assert.fail();
				}
				break;
				
			case "Descending" :
				cloneObjectList = (ArrayList) objectList.clone();
				Collections.sort(cloneObjectList,Collections.reverseOrder());
				
				if (cloneObjectList.equals(objectList)) {
					logger.log(LogStatus.PASS, "The Given ArrayList "+" "+changeColorUtility(objectList.toString(),3)+" "+"Is In Descending Order Hence Testing Can Be Continued");
				}
				
				else {
					logger.log(LogStatus.FAIL, "The Given ArrayList "+" "+changeColorUtility(objectList.toString(),3)+" "+"Is Not In Descending Order Hence Testing Can Not Be Continued");	
				Assert.fail();
				}
				break;
			}
			
		}catch (Throwable t) {
			throw t;
		}
	}
}
