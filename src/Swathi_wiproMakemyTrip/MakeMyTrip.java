package Swathi_wiproMakemyTrip;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import Swathi_wiprosdetAssignments.TestBase;

public class MakeMyTrip extends TestBase{


	public static WebDriver driver;
	// passing the browser
	static String  browserName = "chrome"; // Firefox
	//passing the url
	static String   url = "https://www.makemytrip.com/";
	
	//locators
	 String tripSelectionMultipleCity = "//div[@class ='makeFlex']/ul/li[2]";
	 String tripSelectionOneWay = "//div[@class ='makeFlex']/ul/li[1]";
	 String fromCityClickable = "fromCity";
	 String fromCity = "/html/body/div/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input";
	 String toCity = "toCity" ;//"//*[@id='toCity']";
	 String Popup ="/html/body/div/div[2]/div/div/a";
	 String autoSelectiondDepFrom = "react-autowhatever-1-section-0-item-0";
	// String autoSelectiondDepTo = "/html/body/div/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/ul/li[1]";
	 String autoSelectiondDepTo = "/html/body/div/div/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div/div/ul/li[1]";
	 String dateSelectionArrow ="//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]";
	 String dateSelction = "//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/div[3]/div";
	 String searchButton = "//*[@id='root']/div/div[2]/div/div/div[2]/p/a";
	 String priceArrow = "//*[@id='sorting-togglers']/div[5]/span/span[2]";
	 String bookNow = "/html/body/div[1]/div/div[2]/div[2]/div[2]/div[1]/div[3]/div/div[1]/div[1]/div[1]/div/div/div/div[4]/button";
	 String reviewTitle = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/h4";
	 
	public void flightTravelinfo(WebDriver driver) throws InterruptedException {
		Actions act = new Actions(driver);
		driver.findElement(By.xpath(tripSelectionMultipleCity)).click();
		driver.findElement(By.xpath(tripSelectionOneWay)).click();
		driver.findElement(By.id(fromCityClickable)).click();
		driver.findElement(By.xpath(fromCity)).sendKeys("Bangalore");
		Thread.sleep(2000);
		act.click(driver.findElement(By.id(autoSelectiondDepFrom))).build().perform();
		driver.findElement(By.id(toCity)).sendKeys("Delhi");
		Thread.sleep(2000);
		act.click(driver.findElement(By.xpath(autoSelectiondDepTo))).build().perform();
		//act.click(driver.findElement(By.id(autoSelectiondDepFrom))).build().perform();
		driver.findElement(By.xpath(dateSelectionArrow)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(dateSelction)).click();
		driver.findElement(By.xpath(searchButton)).click();
		
		
		//waitLoader(driver, Popup);
	}
	
	public void searchCheapflight(WebDriver driver) throws InterruptedException {
		waitLoader(driver, priceArrow);
		Thread.sleep(2000);
		driver.findElement(By.xpath(priceArrow)).click();
		driver.findElement(By.xpath(bookNow)).click();
		String title = driver.findElement(By.xpath(reviewTitle)).getText();

	}
	

	public static void main(String[] args) throws InterruptedException {
		
		driver = driverIntialization(browserName);
		driver.get(url);
		MakeMyTrip mkTrip = new MakeMyTrip();
		mkTrip.flightTravelinfo(driver);
		mkTrip.searchCheapflight(driver);
		
	}

}
