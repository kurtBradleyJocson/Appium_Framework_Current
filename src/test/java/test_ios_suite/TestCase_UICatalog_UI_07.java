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
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;
import object_repo.IOSGestures;
import object_repo.TestCase_IOS_BaseClass;
import util.GenerateReport;
import util.ScreenShot_Handler;

public class TestCase_UICatalog_UI_07 extends TestCase_IOS_BaseClass {
	
	IOS ios;
	IOSDriver driver;
	
	IOSGestures gesture;
	

	@Test(priority = 0)
	public void UI_07_step01() {
		
		ios = new IOS("UI_07");
		
		driver = ios.getDriver();

		gesture = new IOSGestures(driver);

		WebElement progressViews = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Progress Views']"));
		progressViews.click();
		
		ios.testResults(LogStatus.PASS, "UI_07_step01");
	
	}
	
	@Test(priority = 1)
	public void UI_07_step02() throws InterruptedException {
		WebElement defaultBar = driver.findElement(AppiumBy.xpath("(//XCUIElementTypeProgressIndicator[@name=\"Progress\"])[1]"));
		String initialValue = defaultBar.getText();
		
		Thread.sleep(5000);

		boolean result = initialValue != defaultBar.getText();
		
		
		ios.testResults(LogStatus.PASS, "UI_07_step01 - Bar counting: " + result);
		
		GenerateReport.closeExtentReports();

	}
	

}
