package pageClasses;

import java.io.IOException;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class DeductionClass {
	public WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	ExplicitWaitClass ewcObj = new ExplicitWaitClass();

	public DeductionClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "select2-deduction-worker_id-container")
	WebElement deductionWorker;

	@FindBy(xpath = "//input[@type='search']")
	WebElement deductionWorkerTextbox;

	@FindBy(xpath = "//span[@class='select2-selection__arrow']")
	WebElement deductionWorkerArrow;

	@FindBy(id = "deduction-type")
	WebElement deductionType;

	@FindBy(id = "deduction-amount")
	WebElement deductionAmount;

	@FindBy(id = "deduction-effective_from")
	WebElement deductionEffectiveFrom;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//table[@id='w0']//tr[1]//td[1]")
	WebElement ShownWorkerName;

	@FindBy(id = "clientsearch-client_name")
	WebElement clientSerachName;

	@FindBy(xpath = "//a[@href='/payrollapp/deduction/index']")
	WebElement deductionLink;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody//tr[1]")
	WebElement deductionTable;

	@FindBy(xpath = "(//table[@class='table table-striped table-bordered']//tbody//tr//td)[2]")
	WebElement workerN;
	@FindBy(xpath = "(//table[@class='table table-striped table-bordered']//tbody//tr//td)[3]")
	WebElement deductionTypeValue;
	@FindBy(xpath = "(//table[@class='table table-striped table-bordered']//tbody//tr//td)[4]")
	WebElement deductionAmountValue;
	@FindBy(xpath = "(//table[@class='table table-striped table-bordered']//tbody//tr//td[7]//a[1])[1]")
	WebElement deductionViewLink;

	@FindBy(xpath = "//table[@id='w0']//tr//td")
	WebElement deductionViewPageTable;

	@FindBy(xpath = "//table[@id='w0']//tr[1]//td")
	WebElement deductionViewPageworkerN;

	@FindBy(xpath = "//table[@id='w0']//tr[2]//td")
	WebElement deductionViewPageType;

	@FindBy(xpath = "//table[@id='w0']//tr[3]//td")
	WebElement deductionViewPageAmount;

	public void createDeduction(String worker, String type, String amount, String effectiveFrom) {
		ewcObj.elementToBeClickableByLocator(driver, deductionWorkerArrow);
		guObj.clickOnAnElement(deductionWorkerArrow);

		guObj.typeOnElement(deductionWorkerTextbox, worker);
		guObj.clickAnElementUsingSendKeys(driver, deductionWorkerTextbox);

		guObj.selectFromDropDownByVisibleText(deductionType, type);

		guObj.typeOnElement(deductionAmount, amount);
		guObj.typeOnElement(deductionEffectiveFrom, effectiveFrom);

		guObj.clickAnElementUsingSendKeys(driver, deductionEffectiveFrom);

		ewcObj.elementToBeClickableByLocator(driver, submitBtn);
		guObj.clickOnAnElementJavascript(driver, submitBtn);
	}

	public String getDeductionEmplyeeName() {
		ewcObj.visibitlityOfElementWait(driver, ShownWorkerName);
		return guObj.getTextOfElement(ShownWorkerName);

	}

	public void clickOnDeductionLink() {
		ewcObj.visibitlityOfElementWait(driver, deductionLink);
		guObj.clickOnAnElement(deductionLink);
	}

	public String[] viewDeductionData() {
		ewcObj.visibitlityOfElementWait(driver, deductionTable);
		String deductionDetailsAraay[] = new String['3'];
		deductionDetailsAraay[0] = guObj.getTextOfElement(workerN);
		deductionDetailsAraay[1] = guObj.getTextOfElement(deductionTypeValue);
		deductionDetailsAraay[2] = guObj.getTextOfElement(deductionAmountValue);
		return deductionDetailsAraay;
	}

	public void clickOnFirstDeductionLink() {
		ewcObj.visibitlityOfElementWait(driver, deductionViewLink);
		guObj.clickOnAnElement(deductionViewLink);
	}

	public String[] viewPageData() {
		ewcObj.visibitlityOfElementWait(driver, deductionViewPageTable);
		String deductionDetailsPageAraay[] = new String['3'];
		deductionDetailsPageAraay[0] = guObj.getTextOfElement(deductionViewPageworkerN);
		deductionDetailsPageAraay[1] = guObj.getTextOfElement(deductionViewPageType);
		deductionDetailsPageAraay[2] = guObj.getTextOfElement(deductionViewPageAmount);
		return deductionDetailsPageAraay;
	}

	public String readStringData(int row, int column) throws IOException {
		return ExcelReadClass.getStringData(row, column);
	}

	public String readIntegerData(int row, int column) throws IOException {
		return ExcelReadClass.getIntegerData(row, column);
	}
}
