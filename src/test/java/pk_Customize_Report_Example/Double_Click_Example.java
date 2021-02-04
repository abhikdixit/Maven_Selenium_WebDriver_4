package pk_Customize_Report_Example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Double_Click_Example {
	ChromeDriver driver;
	Customize_Test_Report CTR = new Customize_Test_Report();
	
	@Test
	public void DragDrop() throws InterruptedException {
//Calling Extent report 
		CTR.test = CTR.extent.createTest("Test Case 1 :: Double Click functionality");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		// maximize browser
		driver.manage().window().maximize();
		// Open webpage
		driver.get("https://www.testandquiz.com/selenium/testing.html");
		
		WebElement DoubleClick = driver.findElementById("dblClkBtn");
		Actions action = new Actions(driver);
		action.doubleClick(DoubleClick).perform();

		String ActText = driver.switchTo().alert().getText();
		String ExpText = "hi, JavaTpoint Testing";
		Assert.assertEquals(ActText, ExpText);
		System.out.println(ActText);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();

		}
	@BeforeTest
	private void Creating_Report() {
		CTR.Customize_Test_Report("Double_Click_Example_Report.html", "Chrome");
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
