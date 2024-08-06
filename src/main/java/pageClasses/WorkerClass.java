package pageClasses;

import java.io.IOException;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.FluentWaitClass;
import utilities.GeneralUtilities;

public class WorkerClass {
	public WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	ExplicitWaitClass ewcObj = new ExplicitWaitClass();
	FluentWaitClass fwcObj = new FluentWaitClass(); 
	
	public WorkerClass(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(id="worker-title")
	WebElement workerTitle;
	
	@FindBy(id="worker-first_name")
	WebElement workerFirstName;
	
	@FindBy(id="worker-last_name")
	WebElement workerLastName;
	
	@FindBy(id="worker-phone")
	WebElement workerPhone;
	
	@FindBy(id="worker-email")
	WebElement workerEmail;
	
	@FindBy(id="worker-gender")
	WebElement workerGender;
	
	@FindBy(id="worker-dob")
	WebElement workerDob;
	
	@FindBy(id="worker-address1")
	WebElement workerAddress;
	
	@FindBy(id="worker-postcode")
	WebElement workerPostcode;
	
	@FindBy(id="worker-branch_id")
	WebElement workerBranchId;
		
	@FindBy(id="worker-division_id")
	WebElement workerDivisionId;
	
	@FindBy(id="worker-employment_type")
	WebElement workerEmploymentType;
	
	@FindBy(id="worker-payslip_method")
	WebElement workerPayslipMethod;
	
	@FindBy(id="worker-engage_status")
	WebElement workerEngageStatus;	
	
	@FindBy(id="worker-ni_number")
	WebElement workerNiNumber;	
	
	@FindBy(xpath="//button[normalize-space()='Next']")
	WebElement nextBtn;	

	@FindBy(id="worker-payment_method")
	WebElement workerPaymentMethod;
	
	@FindBy(id="worker-ac_type")
	WebElement workerAcType;
	
	@FindBy(id="worker-ac_name")
	WebElement workerAcName;
	
	@FindBy(id="worker-ac_no")
	WebElement workerACNo;	
	
	@FindBy(id="worker-sort_code")
	WebElement workerSortCode;
	
	@FindBy(id="worker-start_date")
	WebElement workerStartDate;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement submitButton;
	
	
	@FindBy(xpath="//table[@id='w0']//tr[6]//td[1]")
	WebElement ShownWorkerfName;
	
	@FindBy(xpath="//table[@id='w0']//tr[8]//td[1]")
	WebElement ShownWorkerlName;

	@FindBy(id="workersearch-first_name")
	WebElement workersearchFirstname;
	
	@FindBy(id="workersearch-last_name")
	WebElement workersearchLastname;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement searchButton;
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']//tbody//td[2]")
	List<WebElement> workerNamesSearchResults;

	@FindBy(xpath="//table[@class='table table-striped table-bordered']")
	WebElement searchResultTable;
	
	@FindBy(xpath = "//a[@href='/payrollapp/worker/index']")
	WebElement workerLink;
	
	@FindBy(xpath="clientViewLink=//a[@title='View']")
	WebElement viewWorkerLink;
	
	@FindBy(xpath = "//div[@class='summary']//child::b")
	WebElement pagingTitle;
	
	@FindBy(xpath = "//a[@data-page='0']")
	WebElement buttonOne;
	
	@FindBy(xpath = "//a[@data-page='1']")
	WebElement buttonTwo;
	
	@FindBy(xpath = "//a[@data-page='2']")
	WebElement buttonThree;
	

	
	
	public void createWorker(String title,
								String fname,
								String lname,
								String phone,
								String email,
								String gender,			
								String dob,
								String address,
								String pincode,
								String branch,
								String division,
								String empType,
								String payMethod, 
								String engStatus,
								String niNum
								) {
		
		
		guObj.selectFromDropDownByVisibleText(workerTitle, title);
		
		guObj.typeOnElement(workerFirstName, fname);
		guObj.typeOnElement(workerLastName, lname);
		guObj.typeOnElement(workerPhone, phone);
		guObj.typeOnElement(workerEmail, email);
		guObj.typeOnElement(workerGender, gender);
		guObj.typeOnElement(workerDob, dob);
		guObj.clickAnElementUsingSendKeys(driver, workerDob);
		guObj.typeOnElement(workerAddress, address);
		guObj.typeOnElement(workerPostcode, pincode);

		guObj.selectFromDropDownByVisibleText(workerBranchId, branch);
		guObj.selectFromDropDownByVisibleText(workerDivisionId, division);
		guObj.selectFromDropDownByVisibleText(workerEmploymentType, empType);
		guObj.selectFromDropDownByVisibleText(workerPayslipMethod, payMethod);
		guObj.selectFromDropDownByVisibleText(workerEngageStatus, engStatus);
		
		guObj.typeOnElement(workerNiNumber, niNum);
		
		
		ewcObj.elementToBeClickableByLocator(driver, nextBtn);

		guObj.clickOnAnElementJavascript(driver, nextBtn);
		
	}
		
	public void createWorkerAccountDetails(String payMethod,
			String accType,
			String accName,
			String accNO,
			String sortCode,
			String StartDate) {
		ewcObj.elementToBeClickableByLocator(driver, workerPaymentMethod);
		guObj.selectFromDropDownByVisibleText(workerPaymentMethod, payMethod);
		ewcObj.elementToBeClickableByLocator(driver, workerAcType);
		guObj.selectFromDropDownByVisibleText(workerAcType, accType);
		guObj.typeOnElement(workerAcName, accName);

		ewcObj.elementToBeClickableByLocator(driver, workerStartDate);

		guObj.typeOnElement(workerStartDate, StartDate);

		guObj.clickAnElementUsingSendKeys(driver, workerStartDate);
		
		guObj.typeOnElement(workerACNo, accNO);
		guObj.typeOnElement(workerSortCode, sortCode);
		
		fwcObj.elementToBeClickableWait(driver, submitButton);
		guObj.clickOnAnElement(submitButton);
		
	}
	
	
	 public String getNameOfCreatedWorker() {
		 ewcObj.visibitlityOfElementWait(driver, ShownWorkerfName);
		  return guObj.getTextOfElement(ShownWorkerfName)+" "+guObj.getTextOfElement(ShownWorkerlName);
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
	 }

	 public void initiateWorkerSearch(String fName, String lname) {
		    ewcObj.visibitlityOfElementWait(driver, workersearchFirstname);
			guObj.typeOnElement(workersearchFirstname, fName);		
			ewcObj.visibitlityOfElementWait(driver, workersearchLastname);
			guObj.typeOnElement(workersearchLastname, lname);
			ewcObj.elementToBeClickableByLocator(driver, searchButton);
			guObj.clickOnAnElement(searchButton);
	 }
	
	 public int workerSearchResultCheck(String fName, String lName) {
		int flag=0;
		for (WebElement workerNamesSearchResult : workerNamesSearchResults) {
			String resultName = guObj.getTextOfElement(workerNamesSearchResult);			
			if(!resultName.toLowerCase().contains(fName) && !resultName.toLowerCase().contains(lName)) {
				flag=1;
			}	
		}
		return flag;
	}	
	 
	 
	 public boolean checkWorkerPagePagination() {
		 ewcObj.visibitlityOfElementWait(driver, pagingTitle); 
		 String FirstTitle = guObj.getTextOfElement(pagingTitle);
		 
		 ewcObj.elementToBeClickableByLocator(driver, buttonTwo);
		 guObj.clickOnAnElementJavascript(driver, buttonTwo);
		 String SecondTitle = guObj.getTextOfElement(pagingTitle);
		 
		 ewcObj.elementToBeClickableByLocator(driver, buttonThree);
		 guObj.clickOnAnElementJavascript(driver, buttonThree);
		 String ThirdTitle = guObj.getTextOfElement(pagingTitle);
		 boolean flag = false;
		 if(FirstTitle.equals("1-20") && SecondTitle.equals("21-40") && ThirdTitle.equals("41-60")) {
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
