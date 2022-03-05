package acemePackage1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class AdmitToInpatient {

	public void inpatient(WebDriver driver, String familyName) throws Exception {
		
		driver.findElement(By.xpath("//span[contains(text(),'"+familyName+"')]")).click();

		List<WebElement>ancList=driver.findElements(By.xpath("//li/a"));
		
		for(int i=0;i<ancList.size();i++) {
			
			String str=ancList.get(i).getText();
			
			if(str.equalsIgnoreCase("Admit to Inpatient")) {
				
				ancList.get(i).click();
				break;
				
			}
			
		}
		Thread.sleep(1000);

		new Select(driver.findElement(By.cssSelector("#w5"))).selectByVisibleText("Isolation Ward");//admitted to ward
		driver.findElement(By.cssSelector(".submitButton")).click();//Save button
		
		String actual="Inpatient at Isolation Ward";
		Thread.sleep(4000);
		
		String expected=driver.findElement(By.xpath("//*[@id='content']/div[6]/div[4]/div[2]")).getText();
		
		  SoftAssert sa=new SoftAssert();
		  sa.assertEquals(actual,expected,"Inpatient at Isolation Ward does not match, please investigate ");
		  
		  System.out.println("Completed even though test fails");
		  sa.assertAll();

	}
}
