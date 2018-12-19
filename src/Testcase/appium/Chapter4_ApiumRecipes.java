package appium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Chapter4_ApiumRecipes extends AbstractPage {
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

		// taponElement();
		// dragDrop();
		waitForControlVisibleAndroid(driver, "text(\"Views\")");
		clickToElementAndroid(driver, "text(\"Views\")");
		swipeVertical();
		swipeVertical();
		waitForControlVisibleAndroid(driver, "text(\"WebView\")");
		clickToElementAndroid(driver, "text(\"WebView\")");

		// changeOrientation();
		// closeAndLauch();
		// lockUnlock();

		// keyCode(AndroidKeyCode.MENU);
		// openNotifications();
		// screenShot();
		// pinchZoom();
		longPress();
	}

	public void longPress() {
		// Long Press?
		driver.startActivity("io.appium.android.apis", ".view.Buttons1");
		TouchAction action = new TouchAction(driver);
		action.longPress(driver.findElementById("io.appium.android.apis:id/button_toggle")).release().perform();
	}

	public void pinchZoom() throws InterruptedException {

		// Pinch and Zoom
		driver.startActivity("io.appium.android.apis", ".ApiDemos");
		MobileElement e = driver.findElement(MobileBy.AccessibilityId("App"));
		Thread.sleep(2000);
		e.zoom();
		Thread.sleep(2000);
		e.pinch();
	}

	public void taponElement() {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		driver.findElement(MobileBy.AccessibilityId("Buttons")).click();

		// Point point =
		// driver.findElementById("io.appium.android.apis:id/button_toggle").getLocation();
		// driver.tap(1, point.x + 20, point.y + 30, 1000);
		driver.tap(1, driver.findElementById("io.appium.android.apis:id/button_toggle"), 1000);
		System.out.println(driver.findElementById("io.appium.android.apis:id/button_toggle").getText());

	}

	public void dragDrop(String locator1, String locator2) {
		// Open an activity directly
		driver.startActivity("io.appium.android.apis", ".view.DragAndDropDemo");

		WebElement element1 = driver.findElement(By.id(locator1));
		WebElement element2 = driver.findElement(By.id(locator2));

		// perform Drag and Drop
		TouchAction dragNDrop = new TouchAction(driver);
		dragNDrop.longPress(element1).moveTo(element2).release().perform();
	}

	public void swipeVertical() {
		// vertical swipe
		AndroidElement listView = driver.findElementByClassName("android.widget.ListView");
		listView.swipe(SwipeElementDirection.UP, 1, 0, 1000);
	}

	public void keyCode(int key) {
		// KeyCode
		driver.pressKeyCode(key);
	}

	public void openNotifications() {
		// KeyCode
		driver.openNotifications();
	}

	public void changeOrientation() throws Exception {
		// change orientation to LANDSCAPE
		driver.rotate(ScreenOrientation.LANDSCAPE);
		// change orientation to PORTRAIT
		driver.rotate(ScreenOrientation.PORTRAIT);

	}

	public void screenShot() throws WebDriverException, IOException {
		// Screenshot
		File location = new File("screenshots");
		String screenShotName = location.getAbsolutePath() + File.separator + "SampleScreenshot" + ".png";

		FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File(screenShotName));
	}

	public void closeAndLauch() throws Exception {
		driver.closeApp();
		driver.launchApp();
	}

	public void lockUnlock() {
		// lock device:
		driver.lockDevice();
		// unlock device:
		driver.unlockDevice();
	}

	@AfterClass
	public void afterClass() {
		quitDriver(driver);
	}
}
