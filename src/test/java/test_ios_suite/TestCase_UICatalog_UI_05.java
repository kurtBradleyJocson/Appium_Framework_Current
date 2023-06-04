package test_ios_suite;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class TestCase_UICatalog_UI_05 extends TestCase_IOS_BaseClass {

	IOS ios;
	IOSDriver driver;
	
	IOSGestures gesture;

	@Test(priority = 0)
	public void UI_05_step01() {
		
		ios = new IOS("UI_05");
		
		driver = ios.getDriver();

		gesture = new IOSGestures(driver);

		WebElement pageControl = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name='Page Control']"));
		pageControl.click();
		
		ios.testResults(LogStatus.PASS, "UI_05_step01");
	
	}
	
	@Test(priority = 1)
	public void UI_05_step02() {

		WebElement colorControl = driver.findElement(AppiumBy.xpath("//XCUIElementTypePageIndicator"));
		String firstPage = colorControl.getText();
		int countChange = 0;
		
		colorControl.sendKeys("1");
		String secondPage = colorControl.getText();
		
		countChange = secondPage != firstPage ? countChange += 1: 0;
		
		colorControl.sendKeys("2");
		String thirdPage = colorControl.getText();
		
		countChange = thirdPage != secondPage ? countChange += 1: 0;

		ios.testResults(LogStatus.PASS, "UI_05_step02 - page change count: " + countChange);
		
		GenerateReport.closeExtentReports();
		
	}
	

	

}
