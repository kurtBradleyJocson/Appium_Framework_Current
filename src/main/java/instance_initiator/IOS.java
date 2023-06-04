package instance_initiator;

import java.time.Duration;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import common.Config_Android;
import common.Config_IOS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import object_repo.TestCase_Android_BaseClass;
import object_repo.TestCase_IOS_BaseClass;
import util.GenerateReport;
import util.ScreenShot_Handler;

public class IOS extends TestCase_IOS_BaseClass{
	
	Config_IOS ios;
	
	String img;
	
	public IOS(String testTitle) {
		// TODO Auto-generated constructor stub
		
		ios = new Config_IOS(getTestApp());
		
		driver = ios.getDriver();

		driver.manage().timeouts().implicitlyWait (Duration.ofSeconds (20));
		
		screenShot = new ScreenShot_Handler(driver, project);
		
		img = screenShot.takeScreenShot();
		
		test = GenerateReport.generateExtentReports(project,testTitle);
	}
	
	public void testResults(LogStatus log, String details) {
		String imgPath = screenShot.takeScreenShot();
		String filename = imgPath.substring(imgPath.lastIndexOf("/") + 1);
		test.log(log, details, test.addScreenCapture("../../../screenshots/"+filename));
	}
	
	public IOSDriver getDriver() {
		return this.driver;
	}

}
