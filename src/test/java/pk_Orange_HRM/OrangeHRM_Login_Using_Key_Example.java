package pk_Orange_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login_Using_Key_Example {
	ChromeDriver driver;
  @Test
  public void ChromeBrowser() {
	  
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
	    driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	    driver.findElementById("txtUsername").sendKeys("admin", Keys.TAB, "admin123", Keys.ENTER);
        //driver.findElement(By.name("txtUsername")).sendKeys("Admin", Keys.TAB);
        //driver.findElement(By.name("txtPassword")).sendKeys("admin123", Keys.ENTER);
		driver.findElement(By.linkText("dashboard")).isDisplayed();
		driver.quit();
  }
}
