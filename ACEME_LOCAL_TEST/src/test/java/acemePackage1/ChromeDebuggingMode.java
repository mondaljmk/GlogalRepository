package acemePackage1;

import java.util.List;

import org.bouncycastle.crypto.tls.SRTPProtectionProfile;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ChromeDebuggingMode {
	@Test
	public void debuggingMode() throws Exception {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "localhost:8081");
		WebDriver driver = new ChromeDriver(options);
//*********************************************************************************************************
		driver.findElement(By.xpath("//*[@id='content']/div[1]/div[1]/div/div[1]/h1/span[2]/span")).click();


	}

}
