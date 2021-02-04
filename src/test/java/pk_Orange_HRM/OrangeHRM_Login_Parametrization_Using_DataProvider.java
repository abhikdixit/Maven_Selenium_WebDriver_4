package pk_Orange_HRM;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Login_Parametrization_Using_DataProvider extends OrangeHRM_TestData {
	WebDriver driver;

	@Test(dataProvider="LoginScenario",priority=1)
	public void Login(String URL,String Uname,String Upass) throws InterruptedException {
		driver.get(URL);
		driver.findElement(By.name("txtUsername")).sendKeys(Uname);
		driver.findElement(By.name("txtPassword")).sendKeys(Upass);
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
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
