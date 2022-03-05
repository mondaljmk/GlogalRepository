package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddAccount {



	private String email="mondal.jmk@gmail.com";
	private String PSW="DHIMSdte12345$$";

	@Test
	public void addAccount() throws Exception {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_98.exe");
		driver = new ChromeDriver(); 

		SoftAssert SA=new SoftAssert();

		Login oLogin = new Login();
		oLogin.login(driver,email,PSW);
		
	
		
		driver.findElement(By.cssSelector(".dropdown:nth-child(12) > .btn")).click();
		driver.findElement(By.linkText("Add Account")).click();
		driver.findElement(By.id("firstname")).click();
		driver.findElement(By.id("firstname")).sendKeys("James");
		driver.findElement(By.id("lastname")).sendKeys("Halder");
		driver.findElement(By.id("city-state-zip")).sendKeys("Fall Church, Virginia, 22224");
		driver.findElement(By.id("phone")).click();
		driver.findElement(By.id("phone")).sendKeys("793-288-1242");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("james@gmail.com");
		driver.findElement(By.id("age")).click(); 
		driver.findElement(By.id("age")).sendKeys("33");
		driver.findElement(By.id("dependents")).click();
		driver.findElement(By.id("dependents")).sendKeys("2");
		driver.findElement(By.id("buttonScoreCard")).click();
		String actual=driver.switchTo().alert().getText();
//		System.out.println("Coming from the application: "+ actual);
		String expected="Account was created!";
		SA.assertEquals(actual, expected, "Actual and expected does not match. Please investigate............");
		
		SA.assertAll();
		driver.quit();

	}
}
