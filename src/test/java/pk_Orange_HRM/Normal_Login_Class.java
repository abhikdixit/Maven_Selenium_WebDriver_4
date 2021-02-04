package pk_Orange_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Normal_Login_Class {
	WebDriver driver;
	@Test(priority=1)
	public void Login_001()
	{
	   
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Test(priority=2)
	public void Logout() throws InterruptedException
	{
		
		  driver.findElement(By.id("welcome")).click(); 
		  Thread.sleep(3000);
		 driver.findElement(By.linkText("Logout")).click();
		 String ActLogpanel= driver.findElement(By.id("logInPanelHeading")).getText();
		 String ExpLogpanel="LOGIN Panel"; 
		 Assert.assertEquals(ActLogpanel,ExpLogpanel); 
		 System.out.println(ActLogpanel);

	}
	//Pre-Condition
	@BeforeTest
	//@Test(priority=1)
	public void LaunchBrowser(){
		 WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    //This will wait for Page to load
	        //driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		  //This will store or rememember the cookies or navigation in terms of back and forward
	        driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	//Post Condition
	@AfterTest
	//@Test(priority=3)
	public void CloseBrowser(){
		driver.quit();
	}

}
