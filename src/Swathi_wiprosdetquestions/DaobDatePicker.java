package Swathi_wiprosdetquestions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Swathi_wiprosdetAssignments.TestBase;

//Assignment 1 questions 4- Swathi
public class DaobDatePicker extends TestBase{

	
	public static WebDriver driver;
	// passing the browser
	static String browserName = "chrome"; // Firefox
	//passing the url
	static String url = "https://demoqa.com/datepicker/";
	
	// WebElement and variable declarations
	static String birthDate = "23/09/2019";
	static int  currentMonth =0, count=0;
	static String uiCalMonth,UiCalyear; 
	static WebElement arrowClick;
	
	public static void getUiMonthAndYear() {
		
		uiCalMonth= driver.findElement(By.className("ui-datepicker-month")).getText();
		UiCalyear = driver.findElement(By.className("ui-datepicker-year")).getText();
		//System.out.println("Month "+uiCalMonth+" And  Year "+UiCalyear);
		
	}


	
	public static void  main(String[] args) throws Exception {
		
		driver = driverIntialization(browserName);
		driver.get(url);
		driver.findElement(By.id("datepicker")).click();
		DaobDatePicker.getUiMonthAndYear();
		currentMonth = dateFormater(uiCalMonth);
		String [] dob = birthDate.split("/");
		int dobMonth = Integer.parseInt(dob[1]);
		int dobYear = Integer.parseInt(dob[2]);
		int diffYear = Integer.parseInt(UiCalyear)-dobYear;
		int subMonth = currentMonth - dobMonth ;
		count = (diffYear * 12)+ subMonth;
		System.out.println(count);
	
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		 
		 for (int index = 1 ; index <= count; index++) {
			 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ui-datepicker-div']/div/a[1]/span"))).click();
			 
		 }
		 
		List <WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for(WebElement eachDate : allDates) {
			String date = eachDate.getText();
			if (date.equalsIgnoreCase(dob[0])) {
				eachDate.click();
			}
		}
		
		tearDown(driver);
	}

}