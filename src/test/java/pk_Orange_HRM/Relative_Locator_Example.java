package pk_Orange_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Relative_Locator_Example {
  @Test
  public void RelativeLocator() throws InterruptedException {
	  
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		//Take Reference of Login Panel to Identify UserName Field
		WebElement LoginElement=driver.findElement(By.id("logInPanelHeading"));
		driver.findElement(withTagName("input").below(LoginElement)).sendKeys("Admin");
		/*//Take Reference of Login button to Identify Password Field
		WebElement LoginButton=driver.findElement(By.id("divLoginButton"));
		System.out.println(LoginButton);
		driver.findElement(withTagName("input").above(LoginButton)).sendKeys("admin123");*/
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);
		WebElement SubLink=driver.findElement(By.xpath("//span[contains(text(),'Leave List')]"));
		driver.findElement(withTagName("div").toLeftOf(SubLink)).click();
		/*WebElement uname = driver.findElement(By.name("userName"));
		uname.sendKeys("testing");
		//*****To find the element using below concept**************
		driver.findElement(withTagName("input").below(uname)).sendKeys("testing");
		driver.findElement(By.name("login")).click();*/

		/*//*****To find the element using near() concept**************
		driver.findElement(withTagName("input").toRightOf(By.xpath("//input[@value='roundtrip']"))).click();
		Thread.sleep(5000);
		//*****To find the element using toRightOf() concept**************
		driver.findElement(withTagName("a").toRightOf(By.linkText("SIGN-OFF"))).click();
		Thread.sleep(5000);
		//*****To find the element using Above() concept**************
		//driver.findElement(withTagName("a").above(By.linkText("Hotels"))).click();
		//Thread.sleep(5000);
		//*****To find the element using near() concept**************
		driver.findElement(withTagName("a").toLeftOf(By.linkText("ITINERARY"))).click();*/
  }
}
