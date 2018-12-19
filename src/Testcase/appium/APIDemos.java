package appium;

import java.net.MalformedURLException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class APIDemos extends AbstractPage {
	AndroidDriver<AndroidElement> driver;
	DesiredCapabilities capabilities = new DesiredCapabilities();

	@BeforeClass
	public void beforeClass() {
		setBrowserName(capabilities, "BROWSER_NAME", "Android");
		setVersion(capabilities, "VERSION", "6.0");
		// setDevice(capabilities, "deviceName", "Appium");
		setPlatform(capabilities, "platformName", "Android");
		setDevice(capabilities, "deviceName", "NNDQM7LZ99999999");
		setPathAPKFile(capabilities, "src/test/Resources/apps/", "ApiDemos-debug.apk");
	}

	@Test
	public void TC_01_Contacts() throws MalformedURLException, Exception {

		driver = newServerAppium(capabilities, "http://127.0.0.1:4723/wd/hub");

		waitForControlVisibleAndroid(driver, "text(\"Views\")");
		clickToElementAndroid(driver, "text(\"Views\")");

		scrollToElementAndroid("new UiSelector().description(\"Lists\")");

		 waitForControlVisibleAndroid(driver, "text(\"Lists\")");
		 clickToElementAndroid(driver, "text(\"Lists\")");

	}

	public void swipeVertical() {
		// vertical swipe
		AndroidElement listView = driver.findElementByClassName("android.widget.ListView");
		listView.swipe(SwipeElementDirection.DOWN, 1, 0, 1000);
	}

	protected void scrollToElementAndroid(String locator) {
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" + locator + ")");
	}

	@AfterClass
	public void afterClass() {
		quitDriver(driver);
	}
}
