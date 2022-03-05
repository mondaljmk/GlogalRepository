package acemePackage1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VendorInvertory {

	SoftAssert sa = new SoftAssert();

	@Test
	public void vendorInventory() throws Exception {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_98.exe"); 
		driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("https://acme-test.uipath.com/login");
//		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("mondal.jmk@gmail.com"); 
		driver.findElement(By.id("password")).click(); 
		driver.findElement(By.id("password")).sendKeys("DHIMSdte12345$$");
		driver.findElement(By.cssSelector(".btn-primary")).click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,200)");

		driver.findElement(By.xpath("//*[@id=\"dashmenu\"]//button[text()=' Vendors']")).click();

		Thread.sleep(2000);

		driver.findElement(By.linkText("Vendor Inventory")).click();
		Thread.sleep(2000);

		WebElement vendorDD = driver.findElement(By.xpath("//*[@id='vendorTaxId']"));

		List<WebElement> vdd = vendorDD.findElements(By.tagName("Option"));

		for (int i = 0; i < vdd.size(); i++) {
			String currentItem = vdd.get(i).getText();
			
			switch (currentItem) {
			
			case "DE325476":
				sa.assertEquals(currentItem, "DE325476");
				break;
			case "FR065748":
				sa.assertEquals(currentItem, "FR065748");
				break;
			case "IT145632":
				sa.assertEquals(currentItem, "IT145632","raise the bug if it fails");
				break;
			case "RO094782":
				sa.assertEquals(currentItem, "RO094782");
				break;
			case "RU567434":
				sa.assertEquals(currentItem, "RU567434");
				break;
			default:
				System.out.println("This item is not correct :" + currentItem);

			}
			sa.assertAll();
		}
		driver.quit();

	}
	

}
