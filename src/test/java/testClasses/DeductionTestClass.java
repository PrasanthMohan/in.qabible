package testClasses;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.DeductionClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzer;
import utilities.RandomDataUtilityClass;

public class DeductionTestClass extends BaseClass {
			

	public HomePageClass hp;
	public LoginPageClass lp;
	public DeductionClass dt;
	
	@Test(priority = 1, groups = {"group1"}, retryAnalyzer = RetryAnalyzer.class)
	public void verifyToCreateClient() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		dt = new DeductionClass(driver);
		
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));
		hp.clickOnCreateDeduction();
		
		dt.createDeduction(
			dt.readStringData(13, 0),
			dt.readStringData(13, 1),
			dt.readIntegerData(13, 2),
			dt.readIntegerData(13, 3)	
			);
		
		String expectedResult = dt.readStringData(13, 0);
		String actualResult = dt.getDeductionEmplyeeName();
		boolean result = false;
		if (expectedResult.contains(actualResult)) {
			result = true;
		}	
		Assert.assertTrue(result);
	}
	

	
	@Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
	public void verifyDeductionView() throws IOException {
		lp = new LoginPageClass(driver);
		dt = new DeductionClass(driver);
		
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));
		
		dt.clickOnDeductionLink();
		String[] dedutionaData = dt.viewDeductionData();	

		dt.clickOnFirstDeductionLink();
		String[] foundData = dt.viewPageData();	

		String[] expectedResult = dedutionaData;
		String[] actualResult = foundData;
		Assert.assertEquals(actualResult, expectedResult);
	}		
	
	
}
