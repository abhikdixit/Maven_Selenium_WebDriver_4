package pk_Orange_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser_Navigation_Commands {
	ChromeDriver driver;
	//WebDriver driver;
	
	@Test
	public void ForgetPassword() throws InterruptedException
	{
		
		driver.findElementByLinkText("Forgot your password?").click();
		String ExpURL="https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode";
		String ActURL=driver.getCurrentUrl();
		Assert.assertEquals(ExpURL, ActURL);
		//Navigate back to Login Back
		driver.navigate().back();
		driver.findElementById("btnLogin").isDisplayed();
		//Navigate Forward 
		driver.navigate().forward();
		String ExpURLForward="https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode";
		String ActURLForward=driver.getCurrentUrl();
		Assert.assertEquals(ExpURLForward, ActURLForward);
		
	}
	//Pre-Condition
	@BeforeTest
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
	public void CloseBrowser(){
		//driver.quit();
	}

}
