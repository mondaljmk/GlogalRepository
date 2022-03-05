package acemePackage1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ScheduleAppointment {
	
	public void Appointment(WebDriver driver) throws Exception {
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

		driver.switchTo().frame("pat");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Add']")).click();

		driver.switchTo().defaultContent();
		
		WebElement ele=driver.findElement(By.xpath("//iframe[@id='modalframe']"));
		driver.switchTo().frame(ele);

		new Select(driver.findElement(By.xpath("//select[@name='form_category']"))).selectByVisibleText("New Patient");
		driver.findElement(By.id("form_save")).click();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();


		driver.switchTo().defaultContent();

	}

}
