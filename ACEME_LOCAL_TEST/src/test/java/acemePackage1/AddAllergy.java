package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddAllergy {

	public void addAlergy(WebDriver driver,String familyName) throws Exception {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@id='allergyui-editAllergies']")).click();
		driver.findElement(By.xpath("//button[@id='allergyui-addNewAllergy']")).click();
		driver.findElement(By.xpath("//input[@id='allergen-162297']")).click();
		
	    driver.findElement(By.id("reaction-142412")).click();//Diarrhea
	    driver.findElement(By.id("reaction-140238")).click();//Fever
	    driver.findElement(By.id("reaction-512")).click();//Rash
	    driver.findElement(By.id("severity-1499")).click();
	    driver.findElement(By.id("allergy-comment")).click();
	    driver.findElement(By.id("allergy-comment")).sendKeys("This is a test");
	    driver.findElement(By.id("addAllergyBtn")).click();
		driver.findElement(By.xpath("//span[contains(text(),'"+familyName+"')]")).click();
	}
	
}
