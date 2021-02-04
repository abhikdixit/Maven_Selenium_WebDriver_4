package pk_Advance_Topics;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Orange_HRM_User_Login_Multiple_Scenarios_Extent_Report extends OrangeHRMLoginTestData {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	// helps to generate the logs in test report.
	ExtentTest test;

	ChromeDriver driver;

	public void Validate_URL(String ExpURL) {
		String ActURL = driver.getCurrentUrl();
		Assert.assertEquals(ActURL, ExpURL);
	}

	public void Validate_Error(String ExpMessage) {
		String ActMessage = driver.findElementById("spanMessage").getText();
		Assert.assertEquals(ActMessage, ExpMessage);
		System.out.println("Error Message:: " + ActMessage);
	}

	public void Navigation(String... Menu) {
		Actions act = new Actions(driver);
		for (int length = 0; length < Menu.length; length++) {
			WebElement element = driver.findElementById(Menu[length]);
			act.moveToElement(element).build().perform();
		}
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

	@Test(dataProvider = "Read From Excel XLSX", priority = 2)
	public void login_DataProvider(double serial_number, String Uname, String Upass, String Message)
			throws InterruptedException {
		int Test_Case_num = Integer.valueOf((int) (serial_number + 1));
		test = extent.createTest("Test Case " + Test_Case_num + " :: " + Message, "Multiple");
		Login(Uname, Upass);
		Boolean exception = true;
		try {
			driver.findElementById("spanMessage").isDisplayed();
		} catch (NoSuchElementException excptn) {
			exception = false;
		}
		if (exception) {
			Validate_Error(Message);
			Thread.sleep(3000);
		} else {
			System.out.println(Message + " for User " + Uname + ".");
			Thread.sleep(3000);
			Validate_URL("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
			Logout();
		}
	}

	@Test(priority = 1)
	public void LaunchApplication()

	{
		test = extent.createTest("Test Case 1 :: Launching Application", "Launching Chrome Browser");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		Validate_URL("https://opensource-demo.orangehrmlive.com/");
	}

	@BeforeTest()
	public void startReport() {
		// initialize the HtmlReporter
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/testReport.html");
		// initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		// To add system or environment info by using the setSystemInfo method.
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Browser", "Chrome");

		// configuration items to change the look and feel
		// add content, manage tests etc
		// htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Extent Report Demo");
		htmlReporter.config().setReportName("Smoke Test Report");
		// htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

	}

	@AfterTest
	public void CloseBrowser()

	{
		driver.quit();
		// to write or update test information to reporter
		extent.flush();
	}

	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
			test.fail(result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
		} else {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}
}
