package common;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass {

	public static WebDriver driver = null;
	public static final String AUTOMATE_USERNAME = "workandlifebalan_adNEIw";
	public static final String AUTOMATE_ACCESS_KEY = "mAmxo8jva2DUHs7kQtFx";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	
	@BeforeTest
	public static void browserStackCapabilities() throws Exception{
		
//		  public static void main(String[] args)  {
		    DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("os_version", "10");
		    caps.setCapability("resolution", "1920x1080");
		    caps.setCapability("browser", "Chrome");
		    caps.setCapability("browser_version", "88.0");
		    caps.setCapability("os", "Windows");
		    caps.setCapability("name", "VShred Test"); // test name
		    caps.setCapability("build", "BuildNo 1"); // CI/CD job or build name
//		    caps.setCapability("browserstack.debug", "true");	//enable visual log
//		    caps.setCapability("browserstack.video", "false");  // disables video log
		    driver = new RemoteWebDriver(new URL(URL), caps);
	}
	
	
	
//	@Parameters({"browser"})
//	@BeforeTest
//	public void lauchBrowser(String browser) {				
//		if(browser.equals("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();	
//		}
//		else if(browser.equals("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();	
//		}
//		else if(browser.equals("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();	
//		}
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		
//		
//	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
		

	
	
}
