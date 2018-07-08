package com.test.commonutils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

public class ScreenShotCapture {
     private AndroidDriver driver;
     private PropertyReader properties;
     private Generic generic;
	
	public ScreenShotCapture (AndroidDriver driver, Generic generic,PropertyReader properties ) {
		this.driver = driver;
		this.properties = properties;
		this.generic = generic;
	}

	// ============================================================================================
	// FunctionName : screenshot_capture_utility
	// Description : To Take Application ScreenShot On Failure And Store It In
	// Desired Path
	// Input Parameter : Instance Of The WebDriver Class 'Driver' And Name Of
	// The ScreenShot 'ScreenShotName'
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public String screenShotCaptureUtility()
			throws Exception, Error {
		
	    String destinationPath;
		String dtmCurrentDateInfo;
		String dtmCurrentTimeInfo;
		int position;
		dtmCurrentDateInfo = generic.currentDateInfoUtility();
		dtmCurrentTimeInfo = generic.currentTimeInfoUtility();

		try {
			TakesScreenshot screenShotCapture = (TakesScreenshot) driver;
			File fileSource = screenShotCapture.getScreenshotAs(OutputType.FILE);
			destinationPath = properties.getPropertyValue("FailureScreenShotLocation") +  "_"
					+  "_" + dtmCurrentDateInfo + "_" + dtmCurrentTimeInfo + ".jpg";
			File destinationLocation = new File(destinationPath);
			FileUtils.copyFile(fileSource, destinationLocation);
			FileUtils.forceDelete(fileSource);
			position = destinationPath.indexOf('/');
			destinationPath = destinationPath.substring(position);
			destinationPath = ".." + destinationPath;

		} catch (Exception | Error e) {
			throw (e);
		}
		return destinationPath;
	}
}
