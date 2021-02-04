package pk_Orange_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Sign_In_From_Excel extends OrangeHRM_TestData {

	ChromeDriver driver;

	@Test(dataProvider = "LoginData")
	public void Sign_On(String uname, String password) throws InterruptedException

	{

		driver.findElement(By.name("txtUsername")).sendKeys(uname);
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		// ----------------To Verify Logout Function without using
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.id("logInPanelHeading")).isDisplayed();
	}

	@BeforeTest
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
}
