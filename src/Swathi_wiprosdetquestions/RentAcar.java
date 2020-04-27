package Swathi_wiprosdetquestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Swathi_wiprosdetAssignments.TestBase;

public class RentAcar extends TestBase{
	public static WebDriver driver;
	// passing the browser
	static String browserName = "chrome"; // Firefox
	//passing the url
	static String url = "https://demoqa.com/controlgroup/";
	
	//String eclaration
		String xpathClickEle , xpathEle;
		String carType ="Luxury";
		
	public void carSelection(WebDriver driver,String xpathClickEle,String xpathEle,String carType) {
		driver.findElement(By.id(xpathClickEle)).click();
		List<WebElement> allSpeedDropDownitems = driver.findElements(By.xpath(xpathEle));
		int length = allSpeedDropDownitems.size();
		for(int index =1; index <= length;index++ ) {
			if((driver.findElement(By.xpath(xpathEle+"["+index+"]")).getText()).equalsIgnoreCase(carType)) {
				driver.findElement(By.xpath(xpathEle+"["+index+"]")).click();
				System.out.println(index);
				break;			
			}

			driver.findElement(By.id(xpathClickEle)).click();
		}
		
		driver.findElement(By.xpath("//*[@id='content']/div[2]/div/fieldset[2]/div/label[2]/span[1]")).click();		
		driver.findElement(By.xpath("//*[@id='content']/div[2]/div/fieldset[2]/div/label[3]/span[1]")).click();
		driver.findElement(By.xpath("//*[@id='content']/div[2]/div/fieldset[2]/div/span[2]/a[1]")).click();
		driver.findElement(By.xpath("//*[@id='content']/div[2]/div/fieldset[2]/div/span[2]/a[1]")).click();	
		driver.findElement(By.id("book")).click();
		
		System.out.println("Car Booked Sucessfully");
	}
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		driver = driverIntialization(browserName);
		driver.get(url);
		RentAcar rent = new RentAcar();
		rent.xpathClickEle = "ui-id-8-button";
		rent.xpathEle = "//*[@id='ui-id-8-menu']/li";
		rent.carSelection(driver,rent.xpathClickEle,rent.xpathEle,rent.carType );
		tearDown(driver);

	}

}
