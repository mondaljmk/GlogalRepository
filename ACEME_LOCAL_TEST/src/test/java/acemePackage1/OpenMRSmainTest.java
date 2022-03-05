package acemePackage1;

import org.testng.annotations.Test;
import Lib.ExcelConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class OpenMRSmainTest {

	WebDriver driver;

	@Test(dataProvider = "openEMRS")
	public void Registration(String username, String password,

			String givenName, String familyName, String gender, String birthdateDay, String birthdateMonth,
			String birthdateYear,

			String address1, String city, String State, String country, String postalCode, String phoneNumber,

			String relationship, String person,

			String height, String weight, String temperature, String pulse, String respiratory, String systolic,
			String diastolic, String oxygen,

			String diagnosis) throws Exception {
		

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.manage().window().maximize();

//		Login
		MRSapplication MRS = new MRSapplication();
		MRS.Login(driver, username, password);
		Thread.sleep(3000);

//		PatientInformation
		PatientInformation patientInformation = new PatientInformation();
		patientInformation.PatientDemographicInformation(driver, givenName, familyName, gender, birthdateDay,
				birthdateMonth, birthdateYear);
		Thread.sleep(3000);

//		PatientAddress
		PatientAddress MailingAddress = new PatientAddress();
		MailingAddress.address(driver, address1, city, State, country, postalCode, phoneNumber);
		Thread.sleep(3000);

//		EmergencyContact
		EmergencyContact EMC = new EmergencyContact();
		EMC.relationship(driver, relationship, person);
		Thread.sleep(3000);

//		VitalEntry
		VitalEntry objVitalEntry = new VitalEntry();
		objVitalEntry.vitalsrecord(driver, height, weight, temperature, pulse, respiratory, systolic, diastolic,
				oxygen);
		Thread.sleep(3000);

//		AddAllergy
		AddAllergy objAddAllergy = new AddAllergy();
		objAddAllergy.addAlergy(driver, familyName);
		Thread.sleep(2000);

//		EnterDiagnosis
		EnterDiagnosis objEnterDiagnosis = new EnterDiagnosis();
		objEnterDiagnosis.findDiagnosis(driver, diagnosis);
		Thread.sleep(3000);

//		AdmitToInpatient
		AdmitToInpatient Admit = new AdmitToInpatient();
		Admit.inpatient(driver, familyName);
		
		driver.quit();

		Thread.sleep(3000);

//*********************************************************************************		
	}

	@DataProvider(name = "openEMRS")
	public Object[][] testData() {

		ExcelConfig xlDDT = new ExcelConfig("./TestData/openMRSdata.xlsx");

		int row = xlDDT.getRowCount(0);

		Object[][] data = new Object[row][25];

		for (int i = 0; i < row; i++) {

			data[i][0] = xlDDT.getData(0, i, 0);
			data[i][1] = xlDDT.getData(0, i, 1);
			data[i][2] = xlDDT.getData(0, i, 2);
			data[i][3] = xlDDT.getData(0, i, 3);
			data[i][4] = xlDDT.getData(0, i, 4);
			data[i][5] = xlDDT.getData(0, i, 5);
			data[i][6] = xlDDT.getData(0, i, 6);
			data[i][7] = xlDDT.getData(0, i, 7);
			data[i][8] = xlDDT.getData(0, i, 8);
			data[i][9] = xlDDT.getData(0, i, 9);
			data[i][10] = xlDDT.getData(0, i, 10);
			data[i][11] = xlDDT.getData(0, i, 11);
			data[i][12] = xlDDT.getData(0, i, 12);
			data[i][13] = xlDDT.getData(0, i, 13);
			data[i][14] = xlDDT.getData(0, i, 14);
			data[i][15] = xlDDT.getData(0, i, 15);
			data[i][16] = xlDDT.getData(0, i, 16);
			data[i][17] = xlDDT.getData(0, i, 17);
			data[i][18] = xlDDT.getData(0, i, 18);
			data[i][19] = xlDDT.getData(0, i, 19);
			data[i][20] = xlDDT.getData(0, i, 20);
			data[i][21] = xlDDT.getData(0, i, 21);
			data[i][22] = xlDDT.getData(0, i, 22);
			data[i][23] = xlDDT.getData(0, i, 23);
			data[i][24] = xlDDT.getData(0, i, 24);

		}
		return data;

	}

}
