package acemePackage1;

import Lib.ExcelConfigurationFile;

public class ExcelConf_ReadData {

	public static void main(String[] args) {

		ExcelConfigurationFile rxl=new ExcelConfigurationFile("C:/AllTestData/TestData.xlsx");
		
		String crntcellvalue=rxl.getData(0, 0, 0);
		
		System.out.println(crntcellvalue);
	}

}
