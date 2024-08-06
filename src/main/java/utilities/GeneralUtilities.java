package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	

	public void typeOnElement(WebElement element, String value) {
		element.sendKeys(value);
	}

	public void clickOnAnElement(WebElement element) {
		element.click();
	}

	public String getTextOfElement(WebElement element) {
		return element.getText();
	}
	

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public String getCurrentPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public void navigateBack(WebDriver driver) {
		driver.navigate().back();
	}
	
	public String getAtribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public void scrollToAnElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void clickOnAnElementJavascript(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void selectFromDropDownByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectFromDropDownByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void selectFromDropDownByVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public void aleretAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void clickAnElementUsingSendKeys(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.sendKeys(element, Keys.ENTER).build().perform();
	}

	public void dragAndDrop(WebElement source, WebElement destination, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, destination).build().perform();
	}

	public void doubleClick(WebElement element, WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}

	public void addSleep() throws InterruptedException {
		Thread.sleep(3000);
	}
}
