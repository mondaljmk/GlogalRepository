package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {
	public void verifyBrokenLink(WebDriver driver) {
		
		SoftAssert sa=new SoftAssert();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,500)");

		driver.findElement(By.xpath("//span[contains(text(),'Broken Links - Images')]")).click();
		js.executeScript("window.scrollBy(0,500)");

		driver.findElement(By.xpath("//a[contains(text(),'Click Here for Broken Link')]")).click();
		
		String ExpectedLinkBroken = "This page returned a 500 status code.";
		
		String ActualMessage = driver.findElement(By.xpath("//*[@id='content']/div/p")).getText();

		sa.assertEquals(ActualMessage, ExpectedLinkBroken,"Why it is failing");
		
		driver.navigate().back();
	}

}
