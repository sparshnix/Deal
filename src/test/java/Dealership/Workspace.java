package Dealership;

/**
 * BlackPurl Automation
 * Creation date 7-dec-2021
 * By Sparsh Shrivastava
 */

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
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
import io.github.bonigarcia.wdm.*;
import org.testng.Reporter;

@Listeners(Dealership.Listeners.class)

public class Workspace extends POM {
	
	
	@Test(priority = 8)
	public static void StoreSummary() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver,100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(storesummary)));
		WebElement StoreSummaryTab = driver.findElement(By.xpath(storesummary));
		Assert.assertTrue(StoreSummaryTab.isDisplayed(), "Store Summary tab is missing");
		log.info("Store Summary tab is visible");

		WebElement Today = driver.findElement(By.xpath(today));
		Assert.assertTrue(Today.isDisplayed(), "Today link is missing");
		log.info("Today link is visible");
		Assert.assertTrue(Today.isEnabled(), "Today link is grayed out");
		Today.click();
		log.info("Today link is clickable");

		
		WebElement Last_7_Days = driver.findElement(By.xpath(last_7_days));
		Assert.assertTrue(Last_7_Days.isDisplayed(), "Last_7_Days link is missing");
		log.info("Last_7_Days link is visible");
		Assert.assertTrue(Last_7_Days.isEnabled(), "Last_7_Days link is grayed out");
		Last_7_Days.click();
		log.info("Last_7_Days link is clickable");
		

		WebElement Last_30_Days = driver.findElement(By.xpath(last_30_days));
		Assert.assertTrue(Last_30_Days.isDisplayed(), "Last_30_Days link is missing");
		log.info("Last_30_Days link is visible");
		Assert.assertTrue(Last_30_Days.isEnabled(), "Last_30_Days link is grayed out");
		Last_30_Days.click();
		log.info("Last_30_Days link is clickable");

	
		WebElement Invoices = driver.findElement(By.xpath(invoices));
		Assert.assertTrue(Invoices.isDisplayed(), "Invoices link is missing");
		log.info("Invoices link is visible");
		Invoices.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchtag1)));
		log.info("The page title is - " +driver.getTitle() );
		Assert.assertEquals(driver.getTitle(), "Advanced Search");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchtag1)));

		WebElement Searchtag1 = driver.findElement(By.xpath(searchtag1));
		Assert.assertTrue(Searchtag1.isDisplayed(), "Search tag is missing");
		log.info("Search tag is visible");
		Assert.assertEquals(Searchtag1.getText(), "Customer Invoice");
		log.info("The Invoice link has redirected to correct page");
		
		driver.navigate().back();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(payments)));

		WebElement Payments = driver.findElement(By.xpath(payments));
		Assert.assertTrue(Payments.isDisplayed(), "Payments link is missing");
		log.info("Payments link is visible");
		Payments.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchtag1)));
		log.info("The page title is - " +driver.getTitle() );
		Assert.assertEquals(driver.getTitle(), "Advanced Search");

		WebElement Searchtag2 = driver.findElement(By.xpath(searchtag1));
		Assert.assertTrue(Searchtag2.isDisplayed(), "Search tag is missing");
		log.info("Search tag is visible");
		Assert.assertEquals(Searchtag2.getText(), "Customer Payment");
		log.info("The Payments link has redirected to correct page");
		
		driver.navigate().back();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(new_customers)));
		
		WebElement New_Customers = driver.findElement(By.xpath(new_customers));
		Assert.assertTrue(New_Customers.isDisplayed(), "New Customers link is missing");
		log.info("New Customers link is visible");
		New_Customers.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchtag1)));
		log.info("The page title is - " +driver.getTitle() );
		Assert.assertEquals(driver.getTitle(), "Advanced Search");
		Thread.sleep(10000);

		WebElement Searchtag3 = driver.findElement(By.xpath(searchtag1));
		Assert.assertTrue(Searchtag3.isDisplayed(), "Search tag is missing");
		log.info("Search tag is visible");
		Assert.assertEquals(Searchtag3.getText(), "Customer");
		log.info("The New Customers link has redirected to correct page");

		
	}

	@Test(priority = 9)
	public static void ServiceJobs() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver,100);
		WebElement ServiceJobsTab = driver.findElement(By.xpath(servicejobs));
		Assert.assertTrue(ServiceJobsTab.isDisplayed(), "Store Summary tab is missing");
		log.info("Service Jobs tab is visible");

		
		WebElement Customerpay = driver.findElement(By.xpath(customerpay));
		//*[@id="BP_Home_NavBarListId_1"]/li[1]/a/p
		Assert.assertTrue(Customerpay.isDisplayed(), "Customerpay link is missing");
		log.info("Customerpay link is visible");
		Assert.assertTrue(Customerpay.isEnabled(), "Customerpay link is grayed out");
		Customerpay.click();
		log.info("Customerpay link is clickable");

		
		WebElement ThirdParty = driver.findElement(By.xpath(thirdparty));
		Assert.assertTrue(ThirdParty.isDisplayed(), "ThirdParty link is missing");
		log.info("ThirdParty link is visible");
		Assert.assertTrue(ThirdParty.isEnabled(), "ThirdParty link is grayed out");
		ThirdParty.click();
		log.info("ThirdParty link is clickable");
		

		WebElement Internal = driver.findElement(By.xpath(internal));
		Assert.assertTrue(Internal.isDisplayed(), "Internal link is missing");
		log.info("Internal link is visible");
		Assert.assertTrue(Internal.isEnabled(), "Internal link is grayed out");
		Internal.click();
		log.info("Internal link is clickable");
		
		WebElement Deal = driver.findElement(By.xpath(deal));
		Assert.assertTrue(Deal.isDisplayed(), "Deal link is missing");
		log.info("Deal link is visible");
		Assert.assertTrue(Deal.isEnabled(), "Deal link is grayed out");
		Deal.click();
		log.info("Deal link is clickable");
		Thread.sleep(5000);

	
		WebElement New_link = driver.findElement(By.xpath(new_link));
		Assert.assertTrue(New_link.isDisplayed(), "New link is missing");
		log.info("New link is visible");
		New_link.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchtag2)));
		log.info("The page title is - " +driver.getTitle() );
		Assert.assertEquals(driver.getTitle(), "Advanced Search");
		
		WebElement Searchtag1 = driver.findElement(By.xpath(searchtag2));			
		Assert.assertTrue(Searchtag1.isDisplayed(), "Search tag is missing");
		log.info("Search tag is visible");
		Assert.assertEquals(Searchtag1.getText(), "New");
		log.info("The New link has redirected to correct page");
		
		driver.navigate().back();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(active)));
		
		WebElement Active = driver.findElement(By.xpath(active));
		Assert.assertTrue(Active.isDisplayed(), "Active link is missing");
		log.info("Active link is visible");
		Active.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchtag2)));
		log.info("The page title is - " +driver.getTitle() );
		Assert.assertEquals(driver.getTitle(), "Advanced Search");

		WebElement Searchtag2 = driver.findElement(By.xpath(searchtag2));			
		Assert.assertTrue(Searchtag2.isDisplayed(), "Search tag is missing");
		log.info("Search tag is visible");
		Assert.assertEquals(Searchtag2.getText(), "Active");
		log.info("The Active link has redirected to correct page");
		
		driver.navigate().back();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(completed)));
		
		WebElement Completed = driver.findElement(By.xpath(completed));
		Assert.assertTrue(Completed.isDisplayed(), "New Customers link is missing");
		log.info("New Customers link is visible");
		Completed.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchtag2)));
		log.info("The page title is - " +driver.getTitle() );
		Assert.assertEquals(driver.getTitle(), "Advanced Search");

		WebElement Searchtag3 = driver.findElement(By.xpath(searchtag2));			
		Assert.assertTrue(Searchtag3.isDisplayed(), "Search tag is missing");
		log.info("Search tag is visible");
		Assert.assertEquals(Searchtag3.getText(), "Complete");
		log.info("The Completed link has redirected to correct page");

		
	}
	
	@Test(priority = 10)
	public static void Vendor_Orders() throws Exception
	
	{
		WebDriverWait wt = new WebDriverWait(driver,100);
		WebElement Vendor_Orders = driver.findElement(By.xpath(vendor_orders));
		Assert.assertTrue(Vendor_Orders.isDisplayed(), "Vendor_Orders tab is missing");
		log.info("Vendor_Orders tab is visible");
		
		
		WebElement Active_Orders = driver.findElement(By.xpath(active_orders1));
		Assert.assertTrue(Active_Orders.isDisplayed(), "Active_Orders link is missing");
		log.info("Active_Orders link is visible");
		Active_Orders.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchtag2)));
		log.info("The page title is - " +driver.getTitle() );
		Assert.assertEquals(driver.getTitle(), "Advanced Search");

		
		WebElement Searchtag1 = driver.findElement(By.xpath(searchtag2));
		Assert.assertTrue(Searchtag1.isDisplayed(), "Search tag is missing");
		log.info("Search tag is visible");
		Assert.assertEquals(Searchtag1.getText(), "Active");
		log.info("The Invoice link has redirected to correct page");
		
		driver.navigate().back();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(active_receiving)));
		
		WebElement Active_Receiving = driver.findElement(By.xpath(active_receiving));
		Assert.assertTrue(Active_Receiving.isDisplayed(), "Active_Receiving link is missing");
		log.info("Active_Receiving link is visible");
		Active_Receiving.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchtag2)));
		log.info("The page title is - " +driver.getTitle() );
		Assert.assertEquals(driver.getTitle(), "Advanced Search");

		WebElement Searchtag2 = driver.findElement(By.xpath(searchtag2));
		Assert.assertTrue(Searchtag2.isDisplayed(), "Search tag is missing");
		log.info("Search tag is visible");
		Assert.assertEquals(Searchtag2.getText(), "In Progress");
		log.info("The Payments link has redirected to correct page");
		
		driver.navigate().back();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parts_needed)));
		
		WebElement Parts_needed = driver.findElement(By.xpath(parts_needed));
		Assert.assertTrue(Parts_needed.isDisplayed(), "Parts_needed link is missing");
		log.info("Parts_needed link is visible");
		Parts_needed.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchtag2)));
		log.info("The page title is - " +driver.getTitle() );
		Assert.assertEquals(driver.getTitle(), "Advanced Search");

		WebElement Searchtag3 = driver.findElement(By.xpath(searchtag3));
		Assert.assertTrue(Searchtag3.isDisplayed(), "Search tag is missing");
		log.info("Search tag is visible");
		Assert.assertEquals(Searchtag3.getText(), "Part Needed");
		log.info("The New Customers link has redirected to correct page");

		
		
	}
	
	@Test(priority = 11)
	public static void Customer_Orders() throws Exception
	
	{
		WebDriverWait wt = new WebDriverWait(driver,100);
		WebElement Customer_Orders = driver.findElement(By.xpath(customer_orders));
		Assert.assertTrue(Customer_Orders.isDisplayed(), "Customer_Orders tab is missing");
		log.info("Customer_Orders tab is visible");
		
		
		WebElement Active_Orders = driver.findElement(By.xpath(active_orders2));
		Assert.assertTrue(Active_Orders.isDisplayed(), "Active_Orders link is missing");
		log.info("Active_Orders link is visible");
		Active_Orders.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchtag2)));
		log.info("The page title is - " +driver.getTitle() );
		Assert.assertEquals(driver.getTitle(), "Advanced Search");

		
		WebElement Searchtag1 = driver.findElement(By.xpath(searchtag2));
		Assert.assertTrue(Searchtag1.isDisplayed(), "Search tag is missing");
		log.info("Search tag is visible");
		Assert.assertEquals(Searchtag1.getText(), "Open");
		log.info("The Invoice link has redirected to correct page");
		
		driver.navigate().back();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deposits)));
		
		WebElement Deposits = driver.findElement(By.xpath(deposits));
		Assert.assertTrue(Deposits.isDisplayed(), "Deposits link is missing");
		log.info("Deposits link is visible");
		Deposits.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchtag2)));
		log.info("The page title is - " +driver.getTitle() );
		Assert.assertEquals(driver.getTitle(), "Advanced Search");

		WebElement Searchtag2 = driver.findElement(By.xpath(searchtag4));
		Assert.assertTrue(Searchtag2.isDisplayed(), "Search tag is missing");
		log.info("Search tag is visible");
		Assert.assertEquals(Searchtag2.getText(), "Not Equal To 0");
		log.info("The Payments link has redirected to correct page");
		
		driver.navigate().back();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(balance_due)));
		
		WebElement Balance_Due = driver.findElement(By.xpath(balance_due));
		Assert.assertTrue(Balance_Due.isDisplayed(), "Balance_Due link is missing");
		log.info("Balance_Due link is visible");
		Balance_Due.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchtag2)));
		log.info("The page title is - " +driver.getTitle() );
		Assert.assertEquals(driver.getTitle(), "Advanced Search");

		WebElement Searchtag3 = driver.findElement(By.xpath(searchtag4));
		Assert.assertTrue(Searchtag3.isDisplayed(), "Search tag is missing");
		log.info("Search tag is visible");
		Assert.assertEquals(Searchtag3.getText(), "Not Equal To 0");
		log.info("The New Customers link has redirected to correct page");

		
		
	}
	
	@Test(priority = 12)
	public static void Activity_Feed() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver,100);
		WebElement Activity_Feed = driver.findElement(By.xpath(activity_feed));
		Assert.assertTrue(Activity_Feed.isDisplayed(), "Activity_Feed tab is missing");
		log.info("Activity_Feed tab is visible");
		
		WebElement MyActivity = driver.findElement(By.xpath(myactivity));
		Assert.assertTrue(MyActivity.isDisplayed(), "MyActivity link is missing");
		log.info("MyActivity link is visible");
		Assert.assertTrue(MyActivity.isEnabled(), "MyActivity link is grayed out");
		MyActivity.click();
		log.info("MyActivity link is clickable");
		
		WebElement StoreActivity = driver.findElement(By.xpath(storeactivity));
		Assert.assertTrue(StoreActivity.isDisplayed(), "StoreActivity link is missing");
		log.info("StoreActivity link is visible");
		Assert.assertTrue(StoreActivity.isEnabled(), "StoreActivity link is grayed out");
		StoreActivity.click();
		log.info("StoreActivity link is clickable");
		
	}
	
	
	
}
