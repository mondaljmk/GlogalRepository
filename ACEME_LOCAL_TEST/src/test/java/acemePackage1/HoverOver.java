package acemePackage1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HoverOver {

	@Test
	public void hoverOverFinction() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_98.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.priviahealth.com/who-we-support/physicians/privia-medical-group/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		FunctionLibrary.hoverFunction(driver, "//a[contains(text(),'WHO WE SUPPORT')]");

		FunctionLibrary.SelectItemBootStrapDD(driver, "//*[@id='myLinks']//ul[@class='submen']//li", "Health Systems");
		SoftAssert sa = new SoftAssert();

		String actual = "Health Systems Grow Stronger With Privia";// coming from the application
		//coming from the test case
		String expected = driver.findElement(By.xpath("//*[contains(@id,'text-box')]/div/div/h1//img")).getText();
		
		
		System.out.println(expected);

		sa.assertEquals(actual, expected);

	}
}
