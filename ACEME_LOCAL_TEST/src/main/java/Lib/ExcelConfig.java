package Lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;

	public ExcelConfig(String xlFilePath) {
 
		try {
			File src = new File(xlFilePath); 
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			
		} catch (Exception e) {
			System.out.println("Here is the exception----->>>" + e.getMessage());
		}
	}
	public String getData(int sheetNumber,int rows,int cols) { 
		
		sheet = wb.getSheetAt(sheetNumber);
		
		String celldata = sheet.getRow(rows).getCell(cols).getStringCellValue();

		return celldata;

	}
	public int getRowCount(int sheetIndex) {
		
		int totalRow=wb.getSheetAt(sheetIndex).getLastRowNum()+1;
		
		return totalRow;
		
	}
}
