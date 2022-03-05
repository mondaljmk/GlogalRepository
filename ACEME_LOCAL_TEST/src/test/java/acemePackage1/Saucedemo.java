package acemePackage1;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class Saucedemo {
	
	@Test(dataProvider = "Saucedemo")

	public void shoppingCartSauceDemo(String fname, String lname,String postalcode) {
		
//		String fname="Madison";
//		String lname="Anderson";
//		String postalcode="22314";

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_98.exe");
		WebDriver driver = new ChromeDriver();
		
		SoftAssert sa=new SoftAssert();
		

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
		driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
		driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
		driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
		driver.findElement(By.cssSelector("*[data-test=\"add-to-cart-sauce-labs-bike-light\"]")).click();
		driver.findElement(By.cssSelector(".shopping_cart_badge")).click();
		
		driver.findElement(By.cssSelector("*[data-test=\"checkout\"]")).click();
		driver.findElement(By.cssSelector("*[data-test=\"firstName\"]")).click();
		driver.findElement(By.cssSelector("*[data-test=\"firstName\"]")).sendKeys(fname);
		driver.findElement(By.cssSelector("*[data-test=\"lastName\"]")).click();
		driver.findElement(By.cssSelector("*[data-test=\"lastName\"]")).sendKeys(lname);
		driver.findElement(By.cssSelector("*[data-test=\"postalCode\"]")).click();
		driver.findElement(By.cssSelector("*[data-test=\"postalCode\"]")).sendKeys(postalcode);
		driver.findElement(By.cssSelector("*[data-test=\"continue\"]")).click();
		
		String strTotal=driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText();
		sa.assertEquals(strTotal, "Total: $43.18"," If fails please investigate");		

		driver.findElement(By.cssSelector("*[data-test=\"finish\"]")).click();
		driver.findElement(By.cssSelector("*[data-test=\"back-to-products\"]")).click();
		System.out.println("Beta test completed successfully");
		driver.quit();
		sa.assertAll();
	}

	@DataProvider(name="Saucedemo")
	public Object[][] dp() {
		
		ExcelDataConfig objxlsData=new ExcelDataConfig("./TestData/SauceDemo.xlsx");
		
		int row=objxlsData.getRowCount(0);
			
		Object[][] testData=new Object[row][3];
		
		for (int i = 0; i < row; i++) {
			testData[i][0]=objxlsData.getData(0, i, 0);
			testData[i][1]=objxlsData.getData(0, i, 1);
			testData[i][2]=objxlsData.getData(0, i, 2);
		}
		return testData;
			
	}
}
