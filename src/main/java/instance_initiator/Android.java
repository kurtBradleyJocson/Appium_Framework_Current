package instance_initiator;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import common.Config_Android;
import io.appium.java_client.AppiumDriver;
import object_repo.TestCase_Android_BaseClass;
import util.GenerateReport;
import util.ScreenShot_Handler;

public class Android extends TestCase_Android_BaseClass{
	
	Config_Android android;
	
	String img;
	
	public Android(String testTitle) {
		// TODO Auto-generated constructor stub
		
		android = new Config_Android(getTestApk());
		
		driver = android.getDriver();

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
	
	public AppiumDriver getDriver() {
		return this.driver;
	}
	
	public void inputTestData(String sheetName,List<WebElement> fields, Integer row) {
		testData.setSheetName(sheetName);
		Integer col = 1;
		for (WebElement input : fields) {
			input.sendKeys(testData.getData(row, col));
			col++;
		}
		
		
	}

}
