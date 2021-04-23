package ui;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {

	@BeforeClass
	public void beforeLoginClass() {
		System.out.println("@BeforeClass_Login --->");
	}
	
	@AfterClass
	public void afterLoginClass() {
		System.out.println("@AfterClass_Login --->");
	}
	
	@BeforeTest
	public void initApplication() {
		System.out.println("@BeforeTest_Login - Initialize Login Details");
	}
	
	@AfterTest
	public void closeApplication() {
		System.out.println("@AfterTest_Login - Closing Application");
	}
	
	@BeforeMethod
	public void launchLoginPage() {
		System.out.println("   --- @BeforeMethod_Login --- Login Page is displayed");
	}
	
	@AfterMethod
	public void closeLoginPage() {
		System.out.println("   --- @AfterMethod_Login --- Closing Login Page");
	}
	
	@Test(description = "This is a Login Test")
	public void loginTest01() {
		System.out.println("    --- @Test --- Login is successful");
	}
	
	@Test (description = "This is a Logout Test")
	public void logoutTest01() {
		System.out.println("    ---@Test --- Logout is successful");
	}
	
	@Test(priority=0, description = "This is a Login Test")
	public void loginTest02() {
		System.out.println("    --- @Test --- Login is successful");
	}
	
	
}
