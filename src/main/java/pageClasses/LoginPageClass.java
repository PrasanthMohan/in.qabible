package pageClasses;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

import org.checkerframework.checker.index.qual.IndexFor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class LoginPageClass {
	
	public WebDriver driver;
	GeneralUtilities guObj = new GeneralUtilities();
	ExplicitWaitClass ewcObj = new ExplicitWaitClass();
	
	public LoginPageClass(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="loginform-username")
	WebElement userNameTextBox;
	
	@FindBy(id="loginform-password")
	WebElement userPassword;
	
	@FindBy(name="login-button")
	WebElement loginButton;
	
	@FindBy(xpath="(//p[@class='help-block help-block-error'])[2]")
	WebElement loginErrorMessage;

	
	public void login(String username, String password) {
		guObj.typeOnElement(userNameTextBox, username);
		guObj.typeOnElement(userPassword, password);	
		guObj.clickOnAnElement(loginButton);	
	}
	

	public String getErrorMessageOnLoginFailure() {
		ewcObj.visibitlityOfElementWait(driver, loginErrorMessage);
		return guObj.getTextOfElement(loginErrorMessage);
	}
	
	public String getHomePageURL() {
		return guObj.getCurrentPageUrl(driver);
	}
	
	
	public String readStringData(int row, int column) throws IOException {
		return ExcelReadClass.getStringData(row, column);
	}
	
	public String readIntegerData(int row, int column) throws IOException {
		return ExcelReadClass.getIntegerData(row, column);
	}
}
