package object_repo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class AndroidGestures {

	static AppiumDriver driver;

	public AndroidGestures(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void swipeUp(int distance) {
		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
				ImmutableMap.of("left", 100, "top", distance, "width", 200, "height", distance, "direction", "down",
						"percent", 3.0));
	}

	public void swipeDown(int distance) {
		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
				ImmutableMap.of("left", 100, "top", distance, "width", 200, "height", distance, "direction", "up",
						"percent", 3.0));
	}

	public void dragAndDrop(WebElement element) {

		WebElement dragDot = element;

		int startX = dragDot.getLocation().getX() + dragDot.getSize().getWidth() / 2;
		int startY = dragDot.getLocation().getY() + dragDot.getSize().getHeight() / 2;
		int endX = startX + 100;
		int endY = startY + 100;

		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) dragDot).getId(), "startX", startX, "startY", startY, "endX", endX, "endY", endY));

	}

	public void seekBar(WebElement element) {

		WebElement seekBar = element;


		int startX = seekBar.getLocation().getX();
		System.out.println(startX);


		int startY = seekBar.getLocation().getY();
		System.out.println(startY);


		int endX = seekBar.getSize().getWidth();
		System.out.println(endX);


		int moveToXDirectionAt = (int) (endX * 0.9);
		System.out.println("Moving seek bar at " + moveToXDirectionAt + " In X direction.");


	}

}
