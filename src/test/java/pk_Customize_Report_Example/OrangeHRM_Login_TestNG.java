package pk_Customize_Report_Example;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Login_TestNG {
	WebDriver driver;
	Customize_Test_Report CTR = new Customize_Test_Report();

	@Test
	public void Login() throws InterruptedException {
		CTR.test = CTR.extent.createTest("Test Case 1 :: OrangeHRM Login Functionality");
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		// Verify that Dashboard page displayed
		String ActElement = driver.findElement(By.linkText("Dashboard")).getText();
		String ExpElement = "Dashboard";
		Assert.assertEquals(ActElement, ExpElement);
		System.out.println(ActElement);
		// ----------------To Verify Logout Function without using
		// Assert----------------
		// driver.findElement(By.id("welcome")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.id("logInPanelHeading")).isDisplayed();

	}

	@BeforeTest
	public void LaunchBrowser() {
		CTR.Customize_Test_Report("OrangeHRM_Login_TestNG_Report.html", "Chrome");
		WebDriverManager.chromedriver().setup();
		// WebDriverManager.firefoxdriver().setup();
		// WebDriverManager.edgedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void CloseBrowser() {
		// driver.close();//Close will close only current chrome browser
		driver.quit();
		CTR.extent.flush();
	}

	@AfterMethod
	private void TestResult(ITestResult result) {
		CTR.getResult(result);
	}
}
