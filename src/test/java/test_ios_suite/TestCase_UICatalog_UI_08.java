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

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import common.Config_IOS;
import instance_initiator.IOS;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import object_repo.IOSGestures;
import object_repo.TestCase_IOS_BaseClass;
import util.GenerateReport;
import util.ScreenShot_Handler;



public class TestCase_UICatalog_UI_08 extends TestCase_IOS_BaseClass {
	
	IOS ios;
	IOSDriver driver;
	
	IOSGestures gesture;
	

	@Test(priority = 0)
	public void UI_08_step01() {
		
		ios = new IOS("UI_08");
		
		driver = ios.getDriver();

		gesture = new IOSGestures(driver);
		
		
		WebElement sliders = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Search']"));
		sliders.click();
		
		ios.testResults(LogStatus.PASS, "UI_08_step01");

	}
	
	@Test(priority = 1)
	public void UI_08_step02() {
		
		WebElement defaultNav = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Default']"));
		defaultNav.click();
		
		ios.testResults(LogStatus.PASS, "UI_08_step02");


	}
	
	@Test(priority = 2)
	public void UI_08_step03() {
		
		WebElement scopeTwo = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='Scope Two']"));
		scopeTwo.click();
		
		ios.testResults(LogStatus.PASS, "UI_08_step03 - scope 2");
		
		WebElement scopeOne = driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name='Scope One']"));
		scopeOne.click();
		
		ios.testResults(LogStatus.PASS, "UI_08_step03 - scope 1");
		



	}
	
	@Test(priority = 3)
	public void UI_08_step04() {
		
		driver.navigate().back();
		
		ios.testResults(LogStatus.PASS, "UI_08_step04");

	}
	
	@Test(priority = 4)
	public void UI_08_step05() {
		
		WebElement customNav = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Custom']"));
		customNav.click();
		
		ios.testResults(LogStatus.PASS, "UI_08_step05");

	}
	
	
	WebElement search;
	
	@Test(priority = 5)
	public void UI_08_step06() {
		
		search = driver.findElement(AppiumBy.xpath("//XCUIElementTypeSearchField"));
		search.click();
		
		ios.testResults(LogStatus.PASS, "UI_08_step06");
		
	}
	
	@Test(priority = 6)
	public void UI_08_step07() throws InterruptedException {
		
		search.sendKeys("A");
		
		Thread.sleep(1000);
		
		ios.testResults(LogStatus.PASS, "UI_08_step07: A");
		
		Thread.sleep(2000);
		
		search.sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(1000);
		
		ios.testResults(LogStatus.PASS, "UI_08_step07: Backspace");
		
		Thread.sleep(2000);
		
		search.sendKeys("B");
		
		Thread.sleep(1000);
		
		ios.testResults(LogStatus.PASS, "UI_08_step07: B");
		
		Thread.sleep(2000);
		
		search.sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		
		ios.testResults(LogStatus.PASS, "UI_08_step07: Enter");
		
		GenerateReport.closeExtentReports();
		
	}
	
	
}
