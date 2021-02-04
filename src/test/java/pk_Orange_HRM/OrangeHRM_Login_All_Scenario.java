package pk_Orange_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login_All_Scenario {
	WebDriver driver;

	// Clicking Submit Button.
	public void Click_Submit() {
		driver.findElement(By.id("btnLogin")).click();
	}

	// Getting Error Message.
	public void Error_Message_Validation(String ErrorType) {
		String ErrorMessage = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(ErrorMessage, ErrorType);
		System.out.println(ErrorMessage);
	}

	// Validating Successful login.
	@Test(priority = 3)
	public void Successful_Login() {
		driver.findElement(By.name("txtPassword")).clear(); // It will clear the
															// data from
															// Password Input
															// Box.
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		Click_Submit();
		String ActCurrentUrl = driver.getCurrentUrl();
		String ExpCurrentUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		Assert.assertEquals(ActCurrentUrl, ExpCurrentUrl);
		System.out.println("User Logged In Successfully.");
	}

	// Validating Empty UserName Error Message.
	@Test(priority = 2)
	public void Empty_Username() {
		driver.findElement(By.name("txtUsername")).clear(); // It will clear the
															// data from Input
															// User name Box.
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		Click_Submit();
		Error_Message_Validation("Username cannot be empty");
	}

	// Validating Empty Password Error Message.
	@Test(priority = 2)
	public void Empty_Password() {
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		Click_Submit();
		Error_Message_Validation("Password cannot be empty");
	}

	// Validating Wrong UserName Error Message.
	@Test(priority = 1)
	public void Wrong_UserName() {
		driver.findElement(By.name("txtUsername")).sendKeys("Administrator");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		Click_Submit();
		Error_Message_Validation("Invalid credentials");
	}

	// Validating Wrong Password Error Message.
	@Test
	public void Wrong_Password() {
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("Admin1234");
		Click_Submit();
		Error_Message_Validation("Invalid credentials");
	}

	@BeforeTest
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
