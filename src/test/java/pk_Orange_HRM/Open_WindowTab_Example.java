package pk_Orange_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Open_WindowTab_Example {
  @Test
  public void ChromeBrowser() throws InterruptedException {
	  
	    //WebDriverManager.chromedriver().setup();
	    WebDriverManager.firefoxdriver().setup();
	    //WebDriver driver = new ChromeDriver();
	    WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String Element = driver.findElement(By.linkText("Dashboard")).getText();
		System.out.println(Element);
		//driver.close();//Close will close only current chrome browser
		//*******Navigate to another Tab and lauch another app
	    driver.switchTo().newWindow(WindowType.TAB);
	    driver.navigate().to("https://www.google.co.in/");
	    Thread.sleep(6000);
	    //driver.close();
	    driver.quit();
  }
}
