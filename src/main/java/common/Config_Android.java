package common;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import util.JSON_Reader;

public class Config_Android {
	
	public static AppiumDriver driver;
	
	JSON_Reader json;

	public Config_Android(String appLocation) {
		// TODO Auto-generated constructor stub
		
		json = new JSON_Reader("android");
		
		
		String appPath = appLocation;
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, json.getPlatformName());
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, json.getAutomationName());
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, json.getUdid());
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, json.getDeviceName());
		desiredCapabilities.setCapability(MobileCapabilityType.APP, appPath);

//		URL url = null;
//		
//		try {
//			url = new URL("http://0.0.0.0:4723/wd/hub");
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		try {
			driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		driver.manage().timeouts().implicitlyWait (Duration.ofSeconds (20));
		
	}
	
	
	public AppiumDriver getDriver() {
		return this.driver;
	}
	


}
