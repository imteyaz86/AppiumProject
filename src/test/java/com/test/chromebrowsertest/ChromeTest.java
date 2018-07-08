package com.test.chromebrowsertest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.basesetup.BaseSetup;
import com.test.basesetup.ObjectCreation;

public class ChromeTest extends BaseSetup {
	
	@Parameters ({"deviceName","udid","appiumUrl"})
	@Test
	public void udemyTestOnChrome(String deviceName, String udid,String appiumUrl) throws Throwable {
		ObjectCreation initiateObject = null;
	    ExtentTest logger = null;
		
		try {  
			logger = reports.startTest("Search Udemy Test", "Search Udemy Test");
			initiateObject = new ObjectCreation(logger,deviceName,udid,appiumUrl);
			
		    logger.log(LogStatus.INFO, logger.addScreenCapture(initiateObject.screenShotCapture.screenShotCaptureUtility()));
		    
		    initiateObject.globalWait.until(ExpectedConditions.visibilityOfElementLocated(initiateObject.generic.getByLocator("UdemyBrowser", "UdemyHome_Search_Txt")));
		    initiateObject.input.setValueUtility(initiateObject.generic.getElement("UdemyBrowser", "UdemyHome_Search_Txt"), "Search TextBox On Udemy Home Page", "Soap UI By Rahul");;
		    initiateObject.navigation.click(initiateObject.generic.getElement("UdemyBrowser", "UdemyHome_Search_Btn"), "Search Button On Udemy Home Page");
		    initiateObject.navigation.webPartialLinkSelect("WebServices/REST API Testing with SoapUI+ Real Time Projects", "");
		   
		    
		    
		    
		    
		
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
