package pk_Orange_HRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.testng.annotations.Test;

public class ReadData_FromDoc_File {
	@Test
	public void main() throws IOException
	 {
	 String filePath="D:\\F Drive\\Selenium Training Data\\workspace\\Maven_Selenium_WebDriver_4\\MyData.docx";
	 //String filePath="D:\\F Drive\\Selenium Training Data\\workspace\\Maven_Selenium_WebDriver_4\\MyData.doc";
	 // Location of word document file.
	 loadFile(filePath);
	 }
	 
	 public static void loadFile(String filePath) throws IOException
	 {
	 File file=new File(filePath);                                                     // Creating File Object
	 String fileExtension=FilenameUtils.getExtension(filePath);  // Getting extension of files.
	 if(fileExtension.equalsIgnoreCase("docx"))
	 {
	 readDocxFile(file);
	 }
	 else if(fileExtension.equalsIgnoreCase("doc"))
	 {
	 readDocFile(file);
	 }
	 }
	 
	 // Reading data from ".docx" file.
	 public static void readDocxFile(File file) throws IOException
	 {
	 FileInputStream fis=new FileInputStream(file);
	 XWPFDocument doc =new XWPFDocument(fis);                                                      
	                // Getting all the paragraphs from the document and adding the same in ArrayList 
	 List<XWPFParagraph> getDocParagraphs= doc.getParagraphs();

	                // Getting a total number of paragraphs in the word document.
	 int totalParagraphs=getDocParagraphs.size();        
	 System.out.println("Total number of paragraphs : "+totalParagraphs);
	 
	                // Print document content on Console.
	 for (XWPFParagraph currentParagraph : getDocParagraphs)
	 {
	 System.out.println(currentParagraph.getText().toString());
	 }
	 doc.close();
	 }
	 
	 // Reading data from ".doc" file.
	 public static void readDocFile(File file) throws IOException
	 {
	 FileInputStream fis =new FileInputStream(file);
	 HWPFDocument doc=new HWPFDocument(fis);
	 
	 WordExtractor extractor=new WordExtractor(doc);
	                // Getting all the paragraphs from the document and adding the same in String array.
	 String[] getDocParagraphs= extractor.getParagraphText();

	                // Getting total number of paragraphs in word document.
	 int totalParagraphs=getDocParagraphs.length;
	 System.out.println("Total count of paragraphs : "+totalParagraphs+"\n");

	                // Print document content on Console.
	 for (String currentPara : getDocParagraphs)
	 {
	 System.out.print(currentPara);
	 }
	 extractor.close();
	 }
}
