package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TextBox {
	
	public void writeText(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.xpath("//span[contains(text(),'Text Box')]")).click();
		driver.findElement(By.id("userName")).sendKeys("Edward Gomes");
		driver.findElement(By.id("userEmail")).sendKeys("egomes@gmail.com");
		driver.findElement(By.id("currentAddress")).sendKeys("911 Court House Road");
		js.executeScript("window.scrollBy(0,2000)");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
	}

}
