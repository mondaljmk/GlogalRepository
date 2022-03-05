package DataProviderLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataProviderExcel {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	public dataProviderExcel(String xlFilePath) {

		try {
			File src = new File(xlFilePath);
			FileInputStream fis = new FileInputStream(src);
			 wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage()); 
		}
	}

	public String getData(int sheetNo,int rows, int cols) {	
		sheet=wb.getSheetAt(sheetNo);	
		String cellData=sheet.getRow(rows).getCell(cols).getStringCellValue();	
		return cellData;
	} 
	
	public int rowCount(int sheetIndex) {
		
		int totalrows=wb.getSheetAt(sheetIndex).getLastRowNum()+1;
		return totalrows;
		
		
	}
}
