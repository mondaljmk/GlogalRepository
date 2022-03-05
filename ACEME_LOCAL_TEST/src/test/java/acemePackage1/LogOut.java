package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOut {
	
public void logoff(WebDriver driver) throws Exception {
	
	Thread.sleep(2000);
	driver.switchTo().alert().dismiss();
	driver.findElement(By.linkText("Log Out")).click();

	driver.quit();
}
} 
