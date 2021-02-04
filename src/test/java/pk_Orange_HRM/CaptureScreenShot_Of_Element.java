package pk_Orange_HRM;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureScreenShot_Of_Element {
  @Test
  public void ChromeBrowser() throws IOException {
	  
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		WebElement Button = driver.findElement(By.id("btnLogin"));
		Button.click();
	    File file = Button.getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(file,new File("LoginButton.png"));
	    driver.close();
  }
}
