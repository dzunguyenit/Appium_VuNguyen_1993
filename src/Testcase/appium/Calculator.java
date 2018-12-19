package appium;

import java.net.MalformedURLException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Calculator extends AbstractPage {

	AndroidDriver<AndroidElement> driver;
	DesiredCapabilities capabilities = new DesiredCapabilities();

	@BeforeClass
	public void beforeClass() {
		setBrowserName(capabilities, "BROWSER_NAME", "Android");
		setVersion(capabilities, "VERSION", "6.0");
		capabilities.setCapability("deviceName", "And-1");
		// Real Device: NNDQM7LZ99999999
//		setDevice(capabilities, "deviceName", "NNDQM7LZ99999999");
		setPlatform(capabilities, "platformName", "Android");
		setPackage(capabilities, "appPackage", "com.android.calculator2");
		setActivity(capabilities, "appActivity", "com.android.calculator2.Calculator");
	}

	@Test
	public void TC_01_Calculator() throws MalformedURLException, Exception {

		driver = newServerAppium(capabilities, "http://127.0.0.1:4723/wd/hub");

		waitForControlVisibleAndroidXpath(driver, "//android.widget.Button[@text='1']");
		clickToElementAndroidXpath(driver, "//android.widget.Button[@text='1']");

		waitForControlVisibleAndroidXpath(driver,
				"//android.widget.Button[@text='1']/following-sibling::*");
		clickToElementAndroidXpath(driver,
				"//android.widget.Button[@text='1']/following-sibling::*");
		
		waitForControlVisibleAndroidXpath(driver,
				"//android.widget.Button[@text='1']/preceding-sibling::android.widget.Button[@text='7']");
		clickToElementAndroidXpath(driver,
				"//android.widget.Button[@text='1']/preceding-sibling::android.widget.Button[@text='7']");

		 waitForControlVisibleAndroidXpath(driver,
		 "//android.widget.Button[@index='1']");
		 clickToElementAndroidXpath(driver, "//android.widget.Button[@index='1']");
		
		 waitForControlVisibleAndroidXpath(driver,
		 "//android.widget.Button[@index='2']");
		 clickToElementAndroidXpath(driver, "//android.widget.Button[@index='2']");
		
		 waitForControlVisibleAndroidXpath(driver,
		 "//android.widget.Button[@index='3']");
		 clickToElementAndroidXpath(driver, "//android.widget.Button[@index='3']");

		 waitForControlVisibleAndroidXpath(driver,
		 "//android.widget.Button[@text='1']/following-sibling::android.widget.Button[@text='2']");
		 clickToElementAndroidXpath(driver,
		 "//android.widget.Button[@text='1']/following-sibling::android.widget.Button[@text='2']");

		waitForControlVisibleAndroidXpath(driver, "//android.widget.Button[@text='+']");
		clickToElementAndroidXpath(driver, "//android.widget.Button[@text='+']");

		waitForControlVisibleAndroidXpath(driver, "//android.widget.Button[@text='2']");
		clickToElementAndroidXpath(driver, "//android.widget.Button[@text='2']");

		waitForControlVisibleAndroidXpath(driver, "//android.widget.Button[@text='=']");
		clickToElementAndroidXpath(driver, "//android.widget.Button[@text='=']");

		waitForControlVisibleAndroidXpath(driver, "//android.widget.Button[@text='+']");
		clickToElementAndroidXpath(driver, "//android.widget.Button[@text='+']");

		waitForControlVisibleAndroidXpath(driver, "//android.widget.Button[@text='7']");
		clickToElementAndroidXpath(driver, "//android.widget.Button[@text='7']");

		waitForControlVisibleAndroidXpath(driver, "//android.widget.Button[@text='=']");
		clickToElementAndroidXpath(driver, "//android.widget.Button[@text='=']");

	}

	@AfterClass
	public void afterClass() {
		quitDriver(driver);
	}

}
