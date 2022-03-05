package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class lname {

	public void custlastName(WebDriver driver, String lname) {
		
		driver.findElement(By.xpath("//*[@id='ctl00_MainContent_txtLastName']")).clear();
		

		driver.findElement(By.xpath("//*[@id='ctl00_MainContent_txtLastName']")).sendKeys(lname);

	}

}
