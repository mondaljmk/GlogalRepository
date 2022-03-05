package acemePackage1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OpenERMVitalEntry {

	public void enterVitals(WebDriver driver) throws Exception {
		
		Thread.sleep(4000);
		driver.findElement(By.cssSelector(".fa-plus")).click();
		Thread.sleep(1000);

		driver.switchTo().frame("enc");

		driver.findElement(By.id("pc_catid")).click();
		{
			WebElement dropdown = driver.findElement(By.id("pc_catid"));
			dropdown.findElement(By.xpath("//option[. = 'Office Visit']")).click();
		}
		driver.findElement(By.id("reason")).click();

		driver.findElement(By.id("reason")).sendKeys("Fever for three days");
		driver.findElement(By.cssSelector(".btn-save")).click();

//	    driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id='menuClinical']")).click();
		driver.findElement(By.cssSelector(".dropdown-item:nth-child(10)")).click();

		driver.switchTo().defaultContent();

		driver.switchTo().frame("enc");
		driver.switchTo().frame("enctabs-1001");

		driver.findElement(By.id("weight_input")).click();
		driver.findElement(By.id("weight_input")).sendKeys("188");
		driver.findElement(By.id("weight_input_metric")).click();
		driver.findElement(By.id("height_input")).click();
		driver.findElement(By.id("height_input")).sendKeys("66");
		driver.findElement(By.id("height_input_metric")).click();
		driver.findElement(By.id("bps_input")).click();
		driver.findElement(By.id("bps_input")).sendKeys("122");
		driver.findElement(By.id("bpd_input")).click();
		driver.findElement(By.id("bpd_input")).sendKeys("99");
		driver.findElement(By.id("pulse_input")).click();
		driver.findElement(By.id("pulse_input")).sendKeys("39");
		driver.findElement(By.id("respiration_input")).click();
		driver.findElement(By.id("pulse_input")).click();
		driver.findElement(By.id("pulse_input")).click();
		{
			WebElement element = driver.findElement(By.id("pulse_input"));
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
		}
		driver.findElement(By.id("pulse_input")).sendKeys("99");
		driver.findElement(By.id("respiration_input")).click();
		driver.findElement(By.id("respiration_input")).sendKeys("39");
		driver.findElement(By.id("temperature_input")).click();
		driver.findElement(By.id("temperature_input")).sendKeys("99");
		driver.findElement(By.id("temperature_input_metric")).click();
		driver.findElement(By.id("temp_method")).click();
		{
			new Select(driver.findElement(By.xpath("//*[@id='temp_method']"))).selectByVisibleText("Oral");// Temp
																											// Location
		}
		driver.findElement(By.name("Submit")).click();
		driver.switchTo().defaultContent();

		driver.switchTo().frame("enc");
		driver.switchTo().frame(0);
		List<WebElement> td = driver.findElements(By.xpath("//*[@id=\"divid_2\"]/table/tbody/tr/td"));

		for (int ii = 0; ii < td.size(); ii++) {

			String getdata = td.get(ii).getText();

			switch (getdata) {

			case "Blood Pressure: 122/99":
				break;
			case "Weight: 188.00 lb (85.28 kg)":
				break;
			case "Height: 66.00 in (167.6 cm)":
				break;
			case "Temperature: 99.00 F (37.23 C)":
				break;
			case "Temp Method: Oral":
				break;
			case "Pulse: 99 per min":
				break;
			case "Respiration: 39 per min":
				break;
			case "BMI: 30 kg/m^2":
				break;
			case "BMI Status: See Growth-Chart":
				break;
			default:
				System.out.println("Does not match ============"+getdata);

				break;
			}

		}
		driver.switchTo().defaultContent();
	}
}
