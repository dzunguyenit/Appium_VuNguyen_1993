package appium;

import java.net.MalformedURLException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AutomationLearning extends AbstractPage {
	AndroidDriver<AndroidElement> driver;
	DesiredCapabilities capabilities = new DesiredCapabilities();

	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		setBrowserName(capabilities, "BROWSER_NAME", "Android");
		setVersion(capabilities, "VERSION", "6.0");
		// setDevice(capabilities, "deviceName", "Appium");
		setPlatform(capabilities, "platformName", "Android");
		setDevice(capabilities, "deviceName", "NNDQM7LZ99999999");
		setPathAPKFile(capabilities, "src/test/Resources/apps/", "ApiDemos-debug.apk");
		driver = newServerAppium(capabilities, "http://127.0.0.1:4723/wd/hub");

	}

	@Test
	public void TC_01_Contacts() throws Exception {

		longPress();
	}

	public void longPress() throws InterruptedException
	{
		TouchAction ac = new TouchAction(driver);
		MobileElement ele = driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")"));
		ac.longPress(ele,3000).perform().release();
		Thread.sleep(2000);
	}

	@AfterClass
	public void afterClass() {
		quitDriver(driver);
	}
}
