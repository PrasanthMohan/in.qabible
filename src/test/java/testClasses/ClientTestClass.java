package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.ClientClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.WorkerClass;
import retryAnalyzer.RetryAnalyzer;
import utilities.RandomDataUtilityClass;

public class ClientTestClass extends BaseClass {

	public HomePageClass hp;
	public LoginPageClass lp;
	public ClientClass cc;

	@Test(priority = 1, groups = { "create" }, retryAnalyzer = RetryAnalyzer.class)
	public void verifyToCreateClient() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		cc = new ClientClass(driver);

		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));
		hp.clickOnCreateClient();
		String fName = RandomDataUtilityClass.getFullName();

		cc.createClient(cc.readStringData(9, 0), cc.readStringData(9, 1), fName,
				RandomDataUtilityClass.getFullAddress(), RandomDataUtilityClass.getPostCode(), cc.readStringData(9, 5),
				RandomDataUtilityClass.getRandomPhoneNumber(), RandomDataUtilityClass.getRandomEmail(),
				cc.readStringData(9, 8), cc.readStringData(9, 9), cc.readStringData(9, 10), cc.readStringData(9, 11),
				cc.readIntegerData(9, 12), cc.readStringData(9, 13));
		String expectedResult = fName;
		String actualResult = cc.getNameOfCreatedClient();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 2, groups = { "search" }, retryAnalyzer = RetryAnalyzer.class)
	public void verifyClientSearch() throws IOException {
		readProperty();
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		cc = new ClientClass(driver);

		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));
		hp.clickOnClientMenu();
		cc.initiateClientSearch(cc.readStringData(9, 2));
		driver.get(property.getProperty("clientSearch"));

		int status = cc.clientSearchResultCheck(cc.readStringData(9, 2));
		int expectedResult = 0;
		int actualResult = status;
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 3, groups = { "paging" }, retryAnalyzer = RetryAnalyzer.class)
	public void verifyPaginationClientPage() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		cc = new ClientClass(driver);

		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));
		hp.clickOnClientMenu();
		boolean result = cc.checkClientPagePagination();
		Assert.assertTrue(result);
	}

}
