package pk_Orange_HRM;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_User_BasedOnUserName_and_UserRole {
	ChromeDriver driver;
	@BeforeTest
	public void LaunchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	@Test(priority=1)
	// This is for Sign On Functionality
	public void Sign_On() throws InterruptedException

	{
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String Element = driver.findElement(By.linkText("Dashboard")).getText();
		System.out.println(Element);
		
	}
	
	@Test(priority=2)
	public void AddUsers_Page()
	{
		WebElement admin = driver.findElementById("menu_admin_viewAdminModule");
		Actions action = new Actions(driver);
		action.moveToElement(admin).build().perform();
		WebElement usermanagement = driver.findElementByLinkText("User Management");
		action.moveToElement(usermanagement).build().perform();
		driver.findElementByLinkText("Users").click();
		//User Click on Add Button to add users
		driver.findElementById("searchBtn").click();
		driver.findElementById("btnAdd").isDisplayed();
		
	}
	@Test(priority=3,enabled=true)
	public void VerifyAddedUser() throws InterruptedException
	{
		driver.findElementById("btnAdd").click();
		
		//Enter all the mandatory Fields
		Select SelectPass = new Select(driver.findElementById("systemUser_userType"));
		//SelectPass.selectByValue("1");
		SelectPass.selectByVisibleText("Admin");
		//SelectPass.selectByIndex(0);
		driver.findElementById("systemUser_employeeName_empName").sendKeys("Fiona Grace");
		//Random randomGenerator = new Random();  
		//int randomInt = randomGenerator.nextInt(500); 
		WebElement UserNameInputbox=driver.findElementById("systemUser_userName");
		UserNameInputbox.sendKeys("abhidixitabhidixitabhidixitabhidixit"+System.currentTimeMillis());
		//Verify the MaxLength of UserName Field
		String EnteredValue = UserNameInputbox.getAttribute("value");
		int EnteredValueSize=EnteredValue.length();
		System.out.println("User Name Value entered size ="+EnteredValueSize);
		// Assert with expected
		if (EnteredValueSize == 40) {
			System.out.println("Maxlength character functionality is 40 and its working fine.");
		}
 
		else {
			System.out.println("It allow more than 40");
		}
 	//----------------------------------------
		driver.findElementById("systemUser_password").sendKeys("Pass@2212");
		driver.findElementById("systemUser_confirmPassword").sendKeys("Pass@2212");
		Thread.sleep(5000);
		driver.findElementById("btnSave").click();
		Thread.sleep(5000);
		String ExpUserName=EnteredValue;
		System.out.println(ExpUserName);
	    //WebElement cellIneed = driver.findElementByXPath("//*[@id='resultTable']/tbody/tr[1]/td[2]/a");
		WebElement cellIneed = driver.findElementByXPath("//a[contains(text(),'"+EnteredValue+"')]");
		//a[contains(text(),'abhidixit699')]
		//---//a[text()='"+ExpUserName+"']
	    String valueIneed = cellIneed.getText();
	    System.out.println("Cell value is : " + valueIneed); 
	    Assert.assertEquals(ExpUserName, valueIneed);
	    //Delete User from Search List

	    //driver.findElementByXPath("//a[text()='"+EnteredValue+"']/parent::td/preceding-sibling::td/input").click();
	    driver.findElementByXPath("//a[text()='"+EnteredValue+"']//parent::td/../td[contains(text(), 'Admin')]//parent::td/preceding-sibling::td/input").click();
	    //driver.findElementByXPath("//td/a[text()='"+EnteredValue+"']//parent::td/../td[text()='Admin']").isDisplayed();
		driver.findElementById("btnDelete").click();
		driver.findElementById("dialogDeleteBtn").click();
		
		
	}

	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
	}
}
