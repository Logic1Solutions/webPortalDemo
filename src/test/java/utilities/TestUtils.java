package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import common.BaseTestClass;

public class TestUtils extends BaseTestClass {
	
	
	public void getScreenshot(String tcaseName) throws IOException {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		LocalDate currentDate = LocalDate.now(); 
		String projectPath = System.getProperty("user.dir");
		String imagePath = projectPath+"\\screenshot\\";
		//String screenshotFilename = currentDate.toString().replace(" ", "-").replace(":","/");
		String screenshotFileName = (tcaseName+"_"+currentDate.toString().replace(" ", "-").replace(":", "-"));
		System.out.println(imagePath + currentDate);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
		
		File screenshotName = new File(imagePath + "\\screenshot\\"+screenshotFileName+".png");
		FileUtils.copyFile(screenshotFile, screenshotName);
		
		Reporter.log("<br>  <img src='"+screenshotName+"' height='100' width='100' /><br>");
        Reporter.log("<a href="+screenshotName+"></a>");
		}

}
