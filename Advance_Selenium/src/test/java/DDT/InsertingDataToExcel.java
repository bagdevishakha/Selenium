package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertingDataToExcel {

	public static void main(String[] args) throws Throwable {
	
		// step1: path representation
	FileInputStream fis = new FileInputStream("C:\\Users\\visha\\Desktop\\AdvSelenium\\TestData.xlsx");
	
	//step2: take file in readable mode 
	
	 Workbook book = WorkbookFactory.create(fis);
	 
	//step3: take control of sheet
	 
	Sheet sheet = book.getSheet("sheet1");
	
	//step4: take control of row 
	
	Row row = sheet.createRow(4);
	
	Cell cel = row.createCell(5);
	
	 cel.setCellValue("Qspider");
	
	 FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\visha\\\\Desktop\\\\AdvSelenium\\\\TestData.xlsx");
	book.write(fos);
	book.close();
	
	
	
	}

}
