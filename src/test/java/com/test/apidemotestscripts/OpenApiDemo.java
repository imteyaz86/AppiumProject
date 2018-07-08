package com.test.apidemotestscripts;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.basesetup.BaseSetup;
import com.test.basesetup.ObjectCreation;
import io.appium.java_client.android.AndroidKeyCode;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenApiDemo extends BaseSetup {
  @Parameters({ "deviceName", "udid", "appiumUrl" })
  @Test
  public void openApiDemo(String deviceName, String udid, String appiumUrl) throws Throwable {
    ObjectCreation initiateObject = null;
    ExtentTest logger = null;

    try {
      System.out.println("Device name is " + deviceName);
      System.out.println("appium url is is " + appiumUrl);
      logger = reports.startTest("openApiDemo", "Validate Api Demo App Is Open Successfully");
      initiateObject = new ObjectCreation(logger, deviceName, udid, appiumUrl);
      initiateObject.navigation.optionalClick("ApiDemo", "Home_Ok_Btn");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "Home_ApiDemo_Lnk"),
          "Api Demo Link On Home Page");
      logger.log(LogStatus.INFO,
          logger.addScreenCapture(initiateObject.screenShotCapture.screenShotCaptureUtility()));
      initiateObject.navigation.scrollDown("Views");

    } catch (Throwable t) {
      initiateObject.reportLib.extentFailureReport(initiateObject.reportLib.getFailureMesssage(t));
      throw t;
    } finally {
      reports.endTest(logger);
      initiateObject.generic.closeApplication();
      initiateObject.killObject();
    }
  }

  @Parameters({ "deviceName", "udid", "appiumUrl" })
  @Test
  public void openViewLink(String deviceName, String udid, String appiumUrl) throws Throwable {
    ObjectCreation initiateObject = null;
    ExtentTest logger = null;

    try {

      logger = reports.startTest("openViewLink",
          "Validate View Link Is Opened and scroll to webview link Successfully");
      initiateObject = new ObjectCreation(logger, deviceName, udid, appiumUrl);
      initiateObject.navigation.click(initiateObject.generic.getElement("ApiDemo", "Home_Ok_Btn"),
          "Ok Button On Home Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "Home_ApiDemo_Lnk"),
          "Api Demo Link On Home Page");
      logger.log(LogStatus.INFO,
          logger.addScreenCapture(initiateObject.screenShotCapture.screenShotCaptureUtility()));
      initiateObject.navigation.scrollDown("Views");
      initiateObject.navigation.elementTap(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_View_Lnk"),
          "View Link On Api Demo Page");
      initiateObject.navigation.scrollDown("WebView");
      logger.log(LogStatus.INFO,
          logger.addScreenCapture(initiateObject.screenShotCapture.screenShotCaptureUtility()));
    } catch (Throwable t) {
      initiateObject.reportLib.extentFailureReport(initiateObject.reportLib.getFailureMesssage(t));
      throw t;
    } finally {
      reports.endTest(logger);
      initiateObject.generic.closeApplication();
      initiateObject.killObject();
    }
  }

  @Parameters({ "deviceName", "udid", "appiumUrl" })
  @Test
  public void swipeTest(String deviceName, String udid, String appiumUrl) throws Throwable {
    ObjectCreation initiateObject = null;
    ExtentTest logger = null;

    try {

      logger = reports.startTest("swipeTest", "Validate Swipe Test");
      initiateObject = new ObjectCreation(logger, deviceName, udid, appiumUrl);
      initiateObject.navigation.click(initiateObject.generic.getElement("ApiDemo", "Home_Ok_Btn"),
          "Ok Button On Home Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "Home_ApiDemo_Lnk"),
          "Api Demo Link On Home Page");
      initiateObject.navigation.scrollDown("Views");
      initiateObject.navigation.elementTap(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_View_Lnk"),
          "View Link On Api Demo Page");
      initiateObject.navigation.elementTap(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_DateWidgets_Lnk"),
          "Date Widgets On Api Demo Page");
      initiateObject.navigation.elementTap(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_Inline_Lnk"),
          "Inline On Api Demo Page");
      initiateObject.navigation.elementTap(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_time9_Lnk"),
          "Time 9 On Api Demo Page");
      initiateObject.navigation.swipeTo(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_time15_Lnk"),
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_time45_Lnk"),
          "From Time 15 To Time 45 On Clock");
      logger.log(LogStatus.INFO,
          logger.addScreenCapture(initiateObject.screenShotCapture.screenShotCaptureUtility()));

    } catch (Throwable t) {
      initiateObject.reportLib.extentFailureReport(initiateObject.reportLib.getFailureMesssage(t));
      throw t;
    } finally {
      reports.endTest(logger);
      initiateObject.generic.closeApplication();
      initiateObject.killObject();
    }
  }

  @Parameters({ "deviceName", "udid", "appiumUrl" })
  @Test
  public void pressTest(String deviceName, String udid, String appiumUrl) throws Throwable {
    ObjectCreation initiateObject = null;
    ExtentTest logger = null;
    String actualSampleTxt;
    String expectedSampleTxt;

    try {

      logger = reports.startTest("pressTest", "Validate Long Press Test");
      initiateObject = new ObjectCreation(logger, deviceName, udid, appiumUrl);
      expectedSampleTxt = initiateObject.testDataExcel.excelStringFetchDataUtility("ApiDemo",
          "pressTest", "SampleTitle");
      initiateObject.navigation.click(initiateObject.generic.getElement("ApiDemo", "Home_Ok_Btn"),
          "Ok Button On Home Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "Home_ApiDemo_Lnk"),
          "Api Demo Link On Home Page");
      initiateObject.navigation.scrollDown("Views");
      initiateObject.navigation.elementTap(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_View_Lnk"),
          "View Link On Api Demo Page");
      initiateObject.navigation.elementTap(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_ExpandableList_Lnk"),
          "Expandable List On Api Demo Page");
      initiateObject.navigation.elementTap(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_CustomAdapter_Lnk"),
          "Custom Adaptor On Api Demo Page");
      initiateObject.navigation.elementPress(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_PeopleName_Lnk"), 3,
          "People Name On Api Demo Page");
      initiateObject.verification.elementExistUtility(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_SampleMenu_Lbl"),
          "Sample Menu Pop Up");
      actualSampleTxt = initiateObject.generic.getElement("ApiDemo", "ApiDemo_SampleMenu_Lbl")
          .getText();
      initiateObject.verification.textCompareUtility(expectedSampleTxt, actualSampleTxt,
          "Sample Title");
      logger.log(LogStatus.INFO,
          logger.addScreenCapture(initiateObject.screenShotCapture.screenShotCaptureUtility()));

    } catch (Throwable t) {
      initiateObject.reportLib.extentFailureReport(initiateObject.reportLib.getFailureMesssage(t));
      throw t;
    } finally {
      reports.endTest(logger);
      initiateObject.generic.closeApplication();
      initiateObject.killObject();
    }
  }

  /*
   * //@Test public void scrollUpTest() throws Throwable { ObjectCreation initiateObject = null;
   * ExtentTest logger = null;
   * 
   * try {
   * 
   * logger = reports.startTest("scrollUpTest", "Validate scroll up Test"); //initiateObject = new
   * ObjectCreation(logger,deviceName,appiumUrl);
   * initiateObject.navigation.click(initiateObject.generic.getElement("ApiDemo", "Home_Ok_Btn"),
   * "Ok Button On Home Page");
   * initiateObject.navigation.click(initiateObject.generic.getElement("ApiDemo",
   * "Home_ApiDemo_Lnk"), "Api Demo Link On Home Page");
   * initiateObject.navigation.scrollDown("Views");
   * initiateObject.navigation.elementTap(initiateObject.generic.getElement("ApiDemo",
   * "ApiDemo_View_Lnk"), "View Link On Api Demo Page");
   * initiateObject.navigation.scrollDown("ImageView"); logger.log(LogStatus.INFO,
   * logger.addScreenCapture(initiateObject.screenShotCapture.screenShotCaptureUtility()));
   * //initiateObject.getDriver(). initiateObject.navigation.scrollUp("ApiDemo", "ApiDemo_View_Lnk",
   * "ApiDemo_Animation_Lnk", "");
   * 
   * 
   * }catch (Throwable t) {
   * initiateObject.reportLib.extentFailureReport(initiateObject.reportLib.getFailureMesssage(t));
   * throw t; }
   * 
   * finally { reports.endTest(logger); initiateObject.generic.closeApplication();
   * initiateObject.killObject(); } }
   */
  @Parameters({ "deviceName", "udid", "appiumUrl" })
  @Test
  public void dragDropTest(String deviceName, String udid, String appiumUrl) throws Throwable {
    ObjectCreation initiateObject = null;
    ExtentTest logger = null;

    try {

      logger = reports.startTest("dragDropTest", "Validate scroll up Test");
      initiateObject = new ObjectCreation(logger, deviceName, udid, appiumUrl);
      initiateObject.navigation.click(initiateObject.generic.getElement("ApiDemo", "Home_Ok_Btn"),
          "Ok Button On Home Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "Home_ApiDemo_Lnk"),
          "Api Demo Link On Home Page");
      initiateObject.navigation.scrollDown("Views");
      initiateObject.navigation.elementTap(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_View_Lnk"),
          "View Link On Api Demo Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_DragAndDrop_Lnk"),
          "Api Demo Link On Home Page");
      initiateObject.navigation.longPressAndMoveTo(
          initiateObject.generic.getElements("ApiDemo", "ApiDemo_DropItem_Lnk").get(0),
          initiateObject.generic.getElements("ApiDemo", "ApiDemo_DropItem_Lnk").get(1),
          "Drag Drop");
      logger.log(LogStatus.INFO,
          logger.addScreenCapture(initiateObject.screenShotCapture.screenShotCaptureUtility()));

    } catch (Throwable t) {
      initiateObject.reportLib.extentFailureReport(initiateObject.reportLib.getFailureMesssage(t));
      throw t;
    } finally {
      reports.endTest(logger);
      initiateObject.generic.closeApplication();
      initiateObject.killObject();
    }
  }

  @Parameters({ "deviceName", "udid", "appiumUrl" })
  @Test
  public void pressBackTest(String deviceName, String udid, String appiumUrl) throws Throwable {
    ObjectCreation initiateObject = null;
    ExtentTest logger = null;

    try {

      logger = reports.startTest("pressBackTest", "BackButton Is press");
      initiateObject = new ObjectCreation(logger, deviceName, udid, appiumUrl);
      initiateObject.navigation.click(initiateObject.generic.getElement("ApiDemo", "Home_Ok_Btn"),
          "Ok Button On Home Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "Home_ApiDemo_Lnk"),
          "Api Demo Link On Home Page");
      initiateObject.navigation.scrollDown("Views");
      initiateObject.navigation.elementTap(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_View_Lnk"),
          "View Link On Api Demo Page");
      initiateObject.generic.androidKeyBoardEvents(AndroidKeyCode.BACK, "AndroidKeyCode.BACK");
      initiateObject.navigation.scrollDown("Views");

    } catch (Throwable t) {
      initiateObject.reportLib.extentFailureReport(initiateObject.reportLib.getFailureMesssage(t));
      throw t;

    } finally {
      reports.endTest(logger);
      initiateObject.generic.closeApplication();
      initiateObject.killObject();
    }
  }

  @Parameters({ "deviceName", "udid", "appiumUrl" })
  @Test
  public void toggleClickTest(String deviceName, String udid, String appiumUrl) throws Throwable {
    ObjectCreation initiateObject = null;
    ExtentTest logger = null;

    try {

      logger = reports.startTest("toggleClickTest", "toggleClickTest");
      initiateObject = new ObjectCreation(logger, deviceName, udid, appiumUrl);
      initiateObject.navigation.click(initiateObject.generic.getElement("ApiDemo", "Home_Ok_Btn"),
          "Ok Button On Home Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "Home_ApiDemo_Lnk"),
          "Api Demo Link On Home Page");
      initiateObject.navigation.scrollDown("Views");
      initiateObject.navigation.elementTap(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_View_Lnk"),
          "View Link On Api Demo Page");
      initiateObject.navigation.elementTap(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_Controls_Lnk"),
          "Control Link On Api Demo Page");
      initiateObject.navigation.elementTap(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_MaterialLightTheme_Lnk"),
          "MaterialLightTheme Link On Api Demo Page");
      initiateObject.navigation.elementTap(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_Save_Tgl"),
          "Save Toggle Button On Api Demo Page");

      // Controls are selected and save is clicked
      initiateObject.input.setValueUtility(
          initiateObject.generic.getElement("ApiDemo", "ApiDemo_TextEnter_Txt"),
          "Text Box On Material Light Theme Page", "Hello");
      initiateObject.getDriver().hideKeyboard();
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "MaterialLightTheme_CheckBox1_Chk"),
          "CheckBox1 On Material Light Theme Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "MaterialLightTheme_CheckBox2_Chk"),
          "CheckBox2 On Material Light Theme Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "MaterialLightTheme_RadioButton1_Rdb"),
          "Radio Button 1 On Material Light Theme Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "MaterialLightTheme_RadioButton2_Rdb"),
          "Radio Button 2 On Material Light Theme Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "MaterialLightTheme_Star_Lbl"),
          "Star Button On Material Light Theme Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "MaterialLightTheme_Off_TglBtn"),
          "Off Button On Material Light Theme Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "MaterialLightTheme_Off2_TglBtn"),
          "Off2 Button On Material Light Theme Page");
      ;
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "MaterialLightTheme_Save_Btn"),
          "Save Button On Material Light Theme Page");
      logger.log(LogStatus.INFO,
          logger.addScreenCapture(initiateObject.screenShotCapture.screenShotCaptureUtility()));

      // Controls are unselected

      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "MaterialLightTheme_CheckBox1_Chk"),
          "CheckBox1 On Material Light Theme Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "MaterialLightTheme_CheckBox2_Chk"),
          "CheckBox2 On Material Light Theme Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "MaterialLightTheme_RadioButton2_Rdb"),
          "Radio Button 2 On Material Light Theme Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "MaterialLightTheme_Star_Lbl"),
          "Star Button On Material Light Theme Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "MaterialLightTheme_Off_TglBtn"),
          "Off Button On Material Light Theme Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "MaterialLightTheme_Off2_TglBtn"),
          "Off2 Button On Material Light Theme Page");
      ;
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "MaterialLightTheme_Save_Btn"),
          "Save Button On Material Light Theme Page");
      logger.log(LogStatus.INFO,
          logger.addScreenCapture(initiateObject.screenShotCapture.screenShotCaptureUtility()));

      // initiateObject.navigation.elementTap(initiateObject.generic.getElement("ApiDemo",
      // "ApiDemo_SaveOn_Tgl"), "Save Toggle Button On Api Demo Page");
      initiateObject.navigation.elementTap(
          initiateObject.generic.getElement("ApiDemo", "MaterialLightTheme_PlanetName_Lst"),
          "Planet Name List On Api Demo Page");
      initiateObject.navigation.click(
          initiateObject.generic.getElement("ApiDemo", "MaterialLightTheme_PlanetName_Lbl"),
          "Venus On Material Light Theme Page");

    } catch (Throwable t) {
      initiateObject.reportLib.extentFailureReport(initiateObject.reportLib.getFailureMesssage(t));
      throw t;
    } finally {
      reports.endTest(logger);
      initiateObject.generic.closeApplication();
      initiateObject.killObject();
    }
  }

}
