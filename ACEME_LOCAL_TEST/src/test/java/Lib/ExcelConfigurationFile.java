package Lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfigurationFile {

	XSSFWorkbook wb;
	XSSFSheet sheet;

	public ExcelConfigurationFile(String xlsxFilePath) {

		try {
			File src = new File(xlsxFilePath);

			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

	public String getData(int sheetnumber, int row, int col) {
		
		sheet = wb.getSheetAt(sheetnumber);

		String getcelldata=sheet.getRow(row).getCell(col).getStringCellValue();
		
		return getcelldata;
		

	}

}
