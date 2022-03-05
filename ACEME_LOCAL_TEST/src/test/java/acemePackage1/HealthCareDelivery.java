package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HealthCareDelivery {

	public void HCD(WebDriver driver,String icdcode ,String icdDisc,String  cptCode,String  cptDisc,String medName ) {
		
		driver.findElement(By.id("care_type")).click();

		new Select(driver.findElement(By.id("care_type"))).selectByVisibleText("Emergency");

		driver.findElement(By.id("diagnosis_code")).click();
		driver.findElement(By.id("diagnosis_code")).sendKeys(icdcode);
		driver.findElement(By.id("diagnosis_description")).click();
		driver.findElement(By.id("diagnosis_description")).sendKeys(icdDisc);
		driver.findElement(By.id("procedure_code")).click();
		driver.findElement(By.id("procedure_code")).sendKeys(cptCode); 
		driver.findElement(By.id("procedure_description")).click();
		driver.findElement(By.id("procedure_description")).sendKeys(cptDisc); 
		driver.findElement(By.id("medication")).click();
		driver.findElement(By.id("medication")).sendKeys(medName);
		driver.findElement(By.id("buttonScoreCard")).click();
	}
}
