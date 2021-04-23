package ui;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

@Test (groups = "Registration")
public class GroupTest {
	

	@BeforeClass
	public void beforeGroupTestClass() {
		System.out.println("    --- @BeforeClass_GroupTest ---    ");
	}
	
	@AfterClass
	public void afterGroupTestClass() {
		System.out.println("    --- @AfterClass_GroupTest ---");
	}
	
	@BeforeGroups(value="Regression")
	public void beforeGroupTest() {
		System.out.println("Running this method before regression TCs");
	}
	
	@AfterGroups(value="Regression")
	public void afterGroupTest() {
		System.out.println("Running this method after regression TCs");
	}
	
	
	
	@Test(groups = "Login Tests")
	public void aTest01() {
		System.out.println("    --- @Test --- Login01 is successful");
	}
	
	@Test (groups = "Logout Tests")
	public void logoutTest01() {
		System.out.println("    ---@Test --- Logout01 is successful");
	}
	
	@Test (groups = "Logout Tests")
	public void logoutTest02() {
		System.out.println("    ---@Test --- Logout02 is successful");
	}
	
	@Test (groups = {"Logout Tests", "Regression"})
	public void logoutTest99() {
		System.out.println("    ---@Test --- Logout99 is successful");
	}
	
	@Test(priority=0, groups = "Login Tests")
	public void aTest02() {
		System.out.println("    --- @Test --- Login02 is successful");
	}
	
	@Test(priority=0, groups = {"Login Tests","Regression"})
	public void aTest99() {
		System.out.println("    --- @Test --- Login99 is successful");
	}

	
	
}
