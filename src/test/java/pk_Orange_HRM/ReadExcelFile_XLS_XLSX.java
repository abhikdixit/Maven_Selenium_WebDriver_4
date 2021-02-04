package pk_Orange_HRM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile_XLS_XLSX {
	private static Workbook ExcelWBook;
	private static Sheet ExcelWSheet;

	// this method is to read the test data from the excel File
	public String[][] getExcelData(String fileName, String sheetName)
	throws EncryptedDocumentException, IOException, IllegalFormatException {
	String[][] arrayExcelData = null;
	FileInputStream ExcelFile = new FileInputStream(fileName);
	ExcelWBook = new XSSFWorkbook(ExcelFile);
	ExcelWSheet = ExcelWBook.getSheet(sheetName);
	int totalNoOfRows = ExcelWSheet.getLastRowNum();
	int totalNoOfCols_0 = ExcelWSheet.getRow(0).getLastCellNum();
	arrayExcelData = new String[totalNoOfRows][totalNoOfCols_0];
	for (int i = 0; i < totalNoOfRows; i++) {
	int totalNoOfCols = ExcelWSheet.getRow(i).getLastCellNum();
	// arrayExcelData = new String [totalNoOfRows][totalNoOfCols];
	for (int j = 0; j < totalNoOfCols; j++) {
	arrayExcelData[i][j] = ExcelWSheet.getRow(i + 1).getCell(j).getStringCellValue();
	// System.out.println(arrayExcelData[i][j]);
	}
	}
	System.out.println(arrayExcelData);
	return arrayExcelData;
	}
}
