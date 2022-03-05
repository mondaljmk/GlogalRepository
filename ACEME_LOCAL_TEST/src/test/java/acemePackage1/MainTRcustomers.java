package acemePackage1;

import org.testng.annotations.Test;

import DataProviderLibrary.dataProviderExcel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class MainTRcustomers {

	WebDriver driver;

	@Test(dataProvider = "TRrite")

	public void TrainingRite(String custfname, String lname, String email, String password, String txtVerifyPassword,
			String homephone, String cellPhone) {

//		System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
//		driver.get("http://trainingrite.net/");
//		driver.findElement(By.cssSelector("div:nth-child(3) > .submitbtn")).click();

//		String custfname="James";
//		String lname="Mondol";
//		String email="james@gmail.com";
//		String password="DHIMSdte12345$$";
//		String txtVerifyPassword="DHIMSdte12345$$";
//		String homephone="6768788767";
//		String cellPhone="7655676879";

//		fname
		fname custName = new fname();
		custName.name(driver, custfname);

//		driver.findElement(By.id("ctl00_MainContent_txtFirstName")).click();
//		driver.findElement(By.id("ctl00_MainContent_txtFirstName")).sendKeys(custfname);

//		lname
		lname custlname = new lname();
		custlname.custlastName(driver, lname);
//		driver.findElement(By.xpath("//*[@id='ctl00_MainContent_txtLastName']")).sendKeys(lname);

//		email
		email custEmail = new email();
		custEmail.customerEmail(driver, email);
//		driver.findElement(By.id("ctl00_MainContent_txtEmail")).sendKeys(email);

//		password
		password custPassword = new password();
		custPassword.customerPassword(driver, password, txtVerifyPassword);
//		driver.findElement(By.id("ctl00_MainContent_txtPassword")).sendKeys(password);
//		driver.findElement(By.id("ctl00_MainContent_txtVerifyPassword")).sendKeys(txtVerifyPassword);

//		phoneNumber
		phoneNumber custNumber = new phoneNumber();
		custNumber.customerPhone(driver, homephone, cellPhone);

//		driver.findElement(By.id("ctl00_MainContent_txtHomePhone")).sendKeys(homephone);
//		driver.findElement(By.id("ctl00_MainContent_txtCellPhone")).sendKeys(cellPhone);
//		driver.findElement(By.id("ctl00_MainContent_txtInstructions")).click();
//		driver.findElement(By.id("ctl00_MainContent_txtInstructions")).sendKeys("this is a test");
//		driver.findElement(By.id("ctl00_MainContent_btnSubmit")).click();
	}

	@DataProvider(name = "TRrite")
	public Object[][] dp() {

		dataProviderExcel readExcel = new dataProviderExcel("./TestData/TRcustomerData.xlsx");
		int row = readExcel.rowCount(0);

		Object[][] data = new Object[row][7];
		for (int i = 0; i < row; i++) {

			data[i][0] = readExcel.getData(0, i, 0);
			data[i][1] = readExcel.getData(0, i, 1);
			data[i][2] = readExcel.getData(0, i, 2);
			data[i][3] = readExcel.getData(0, i, 3);
			data[i][4] = readExcel.getData(0, i, 4);
			data[i][5] = readExcel.getData(0, i, 5);
			data[i][6] = readExcel.getData(0, i, 6);

		}
		return data;

	};

	@BeforeTest
	public void beforeTest() {

		System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://trainingrite.net/");
		driver.findElement(By.cssSelector("div:nth-child(3) > .submitbtn")).click();

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
