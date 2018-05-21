package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import Page_Factory.IJP_Homepage_New;

public class Wrapper_Pagefactory {
	
	public WebDriver driver;
	public String brurl = "https://india.jobs.ciostage.accenture.com/";
	public int iBroType = 1;
	ExtentReports ologger = new ExtentReports();
	
	@Test(priority=-1)
	public void Invoke_Browser(){
		ologger.init("C:\\Users\\acer\\Desktop\\Eclipse\\Java Training\\Report\\ijpreport.html", true);
		ologger.startTest("Invoke Browser" , "Invokes Browser of User Choice");
		switch (iBroType) {
		case 1:
			System.out.println("User Option is : "+iBroType+", So Invoking Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\acer\\Downloads\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case 2:
			System.out.println("User Option is : "+iBroType+", So Invoking FireFox Browser");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\acer\\Downloads\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
				}	
		ologger.log(LogStatus.INFO, "Browser Invoked Successfully");
		ologger.endTest();
		
	}

	@Test (priority=0)
	public void navigate_url(){
		ologger.startTest("Navigate url" , "Navigate to IJP Home Page");
		driver.manage().window().maximize();
		driver.get(brurl);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String pagetitle = driver.getTitle();
		
		if (pagetitle.contains("accenture")){
		ologger.log(LogStatus.PASS, "User Navigated to IJP Home Page");
				}
		else {
		ologger.log(LogStatus.FAIL, "User Not Navigated to IJP Home Page");	
		
		}
		ologger.endTest();
	}
	
	@Test (priority=1)	
	public void candidate_login(){
	ologger.startTest("Candidate Login", "Login as Candidate");
	IJP_Homepage_New homepage= PageFactory.initElements(driver, IJP_Homepage_New.class);
	driver = homepage.candidate_login(driver);
	boolean result = homepage.result;
	if (result==true){
	ologger.log(LogStatus.PASS, "Candidate Login Passed");	
		}
	else {
	ologger.log(LogStatus.FAIL, "Candidate Login Failed");	
		}
	ologger.endTest();
	}
	
	public static void print() {
		System.out.println("My Name is Kamatchi");
	}

	

}
