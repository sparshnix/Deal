package Dealership;

/**
 * BlackPurl Automation
 * Creation date 7-dec-2021
 * By Sparsh Shrivastava
 */

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

public class AusOnTaxClass4 extends POM	
{
	@Test(priority = 73)
	public static void ChangeandDeleteCustomerTax() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
		WebElement Sell = driver.findElement(By.xpath(sell));
		Assert.assertTrue(Sell.isDisplayed(), "Sell link is missing");
		log.info("Sell link is visible");
		Sell.click();
		log.info("Sell link is clickable");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectcustomerdropdown)));
		WebElement SelectCustomerDropdown = driver.findElement(By.xpath(selectcustomerdropdown));
		Assert.assertTrue(SelectCustomerDropdown.isDisplayed(), "Select Customer Dropdown is missing");
		log.info("Select Customer Dropdown is visible");
		SelectCustomerDropdown.click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocompleteCustomer")));
		WebElement SelectCustomerField = driver.findElement(By.id("autocompleteCustomer"));
		Assert.assertTrue(SelectCustomerField.isDisplayed(), "Select Customer Field is missing");
		log.info("Select Customer Field is visible");
		SelectCustomerField.sendKeys("Automation Customer1");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerInfo_0")));
		WebElement CustomerInfo = driver.findElement(By.id("customerInfo_0"));
		Assert.assertTrue(CustomerInfo.isDisplayed(), "CustomerInfo is missing");
		log.info("CustomerInfo is visible");
		CustomerInfo.click();
		Thread.sleep(10000);

		if(driver.findElement(By.xpath(activeorders)).isDisplayed()) 
		{
			driver.findElement(By.xpath(activeorderbutton)).click();
			Thread.sleep(10000);
		}

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customerHeader)));
		WebElement CustomerHeader = driver.findElement(By.xpath(customerHeader));
		Assert.assertTrue(CustomerHeader.isDisplayed(), "Customer Header is missing");
		log.info("Customer Header is visible");
		CustomerHeader.click();
		log.info("Customer Header is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customerName)));
		WebElement CustomerName1 = driver.findElement(By.xpath(customerName));
		Assert.assertEquals(CustomerName1.getText(), "Automation Customer1");
		log.info("New Customer Name is correctly displayed");
	
		WebElement PriceLevel1 = driver.findElement(By.xpath(priceLevel));
		Assert.assertTrue(PriceLevel1.isDisplayed(), "Price level is missing");
		String Customer1Pricelevel = PriceLevel1.getText();
		log.info("Customer1 Pricelevel is " +Customer1Pricelevel);
		
		WebElement TaxExemption1 = driver.findElement(By.xpath(taxExemption1));
		Assert.assertTrue(TaxExemption1.isDisplayed(), "Tax Exemption is missing");
		String Cuatomer1TaxExemption = TaxExemption1.getText();
		log.info("Tax Exemption is " +Cuatomer1TaxExemption);
		
		WebElement SellPartandAccs = driver.findElement(By.xpath(sellpartandaccs));
		Assert.assertTrue(SellPartandAccs.isDisplayed(), "SellPartandAccs button is missing");
		log.info("SellPartandAccs button is visible");
		SellPartandAccs.click();
		log.info("SellPartandAccs button is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocompleteMerchandiseSectionWrapperId")));
		WebElement Searchbox = driver.findElement(By.id("autocompleteMerchandiseSectionWrapperId"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		log.info("Searchbox is visible");
		
		Searchbox.sendKeys("Merchandise_Tax");
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityInfo_0")));
		WebElement Merchentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Merchentity.isDisplayed(), "Merchentity is missing");
		log.info("Merchentity is visible");
		Merchentity.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(merchandiseSectionId)).click();
		Thread.sleep(10000);
		
		WebElement CheckoutTotal1 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal1.getText().contains("110"),"CheckoutTotal is missing");
		log.info("The Amount for Automation Customer1 has been captured successfully");

		JavascriptExecutor executer1 = (JavascriptExecutor)driver;
		executer1.executeScript("window.scrollBy(0,-550)", "");
		
		CustomerHeader.click();
		log.info("Customer Header is clicked");
		Thread.sleep(5000);
		
		WebElement ChangeCustomerButton = driver.findElement(By.xpath(changeCustomerButton));
		Assert.assertTrue(ChangeCustomerButton.isDisplayed(), "Change Customer Button is missing");
		log.info("Change Customer Button is visible");
		ChangeCustomerButton.click();
		log.info("Change Customer Button is clicked");
	
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("autocompleteCustomer")));
		WebElement CustomerSearchbox2 = driver.findElement(By.id("autocompleteCustomer"));
		Assert.assertTrue(CustomerSearchbox2.isDisplayed(), "Customer Searchbox is missing");
		log.info("Customer Searchbox is visible");
		CustomerSearchbox2.sendKeys(Keys.chord(Keys.CONTROL,"a"), "Automation Customer2");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerInfo_0")));
		WebElement CustomerInfo2 = driver.findElement(By.id("customerInfo_0"));
		Assert.assertTrue(CustomerInfo2.isDisplayed(), "CustomerInfo is missing");
		log.info("CustomerInfo is visible");
		CustomerInfo2.click();

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customerWarning)));
		WebElement Warning2 = driver.findElement(By.xpath(warning1));
		Assert.assertEquals(Warning2.getText(), "Pricing may need to be recalculated");
		log.info("Warning is correctly displayed");
		
		Thread.sleep(5000);
		WebElement Confirm2 = driver.findElement(By.xpath(confirm));
		Assert.assertTrue(Confirm2.isDisplayed(), "Confirm Button is missing");
		log.info("Confirm Button is visible");
		Confirm2.click();
		log.info("Confirm Button is clicked");
		Thread.sleep(15000);
		
		WebElement CheckoutTotal2 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal2.getText().contains("105"),"CheckoutTotal is missing");
		log.info("The Amount for Automation Customer2 has been captured successfully");
		
		WebElement CustomerHeader2 = driver.findElement(By.xpath(customerHeader));
		Assert.assertTrue(CustomerHeader2.isDisplayed(), "Customer Header is missing");
		log.info("Customer Header is visible");
		CustomerHeader2.click();
		log.info("Customer Header is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deleteButton)));
		WebElement DeleteButton = driver.findElement(By.xpath(deleteButton));
		Assert.assertTrue(DeleteButton.isDisplayed(), "Delete Button is missing");
		log.info("Delete Button is visible");
		DeleteButton.click();
		log.info("Delete Button is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customerWarning)));
		WebElement Warning = driver.findElement(By.xpath(warning1));
		Assert.assertEquals(Warning.getText(), "Pricing may need to be recalculated");
		log.info("Warning is correctly displayed");
		
		Thread.sleep(5000);
		WebElement Confirm = driver.findElement(By.xpath(confirm));
		Assert.assertTrue(Confirm.isDisplayed(), "Confirm Button is missing");
		log.info("Confirm Button is visible");
		Confirm.click();
		log.info("Confirm Button is clicked");
		Thread.sleep(15000);

		
		WebElement CheckoutTotal3 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal3.getText().contains("110"),"CheckoutTotal is missing");
		log.info("The Amount for No Customer has been captured successfully");

		

	}
	

}
