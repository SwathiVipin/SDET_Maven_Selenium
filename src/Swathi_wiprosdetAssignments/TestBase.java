package Swathi_wiprosdetAssignments;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class TestBase {

	
	public static WebDriver driver;
	private static final long SECONDS = 5;
	// Initialise Driver
	String popup=null;
	
	public static WebDriver  driverIntialization(String browserName){
		
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",".//Drivers//chromedriver.exe");
			 ChromeOptions options  = new ChromeOptions();
			    //options.addArguments("incognito");
			    options.addArguments("--disable-popup-blocking");
			    DesiredCapabilities capabilities = new DesiredCapabilities();
			    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			   // driver = new ChromeDriver(capabilities)
			    driver = new ChromeDriver(capabilities);
		}else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.firefox.driver", "./Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}else{
			System.setProperty("webdriver.ie.driver",".//Drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(1000,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

		return driver;
	}
	
	// Date formating
	public static int  dateFormater(String uiCalMonth) throws ParseException {
		SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM");
		Calendar cal = Calendar.getInstance();
		cal.setTime(inputFormat.parse(uiCalMonth));
		SimpleDateFormat outputFormat = new SimpleDateFormat("MM"); // 01-12
		//System.out.println(outputFormat.format(cal.getTime()));
		int currentMonth = Integer.parseInt(outputFormat.format(cal.getTime()));
		//System.out.println(currentMonth);
		return currentMonth;
	}
	

	public void waitLoader(WebDriver driver, String popup) {
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>( driver)
				.withTimeout(Duration.ofSeconds(SECONDS))
				.pollingEvery(Duration.ofSeconds(SECONDS))
				.ignoring(Exception.class);
		WebElement popuclosebutton = wait.until(new Function<WebDriver, WebElement>(){
			
			public WebElement apply(WebDriver driver ) {
				return driver.findElement(By.xpath(popup));
			}
		});
		popuclosebutton.click();
		System.out.println("We clicked the popUp");
	}
	
	// closing the  browser
	public static void tearDown(WebDriver driver) throws InterruptedException {
		Thread.sleep(500);
		driver.quit();
	}
	
}
