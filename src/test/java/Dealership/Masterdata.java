package Dealership;

/**
 * BlackPurl Automation
 * Creation date 17-nov-2021
 * By Sparsh Shrivastava
 */

import java.io.IOException;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.*;

public class Masterdata extends POM {
	
//	public static ExtentReports extent;
//	
//	@BeforeTest
//	public void config()
//	{
//		//ExtentReporters , ExtentSparkReporter
//		String path = System.getProperty("user.dir") + "\\reports\\extentreport.html";
//		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//		reporter.config().setReportName("Blackpurl Automation Results");
//		reporter.config().setDocumentTitle("Blackpurl | Test Result");
//		
//		extent = new ExtentReports();
//		extent.attachReporter(reporter);
//		extent.setSystemInfo("Tester", "Sparsh Shrivastava");
//		
//	}
//	
	@Test
	public static void AddCustomer() throws IOException
	{
		POM.Login();
		Assert.assertTrue(false);
	}
	
	@Test
	public static void Test2() throws IOException
	{
	System.out.println("This is Test2");
	}
}
