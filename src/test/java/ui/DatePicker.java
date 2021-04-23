package ui;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	static WebDriver driver = null;

	@BeforeMethod
	public void openExpedia() {

		WebDriverManager.chromedriver().setup();	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.expedia.com/");
		String windowHandle = driver.getWindowHandle();
		System.out.println("Window Handle: " + windowHandle);
	}
	@AfterMethod
	public void closeExpedia() {
		driver.close();
	}

	@Test
	public void selectDates() throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Flights')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Roundtrip')]")).click();

		driver.findElement(By.xpath("//button[@aria-label = 'Leaving from']")).sendKeys("SFO");
		driver.findElement(By.xpath("//strong[contains(text(),'San Francisco (SFO - San Francisco Intl.)')]")).click();
		driver.findElement(By.xpath("//button[@aria-label = 'Going to']")).sendKeys("NYC");
		driver.findElement(By.xpath("//strong[contains(text(),'Newark (EWR - Liberty Intl.)')]")).click();;

		driver.findElement(By.xpath("//button[@id='d1-btn']")).click();
		
		Thread.sleep(2000);
		String departingDate = "16-July 2021";
		String splitter[] = departingDate.split("-");
		String departDay = splitter[0];
		String departMonthYear = splitter[1];
		System.out.println(departMonthYear + " Day:" + departDay);

		dateSelect(departMonthYear, departDay);
		driver.findElement(By.xpath("//span[contains(text(),'Roundtrip')]")).click();
		
		
		driver.findElement(By.xpath("//button[@id='d2-btn']")).click();
		Thread.sleep(3000);
		String returningDate = "21-July 2021";
		splitter = returningDate.split("-");
		String returnDay = splitter[0];
		String returnMonthYear = splitter[1];
		System.out.println(returnMonthYear + " Day:" + returnDay);
		
		dateSelect(returnMonthYear, returnDay);
		driver.findElement(By.xpath("//span[contains(text(),'Roundtrip')]")).click();
		Thread.sleep(2000);

		
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//legend[@id='Airlines-legend']")));
		System.out.println("Select Dates successfull ");
		
		assert driver.getWindowHandles().size() == 1;
	}

	public static void dateSelect(String month_year, String sel_day) throws InterruptedException {

		String calendarMonthxp = "//div[@class='uitk-calendar']/div/div/h2";
		List<WebElement> months = driver.findElements(By.xpath(calendarMonthxp));
		
		for (int i=0; i<months.size();i++) {
			//System.out.println(months.get(i).getText());

			if(months.get(i).getText().equalsIgnoreCase(month_year)) {
				System.out.println("Month Selected: " + months.get(i).getText());				
						
				List<WebElement> days = driver.findElements(By.xpath("//div[@class='uitk-calendar']/div[2]/div["+(i+1)+"]/table/tbody/tr/td/button"));
				
				for (WebElement xday : days) {
					//if(xday.getAttribute("data-day").equalsIgnoreCase(day)) {
					//System.out.println("Days: "+ xday.getAttribute("data-day"));
					if(xday.getAttribute("data-day").equals(sel_day)) {	
						System.out.println("Date: "+ xday.getAttribute("data-day"));
						xday.click();		
						return;
					}
				}
			}	
		}	
//		while (months.get(i).getText()!=(month_year)) {
			driver.findElement(By.xpath("(//button[@data-stid='date-picker-paging'])[2]")).click();
			driver.findElement(By.xpath("(//button[@data-stid='date-picker-paging'])[2]")).click();
			Thread.sleep(2000);	
			dateSelect(month_year, sel_day);
		}
	}
	




