package ui;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

public class DataProviderClass{

	@DataProvider(name = "login")
	public Object[][] dataSet01(Method m) {
		
		Object[][] dataSet = null;
		
		if(m.getName().equals("dataCaller01")) {
			
			System.out.println("Test Data Provider Set01");
			dataSet = new Object[][] {{"user01", "pass01"},
										{"user02","pass02"},
										{"user03","pass03"}
									};
		}
		else if(m.getName().equals("dataCaller02")) {
			System.out.println("Test Data Provider Set02");
			dataSet = new Object [][] {{"username01", "password01",Integer.valueOf(36)},
										{"username02","password02", Integer.valueOf(21)},
										{"username03","password03",Integer.valueOf(25)},
										{"Danny","Me",Integer.valueOf(41)}
									};
		}
		else if(m.getName().equals("sauceLabLogin")) {
			dataSet = new Object[][] {{"standard_user", "secret_sauce"},
										{"locked_out_user","secret_sauce"},
										{"problem_user","secret_sauce"},
										{"performance_glitch_user","secret_sauce"}
									};
			
		}
		return dataSet;	
	}
}
