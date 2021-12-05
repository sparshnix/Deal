package Dealership;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class POM extends Variables {
	
	private static Logger log = LogManager.getLogger(POM.class.getName());

	@SuppressWarnings("deprecation")
	
	public static void Login() throws IOException {

		/*
		 * String projectpath = System.getProperty("user.dir") + File.separator
		 * +"chromedriver.exe" ; System.setProperty("webdriver.chrome.driver",
		 * projectpath); WebDriver driver = new ChromeDriver();
		 */

		// call property class and get the value of browser string from
		// config.properties file
		Property.testProperty();

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		if (browser.equalsIgnoreCase("IEDriver")) {
			WebDriverManager.iedriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		log.info("Windows maximized");
		System.out.println("Windows is maximized");

		driver.get(url); // url gets its value from config.properties file via Property class
		log.info("URL entered");
		System.out.println("URL Entered");

		WebElement Username = driver.findElement(By.id("username"));
		Assert.assertTrue(Username.isDisplayed(), "Username field is missing");
		log.info("Username field is visible");
		System.out.println("Username field is visible");
		Username.sendKeys(username);
		
		WebElement Password = driver.findElement(By.id("password"));
		Assert.assertTrue(Password.isDisplayed(), "Password field is missing");
		log.info("Password field is visible");
		System.out.println("Password field is visible");
		Password.sendKeys(password);
		 
		WebElement LoginButton =  driver.findElement(By.id("Login"));
		Assert.assertTrue(LoginButton.isDisplayed(), "Login Button is missing");
		log.info("Login Button is visible");
		System.out.println("Login Button is visible");
		LoginButton.sendKeys(Keys.RETURN);
		System.out.println("Login button is clicked");
		
		 
		 String Actual = driver.getTitle(); 
		 System.out.println(Actual); 
		 String	Expected = "Blackpurl";
		 
		 if(Actual.equalsIgnoreCase(Expected)) 
		 {
			 log.info("Title Matched");
			 System.out.println("Title Matched");
		 }
		 else 
		 {
			 log.info("Title not Matched");
			 System.out.println("Title not Matched"); 
		 }
		 
		
	}

}
