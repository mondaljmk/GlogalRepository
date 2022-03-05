package acemePackage1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PersonalInformation {

	public void demographic(WebDriver driver, String ssn, String fName, String lName, String patientEmail)
			throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//button[text()=' Health Care']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"dashmenu\"]/div/ul//li"));
		for (int i = 0; i < list.size(); i++) {
			String webList = list.get(i).getText();
			if (webList.equalsIgnoreCase("National Insurance Planning")) {
				list.get(i).click();
				break;

			}
		}

		driver.findElement(By.id("social_number")).click();
		driver.findElement(By.id("social_number")).sendKeys(ssn);
		driver.findElement(By.id("firstname")).click();
		driver.findElement(By.id("firstname")).sendKeys(fName);
		driver.findElement(By.id("lastname")).click();
		driver.findElement(By.id("lastname")).sendKeys(lName);
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys(patientEmail);
		driver.findElement(By.id("gender")).click();

		new Select(driver.findElement(By.xpath("//select[@id='gender']"))).selectByVisibleText("Female");
	}
}
