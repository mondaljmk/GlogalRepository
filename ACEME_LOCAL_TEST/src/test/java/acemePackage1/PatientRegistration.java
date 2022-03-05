package acemePackage1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PatientRegistration {
	
	public void newPatient(WebDriver driver) throws Exception {
		
		driver.findElement(By.xpath("//div[contains(text(),'Patient/Client')]")).click();

		List<WebElement> ele = driver.findElements(By.xpath("//ul[@name='menuEntries']//li"));

		for (int i = 0; i < ele.size(); i++) {

			String search = ele.get(i).getText();

			if (search.equalsIgnoreCase("New/Search")) {

				ele.get(i).click();

				break;

			}

		}

//		driver.switchTo().frame(3);
		FunctionLibrary.HandleiFrame(driver, "//iframe[@name='pat']");
		
		driver.findElement(By.id("form_fname")).click();
		driver.findElement(By.id("form_fname")).sendKeys("Tree");
		driver.findElement(By.id("form_lname")).click();
		driver.findElement(By.id("form_lname")).sendKeys("Mango");
		driver.findElement(By.id("form_DOB")).click();

//		driver.findElement(By.xpath("//*[@id=\"form_DOB\"]")).click();//DOB

		String day = "20";
		String yr = "2018";
		Thread.sleep(1000);

		while (true) {

			String str = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/div[2]/span")).getText();

			if (str.equalsIgnoreCase(yr)) {

				break;

			} else {
				driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/button[1]")).click();
			}

			// click on the left right next to the calendar
			driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/span[1]")).click();

		}

		List<WebElement> findDate = driver.findElements(By.xpath("//table/tbody/tr/td"));

		for (int i = 0; i < findDate.size(); i++) {

			String dateText = findDate.get(i).getText();

			if (dateText.equalsIgnoreCase(day)) {
				findDate.get(i).click();
				break;

			}

		}

		new Select(driver.findElement(By.xpath("//*[@id='form_sex']"))).selectByVisibleText("Male");
		driver.findElement(By.xpath("//*[@id=\"create\"]")).click();

		driver.switchTo().defaultContent();
		driver.switchTo().frame(4);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".btn")).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("pat");

		String actMedRecord = "Medical Record Dashboard - Tree Mango";
		String expMedRecord = driver.findElement(By.xpath("//*[@id='container_div']/div[1]/div/h2")).getText();

		Assert.assertEquals(actMedRecord, expMedRecord, "Please investigate if unmatch with:" + expMedRecord);
		driver.switchTo().defaultContent();
	}

}
