package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VitalEntry {
	
	public void vitalsrecord(WebDriver driver,String height ,String weight,String temperature,String pulse,String respiratory,String systolic,String diastolic,String oxygen) throws Exception {
		
		Thread.sleep(2000);
		
	    driver.findElement(By.xpath("//div[contains(text(),'Start Visit')]")).click();
	    driver.findElement(By.xpath("//button[@id='start-visit-with-visittype-confirm']")).click();
	    
	    Thread.sleep(10000);

	    driver.findElement(By.id("referenceapplication.realTime.vitals")).click();  
	    driver.findElement(By.id("w8")).sendKeys(height);//height
	    driver.findElement(By.cssSelector(".fa-chevron-right")).click();
	    driver.findElement(By.id("w10")).click();
	    driver.findElement(By.id("w10")).sendKeys(weight);//weight
	    driver.findElement(By.id("next-button")).click();
	    driver.findElement(By.id("next-button")).click();
	    driver.findElement(By.id("w12")).click();
	    driver.findElement(By.id("vitals")).click();
	    driver.findElement(By.id("w12")).sendKeys(temperature);//temperature (c)
	    driver.findElement(By.cssSelector(".fa-chevron-right")).click();//right arrow
	    driver.findElement(By.id("w14")).click();
	    driver.findElement(By.id("w14")).sendKeys(pulse);//pulse
	    driver.findElement(By.cssSelector(".fa-chevron-right")).click();
	    driver.findElement(By.id("w16")).click();
	    driver.findElement(By.id("w16")).sendKeys(respiratory);//respiratory rate
	    driver.findElement(By.id("next-button")).click();
	    driver.findElement(By.id("w18")).click();
	    driver.findElement(By.id("w18")).sendKeys(systolic);//systolic
	    driver.findElement(By.id("w20")).click();
	    driver.findElement(By.id("w20")).sendKeys(diastolic);//diastolic
	    driver.findElement(By.cssSelector(".fa-chevron-right")).click();
	    driver.findElement(By.id("w22")).click();
	    driver.findElement(By.id("w22")).sendKeys(oxygen);//oxygen 
	    driver.findElement(By.id("next-button")).click();
	    driver.findElement(By.xpath("//*[@id='confirmationQuestion']/p[1]/button")).click();
	   Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"breadcrumbs\"]/li[2]/a")).click();
	  
	}

}
