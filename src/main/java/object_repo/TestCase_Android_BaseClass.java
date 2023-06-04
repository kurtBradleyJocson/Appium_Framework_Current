package object_repo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import common.Config;
import common.Config_Android;
import io.appium.java_client.AppiumDriver;
import util.GenerateReport;
import util.ScreenShot_Handler;
import util.TestData;

public class TestCase_Android_BaseClass {
	
	public AppiumDriver driver;
	
	Config_Android android;
	
	public ExtentTest test;
	
	public ScreenShot_Handler screenShot;
	
	public TestData testData;
	
	public String project;
	
	String testApp;
	
	public TestCase_Android_BaseClass() {
		
		project = "Appium_Framework_v2";
		
		testApp = System.getProperty("user.dir") + "/resources/bankappdemo.apk";

		try {
			testData = new TestData(project);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	public String getTestApk() {
		return testApp;
	}

}
