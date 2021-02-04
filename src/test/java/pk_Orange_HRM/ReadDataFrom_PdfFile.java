package pk_Orange_HRM;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataFrom_PdfFile {
	 WebDriver driver;
	 @BeforeTest
	 public void setup() throws Exception {

	    WebDriverManager.chromedriver().setup();
	    //WebDriverManager.firefoxdriver().setup();
	    //WebDriverManager.edgedriver().setup();
	    driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("D:\\F Drive\\EItin_DIXIT_BLR-AUH_TLWMAW43.pdf");
	 }
	 @Test
	 public void ReadPDFFile() throws InvalidPasswordException, IOException
		{

			String Currentlink=driver.getCurrentUrl();
			URL url=new URL(Currentlink);
			InputStream is=url.openStream();
			BufferedInputStream fp=new BufferedInputStream(is);
			PDDocument document=null;
			document=PDDocument.load(fp);
			String pdfContent= new PDFTextStripper().getText(document);
			System.out.println(pdfContent);
		}
	 
	 @AfterTest
	 public void Close() throws Exception {
	  driver.quit();
	 }
}
