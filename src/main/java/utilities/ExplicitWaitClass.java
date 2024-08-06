package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitClass {
	WebDriver driver;
	WebDriverWait wait;
	

	public void presenceOfElementLocatedWaitByxPath(WebDriver driver,String xpathValue)
	{
		wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));	
	}
	
	public void presenceOfElementLocatedWaitByName(WebDriver driver,String name)
	{
		wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
		
	}
	
	public void presenceOfElementLocatedWaitById(WebDriver driver,String idValue)
	{
		wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idValue)));
		
	}
	
	public void elementToBeClickableByLocator(WebDriver driver,String xpathValue)
	{
		wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathValue)));
	}
	
	public void elementToBeClickableByLocator(WebDriver driver,WebElement element)
	{
		wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void elementToBeClickableByLocatorArray(WebDriver driver, List<WebElement> List)
	{
		wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		for (WebElement webElement : List) {
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
		}	
	}
	
	public void visibitlityOfElementWait(WebDriver driver, WebElement element)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void alertPresentWait(WebDriver driver)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}


}
