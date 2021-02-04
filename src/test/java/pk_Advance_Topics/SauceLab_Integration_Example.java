package pk_Advance_Topics;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.Test;

public class SauceLab_Integration_Example {

    public static final String USERNAME = "abhikdixit";
    public static final String ACCESS_KEY = "d246025c-7be6-497f-9206-2db3dd761350";
    //public static final String URL = "https://" + "abhikdixit" + ":" + "d246025c-7be6-497f-9206-2db3dd761350" + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
    @Test
    public void SauceLab_Example() throws MalformedURLException, InterruptedException {
        // TODO Auto-generated method stub
    	// Below Configuration for Win10/Chrome
    	//MutableCapabilities sauceOptions = new MutableCapabilities();
    	DesiredCapabilities sauceOptions = new DesiredCapabilities();
    	
    	//EdgeOptions browserOptions = new EdgeOptions();
    	ChromeOptions browserOptions = new ChromeOptions();
    	//SafariOptions browserOptions = new SafariOptions();
    	//FirefoxOptions browserOptions = new FirefoxOptions();
    	//browserOptions.setExperimentalOption("w3c", true);
    	browserOptions.setCapability("platformName", "macOS 10.13");
    	//browserOptions.setCapability("platformName", "Windows 10");
    	//browserOptions.setCapability("platformName", "Windows 7");
    	browserOptions.setCapability("browserVersion", "latest");
    	browserOptions.setCapability("sauce:options", sauceOptions);
   	
        WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), browserOptions);
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(8000);
		String Element = driver.findElement(By.linkText("Dashboard")).getText();
		System.out.println(Element);
		driver.quit();
		
    	//Below Configuration for Mac/Chrome Latest Version
    	/*MutableCapabilities sauceOptions = new MutableCapabilities();
    	//ChromeOptions browserOptions = new ChromeOptions();
    	FirefoxOptions browserOptions = new FirefoxOptions();
    	browserOptions.setCapability("platformName", "Windows 10");
    	browserOptions.setCapability("browserVersion", "latest");
    	browserOptions.setCapability("sauce:options", sauceOptions);*/


    }
}
