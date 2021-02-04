package pk_Orange_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_SearchByUserName_MouseOver {

@Test
	//This is for Sign On Functionality
	public void Sign_On()
		
		{
    WebDriverManager.chromedriver().setup();
    //WebDriverManager.firefoxdriver().setup();
    //WebDriverManager.edgedriver().setup();
    ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			driver.findElement(By.name("txtUsername")).sendKeys("Admin");
			driver.findElement(By.name("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			String Element = driver.findElement(By.linkText("Dashboard")).getText();
			System.out.println(Element);
			WebElement admin = driver.findElementById("menu_admin_viewAdminModule");

	        Actions action = new Actions(driver);
	        action.moveToElement(admin).build().perform();
			WebElement usermanagement = driver.findElementByLinkText("User Management");
	        action.moveToElement(usermanagement).build().perform();
	        driver.findElementByLinkText("Users").click();
	        driver.findElementById("searchSystemUser_userName").sendKeys("Admin");
	        driver.findElementById("searchBtn").click();
	        driver.findElementByLinkText("Admin").isDisplayed();
			driver.close();//Close will close only current chrome browser
		}
	
	
}
