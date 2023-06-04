package object_repo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import common.Config;
import common.Config_Android;
import common.Config_IOS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import util.GenerateReport;
import util.ScreenShot_Handler;
import util.TestData;

public class TestCase_IOS_BaseClass {
	
	public IOSDriver driver;
	
	Config_IOS ios;
	
	public ExtentTest test;
	
	public ScreenShot_Handler screenShot;
	
	public TestData testData;
	
	public String project;
	
	String testApp;
	
	public TestCase_IOS_BaseClass() {
		
		this.project = "Appium_Framework_v2";
		
		testApp = System.getProperty("user.dir") + "/resources/UIKitCatalog.app";
		
		try {
			testData = new TestData(project);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getTestApp() {
		return testApp;
	}

}
