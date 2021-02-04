package pk_Orange_HRM;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowser_Test {
	//ChromeDriver driver;
  @Test
  public void ChromeBrowser() throws InterruptedException {
	  
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    //WebDriverManager.firefoxdriver().setup();
	    //WebDriverManager.edgedriver().setup();

	    driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
	    //This will wait for Page to load
        //driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	  //This will store or rememember the cookies or navigation in terms of back and forward
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		//Verify that Dashboard page displayed
		String ActElement = driver.findElement(By.linkText("Dashboard")).getText();
		String ExpElement="Dashboard";
		Assert.assertEquals(ActElement, ExpElement);
		System.out.println(ActElement);
		//----------------To Verify Logout Function----------------
		
		/* driver.findElement(By.id("welcome")).click();
	      Thread.sleep(3000);
	        driver.findElement(By.linkText("Logout")).click();
	        String ActLogpanel = driver.findElement(By.id("logInPanelHeading")).getText();
	        String ExpLogpanel="LOGIN Panel";
	        Assert.assertEquals(ActLogpanel, ExpLogpanel);
	        System.out.println(ActLogpanel);*/
	      //----------------To Verify Logout Function without using Assert----------------
			
			 driver.findElement(By.id("welcome")).click();
		      Thread.sleep(3000);
		        driver.findElement(By.linkText("Logout")).click();
		        driver.findElement(By.id("logInPanelHeading")).isDisplayed();
		//driver.close();//Close will close only current chrome browser
		driver.quit();
  }
}
