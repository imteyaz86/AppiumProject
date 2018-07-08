package com.test.commonutils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportLib {

	ExtentTest logger = null;
	ScreenShotCapture screenShotCapture = null;
	PropertyReader properties = null;
	Generic generic = null;

	public ReportLib() {
	}

	public ReportLib(ExtentTest logger, ScreenShotCapture screenShotCapture, Generic generic) {
		this.logger = logger;
		this.screenShotCapture = screenShotCapture;
		this.generic = generic;
	}

	// ============================================================================================
	// FunctionName : ExtentReportsInstance_Utility
	// Description : To Generate Test Case Execution Report Using Extent Report
	// Reporting FrameWork And Store It In Desired Path
	// Input Parameter : IntRowNumber Of The Type Integer
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public ExtentReports extentReportsInstanceUtility() throws Throwable {
		ExtentReports extent;
		try {
			String extentReportsLocation;
			String extentReportHtmlName;
			String dtmCurrentTimeInfo;
			String dtmCurrentDateInfo;

			// Current Date Is Generated
			DateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			dtmCurrentDateInfo = dateformat.format(date);
			// Current Time Is Generated
			DateFormat timeformat = new SimpleDateFormat("hhmmss");
			dtmCurrentTimeInfo = timeformat.format(date);

			properties = new PropertyReader("utilities.properties");
			extentReportHtmlName = properties.getPropertyValue("ExtentReportsHtmlName");
			extentReportsLocation = properties.getPropertyValue("ExtentReportsLocation");
			extentReportsLocation = extentReportsLocation + extentReportHtmlName + "_" + dtmCurrentDateInfo + "_" + dtmCurrentTimeInfo + ".html";
			extent = new ExtentReports(extentReportsLocation, true);

		} catch (Exception | Error e) {
			System.out.println("Error Occurred In extentReportsInstanceUtility method is" + e.toString());
			throw (e);
		}
		return extent;
	}

	// ============================================================================================
	// FunctionName : ExtentFailureReport
	// Description : To Write Failure Step Logs In The Generated Suite Extent
	// Report
	// Input Parameter : String FinalErrorMessage Stores The Error Message,
	// String TestCaseName Stores The Name Of The Test Case Function,
	// StrScreenShotTCName Stores The Name Of The TestCase
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public void extentFailureReport(String finalErrorMessage) throws Exception, Error {
		try {
			logger.log(LogStatus.FAIL, "Following Error Occurred  ::: "
					+ generic.changeColorUtility(finalErrorMessage, 1) + " " + "And Hence The Test Case Is A Fail");
			logger.log(LogStatus.INFO, logger.addScreenCapture(screenShotCapture.screenShotCaptureUtility()));

		} catch (Exception | Error e) {
			throw (e);
		}
	}

	// ============================================================================================
	// FunctionName : getFailureMesssage
	// Description : To capture failure message
	// Input Parameter : ExceptionRecorded : e.toString, TraceElement :
	// e.getStackTrace()
	// Revision : 0.0 - ImteyazAhmad-19-10-2016
	// ============================================================================================

	public String getFailureMesssage(Throwable e) throws Exception, Error {
		String errorMessage = null;
		try {
			String errorMessageArray[];
			String exceptionRecorded = e.toString();
			if (exceptionRecorded.contains("Command")) {
				errorMessageArray = exceptionRecorded.split("Command");
				errorMessage = errorMessageArray[0];
			} else {
				errorMessage = exceptionRecorded;
			}

			for (StackTraceElement ObjectName : e.getStackTrace()) {
				if (ObjectName.toString().contains("testscript")) {
					errorMessage = errorMessage + " " + "And Error Occured In :" + " " + ObjectName.toString();
					break;
				}
			}

		} catch (Exception | Error m)

		{
			throw (m);
		}

		return errorMessage;

	}

}
