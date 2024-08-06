package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	public void takeScreenshot(WebDriver driver, String name) throws IOException {
			String folderPath = "C:\\Users\\Asus\\eclipse-workspace\\SuitSample"+"\\screenshots\\";
			File folder = new File(folderPath);
			if (!folder.exists()) {
				folder.mkdirs();
			}
			//Takescrrenshot interface
			TakesScreenshot takeScreen = (TakesScreenshot)driver;
			File sceenshotImage = takeScreen.getScreenshotAs(OutputType.FILE);
			
			String timestamp = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss").format(new Date());
			
			String destinationPath = folderPath+name+timestamp+".png";
			
			File fileDestinstion = new File(destinationPath);
			
			FileHandler.copy(sceenshotImage, fileDestinstion);
	}

}