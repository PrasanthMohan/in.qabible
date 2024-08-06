package testClasses;

import java.io.IOException;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;

public class HomePageTestClass extends BaseClass {

	public HomePageClass hp;
	LoginPageClass lp;

	@Test
	public void verifyAllTilesAreDisplayedInHomePage() throws IOException {
		hp = new HomePageClass(driver);
		lp = new LoginPageClass(driver);
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));
		String[] actualResult = hp.verifyMainMenuLinkTitles();
	    System.out.println(Arrays.toString(actualResult));
		String[] expectedResult = { "Dashboard", "Company", "Clients", "Workers", "Deduction", "TimeSheet", "Payslip",
				"Invoice", "Report" };
		Assert.assertEquals(actualResult, expectedResult);
	}

	
	@Test
	public void verifyLogOutProcess() throws IOException {
		hp = new HomePageClass(driver);
		lp = new LoginPageClass(driver);
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));
		String actualResult = hp.verifyLogoutProcess();
		String expectedResult = "https://qabible.in/payrollapp/site/login";
		Assert.assertEquals(actualResult, expectedResult);
	}	
	
	@Test
	public void verifyFooterText() throws IOException {
		hp = new HomePageClass(driver);
		lp = new LoginPageClass(driver);
		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));
		String actualResult = hp.verifyFooterText();
		String expectedResult = "© My Application 2024";
		Assert.assertEquals(actualResult, expectedResult);
	}	
}
