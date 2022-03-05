package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest {

	@Test(dataProvider="TRCustomer")

	public void newMemberRegistration(String fname, String lname, String email, String homephone,String cellPhone) {

		System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://trainingrite.net/");
		driver.findElement(By.cssSelector("div:nth-child(3) > .submitbtn")).click();
		driver.findElement(By.id("ctl00_MainContent_txtFirstName")).click();
		driver.findElement(By.id("ctl00_MainContent_txtFirstName")).sendKeys(fname);
		driver.findElement(By.id("ctl00_MainContent_txtLastName")).sendKeys(lname);
		driver.findElement(By.id("ctl00_MainContent_txtEmail")).sendKeys(email);
		driver.findElement(By.id("ctl00_MainContent_txtPassword")).sendKeys("DHIMSdte12345$$");
		driver.findElement(By.id("ctl00_MainContent_txtVerifyPassword")).sendKeys("DHIMSdte12345$$");
		driver.findElement(By.id("ctl00_MainContent_txtHomePhone")).sendKeys(homephone);
		driver.findElement(By.id("ctl00_MainContent_txtCellPhone")).sendKeys(cellPhone);
		driver.findElement(By.id("ctl00_MainContent_txtInstructions")).click();
		driver.findElement(By.id("ctl00_MainContent_txtInstructions")).sendKeys("this is a test");
		driver.findElement(By.id("ctl00_MainContent_btnSubmit")).click();
		driver.close();
	}

	@DataProvider(name = "TRCustomer")
	public Object[][] testData() {

		Object [][] data = new Object[4][5];

		data[0][0] = "James";
		data[0][1] = "Mondal";
		data[0][2] = "james@gmail.com";
		data[0][3] = "7039228172";
		data[0][4] = "999887777";

		data[1][0] = "Henry";
		data[1][1] = "Baroi";
		data[1][2] = "Henry@gmail.com";
		data[1][3] = "7039228174"; 
		data[1][4] = "999887777";

		data[2][0] = "Simson";
		data[2][1] = "Sarker";
		data[2][2] = "Simson@gmail.com";
		data[2][3] = "7039228176";
		data[2][4] = "999887777";

		data[3][0] = "Peter";
		data[3][1] = "Sarker";
		data[3][2] = "Peter@gmail.com";
		data[3][3] = "7039228177";
		data[3][4] = "999887777";

		return data;

	}

}
