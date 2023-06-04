package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class ScreenShot_Handler {

	AppiumDriver driver;
	
	String project;

	public ScreenShot_Handler(AppiumDriver driver, String project) {
		
		this.driver = driver;
		this.project = project;

	}
	
	public ScreenShot_Handler(IOSDriver driver, String project) {
		
		this.driver = driver;
		this.project = project;

	}
	
	public String takeScreenShot() {

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String timestamp = formatter.format(date);
		
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy");
		String day = formatter2.format(date);
		
		String userDir = System.getProperty("user.home");
//		String filePath = userDir + "/eclipse-workspace/" + project + "/ScreenShot/"+timestamp+".png";
		
		String filePath = userDir + "/Desktop/"+day+"/screenshots/" + timestamp +".png";
		

		try {
		    FileUtils.copyFile(screenshotFile, new File(filePath));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		return filePath;
	}

}
