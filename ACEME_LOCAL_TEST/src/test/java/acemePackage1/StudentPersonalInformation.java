package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StudentPersonalInformation {
	
 public void studentDmo(WebDriver driver) {
		
		driver.findElement(By.id("studentemail")).click();
		driver.findElement(By.id("studentemail")).sendKeys("student@gmail.com");
		driver.findElement(By.id("firstname")).click();
		driver.findElement(By.id("firstname")).sendKeys("firstname");
		driver.findElement(By.id("lastname")).click();
		driver.findElement(By.id("lastname")).sendKeys("lastname");
		driver.findElement(By.id("parentemail")).click();
		driver.findElement(By.id("parentemail")).sendKeys("parent@yahoo.com");
 }
}
