package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EmergencyContact {
	
	public void relationship(WebDriver driver, String relationship, String person) {
		
		driver.findElement(By.id("relationship_type")).click();
		{
		new Select(driver.findElement(By.xpath("//*[@id='relationship_type']"))).selectByVisibleText(relationship);
		}
		System.out.println("=============Run upto here successfully===============");

		driver.findElement(By.cssSelector(".person-typeahead")).click();
		driver.findElement(By.cssSelector(".person-typeahead")).sendKeys(person);
		driver.findElement(By.id("next-button")).click();
		driver.findElement(By.id("submit")).click();
	}

}
