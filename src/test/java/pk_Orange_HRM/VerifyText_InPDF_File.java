package pk_Orange_HRM;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyText_InPDF_File {
	ChromeDriver driver;
	String strURL="file:///D:/F%20Drive/EItin_DIXIT_BLR-AUH_TLWMAW43.pdf";
	//Launching PDF file from your local system
	@Test
	public void testVerifyPDFTextInBrowser() throws IOException {
		//URL stands for Uniform Resource Locator and represents a resource on the World Wide Web, such as a Web page or FTP directory.
		URL url = new URL(strURL);
		//InputStream class is the superclass of all the io classes
		InputStream is= url.openStream();
		//The BufferedInputStream class of the java.io package is used with other input streams to read the data (in bytes) more efficiently.
		//It extends the InputStream abstract class.
		BufferedInputStream file = new BufferedInputStream(is);
		PDDocument document =null;
		document=PDDocument.load(file);
		String pdfContent = new PDFTextStripper().getText(document);
		System.out.println(pdfContent);
		Assert.assertTrue(pdfContent.contains("MR ABHINAYKUMAR DIXIT"));
		
	}
	//Launching PDF in browser and verifying
	@Test
	public void testVerifyPDFTextUsing_Get() throws IOException {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf");
	    String CurrentURL=driver.getCurrentUrl();
		URL url = new URL(CurrentURL);
		InputStream is= url.openStream();
		BufferedInputStream file = new BufferedInputStream(is);
		PDDocument document =null;
		document=PDDocument.load(file);
		String pdfContent = new PDFTextStripper().getText(document);
		System.out.println(pdfContent);
		Assert.assertTrue(pdfContent.contains("Dummy PDF file"));
		
	}
// Note: We can't read or parse pdf which are scanned, as its treated as image
}
