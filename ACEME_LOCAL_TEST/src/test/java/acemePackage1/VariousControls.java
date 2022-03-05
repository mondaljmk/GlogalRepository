package acemePackage1;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VariousControls {
	

	@Test
	public void Controls() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_98.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		SoftAssert sa = new SoftAssert();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		driver.findElement(By.xpath("//h5[contains(text(),'Elements')]")).click();

//	  TextBox
		TextBox obj=new TextBox();
		obj.writeText(driver);
		


//		Check Box
		CheckBox checkBox=new CheckBox();
		checkBox.checkCheckBox(driver);
		

//		Radio Button
		RadioButton radioButton=new RadioButton();
		radioButton.checkRadioButton(driver);

//		Buttons
		Buttons  button=new Buttons();
		button.verifyButton(driver);
		
//		Links
		Links links=new Links();
		
		driver.quit();

		sa.assertAll();

	}

}
