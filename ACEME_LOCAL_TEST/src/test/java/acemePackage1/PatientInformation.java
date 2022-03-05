package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientInformation {

	public void PatientDemographicInformation(WebDriver driver, String givenName, String familyName,String gender, String birthdateDay,String birthdateMonth,String birthdateYear  ) throws Exception {
		
		Thread.sleep(1000);

		driver.findElement(By.name("givenName")).click();
		driver.findElement(By.name("givenName")).sendKeys(givenName);
		driver.findElement(By.name("familyName")).click();
		driver.findElement(By.name("familyName")).sendKeys(familyName);
		driver.findElement(By.cssSelector(".fa-chevron-right")).click();

		driver.findElement(By.cssSelector("#gender-field > option:nth-child(1)")).click();
		{
			WebElement dropdown = driver.findElement(By.id("gender-field"));
			dropdown.findElement(By.xpath("//option[. = '"+gender+"']")).click();
		}
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
		driver.findElement(By.id("birthdateDay-field")).click();
		driver.findElement(By.id("birthdateDay-field")).sendKeys(birthdateDay);
		{
			WebElement dropdown = driver.findElement(By.id("birthdateMonth-field"));
			dropdown.findElement(By.xpath("//option[. = '"+birthdateMonth+"']")).click();
		}
		driver.findElement(By.id("birthdateYear-field")).click();
		driver.findElement(By.id("birthdateYear-field")).sendKeys(birthdateYear);
		driver.findElement(By.xpath("//button[@id='next-button']")).click();
		
	}
}
