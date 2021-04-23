package ui;

import org.openqa.selenium.By;
import org.testng.ITestListener;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import utilities.TestUtils;

public class Amazon_NewMouse extends TestUtils implements ITestListener{
	
//	WebDriver  driver = null;
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void initializePage() {
	
		driver.navigate().to("http://www.amazon.com/");			
	}
	
	@Test (priority=0)
	public void verifyPageTitle() {
		
		String expectedPageTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		String expectedCovidText = "Amazon's response to COVID-19";
		
		System.out.println("Page Title verification");
		
		String actualPageTitle = driver.getTitle();
		softAssert.assertEquals(actualPageTitle, expectedPageTitle);
		
		System.out.println("Covid Text verification");
		String actualCovidText = driver.findElement(By.id("swm-link")).getText();
		
		softAssert.assertEquals(actualCovidText, expectedCovidText,"Text mismatch");
		softAssert.assertAll();
		
	}
	
//	@Test (priority =1, retryAnalyzer = common.MyRetry.class)
	@Test (priority =1)
	public void searchMouse() {
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mouse");
		driver.findElement(By.id("nav-search-submit-button")).click();
		boolean mouseUnderTest = driver.findElement(By.partialLinkText("Jelly Comb 2.4G Slim Wireless Mouse")).isDisplayed();
		
		softAssert.assertTrue(mouseUnderTest);
		
		driver.findElement(By.xpath("//*[contains(@alt, 'Jelly Comb 2.4G Slim Wireless Mouse with Nano Receiver')]")).click();
		String actualMouseTitle = driver.findElement(By.cssSelector("#productTitle")).getText();
		String expectedMouseTitle ="1Jelly Comb 2.4G Slim Wireless Mouse with Nano Receiver MS001 (Black and Gold)";
		
		softAssert.assertEquals(actualMouseTitle, expectedMouseTitle);
		softAssert.assertAll();
		
	}
	
	
}
