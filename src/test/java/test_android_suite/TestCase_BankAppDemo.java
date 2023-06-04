package test_android_suite;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import common.Config_Android;
import instance_initiator.Android;
import io.appium.java_client.AppiumDriver;
import object_repo.TestCase_Android_BaseClass;
import util.GenerateReport;
import util.ScreenShot_Handler;
import util.TestData;

public class TestCase_BankAppDemo extends TestCase_Android_BaseClass {

	Android android;
	AppiumDriver driver;

	@Test(priority = 0)
	public void BAD_01_testStep01() {

		android = new Android("Test Demo2");

		driver = android.getDriver();

		android.testResults(LogStatus.PASS, "BAD_01_Step01 - Launch App initiliazed through extended BaseClass");

	}

	@Test(priority = 1)
	public void BAD_01_testStep02() {

		WebElement btnCreateProfile1 = driver.findElement(By.xpath(
				"//android.widget.Button[@resource-id='com.example.mikebanks.bankscorpfinancial:id/btn_create_account']"));
		btnCreateProfile1.click();

		List<WebElement> fields = driver.findElements(By.xpath("//android.widget.EditText"));
		
		android.inputTestData("BAD01_Step02_CreateProfile",fields,1);

		WebElement btnCreateProfile2 = driver.findElement(By.xpath("//android.widget.Button"));
		btnCreateProfile2.click();

		android.testResults(LogStatus.PASS, "BAD_01_Step02");

	}

	@Test(priority = 2)
	public void BAD_01_testStep03() {

		List<WebElement> fields = driver.findElements(By.xpath("//android.widget.EditText"));

		android.inputTestData("BAD01_Step03_Login",fields,1);

		WebElement btnLogin = driver.findElement(By.xpath("//android.widget.Button"));
		btnLogin.click();

		android.testResults(LogStatus.PASS, "BAD_01_Step03");

	}

	@Test(priority = 3)
	public void BAD_01_testStep04() {

		testData.setSheetName("BAD01_Step04_Dashboard");

		String title = driver.findElement(By.xpath("//android.widget.TextView[@text='Dashboard']")).getText();

		String data = testData.getData(1, 1);

		boolean validateDashboard = title.equals(data) ? true : false;
		
		android.testResults(LogStatus.PASS, "BAD_01_Step04 - Homepage Title = Dashboard: ");

	}

	@Test(priority = 4)
	public void BAD_02_testStep01() {
		
		android.testResults(LogStatus.PASS, "BAD_02_Step01 - (BAD_01_Step01: Session)");

	}

	@Test(priority = 5)
	public void BAD_02_testStep02() {
		
		android.testResults(LogStatus.PASS, "BAD_02_Step02 - (BAD_01_Step02: Created Account and Credentials)");

	}

	@Test(priority = 6)
	public void BAD_02_testStep03() {

		WebElement btnHamburger = driver
				.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]"));
		btnHamburger.click();
		
		android.testResults(LogStatus.PASS, "BAD_02_Step03");


	}

	@Test(priority = 7)
	public void BAD_02_testStep04() {

		testData.setSheetName("BAD02_Step04_Accounts");

		WebElement itemAccounts = driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Accounts']"));
		itemAccounts.click();

		WebElement floatAddAccount = driver
				.findElement(By.id("com.example.mikebanks.bankscorpfinancial:id/floating_action_btn"));
		floatAddAccount.click();

		WebElement accnt_name = driver.findElement(By.id("com.example.mikebanks.bankscorpfinancial:id/edt_payee_name"));
		accnt_name.sendKeys(testData.getData(1, 1));

		WebElement init_bal = driver.findElement(By.id("com.example.mikebanks.bankscorpfinancial:id/edt_init_bal"));
		init_bal.sendKeys(testData.getData(1, 2));

		WebElement btnAdd = driver.findElement(By.xpath("//android.widget.Button[@text='ADD']"));
		btnAdd.click();
		
		android.testResults(LogStatus.PASS, "BAD_02_Step04");

	}

	@Test(priority = 8)
	public void BAD_02_testStep05() {

		boolean validateNewAccount = driver.findElement(By.xpath("//android.view.ViewGroup")).isDisplayed();
		
		android.testResults(LogStatus.PASS, "BAD_02_Step05 - account details: " + validateNewAccount);
	}

	@Test(priority = 9)
	public void BAD_03_testStep01() {

		android.testResults(LogStatus.PASS, "BAD_03_testStep01 - (BAD_01_Step01: Session)");

	}

	@Test(priority = 10)
	public void BAD_03_testStep02() {
		
		android.testResults(LogStatus.PASS, "BAD_03_testStep02 - (BAD_01_Step02: Created Account and Credentials)");

	}

	@Test(priority = 11)
	public void BAD_03_testStep03() {

		WebElement btnHamburger = driver
				.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]"));
		btnHamburger.click();

		android.testResults(LogStatus.PASS, "BAD_02_Step03");

	}

	@Test(priority = 12)
	public void BAD_03_testStep04() {

		WebElement btnTransfer = driver
				.findElement(By.xpath("//android.widget.CheckedTextView[@text='Make a Transfer']"));
		btnTransfer.click();

		android.testResults(LogStatus.PASS, "BAD_02_Step04");

	}

	@Test(priority = 13)
	public void BAD_03_testStep05() {

		boolean validateAccount = driver
				.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).isDisplayed();
		
		android.testResults(LogStatus.PASS, "BAD_03_Step05 - Add Account Button: " + validateAccount);
	}

	@Test(priority = 15)
	public void BAD_03_testStep06() {

		WebElement btnAddAccount = driver
				.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']"));
		btnAddAccount.click();

		testData.setSheetName("BAD03_Step06_MakeTransfer");

		List<WebElement> fields = driver.findElements(By.xpath("//android.widget.EditText"));

		android.inputTestData("BAD03_Step06_MakeTransfer", fields, 1);

		WebElement btnAdd = driver.findElement(By.xpath("//android.widget.Button[@text='ADD']"));
		btnAdd.click();
		
		android.testResults(LogStatus.PASS, "BAD_03_Step06");

	}

	@Test(priority = 16)
	public void BAD_03_testStep07() {

		WebElement btnAccount2 = driver
				.findElement(By.xpath("//android.widget.TextView[contains(@text, 'Account no: A2')]"));
		btnAccount2.click();
		
		android.testResults(LogStatus.PASS, "BAD_03_Step07");

	}

	@Test(priority = 17)
	public void BAD_03_testStep08() {

		boolean detailsAccount2 = driver
				.findElement(By.id("com.example.mikebanks.bankscorpfinancial:id/txt_transaction_type_id"))
				.isDisplayed();
		
		android.testResults(LogStatus.PASS, "BAD_03_Step08 - Account Details: " + detailsAccount2);
		
		GenerateReport.closeExtentReports();
	}

}
