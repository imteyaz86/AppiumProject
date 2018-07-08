package com.test.basesetup;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.test.commonutils.ExcelLib;
import com.test.commonutils.Generic;
import com.test.commonutils.Input;
import com.test.commonutils.Navigation;
import com.test.commonutils.NegativeVerification;
import com.test.commonutils.PropertyReader;
import com.test.commonutils.ReportLib;
import com.test.commonutils.ScreenShotCapture;
import com.test.commonutils.Verification;

import io.appium.java_client.android.AndroidDriver;

public class ObjectCreation {
	public AndroidDriver driver = null;
	public WebDriverWait globalWait = null;
	public  ExcelLib testDataExcel;
	public  ExcelLib webElementExcel;
	public Input input = null;
	public Generic generic = null;
	public Navigation navigation = null;
	public NegativeVerification negativeVerification = null;
	public Verification verification = null;
	public ReportLib reportLib = null;
	public PropertyReader properties = null;
	public ScreenShotCapture screenShotCapture = null;
	
	/*public ObjectCreation() throws Throwable  {
		properties = new PropertyReader("utilities.properties");
		driver = new InitiateDriver(properties ).getDriver();
	}*/
	
	public ObjectCreation(ExtentTest logger,String deviceName,String udid, String appiumUrl)
			throws Throwable {
		
		try {
		testDataExcel = new ExcelLib(
				System.getProperty("user.dir") + "/src/test/resources/sample/testData/TestData.xlsx");
		webElementExcel = new ExcelLib(
				System.getProperty("user.dir") + "/src/test/resources/sample/testData/WebElementData.xlsx");
		properties = new PropertyReader("utilities.properties");
		driver = new InitiateDriver(properties ,deviceName,udid,appiumUrl).getDriver();
		globalWait = new WebDriverWait(driver, Integer.valueOf(properties.getPropertyValue("GlobalWaitValue")).intValue());
		generic = new Generic(driver, logger,properties,webElementExcel,globalWait);
		screenShotCapture = new ScreenShotCapture(driver, generic, properties);
		negativeVerification = new NegativeVerification(driver, generic,logger,globalWait);
		verification = new Verification(driver, generic, logger,globalWait);
		navigation = new Navigation(driver, generic, logger,globalWait);
		input = new Input(driver, generic, verification, logger,globalWait);
		reportLib = new ReportLib(logger, screenShotCapture,generic);
		
		} catch (Throwable t) {
			System.out.println("Error Occurred In Object Creation Contructor Is: "+t.toString());
		}
	}
	
	public AndroidDriver getDriver() throws Throwable {
		return driver;
	}
	
	public void killObject() throws Throwable {
		input = null;
		generic = null;
		navigation = null;
		negativeVerification = null;
		verification = null;
		globalWait = null;
		driver = null;
		reportLib = null;
		properties = null;
	}

}
