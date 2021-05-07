package common;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utilities.TestUtils;

public class Listeners extends BaseTestClass implements ITestListener{
	

	TestUtils screencapture = new TestUtils();
	
	public void onTestStart(ITestResult result) {
	
		System.setProperty("org.uncommons.reportng.title","Danny's Tests");
		System.out.println("Starting Test");
	}

	public void onTestSuccess(ITestResult result) {
	
		Reporter.log("Test Case: " + result.getName() + " - Passed");		
//		 public static void markTestStatus(String status, String reason, WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Test Case Passed\"}}");
			  }
		
	
	public void onTestFailure(ITestResult result) {
		Reporter.log("Test Case: "+ result.getName() + " - Failed");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Test Case Failed\"}}");
		
		System.out.println("Test Case: "+ result.getName() + result.getStatus());
		try {
			screencapture.getScreenshot(result.getName());
		} catch (IOException e) {
			e.printStackTrace();  
		}

	}
	

}
