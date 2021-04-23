package ui;

import org.testng.annotations.Test;

import common.CommonDataSetup;

@Test (groups = "Registration")
public class GroupTest2 extends CommonDataSetup {
	

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
