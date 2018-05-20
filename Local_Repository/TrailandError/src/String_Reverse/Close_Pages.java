package String_Reverse;

import java.sql.Array;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Close_Pages {
	
	public static WebDriver driver;
	public static String brurl = "https://www.hdfcbank.com/";
	public static int iBroType=1;
	public static int wincount;
	static By osecurities = By.linkText("HDFC Securities");
	static By olife = By.linkText("HDFC Life");
	static By omf = By.linkText("HDFC Mutual Fund");
	static By opension = By.linkText("HDFC Pension");
	
	public static void Invoke_Browser(){
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
	}
	
	public static void navigate_url(){
		driver.manage().window().maximize();
		driver.get(brurl);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public static void Open_multiple_windows() throws Exception{
	WebElement odemat = driver.findElement(osecurities);
	WebElement ohdfclife = driver.findElement(olife);
	WebElement omutualfund = driver.findElement(omf);
	WebElement ohdfcpension = driver.findElement(opension);	
	Actions oaction = new Actions(driver);
	PageFactory.initElements(driver, Close_Pages.class);
	oaction.moveToElement(odemat).click().build().perform();
	oaction.moveToElement(ohdfclife).click().build().perform();
	oaction.moveToElement(omutualfund).click().build().perform();
	oaction.moveToElement(ohdfcpension).click().build().perform();
	wincount = driver.getWindowHandles().size();
	System.out.println(wincount);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	Thread.sleep(20000);
	String pageurl = driver.getCurrentUrl();
	System.out.println(pageurl);
	Thread.sleep(20000);
	driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
	Thread.sleep(5000);
	String url = driver.getCurrentUrl();
	System.out.println(url);
	}
	
	public static void Close_Inactive_windows() throws Exception{
		for (int i=0 ; i<=wincount-1 ; i++){
		int temp = driver.getWindowHandles().size();
		System.out.println("Window Size is " + temp);
		if (i!=0){
		driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
		Thread.sleep(5000);
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		Thread.sleep(5000);
		String url2 = driver.getCurrentUrl();
		driver.close();
		System.out.println("Window" + url2 + "is being closed");
			}
			}
			
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Invoke_Browser();
		navigate_url();
		Open_multiple_windows();
		Close_Inactive_windows();
		
	}

}
