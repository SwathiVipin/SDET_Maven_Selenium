package Swathi_wiprosdetquestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//Assignment 1 questions 3- Swathi
public class Dragdrop extends Swathi_wiprosdetAssignments.TestBase {

	
	public static WebDriver driver;
	// passing the browser
	static String browserName = "chrome"; // Firefox
	//passing the url
	static String url = "https://demoqa.com/droppable/";
	
	//WebElement for drag and drop
	WebElement dragsource;
	WebElement target;	
	
	public  void dragdroppable(WebDriver driver) throws InterruptedException {
		
		dragsource = driver.findElement(By.cssSelector("#draggable"));
		target = driver.findElement(By.cssSelector("#droppable"));
		Thread.sleep(500);
		Actions act = new Actions(driver);
		act.dragAndDrop(dragsource, target).build().perform();
		System.out.println("Dropped");
		
					
	}
	
	public static void main(String[] args) throws InterruptedException {
		driver = driverIntialization(browserName);
		driver.get(url);
		Dragdrop drd = new Dragdrop();
		drd.dragdroppable(driver);
		tearDown(driver);
	
	}

}
