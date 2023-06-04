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

public class TestCase_UICatalog_UI_06 extends TestCase_IOS_BaseClass {

	IOS ios;
	IOSDriver driver;
	
	IOSGestures gesture;
	
	@Test(priority = 0)
	public void UI_06_step01() {

		ios = new IOS("UI_06");
		
		driver = ios.getDriver();

		gesture = new IOSGestures(driver);

		WebElement pickerView = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Picker View']"));
		pickerView.click();

		ios.testResults(LogStatus.PASS, "UI_06_step01");

	}

	@Test(priority = 1)
	public void UI_06_step02() {
		
		ios.testResults(LogStatus.PASS, "UI_06_step01 - first color: ");

		WebElement redColor = driver
				.findElement(AppiumBy.xpath("//XCUIElementTypePickerWheel[@name=\"Red color component value\"]"));
		WebElement greenColor = driver
				.findElement(AppiumBy.xpath("//XCUIElementTypePickerWheel[@name=\"Green color component value\"]"));
		WebElement blueColor = driver
				.findElement(AppiumBy.xpath("//XCUIElementTypePickerWheel[@name=\"Blue color component value\"]"));

		String firstColor = redColor.getText() + greenColor.getText() + blueColor.getText();

		redColor.sendKeys("255");
		greenColor.sendKeys("255");
		blueColor.sendKeys("255");

		String newColor = redColor.getText() + greenColor.getText() + blueColor.getText();

		boolean result = firstColor != newColor ? true : false;

		ios.testResults(LogStatus.PASS, "UI_06_step01 - new color: ");
		
		GenerateReport.closeExtentReports();

	}

}
