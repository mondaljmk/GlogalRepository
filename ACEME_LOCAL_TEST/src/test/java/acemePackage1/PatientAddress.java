package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientAddress {

	public void address(WebDriver driver, String address1,String city, String State,String country, String postalCode, String phoneNumber ) {
		
		driver.findElement(By.id("address1")).click();
		driver.findElement(By.id("address1")).sendKeys(address1);
		driver.findElement(By.id("cityVillage")).click();
		driver.findElement(By.id("cityVillage")).click();
		driver.findElement(By.id("cityVillage")).sendKeys(city);
		driver.findElement(By.id("stateProvince")).click();
		driver.findElement(By.id("stateProvince")).sendKeys(State);
		driver.findElement(By.id("country")).click();
		driver.findElement(By.id("country")).sendKeys(country);
		driver.findElement(By.id("postalCode")).click();
		driver.findElement(By.id("postalCode")).sendKeys(postalCode);
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
		driver.findElement(By.name("phoneNumber")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
	}
	
}
