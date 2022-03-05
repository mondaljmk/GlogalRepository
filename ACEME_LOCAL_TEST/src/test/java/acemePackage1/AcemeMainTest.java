package acemePackage1;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AcemeMainTest {

	String email = "mondal.jmk@gmail.com";
	String PSW = "DHIMSdte12345$$"; 

	String ssn = "999887777";
	String fName = "xxPrashanta";
	String lName = "Baroe";
	String patientEmail = "baroi@gmail.com"; 

	String icdcode = "A00-A09";
	String icdDisc = "Intestinal infectious diseases";
	String cptCode = "70010-76499";
	String cptDisc = "Diagnostic Radiology (Diagnostic Imaging) Procedure and Services";
	String medName = "Omeprazole 40 mg";
//*******************************************************************
//	String email ="mondal.jmk@gmail.com";
	String password = "DHIMSdte12345$$";
	String studentemail = "student@gmail.com";
	String firstname = "Thomas";
	String lastname = "Mondal";
	String parentemail = "parent@gmail.com";

	String tuition = "5000";
	String mathematics = "99";
	String physics = "99";
	String biology = "98";
	String chemistry = "99";
	String geography = "78";
	String history = "88";
	String english = "88";
	String computerScience = "89";

	@Test 

	public void HCDnationalInsurancePlanning() throws Exception {

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_98.exe");
		driver = new ChromeDriver();

		Login oLogin = new Login();
		oLogin.login(driver, email, PSW);

		PersonalInformation oPersonalInformation = new PersonalInformation();
		oPersonalInformation.demographic(driver, ssn, fName, lName, patientEmail);
		Thread.sleep(2000);
		
		HealthCareDelivery oHealthCareDelivery = new HealthCareDelivery();

		oHealthCareDelivery.HCD(driver, icdcode, icdDisc, cptCode, cptDisc, medName);

		LogOut oLogOut = new LogOut();
		oLogOut.logoff(driver);
	}
	
	@Ignore
	
	@Test

	public void studentScoreCard() throws Exception {

		Login obj = new Login();

		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\AllDrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		obj.login(driver, email, PSW);

		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,-1000)");

		SoftAssert sa = new SoftAssert();

		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,1000)");

		driver.findElement(By.cssSelector(".dropdown:nth-child(9) > .btn")).click();
		driver.findElement(By.linkText("Score Card")).click();
		driver.findElement(By.xpath("//button[@id='buttonScoreCard']")).click();

		Thread.sleep(2000);

		Alert ha = driver.switchTo().alert();
		String actualMsg = ha.getText();

		String expectedMsg = "Some problems were present, please retry.";

		sa.assertEquals(actualMsg, expectedMsg, "Assert text is not displaying correctly");
		ha.accept();

		Thread.sleep(4000);

		js.executeScript("window.scrollBy(0,-1000)");

		StudentPersonalInformation oDemography = new StudentPersonalInformation();

		oDemography.studentDmo(driver);

		ScoreCalculation oScoreCalculation = new ScoreCalculation();

		oScoreCalculation.score(driver, tuition, mathematics, physics, biology, chemistry, geography, history, english,
				computerScience);
		driver.quit();
	}

}
