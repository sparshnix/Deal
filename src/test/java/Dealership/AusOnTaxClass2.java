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

public class AusOnTaxClass2 extends POM	
{
	
	@Test(priority = 70)
	public static void ServicejobTax() throws Exception
	{
		SelectCustomer2();
		WebDriverWait wt = new WebDriverWait(driver, 100);		
		WebElement ServiceJob = driver.findElement(By.xpath(servicejob));
		Assert.assertTrue(ServiceJob.isDisplayed(), "ServiceJob button is missing");
		log.info("ServiceJob button is visible");
		ServiceJob.click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(servicejobstatus)));
		WebElement ServiceJobStatus1 = driver.findElement(By.xpath(servicejobstatus));
		Assert.assertTrue(ServiceJobStatus1.isDisplayed(), "ServiceJobStatus is missing");
		log.info("ServiceJobStatus is visible");
		log.info("ServiceJobStatus is " +ServiceJobStatus1.getText());
		Assert.assertEquals(ServiceJobStatus1.getText(), "Status: New");

		WebElement ServiceJobDetails = driver.findElement(By.xpath(servicejobdetails));
		wt.until(ExpectedConditions.visibilityOf(ServiceJobDetails));
		Assert.assertTrue(ServiceJobDetails.isDisplayed(), "ServiceJobDetails is missing");
		log.info("ServiceJobDetails is visible");
		ServiceJobDetails.click();
		log.info("ServiceJobDetails is clicked");
		Thread.sleep(5000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addcustomerunit)));
		WebElement AddCustomerUnit = driver.findElement(By.xpath(addcustomerunit));
		AddCustomerUnit.click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tempUnitMmodalWindow)));
		Thread.sleep(5000);
		WebElement TempUnitMmodalWindow = driver.findElement(By.xpath(tempUnitMmodalWindow));
		Assert.assertEquals(TempUnitMmodalWindow.getText(), "ADD A NEW CUSTOMER OWNED UNIT");
		log.info("Temp Unit Mmodal Window  is visible");

		WebElement VIN_Unit = driver.findElement(By.id("VIN_Unit"));
		Assert.assertTrue(VIN_Unit.isDisplayed(), "VIN_Unit field is missing");
		log.info("VIN_Unit field is visible");
		
		WebElement MakeUnitOrdering = driver.findElement(By.id("MakeUnitOrdering"));
		Assert.assertTrue(MakeUnitOrdering.isDisplayed(), "Make field is missing");
		log.info("Make field is visible");
		int num = random.nextInt(1000);
		MakeUnitOrdering.sendKeys("Make" +num);
		log.info("Make is filed");
		
		WebElement ModelUnitOrdering = driver.findElement(By.id("ModelUnitOrdering"));
		Assert.assertTrue(ModelUnitOrdering.isDisplayed(), "Model field is missing");
		log.info("Model field is visible");
		ModelUnitOrdering.sendKeys("Model" +num);
		log.info("Model is filed");
		
		WebElement SubModelUnitOrdering = driver.findElement(By.id("SubModelUnitOrdering"));
		Assert.assertTrue(SubModelUnitOrdering.isDisplayed(), "Sun-Model field is missing");
		log.info("Sub-Model field is visible");
		SubModelUnitOrdering.sendKeys("SubModel" +num);
		log.info("Sub-Model is filed");
		
		WebElement YearAddEditUnit = driver.findElement(By.id("YearAddEditUnit"));
		Assert.assertTrue(YearAddEditUnit.isDisplayed(), "Year field is missing");
		log.info("Year field is visible");
		YearAddEditUnit.sendKeys("2022");
		log.info("Year is filed");
		
		WebElement Addbutton = driver.findElement(By.xpath(addbutton));
		Assert.assertTrue(Addbutton.isDisplayed(), "Addbutton is missing");
		log.info("Addbutton is visible");
		Addbutton.click();
		log.info("Addbutton is clicked");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customerownedunit)));
		WebElement Customerownedunit = driver.findElement(By.xpath(customerownedunit));
		Assert.assertTrue(Customerownedunit.isDisplayed(), "Customerownedunit is missing");
		log.info(Customerownedunit.getText()+ " is visible");
		
		WebElement Concern = driver.findElement(By.id("Concern0"));
		Assert.assertTrue(Concern.isDisplayed(), "Concern field is missing");
		log.info("Concern field is visible");
		Concern.sendKeys("Break loose");
		log.info("Concern field is filled");

		WebElement Cause = driver.findElement(By.id("Cause0"));
		Assert.assertTrue(Cause.isDisplayed(), "Cause field is missing");
		log.info("Cause field is visible");
		Cause.sendKeys("Long drive");
		log.info("Cause field is filled");

		
		WebElement Correction = driver.findElement(By.id("Correction0"));
		Assert.assertTrue(Correction.isDisplayed(), "Correction field is missing");
		log.info("Correction field is visible");
		Correction.sendKeys("Fix breaks");
		log.info("Correction field is filled");

		WebElement Odometer_on_arrival = driver.findElement(By.xpath(odometer_on_arrival));
		Assert.assertTrue(Odometer_on_arrival.isDisplayed(), "Odometer_on_arrival field is missing");
		log.info("Odometer_on_arrival field is visible");
		Odometer_on_arrival.sendKeys(Keys.chord(Keys.CONTROL,"a"), "6000");
		log.info("Odometer_on_arrival field is filled");

		WebElement Odometer_on_departure = driver.findElement(By.xpath(odometer_on_departure));
		Assert.assertTrue(Odometer_on_departure.isDisplayed(), "Odometer_on_departure field is missing");
		log.info("Odometer_on_departure field is visible");
		Odometer_on_departure.sendKeys(Keys.chord(Keys.CONTROL,"a"), "6100");
		log.info("Odometer_on_departure field is filled");
		
		
		WebElement LPJItems = driver.findElement(By.xpath(lpjItems));
		LPJItems.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocompleteServiceJob0")));
		WebElement Searchbox1 = driver.findElement(By.id("autocompleteServiceJob0"));
		Assert.assertTrue(Searchbox1.isDisplayed(), "Searchbox is missing");
		log.info("Searchbox is visible");
		
		Searchbox1.sendKeys("Merchandise_Tax");
		Thread.sleep(10000);
		
		WebElement Merchentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Merchentity.isDisplayed(), "Merchentity is missing");
		log.info("Merchentity is visible");
		Merchentity.click();
		Thread.sleep(10000);

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkoutTotal)));
		WebElement CheckoutTotal1 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal1.getText().contains("110"), "CheckoutTotal is missing");
		log.info("The Amount for Merchandise has been captured successfully");
		
		driver.findElement(By.xpath(searchentitytext)).click();
		Thread.sleep(10000);
		
		WebElement Searchbox2 = driver.findElement(By.id("autocompleteServiceJob0"));
		Searchbox2.sendKeys("Fee_Tax");
		Thread.sleep(10000);
		
		WebElement Feeentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Feeentity.isDisplayed(), "Feeentity is missing");
		log.info("Feeentity is visible");
		Feeentity.click();
		Thread.sleep(20000);		

		WebElement CheckoutTotal2 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal2.getText().contains("210"),"CheckoutTotal is missing");
		log.info("The Amount for Fee has been captured successfully");
		
		driver.findElement(By.xpath(searchentitytext)).click();
		Thread.sleep(10000);
		
		WebElement Searchbox3 = driver.findElement(By.id("autocompleteServiceJob0"));
		Searchbox3.sendKeys("Kit_Tax");
		Thread.sleep(10000);
		
		WebElement Kitentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Kitentity.isDisplayed(), "Kitentity is missing");
		log.info("Kitentity is visible");
		Kitentity.click();
		Thread.sleep(20000);
		
		WebElement CheckoutTotal3 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal3.getText().contains("320"),"CheckoutTotal is missing");
		log.info("The Amount for Kit has been captured successfully");
	

		driver.findElement(By.xpath(searchentitytext)).click();
		Thread.sleep(10000);
		
		WebElement Searchbox4 = driver.findElement(By.id("autocompleteServiceJob0"));
		Searchbox4.sendKeys("Labor_Tax");
		Thread.sleep(10000);
		
		WebElement Laborentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Laborentity.isDisplayed(), "Laborentity is missing");
		log.info("Laborentity is visible");
		Laborentity.click();
		Thread.sleep(20000);
		
		WebElement CheckoutTotal4 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal4.getText().contains("420"),"CheckoutTotal is missing");
		log.info("The Amount for labor has been captured successfully");
	
		
		driver.findElement(By.xpath(searchentitytext)).click();
		Thread.sleep(10000);
		
		WebElement Searchbox5 = driver.findElement(By.id("autocompleteServiceJob0"));
		Searchbox5.sendKeys("Sublet_Tax");
		Thread.sleep(10000);
		
		WebElement Subletentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Subletentity.isDisplayed(), "Subletentity is missing");
		log.info("Subletentity is visible");
		Subletentity.click();
		Thread.sleep(20000);
		
		WebElement CheckoutTotal5 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal5.getText().contains("520"),"CheckoutTotal is missing");
		log.info("The Amount for Sublet has been captured successfully");
		
		driver.findElement(By.xpath(searchentitytext)).click();
		Thread.sleep(10000);
		
		WebElement ServiceJobDetails2 = driver.findElement(By.xpath(servicejobdetails));
		wt.until(ExpectedConditions.visibilityOf(ServiceJobDetails2));
		Assert.assertTrue(ServiceJobDetails2.isDisplayed(), "ServiceJobDetails is missing");
		log.info("ServiceJobDetails is visible");
		ServiceJobDetails2.click();
		log.info("ServiceJobDetails is clicked");
		Thread.sleep(5000);

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("ServiceJob0_jobTypeInput")));
		WebElement TranactionType = driver.findElement(By.id("ServiceJob0_jobTypeInput"));
		Assert.assertTrue(TranactionType.isDisplayed(), "TranactionType is missing");
		log.info("TranactionType is visible");
		TranactionType.click();
		log.info("TranactionType is clicked");


		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Internal_Tax')]")));
		WebElement Internaltype = driver.findElement(By.xpath("//div[contains(text(), 'Internal_Tax')]"));
		Assert.assertTrue(Internaltype.isDisplayed(), "Internaltype is missing");
		log.info("Internaltype is visible");
		Internaltype.click();
		log.info("Internaltype is clicked");
		
