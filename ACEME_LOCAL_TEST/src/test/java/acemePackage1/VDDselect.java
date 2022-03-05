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

public class VDDselect {

	SoftAssert sa = new SoftAssert();

	@Test
	public void vendorInventory() throws Exception {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_98.exe");
		driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("https://acme-test.uipath.com/login");
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

			driver.findElement(By.xpath("//*[@id='vendorTaxId']")).click();

			String selectedItem = vdd.get(i).getText();

			Thread.sleep(2000);

			System.out.println("Each item selected in the vdd: " + selectedItem);
		}
		driver.quit();
	} 

}
