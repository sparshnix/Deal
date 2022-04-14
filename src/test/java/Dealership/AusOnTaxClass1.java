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

public class AusOnTaxClass1 extends POM	
{
	
	@Test(priority = 67)
	public static void CashSaleTax() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sell)));
		WebElement Sell = driver.findElement(By.xpath(sell));
		Assert.assertTrue(Sell.isDisplayed(), "Sell link is missing");
		log.info("Sell link is visible");
		Sell.click();
		log.info("Sell link is clickable");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sellpart)));
		WebElement SellPart = driver.findElement(By.xpath(sellpart));
		Assert.assertTrue(SellPart.isDisplayed(), "Sell Part Tile is missing");
		log.info("Sell Part tile is displayed");
		SellPart.click();
		log.info("Sell Part tile is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocompleteMerchandiseSectionWrapperId")));
		WebElement Searchbox = driver.findElement(By.id("autocompleteMerchandiseSectionWrapperId"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		log.info("Searchbox is visible");
		
		WebElement Searchbox1 = driver.findElement(By.id("autocompleteMerchandiseSectionWrapperId"));
		Assert.assertTrue(Searchbox1.isDisplayed(), "Searchbox is missing");
		log.info("Searchbox is visible");
		Searchbox1.sendKeys("Merchandise_Tax");
		log.info("Merchandise_Tax is entered");

		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityInfo_0")));
		WebElement Merchentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Merchentity.isDisplayed(), "Merchentity is missing");
		log.info("Merchentity is visible");
		Merchentity.click();
		log.info("Merchentity is selected");
		Thread.sleep(20000);	
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkoutTotal)));
		WebElement CheckoutTotal1 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal1.getText().contains("110"), "CheckoutTotal is missing");
		log.info("The Amount for Merchandise has been captured successfully");
		

		WebElement Searchbox2 =  driver.findElement(By.id("autocompleteMerchandiseSectionWrapperId"));
		Assert.assertTrue(Searchbox2.isDisplayed(), "Searchbox is missing");
		log.info("Searchbox is visible");
		Searchbox2.sendKeys("Fee_Tax");
		  
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityInfo_0")));
		WebElement Feeentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Feeentity.isDisplayed(), "Feeentity is missing");
		log.info("Feeentity is visible");
		Feeentity.click();
		Thread.sleep(20000);
		  
		WebElement CheckoutTotal2 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal2.getText().contains("210"),"CheckoutTotal is missing");
		log.info("The Amount for Fee has been captured successfully");
		
		WebElement Searchbox3 = driver.findElement(By.id("autocompleteMerchandiseSectionWrapperId"));
		Assert.assertTrue(Searchbox3.isDisplayed(), "Searchbox is missing");
		log.info("Searchbox is visible");
