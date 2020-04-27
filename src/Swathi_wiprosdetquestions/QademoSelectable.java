package Swathi_wiprosdetquestions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import Swathi_wiprosdetAssignments.TestBase;

//Assignment 1 questions 1- Swathi


public class QademoSelectable extends TestBase {
	
	public static WebDriver driver;
	// passing the browser
	static String browserName = "chrome"; // Firefox
	//passing the url
	static String url = "https://demoqa.com/selectable/";
	
	// variable declarations
	String expectedTitle ="Selectable – ToolsQA – Demo Website to Practice Automation";
	WebElement selectedElement;
	String elementName;
	int totalItemCount = 7;

	
	// verifying the pagetitle
	public void verifyPageTitle( WebDriver driver){
		String title = driver.getTitle();
		assertEquals(title, expectedTitle);

	}
	// finding the elements and item list

	public void getAllElementsAndNames( WebDriver driver) {
		for (int counter = 1; counter <= totalItemCount; counter++) {
			selectedElement = driver.findElement(By.xpath("//*[@id=\"selectable\"]/li["+counter+"]"));
			selectedElement.click();
			elementName = selectedElement.getText();
			System.out.println("Selected Element Name for itemlist "+ counter+"  is  :- "+ elementName);
		}
	}


	public static void main(String[] args) throws InterruptedException {
		driver = driverIntialization(browserName);
		driver.get(url);
		
		QademoSelectable qademosel = new QademoSelectable();
		qademosel.verifyPageTitle(driver);
		qademosel.getAllElementsAndNames(driver);
		tearDown(driver);
		
	}

}