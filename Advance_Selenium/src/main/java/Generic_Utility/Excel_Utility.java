package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	public String getExcelData(String SheetName, int rowNum, int celNum) throws Throwable
	{
		  FileInputStream fes = new FileInputStream("C:\\Users\\visha\\Desktop\\AdvSelenium\\TestData.xlsx");
		    //keep excel in read mode 
		    Workbook book = WorkbookFactory.create(fes);
		    
		    Sheet sheet =book.getSheet(SheetName);
		    
		    Row row = sheet.getRow(rowNum);
		    
		    Cell cel = row.getCell(celNum);
		   DataFormatter format = new DataFormatter();
		   String ExcelData = format.formatCellValue(cel);
		   return ExcelData;
	}
}
