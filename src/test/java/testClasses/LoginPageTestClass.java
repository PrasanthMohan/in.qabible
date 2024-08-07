package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzer;

public class LoginPageTestClass extends BaseClass {

	LoginPageClass lp;
	HomePageClass hp;

	@Test(priority = 1, dataProviderClass = DataProviderClass.class, dataProvider = "successfullLogin", retryAnalyzer = RetryAnalyzer.class)
	public void verfySuccesfullLogin(String uname, String pass) throws IOException {
		lp = new LoginPageClass(driver);
		// lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));
		lp.enterUsername(uname).enterPassword(pass).clickOnLoginButton();
		hp = new HomePageClass(driver);
		String actualResult = hp.getUsernameOfLoggedUser();
		String expectedResult = lp.readStringData(1, 2);
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 2, dataProviderClass = DataProviderClass.class, dataProvider = "unsuccessfullLogin", retryAnalyzer = RetryAnalyzer.class)
	public void verifyUnsuccessfulLogin(String uname, String pass) throws IOException {
		lp = new LoginPageClass(driver);
		lp.login(uname, pass);
		String actualResult = lp.getErrorMessageOnLoginFailure();
		String expectedResult = lp.readStringData(2, 3);
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
	public void verifyTheExpectedPageisOpensWhileHittingTheUrl() {
		lp = new LoginPageClass(driver);
		String actualResult = lp.getHomePageURL();
		String expectedResult = "https://qabible.in/payrollapp/site/login";
		Assert.assertEquals(actualResult, expectedResult);
	}

}