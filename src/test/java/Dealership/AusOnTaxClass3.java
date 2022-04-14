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

public class AusOnTaxClass3 extends POM	
{
	@Test(priority = 72)
	public static void UnitDealTax() throws Exception
	{
		SelectCustomer2();
		WebDriverWait wt = new WebDriverWait(driver, 100);
		WebElement SellAUnit = driver.findElement(By.xpath(sellAUnit));
		Assert.assertTrue(SellAUnit.isDisplayed(), "Sell A Unit button is missing");
		log.info("Sell A Unit button is visible");
		SellAUnit.click();
		log.info("Sell A Unit button is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitdealstatus)));
		WebElement UnitDealStatus = driver.findElement(By.xpath(unitdealstatus));
		Assert.assertTrue(UnitDealStatus.isDisplayed(), "UnitDealStatus is missing");
		log.info("UnitDealStatus is visible");
		log.info("UnitDealStatus is " +UnitDealStatus.getText());
		Assert.assertEquals(UnitDealStatus.getText(), "Status: Quotation");
		
		WebElement UnitOptionsStatus = driver.findElement(By.xpath(unitoptionsstatus));
		Assert.assertTrue(UnitOptionsStatus.isDisplayed(), "UnitOptionsStatus is missing");
		log.info("UnitOptionsStatus is visible");
		log.info("UnitOptionsStatus is " +UnitOptionsStatus.getText());
		Assert.assertEquals(UnitOptionsStatus.getText(), "Option:");


		WebElement Unit1 = driver.findElement(By.xpath(unit1));
		Assert.assertTrue(Unit1.isDisplayed(), "Unit1 is missing");
		log.info("Unit1 is visible");
		Unit1.click();
		log.info("Unit1 is opened");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("autocompleteDealUnit0")));
		WebElement SearchStockunit = driver.findElement(By.id("autocompleteDealUnit0"));
		Assert.assertTrue(SearchStockunit.isDisplayed(), "Search Stockunit field is missing");
		log.info("Search Stockunit field is visible");
		SearchStockunit.sendKeys("StockUnit_Tax");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityInfo_0")));
		WebElement UnitInfo = driver.findElement(By.id("entityInfo_0"));
		UnitInfo.click();
		log.info("Unit1 is selected");	
		
		Thread.sleep(20000);
		
