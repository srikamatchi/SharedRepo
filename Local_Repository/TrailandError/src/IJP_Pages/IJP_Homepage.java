package IJP_Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import Utilities.Wrapper_Class;

public class IJP_Homepage {

	public WebDriver driver; 
	public int iBroType = 1;
	public String brurl = "https://india.jobs.ciostage.accenture.com/";
	public Wrapper_Class owrapper;
	public ExtentReports ologger = new ExtentReports();
	
	By Cndbtn = By.xpath("//a[text()='Candidate']");
	By Agencybtn = By.xpath("//a[text()='Agency']");
	By Emplbtn = By.linkText("Employee");
	By loginbtn = By.xpath("//input[@value='Login']");
	By emploginbtn = By.id("btnEmpLogIn");
	By Signinbtn = By.xpath("//input[@value='Sign In']");
	By adfssignin = By.id("submitButton");
	

	@BeforeTest
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
	
	public void transfer_driver_to_wrapper(){
		owrapper = new Wrapper_Class(driver);
	}
	
	@Test(priority=1,enabled=true)
	public void Candidate_login() throws Exception {
	transfer_driver_to_wrapper();	
	ologger.startTest("Candidate Login", "Login as a Candidate");	
	boolean cndbtn = owrapper.button_click(Cndbtn);	
	if (cndbtn==true){
		ologger.log(LogStatus.PASS, "Candidate Button Available and Button Click Successful");
	}
	else {
		owrapper.getscreenshot("Candidatelogin");
		ologger.attachScreenshot("C:\\Users\\acer\\Desktop\\Eclipse\\TrailandError\\Screenshot\\Candidatelogin.png","Candidate Login Failure");
		ologger.log(LogStatus.FAIL, "Candidate Button Not Available");
	}
	
	boolean lgnbtn = owrapper.button_click(loginbtn);
	if (lgnbtn== true){
		ologger.log(LogStatus.PASS, "Login button Available");
			}
	else {
		ologger.log(LogStatus.FAIL, "Login Button Not Available");
	}
	
	WebElement signinbtn = owrapper.Verify_Elementpresence(Signinbtn); 
	
	if (signinbtn!=null){
		ologger.log(LogStatus.PASS, "User Redirectd to the Candidate Login Page Successfully");
	}
	else {
		ologger.log(LogStatus.FAIL, "User is not Redirected to the Correct Page");
	}
	ologger.endTest();
	
	}
	
	public void get_driver(){
			this.driver = Wrapper_Class.return_driver(); 
	}


	@Test(priority=2,enabled=false)
	public void Employee_login(){
	get_driver();
	driver.navigate().to(brurl);
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	ologger.startTest("Employee Login" , "Login in as Employee");
	boolean Emplybtn = owrapper.button_click(Emplbtn);
	if (Emplybtn==true){
		ologger.log(LogStatus.PASS, "Employee Button Visible in the IJP Home Page");
		}
	else {
		ologger.log(LogStatus.FAIL, "Employee Button Not Available in the IJP Home Page to Login");
	}
	
	WebElement signinbtn = owrapper.Verify_Elementpresence(emploginbtn); 
	boolean lgnbtn = owrapper.button_click(emploginbtn);
	if (signinbtn!=null){
		ologger.log(LogStatus.PASS, "User Redirectd to the Candidate Login Page Successfully");
	}
	else {
		ologger.log(LogStatus.FAIL, "User is not Redirected to the Login Page");
	}
	
	WebElement Adfs_Signin = owrapper.Verify_Elementpresence(adfssignin);
	if (Adfs_Signin!=null){
		ologger.log(LogStatus.PASS,"User Redirected to the Adfs Login Page");
		}
	else{
		ologger.log(LogStatus.FAIL, "User Not Navigated to the Login Page");
	}
	
	ologger.endTest();
	}

}