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

public class ClientClass {
	public WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	ExplicitWaitClass ewcObj = new ExplicitWaitClass();

	public ClientClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "client-branch_id")
	WebElement clientBranch;

	@FindBy(id = "client-division_id")
	WebElement clientDivision;

	@FindBy(id = "client-client_name")
	WebElement clientName;

	@FindBy(id = "client-client_address")
	WebElement addresss;

	@FindBy(id = "client-postcode")
	WebElement postcode;

	@FindBy(id = "client-invoice_contact")
	WebElement ClientInvoiceContact;

	@FindBy(id = "client-phone")
	WebElement clientPhone;

	@FindBy(id = "client-email")
	WebElement clientEmail;

	@FindBy(id = "client-company_reg")
	WebElement ClientCompanyReg;

	@FindBy(id = "client-invoice_order")
	WebElement ClientInvoiceOrder;

	@FindBy(id = "client-invoice_delivery_method")
	WebElement deliveryMethod;

	@FindBy(id = "client-master_document")
	WebElement masterDocument;

	@FindBy(id = "client-settilement_days")
	WebElement settilementDays;

	@FindBy(id = "client-vat_rate")
	WebElement ClientVatRate;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//table[@id='w0']//tr[3]//td[1]")
	WebElement ShownClientName;

	@FindBy(id = "clientsearch-client_name")
	WebElement clientSerachName;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchButton;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']//tbody//td[2]")
	List<WebElement> clientNamesSearchResults;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered']")
	WebElement searchResultTable;

	@FindBy(xpath = "//a[@href='/payrollapp/client/index']")
	WebElement clientLink;

	@FindBy(xpath = "clientViewLink=//a[@title='View']")
	WebElement viewClientLink;

	@FindBy(xpath = "//div[@class='summary']//child::b")
	WebElement pagingTitle;

	@FindBy(xpath = "//a[@data-page='0']")
	WebElement buttonOne;

	@FindBy(xpath = "//a[@data-page='1']")
	WebElement buttonTwo;

	@FindBy(xpath = "//a[@data-page='2']")
	WebElement buttonThree;

	public void createClient(String branch, String division, String name, String address, String pincode,
			String invoiceContact, String phone, String email, String companyReg, String invoiceOrder,
			String invoiceDelivery, String masterDoc, String settlementDays, String vatRate) {

		guObj.selectFromDropDownByVisibleText(clientBranch, branch);
		guObj.selectFromDropDownByVisibleText(clientDivision, division);

		guObj.typeOnElement(clientName, name);
		guObj.typeOnElement(addresss, address);
		guObj.typeOnElement(postcode, pincode);
		guObj.typeOnElement(ClientInvoiceContact, invoiceContact);
		guObj.typeOnElement(clientPhone, phone);
		guObj.typeOnElement(clientEmail, email);
		guObj.typeOnElement(ClientCompanyReg, companyReg);

		guObj.selectFromDropDownByVisibleText(ClientInvoiceOrder, invoiceOrder);
		guObj.selectFromDropDownByVisibleText(deliveryMethod, invoiceDelivery);
		guObj.selectFromDropDownByVisibleText(masterDocument, masterDoc);

		guObj.typeOnElement(settilementDays, settlementDays);

		guObj.selectFromDropDownByVisibleText(ClientVatRate, vatRate);

		ewcObj.elementToBeClickableByLocator(driver, submitBtn);

		guObj.clickOnAnElementJavascript(driver, submitBtn);

	}

	public String getNameOfCreatedClient() {
		ewcObj.visibitlityOfElementWait(driver, ShownClientName);
		return guObj.getTextOfElement(ShownClientName);

	}

	public void initiateClientSearch(String clientName) {
		ewcObj.visibitlityOfElementWait(driver, clientSerachName);
		guObj.typeOnElement(clientSerachName, clientName);
		ewcObj.elementToBeClickableByLocator(driver, searchButton);
		guObj.clickOnAnElement(searchButton);
	}

	public int clientSearchResultCheck(String clientName) {
		int flag = 0;
		for (WebElement clientNamesSearchResult : clientNamesSearchResults) {
			String resultName = guObj.getTextOfElement(clientNamesSearchResult);
			if (!resultName.toLowerCase().contains(clientName)) {
				flag = 1;
			}
		}
		return flag;
	}

	public void clickOnClientViewLink() {
		ewcObj.visibitlityOfElementWait(driver, clientLink);
		guObj.clickOnAnElement(clientLink);

		guObj.clickOnAnElement(viewClientLink);
	}

	public boolean checkClientPagePagination() {
		ewcObj.visibitlityOfElementWait(driver, pagingTitle);
		String FirstTitle = guObj.getTextOfElement(pagingTitle);

		ewcObj.elementToBeClickableByLocator(driver, buttonTwo);
		guObj.clickOnAnElementJavascript(driver, buttonTwo);
		String SecondTitle = guObj.getTextOfElement(pagingTitle);

		ewcObj.elementToBeClickableByLocator(driver, buttonThree);
		guObj.clickOnAnElementJavascript(driver, buttonThree);
		String ThirdTitle = guObj.getTextOfElement(pagingTitle);
		boolean flag = false;
		if (FirstTitle.equals("1-20") && SecondTitle.equals("21-40") && ThirdTitle.equals("41-60")) {
			flag = true;
		}
		return flag;
	}

	public String readStringData(int row, int column) throws IOException {
		return ExcelReadClass.getStringData(row, column);
	}

	public String readIntegerData(int row, int column) throws IOException {
		return ExcelReadClass.getIntegerData(row, column);
	}
}
