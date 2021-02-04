package pk_Advance_Topics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_Excel_XLSX_File {

	private static Sheet ExcelSheet;
	private static Workbook Excelbook;

	public Object[][] Read_XLSX_File(String FileName, String SheetName)
			throws EncryptedDocumentException, IOException, IllegalFormatException {
		Object[][] arrayXLSXdata = null;
		FileInputStream file = new FileInputStream(FileName);
		Excelbook = WorkbookFactory.create(file);
		ExcelSheet = Excelbook.getSheet(SheetName);

		int ExcelAllRows = ExcelSheet.getLastRowNum();
		int ExcelAllColumns = ExcelSheet.getRow(0).getLastCellNum();
		arrayXLSXdata = new Object[ExcelAllRows][ExcelAllColumns];
		for (int row = 0; row < ExcelAllRows; row++) {
			for (int col = 0; col < ExcelAllColumns; col++) {
				if (ExcelSheet.getRow(row + 1).getCell(col).getCellType() == CellType.NUMERIC) {
					arrayXLSXdata[row][col] = ExcelSheet.getRow(row + 1).getCell(col).getNumericCellValue();
				} else {
					arrayXLSXdata[row][col] = ExcelSheet.getRow(row + 1).getCell(col).getStringCellValue();
				}

				if (arrayXLSXdata[row][col].equals(new String("empty"))) {
					arrayXLSXdata[row][col] = "";
				}
			}
		}
		return arrayXLSXdata;
	}

}
