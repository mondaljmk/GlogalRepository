package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class fname {
	
	public void name(WebDriver driver, String custfname) {
		
		driver.findElement(By.id("ctl00_MainContent_txtFirstName")).clear();
		driver.findElement(By.id("ctl00_MainContent_txtFirstName")).sendKeys(custfname);
		
	}

}
