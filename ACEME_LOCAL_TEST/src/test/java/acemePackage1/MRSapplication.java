package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MRSapplication {
	
	public void Login(WebDriver driver,String username,String password) {
		
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Registration Desk")).click();
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.linkText("Register a patient")).click();
	}

}
