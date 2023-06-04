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

public class TestCase_UICatalog_UI_03 extends TestCase_IOS_BaseClass{
	
	IOS ios;
	IOSDriver driver;
	
	IOSGestures gesture;
	
	@Test(priority = 0)
	public void UI_03_step01() {
		
		ios = new IOS("UI_03");
		
		driver = ios.getDriver();

		gesture = new IOSGestures(driver);

		WebElement datePicker = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Date Picker']"));
		datePicker.click();
		
		ios.testResults(LogStatus.PASS, "UI_03_step01");
		
	}

	@Test(priority = 1)
	public void UI_03_step02(){
		
		WebElement datePicker = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[contains(@name, '20')]"));
		datePicker.click();

		WebElement previousMonth = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Previous Month\"]"));
		boolean validatePrevious = previousMonth.isEnabled();
		
		LogStatus result;
		
		if(!validatePrevious) {
			result = LogStatus.FAIL;
		}else {
			result = LogStatus.PASS;
		}

		ios.testResults(result, "UI_03_step02 - result: " + result);
		
		GenerateReport.closeExtentReports();

	}
	


}
