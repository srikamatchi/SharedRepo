package Page_Factory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import Utilities.Wrapper_Pagefactory;

public class IJP_Homepage_New {

	public boolean result;

@FindBy (linkText = "Candidate") 
WebElement cndbtn;
	
@FindBy (how=How.NAME, using="btnCandLogin")
WebElement lgnbtn;

@FindBy (how=How.XPATH, using="//input[@value='Sign In']") 
WebElement siginbtn;

public WebDriver candidate_login(WebDriver driver){
	
	boolean result;
	result = cndbtn.isDisplayed();
	if (result==true){
		lgnbtn.click();
		}
	return driver;
	}

}