		WebElement CheckoutTotal1 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal1.getText().contains("100"),"CheckoutTotal is missing");
		log.info("The Amount for StockUnit has been captured successfully");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitName)));
		WebElement Option_Fee = driver.findElement(By.xpath(option_fee));
		Assert.assertTrue(Option_Fee.isDisplayed(), "Option_Fee field is missing");
		log.info("Option_Fee field is visible");
		
		JavascriptExecutor executer =  (JavascriptExecutor) driver;		
		executer.executeScript("window.scrollBy(0,550)", "");
		
		WebElement OptionsAndFee = driver.findElement(By.xpath(optionaAndfee));
		Assert.assertTrue(OptionsAndFee.isDisplayed(), "Options And Fee field is missing");
		log.info("Options And Fee field is visible");
		OptionsAndFee.click();
		log.info("Options And Fee field is clicked");

		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("autocompleteDealUnit0")));
		WebElement SearchOptions = driver.findElement(By.id("autocompleteDealUnit0"));
		Assert.assertTrue(SearchOptions.isDisplayed(), "SearchOptions field is missing");
		log.info("SearchOptions field is visible");
		SearchOptions.sendKeys("WarrantyPlan_Tax");
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("entityInfo_0")));
		WebElement OptionInfo = driver.findElement(By.id("entityInfo_0"));
		OptionInfo.click();
		log.info("Warranty product is selected");	
		Thread.sleep(20000);
		
		WebElement CheckoutTotal2 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal2.getText().contains("200"),"CheckoutTotal is missing");
		log.info("The Amount for WarrantyPlan has been captured successfully");
		
		WebElement ScanandSearch = driver.findElement(By.xpath(scanandsearch));
		ScanandSearch.click();
		Thread.sleep(10000);		
		
		WebElement SearchOptions2 = driver.findElement(By.id("autocompleteDealUnit0"));
		Assert.assertTrue(SearchOptions2.isDisplayed(), "SearchOptions field is missing");
		log.info("SearchOptions field is visible");
		SearchOptions2.sendKeys("FinancingProduct_Tax");
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("entityInfo_0")));
		WebElement OptionInfo2 = driver.findElement(By.id("entityInfo_0"));
		OptionInfo2.click();
		log.info("Financing product is selected");	
		Thread.sleep(20000);
		
		WebElement CheckoutTotal3 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal3.getText().contains("300"),"CheckoutTotal is missing");
		log.info("The Amount for Financing product has been captured successfully");
		
		WebElement ScanandSearch2 = driver.findElement(By.xpath(scanandsearch));
		ScanandSearch2.click();
		Thread.sleep(10000);
		
		WebElement SearchOptions3 = driver.findElement(By.id("autocompleteDealUnit0"));
		Assert.assertTrue(SearchOptions3.isDisplayed(), "SearchOptions field is missing");
		log.info("SearchOptions field is visible");
		SearchOptions3.sendKeys("DealProduct_Tax");
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("entityInfo_0")));
		WebElement OptionInfo3 = driver.findElement(By.id("entityInfo_0"));
		OptionInfo3.click();
		log.info("DealProduct is selected");	
		Thread.sleep(20000);
		
		WebElement CheckoutTotal4 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal4.getText().contains("400"),"CheckoutTotal is missing");
		log.info("The Amount for DealProduct has been captured successfully");
		
		WebElement ScanandSearch3 = driver.findElement(By.xpath(scanandsearch));
		ScanandSearch3.click();
		Thread.sleep(10000);
		
		WebElement AddTradeIn = driver.findElement(By.xpath(addTradeIn));
		Assert.assertTrue(AddTradeIn.isDisplayed(), "AddTradeIn button is missing");
		log.info("AddTradeIn button is visible");
		AddTradeIn.click();
		log.info("AddTradeIn button is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addCOU)));

		WebElement AddCOU = driver.findElement(By.xpath(addCOU));
		Assert.assertTrue(AddCOU.isDisplayed(), "AddCOU button is missing");
		log.info("AddCOU button is visible");
		AddCOU.click();
		log.info("AddCOU button is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("MakeUnitOrdering")));
		
		WebElement TempUnitMmodalWindow = driver.findElement(By.xpath(tempUnitMmodalWindow));
		Assert.assertEquals(TempUnitMmodalWindow.getText(), "ADD A NEW CUSTOMER OWNED UNIT");
		log.info("Temp Unit Mmodal Window  is visible");

		
		WebElement MakeUnitOrdering1 = driver.findElement(By.id("MakeUnitOrdering"));
		Assert.assertTrue(MakeUnitOrdering1.isDisplayed(), "Make field is missing");
		log.info("Make field is visible");
		int num = random.nextInt(10000);
		MakeUnitOrdering1.sendKeys("Make" +num);
		log.info("Make is filed");
		
		WebElement ModelUnitOrdering1 = driver.findElement(By.id("ModelUnitOrdering"));
		Assert.assertTrue(ModelUnitOrdering1.isDisplayed(), "Model field is missing");
		log.info("Model field is visible");
		ModelUnitOrdering1.sendKeys("Model" +num);
		log.info("Model is filed");
		
		WebElement SubModelUnitOrdering1 = driver.findElement(By.id("SubModelUnitOrdering"));
		Assert.assertTrue(SubModelUnitOrdering1.isDisplayed(), "Sun-Model field is missing");
		log.info("Sub-Model field is visible");
		SubModelUnitOrdering1.sendKeys("SubModel" +num);
		log.info("Sub-Model is filed");
		
		WebElement YearAddEditUnit1 = driver.findElement(By.id("YearAddEditUnit"));
		Assert.assertTrue(YearAddEditUnit1.isDisplayed(), "Year field is missing");
		log.info("Year field is visible");
		YearAddEditUnit1.sendKeys("2020");
		log.info("Year is filed");
		
		WebElement Addbutton = driver.findElement(By.xpath(addbutton));
		Assert.assertTrue(Addbutton.isDisplayed(), "Addbutton is missing");
		log.info("Addbutton is visible");
		Addbutton.click();
		log.info("Addbutton is clicked");
		Thread.sleep(10000);

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tradeinunitname)));
		
		WebElement AgreedValueForCOU = driver.findElement(By.id("AgreedValueForCOU"));
		Assert.assertTrue(AgreedValueForCOU.isDisplayed(), "AgreedValueForCOU is missing");
		log.info("AgreedValueForCOU is visible");
		AgreedValueForCOU.sendKeys("50");
		AgreedValueForCOU.sendKeys(Keys.TAB);
		log.info("AgreedValueForCOU is clicked");
		Thread.sleep(10000);
		
		WebElement CheckoutTotal5 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal5.getText().contains("350"),"CheckoutTotal is missing");
		log.info("The Amount after agreed value been captured successfully");
				
		
		WebElement tradeInLienPayout = driver.findElement(By.id("tradeInLienPayout"));
		Assert.assertTrue(tradeInLienPayout.isDisplayed(), "tradeInLienPayout is missing");
		log.info("tradeInLienPayout is visible");
		tradeInLienPayout.sendKeys("10");
		tradeInLienPayout.sendKeys(Keys.TAB);
		log.info("tradeInLienPayout is clicked");
		Thread.sleep(10000);
		
		WebElement CheckoutTotal6 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal6.getText().contains("360"),"CheckoutTotal is missing");
		log.info("The Amount after LienPayout been captured successfully");
		
		WebElement tradeInFinanceCompany = driver.findElement(By.id("tradeInFinanceCompany"));
		Assert.assertTrue(tradeInFinanceCompany.isDisplayed(), "tradeInFinanceCompany is missing");
		log.info("tradeInFinanceCompany is visible");
		tradeInFinanceCompany.click();
		log.info("tradeInFinanceCompany is clicked");
		Thread.sleep(5000);
		
		
		WebElement tradeInFinanceCompanyDropdownDiv = driver.findElement(By.id("tradeInFinanceCompanyDropdownDiv"));
		Assert.assertTrue(tradeInFinanceCompanyDropdownDiv.isDisplayed(), "tradeInFinanceCompanyDropdownDiv is missing");
		log.info("tradeInFinanceCompanyDropdownDiv is visible");
		tradeInFinanceCompanyDropdownDiv.click();
		log.info("tradeInFinanceCompanyDropdownDiv is clicked");
		Thread.sleep(5000);
		
		JavascriptExecutor ex1 = (JavascriptExecutor) driver;
		ex1.executeScript("window.scrollBy(0,-700)", "");
		
			
		WebElement AppraisalMethod = driver.findElement(By.xpath(appraisalMethod));
		Assert.assertTrue(AppraisalMethod.isDisplayed(), "AppraisalMethod is missing");
		log.info("AppraisalMethod is visible");
	
		JavascriptExecutor executer1 = (JavascriptExecutor) driver;
		executer1.executeScript("arguments[0].click();", AppraisalMethod);
