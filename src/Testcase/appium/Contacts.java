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

public class Contacts extends AbstractPage {

	AndroidDriver<AndroidElement> driver;
	DesiredCapabilities capabilities = new DesiredCapabilities();

	@BeforeClass
	public void beforeClass() {
		setBrowserName(capabilities, "BROWSER_NAME", "Android");
		setVersion(capabilities, "VERSION", "6.0");
//		setDevice(capabilities, "deviceName", "NNDQM7LZ99999999");
		capabilities.setCapability("deviceName", "And-1");
		setPlatform(capabilities, "platformName", "Android");
		setPackage(capabilities, "appPackage", "com.android.contacts");
		setActivity(capabilities, "appActivity", "com.android.contacts.activities.PeopleActivity");
	}

	@Test
	public void TC_01_Contacts() throws MalformedURLException, Exception {

		driver = newServerAppium(capabilities, "http://127.0.0.1:4723/wd/hub");
		waitForControlVisibleAndroid(driver, "text(\"Create a new contact\")");
		clickToElementAndroid(driver, "text(\"Create a new contact\")");

		waitForControlVisibleAndroid(driver, "new UiSelector().resourceId(\"com.android.contacts:id/expansion_view\")");
		clickToElementAndroid(driver, "new UiSelector().resourceId(\"com.android.contacts:id/expansion_view\")");

		waitForControlVisibleAndroid(driver, "text(\"Name prefix\")");
		sendKeyToElementAndroid(driver, "text(\"Name prefix\")", "Name prefix");

		waitForControlVisibleAndroid(driver, "text(\"First name\")");
		sendKeyToElementAndroid(driver, "text(\"First name\")", "First name");

		waitForControlVisibleAndroid(driver, "text(\"Middle name\")");
		sendKeyToElementAndroid(driver, "text(\"Middle name\")", "Middle name");

		waitForControlVisibleAndroid(driver, "text(\"Last name\")");
		sendKeyToElementAndroid(driver, "text(\"Last name\")", "Last name");

		waitForControlVisibleAndroid(driver, "text(\"Name suffix\")");
		sendKeyToElementAndroid(driver, "text(\"Name suffix\")", "Name suffix");

		waitForControlVisibleAndroid(driver, "text(\"Phone\")");
		sendKeyToElementAndroid(driver, "text(\"Phone\")", "1234567890");

		waitForControlVisibleAndroid(driver, "text(\"Mobile\")");
		clickToElementAndroid(driver, "text(\"Mobile\")");

		waitForControlVisibleAndroid(driver, "text(\"Car\")");
		clickToElementAndroid(driver, "text(\"Car\")");

		swipeVertical();
		swipeVertical();

		waitForControlVisibleAndroid(driver, "text(\"Email\")");
		sendKeyToElementAndroid(driver, "text(\"Email\")", "Email@gmail.com");

	}

	public void swipeVertical() {
		AndroidElement listView = driver.findElementByClassName("android.widget.ScrollView");
		listView.swipe(SwipeElementDirection.UP, 1, 0, 1000);
	}

	@AfterClass
	public void afterClass() {
		quitDriver(driver);
	}

}
