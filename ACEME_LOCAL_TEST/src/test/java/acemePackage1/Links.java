package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class Links {
	public void verifyLinks(WebDriver driver) throws Exception {
		
		SoftAssert sa=new SoftAssert();
		
		driver.findElement(By.xpath("//*[@id=\"item-5\"]/span[text()='Links']")).click();
		driver.findElement(By.linkText("Home")).click();

		FunctionLibrary.HandleWindows(driver);

		driver.findElement(By.xpath("//*[@id=\"created\"]")).click();

		String text = driver.findElement(By.xpath("//*[@id=\"linkResponse\"]")).getText();

		String testOutput1 = text.substring(0, 30);
		String testOutput = text.substring(30, 33);
		String comineText = testOutput1 + testOutput;
		System.out.println(comineText);

		String createdExpected = "Link has responded with staus 201";
		sa.assertEquals(comineText, createdExpected, "please see if it fails");

		Thread.sleep(2000);

		driver.findElement(By.linkText("Bad Request")).click();
		Thread.sleep(1000);

		String text2 = driver.findElement(By.xpath("//p[@id='linkResponse']")).getText();

		String testOutput2 = text.substring(0, 30);
		String testOutput3 = text2.substring(30, 33);
		String comineText2 = testOutput2 + testOutput3;

		System.out.println("Second Assertion=========" + comineText2);

		String createdExpected2 = "Link has responded with staus 400";
		sa.assertEquals(comineText2, createdExpected2, "please see if it fails");
		
	}

}
