package com.test.hybridtestapp;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.test.basesetup.BaseSetup;
import com.test.basesetup.ObjectCreation;

public class TestApp extends BaseSetup{

	@Parameters ({"deviceName","udid","appiumUrl"})
	@Test
	public void contextSwitching(String deviceName, String udid,String appiumUrl) throws Throwable {
		ObjectCreation initiateObject = null;
	    ExtentTest logger = null;
		
		try {  
			
			logger = reports.startTest("context switching", "context switching");
			initiateObject = new ObjectCreation(logger,deviceName,udid,appiumUrl);
			
		    
		}catch (Throwable t) {
			initiateObject.reportLib.extentFailureReport(initiateObject.reportLib.getFailureMesssage(t));
			throw t;
		}
		
		finally {
			reports.endTest(logger);
			initiateObject.generic.closeApplication();
			initiateObject.killObject();
		}
	}
}
