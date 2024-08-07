package testClasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.Screenshot;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	public WebDriver driver;
	public Screenshot shObj;
	public static Properties property;

	public static void readProperty() throws IOException {
		property = new Properties();
		FileInputStream fObj = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/config.properties");
		property.load(fObj);
	}

	@Parameters({ "browser" })
	@BeforeMethod(groups = { "launch" })
	public void beforeMethod(String browserValue) throws IOException {

		readProperty();
		if (browserValue.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserValue.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
	}

	@AfterMethod(groups = { "close" })
	public void afterMethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			shObj = new Screenshot();
			shObj.takeScreenshot(driver, result.getName());
		}
		driver.quit();
	}

	@BeforeSuite(alwaysRun = true)
	public void createReport(final ITestContext testContext) {
		extentReport.ExtentManager.createInstance().createTest(testContext.getName(), "message");
	}
}
