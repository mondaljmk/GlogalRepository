package acemePackage1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import DataProviderLibrary.dataProviderExcel;

public class ORANGEhrmMain {

	@Test(dataProvider="OrangeHRMTD")
	public void orangeHRM(String userName, String password, String firstName, String lastName, String nationality,
			String maritalStatus, String contact_street1, String contact_city, String contact_province,
			String contact_emp_zipcode, String contact_country, String contact_emp_hm_telephone,
			String emgcontacts_name, String emgcontacts_relationship,
			String emgcontacts_homePhone, String dependent_name, String dependent_relationship, String passportNumber)
			throws Exception {

		SoftAssert sa = new SoftAssert();

//		String userName="admin";
//		String password="admin123";	
//		String firstName="William";
//		String lastName="Gomes";
//		String nationality="Bangladeshi";
//		String maritalStatus="Married";
//		String contact_street1 ="1250 ANDERSON AVENUE";
//		String  contact_city="VIENNA";
//		String  contact_province="Virginia";
//		String  contact_emp_zipcode="22182";
//		String 	contact_country ="Bangladesh";
//		String  contact_emp_hm_telephone="70394412421";
		String contact_emp_work_email="ed"+FunctionLibrary.dbldigit()+"@gmail.com";
//			
//		String emgcontacts_name ="ABC CONTACT";
//		String  emgcontacts_relationship="anonymous";
//		String  emgcontacts_homePhone="7039442222";
//
//		String dependent_name ="Madison Mondal";
//		String dependent_relationship ="Madison Mondal";
//		
//		String passportNumber="987654321";

//*******************************************************************************		
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		// Login
		driver.findElement(By.id("txtUsername")).click();
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		driver.findElement(By.id("txtPassword")).click();
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);

		// AddEmployee
		FunctionLibrary.hoverFunction(driver, "//*[@id='menu_pim_viewPimModule']/b");
		FunctionLibrary.SelectItemBootStrapDD(driver, "//ul//li/a", "Add Employee");
		driver.findElement(By.id("firstName")).click();
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).click();
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("btnSave")).click();

		// PersonalDetails
		driver.findElement(By.id("personal_optGender_1")).click();
		driver.findElement(By.id("personal_cmbNation")).click();
		new Select(driver.findElement(By.id("personal_cmbNation"))).selectByVisibleText(nationality);
		new Select(driver.findElement(By.id("personal_cmbMarital"))).selectByVisibleText(maritalStatus);

		{
			// click on the calendar
			driver.findElement(By.xpath("//*[@id='frmEmpPersonalDetails']/fieldset/ol[3]/li[4]/img")).click();
			// select the month
			new Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[1]")))
					.selectByVisibleText("Feb");
			// select year
			new Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]")))
					.selectByVisibleText("2000");
			// select date
			List<WebElement> ele = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a"));
			for (int i = 0; i < ele.size(); i++) {

				String element = ele.get(i).getText();

				if (element.equalsIgnoreCase("9")) {

					ele.get(i).click();
					break;

				}
			}

		}
		Thread.sleep(2000);

		driver.findElement(By.id("btnSave")).click();

		// AddBloodType

		driver.findElement(By.id("btnEditCustom")).click();// Edit blood type
		{
			new Select(driver.findElement(By.name("custom1"))).selectByVisibleText("AB+");
		}
		driver.findElement(By.name("btnEditCustom")).click();// save button

		// ContactDetails

		driver.findElement(By.linkText("Contact Details")).click();
		driver.findElement(By.id("btnSave")).click();// edit button
		driver.findElement(By.id("contact_street1")).sendKeys(contact_street1);
		driver.findElement(By.id("contact_city")).sendKeys(contact_city);
		driver.findElement(By.id("contact_province")).sendKeys(contact_province);
		driver.findElement(By.id("contact_emp_zipcode")).sendKeys(contact_emp_zipcode);
		{
			new Select(driver.findElement(By.id("contact_country"))).selectByVisibleText(contact_country);// country
		}
		driver.findElement(By.id("contact_emp_hm_telephone")).sendKeys(contact_emp_hm_telephone);
		driver.findElement(By.id("contact_emp_work_email")).sendKeys("" + contact_emp_work_email + "");
		Thread.sleep(2000);
		driver.findElement(By.id("btnSave")).click();

		// EmergencyContracts 