//		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("ServiceJob0_categoryInput")));
//		WebElement Categorytype = driver.findElement(By.id("ServiceJob0_categoryInput"));
//		Assert.assertTrue(Categorytype.isDisplayed(), "Categorytype is missing");
//		log.info("Categorytype is visible");
//		Categorytype.click();
//		log.info("Categorytype is clicked");
//
//		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Internal Category')]")));
//		WebElement CategoryInput = driver.findElement(By.xpath("//div[contains(text(),'Internal Category')]"));
//		Assert.assertTrue(CategoryInput.isDisplayed(), "CategoryInput is missing");
//		log.info("CategoryInput is visible");
//		CategoryInput.click();
//		log.info("CategoryInput is clicked");
//		Thread.sleep(5000);
		
		JavascriptExecutor ex1 = (JavascriptExecutor) driver;
		ex1.executeScript("window.scrollBy(0,-200)", "");
		
		WebElement RecalculateIcon = driver.findElement(By.xpath("//span[contains(text(),'Recalculate')]"));
		Assert.assertTrue(RecalculateIcon.isDisplayed(), "RecalculateIcon is missing");
		log.info("RecalculateIcon is visible");
		RecalculateIcon.click();
		log.info("RecalculateIcon is clicked");
		Thread.sleep(20000);
		

		WebElement CheckoutTotal6 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal6.getText().contains("472.73"),"CheckoutTotal is missing");
		log.info("The Amount for Internal transaction type has been captured successfully");
		
		driver.navigate().refresh();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(servicejobdetails)));
		Thread.sleep(5000);
		WebElement ServiceJobDetails3 = driver.findElement(By.xpath(servicejobdetails));
		Assert.assertTrue(ServiceJobDetails3.isDisplayed(), "ServiceJobDetails is missing");
		log.info("ServiceJobDetails is visible");
		ServiceJobDetails3.click();
		log.info("ServiceJobDetails is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("ServiceJob0_jobTypeInput")));
		WebElement TranactionType2 = driver.findElement(By.id("ServiceJob0_jobTypeInput"));
		Assert.assertTrue(TranactionType2.isDisplayed(), "TranactionType is missing");
		log.info("TranactionType is visible");
		TranactionType2.click();
		log.info("TranactionType is clicked");


		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'ThirdParty_Tax')]")));
		WebElement ThirdPartytype = driver.findElement(By.xpath("//div[contains(text(), 'ThirdParty_Tax')]"));
		Assert.assertTrue(ThirdPartytype.isDisplayed(), "ThirdPartytype is missing");
		log.info("ThirdPartytype is visible");
		ThirdPartytype.click();
		log.info("ThirdPartytype is clicked");
		
		JavascriptExecutor ex2 = (JavascriptExecutor) driver;
		ex2.executeScript("window.scrollBy(0,-200)", "");
		
		
		WebElement RecalculateIcon2 = driver.findElement(By.xpath("//span[contains(text(),'Recalculate all pricing')]"));
		Assert.assertTrue(RecalculateIcon2.isDisplayed(), "RecalculateIcon is missing");
		log.info("RecalculateIcon is visible");
		RecalculateIcon2.click();
		log.info("RecalculateIcon is clicked");
		Thread.sleep(20000);
		
		WebElement CheckoutTotal7 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal7.getText().contains("520"),"CheckoutTotal is missing");
		log.info("The Amount for Third Party transaction type has been captured successfully");
	
		DeleteCOU2();
		
		
	}
	
	
	@Test(priority = 71)
	public static void InternalserviceTax() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sell)));
		WebElement Sell = driver.findElement(By.xpath(sell));
		Assert.assertTrue(Sell.isDisplayed(), "Sell link is missing");
		log.info("Sell link is visible");
		Sell.click();
		log.info("Sell link is clicked");
		

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(internalservice)));
		WebElement Internalservice = driver.findElement(By.xpath(internalservice));
		Assert.assertTrue(Internalservice.isDisplayed(), "Internalservice link is missing");
		log.info("Internalservice link is visible");
		Internalservice.click();
		log.info("Internalservice link is clicked");

		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Service Job 1')]")));
		Thread.sleep(10000);
		WebElement DealershipName = driver.findElement(By.xpath(dealershipname));
		Assert.assertTrue(DealershipName.getText().contains("GREY ROCK MOTOSPORTS"), "DealershipName is mismatched");
		log.info("DealershipName is visible");
		
		
		WebElement Pricelevel = driver.findElement(By.xpath(pricelevel));
		Assert.assertTrue(Pricelevel.getText().contains("Default"), "Pricelevel is missing");
		log.info("Pricelevel is visible");
		
		WebElement ServiceJobDetails = driver.findElement(By.xpath(servicejobdetails));
		wt.until(ExpectedConditions.visibilityOf(ServiceJobDetails));
		Assert.assertTrue(ServiceJobDetails.isDisplayed(), "ServiceJobDetails is missing");
		log.info("ServiceJobDetails is visible");
		ServiceJobDetails.click();
		log.info("ServiceJobDetails is clicked");
		Thread.sleep(5000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocompleteServiceJob0")));
		WebElement SKUsearhfield = driver.findElement(By.id("autocompleteServiceJob0"));
		Assert.assertTrue(SKUsearhfield.isDisplayed(), "SKUsearhfield  is missing");
		log.info("SKUsearhfield is visible");
		SKUsearhfield.sendKeys("Auto_make");
		log.info("SKU is entered");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityInfo_0")));
		WebElement SKUentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(SKUentity.isDisplayed(), "SKUentity is missing");
		log.info("SKUentity is visible");
		SKUentity.click();
		Thread.sleep(10000);
		
		if(driver.findElement(By.id("autocompleteServiceJob0")).isDisplayed())
		{
			driver.findElement(By.xpath(activeorderbutton)).click();
			Thread.sleep(10000);
		}
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(stockunit)));
		WebElement Stockunit = driver.findElement(By.xpath(stockunit));
		Assert.assertTrue(Stockunit.isDisplayed(), "Stockunit is missing");
		log.info(Stockunit.getText()+ " is visible");
		
		WebElement Concern = driver.findElement(By.id("Concern0"));
		Assert.assertTrue(Concern.isDisplayed(), "Concern field is missing");
		log.info("Concern field is visible");
		Concern.sendKeys("Break loose");
		log.info("Concern field is filled");

		WebElement Cause = driver.findElement(By.id("Cause0"));
		Assert.assertTrue(Cause.isDisplayed(), "Cause field is missing");
		log.info("Cause field is visible");
		Cause.sendKeys("Long drive");
		log.info("Cause field is filled");

		
		WebElement Correction = driver.findElement(By.id("Correction0"));
		Assert.assertTrue(Correction.isDisplayed(), "Correction field is missing");
		log.info("Correction field is visible");
		Correction.sendKeys("Fix breaks");
		log.info("Correction field is filled");

		WebElement Odometer_on_arrival = driver.findElement(By.xpath(odometer_on_arrival));
		Assert.assertTrue(Odometer_on_arrival.isDisplayed(), "Odometer_on_arrival field is missing");
		log.info("Odometer_on_arrival field is visible");
		Odometer_on_arrival.sendKeys(Keys.chord(Keys.CONTROL,"a"), "6000");
		log.info("Odometer_on_arrival field is filled");

		WebElement Odometer_on_departure = driver.findElement(By.xpath(odometer_on_departure));
		Assert.assertTrue(Odometer_on_departure.isDisplayed(), "Odometer_on_departure field is missing");
		log.info("Odometer_on_departure field is visible");
		Odometer_on_departure.sendKeys(Keys.chord(Keys.CONTROL,"a"), "6100");
		log.info("Odometer_on_departure field is filled");
		
		
		WebElement LPJItems = driver.findElement(By.xpath(lpjItems));
		LPJItems.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocompleteServiceJob0")));
		WebElement Searchbox1 = driver.findElement(By.id("autocompleteServiceJob0"));
		Assert.assertTrue(Searchbox1.isDisplayed(), "Searchbox is missing");
		log.info("Searchbox is visible");
		
		Searchbox1.sendKeys("Merchandise_Tax");
		Thread.sleep(10000);
		
		WebElement Merchentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Merchentity.isDisplayed(), "Merchentity is missing");
		log.info("Merchentity is visible");
		Merchentity.click();
		Thread.sleep(10000);

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkoutTotal)));
		WebElement CheckoutTotal1 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal1.getText().contains("100"), "CheckoutTotal is missing");
		log.info("The Amount for Merchandise has been captured successfully");
		
		
	}
}
