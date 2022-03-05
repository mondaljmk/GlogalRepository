package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class RadioButton {
	public void checkRadioButton(WebDriver driver) throws Exception {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		SoftAssert sa=new SoftAssert();

		driver.findElement(By.xpath("//span[contains(text(),'Radio Button')]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//label[contains(text(),'Yes')]")).click();
		sa = new SoftAssert();
		String expected = "You have selected Yes";
		String str = driver.findElement(By.xpath("//*[@id=\"app\"]//p")).getText();
		sa.assertEquals(str, expected, "raise the defect if fails");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,200)");
		
	}

}
