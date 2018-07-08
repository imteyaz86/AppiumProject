package com.test.commonutils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

public class Verification extends com.test.basesetup.BaseSetup {
	String returnValue;
    String strActualVal1;
	String strActualVal2;
	int intTableRowsCount;
	boolean flag = false;
	
	AndroidDriver driver = null;
	ExtentTest logger = null;
	WebDriverWait globalWait = null;
	Generic generic = null;
	
	public Verification(AndroidDriver driver, Generic generic, ExtentTest logger,WebDriverWait globalWait){
		this.driver = driver;
		this.generic = generic;
		this.logger = logger;
		this.globalWait = globalWait;
	}

	// ============================================================================================
	// FunctionName : elementexist_utility
	// Description : To Check The Existence Of A Web Element On The Web Page
	// Input Parameter : None
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public void elementExistUtility(WebElement element, String objectDescription)
			throws Exception, Error {
		try {
			Assert.assertTrue(element != null);
			if (element != null) {
					logger.log(LogStatus.PASS,
							"Following Object:" + " " + generic.changeColorUtility(objectDescription, 4) + " "
									+ "Is Found On Application Screen And Hence We Can Continue With Testing");
				
			} else {
					logger.log(LogStatus.FAIL,
							"Following Object:" + " " + generic.changeColorUtility(objectDescription, 4) + " "
									+ generic.changeColorUtility(
											"Is Not Found On Application Screen And Hence Testing Is DisContinued", 1));
				
			}
		} catch (Exception | Error e) {
			throw (e);
		}
	}

	// ============================================================================================
	// FunctionName : attributefetch_utility
	// Description : To Fetch The Value Of The Attribute Based On The WebElement
	// And Attribute To Fetch Provided By the User
	// Input Parameter : Element Of Type WebElement and AttributeToFetch Of Type
	// String
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public String attributeFetchUtility(WebElement element, String attributeToFetch) throws Exception, Error {// In

		try {
			returnValue = element.getAttribute(attributeToFetch);
		} catch (Exception | Error e) {
			throw (e);
		}
		return returnValue;
	}


	// ============================================================================================
	// FunctionName : enbdisbstateverify_utility
	// Description : To Verify The Enabled Or Disabled State Of The Given
	// Control
	// Input Parameter : Element: Web Element Whose State Is To Be Verified
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public void enableDisableStateVerifyUtility(WebElement element, String state, String controlName)
			throws Exception, Error {
		try {
			switch (state) {
			case "enable":
				if (element.isEnabled()) {
						logger.log(LogStatus.PASS,
								generic.changeColorUtility(controlName, 4) + " "
										+ "Is In Enabled State And Hence Enabled State Verification For" + " "
										+ generic.changeColorUtility(controlName, 4) + " " + "Is Successful");
					
				} else {
						logger.log(LogStatus.FAIL, generic.changeColorUtility(controlName, 4) + " "
								+ generic.changeColorUtility(
										"Is In Disabled State And Hence Enabled State Verification For", 1)
								+ " " + generic.changeColorUtility(controlName, 4) + " "
								+ generic.changeColorUtility("Is Unsuccessful", 1));
					}
				
				Assert.assertTrue(element.isEnabled());
				break;
			case "disable":
				if (!element.isEnabled()) {
						logger.log(LogStatus.PASS,
								generic.changeColorUtility(controlName, 4) + " "
										+ "Is In Disabled State And Hence Disabled State Verification For" + " "
										+ generic.changeColorUtility(controlName, 4) + " " + "Is Successful");
					
				} else {
						logger.log(LogStatus.FAIL, generic.changeColorUtility(controlName, 4) + " "
								+ generic.changeColorUtility(
										"Is In Enabled State And Hence Disabled State Verification For", 1)
								+ " " + generic.changeColorUtility(controlName, 4) + " "
								+ generic.changeColorUtility("Is Unsuccessful", 1));
					
				}
				Assert.assertFalse(element.isEnabled());
				break;

			}
		} catch (Exception | Error e) {
			throw (e);
		}
	}

	// ============================================================================================
	// FunctionName : selectdeselect_stateverification_utility
	// Description : To Verify The Selected Or DeSelected State Of The Given
	// Control
	// Input Parameter : Element: Web Element Whose State Is To Be Verified
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public void selectDeselectStateVerification(WebElement element, String state, String controlName
			) throws Exception, Error {
		try {
			switch (state) {
			case "select":
				if (element.isSelected()) {
						logger.log(LogStatus.PASS,
								generic.changeColorUtility(controlName, 4) + " "
										+ "Is In Selected State And Hence Selected State Verification For" + " "
										+ generic.changeColorUtility(controlName, 4) + " " + "Is Successful");
					
				} else {
						logger.log(LogStatus.FAIL,
								generic.changeColorUtility(controlName, 4) + " "
										+ generic.changeColorUtility(
												"Is In Deselected State And Hence Selected State Verification For", 1)
										+ " " + generic.changeColorUtility(controlName, 4) + " "
										+ generic.changeColorUtility("Is Unsuccessful", 1));
					
				}
				Assert.assertTrue(element.isSelected());
				break;
			case "deselect":
				if (!element.isSelected()) {
						logger.log(LogStatus.PASS,
								generic.changeColorUtility(controlName, 4) + " "
										+ "Is In DeSelected State And Hence Deselected State Verification For" + " "
										+ generic.changeColorUtility(controlName, 4) + " " + "Is Successful");
					
				} else {
						logger.log(LogStatus.FAIL,
								generic.changeColorUtility(controlName, 4) + " "
										+ generic.changeColorUtility(
												"Is In Selected State And Hence Deselected State Verification For", 1)
										+ " " + generic.changeColorUtility(controlName, 4) + " "
										+ generic.changeColorUtility("Is Unsuccessful", 1));
				}
				Assert.assertFalse(element.isSelected());
				break;

			}
		} catch (Exception | Error e) {
			throw (e);
		}
	}

