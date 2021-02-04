package pk_Orange_HRM;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BaseClass {

	// String filePath_failure = "D:\\F Drive\\Selenium Training
	// Data\\workspace\\Maven_Selenium_WebDriver_4\\Screenshot_Failure";
	static String filePath_failure = System.getProperty("user.dir");

	static String Relativepath_failure = filePath_failure + "\\Screenshot_Failure";

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshot_Failure/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}
