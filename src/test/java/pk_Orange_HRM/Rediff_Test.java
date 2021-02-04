package pk_Orange_HRM;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rediff_Test {
	
	public static void main(String[] args) throws InterruptedException
	 {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	  
	  //driver.findElementByName("proceed").click();
	  driver.findElement(By.name("proceed")).click();
	  Thread.sleep(1000);
	  Alert alert=driver.switchTo().alert();
	  System.out.println(alert.getText());
	  alert.accept();
}
}
