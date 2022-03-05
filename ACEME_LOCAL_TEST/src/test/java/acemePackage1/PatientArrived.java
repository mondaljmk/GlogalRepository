package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PatientArrived {
	
	public void arrived(WebDriver driver) throws Exception {
		
		FunctionLibrary.HandleiFrame(driver, "//iframe[@name='pat']");
		
		System.out.println("Message for the user==============");
		
		Thread.sleep(4000);
				
//		driver.findElement(By.xpath("//button[contains(text(),'×')]")).click();
//		driver.switchTo().defaultContent();
//
		driver.findElement(By.xpath("//*[@id='appointments_ps_expand']/div/a/b")).click();//click on the existing appointment date
		
		driver.switchTo().defaultContent();
		
		FunctionLibrary.HandleiFrame(driver, "//iframe[@id='modalframe']");
		
		new Select(driver.findElement(By.xpath("//select[@name='form_category']"))).selectByVisibleText("Office Visit");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		new Select(driver.findElement(By.xpath("//*[@id='form_apptstatus']"))).selectByVisibleText("@ Arrived");
		
		driver.findElement(By.id("form_save")).click();
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		
//		driver.switchTo().defaultContent();
//*************************************************************
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		
		driver.switchTo().defaultContent();
	}

}
