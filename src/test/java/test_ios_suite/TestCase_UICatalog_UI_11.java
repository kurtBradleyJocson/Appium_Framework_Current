package test_ios_suite;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import common.Config_IOS;
import instance_initiator.IOS;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import object_repo.IOSGestures;
import object_repo.TestCase_IOS_BaseClass;
import util.GenerateReport;
import util.ScreenShot_Handler;

public class TestCase_UICatalog_UI_11 extends TestCase_IOS_BaseClass {
	
	IOS ios;
	IOSDriver driver;
	
	IOSGestures gesture;
	

	@Test(priority = 0)
	public void UI_11_step01() {
		
		ios = new IOS("UI_11");
		
		driver = ios.getDriver();

		gesture = new IOSGestures(driver);
		
		WebElement elem = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Stack Views']"));
		elem.click();
		
		ios.testResults(LogStatus.PASS, "UI_11_step01");

	}
	
	@Test(priority = 1)
	public void UI_11_step02() {
		WebElement elem = driver.findElement(AppiumBy.xpath("(//XCUIElementTypeButton[@name=\"stepper increment\"])[1]"));
		elem.click();
		
		screenShot = new ScreenShot_Handler(driver, "Appium_Framework_v2");

		String img = screenShot.takeScreenShot();

		ios.testResults(LogStatus.PASS, "UI_11_step02");
	}

	@Test(priority = 2)
	public void UI_11_step03() {
		WebElement elem = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Further Detail\"]"));
		boolean result = elem.isDisplayed();
		
		screenShot = new ScreenShot_Handler(driver, "Appium_Framework_v2");

		ios.testResults(LogStatus.PASS, "UI_11_step03");
	}

	@Test(priority = 3)
	public void UI_11_step04() {
		WebElement elem = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"stepper increment\"]"));
		elem.click();

		ios.testResults(LogStatus.PASS, "UI_11_step04");
	}
	
	@Test(priority = 4)
	public void UI_11_step05() {
		
		WebElement elem = driver.findElement(AppiumBy.xpath("//XCUIElementTypeApplication[@name=\"UIKitCatalog\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther"));
		boolean result = elem.isDisplayed();
		
		ios.testResults(LogStatus.PASS, "UI_11_step05");
		
		GenerateReport.closeExtentReports();
	}


}
