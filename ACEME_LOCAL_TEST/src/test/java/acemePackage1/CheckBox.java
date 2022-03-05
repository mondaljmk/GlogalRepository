package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CheckBox {

	public void checkCheckBox(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.xpath("//span[contains(text(),'Check Box')]")).click();
		driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label/span[1]")).click();
		js.executeScript("window.scrollBy(0,500)");
	}
}
