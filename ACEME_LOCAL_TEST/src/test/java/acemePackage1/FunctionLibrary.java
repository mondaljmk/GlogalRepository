package acemePackage1;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FunctionLibrary {

//	public static void Run$$From$$Step() {
//		
//		System.setProperty("webdriver.chrome.driver","F:\\Selenium\\AllDrivers\\chromedriver_win32_84\\chromedriver.exe");
//		ChromeOptions co = new ChromeOptions();
//		co.setExperimentalOption("debuggerAddress", "localhost:9015");
//		WebDriver driver = new ChromeDriver(co);
//	}

	public static void btDD(WebDriver driver, String strXPath, String strSelectItem) {

		List<WebElement> elements = driver.findElements(By.xpath("" + strXPath + ""));
		for (int i = 0; i < elements.size(); i++) {

			String srtString = elements.get(i).getText();
			if (srtString.equalsIgnoreCase("" + strSelectItem + "")) {
				elements.get(i).click();
				break;

			}

		}

	}

	public static void click$$On$The$CurrentDate$$from$$the$$datePicker(WebDriver driver, String datePickerTableXpath) {
		// input datepicker
		// click on the current date from date picker table
		List<WebElement> elements = driver.findElements(By.xpath("" + datePickerTableXpath + ""));

		LocalDate.now().getDayOfMonth();

		for (int i = 0; i < elements.size(); i++) {

			if (i == LocalDate.now().getDayOfMonth()) {

				elements.get(i).click();
				break;
			}

		}

	}

	public static void click$FutureDay$$AsNeeded(WebDriver driver, String datePickerTableXpath, int expectedDate) {

		// click on the current date from date picker table
		List<WebElement> elements = driver.findElements(By.xpath("" + datePickerTableXpath + ""));

		Calendar clCalendar = Calendar.getInstance();
		int date = clCalendar.get(Calendar.DATE) + expectedDate;
//		System.out.println("date selected::"+date);

		for (int i = 0; i < elements.size(); i++) {

			if (i == date) {

				elements.get(i).click();
				break;
			}

		}

	}

	public static void one$$Year$$Advance(WebDriver driver, String yrDDXpath) {
		// bootStrap datepicker
		new Select(driver.findElement(By.xpath("" + yrDDXpath + "")))
				.selectByVisibleText("" + FunctionLibrary.getIntYearPlus() + "");

	}

	public static void currentDayOfMonth(WebDriver driver, String datePickerTableXpath) {
		// bootStrap datepicker
		// This is from date picker table
		List<WebElement> elements = driver.findElements(By.xpath("" + datePickerTableXpath + ""));

		LocalDate.now().getDayOfMonth();

		for (int i = 0; i < elements.size(); i++) {

			String currDate = elements.get(i).getText();

			int dayofmonth = Integer.parseInt(currDate);

			if (dayofmonth == LocalDate.now().getDayOfMonth()) {

				elements.get(i).click();
				break;
			}

		}
	}

	public String dateToday() {

		SimpleDateFormat sdfDateFormat = new SimpleDateFormat("MM/dd/YYYY");

		Date strDate = new Date();

		String srtString = sdfDateFormat.format(strDate);

		System.out.println(srtString);

		return srtString;
	}

	public String futureDateString() {

//		MM/dd/YYYY returns in this format

//		https://www.youtube.com/watch?v=5CtayD2RUqM

		Calendar instCalendar = Calendar.getInstance();
		instCalendar.add(Calendar.DATE, 0);
		instCalendar.add(Calendar.MONTH, 0);
		instCalendar.add(Calendar.YEAR, 1);

		Date date = instCalendar.getTime();

		SimpleDateFormat sdfFormat = new SimpleDateFormat("MM/dd/YYYY");
		String dateString = sdfFormat.format(date);

		return dateString;
	}

	public Month getstrMonthNow() {

		LocalDate nameMonth = LocalDate.now();
		Month abcString = nameMonth.getMonth();
		return abcString;

	}

	public int getYearNow() {

		LocalDate nameMonth = LocalDate.now();
		int abcString = nameMonth.getYear();
		return abcString;

	}

	public int getIntegerMonthNow() {

		Calendar clCalendar = Calendar.getInstance();
		int month = clCalendar.get(Calendar.MONTH) + 1;
		return month;
	}

	public static int getInteger$$Day$$Position(int expectedDate) {

		// click on the current date from date picker table
//		List<WebElement> dtelements = driver.findElements(By.xpath(""+ftdatePickerTableXpath+""));

		// This will returns the date tomorrow or as intended
		Calendar clCalendar = Calendar.getInstance();
		int date = clCalendar.get(Calendar.DATE) + expectedDate;
		System.out.println("date selected::" + date);
		return date;
	}

	public static int getIntegerDayNow() {
		Calendar clCalendar = Calendar.getInstance();
		int date = clCalendar.get(Calendar.DATE);
		System.out.println("date selected::" + date);
		return date;
	}

	public static int getIntegerYear() {

		Calendar clCalendar = Calendar.getInstance();
		int year = clCalendar.get(Calendar.YEAR);
		return year;
	}

	public static String currentMonthName() {

		String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		Calendar cal = Calendar.getInstance();

		String month = monthName[cal.get(Calendar.MONTH)];

		return month;
	}

	public static String crntMonthName3Digit() {

		String[] monthName = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

		Calendar cal = Calendar.getInstance();

		String month = monthName[cal.get(Calendar.MONTH)];

		System.out.println(month);
		return month;
	}

	public String getYearPlus() {

		Calendar instCalendar = Calendar.getInstance();
		instCalendar.add(Calendar.YEAR, 1);

		Date date = instCalendar.getTime();

		SimpleDateFormat sdfFormat = new SimpleDateFormat("YYYY");
		String dateString = sdfFormat.format(date);

		return dateString;

	}

	public static int getIntYearPlus() {

		Calendar clCalendar = Calendar.getInstance();
		int year = clCalendar.get(Calendar.YEAR) + 1;
		return year;
	}

	public void clickWebListLink(WebDriver driver, String ElementsXpath, String clickLink) throws Exception {

		List<WebElement> tableData = driver.findElements(By.xpath("" + ElementsXpath + ""));

		System.out.println(tableData.size());

		for (int i = 0; i < tableData.size(); i++) {

			String strDataString = tableData.get(i).getText();

			if (strDataString.equalsIgnoreCase("Christmas")) {

				driver.findElement(By.xpath("" + clickLink + "")).click();

				Thread.sleep(1000);
				break;
			} else {

			}
		}
	}

	public static void destinationDatePicker_select_date(WebDriver driver) throws Exception {
		// bootStrap datepicker
		Thread.sleep(2000);// Click on the name of the month
		driver.findElement(By.xpath("//th[contains(text(),'" + FunctionLibrary.currentMonthName() + "')]")).click();

		Thread.sleep(2000);// Click on the year numeric value
		driver.findElement(
				By.xpath("//div[@class='datepicker-months']//th[@class='datepicker-switch'][contains(text(),'"
						+ FunctionLibrary.getIntegerYear() + "')]"))
				.click();

		Thread.sleep(2000);// Click on the year numeric value again

		FunctionLibrary.clickString(driver, "//div[@class='datepicker-years']//td/span",
				"" + FunctionLibrary.getIntYearPlus() + "");

		Thread.sleep(2000);// Click on the name of the month "Aug/Sep/etc"

		FunctionLibrary.clickString(driver, "//div[@class='datepicker-months']//td/span",
				"" + FunctionLibrary.crntMonthName3Digit() + "");

		Thread.sleep(2000);// Click on the date
		driver.findElement(
				By.xpath("//td[@class='day'][contains(text(),'" + FunctionLibrary.getIntegerDayNow() + "')]")).click();

	}

	public static int GenericRandomNumber() {
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(9999) + 1111;
		return randomNumber;

	}

	public static int dbldigit() {
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(99) + 11;
		return randomNumber;

	}

	public static String clickString(WebDriver driver, String xpathWebList, String expectString) {

		List<WebElement> webtableElements = driver.findElements(By.xpath("" + xpathWebList + ""));
		for (int i = 0; i < webtableElements.size(); i++) {
			String outerTextString = webtableElements.get(i).getText();
			if (outerTextString.equalsIgnoreCase("" + expectString + "")) {
//				System.out.println(outerTextString);
				webtableElements.get(i).click();
				break;
			}
		}
		return expectString;
	}

//	mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
	public void datePickerDateSelect(WebDriver driver) throws Exception {

		String actualmonth = "November 2022";
		String actualDay = "30";

		Thread.sleep(3000);

		while (true) {

			String text = driver.findElement(By.xpath("//th[@class='month']")).getText();// find the month and year
			if (text.equalsIgnoreCase(actualmonth)) {
				break;
			} else {
				driver.findElement(By.xpath("//i[@class='icon-arrow-right']")).click();
			}
		}
		Thread.sleep(1000);
		List<WebElement> allDate = driver
				.findElements(By.xpath("//*[starts-with(@id,'picker')]/div[3]/div[2]/table/tbody/tr/td"));// how many
																											// days in
																											// the month
		Thread.sleep(3000);
		System.out.println("Total number of elements:  =========" + allDate.size());

		Thread.sleep(1000);

		for (int i = 0; i < allDate.size(); i++) {

			String ele = allDate.get(i).getText();

			if (ele.equalsIgnoreCase(actualDay)) {

				allDate.get(i).click();
				break;
			}
		}
//---------------------------------------------------------------------------
		Thread.sleep(2000);

		String returnmonth = "Apr 2022";
		String returnday = "20";

		Thread.sleep(2000);
		// how many days in the month
		List<WebElement> allreturingdate = driver
				.findElements(By.xpath("//*[starts-with(@id,'picker')]/div[4]/div[2]/table/tbody/tr/td"));
		Thread.sleep(2000);

		System.out.println("Return date element count: " + allreturingdate.size());

		for (int ii = 0; ii < allreturingdate.size(); ii++) {

			String element = allreturingdate.get(ii).getText();

			if (element.equalsIgnoreCase(returnday)) {

				allreturingdate.get(ii).click();
				break;
			}

		}
		Thread.sleep(2000);
	}

	public static void hoverFunction(WebDriver driver, String xpath) {

		WebElement element = driver.findElement(By.xpath("" + xpath + ""));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();

	}

	public static void SelectItemBootStrapDD(WebDriver driver, String xpath, String textToFind) {

		List<WebElement> ele = driver.findElements(By.xpath("" + xpath + ""));

		for (int i = 0; i < ele.size(); i++) {

			String text = ele.get(i).getText();

			if (text.equalsIgnoreCase("" + textToFind + "")) {

				ele.get(i).click();
				break;

			}

		}
	}

	public static void dateSelection(WebDriver driver) {
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
	
	public static void HandleWindows(WebDriver driver) {
		
		String handle=driver.getWindowHandle();
		
		Set<String> secondWindows=driver.getWindowHandles();
		
		for(String i:secondWindows) {
			if(!i.equals(handle)) {
				driver.switchTo().window(i).close();
				driver.switchTo().window(handle);
				
				
			}
			
		}
	}
	
	public static void HandleiFrame(WebDriver driver) {
		WebElement ele = driver.findElement(By.xpath("//iframe[@name='pat']"));
		driver.switchTo().frame(ele);
		driver.findElement(By.xpath("//span[text()='Add']")).click();
	}

	public static void HandleiFrame(WebDriver driver,String TopFrame,String eleLocation) {
		WebElement ele = driver.findElement(By.xpath(""+TopFrame+""));
		driver.switchTo().frame(ele);
		driver.findElement(By.xpath(""+eleLocation+"")).click();
	}
	
	public static void HandleiFrame(WebDriver driver,String TopFrame) {
		WebElement ele = driver.findElement(By.xpath(""+TopFrame+""));
		driver.switchTo().frame(ele);
	}
}
