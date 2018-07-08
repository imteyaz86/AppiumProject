package com.test.chromebrowsertest;

import java.util.ArrayList;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.test.basesetup.BaseSetup;
import com.test.basesetup.ObjectCreation;

public class ChromeTest2 extends BaseSetup {
	
	
	@Parameters ({"deviceName","udid","appiumUrl"})
	@Test
	public void udemyTestOnChrome(String deviceName, String udid,String appiumUrl) throws Throwable {
		ObjectCreation initiateObject = null;
	    ExtentTest logger = null;
		
		try {  
			logger = reports.startTest("Search Udemy Test", "Search Udemy Test");
			initiateObject = new ObjectCreation(logger,deviceName,udid,appiumUrl);
			
			ArrayList my = new ArrayList();
			my.add(10.5);
			my.add(100.8);
			my.add(2.5);
			
			initiateObject.generic.validateSortOrder(initiateObject.generic.sortOrder(my, "Descending"), "Descending");
		    
		    
		    
		
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
