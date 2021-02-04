package pk_Orange_HRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Read_Data_From_WebTable {
  @Test
  public void WebTable() throws InterruptedException {

		//Navigate to the Web page
	  	WebDriverManager.chromedriver().setup();
	    //WebDriverManager.firefoxdriver().setup();
	    //WebDriverManager.edgedriver().setup();
	    ChromeDriver driver = new ChromeDriver();
		driver.get("https://trebl.kdev.ignite.harman.com/trebl/dashboard"); 
		//Login to App
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("trebl@harman.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Aa123415");
		driver.findElement(By.xpath("//div[@class='text-button-auth']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[text()='Gateways']")).click();
		//----------------------------
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 WebElement baseTable = driver.findElement(By.tagName("table"));
		  
		 //To find third row of table
		 WebElement tableRow = baseTable.findElement(By.xpath("//table[1]/tbody[1]/tr[5]/td[2]"));
         String rowtext = tableRow.getText();
         tableRow.click();
		 System.out.println("Third row of table : "+rowtext);
		    
	/*	    //to get 3rd row's 2nd column data
		    WebElement cellIneed = tableRow.findElement(By.xpath("//div[@id='leftcontainer']/table/tbody/tr[3]/td[2]"));
		    String valueIneed = cellIneed.getText();
		    System.out.println("Cell value is : " + valueIneed); 
		    
	         WebElement cellIneedThirdRow_FirstValue = tableRow.findElement(By.xpath("//div[@id='leftcontainer']/table/tbody/tr[3]/td[1]"));
	         cellIneedThirdRow_FirstValue.click();*/
		    //driver.close();
  }
}
