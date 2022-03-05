package acemePackage1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class OpenEMRmainTest {

	@Test // (dataProvider = "dp")][po ire
	public void PatientRegistration() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_98.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.openemr.io/a/openemr/");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).click();
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		driver.findElement(By.cssSelector(".btn-login")).click();

//	    PatientRegistration
		PatientRegistration patientRegistration = new PatientRegistration();

		patientRegistration.newPatient(driver);

//		ScheduleAppointment
		ScheduleAppointment scheduleAppointment=new ScheduleAppointment();
		scheduleAppointment.Appointment(driver);
		
//		PatientArrived
		PatientArrived patientArrived=new PatientArrived();
		patientArrived.arrived(driver);
		
//		OpenERMVitalEntry
		OpenERMVitalEntry openERMVitalEntry=new OpenERMVitalEntry();
		openERMVitalEntry.enterVitals(driver);

	}

//  @DataProvider
//  public Object[][] dp() {
//    return new Object[][] {
//      new Object[] { 1, "a" },
//      new Object[] { 2, "b" },
//    };
//  }
}
