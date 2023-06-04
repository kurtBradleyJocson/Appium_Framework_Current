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

public class TestCase_UICatalog_UI_10 extends TestCase_IOS_BaseClass {
	
	IOS ios;
	IOSDriver driver;
	
	IOSGestures gesture;

	@Test(priority = 0)
	public void UI_10_step01() {
		
		ios = new IOS("UI_10");
		
		driver = ios.getDriver();

		gesture = new IOSGestures(driver);
		
		WebElement elem = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Sliders']"));
		elem.click();
		
		ios.testResults(LogStatus.PASS, "UI_10_step01");
	
	}
	
	@Test(priority = 1)
	public void UI_10_step02() {
		WebElement elem = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`value == \"42%\"`]"));
		elem.sendKeys("0");
		
		ios.testResults(LogStatus.PASS, "UI_10_step02");

	}
	
	@Test(priority = 2)
	public void UI_10_step03() {
		WebElement elem = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`value == \"50%\"`][1]"));
		elem.sendKeys("1");
		
		ios.testResults(LogStatus.PASS, "UI_10_step03");
	}
	
	@Test(priority = 3)
	public void UI_10_step04() {
		WebElement elem = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`value == \"84%\"`]"));
		elem.sendKeys("0.5");
		
		ios.testResults(LogStatus.PASS, "UI_10_step04");
		
		GenerateReport.closeExtentReports();

	}


}
