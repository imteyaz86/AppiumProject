package com.test.commonutils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

public class NegativeVerification extends com.test.basesetup.BaseSetup {
	
	String strValue;
	AndroidDriver driver = null;
	ExtentTest logger = null;
	WebDriverWait globalWait = null;
	Generic generic = null;
	
	public NegativeVerification(AndroidDriver driver, Generic generic, ExtentTest logger,WebDriverWait globalWait){
		this.driver = driver;
		this.generic = generic;
		this.logger = logger;
		this.globalWait = globalWait;
	}

	// ============================================================================================
	// FunctionName : element_notexist_utility
	// Description : To Check The Non-Existence Of A Web Element
	// Input Parameter : WebElement Element : WebElement Whose Existence Is To
	// Be Checked And ObjectDescription : Description Of The Object Whose
	// Existence Needs To Be Checked
	// Revision : 0.0 - ImteyazAhmad-11-30-2015
	// ============================================================================================
	public void elementNotExistUtility(String sheetName, String elementName, String objectDescription ) throws Exception, Error {
		WebElement element = null;
		try {

			element = generic.getElementWithNoDelay(sheetName, elementName);
			if (!(element == null)) {
			logger.log(LogStatus.FAIL,
						generic.changeColorUtility("Following Object", 1) + " " + objectDescription + " "
								+ generic.changeColorUtility(
										"Is Found On Application Screen And Hence Testing Is DisContinued", 1));
			
			Assert.fail(objectDescription + " - Element Exists"); }
		} catch (Exception | Error e) {
			if (e.toString().contains("NoSuchElementException")) {
					logger.log(LogStatus.PASS, "Following Object:" + " " + objectDescription + " "
							+ "Is Not Found On Application Screen And Hence We Can Continue With Testing");
			} else {
				throw (e);
			}

		}
	}
}
