package Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wrapper_Class {

public static WebDriver driver;

public Wrapper_Class (WebDriver driver){
	this.driver = driver;	
}

public boolean button_click(By locator){
	WebElement btn;
	boolean btnpresence = false;
	btn = driver.findElement(locator);
	if (btn.isDisplayed()){
	btn.click();
	
		}	
	return btnpresence;
	}

public WebElement Verify_Elementpresence(By locator){
	WebElement btn;
	WebDriverWait owait = new WebDriverWait(driver,20);
	btn = driver.findElement(locator);
	owait.until(ExpectedConditions.elementToBeClickable(locator));
	return btn;
	}

public static WebDriver return_driver(){
	return driver;
}

public void getscreenshot(String File_Name) throws Exception 
{
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       // String sPath = "./Report_Output/Screenshot/"+File_Name+".jpg";
        String sPath = "./Screenshot/"+File_Name+".png";
        FileUtils.moveFile(scrFile, new File(sPath));
       
}
}
