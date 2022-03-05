package acemePackage1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDDT {
	
	@Test(dataProvider="AcemeData")
	
	public void AcemeLogin(String email, String password) {
		System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://acme-test.uipath.com/login");

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/form/button")).click();
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a")).click();
		driver.quit();

	}

	@DataProvider(name = "AcemeData")
	
	public Object[][] loginCredentials() {
		
		ExcelDataConfig objXL=new ExcelDataConfig("C:\\DemoWorkspace\\ACEME_LOCAL_TEST\\TestData\\inputData.xlsx");
		
		int xnumRow=objXL.getRowCount(0);
		
		Object[][] data = new Object[xnumRow][2];
		
		for(int i=0;i<xnumRow;i++) {
			
			data[i][0]=objXL.getData(0, i, 0);
			data[i][1]=objXL.getData(0, i, 1);
		}

		

		return data;
	}

}
