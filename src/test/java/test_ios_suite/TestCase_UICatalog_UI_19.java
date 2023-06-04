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

public class TestCase_UICatalog_UI_19 extends TestCase_IOS_BaseClass {
	
	IOS ios;
	IOSDriver driver;
	
	IOSGestures gesture;

	@Test(priority = 0)
	public void UI_19_step01() {
		
		ios = new IOS("UI_19");
		
		driver = ios.getDriver();

		gesture = new IOSGestures(driver);
		
		
		WebElement alertViews= driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Alert Views']"));

		alertViews.click();
		
		ios.testResults(LogStatus.PASS, "UI_19_step01");
		
	}
	
	@Test(priority = 1)
	public void UI_19_step02() {
		WebElement confirmCancel = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Confirm / Cancel\"]"));
		
		confirmCancel.click();
		
		ios.testResults(LogStatus.PASS, "UI_19_step02");
	}
	
	boolean validateBtnConfirm;
	boolean validateBtnCancel;
	WebElement btnConfirm;
	
	@Test(priority = 2)
	public void UI_19_step03() {
		
		btnConfirm = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Confirm\"]"));
		
		validateBtnConfirm = btnConfirm.isDisplayed();
		
		WebElement btnCancel = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"Cancel\"]"));
				
		validateBtnCancel = btnCancel.isDisplayed();
		
		ios.testResults(LogStatus.PASS, "UI_19_step03");
	}
	
	
	@Test(priority = 3)
	public void UI_19_step04() {
		btnConfirm.click();
		
		ios.testResults(LogStatus.PASS, "UI_19_step04");
		
		GenerateReport.closeExtentReports();
		
	}


}
