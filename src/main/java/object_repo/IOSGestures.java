package object_repo;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class IOSGestures {
	
	static IOSDriver driver;

	public IOSGestures(IOSDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		
	}
	
	
	public void scroll(String direction, WebElement element, int distance) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Map<String, Object> params = new HashMap<>();
		params.put("direction", direction);
		params.put("element", ((RemoteWebElement) element).getId());
		params.put("distance", distance);
		js.executeScript("mobile: scroll", params);
	}
	
	public void dragDrop(WebElement elem, int origin_x, int origin_y, int toX, int toY) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Map<String, Object> params = new HashMap<>();
		params.put("duration", 1.0);
		params.put("fromX", origin_x);
		params.put("fromY", origin_y);
		params.put("toX", toX);
		params.put("toY", toY);
		params.put("element", ((RemoteWebElement) elem).getId());
		js.executeScript("mobile: dragFromToForDuration", params);
		
	}
	
	//TODO
	public void swipe(WebElement elem, int origin_x, int origin_y, int toX, int toY) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Map<String, Object> params = new HashMap<>();
		params.put("direction", "right");
		params.put("fromX", origin_x);
		params.put("fromY", origin_y);
		params.put("toX", toX);
		params.put("toY", toY);
		params.put("element", ((RemoteWebElement) elem).getId());
		js.executeScript("mobile: swipe", params);
		
	}
	

}
