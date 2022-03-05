package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Login {
	

	public void login(WebDriver driver, String email, String PSW) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("https://acme-test.uipath.com/home");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).click(); 
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys(PSW);
		driver.findElement(By.cssSelector(".btn-primary")).click();

//		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
	}


}
