package pk_Orange_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;

public class All_Relative_Locator_Example {
	 private WebDriver driver;
	    boolean status = false;
	 
	    @BeforeTest //Pre-condition
	    public void LaunchBrowser(){
		    WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("https://4dvanceboy.github.io/lambdatest/lambdasampleapp.html");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
	 
	   @AfterTest
	    public void tearDown() throws Exception {
	       if (driver != null) {
	           driver.quit();
	        }
	    }
	 
	    @Test
	    public void test_login_using_relative_locators_1(){
	        String name = driver.findElement(withTagName("input")
	                .above(By.name("li5"))
	                .below(By.name("li3")))
	                .getAttribute("name");
	        Assert.assertEquals(name, "li4");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
	    
	    @Test
	    public void test_login_using_relative_locators_2(){
	        String txt_name = driver.findElement(withTagName("input")
	                .toLeftOf(By.id("addbutton"))
	                .below(By.name("li5")))
	                .getAttribute("id");
	        Assert.assertEquals(txt_name, "sampletodotext");
	        
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
	    
	    @Test
	    public void test_login_using_relative_locators_3() throws InterruptedException{
	        WebElement txt_name =  driver.findElement(withTagName("input")
	                  .toLeftOf(By.id("addbutton"))
	                  .below(By.name("li5")));
	        
	        txt_name.sendKeys("Selenium");
	        Thread.sleep(3000);
	        
	        // Get details of the Submit/Add button
	        WebElement submitbutton = driver.findElement(By.xpath("//*[@id=\'addbutton\']"));
	        
	        // Submit the new entry
	        submitbutton.click();
	        
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }}
