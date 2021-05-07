package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestListener;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import utilities.TestUtils;

public class Vshred extends TestUtils implements ITestListener{
		
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void initializePage() {
		
		driver.navigate().to("https://vshred.com/");
	}
	
	@Test (enabled = false,priority = 1)
	public void verifyVshredPageTitle() {
		String expectedPageTitle = "V Shred";
		String actualPageTitle = driver.getTitle();
		softAssert.assertEquals(expectedPageTitle, actualPageTitle);
		System.out.println("Page title: " + actualPageTitle);
	}
	
	@Test(enabled = false,priority = 2)
	public void verifyMenuList() {
		
		List<WebElement> menuList = driver.findElements(By.xpath("//*[@class='menu-horizontal text-left']/li/a"));
		
		String [] expectedMenu = {"HOME","PROGRAMS","SUPPLEMENTS", "CLOTHING","bLOG", "ABOUT"};
		System.out.println("Title : URL");
		
		for (WebElement list : menuList) {
			softAssert.assertEquals(expectedMenu, list.getText());	
			
			System.out.println(list.getText() + " : " + list.getAttribute("href"));
			}
		}
	
	@Test (enabled = false,priority = 3)
	public void verifyGenderSelector() {
		WebElement genderHeader = driver.findElement(By.xpath("//h3[contains(text(),'What is your gender?')]"));
		
		System.out.println("Gender Header: " + genderHeader.getText());
		List<WebElement> genderSelect = driver.findElements(By.xpath("//*[@class = 'gender-selector__ctas']/a"));
		String [] gender ={"MALE","FEMALE"};
		System.out.println("Title : URL");
		
		for (WebElement x : genderSelect) {
			softAssert.assertEquals(gender, x.getText());
			
			System.out.println(x.getText() + " : " + x.getAttribute("href") );
		}
	}
	
	@Test (priority = 4)
	public void verifyGenderLinks() throws InterruptedException {
		
		WebElement giftElement = driver.findElement(By.xpath("//h2[contains(text(),'Our Gift To You!')]"));
		Actions action = new Actions(driver);
		action.moveToElement(giftElement);
		action.perform();
		Thread.sleep(3000);
		
		
		List <WebElement> supplementGuideLinks = driver.findElements(By.xpath("//*[@class = 'supplement-guide-links']/div/a"));
		
		for (WebElement suppLinks : supplementGuideLinks) {
			softAssert.assertTrue(suppLinks.isEnabled());
			System.out.println(suppLinks.getText());
		
//			driver.findElement(By.xpath("//a[contains(text(),'Men - Click Here!')]")).click();
		}
		
		
	}
	
	
}
