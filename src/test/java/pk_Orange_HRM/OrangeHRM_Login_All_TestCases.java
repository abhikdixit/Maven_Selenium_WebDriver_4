package pk_Orange_HRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login_All_TestCases extends OrangeHRM_TestData {
	ChromeDriver driver;

	public void Validate_URL(String ExpURL) {
		String ActURL = driver.getCurrentUrl();
		Assert.assertEquals(ActURL, ExpURL);
	}

	public void Validate_Error(String ExpMessage) {
		String ActMessage = driver.findElementById("spanMessage").getText();
		Assert.assertEquals(ActMessage, ExpMessage);
		System.out.println("Error Message:: " + ActMessage);
	}

	public void Navigation(String... Menu) {
		Actions act = new Actions(driver);
		for (int length = 0; length < Menu.length; length++) {
			WebElement element = driver.findElementById(Menu[length]);
			act.moveToElement(element).build().perform();
		}
	}

	public void Login(String Username, String Password) {
		driver.findElementById("txtUsername").clear();
		driver.findElementById("txtUsername").sendKeys(Username);
		driver.findElementById("txtPassword").clear();
		driver.findElementById("txtPassword").sendKeys(Password);
		driver.findElementById("btnLogin").click();
	}

	public void Logout() throws InterruptedException {
		driver.findElementById("welcome").click();
		Thread.sleep(3000);
		driver.findElementByLinkText("Logout").click();
		Thread.sleep(3000);
	}

	@Test(dataProvider = "LoginScenario")
	public void login_DataProvider(String Uname, String Upass, String Message) throws InterruptedException {
		Login(Uname, Upass);
		Boolean Error = true;
		try{ 
			driver.findElementById("spanMessage").isDisplayed();
		}
		catch(Exception e){
			Error = false;
		}
		if (Error) {
			Validate_Error(Message);
			Thread.sleep(3000);
		} 
		else {
			System.out.println(Message + " for User " + Uname + ".");
			Thread.sleep(3000);
			Validate_URL("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
			Logout();
		}
	}

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Validate_URL("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
