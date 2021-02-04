package pk_Advance_Topics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EventListeners {

	private WebDriver driver;
	private EventFiringWebDriver e_driver;
	private WebEventListener eventListener;
	private String appURL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

	@BeforeClass()
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		e_driver.manage().window().maximize();
		e_driver.get(appURL);
	}

	@Test
	public void testEventsOne() {
		System.out.println("***** Executing Test One ***** ");
		// Entering user name and clicking on next
		e_driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		e_driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		e_driver.findElement(By.id("btnLogin")).click();
		// Verify that Dashboard page displayed
		String ActElement = e_driver.findElement(By.linkText("Dashboard")).getText();
		String ExpElement = "Dashboard";
		Assert.assertEquals(ActElement, ExpElement);
	}

	@AfterClass()
	public void tearDown() {
		if (e_driver != null) {
			e_driver.quit();
		}
	}

}
