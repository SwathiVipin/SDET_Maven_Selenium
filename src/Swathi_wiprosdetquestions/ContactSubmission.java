package Swathi_wiprosdetquestions;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import Swathi_wiprosdetAssignments.TestBase;

//Assignment 1 questions 2- Swathi
public class ContactSubmission extends TestBase {
	
	public static WebDriver driver;
	// passing the browser
	static String  browserName = "chrome"; // Firefox
	//passing the url
	static String   url = "https://demoqa.com/html-contact-form/";
	
	
	//Filling the contact details
	public  void fillContactForm() throws AWTException, Exception {
		try {
		driver.findElement(By.cssSelector("input.firstname")).sendKeys("Swathi");
		driver.findElement(By.cssSelector("#lname")).sendKeys("kasaragod");
		driver.findElement(By.xpath("//input[@type='text'][@name='country']")).sendKeys("India");
		driver.findElement(By.cssSelector("#subject")).sendKeys("Testing the contact form");
		WebElement firstEle = driver.findElement(By.partialLinkText("Link"));
		WebElement secondEle = driver.findElement(By.partialLinkText("here"));
		
		Actions act = new Actions(driver);
		act.moveToElement(firstEle);
		act.keyDown(firstEle,Keys.CONTROL).click().build().perform();
		
		act.moveToElement(secondEle).build().perform();
		act.keyDown(secondEle, Keys.CONTROL).click().build().perform();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws AWTException, Exception {
		ContactSubmission cont = new ContactSubmission();
		driver = driverIntialization(browserName);
		driver.get(url);
		cont.fillContactForm();
		tearDown(driver);
		
	}
	
	
	
}