//		SoftAssert sa=new SoftAssert();

		driver.findElement(By.linkText("Emergency Contacts")).click();
		driver.findElement(By.id("btnAddContact")).click();// add button
		driver.findElement(By.id("emgcontacts_name")).sendKeys(emgcontacts_name);
		driver.findElement(By.id("emgcontacts_relationship")).sendKeys(emgcontacts_relationship);
		driver.findElement(By.id("emgcontacts_homePhone")).sendKeys(emgcontacts_homePhone);
		driver.findElement(By.id("btnSaveEContact")).click();

		Thread.sleep(3000);
		String expected = "" + emgcontacts_name + "";

		System.out.println("expected========" + expected);
		String Actual = driver.findElement(By.xpath("//*[@id='emgcontact_list']//tr[@class='odd']")).getText();

		System.out.println("Found string " + Actual.substring(0, 11));

		sa.assertEquals(Actual.substring(0, 11), expected);

//		sa.assertAll();

		// Dependents

		driver.findElement(By.linkText("Dependents")).click();
		driver.findElement(By.id("btnAddDependent")).click();// add button
		driver.findElement(By.id("dependent_name")).sendKeys(dependent_name);
		{
			new Select(driver.findElement(By.id("dependent_relationshipType"))).selectByVisibleText("Other");
		}

		driver.findElement(By.xpath("//*[@id='dependent_relationship']")).sendKeys(dependent_relationship);

		{
			// click on the calendar
			driver.findElement(By.xpath("//*[@id=\"frmEmpDependent\"]/fieldset/ol/li[4]/img")).click();
			// select the month
			new Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[1]")))
					.selectByVisibleText("Feb");
			// select year
			new Select(driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/select[2]")))
					.selectByVisibleText("2019");
			// select date
			List<WebElement> ele = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a"));
			for (int i = 0; i < ele.size(); i++) {

				String element = ele.get(i).getText();

				if (element.equalsIgnoreCase("20")) {

					ele.get(i).click();
					break;

				}
			}
		}

		driver.findElement(By.id("btnSaveDependent")).click();

		// ImmigrationInformation

		driver.findElement(By.linkText("Immigration")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("immigration_number")).sendKeys(passportNumber);// passport number

		// IssueDage
		{
			// click on the calendar
			driver.findElement(By.xpath("//*[@id='frmEmpImmigration']/fieldset/ol/li[3]/img")).click();
			// select the month
			new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")))
					.selectByVisibleText("Mar");
			// select year
			new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")))
					.selectByVisibleText("2018");
			// select date
			List<WebElement> ele = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a"));
			for (int i = 0; i < ele.size(); i++) {

				String element = ele.get(i).getText();

				if (element.equalsIgnoreCase("16")) {

					ele.get(i).click();
					break;
				}
			}
		}

		// ExpireDate

		{
			// click on the calendar
			driver.findElement(By.xpath("//*[@id=\"frmEmpImmigration\"]/fieldset/ol/li[4]/img")).click();
			// select the month
			new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")))
					.selectByVisibleText("Mar");
			// select year
			new Select(driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")))
					.selectByVisibleText("2023");
			// select date
			List<WebElement> ele = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a"));
			for (int i = 0; i < ele.size(); i++) {

				String element = ele.get(i).getText();

				if (element.equalsIgnoreCase("16")) {

					ele.get(i).click();
					break;

				}
			}
		}
		driver.findElement(By.id("btnSave")).click();
		
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(500);

		driver.quit();

		sa.assertAll();

	}

	@DataProvider(name = "OrangeHRMTD")
	public Object[][] dp() {
		
		dataProviderExcel objxldata = new dataProviderExcel("./TestData/OrangeHRMTestData.xlsx");
		
		int row = objxldata.rowCount(0);

		Object[][] data = new Object[row][18];

		for (int i = 0; i < row; i++) {

			data[i][0] = objxldata.getData(0, i, 0);
			data[i][1] = objxldata.getData(0, i, 1);
			data[i][2] = objxldata.getData(0, i, 2);
			data[i][3] = objxldata.getData(0, i, 3);
			data[i][4] = objxldata.getData(0, i, 4);
			data[i][5] = objxldata.getData(0, i, 5);
			data[i][6] = objxldata.getData(0, i, 6);
			data[i][7] = objxldata.getData(0, i, 7);
			data[i][8] = objxldata.getData(0, i, 8);
			data[i][9] = objxldata.getData(0, i, 9);
			data[i][10] = objxldata.getData(0, i, 10);
			data[i][11] = objxldata.getData(0, i, 11);
			data[i][12] = objxldata.getData(0, i, 12);
			data[i][13] = objxldata.getData(0, i, 13);
			data[i][14] = objxldata.getData(0, i, 14);
			data[i][15] = objxldata.getData(0, i, 15);
			data[i][16] = objxldata.getData(0, i, 16);
			data[i][17] = objxldata.getData(0, i, 17);


		}
		return data;
	}
}
