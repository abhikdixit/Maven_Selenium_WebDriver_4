package pk_Orange_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HDFC_Netbanking {
	ChromeDriver driver;
	// WebDriver driver;

	@Test
	public void EnterCustomerID() throws InterruptedException {
		//driver.switchTo().frame("login_page");
		driver.switchTo().frame(0);
		driver.findElementByXPath("//input[@name='fldLoginUserId']").sendKeys("1000");
		//driver.findElementByXPath("//img[@alt='continue']").click();
		driver.findElementByXPath("//table[@class='lForm']//img").click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.findElementByLinkText("Terms and Conditions").click();
		
	}

	// Pre-Condition
	@BeforeTest
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// This will wait for Page to load
		// driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		// This will store or rememember the cookies or navigation in terms of
		// back and forward
		driver.navigate().to("https://netbanking.hdfcbank.com/netbanking/");
	}

	// Post Condition
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
