package acemePackage1;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadXLdata {
	
	@Test
	public void addition() throws Exception 
	{
	String filePath="C:/AllTestData/TestData.xlsx";
	File src=new File(filePath);//Load the xl file
	FileInputStream fis=new FileInputStream(src);//read stream of the file
	XSSFWorkbook wb=new XSSFWorkbook(fis);//open the workbook
	
	XSSFSheet sheet=wb.getSheetAt(0);
	
	int totalrow=sheet.getLastRowNum()+1;
	
	for(int i=0;i<totalrow;i++) {
		
		String cellval=sheet.getRow(i).getCell(0).getStringCellValue();
		
		System.out.println(cellval);
			
	}
	wb.close();
	
	
	
	}

}
