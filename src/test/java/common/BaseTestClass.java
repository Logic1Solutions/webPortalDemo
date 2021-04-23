package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass {

	public static WebDriver driver = null;
	
	@Parameters({"browser"})
	@BeforeTest
	public void lauchBrowser(String browser) {		
	//	WebDriverManager.firefoxdriver().setup();
	//	driver = new FirefoxDriver();
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();	
		}
		else if(browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
		

	
	
}
