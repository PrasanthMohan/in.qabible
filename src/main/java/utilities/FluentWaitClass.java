package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitClass {
	WebDriver driver;
	Wait <WebDriver>wait;
	
	public void presenceOfElementLocatedWaitXpath(WebDriver driver, String xpathValue) {
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));
	}
	
	public void elementToBeClickableWait(WebDriver driver,WebElement element)
	{
		wait= new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(5)).
				ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
