package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingSingleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("C:\\\\Users\\\\visha\\\\Desktop\\\\AdvSelenium\\\\TestData.xlsx");
               
		//step1: keep the excel in readable mode
		
		         Workbook book = WorkbookFactory.create(fis);
		 
		         
		 //step2: take control of sheet
		         
		        Sheet sheet = book.getSheet("sheet1");
		        
		 //step3: get control of row
		        
		        Row row = sheet.getRow(2);
		        
		  // step4: get control of cell
		        
		       Cell cell = row.getCell(1);
		       
		  // step5: get cell value
		       
		       String Excel_value = cell.getStringCellValue();
		       
		      System.out.println(Excel_value);
		
		
	}

}
