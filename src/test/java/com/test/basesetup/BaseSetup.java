package com.test.basesetup;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.test.commonutils.ReportLib;

/**
 * Purpose : This is a base class in which before suite and after suite
 * configuration is defined
 * 
 * @author iahmad
 *
 */
public class BaseSetup {
	public static ExtentReports reports;

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Throwable {
		try {
			reports = new ReportLib().extentReportsInstanceUtility();
		} catch (Throwable e) {
			 System.out.println("Error Occurred In Before Suite Configuration Is :" +e.toString());
			 
	}
		}

	@AfterSuite(alwaysRun = true)
	public void exitSetUp() throws Exception, Error {
		try {
			reports.flush();
			reports.close();

		} catch (Exception | Error e) {
			// System.out.println("Error Occurred In After Suite Configuration
			// Is :" +e.toString());
		}

	}
}