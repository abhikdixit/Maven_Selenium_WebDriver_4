package pk_Orange_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait_Example {
  @Test
	public void Explicit_Wait()
	
	{
	    WebDriverManager.chromedriver().setup();
	    ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		//-----------------ImplicitWait Example-------------
		//Thread.sleep(3000);
		/*driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		String Element = driver.findElement(By.linkText("PIM")).getText();
		
		System.out.println(Element);
		
		// ----------------To Verify Logout Function without using
				// Assert----------------
				//driver.findElement(By.id("welcome")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).click();
				driver.findElement(By.linkText("Logout")).click();
				driver.findElement(By.id("logInPanelHeading")).isDisplayed();*/

		//----------------ExplicitWait Example--------------
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("PIM")));
		element.getText();
		element.click();
		
		driver.quit();		
	}
}