//      Searchbox.sendKeys(POM.NewKit);
		Searchbox3.sendKeys("Kit_tax");
		  
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityInfo_0")));
		WebElement Kitentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Kitentity.isDisplayed(), "Kitentity is missing");
		log.info("Kitentity is visible");
		Kitentity.click();
		Thread.sleep(20000);
		
		WebElement CheckoutTotal3 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal3.getText().contains("320"),"CheckoutTotal is missing");
		log.info("The Amount for Kit has been captured successfully");
		  
		// JavascriptExecutor executer = (JavascriptExecutor) driver; 
		//executer.executeScript("window.scrollBy(0,550)", MerchandiseSectionId);
		  
		WebElement Checkout_Button = driver.findElement(By.xpath(checkout_button));
		Assert.assertTrue(Checkout_Button.isDisplayed(),"Checkout_Button is missing");
		log.info("Checkout_Button is visible");
		Checkout_Button.click();
		Thread.sleep(10000);
		  
		if(driver.findElement(By.xpath(setCashDrawerModalWindow)).isDisplayed()) 
		{

		  driver.findElement(By.id("cashDrawer")).click();
		  driver.findElement(By.id("cashDrawerDropdownDiv")).click();
//		  driver.findElement(By.id("terminal")).click(); 
//		  driver.findElement(By.id("terminalDropdownDiv")).click();
		  driver.findElement(By.xpath(selectdrawerbutton)).click();
		  Thread.sleep(10000);
		  Checkout_Button.click();
		  Thread.sleep(10000);
		}
		
		WebElement PaymentOption = driver.findElement(By.xpath(cashoption));
		Assert.assertTrue(PaymentOption.isDisplayed(), "Payment Option is missing");
		log.info("Payment option is visible");
		PaymentOption.click();
		log.info("Payment option is selected");
		
		WebElement AddPayment = driver.findElement(By.xpath(addpayment));
		Assert.assertTrue(AddPayment.isDisplayed(), "AddPayment Button is missing");
		log.info("AddPayment Button is visible");
		AddPayment.click();
		log.info("AddPayment Button is clicked");
		Thread.sleep(20000);
		
		WebElement FinalizeButton = driver.findElement(By.xpath(finalizebutton));
		Assert.assertTrue(FinalizeButton.isDisplayed(), "Finalize Button is missing");
		log.info("Finalize Button is visible");
		FinalizeButton.click();
		log.info("Finalize Button is clicked");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoicewindow)));
		WebElement InvoiceWindow = driver.findElement(By.xpath(invoicewindow));
		Assert.assertTrue(InvoiceWindow.isDisplayed(), "Invoice Window is missing");
		log.info("Invoice Window is visible");
		
		WebElement PrintModelWindow = driver.findElement(By.xpath(printModelWindow));
		String PrintModelWindowText = PrintModelWindow.getText();
		Assert.assertEquals(PrintModelWindowText, "WHAT WOULD YOU LIKE TO PRINT?");
		log.info("Print Model Window is visible");
		Thread.sleep(5000);	

		
		WebElement BrandingLocationId = driver.findElement(By.id("BrandingLocationId"));
		wt.until(ExpectedConditions.visibilityOf(BrandingLocationId));
		Assert.assertTrue(BrandingLocationId.isDisplayed(), "BrandingLocationId is missing");
		log.info("BrandingLocationId is visible");
		BrandingLocationId.click();
		log.info("BrandingLocationId is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("brandingLocationDropdownDiv")));
		WebElement brandingLocationDropdownDiv = driver.findElement(By.id("brandingLocationDropdownDiv"));
		Assert.assertTrue(brandingLocationDropdownDiv.isDisplayed(), "brandingLocationDropdownDiv is missing");
		log.info("brandingLocationDropdownDiv is visible");
		brandingLocationDropdownDiv.click();
		log.info("branding name is selected");
				
		WebElement Confirm1 = driver.findElement(By.xpath("//button[contains(text() , 'CONFIRM')]"));
		Confirm1.click();
		
		
		WebElement Invoicelabel = driver.findElement(By.xpath("//label[contains(text(),'Invoice')]"));
		Assert.assertTrue(Invoicelabel.isDisplayed(), "Invoicelabel is missing");
		log.info("Invoicelabel is visible");
		Invoicelabel.click();
		log.info("Invoicelabel is unchecked");
		
		WebElement PrintReceipt = driver.findElement(By.xpath("//label[contains(text(),'Print receipt')]"));
		Assert.assertTrue(PrintReceipt.isDisplayed(), "PrintReceipt is missing");
		log.info("PrintReceipt is visible");
		PrintReceipt.click();
		log.info("PrintReceipt is checked");
		
		
		WebElement PrintButton = driver.findElement(By.xpath("//span[contains(text(),'Print Selected')]"));
		Assert.assertTrue(PrintButton.isDisplayed(), "PrintButton is missing");
		log.info("PrintButton is visible");
		PrintButton.click();
		log.info("PrintButton is clicked");
		
		Thread.sleep(10000);
		
		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> It = Windows.iterator();
		String ParentID = It.next();
		String ChildID = It.next();
		
		driver.switchTo().window(ChildID);

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(printtotal)));
		WebElement Printtotal = driver.findElement(By.xpath(printtotal));
		Assert.assertTrue(Printtotal.getText().contains("320"), "Total is missing");
		log.info("Print total is successfully verified");
		driver.close();
		driver.switchTo().window(ParentID);
		
		WebElement PrintClose = driver.findElement(By.xpath(printClose));
		Assert.assertTrue(PrintClose.isDisplayed(), "PrintClose x is missing");
		log.info("PrintClose x is visible");
		JavascriptExecutor executer4 = (JavascriptExecutor) driver;
		executer4.executeScript("arguments[0].click();", PrintClose);
		log.info("Print window is closed");
		

	}

	@Test(priority = 68)
	public static void MerchandiseTax() throws Exception
	{	
		SelectCustomer2();
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sellpartandaccs)));
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
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkoutTotal)));
		WebElement CheckoutTotal1 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal1.getText().contains("110"), "CheckoutTotal is missing");
		log.info("The Amount for Merchandise has been captured successfully");

		
		Searchbox.sendKeys("Fee_Tax");
		Thread.sleep(10000);
				
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityInfo_0")));
		WebElement Feeentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Feeentity.isDisplayed(), "Feeentity is missing");
		log.info("Feeentity is visible");
		Feeentity.click();
		Thread.sleep(10000);	
		
		WebElement CheckoutTotal2 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal2.getText().contains("210"),"CheckoutTotal is missing");
		log.info("The Amount for Fee has been captured successfully");

		Searchbox.sendKeys("Kit_Tax");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityInfo_0")));
		WebElement Kitentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Kitentity.isDisplayed(), "Kitentity is missing");
		log.info("Kitentity is visible");
		Kitentity.click();
		Thread.sleep(10000);
		
		WebElement MerchandiseSectionId = driver.findElement(By.xpath(merchandiseSectionId));
		JavascriptExecutor executer = (JavascriptExecutor) driver;
		executer.executeScript("arguments[0].click();", MerchandiseSectionId);
		
		WebElement CheckoutTotal3 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal3.getText().contains("320"),"CheckoutTotal is missing");
		log.info("The Amount for Kit has been captured successfully");
		
		WebElement Checkout_Button = driver.findElement(By.xpath(checkout_button));
		Assert.assertTrue(Checkout_Button.isDisplayed(), "Checkout_Button is missing");
		log.info("Checkout_Button is visible");
		Checkout_Button.click();
		Thread.sleep(10000);

		if(driver.findElement(By.xpath(setCashDrawerModalWindow)).isDisplayed()) 
		{

		  driver.findElement(By.id("cashDrawer")).click();
		  driver.findElement(By.id("cashDrawerDropdownDiv")).click();
//		  driver.findElement(By.id("terminal")).click(); 
//		  driver.findElement(By.id("terminalDropdownDiv")).click();
		  driver.findElement(By.xpath(selectdrawerbutton)).click();
		  Thread.sleep(10000);
		  Checkout_Button.click();
		  Thread.sleep(10000);
		}
		
		WebElement PaymentOption = driver.findElement(By.xpath(cashoption));
		Assert.assertTrue(PaymentOption.isDisplayed(), "Payment Option is missing");
		log.info("Payment option is visible");
		PaymentOption.click();
		log.info("Payment option is selected");
		
		WebElement AddPayment = driver.findElement(By.xpath(addpayment));
		Assert.assertTrue(AddPayment.isDisplayed(), "AddPayment Button is missing");
		log.info("AddPayment Button is visible");
		AddPayment.click();
		log.info("AddPayment Button is clicked");
		Thread.sleep(20000);
		
		WebElement FinalizeButton = driver.findElement(By.xpath(finalizebutton));
		Assert.assertTrue(FinalizeButton.isDisplayed(), "Finalize Button is missing");
		log.info("Finalize Button is visible");
		FinalizeButton.click();
		log.info("Finalize Button is clicked");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoicewindow)));
		WebElement InvoiceWindow = driver.findElement(By.xpath(invoicewindow));
		Assert.assertTrue(InvoiceWindow.isDisplayed(), "Invoice Window is missing");
		log.info("Invoice Window is visible");
		
		WebElement PrintModelWindow = driver.findElement(By.xpath(printModelWindow));
		String PrintModelWindowText = PrintModelWindow.getText();
		Assert.assertEquals(PrintModelWindowText, "WHAT WOULD YOU LIKE TO PRINT?");
		log.info("Print Model Window is visible");
		Thread.sleep(5000);	

		
		WebElement BrandingLocationId = driver.findElement(By.id("BrandingLocationId"));
		wt.until(ExpectedConditions.visibilityOf(BrandingLocationId));
		Assert.assertTrue(BrandingLocationId.isDisplayed(), "BrandingLocationId is missing");
		log.info("BrandingLocationId is visible");
		BrandingLocationId.click();
		log.info("BrandingLocationId is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("brandingLocationDropdownDiv")));
		WebElement brandingLocationDropdownDiv = driver.findElement(By.id("brandingLocationDropdownDiv"));
		Assert.assertTrue(brandingLocationDropdownDiv.isDisplayed(), "brandingLocationDropdownDiv is missing");
		log.info("brandingLocationDropdownDiv is visible");
		brandingLocationDropdownDiv.click();
		log.info("branding name is selected");
				
		WebElement Confirm1 = driver.findElement(By.xpath("//button[contains(text() , 'CONFIRM')]"));
		Confirm1.click();
		
		
		WebElement Invoicelabel = driver.findElement(By.xpath("//label[contains(text(),'Invoice')]"));
		Assert.assertTrue(Invoicelabel.isDisplayed(), "Invoicelabel is missing");
		log.info("Invoicelabel is visible");
		Invoicelabel.click();
		log.info("Invoicelabel is unchecked");
		
		WebElement PrintReceipt = driver.findElement(By.xpath("//label[contains(text(),'Print receipt')]"));
		Assert.assertTrue(PrintReceipt.isDisplayed(), "PrintReceipt is missing");
		log.info("PrintReceipt is visible");
		PrintReceipt.click();
		log.info("PrintReceipt is checked");
		
		
		WebElement PrintButton = driver.findElement(By.xpath("//span[contains(text(),'Print Selected')]"));
		Assert.assertTrue(PrintButton.isDisplayed(), "PrintButton is missing");
		log.info("PrintButton is visible");
		PrintButton.click();
		log.info("PrintButton is clicked");
		
		Thread.sleep(10000);
		
		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> It = Windows.iterator();
		String ParentID = It.next();
		String ChildID = It.next();
		
		driver.switchTo().window(ChildID);

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(printtotal)));
		WebElement Printtotal = driver.findElement(By.xpath(printtotal));
		Assert.assertTrue(Printtotal.getText().contains("320"), "Total is missing");
		log.info("Print total is successfully verified");
		driver.close();
		driver.switchTo().window(ParentID);
		
		WebElement PrintClose = driver.findElement(By.xpath(printClose));
		Assert.assertTrue(PrintClose.isDisplayed(), "PrintClose x is missing");
		log.info("PrintClose x is visible");
		JavascriptExecutor executer4 = (JavascriptExecutor) driver;
		executer4.executeScript("arguments[0].click();", PrintClose);
		log.info("Print window is closed");

	}
	
	@Test(priority = 69)
	public static void SalePrice() throws Exception
	{
		SelectCustomer2();
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sellpartandaccs)));
		WebElement SellPartandAccs = driver.findElement(By.xpath(sellpartandaccs));
		Assert.assertTrue(SellPartandAccs.isDisplayed(), "SellPartandAccs button is missing");
		log.info("SellPartandAccs button is visible");
		SellPartandAccs.click();
		log.info("SellPartandAccs button is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocompleteMerchandiseSectionWrapperId")));
		WebElement Searchbox = driver.findElement(By.id("autocompleteMerchandiseSectionWrapperId"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		log.info("Searchbox is visible");
		Searchbox.sendKeys("Merchandise_SalePrice");	
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityInfo_0")));
		WebElement Merchentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Merchentity.isDisplayed(), "Merchentity is missing");
		log.info("Merchentity is visible");
		Merchentity.click();
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkoutTotal)));
		WebElement CheckoutTotal1 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal1.getText().contains("70"), "CheckoutTotal is missing");
		log.info("The Sale price for Merchandise has been captured successfully");
		

	}

}
