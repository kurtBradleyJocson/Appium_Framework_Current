package common;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import util.JSON_Reader;

public class Config_IOS {
	
	public static IOSDriver driver;
	
	JSON_Reader json;

	public Config_IOS(String appLocation) {
		// TODO Auto-generated constructor stub
		
		json = new JSON_Reader("ios");
		
		File fs=new File(appLocation);
		
		XCUITestOptions cap=new XCUITestOptions();
		
		cap.setDeviceName (json.getDeviceName());
		cap.setApp(fs.getAbsolutePath()) ; 
		cap.setAutomationName (json.getAutomationName());
		cap.setWdaLaunchTimeout(Duration.ofSeconds(20));
		
		try {
			driver=new IOSDriver(new URL ("http://127.0.0.1:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		driver.manage().timeouts().implicitlyWait (Duration.ofSeconds (20));
		
	}
	
	public IOSDriver getDriver() {
		return this.driver;
	}

}
