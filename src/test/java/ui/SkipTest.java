package ui;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTest {

	boolean data = false;
	
	@Test(enabled=false)
	public void skipTest01() {
		System.out.println("Skipping TC as is not yet complete");
	}

	@Test
	public void skipTest02() {
		if(data==true) {
			System.out.println("Test02 Executed");
		} else {
			throw new SkipException("skipTest02 is skipped");
		}
		
		System.out.println("Skipping TC as is not yet complete");
	}

	@Test
	public void skipTest03() {
		System.out.println("Skipping TC as is not yet complete");
		throw new SkipException("Skipping TC by throwing exception"); 
	}

	
	@Test
	public void pageReview() {
		System.out.println("Working TC for execution");
	}
	
}
