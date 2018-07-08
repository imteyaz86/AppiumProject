package com.test.basesetup;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.test.commonutils.PropertyReader;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class InitiateDriver extends BaseSetup {

  private AndroidDriver driver;

  public InitiateDriver(PropertyReader properties, String deviceName, String udid, String appiumUrl)
      throws Exception, Error {
    String apkFileName = properties.getPropertyValue("ApkFileName");
    String browserName = properties.getPropertyValue("BrowserName");

    try {
      DesiredCapabilities cap = new DesiredCapabilities();
      cap.setCapability(MobileCapabilityType.UDID, udid);
      cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
      cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
      cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");

      if (properties.getPropertyValue("AppTest").equalsIgnoreCase("true")) {
        File appDir = new File(System.getProperty("user.dir") + "/APKFile");
        File app = new File(appDir, apkFileName);
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver(new URL(appiumUrl), cap);
      } else {
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        driver = new AndroidDriver(new URL(appiumUrl), cap);
        driver.get(properties.getPropertyValue("BrowserUrl"));
      }

    } catch (Exception | Error e) {

      throw (e);
    }
  }

  public AndroidDriver getDriver() {
    return driver;
  }
}
