package ui;

import org.testng.annotations.Test;
import common.BaseTestClass;

public class ListenerTestCase extends BaseTestClass{

	@Test
	public void launchApp() {
		driver.get("http://www.google.com");
		
	}

}
