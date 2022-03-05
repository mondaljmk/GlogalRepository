package acemePackage1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ScoreCalculation {

	public void score(WebDriver driver,String  tuition ,String mathematics  ,String  physics ,String  biology ,String chemistry,String geography  ,String history  ,String  english ,String  computerScience) throws Exception {
		
		driver.findElement(By.id("tuition")).click();
		driver.findElement(By.id("tuition")).sendKeys(tuition);
		driver.findElement(By.id("mathematics")).click();
		driver.findElement(By.id("mathematics")).sendKeys(mathematics);
		driver.findElement(By.id("physics")).click();
		driver.findElement(By.id("physics")).sendKeys(physics);
		driver.findElement(By.id("biology")).click();
		driver.findElement(By.id("biology")).sendKeys(biology); 
		driver.findElement(By.id("chemistry")).click();
		driver.findElement(By.id("chemistry")).sendKeys(chemistry );
		driver.findElement(By.id("geography")).click();
		driver.findElement(By.id("geography")).sendKeys(geography);
		driver.findElement(By.id("history")).click();
		driver.findElement(By.id("history")).sendKeys(history);
		driver.findElement(By.id("english")).click();
		driver.findElement(By.id("english")).sendKeys(english);
		driver.findElement(By.id("computer Science")).click();
		driver.findElement(By.id("computer Science")).sendKeys(computerScience);
		driver.findElement(By.id("professorComments")).click();
		driver.findElement(By.id("professorComments")).sendKeys("test comments");
		driver.findElement(By.id("buttonScoreCard")).click();
		driver.findElement(By.cssSelector(".main-container > .row")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		driver.quit();

	}
}
