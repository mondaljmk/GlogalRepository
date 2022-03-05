package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class password {

	public void customerPassword(WebDriver driver, String password, String txtVerifyPassword) {
		
		driver.findElement(By.id("ctl00_MainContent_txtPassword")).clear();

		driver.findElement(By.id("ctl00_MainContent_txtPassword")).sendKeys(password);
		
		driver.findElement(By.id("ctl00_MainContent_txtVerifyPassword")).clear();

		driver.findElement(By.id("ctl00_MainContent_txtVerifyPassword")).sendKeys(txtVerifyPassword);

	}

}
