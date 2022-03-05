package acemePackage1;

 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 import org.testng.annotations.Test;

public class VariousDatePicker {
	
	@Test
	public void BookFlight() throws Exception {

		String month = "November 2022";
		String day = "15";

//		https://www.youtube.com/watch?v=uzvQJrplZB8
		System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.phptravels.net/flights");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='round-trip']")).click();
		driver.findElement(By.xpath("//*[@id='departure']")).click(); 

		while (true) {

			String actualMonth = driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[1]/th[2]"))
					.getText();
			if (actualMonth.equalsIgnoreCase(month)) {
				break;
			} else {
				driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[1]/th[3]/i")).click();
			}
		}
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr/td[contains(text()," + day + ")]"))
				.click();
		System.out.println("Date selected successfully");

	
		driver.quit();
	}

}
