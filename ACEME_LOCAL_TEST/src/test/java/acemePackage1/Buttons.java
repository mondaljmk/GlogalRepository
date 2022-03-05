package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class Buttons {
	
	public void verifyButton(WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//span[contains(text(),'Buttons')]")).click();

		Actions actions = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.id("doubleClickBtn"));
		actions.doubleClick(elementLocator).perform();

		Actions actions2 = new Actions(driver);
		WebElement rightclick = driver.findElement(By.id("rightClickBtn"));
		actions2.contextClick(rightclick).perform();

		js.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.xpath("//*[text()='Click Me']")).click();
		js.executeScript("window.scrollBy(0,200)");
		
	}

}
