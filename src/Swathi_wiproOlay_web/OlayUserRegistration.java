package Swathi_wiproOlay_web;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Swathi_wiprosdetAssignments.TestBase;

public class OlayUserRegistration extends TestBase {

	//Assignment 2 questions 1 and 2- Swathi
	
	public static WebDriver driver;
	// passing the browser
	static String browserName = "chrome"; // Firefox
	//passing the url
	static String url = "https://www.olay.co.uk/en-gb";
	static String url_de = " https://www.olaz.de/de-de";
	static String url_es = "https://www.olay.es/es-es";
	static String url_ch = " https://www.olay.com.cn/";
	
	// Element loacators in string
	
	String Email = "phdesktopbody_0_grs_account[emails][0][address]";
	String FirstName = "phdesktopbody_0_grs_consumer[firstname]";
	String LastName = "phdesktopbody_0_grs_consumer[lastname]";
	String Password = "phdesktopbody_0_grs_account[password][password]";
	String confirmPassword = "phdesktopbody_0_grs_account[password][confirm]";
	String dobDay ="phdesktopbody_0_grs_consumer[birthdate][day]";
	String dobMonth ="phdesktopbody_0_grs_consumer[birthdate][month]";
	String dobYear ="phdesktopbody_0_grs_consumer[birthdate][year]";
	String country = "phdesktopbody_0_labelgrs_account[addresses][0][country]";
	String StreetAddress = "phdesktopbody_0_labelgrs_account[addresses][0][line1]";
	String Zipcode = "phdesktopbody_0_grs_account[addresses][0][postalarea]";
	String city = "phdesktopbody_0_labelgrs_account[addresses][0][city]";
	String submitButton ="phdesktopbody_0_submit";
	String cookies = "//*[@id='onetrust-accept-btn-handler'][1]";
	String image = "phdesktopbody_0_imgmale";
	String middleName = "phdesktopbody_0_labelgrs_consumer[secondary_lastname]";
	String teleNumber = "phdesktopbody_0_grs_account[phones][0][fulltelephonenumber]";
	String userEmail = "phdesktopbody_0_username"; 
	String userPswd = "phdesktopbody_0_password";
	String signInbutton = "//input[@type ='submit']";
	String validation ="phdesktopbody_0_Message";
	String validatioMessage = "The email and password combination you entered is incorrect. Please try again, or click the link below to create an account.";
	String forgotPaswrd = "phdesktopbody_0_forgotpassword";
	String signLink = "//a[@class='event_profile_login']";
	String logout = "//a[@class ='logoutbtn']";
	String usNameEmail ="swathik.test@gmail.com";
	String usPswd = "test@1234";
	String fName ="Frsabe";
	String lName ="Lrsabe";
	String  mName = "Mrsabe";
	String InvalidusPswd = "test1111";
	
	public void fillSignupFormUK(String url) throws InterruptedException {
		driver = driverIntialization(browserName);
		driver.get(url);
		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.id(Email)).sendKeys(usNameEmail);
		driver.findElement(By.id(Password)).sendKeys(usPswd);
		driver.findElement(By.id(confirmPassword)).sendKeys(usPswd);
		
		driver.findElement(By.xpath(cookies)).click();
		Select selDob = new Select(driver.findElement(By.id(dobDay)));
		selDob.selectByValue("25");
		Select selMonth = new Select(driver.findElement(By.id(dobMonth)));
		selMonth.selectByValue("07");
		Select selYear = new Select(driver.findElement(By.id(dobYear)));
		selYear.selectByValue("1992");
		driver.findElement(By.id(submitButton)).click();
	
