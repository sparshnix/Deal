package Dealership;


import static org.testng.Assert.expectThrows;

import java.io.BufferedInputStream;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.apache.pdfbox.*;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripper;
import org.jsoup.select.Evaluator.ContainsText;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

//import TestPackage.Test;
import io.github.bonigarcia.wdm.*;
import org.testng.Reporter;

@Listeners(Dealership.Listeners.class)


public class Schedule extends POM {
	
	@Test(priority = 43)
	public static void CreateEditDeleteAppointment() throws Exception
	
	{		
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(schedule)));
		WebElement Schedule = driver.findElement(By.xpath(schedule));
		Assert.assertTrue(Schedule.isDisplayed(), "Schedule link is missing");
		log.info("Schedule link is visible");
		Schedule.click();
		log.info("Schedule link is clicked");
		
		CreateAppointment();
		EditAppointment();
		DeleteAppointment();
		
	}
	

	
	
	
}
