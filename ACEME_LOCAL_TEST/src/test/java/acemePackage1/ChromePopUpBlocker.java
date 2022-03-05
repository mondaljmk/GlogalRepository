package acemePackage1;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//https://www.youtube.com/watch?v=rjScSPsgtro

//https://chromedriver.chromium.org/
public class ChromePopUpBlocker {
	
  @Test
  public void PopUpBlocker() {
	  
	  WebDriverManager.chromedriver().setup();
	  ChromeOptions opt=new ChromeOptions();
	  opt.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
	  WebDriver driver=new ChromeDriver(opt);
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	  driver.get("https://www.amazon.com/");  
  }
  
}
