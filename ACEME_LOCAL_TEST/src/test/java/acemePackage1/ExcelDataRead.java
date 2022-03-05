package acemePackage1;

public class ExcelDataRead {

	public static void main(String[] args) {
		
		ExcelDataConfig rxl=new ExcelDataConfig("C:/AllTestData/TestData.xlsx");
		
		String readingdata=rxl.getData(0, 1, 0);
		
		System.out.println("readingdata====>>"+readingdata);
	}

}
	