package acemePackage1;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import DataProviderLibrary.dataProviderExcel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class Shoppingcart {
	
	@Test  (dataProvider = "Traingrite")
	public void TRShoppingCart(String txtItemQty1,String txtCustomerName,String txtAddress,String txtCity,String txtState,String txtZIP,String txtAcctNo,String txtCVV2No,String txtExpDate ) throws Exception {

//		String txtItemQty1 = "2";
//		String txtCustomerName = "James Mondal";
//		String txtAddress = "111 Terrace Ct";
//		String txtCity = "Alexandria";
//		String txtState = "VA";
//		String txtZIP = "22234";
//		String txtAcctNo = "123456789098765";
//		String txtCVV2No = "112";
//		String txtExpDate = "11/2023";

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_98.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.trainingrite.net/OnLine/home.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

//		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.id("btnApple_Iphone_6.jpg")).click();
		driver.findElement(By.cssSelector("table:nth-child(2) tr:nth-child(2) > td:nth-child(1)")).click();
		driver.findElement(By.name("txtItemQty1")).clear();
		Thread.sleep(1000);
		driver.findElement(By.name("txtItemQty1")).sendKeys(txtItemQty1);
		driver.findElement(By.id("Recalc")).click();
		String orderingTotal=driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]")).getText();
		
		System.out.println("Grand Total is ==="+orderingTotal);
		
		driver.findElement(By.cssSelector("input:nth-child(5)")).click();
		driver.findElement(By.name("txtCustomerName")).click();
		driver.findElement(By.name("txtCustomerName")).sendKeys(txtCustomerName);
		driver.findElement(By.name("txtAddress")).sendKeys(txtAddress);
		driver.findElement(By.name("txtCity")).sendKeys(txtCity);
//	    driver.findElement(By.cssSelector("td tr:nth-child(4) > td:nth-child(2) > font")).click();
		driver.findElement(By.name("txtState")).sendKeys(txtState);
		driver.findElement(By.name("txtZIP")).click();
		driver.findElement(By.name("txtZIP")).sendKeys(txtZIP);
		driver.findElement(By.name("optPaymentType")).click();
		driver.findElement(By.name("txtAcctNo")).click();
		driver.findElement(By.name("txtAcctNo")).sendKeys(txtAcctNo);
		driver.findElement(By.name("txtCVV2No")).click();
		driver.findElement(By.name("txtCVV2No")).sendKeys(txtCVV2No);
		driver.findElement(By.name("txtExpDate")).click();
		driver.findElement(By.name("txtExpDate")).sendKeys(txtExpDate);
		String actualTotal=driver.findElement(By.xpath("//table[2]/tbody/tr[5]/td[2]")).getText();
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actualTotal.equalsIgnoreCase(orderingTotal), "Investigate if the total does not match");
		
		driver.findElement(By.cssSelector("html")).click();
		driver.quit();
	} 

	@DataProvider(name="Traingrite")
	public Object[][] dp() {

		dataProviderExcel readExcel = new dataProviderExcel("./TestData/ShoppingcartTestData.xlsx");
		int row = readExcel.rowCount(0);

		Object[][] data = new Object[row][9];
		for (int i = 0; i < row; i++) {

			data[i][0] = readExcel.getData(0, i, 0);
			data[i][1] = readExcel.getData(0, i, 1);
			data[i][2] = readExcel.getData(0, i, 2);
			data[i][3] = readExcel.getData(0, i, 3);
			data[i][4] = readExcel.getData(0, i, 4);
			data[i][5] = readExcel.getData(0, i, 5);
			data[i][6] = readExcel.getData(0, i, 6);
			data[i][7] = readExcel.getData(0, i, 7);
			data[i][8] = readExcel.getData(0, i, 8);

		}
		return data;

	};
}
