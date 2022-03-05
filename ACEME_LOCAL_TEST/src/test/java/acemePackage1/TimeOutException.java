package acemePackage1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TimeOutException {
  @Test
  public void TimeOutExceptionDemo() {
	  
	  
	  System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_98.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.trainingrite.net/OnLine/home.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  }
}
