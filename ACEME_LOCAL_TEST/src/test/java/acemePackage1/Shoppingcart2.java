package acemePackage1;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shoppingcart2 {
	
	@Test  
	public void TRShoppingCart() throws Exception {

		String txtItemQty1 = "2";
		String txtCustomerName = "James Mondal";
		String txtAddress = "111 Terrace Ct";
		String txtCity = "Alexandria";
		String txtState = "VA";
		String txtZIP = "22234";
		String txtAcctNo = "123456789098765";
		String txtCVV2No = "112";
		String txtExpDate = "11/2023";
		SoftAssert sa=new SoftAssert();

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
		System.out.println("Final Total is ==="+actualTotal);

		sa.assertEquals(actualTotal,orderingTotal,"Investigate if the total does not match] but found");
		driver.findElement(By.cssSelector("html")).click();
		
		driver.quit();
		sa.assertAll();

	}

}
