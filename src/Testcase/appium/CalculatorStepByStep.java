package appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CalculatorStepByStep extends AbstractPage {

	AndroidDriver<AndroidElement> driver;
	DesiredCapabilities capabilities = new DesiredCapabilities();

	@BeforeClass
	public void beforeClass() {
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "6.0");
		capabilities.setCapability("deviceName", "And-1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	}

	@Test
	public void TC_01_Calculator() throws MalformedURLException, Exception {

		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		// waitForControlVisibleAndroidXpath(driver,
		// "//android.widget.Button[@text='1']");
		// clickToElementAndroidXpath(driver, "//android.widget.Button[@text='1']");
		AndroidElement number1 = driver.findElement(By.xpath("//android.widget.Button[@text='1']"));
		number1.click();

		AndroidElement plus = driver.findElement(By.xpath("//android.widget.Button[@text='+']"));
		plus.click();

		AndroidElement number2 = driver.findElement(By.xpath("//android.widget.Button[@text='2']"));
		number2.click();

		AndroidElement equal = driver.findElement(By.xpath("//android.widget.Button[@text='=']"));
		equal.click();

		String text = driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
		Assert.assertEquals("3", text);

	}

	@AfterClass
	public void afterClass() {
		quitDriver(driver);
	}

}
