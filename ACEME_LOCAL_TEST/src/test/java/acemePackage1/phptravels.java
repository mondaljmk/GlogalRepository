package acemePackage1;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Lib.ExcelConfig;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

public class phptravels {

	@Test  (dataProvider = "PHPtravels")
	public void FlightBooking(String flyFrom,String flyTO,String flyMM,String flyDD,String firstname,String lastname,String email,String phone,String address,String country,String nationality2,String travlerFname,String travlerLname,String nationality3,String birthMM,String birthDD,String birthYY) throws Exception {

//		String flyFrom = "DCA - Ronald Reagan Washington Natl - Washington";
//		String flyTO = "DFW - Dallas Fort Worth Intl - Dallas-Fort Worth";
//		String flyMM = "December 2021";
//		String flyDD = "24";
//
//		// YourPersonalInformation
//		String firstname = "Person";
//		String lastname = "Gentleman";
//		String email = "person@gmail.com";
//		String phone = "8091662712";
//		String address = "111 Lacy Blvd";
//		String country = "Albania";
//		String nationality2 = "Albania";
//
//		// TravellersInformation
//
//		String travlerFname = "Person";
//		String travlerLname = "Gentleman";
//		String nationality3 = "Bangladesh";
//		String birthMM = "03 March";
//		String birthDD = "10";
//		String birthYY = "1999";

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_98.exe");		WebDriver driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;

//		FlightSearch
		driver.findElement(By.xpath("//a[contains(text(),'flights')]")).click();
		driver.findElement(By.xpath("//*[@id='autocomplete']")).sendKeys(flyFrom);
		driver.findElement(By.xpath("//*[@id='autocomplete']")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//*[@id='autocomplete2']")).sendKeys(flyTO);
		driver.findElement(By.xpath("//*[@id='autocomplete2']")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//*[@id='departure']")).click();

		while (true) {
			String actualMonth = driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[1]/th[2]"))
					.getText();
			if (actualMonth.equals(flyMM)) {
				break;

			} else {
				driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[1]/th[3]/i")).click();
			}
		}

		List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr/td"));

		for (int i = 0; i < elements.size(); i++) {

			String crntElement = elements.get(i).getText();
			if (crntElement.equals(flyDD)) {
				elements.get(i).click();
				break;

			}

		}

		driver.findElement(By.xpath("//*[@id=\"flights-search\"]/span[1]")).click();// search
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,200)");

		List<WebElement> bookNow = driver
				.findElements(By.xpath("//*[contains(@id,'MixItUp')]/ul/li/div//button/span[text()='Book Now']"));

		for (int i = 0; i < bookNow.size(); i++) {

			String bknow = bookNow.get(i).getText();

			if (bknow.equalsIgnoreCase("Book Now")) {
				bookNow.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);

//	    YourPersonalInformation

		driver.findElement(By.name("firstname")).sendKeys(firstname);
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("address")).sendKeys(address);

		js.executeScript("window.scrollBy(0,200)");

		Thread.sleep(1000);

		driver.findElement(By.xpath(
				"/html/body/div[2]/form/section/div/div/div[1]/div[1]/div[2]/div/div/div[6]/div/div/div/span/span[1]/span"))
				.click();

		WebElement ele = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));

		ele.sendKeys(country);// country
		Thread.sleep(2000);

		ele.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath(
				"/html/body/div[2]/form/section/div/div/div[1]/div[1]/div[2]/div/div/div[7]/div/div/div/span/span[1]/span"))
				.click();

		WebElement ele2 = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));

		ele2.sendKeys(nationality2);// nationality
		Thread.sleep(2000);

		ele2.sendKeys(Keys.ENTER);

//		TravellersInformation

		driver.findElement(By.name("firstname_1")).sendKeys(travlerFname);
		driver.findElement(By.name("lastname_1")).sendKeys(travlerLname);
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);

		driver.findElement(By.name("nationality_1")).click();
		new Select(driver.findElement(By.name("nationality_1"))).selectByVisibleText(nationality3);// nationality
		Thread.sleep(1000);
		driver.findElement(By.name("dob_month_1")).click();
		Thread.sleep(2000);

		{
			new Select(driver.findElement(By.name("dob_month_1"))).selectByVisibleText(birthMM);// birth month
		}

		driver.findElement(By.name("dob_day_1")).sendKeys(birthDD);// day
		driver.findElement(By.name("dob_year_1")).sendKeys(birthYY);// year
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);

//		PaymentMethod
		driver.findElement(By.id("gateway_bank-transfer")).click();
		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0,1000)");

		driver.findElement(By.xpath("//*[@id=\"booking\"]//preceding::label[contains(text(),'By continuing')]"))
				.click();

		driver.findElement(By.id("booking")).click();// confirm booking

		driver.findElement(By.id("form")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Yes")).click();

		String actual = driver
				.findElement(By.xpath("/html/body/section/div/div/div/div/div[3]/div[2]/div/div[1]/div/h3[1]"))
				.getText();
		String expected = "Thanks "+firstname +" "+lastname +"";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual, expected, "Please investigate for the failure");
		
		driver.quit();

		sa.assertAll();


	}

  @DataProvider(name="PHPtravels")
	public Object[][] testData() {

		ExcelConfig xlddt = new ExcelConfig("./TestData/phpTestData.xlsx");

		int row = xlddt.getRowCount(0);

		Object[][] data = new Object[row][17];

		for (int i = 0; i < row; i++) {

			data[i][0] = xlddt.getData(0, i, 0);
			data[i][1] = xlddt.getData(0, i, 1);
			data[i][2] = xlddt.getData(0, i, 2);
			data[i][3] = xlddt.getData(0, i, 3);
			data[i][4] = xlddt.getData(0, i, 4);
			data[i][5] = xlddt.getData(0, i, 5);
			data[i][6] = xlddt.getData(0, i, 6);
			data[i][7] = xlddt.getData(0, i, 7);
			data[i][8] = xlddt.getData(0, i, 8);
			data[i][9] = xlddt.getData(0, i, 9);
			data[i][10] = xlddt.getData(0, i, 10);
			data[i][11] = xlddt.getData(0, i, 11);
			data[i][12] = xlddt.getData(0, i, 12);
			data[i][13] = xlddt.getData(0, i, 13);
			data[i][14] = xlddt.getData(0, i, 14);
			data[i][15] = xlddt.getData(0, i, 15);
			data[i][16] = xlddt.getData(0, i, 16);
			
		}
		return data;
	}
}
