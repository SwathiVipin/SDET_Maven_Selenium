package Swathi_wiprosdetquestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import Swathi_wiprosdetAssignments.TestBase;

public class SelectMenue extends TestBase {
	
	public static WebDriver driver;
	// passing the browser
	static String browserName = "chrome"; // Firefox
	//passing the url
	static String url = "https://demoqa.com/selectmenu/";
	
	//WebElement declaration
	String xpathClickEle , xpathEle;
	
	public void menuSelection(WebDriver driver,String xpathClickEle,String xpathEle) {
		driver.findElement(By.id(xpathClickEle)).click();
		List<WebElement> allSpeedDropDownitems = driver.findElements(By.xpath(xpathEle));
		int length = allSpeedDropDownitems.size();
		for(int index =1; index <= length;index++ ) {
			driver.findElement(By.xpath(xpathEle+"["+index+"]")).click();
			if ( index < length)
				driver.findElement(By.id(xpathClickEle)).click();
			
		}
		
		System.out.println(length);
	}
	

	
	public void menuSalutation(WebDriver driver,String xpathClickEle,String xpathEle) {
		driver.findElement(By.id(xpathClickEle)).click();
		List<WebElement> allSpeedDropDownitems = driver.findElements(By.xpath(xpathEle));
		int length = allSpeedDropDownitems.size();
		for(int index =2; index <= length;index++ ) {
			driver.findElement(By.xpath(xpathEle+"["+index+"]")).click();
			if ( index < length)
				driver.findElement(By.id(xpathClickEle)).click();
			
		}
		
		System.out.println(length);

	}

	
	

	public static void main(String[] args) throws InterruptedException  {
		driver = driverIntialization(browserName);
		driver.get(url);
		// code for select first menu Just passing the xpath again on same function
		SelectMenue menu = new SelectMenue();
		menu.xpathClickEle = "speed-button";
		menu.xpathEle = "//*[@id='speed-menu']/li";
		menu.menuSelection(driver,menu.xpathClickEle,menu.xpathEle );
		// code for select number menu Just passing the xpath again on same function
		menu.xpathClickEle = "number-button";
		menu.xpathEle= "//*[@id='number-menu']/li";
		menu.menuSelection(driver,menu.xpathClickEle,menu.xpathEle );
		// code for select salutation menu
		menu.xpathClickEle = "salutation-button";
		menu.xpathEle= "//*[@id='salutation-menu']/li";
		menu.menuSalutation(driver,menu.xpathClickEle,menu.xpathEle );
		// code for select files menu Just passing the xpath again on same function
		menu.xpathClickEle = "files-button";
		menu.xpathEle= "//*[@id='files-menu']/li";
		menu.menuSelection(driver,menu.xpathClickEle,menu.xpathEle );
		tearDown(driver);

	}

}
