package com.cdn.utils;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BaseClass {

	protected static AppiumDriver<MobileElement> driver;
	protected static Properties props;
	InputStream inputStream;

	public BaseClass(){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@Parameters({"platformName","platformVersion","deviceName"})
	@BeforeMethod
	public void setUp(String platformName,String platformVersion,String deviceName) {
		try {
			props = new Properties();
			String propsFileName = "config.properties";
			inputStream = getClass().getClassLoader().getResourceAsStream(propsFileName);
			props.load(inputStream);

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			caps.setCapability("appPackage", props.getProperty("AndroidAppPackage"));
			caps.setCapability("appActivity", props.getProperty("AndroidAppActivity"));
			URL appURL = getClass().getClassLoader().getResource(props.getProperty("AndroidAppLocation"));
			caps.setCapability(MobileCapabilityType.APP, appURL);

			URL url = new URL(props.getProperty("AppiumUrl"));
			driver = new AppiumDriver<MobileElement>(url,caps);


		}catch(Exception e){
			System.out.println("Cause for failure in Set Up: "+ e.getCause());
			System.out.println("Message for failure in Set Up: "+ e.getMessage());
			e.printStackTrace();
		}
	}	

	public void waitForVisibility(MobileElement element){
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void click(MobileElement element) {
		try {
			waitForVisibility(element);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendKeys(MobileElement element,String txt) {
		try {
			waitForVisibility(element);
			element.sendKeys(txt);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getAttribute(MobileElement element,String attribute) {
		try {
			waitForVisibility(element);
			return element.getAttribute(attribute);
		}catch (Exception e) {
			e.printStackTrace();
			return "Attribute is invalid" ;
		}


	}

	public boolean isElementDisplayed(MobileElement element) {
		try {
			waitForVisibility(element);
			element.isDisplayed();
			return true;

		}catch(Exception msg) {
			captureScreenShots();
			msg.printStackTrace();
			return false;
		}


	}

	@SuppressWarnings("deprecation")
	public void sendKeysThroughKeyBoard(String txt) {

		for (int i = 0; i < txt.length(); i++) {
			char c = txt.charAt(i);
			String s = new StringBuilder().append(c).toString();
			driver.getKeyboard().pressKey(s);
		}
		driver.hideKeyboard();

	}

	public void swipeScreen(Direction dir) {
		final int ANIMATION_TIME = 200; // ms
		final int PRESS_TIME = 200; // ms
		int edgeBorder = 10; // better avoid edges
		PointOption pointOptionStart, pointOptionEnd;
		Dimension dims = driver.manage().window().getSize();
		pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

		switch (dir) {
		case DOWN: 
			pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
			break;
		case UP:
			pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
			break;
		case LEFT: 
			pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
			break;
		case RIGHT: 
			pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
			break;
		default:
			throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
		}

		try {
			new TouchAction(driver)
			.press(pointOptionStart)
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
			.moveTo(pointOptionEnd)
			.release().perform();
		} catch (Exception e) {
			System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
			return;
		}

		try {
			Thread.sleep(ANIMATION_TIME);
		} catch (InterruptedException e) {

		}
	}

	public enum Direction {
		UP,
		DOWN,
		LEFT,
		RIGHT;
	}

	public static void captureScreenShots() {
		try {
			String folder_name="screenshotCDN";
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			SimpleDateFormat df=new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
			String file_name=df.format(new Date())+".png";
			FileUtils.copyFile(file, new File("./report/"+ file_name));
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}



}
