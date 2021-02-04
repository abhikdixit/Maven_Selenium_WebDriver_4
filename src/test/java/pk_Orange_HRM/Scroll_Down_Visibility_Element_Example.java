package pk_Orange_HRM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll_Down_Visibility_Element_Example {

	ChromeDriver driver;
    @Test
    public void ByVisibleElement() throws InterruptedException {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
      //JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get( "https://www.shutterfly.com/");
		Thread.sleep(6000);
		driver.findElementByClassName("overlay-modal-close").click();
		Thread.sleep(6000);
		WebElement Element = driver.findElementByLinkText("Order Status");
        //This will scroll the page till the element is found		
	     //js.executeScript("arguments[0].scrollIntoView();", Element);
	      Element.click();
    }
}
