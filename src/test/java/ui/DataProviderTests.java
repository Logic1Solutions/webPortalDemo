package ui;

import org.testng.annotations.Test;

public class DataProviderTests {
	
	@Test(dataProvider = "login",dataProviderClass=DataProviderClass.class)
	public void dataCaller01(String username, String password) {
		
		System.out.println("Username: "+username + "  Password: "+ password);
	}
	
	@Test(dataProvider = "login",dataProviderClass=DataProviderClass.class)
	public void dataCaller02(String username, String password, int age) {
		
		System.out.println("Username: "+username + "  Password: "+ password + "  Age: "+ age);
		
		
	}
	
	

}
