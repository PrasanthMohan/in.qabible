package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.WorkerClass;
import retryAnalyzer.RetryAnalyzer;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import utilities.RandomDataUtilityClass;

public class WorkerTestClass extends BaseClass {

	public HomePageClass hp;
	public LoginPageClass lp;
	public WorkerClass wc;

	@Test(priority = 1, groups = {"group1"}, retryAnalyzer = RetryAnalyzer.class)
	public void verifyToCreateWorker() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		wc = new WorkerClass(driver);

		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));
		hp.clickOnCreateWorker();
		String fName = RandomDataUtilityClass.getfName();
		String lName = RandomDataUtilityClass.getlName();

		wc.createWorker("Mr", fName, lName, RandomDataUtilityClass.getRandomPhoneNumber(),
				RandomDataUtilityClass.getRandomEmail(), "Male", "24-12-1990", RandomDataUtilityClass.getFullAddress(),
				RandomDataUtilityClass.getPostCode(), wc.readStringData(19, 0), wc.readStringData(19, 1),
				wc.readStringData(19, 2), wc.readStringData(19, 3), wc.readStringData(19, 4), "123456");

		wc.createWorkerAccountDetails(wc.readStringData(19, 6),
										wc.readStringData(19, 7),
										fName+" "+lName,
										wc.readIntegerData(19, 9),
										wc.readIntegerData(19, 10),
										"01-07-2024");
		String expectedResult = fName+" "+lName;
		String actualResult = wc.getNameOfCreatedWorker();
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 2, groups = {"group2"}, retryAnalyzer = RetryAnalyzer.class)
	public void verifyWorkerSearch() throws IOException {
		readProperty();
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		wc = new WorkerClass(driver);

		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));
		hp.clickOnWorkerMenu();
		wc.initiateWorkerSearch(wc.readStringData(23, 0), wc.readStringData(23, 1) );
		driver.get(property.getProperty("workerSearch"));

		int status = wc.workerSearchResultCheck(wc.readStringData(23, 0), wc.readStringData(23, 1));
		int expectedResult = 0;
		int actualResult = status;
		Assert.assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 3, groups = {"group3"}, retryAnalyzer = RetryAnalyzer.class)
	public void verifyPaginationWorkerPage() throws IOException {
		lp = new LoginPageClass(driver);
		hp = new HomePageClass(driver);
		wc = new WorkerClass(driver);

		lp.login(lp.readStringData(1, 0), lp.readStringData(1, 1));
		hp.clickOnWorkerMenu();
		boolean result = wc.checkWorkerPagePagination(); 
		Assert.assertTrue(result);
	}

}
