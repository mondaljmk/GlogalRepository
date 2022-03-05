package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class email {
	
	public void customerEmail(WebDriver driver, String email) {
		
		driver.findElement(By.id("ctl00_MainContent_txtEmail")).clear();

		driver.findElement(By.id("ctl00_MainContent_txtEmail")).sendKeys(email);

	}

}
