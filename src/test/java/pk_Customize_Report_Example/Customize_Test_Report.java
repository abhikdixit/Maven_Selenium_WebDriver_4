package pk_Customize_Report_Example;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Customize_Test_Report {

	ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void Customize_Test_Report(String ReportName, String Browser){
		System.out.println("Top of Method");
	htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+ReportName);
	extent = new ExtentReports();
	extent.attachReporter(htmlreporter);
	
	extent.setSystemInfo("OS", System.getProperty("os.name"));
	extent.setSystemInfo("Browser", Browser);
	
	htmlreporter.config().setDocumentTitle("Test");
	htmlreporter.config().setReportName(ReportName);
	htmlreporter.config().setTheme(Theme.DARK);
	htmlreporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	System.out.println("Last of Method");
	}
	
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
