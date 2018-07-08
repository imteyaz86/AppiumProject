package com.test.commonutils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Navigation extends com.test.basesetup.BaseSetup {

	String strValue;
	AndroidDriver driver = null;
	ExtentTest logger = null;
	WebDriverWait globalWait = null;
	Generic generic = null;

	public Navigation(AndroidDriver driver, Generic generic, ExtentTest logger, WebDriverWait globalWait) {
		this.driver = driver;
		this.generic = generic;
		this.logger = logger;
		this.globalWait = globalWait;
	}

	// ============================================================================================
	// FunctionName : weblinkselect_utility
	// Description : To Click On The Link Element Based On The Link Text
	// Provided
	// Input Parameter : Link Text Of The Type String
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public void webLinkSelect(String LinkText, String ControlDesc) throws Exception, Error {
		boolean found = false;
		try {
			ControlDesc = generic.changeColorUtility(ControlDesc, 4);
			// LinkText = generic.changeColorUtility(LinkText, 4);

			for (int i = 0; i < 10; i++) {
				try {
					driver.findElement(By.linkText(LinkText)).click();
					found = true;
				} catch (StaleElementReferenceException e) {
					found = false;
					continue;

				}

				if (found == true) {
					break;
				}

			}
			logger.log(LogStatus.INFO,
					"Following Link:" + " " + LinkText + " " + "On" + ControlDesc + " " + "Is Successfully Clicked");

		} catch (Exception | Error e) {
			throw (e);
		}
	}

	// ============================================================================================
	// FunctionName : webpartiallinkselect_utility
	// Description : To Click On The Link Element Based On The Partial Link Text
	// Provided
	// Input Parameter : PartialLinkText And ControlDesc Of The Type String,
	// logval Of The Type Integer
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public void webPartialLinkSelect(String PartialLinkText, String ControlDesc) throws Exception, Error {
		boolean found = false;
		try {
			ControlDesc = generic.changeColorUtility(ControlDesc, 4);
			String ParLinkText = generic.changeColorUtility(PartialLinkText, 4);

			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
					driver.findElement(By.partialLinkText(PartialLinkText)).click();
					found = true;
				} catch (StaleElementReferenceException e) {
					found = false;
					continue;

				}

				if (found == true) {
					break;
				}

			}
			logger.log(LogStatus.INFO,
					"Following Link:" + " " + ParLinkText + " " + "On" + ControlDesc + " " + "Is Successfully Clicked");

		} catch (Exception | Error e) {
			throw (e);
		}
	}

	// ============================================================================================
	// FunctionName : objectclick_utility
	// Description : To Click On The Web Element And Provide Suitable Logger
	// Statement
	// Input Parameter : Element Of Type WebElement: Element To Be Clicked and
	// ControlDesc: Control Name To Be Clicked
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public void click(WebElement element, String controlDesc) throws Exception, Error {
		String controlDescLabel;
		controlDescLabel = generic.changeColorUtility(controlDesc, 4);
		try {
			if (element.isEnabled()) {
				element.click();
				logger.log(LogStatus.INFO, controlDescLabel + " " + "Is Successfully Clicked");

			}

			else {
				Assert.fail();
			}

		} catch (Exception | Error e) {
			throw (e);
		}
	}

	// ============================================================================================
	// FunctionName : objectdoubleclick_utility
	// Description : To DoubleClick On The Web Element And Provide Suitable
	// Logger Statement
	// Input Parameter : Element Of Type WebElement: Element To Be DoubleClicked
	// and ControlDesc: Control Name To Be Clicked
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public void doubleClick(WebElement element, String controlDesc) throws Exception, Error {
		String controlDescLabel;
		controlDescLabel = generic.changeColorUtility(controlDesc, 4);
		try {
			Actions oAction = new Actions(driver);
			oAction.doubleClick(element).build().perform();
			logger.log(LogStatus.INFO, controlDescLabel + " " + "Is Successfully DoubleClicked");

		} catch (Exception | Error e) {
			throw (e);
		}
	}

	// ============================================================================================
	// FunctionName : objectrightclick_utility
	// Description : To RightClick On The Web Element And Provide Suitable
	// Logger Statement
	// Input Parameter : Element Of Type WebElement: Element To Be Clicked,
	// ControlDesc: Control Name To Be Right Clicked, ElementRightClick: Element
	// To Be RightClicked, ObjDesc: Control Name To Be Clicked, logval: log
	// parameters
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public void rightClick(WebElement elementRightClick, String controlDesc) throws Exception, Error {
		String controlDescLabel;
		controlDescLabel = generic.changeColorUtility(controlDesc, 4);
		try {
			Actions oAction = new Actions(driver);
			oAction.moveToElement(elementRightClick);
			oAction.contextClick(elementRightClick).build().perform();
			logger.log(LogStatus.INFO, controlDescLabel + " " + "Is Successfully Right Clicked");

		} catch (Exception | Error e) {
			throw (e);
		}
	}

	/**
	 * @param element
	 * @param controlDesc
	 * @param logval
	 * @throws Exception
	 * @throws Error
	 * @Method : This is to click an element using Action
	 */
	public void actionsClick(WebElement element, String controlDesc) throws Exception, Error {
		String controlDescLabel;
		controlDescLabel = generic.changeColorUtility(controlDesc, 4);
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).click().build().perform();
			logger.log(LogStatus.INFO, controlDescLabel + " " + "Is Successfully Clicked");

		} catch (Exception | Error e) {
			throw (e);
		}
	}

	// ============================================================================================
	// FunctionName : elementweblistselect_utility
	// Description : To Select The Element Displayed In The WebList As Per The
	// User Given Selection Value
	// Input Parameter : Element Of Type WebElement: Element For Which The Value
	// Is To Be Selected and SelectionElement Of Type String : Value To Be
	// Selected
	// Revision : 0.0 - ImteyazAhmad-13-10-2016
	// ============================================================================================
	public void elementWebListSelect(WebElement element, String value, String controlName) throws Exception, Error {
		try {
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(value);
			logger.log(LogStatus.INFO, "Value Selected In" + " " + generic.changeColorUtility(controlName, 4) + "Is"
					+ "::" + " " + generic.changeColorUtility(value, 3));
		} catch (Exception | Error e) {
			throw (e);
		}
	}

	// ============================================================================================
	// FunctionName : element_weblistselect_utility
	// Description : To Select The Element Displayed In The WebList As Per The
	// User Given Selection Value
	// Input Parameter : Element Of Type WebElement: Element For Which The Value
	// Is To Be Selected and SelectionElement Of Type Integer: Index Of The
	// Value To Be Selected
	// Revision : 0.0 - KImteyazAhmad-13-10-2016
	// ============================================================================================
	public void elementWebListSelect(WebElement element, int value, String controlName) throws Exception, Error {
		try {
			Select dropdown = new Select(element);
			dropdown.selectByIndex(value);
			logger.log(LogStatus.INFO, "Value Selected In" + " " + generic.changeColorUtility(controlName, 4) + "Is"
					+ "::" + " " + generic.changeColorUtility(String.valueOf(value), 3));
		} catch (Exception | Error e) {
			throw (e);
		}
	}

	/**
	 * @Summary This method is used to tap mobile element
	 * @param element
	 * @param elementDescription
	 * @throws Throwable
	 */
	public void elementTap(WebElement element, String elementDescription) throws Throwable {
		TouchAction touchAction;
		try {
			touchAction = new TouchAction(driver);
			touchAction.tap(element).perform();
			logger.log(LogStatus.INFO, "Element :" + " " + generic.changeColorUtility(elementDescription, 4) + " "
					+ "Is Successfully Tapped");
		} catch (Throwable t) {
			throw t;
		}
	}

	/**
	 * @Summary This method is used to press mobile element for given period of
	 *          time
	 * @param element
	 * @param milliSeconds
	 * @param elementDescription
	 * @throws Throwable
	 */
	public void elementPress(WebElement element, int Seconds, String elementDescription) throws Throwable {
		TouchAction touchAction;
		int milliSeconds = Seconds*1000;
		try {
			touchAction = new TouchAction(driver);
			touchAction.press(element).waitAction(Duration.ofMillis(milliSeconds)).release().perform();
			logger.log(LogStatus.INFO,
					"Element :" + " " + generic.changeColorUtility(elementDescription, 4) + " "
							+ "Is Pressed Successfully For Duration " + " "
							+ generic.changeColorUtility(String.valueOf(milliSeconds / 1000), 3) + " " + "Seconds");
		} catch (Throwable t) {
			throw t;
		}
	}

	/**
	 * @Summary This method is used to swipe from one mobile element to another
	 *          mobile element
	 */
	public void swipeTo(WebElement fromElement, WebElement toElement, String elementDescription) throws Throwable {
		TouchAction touchAction;
		try {
			touchAction = new TouchAction(driver);
			touchAction.press(fromElement).waitAction(Duration.ofSeconds(2)).moveTo(toElement).release().perform();
			logger.log(LogStatus.INFO,
					"Swipe Happened Successfully " + " " + generic.changeColorUtility(elementDescription, 4));
		} catch (Throwable t) {
			throw t;
		}
	}

	/**
	 * @Summary This method is used to long press from one mobile element to another
	 *          mobile element
	 */
	public void longPressAndMoveTo(WebElement fromElement, WebElement toElement, String elementDescription) throws Throwable {
		TouchAction touchAction;
		try {
			touchAction = new TouchAction(driver);
			touchAction.longPress(fromElement).moveTo(toElement).release().perform();
			logger.log(LogStatus.INFO,
					"Long Press And Move To Happened Successfully " + " " + generic.changeColorUtility(elementDescription, 4));
		} catch (Throwable t) {
			throw t;
		}
	}

	/**
	 * @Summary This method is used to scroll down to mobile element using text attribute
	 */
	public void scrollDown(String scrollToText) throws Throwable {
		
		String uiAutomator;
		WebElement element;
		try {
			uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\""+scrollToText+"\"));";
			element = driver.findElementByAndroidUIAutomator(uiAutomator);
			if (element.isDisplayed()) {
				logger.log(LogStatus.INFO, "Scroll Happened Successfully To Element :"+" "+generic.changeColorUtility(scrollToText, 4));
			}
			else {
				Assert.fail();
			}
			
		} catch (Throwable t) {
			throw t;
		}
	}
	
	/**
	 * @Summary This method is used to scroll Up to mobile element 
	 */
	public void scrollUp(String sheetName,String fromElementName,String toElementName, String objectDes) throws Throwable {
		int xCoordinate;
		int yCoordinate;
		int moveBy = 10;
		boolean notDisplayed = true;
		TouchAction touchAction;
		WebElement fromElement;
		WebElement toElement;
		try {
			touchAction = new TouchAction(driver);
			fromElement = generic.getElement(sheetName, fromElementName);
			//xCoordinate = fromElement.getLocation().getX();
			//yCoordinate = fromElement.getLocation().getY();
			
			System.out.println("size is "+driver.manage().window().getSize().getWidth()+" :"+driver.manage().window().getSize().getHeight());
			yCoordinate =driver.manage().window().getSize().getHeight();
			yCoordinate = yCoordinate/2;
			xCoordinate = driver.manage().window().getSize().getWidth();
			xCoordinate = xCoordinate/2;
			while (notDisplayed) {
			//touchAction.longPress(xCoordinate, yCoordinate).moveTo(xCoordinate, yCoordinate+moveBy).release().perform();
				touchAction.moveTo(xCoordinate, yCoordinate+moveBy).perform();
			try {
			toElement = generic.getElementWithNoDelay(sheetName, toElementName);
			} catch (NoSuchElementException e) {
				moveBy = 20;
				System.out.println("Catch");
				continue;
			}
			
			if (toElement.isDisplayed()){
				notDisplayed = false;
				System.out.println("Done");
			}
			}
			
			
		} catch (Throwable t) {
			throw t;
		}
	}
	/**
	 * @Summary This perform click when element is present
	 */
	public void optionalClick(String sheetName, String elementName) throws Throwable {
		WebElement element;
		try {

			element = generic.getElement(sheetName, elementName);
			element.click();
			logger.log(LogStatus.INFO, "Optional Click Is Performed Successfully On Element"+" "+generic.changeColorUtility(elementName, 4));

		} catch (NoSuchElementException n) {
			logger.log(LogStatus.INFO, "Optional Click Is Not Performed As Element"+" "+generic.changeColorUtility(elementName, 4)+" "+"Is Not Present");
		} catch (Throwable t) {
			throw t;
		}
	}
}
