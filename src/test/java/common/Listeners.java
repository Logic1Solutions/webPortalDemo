package common;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utilities.TestUtils;

public class Listeners implements ITestListener{
	

	TestUtils screencapture = new TestUtils();
	
	public void onTestStart(ITestResult result) {
	
		System.setProperty("org.uncommons.reportng.title","Danny's Tests");
		System.out.println("Starting Test");
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test Case: " + result.getName() + " - Passed");		
		
	}
	public void onTestFailure(ITestResult result) {
		Reporter.log("Test Case: "+ result.getName() + " - Failed");
		System.out.println("Test Case: "+ result.getName() + result.getStatus());
		try {
			screencapture.getScreenshot(result.getName());
		} catch (IOException e) {
			e.printStackTrace();  
		}

	}
	

}
