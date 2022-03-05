package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class phoneNumber {
	
	public void customerPhone(WebDriver driver,String homephone,String cellPhone) {
		
		driver.findElement(By.id("ctl00_MainContent_txtHomePhone")).clear();

		driver.findElement(By.id("ctl00_MainContent_txtHomePhone")).sendKeys(homephone);
		driver.findElement(By.id("ctl00_MainContent_txtCellPhone")).clear();

		driver.findElement(By.id("ctl00_MainContent_txtCellPhone")).sendKeys(cellPhone);
		driver.findElement(By.id("ctl00_MainContent_txtInstructions")).clear();
		driver.findElement(By.id("ctl00_MainContent_txtInstructions")).sendKeys("this is a test");
		driver.findElement(By.id("ctl00_MainContent_btnSubmit")).click();
		
	}

}
