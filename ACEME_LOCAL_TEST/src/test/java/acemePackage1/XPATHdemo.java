package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class XPATHdemo {
	

	private String email="mondal.jmk@gmail.com";
	private String PSW="DHIMSdte12345$$";

	
	@Test
	public void demoXPATH() throws Exception {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_98.exe");
		driver = new ChromeDriver();
		
		Login oLogin=new Login();
		oLogin.login(driver,email,PSW );
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()=' User options']/ /following::*[text()=' Work Items']")).click();
		Thread.sleep(2000);

		driver.navigate().back();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()=' Work Items']//following::*[text()=' Accounts']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[text()=' User options']//following::*[text()=' Work Items']")).click();
		Thread.sleep(2000);

		System.out.println("Successfully executed");
	
	}
	
	@Test
	public void amazonAccount() {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "C:\\AllDrivers\\geckodriver-v0.25.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.com/gp/css/homepage.html?ref_=nav_AccountFlyout_ya");
		
		driver.findElement(By.xpath("//h2[contains(text(),'Your Payments')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Conditions of Use')]")).click();
		
		
	}

}
