package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Lib.ExcelConfig;

public class ExcelDemoDDT{

	@Test(dataProvider = "PHPtravels")

	public void newMemberRegistration(String fname, String lname, String email,String password, String homephone, String cellPhone ) 
	
	{
	
		System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://trainingrite.net/");
		driver.findElement(By.cssSelector("div:nth-child(3) > .submitbtn")).click();
		
			
		driver.findElement(By.id("ctl00_MainContent_txtFirstName")).click();
		driver.findElement(By.id("ctl00_MainContent_txtFirstName")).sendKeys(fname);
		driver.findElement(By.id("ctl00_MainContent_txtLastName")).sendKeys(lname);
		driver.findElement(By.id("ctl00_MainContent_txtEmail")).sendKeys(email);
		driver.findElement(By.id("ctl00_MainContent_txtPassword")).sendKeys(password);
		driver.findElement(By.id("ctl00_MainContent_txtVerifyPassword")).sendKeys("DHIMSdte12345$$");
		driver.findElement(By.id("ctl00_MainContent_txtHomePhone")).sendKeys(homephone);
		driver.findElement(By.id("ctl00_MainContent_txtCellPhone")).sendKeys(cellPhone);
		driver.findElement(By.id("ctl00_MainContent_txtInstructions")).click(); 
		driver.findElement(By.id("ctl00_MainContent_txtInstructions")).sendKeys("this is a test");
		driver.findElement(By.id("ctl00_MainContent_btnSubmit")).click(); 
		
		
		driver.close();
	} 
	@DataProvider(name = "PHPtravels")
	public Object[][] testData() {

		ExcelConfig xlDDT = new ExcelConfig("./TestData/TRdata.xlsx");
		
		int row = xlDDT.getRowCount(0);

		Object[][] data = new Object[row][6];

		for (int i = 0; i <row; i++) {
			
			data[i][0]=xlDDT.getData(0, i, 0);//lname
			data[i][1]=xlDDT.getData(0, i, 1);//fname		
			data[i][2]=xlDDT.getData(0, i, 2);//email
			data[i][3]=xlDDT.getData(0, i, 3);//password
			data[i][4]=xlDDT.getData(0, i, 4);//hphone
			data[i][5]=xlDDT.getData(0, i, 5);//cellPhone
			
		}
		return data;
		


	}

}
