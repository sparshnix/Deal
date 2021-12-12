package Dealership;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;



public class POM extends Variables {
	
	private static Logger log = LogManager.getLogger(POM.class.getName());

	@SuppressWarnings("deprecation")
	
	public static void Login() throws Exception {

		/*
		 * String projectpath = System.getProperty("user.dir") + File.separator
		 * +"chromedriver.exe" ; System.setProperty("webdriver.chrome.driver",
		 * projectpath); WebDriver driver = new ChromeDriver();
		 */
		// call property class and get the value of browser string from config.properties file
		Property.testProperty();

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		if (browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		log.info("Windows maximized");

		driver.get(url); 
		log.info("URL entered");

		WebElement Username = driver.findElement(By.id("username"));
		Assert.assertTrue(Username.isDisplayed(), "Username field is missing");
		log.info("Username field is visible");
		Username.sendKeys(username);
		
		WebElement Password = driver.findElement(By.id("password"));
		Assert.assertTrue(Password.isDisplayed(), "Password field is missing");
		log.info("Password field is visible");
		Password.sendKeys(password);
		 
		WebElement LoginButton =  driver.findElement(By.id("Login"));
		Assert.assertTrue(LoginButton.isDisplayed(), "Login Button is missing");
		log.info("Login Button is visible");
		LoginButton.sendKeys(Keys.RETURN);
		log.info("Login Button is clicked");
		Thread.sleep(25000);
 
	}

	
	public static void Homepage() throws InterruptedException
	{
		
		WebElement Home = driver.findElement(By.xpath(home));
		Assert.assertTrue(Home.isDisplayed(), "Home icon is missing");
		log.info("Home icon is visible");
		Home.click();
		log.info("Home icon is clicked");
		Assert.assertEquals(driver.getTitle(), "Blackpurl");
		log.info("Title matched, Homepage is displayed");
		Thread.sleep(25000);
		
	}
	
	
	
	
	
	
//	{
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source =ts.getScreenshotAs(OutputType.FILE);
//		String destinationfile =  C:\\Users\\Sparsh\\eclipse-workspace\\DealTest\\Screenshots + testCaseName+ ".png";
//		FileUtils.copyFile(source, new File(destinationfile));
//		
//	}
	
	

}
