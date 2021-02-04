package pk_Orange_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EnterText_PressEnter_Button_Example {
	ChromeDriver driver;
  @Test
  public void PressEnterKey() {
	  
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
        driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("Selenium Testing",Keys.ENTER);
		String ReturnText=driver.findElement(By.xpath("//span[text()='Selenium testing']")).getText();
		Assert.assertEquals("Selenium testing", ReturnText);
		//driver.findElement(By.xpath("//span[contains(text(),'Dummy PDF file')]")).click();
		driver.quit();
  }
}
