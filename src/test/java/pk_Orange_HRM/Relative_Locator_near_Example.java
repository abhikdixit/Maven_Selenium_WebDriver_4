package pk_Orange_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Relative_Locator_near_Example {
  @Test
  public void RelativeLocator() throws InterruptedException {
	  
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("selenium");
		driver.findElement(withTagName("input").near(By.name("btnK"))).click();
		
  }
}
