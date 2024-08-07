package testClasses;

import utilities.ExcelReadClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name = "unsuccessfullLogin")
	public Object[][] dp1() throws IOException {
		return new Object[][] { new Object[] { ExcelReadClass.getStringData(2, 0), ExcelReadClass.getStringData(2, 1) },
				new Object[] { ExcelReadClass.getStringData(3, 0), ExcelReadClass.getStringData(3, 1) },
				new Object[] { ExcelReadClass.getStringData(4, 0), ExcelReadClass.getStringData(4, 1) }, };
	}

	@DataProvider(name = "successfullLogin")
	public Object[][] dp2() throws IOException {
		return new Object[][] {
				new Object[] { ExcelReadClass.getStringData(1, 0), ExcelReadClass.getStringData(1, 1) }, };
	}
}
