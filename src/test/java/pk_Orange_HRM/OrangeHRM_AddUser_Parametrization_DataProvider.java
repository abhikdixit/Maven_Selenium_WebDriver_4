package pk_Orange_HRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_AddUser_Parametrization_DataProvider extends OrangeHRM_TestData {
	ChromeDriver driver;

	public void Navigate_To_System_Users() throws InterruptedException{
		Navigation("menu_admin_viewAdminModule","menu_admin_UserManagement","menu_admin_viewSystemUsers");
		Thread.sleep(3000);
		Validate_URL("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
	}
	
	public void Validate_URL(String ExpURL) {
		String ActURL = driver.getCurrentUrl();
		Assert.assertEquals(ActURL, ExpURL);
	}

	public void Validate_Error(String ExpMessage) {
		String ActMessage = driver.findElementById("spanMessage").getText();
		Assert.assertEquals(ActMessage, ExpMessage);
		System.out.println("Error Message:: " + ActMessage);
	}

	public void Navigation(String... Menu) throws InterruptedException {
		Actions act = new Actions(driver);
		for (int length = 0; length < Menu.length; length++) {
			WebElement element = driver.findElementById(Menu[length]);
			act.moveToElement(element).build().perform();
			Thread.sleep(3000);
		}
		driver.findElementById(Menu[Menu.length - 1]).click();
	}

	public void Login(String Username, String Password) {
		driver.findElementById("txtUsername").clear();
		driver.findElementById("txtUsername").sendKeys(Username);
		driver.findElementById("txtPassword").clear();
		driver.findElementById("txtPassword").sendKeys(Password);
		driver.findElementById("btnLogin").click();
	}

	public void Logout() throws InterruptedException {
		driver.findElementById("welcome").click();
		Thread.sleep(3000);
		driver.findElementByLinkText("Logout").click();
		Thread.sleep(3000);
	}
	
	public void Adding_Users(String User_Role, String Employee_Name, String Username, String Status,
			String Password, String Confirm_Password) throws InterruptedException{
		driver.findElementById("btnAdd").click();
		Thread.sleep(3000);
		Select Select_Role= new Select(driver.findElementById("systemUser_userType"));
		Select_Role.selectByVisibleText(User_Role);
		driver.findElementById("systemUser_employeeName_empName").sendKeys(Employee_Name);
		driver.findElementById("systemUser_userName").sendKeys(Username);
		Select Select_Status= new Select(driver.findElementById("systemUser_status"));
		Select_Status.selectByVisibleText(Status);
		driver.findElementById("systemUser_password").sendKeys(Password);
		driver.findElementById("systemUser_confirmPassword").sendKeys(Confirm_Password);
		driver.findElementById("btnSave").click();
		Thread.sleep(3000);
		try{
			Validate_URL("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
		}
		catch(Error e){
			System.out.println("All informations are not provided Correctly. \nPlease Try Again with Proper Details.");
			driver.findElementById("btnCancel").click();
		}
		
		driver.findElementByXPath("//a[text()='"+Username+"']").isDisplayed();
	}
	
	@Test(priority=1)
	public void Login() throws InterruptedException
	{
		Login("admin", "admin123");
		Validate_URL("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		Navigate_To_System_Users();
	}

	@Test(dataProvider = "AddUsers", priority=2)
	public void Adding_Multiple_Users_DataProvider(String User_Role, String Employee_Name, String Username, String Status,
			String Password, String Confirm_Password) throws InterruptedException {
		Thread.sleep(3000);
		Adding_Users( User_Role, Employee_Name, Username, Status, Password, Confirm_Password);
	}

	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Validate_URL("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Logout();
		driver.quit();
	}

}