		tearDown(driver);
	}
	
	
	public void fillSignupFormDE(String url_de ) throws InterruptedException {
		driver = driverIntialization(browserName);
		driver.get(url_de);
		driver.findElement(By.linkText("Registrieren")).click();
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id(image))).click().build().perform();
		driver.findElement(By.id(FirstName)).sendKeys(fName);
		driver.findElement(By.id(LastName)).sendKeys(lName);
		driver.findElement(By.id(Email)).sendKeys(usNameEmail);
		driver.findElement(By.id(Password)).sendKeys(usPswd);
		driver.findElement(By.id(confirmPassword)).sendKeys(usPswd);
	
		driver.findElement(By.xpath(cookies)).click();
		Select selDob = new Select(driver.findElement(By.id(dobDay)));
		selDob.selectByValue("25");
		Select selMonth = new Select(driver.findElement(By.id(dobMonth)));
		selMonth.selectByValue("07");
		Select selYear = new Select(driver.findElement(By.id(dobYear)));
		selYear.selectByValue("1992");
		
		Select selcountry = new Select(driver.findElement(By.id(country)));
		selcountry.selectByValue("DEU");
		driver.findElement(By.id(StreetAddress)).sendKeys("Street Address");
		driver.findElement(By.id(Zipcode)).sendKeys("125455");
		driver.findElement(By.id(city)).sendKeys("Denf");
		
		driver.findElement(By.id(submitButton)).click();
		tearDown(driver);
	}
	
	public void fillSignupFormES(String url_es ) throws InterruptedException {
		driver = driverIntialization(browserName);
		driver.get(url_es);
		driver.findElement(By.linkText("Registrieren")).click();
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id(image))).click().build().perform();
		driver.findElement(By.id(FirstName)).sendKeys(fName);
		driver.findElement(By.id(LastName)).sendKeys(lName);
		driver.findElement(By.id(middleName)).sendKeys(mName);
		driver.findElement(By.id(Email)).sendKeys(usNameEmail);
		driver.findElement(By.id(Password)).sendKeys(usPswd);
		driver.findElement(By.id(confirmPassword)).sendKeys(usPswd);
	
		driver.findElement(By.xpath(cookies)).click();
		Select selDob = new Select(driver.findElement(By.id(dobDay)));
		selDob.selectByValue("25");
		Select selMonth = new Select(driver.findElement(By.id(dobMonth)));
		selMonth.selectByValue("07");
		Select selYear = new Select(driver.findElement(By.id(dobYear)));
		selYear.selectByValue("1992");
		driver.findElement(By.id(teleNumber)).sendKeys("125454445");
		driver.findElement(By.id(submitButton)).click();
		tearDown(driver);
	}
	
	public void signFunction(String url) throws InterruptedException {

		this.url = url;
		driver = driverIntialization(browserName);
		driver.get(url);
		driver.findElement(By.xpath(signLink)).click();
		driver.findElement(By.id(userEmail)).sendKeys(usNameEmail);
		driver.findElement(By.id(userPswd)).sendKeys(usPswd);
		driver.findElement(By.xpath(signInbutton)).click();
		Thread.sleep(1000);
		System.out.println("Successfully logged");
		driver.findElement(By.xpath(logout)).click();
		tearDown(driver);
	}
	
	public void InvalidsignFunction(String url) throws InterruptedException {
		this.url = url;
		driver = driverIntialization(browserName);
		driver.get(url);
		driver.findElement(By.xpath(signLink)).click();
		driver.findElement(By.id(userEmail)).sendKeys(usNameEmail);
		driver.findElement(By.id(userPswd)).sendKeys(InvalidusPswd);
		driver.findElement(By.xpath(signInbutton)).click();
		String msg = driver.findElement(By.id(validation)).getText();
		validationAssertion(driver,msg);
		forgotPswd(driver);

	}
	
	
	public void  validationAssertion(WebDriver driver , String msg) {
		 if(msg.equalsIgnoreCase(validatioMessage)) {
			 System.out.println("Validation message is matching");
		 }else {
			 System.out.println("Validation message is incorrect");
		 }
		
	}
	
	public void forgotPswd(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		driver.findElement(By.id(forgotPaswrd)).click();
		driver.findElement(By.id(userEmail)).sendKeys(usNameEmail);
		driver.findElement(By.xpath(signInbutton)).click();
		Thread.sleep(1000);
		tearDown(driver);
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
	
		
		OlayUserRegistration olay = new OlayUserRegistration();
		olay.fillSignupFormUK(url);
		olay.fillSignupFormDE(url_de);
		olay.fillSignupFormES(url_es);
		olay.InvalidsignFunction(url);
		olay.InvalidsignFunction(url_de);
		olay.InvalidsignFunction(url_es);
		olay.signFunction(url);
		olay.signFunction(url_de);
		olay.signFunction(url_es);

	}

}
