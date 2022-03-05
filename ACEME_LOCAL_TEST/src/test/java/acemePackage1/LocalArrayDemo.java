package acemePackage1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LocalArrayDemo {
	
	@Test(dataProvider="AcemeData")
	
	public void AcemeLogin(String email, String password) {
		System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://acme-test.uipath.com/login");

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/form/button")).click();
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a")).click();
		driver.quit();

	}

	@DataProvider(name = "AcemeData")
	public Object[][] loginCredentials() {

		Object[][] data = new Object[3][2];

		data[0][0] = "mondal.jmk@gmail.com";
		data[0][1] = "DHIMSdte12345$$";

		data[1][0] = "mondal.jmk@gmail.com";
		data[1][1] = "DHIMSdte12345$$";

		data[2][0] = "mondal.jmk@gmail.com";
		data[2][1] = "DHIMSdte12345$$";

		return data;
	}

}
