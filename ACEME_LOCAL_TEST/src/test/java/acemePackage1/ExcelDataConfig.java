package acemePackage1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {

	XSSFWorkbook wb;
	XSSFSheet sheet;

	public ExcelDataConfig(String xlsxFilePath) {

		try {
			File src = new File(xlsxFilePath);

			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getData(int sheetNuber, int row, int column) {

		sheet = wb.getSheetAt(sheetNuber);
		
		String getcellval = sheet.getRow(row).getCell(column).getStringCellValue();

		return getcellval;
	}
	
	public int getRowCount(int sheetindex) {
		
		int rowcount=wb.getSheetAt(sheetindex).getLastRowNum()+1;
		
		return rowcount;
		
	}
}
