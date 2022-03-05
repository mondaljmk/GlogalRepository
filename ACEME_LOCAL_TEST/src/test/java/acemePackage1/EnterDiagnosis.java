package acemePackage1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class EnterDiagnosis {

	
	public void findDiagnosis(WebDriver driver,String diagnosis) throws Exception {
		
		driver.findElement(By.linkText("Visit Note")).click();
		driver.findElement(By.xpath("//*[@id='diagnosis-search']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id='diagnosis-search']")).sendKeys("Hemorr");
		Thread.sleep(2000);

		List<WebElement>ele=driver.findElements(By.xpath("//ul//li"));
		

		System.out.println("Number of Items===="+ele.size());
		for(int i=0;i<ele.size();i++) {
			
			String text=ele.get(i).getText();

			System.out.println("Each of Items===="+text);

			if(text.contains(diagnosis)) {
				
				Thread.sleep(1000);
				
				ele.get(i).click();
				
				break;
				
			}	
			
		}
		
		driver.findElement(By.cssSelector(".submitButton")).click();
		
		Thread.sleep(2000);
		
		String ActualDiagnosis=""+diagnosis+"";

		
		String strdiagnosis=driver.findElement(By.xpath("//*[@id='coreapps-diagnosesList']/div[2]/ul/li")).getText();
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(ActualDiagnosis, strdiagnosis,""+ActualDiagnosis+" does not match with the expected diagnosis");

		sa.assertAll();
}
	
}
