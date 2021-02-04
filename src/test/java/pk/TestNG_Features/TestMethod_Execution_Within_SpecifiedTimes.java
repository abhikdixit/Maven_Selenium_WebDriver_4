package pk.TestNG_Features;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethod_Execution_Within_SpecifiedTimes {
	ChromeDriver driver;

	@BeforeTest
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@Test(priority = 1, timeOut = 5000)
	// This is for Sign On Functionality
	public void Sign_On() throws InterruptedException

	{
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String Element = driver.findElement(By.linkText("Dashboard")).getText();
		System.out.println(Element);

	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