	// ============================================================================================
	// FunctionName : objectdisplayverify_utility
	// Description : To Verify That Whether The Given Control Is Displayed Or
	// Not Displayed
	// Input Parameter : Element: Web Element Whose State Is To Be Verified
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public void objectDisplayVerifyUtility(WebElement element, String state, String controlName)
			throws Exception, Error {
		try {
			switch (state) {
			case "displayed":
				if (element.isDisplayed()) {
						logger.log(LogStatus.PASS,
								generic.changeColorUtility(controlName, 4) + " "
										+ "Is Displayed On Application Screen And Hence Displayed State Verification For"
										+ " " + generic.changeColorUtility(controlName, 4) + " " + "Is Successful");
					
				} else {
						logger.log(LogStatus.FAIL,
								generic.changeColorUtility(controlName, 4) + " "
										+ generic.changeColorUtility(
												"Is Not Displayed On Application Screen And Hence Displayed State Verification For",
												1)
										+ " " + generic.changeColorUtility(controlName, 4) + " "
										+ generic.changeColorUtility("Is Unsuccessful", 1));
				}
				Assert.assertTrue(element.isDisplayed());
				break;
			case "notdisplayed":
				if (!element.isDisplayed()) {
						logger.log(LogStatus.PASS,
								generic.changeColorUtility(controlName, 4) + " "
										+ "Is Not Displayed On Application Screen And Hence Not Displayed State Verification For"
										+ " " + generic.changeColorUtility(controlName, 4) + " " + "Is Successful");
					
				} else {
						logger.log(LogStatus.FAIL,
								generic.changeColorUtility(controlName, 4) + " "
										+ generic.changeColorUtility(
												"Is Not Displayed On Application Screen And Hence Not Displayed State Verification For",
												1)
										+ " " + generic.changeColorUtility(controlName, 4) + " "
										+ generic.changeColorUtility("Is Unsuccessful", 1));
					
				}
				Assert.assertFalse(element.isDisplayed());
				break;

			}
		} catch (Exception | Error e) {
			throw (e);
		}
	}

	// ============================================================================================
	// FunctionName : textcompare_utility
	// Description : To Compare Two String Values
	// Input Parameter : ExpectedString, ActualString Containing The Values Of
	// The Values To Be Compared And ObjjDesc Contains Comparison Description To
	// Be Passed In Log Statement
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public void textCompareUtility(String expectedString, String actualString, String objDesc)
			throws Exception, Error {
		try {
			String actualStringLabel;
			String expectedStringLabel;
			// Local Variable Declaration

			actualStringLabel = generic.changeColorUtility(actualString, 2);
			expectedStringLabel = generic.changeColorUtility(expectedString, 3);

			if (expectedString.equalsIgnoreCase(actualString)) {

					logger.log(LogStatus.PASS,
							"Expected Value" + " " + expectedStringLabel + " " + "And Actual Value" + " "
									+ actualStringLabel + " " + "Are Same And Hence" + " " + objDesc + " "
									+ "Verification Is Successful");

			} else {
					logger.log(LogStatus.FAIL,
							generic.changeColorUtility("Expected Value", 1) + " " + expectedStringLabel + " "
									+ generic.changeColorUtility("And Actual Value", 1) + " " + actualStringLabel + " "
									+ generic.changeColorUtility("Are Not Same And Hence", 1) + " " + objDesc + " "
									+ generic.changeColorUtility("Verification Is Not Successful", 1));
				
			}

			Assert.assertTrue(expectedString.equalsIgnoreCase(actualString));
		} catch (Exception | Error e) {
			throw (e);
		}
	}


	// ============================================================================================
	// FunctionName : partialtextverification_utility
	// Description : To Compare Two String Values
	// Input Parameter : ExpectedString, ActualString Containing The Values Of
	// The Values To Be Compared And ObjjDesc Contains Comparison Description To
	// Be Passed In Log Statement
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public void partialTextVerificationUtility(String expectedString, String actualString, String objDesc,
			int logVal) throws Exception, Error {
		try {
			String actualStringLabel;
			String expectedStringLabel;
			// Local Variable Declaration

			actualStringLabel = generic.changeColorUtility(actualString, 2);
			expectedStringLabel = generic.changeColorUtility(expectedString, 3);

			if (actualString.contains(expectedString)) {

					logger.log(LogStatus.PASS,
							"Expected Value" + " " + expectedStringLabel + " " + "Is Contained In Actual Value" + " "
									+ actualStringLabel + " " + "Hence" + " " + objDesc + " "
									+ "Partial Text Verification Is Successful");
			} else {
				logger.log(LogStatus.FAIL,
						generic.changeColorUtility("Expected Value", 1) + " " + expectedStringLabel + " "
								+ generic.changeColorUtility("Is Not Present Partially In Actual Value", 1) + " "
								+ actualStringLabel + " "
								+ generic.changeColorUtility("Hence Partial Text Verification Is Not Successful For ", 1)
								+ " " + objDesc);
			}
			Assert.assertTrue(actualString.contains(expectedString));
		} catch (Exception | Error e) {
			throw (e);
		}
	}
}