//		AppraisalMethod.click();
		log.info("AppraisalMethod is clicked");
		Thread.sleep(5000);
		
		
		WebElement appraisalMethod0 = driver.findElement(By.id("appraisalMethod0"));
		Assert.assertTrue(appraisalMethod0.isDisplayed(), "appraisalMethod0 is missing");
		log.info("appraisalMethod0 is visible");
		appraisalMethod0.click();
		log.info("appraisalMethod0 is clicked");
		
		
		WebElement AppraisalStatus = driver.findElement(By.id("AppraisalStatus"));
		Assert.assertTrue(AppraisalStatus.isDisplayed(), "AppraisalStatus is missing");
		log.info("AppraisalStatus is visible");
		AppraisalStatus.click();
		log.info("AppraisalStatus is clicked");
		Thread.sleep(5000);

		WebElement appraisalStatus1 = driver.findElement(By.id("appraisalStatus1"));
		Assert.assertTrue(appraisalStatus1.isDisplayed(), "appraisalStatus1 is missing");
		log.info("appraisalStatus1 is visible");
		appraisalStatus1.click();
		log.info("appraisalStatus1 is clicked");
		

		WebElement AppraisalNote = driver.findElement(By.id("AppraisalNote"));
		Assert.assertTrue(AppraisalNote.isDisplayed(), "AppraisalNote is missing");
		log.info("AppraisalNote is visible");
		AppraisalNote.sendKeys("This is a test Note");
		log.info("AppraisalNote is filled");
		
		JavascriptExecutor ex2 = (JavascriptExecutor) driver;
		ex2.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(5000);

		
		WebElement ApprovedBy = driver.findElement(By.id("ApprovedBy"));
		Assert.assertTrue(ApprovedBy.isDisplayed(), "ApprovedBy is missing");
		log.info("ApprovedBy is visible");
		ApprovedBy.click();
		log.info("ApprovedBy is clicked");
		Thread.sleep(5000);
		
		
		WebElement approvedBy0 = driver.findElement(By.id("approvedBy0"));
		Assert.assertTrue(approvedBy0.isDisplayed(), "approvedBy0 is missing");
		log.info("approvedBy0 is visible");
		approvedBy0.click();
		log.info("approvedBy0 is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(adddealfinancing)));
		WebElement Aadddealfinancing = driver.findElement(By.xpath(adddealfinancing));
		Assert.assertTrue(Aadddealfinancing.isDisplayed(), "Aadddealfinancing button is missing");
		log.info("Aadddealfinancing button is visible");
		Aadddealfinancing.click();
		log.info("Aadddealfinancing button is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("DealFinance")));
		WebElement DealFinanceField = driver.findElement(By.id("DealFinance"));
		Assert.assertTrue(DealFinanceField.isDisplayed(), "DealFinanceField is missing");
		log.info("DealFinanceField is visible");
		DealFinanceField.sendKeys("BP_Vendor");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("DealFinance0")));
		WebElement DealFinanceVendor = driver.findElement(By.id("DealFinance0"));
		Assert.assertTrue(DealFinanceVendor.isDisplayed(), "DealFinanceVendor is missing");
		log.info("DealFinanceVendor is visible");
		DealFinanceVendor.click();
		log.info("DealFinanceVendor is selected");


		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(financeVendorname)));
		WebElement FinanceVendorname = driver.findElement(By.xpath(financeVendorname));
		Assert.assertTrue(FinanceVendorname.getText().contains("BP_Vendor"), "DealFinanceVendor is mismatched");
		log.info("FinanceVendorname is "+ FinanceVendorname.getText());
		
		
		WebElement FNIProductfield = driver.findElement(By.xpath("//h2[contains(text(),'F&I products')]"));
		Assert.assertTrue(FNIProductfield.isDisplayed(), "FNIProductfield is missing");
		log.info("FNIProductfield is visible");
		FNIProductfield.click();
		log.info("FNIProductfield is selected");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocompleteDealFinance")));
		WebElement SearchFNI = driver.findElement(By.id("autocompleteDealFinance"));
		Assert.assertTrue(SearchFNI.isDisplayed(), "SearchFNI is missing");
		log.info("SearchFNI is visible");
		SearchFNI.sendKeys("FinancingProduct_Tax");
		log.info("SearchFNI is selected");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityInfo_0")));
		WebElement FNIInfo = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(FNIInfo.isDisplayed(), "FNIInfo is missing");
		log.info("FNIInfo is visible");
		FNIInfo.click();
		log.info("FNI product is selected");
		Thread.sleep(10000);
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Save')]")));
		WebElement SaveFNI = driver.findElement(By.xpath("//a[contains(text(),'Save')]"));
		Assert.assertTrue(SaveFNI.isDisplayed(), "SaveFNI is missing");
		log.info("SaveFNI is visible");
		SaveFNI.click();
		log.info("FNI product is saved");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Edit')])[2]"))).click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Save')]"))).click();
		Thread.sleep(10000);

		WebElement CheckoutTotal7 = driver.findElement(By.xpath(checkoutTotal));
		Assert.assertTrue(CheckoutTotal7.getText().contains("460"),"CheckoutTotal is missing");
		log.info("The Amount for F&I product has been captured successfully");

		DeleteCOU2();
	}
	

}
