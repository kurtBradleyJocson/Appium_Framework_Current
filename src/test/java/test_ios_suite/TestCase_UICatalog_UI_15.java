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

public class TestCase_UICatalog_UI_15 extends TestCase_IOS_BaseClass {
	
	IOS ios;
	IOSDriver driver;
	
	IOSGestures gesture;
	
	@Test(priority = 0)
	public void UI_15_step01() {
		
		ios = new IOS("UI_15");
		
		driver = ios.getDriver();

		gesture = new IOSGestures(driver);
		
		
		WebElement stackViews = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow"));
		
		RemoteWebElement anchor = (RemoteWebElement) stackViews;
		
		gesture.scroll("down", anchor, 1);
		
		ios.testResults(LogStatus.PASS, "UI_15_step01");

	}
	
	@Test(priority = 1)
	public void UI_15_step02() {
		WebElement elem = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Web View']"));
		elem.click();
		
		ios.testResults(LogStatus.PASS, "UI_15_step02");

	}
	
	@Test(priority = 2)
	public void UI_15_step03() throws InterruptedException {
		Thread.sleep(3000);
		WebElement elem = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"This is HTML content inside a \"]"));
		
		ios.testResults(LogStatus.PASS, "UI_15_step03 - content: " + elem.getText());
		GenerateReport.closeExtentReports();
		
	}
	

}
