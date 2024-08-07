package pageClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class HomePageClass {
	public WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	ExplicitWaitClass ewcObj = new ExplicitWaitClass();

	public HomePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='dropdown-toggle']")
	WebElement loggedUsernameToggleLink;

	@FindBy(xpath = "//ul[@class='dropdown-menu profile-Details']//child::h2")
	WebElement loggedUsername;

	@FindBy(xpath = "(//ul[@class='dropdown-menu profile-Details']//child::a)[2]")
	WebElement logoutLink;

	@FindBy(xpath = "//ul[@id='w1']//child::a")
	List<WebElement> mainMenuLinkTitles;

	@FindBy(xpath = "(//ul[@id='w1']//child::a)[1]")
	WebElement mainMenuLinkTitleCheck;

	@FindBy(xpath = "//a[@href='/payrollapp/client/index']")
	WebElement clientLink;

	@FindBy(xpath = "//a[@href='/payrollapp/worker/index']")
	WebElement workerLink;

	@FindBy(xpath = "//a[@href='/payrollapp/user/profile']")
	WebElement viewFullOrofileLink;

	@FindBy(xpath = "//a[@href='/payrollapp/client/create']")
	WebElement createClientLink;

	@FindBy(xpath = "//a[@href='/payrollapp/worker/create']")
	WebElement createWorkerLink;

	@FindBy(xpath = "//a[@href='/payrollapp/deduction/index']")
	WebElement deductionLink;

	@FindBy(xpath = "//a[@href='/payrollapp/deduction/create']")
	WebElement createDeductionLink;

	@FindBy(xpath = "//div[@class='container']//child::p")
	WebElement pageFooterText;

	public String[] verifyMainMenuLinkTitles() {
		ewcObj.visibitlityOfElementWait(driver, mainMenuLinkTitleCheck);
		String mainMenuLinkTitlesAraay[] = new String[9];
		int i = 0;
		for (WebElement mainMenuLinkTitle : mainMenuLinkTitles) {
			ewcObj.elementToBeClickableByLocator(driver, mainMenuLinkTitle);
			mainMenuLinkTitlesAraay[i] = guObj.getTextOfElement(mainMenuLinkTitle);
			i++;
		}
		return mainMenuLinkTitlesAraay;
	}

	public String getUsernameOfLoggedUser() {
		ewcObj.visibitlityOfElementWait(driver, loggedUsernameToggleLink);
		return guObj.getTextOfElement(loggedUsernameToggleLink);
	}

	public String verifyLogoutProcess() {
		ewcObj.visibitlityOfElementWait(driver, mainMenuLinkTitleCheck);
		guObj.clickOnAnElement(loggedUsernameToggleLink);
		guObj.clickOnAnElement(logoutLink);
		guObj.navigateBack(driver);
		guObj.clickOnAnElement(viewFullOrofileLink);
		String curUrl = guObj.getCurrentPageUrl(driver);
		return curUrl;
	}

	public void clickOnCreateClient() {
		ewcObj.visibitlityOfElementWait(driver, clientLink);
		guObj.clickOnAnElement(clientLink);
		ewcObj.visibitlityOfElementWait(driver, createClientLink);
		guObj.clickOnAnElement(createClientLink);
	}

	public void clickOnCreateWorker() {
		ewcObj.visibitlityOfElementWait(driver, workerLink);
		guObj.clickOnAnElement(workerLink);
		ewcObj.visibitlityOfElementWait(driver, createWorkerLink);
		guObj.clickOnAnElement(createWorkerLink);
	}

	public void clickOnClientMenu() {
		ewcObj.visibitlityOfElementWait(driver, clientLink);
		guObj.clickOnAnElement(clientLink);
	}

	public void clickOnWorkerMenu() {
		ewcObj.visibitlityOfElementWait(driver, workerLink);
		guObj.clickOnAnElement(workerLink);
	}

	public void clickOnCreateDeduction() {
		ewcObj.visibitlityOfElementWait(driver, deductionLink);
		guObj.clickOnAnElement(deductionLink);
		ewcObj.visibitlityOfElementWait(driver, createDeductionLink);
		guObj.clickOnAnElement(createDeductionLink);
	}

	public String verifyFooterText() {
		ewcObj.visibitlityOfElementWait(driver, pageFooterText);
		return guObj.getTextOfElement(pageFooterText);
	}

	public String readStringData(int row, int column) throws IOException {
		return ExcelReadClass.getStringData(row, column);
	}

	public String readIntegerData(int row, int column) throws IOException {
		return ExcelReadClass.getIntegerData(row, column);
	}
}
