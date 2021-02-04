package pk_Customize_Report_Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag_and_Drop {
	ChromeDriver driver;
	Customize_Test_Report CTR = new Customize_Test_Report();
  @Test
	public void DragDrop() throws InterruptedException {
	  CTR.test = CTR.extent.createTest("Test Case 1 :: Drag and Drop functionality"); 
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    //WebDriver driver = new ChromeDriver();
		// maximize browser
		driver.manage().window().maximize();
		// Open webpage
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		// Add 5 seconds wait
		Thread.sleep(5000);
		// Create object of actions class
		Actions act=new Actions(driver);
		// find element which we need to drag
		//WebElement drag=driver.findElementById("draggable");
		WebElement drag=driver.findElement(By.id("draggable"));
		// find element which we need to drop
		//WebElement drop=driver.findElementById("droppable");
		WebElement drop=driver.findElement(By.id("droppable"));
		// this will drag element to destination
		act.dragAndDrop(drag, drop).build().perform();
		 Thread.sleep(5000);
		driver.quit();
	 
		}
  @BeforeTest
	private void Creating_Report() {
		CTR.Customize_Test_Report("Drag_and_Drop_Report.html", "Chrome");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		CTR.extent.flush();
	}

	@AfterMethod
	private void TestResult(ITestResult result) {
		CTR.getResult(result);
	}
}
