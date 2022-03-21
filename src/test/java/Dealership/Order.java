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
import java.util.Random;
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
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import freemarker.core.JavaScriptOutputFormat;
//import TestPackage.Test;
import io.github.bonigarcia.wdm.*;
import org.testng.Reporter;

@Listeners(Dealership.Listeners.class)


public class Order extends POM {
	
	public static Random Random = new Random();
	static String Todaysdate = new SimpleDateFormat("d").format(new Date());
	
	@Test(priority = 36)
	public static void SingleUnitOrder() throws Exception
	
	{		
		WebDriverWait wt = new WebDriverWait(driver,100);
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(order)));
		WebElement Order = driver.findElement(By.xpath(order));
		Assert.assertTrue(Order.isDisplayed(), "Order link is missing");
		log.info("Order link is visible");
		Order.click();
		log.info("Order link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(orderoptions)));
		WebElement UnitOrder = driver.findElement(By.xpath(unitorder));
		Assert.assertTrue(UnitOrder.isDisplayed(), "UnitOrder link is missing");
		log.info("UnitOrder link is visible");
		UnitOrder.click();
		//action Class is not required here for hovering 
		log.info("UnitOrder link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(vendoroptions)));
		Thread.sleep(20000);		
		WebElement FirstVendor = driver.findElement(By.xpath(firstVendor));
		Assert.assertTrue(FirstVendor.isDisplayed(), "FirstVendor link is missing");
		log.info("FirstVendor link is visible");
		FirstVendor.click();
		
		Thread.sleep(5000);		
		WebElement OrderunitButton  = driver.findElement(By.xpath(orderunitButton));
		Assert.assertTrue(OrderunitButton.isDisplayed(), "Orderunit Button is missing");
		log.info("Orderunit Button is visible");
		OrderunitButton.click();
		log.info("Orderunit Button is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("MakeUnitOrdering")));
		WebElement MakeUnitOrdering  = driver.findElement(By.id("MakeUnitOrdering"));
		Assert.assertTrue(MakeUnitOrdering.isDisplayed(), "MakeField is missing");
		log.info("MakeField is visible");
		MakeUnitOrdering.sendKeys("Auto");
		Thread.sleep(4000);		

		WebElement MakeFieldDropdown  = driver.findElement(By.id("make0"));
		Assert.assertTrue(MakeFieldDropdown.isDisplayed(), "MakeFieldDropdown is missing");
		log.info("MakeFieldDropdown is visible");
		MakeFieldDropdown.click();
		log.info("MakeField is filled");
		
		
		WebElement ModelUnitOrdering  = driver.findElement(By.id("ModelUnitOrdering"));
		Assert.assertTrue(ModelUnitOrdering.isDisplayed(), "Model Field is missing");
		log.info("Model Field is visible");
		ModelUnitOrdering.sendKeys("Auto");
		Thread.sleep(4000);		

		WebElement ModelFieldDropdown  = driver.findElement(By.id("model0"));
		Assert.assertTrue(ModelFieldDropdown.isDisplayed(), "ModelFieldDropdown is missing");
		log.info("ModelFieldDropdown is visible");
		ModelFieldDropdown.click();
		log.info("ModelField is filled");
		
		
		WebElement SubModelUnitOrdering  = driver.findElement(By.id("SubModelUnitOrdering"));
		Assert.assertTrue(SubModelUnitOrdering.isDisplayed(), "SubModel Field is missing");
		log.info("SubModel Field is visible");
		SubModelUnitOrdering.sendKeys("Auto");
		Thread.sleep(4000);		

		WebElement SubModelFieldDropdown  = driver.findElement(By.id("subModel0"));
		Assert.assertTrue(SubModelFieldDropdown.isDisplayed(), "SubModelFieldDropdown is missing");
		log.info("SubModelFieldDropdown is visible");
		SubModelFieldDropdown.click();
		log.info("SubModelField is filled");	 
		
		
		WebElement YearUnitOrdering  = driver.findElement(By.id("YearUnitOrdering"));
		Assert.assertTrue(YearUnitOrdering.isDisplayed(), "YearUnitOrdering Field is missing");
		log.info("YearUnitOrdering Field is visible");
		YearUnitOrdering.click();
		WebElement YearDropdown  = driver.findElement(By.xpath(yearDropdown));
		Assert.assertTrue(YearDropdown.isDisplayed(), "YearDropdown is missing");
		log.info("YearDropdown is visible");
		YearDropdown.click();
		log.info("Year is selected");
			
		
		WebElement ConditionUnitOrdering  = driver.findElement(By.id("ConditionUnitOrdering"));
		Assert.assertTrue(ConditionUnitOrdering.isDisplayed(), "ConditionUnitOrdering field is missing");
		log.info("ConditionUnitOrdering Field is visible");
		ConditionUnitOrdering.click();
		WebElement ConditionDropdown  = driver.findElement(By.xpath(conditionDropdown));
		Assert.assertTrue(ConditionDropdown.isDisplayed(), "ConditionDropdown is missing");
		log.info("ConditionDropdown is visible");
		ConditionDropdown.click();
		log.info("Condition is selected");
			
		
		WebElement Colorfiled  = driver.findElement(By.xpath(colorfield));
		Assert.assertTrue(Colorfiled.isDisplayed(), "Colorfiled is missing");
		log.info("Colorfiled is visible");
		Colorfiled.sendKeys("Teal");
		log.info("Colorfiled is selected");

		
		WebElement Factoryfiled  = driver.findElement(By.xpath(factoryfield));
		Assert.assertTrue(Factoryfiled.isDisplayed(), "Factoryfiled is missing");
		log.info("Factoryfiled is visible");
		int num = Random.nextInt(10000);
		Factoryfiled.sendKeys(num + "");
		log.info("Factoryfiled is filled");
		
				
		WebElement StockNumber  = driver.findElement(By.xpath(stockNumber));
		Assert.assertTrue(StockNumber.isDisplayed(), "StockNumber is missing");
		log.info("StockNumber is visible");
		StockNumber.sendKeys(num + "");
		log.info("StockNumber is filled");
		
		
		WebElement CategoryUnitOrdering  = driver.findElement(By.id("CategoryUnitOrdering"));
		Assert.assertTrue(CategoryUnitOrdering.isDisplayed(), "CategoryUnitOrdering field is missing");
		log.info("CategoryUnitOrdering Field is visible");
		CategoryUnitOrdering.click();
		WebElement CategoryDropdown  = driver.findElement(By.id("category0"));
		Assert.assertTrue(CategoryDropdown.isDisplayed(), "CategoryDropdown is missing");
		log.info("CategoryDropdown is visible");
		CategoryDropdown.click();
		log.info("CategoryDropdown is selected");
		
		JavascriptExecutor ex1 = (JavascriptExecutor) driver;
		ex1.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(5000);
		
//		OrderedDateUnitOrdering		
		WebElement OrderedDateUnitOrdering  = driver.findElement(By.id("OrderedDateUnitOrdering"));
		Assert.assertTrue(OrderedDateUnitOrdering.isDisplayed(), "OrderedDateUnitOrdering field is missing");
		log.info("OrderedDateUnitOrdering Field is visible");
		OrderedDateUnitOrdering.click();
		Thread.sleep(2000);
		
		WebElement OrderDate = driver.findElement(By.xpath("//a[contains(text(),"+Todaysdate+")]"));
		Assert.assertTrue(OrderDate.isDisplayed(), "OrderDate is missing");
		log.info("OrderDate is visible");
		OrderDate.click();
		log.info("OrderDate is selected");

		
//		ExpectedDateUnitOrdering
		WebElement ExpectedDateUnitOrdering  = driver.findElement(By.id("ExpectedDateUnitOrdering"));
		Assert.assertTrue(ExpectedDateUnitOrdering.isDisplayed(), "ExpectedDateUnitOrdering field is missing");
		log.info("ExpectedDateUnitOrdering Field is visible");
		ExpectedDateUnitOrdering.click();
		Thread.sleep(2000);

		WebElement ExpectDate = driver.findElement(By.xpath("//a[contains(text(),"+Todaysdate+")]"));
		Assert.assertTrue(ExpectDate.isDisplayed(), "ExpectDate is missing");
		log.info("ExpectDate is visible");
		ExpectDate.click();
		log.info("ExpectDate is selected");
		
		WebElement BaseUnitPrice  = driver.findElement(By.xpath(baseUnitPrice));
		Assert.assertTrue(BaseUnitPrice.isDisplayed(), "BaseUnitPrice is missing");
		log.info("BaseUnitPrice is visible");
		BaseUnitPrice.sendKeys(Keys.chord(Keys.CONTROL,"a"),"3000");
		log.info("BaseUnitPrice is filled");
		

		WebElement BaseUnitCost  = driver.findElement(By.xpath(baseUnitCost));
		Assert.assertTrue(BaseUnitCost.isDisplayed(), "BaseUnitCost is missing");
		log.info("BaseUnitCost is visible");
		BaseUnitCost.sendKeys(Keys.chord(Keys.CONTROL,"a"),"2500");
		log.info("BaseUnitCost is filled");
		
		
		WebElement AddPricing  = driver.findElement(By.xpath(addPricing));
		Assert.assertTrue(AddPricing.isDisplayed(), "AddPricing button is missing");
		log.info("AddPricing button is visible");
		AddPricing.click();
		log.info("AddPricing button is clicked");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td")));
		WebElement CreateSingleOrderButton  = driver.findElement(By.xpath(createSingleOrderButton));
		Assert.assertTrue(CreateSingleOrderButton.isDisplayed(), "Create Single Order Button  is missing");
		log.info("Create Single Order Button is visible");
		CreateSingleOrderButton.click();
		log.info("Create Single Order Button is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td/div")));
		
		WebElement Orderunit = driver.findElement(By.xpath("//tr/td[contains(text(),"+num+")]"));
		Assert.assertTrue(Orderunit.isDisplayed(), "Orderunitn is missing");
		log.info("Orderunit is visible");
		Orderunit.click();
		log.info("Orderunit is clicked");
		Thread.sleep(5000);

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orderunitinfo)));
		
		WebElement VerifyMake = driver.findElement(By.xpath("//span[contains(text(),'Make')]"));
		Assert.assertTrue(VerifyMake.getText().contains("Make"), "Make is missing");
		log.info("Make is verified");

		WebElement VerifyModel = driver.findElement(By.xpath("//span[contains(text(),'Model')]"));
		Assert.assertTrue(VerifyModel.getText().contains("Model"), "Model is missing");
		log.info("Model is verified");

		WebElement VerifySubModel = driver.findElement(By.xpath("//span[contains(text(),'SubModel')]"));
		Assert.assertTrue(VerifySubModel.getText().contains("SubModel"), "SubModel is missing");
		log.info("SubModel is verified");
		
		WebElement Print = driver.findElement(By.xpath("//button[contains(text(),'Print')]"));
		Assert.assertTrue(Print.isDisplayed(), "Print Button is missing");
		log.info("Print Button is visible");
		Print.click();
		log.info("Print Button is clicked");
		
		Set<String> Window = driver.getWindowHandles();
		Iterator<String> it = Window.iterator();
		String ParentID = it.next();
		String ChildID = it.next();
		
		driver.switchTo().window(ChildID);
		Thread.sleep(10000);
		driver.close();
		driver.switchTo().window(ParentID);
		
		WebElement Edit = driver.findElement(By.xpath("//button[contains(text(),'Edit')]"));
		Assert.assertTrue(Edit.isDisplayed(), "Edit button is missing");
		log.info("Edit button is visible");
		Edit.click();
		log.info("Edit button is clicked");
		Thread.sleep(5000);
		
		
		WebElement Save = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		Assert.assertTrue(Save.isDisplayed(), "Save button is missing");
		log.info("Save button is visible");
		Save.click();
		log.info("Save button is clicked");
		Thread.sleep(5000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Receive')]")));
		WebElement Receive = driver.findElement(By.xpath("//button[contains(text(),'Receive')]"));
		Assert.assertTrue(Receive.isDisplayed(), "Receive button is missing");
		log.info("Receive button is visible");
		Receive.click();
		log.info("Receive button is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Model')]")));
		WebElement VerifyModelName = driver.findElement(By.xpath("//td[contains(text(),'Model')]"));
		Assert.assertTrue(VerifyModelName.getText().contains("Model"), "Model Name is missing");
		log.info("Model Name is verified");
		
		WebElement VINField = driver.findElement(By.xpath(vinField));
		Assert.assertTrue(VINField.isDisplayed(), "VINField is missing");
		log.info("VINField is visible");
		VINField.sendKeys(num+"");
		log.info("VINField is filled");
		
		WebElement InvoiceNumberField = driver.findElement(By.id("InvoiceNumber-0"));
		Assert.assertTrue(InvoiceNumberField.isDisplayed(), "InvoiceNumberField is missing");
		log.info("InvoiceNumberField is visible");
		InvoiceNumberField.sendKeys(num+"");
		log.info("InvoiceNumberField is filled");
		
		WebElement InvoiceDateField = driver.findElement(By.id("invoiceDate0"));
		Assert.assertTrue(InvoiceDateField.isDisplayed(), "InvoiceDateField is missing");
		log.info("InvoiceDateField is visible");
		InvoiceDateField.click();
		log.info("InvoiceDateField is filled");
		Thread.sleep(5000);
		
		WebElement InvoiceDate = driver.findElement(By.xpath("//a[contains(text(),"+Todaysdate+")]"));
		Assert.assertTrue(InvoiceDate.isDisplayed(), "InvoiceDate is missing");
		log.info("InvoiceDate is visible");
		InvoiceDate.click();
		log.info("InvoiceDate is selected");
		Thread.sleep(2000);
		
		
		WebElement ConfirmButton = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
		Assert.assertTrue(ConfirmButton.isDisplayed(), "ConfirmButton is missing");
		log.info("ConfirmButton is visible");
		ConfirmButton.click();
		log.info("ConfirmButton is selected");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td[contains(text(),"+num+")]")));
		
		WebElement ReceivedUnit = driver.findElement(By.xpath("//tr/td[contains(text(),"+num+")]"));
		Assert.assertTrue(ReceivedUnit.getText().contains(num+""), "ReceivedUnit is missing");
		log.info("ReceivedUnit is visible");
		
		WebElement UNTNumber = driver.findElement(By.xpath("//tr/td/span[contains(text(),'UNT')]"));
		Assert.assertTrue(UNTNumber.isDisplayed(), "ReceivedUnit is missing");
		log.info("UNTNumber is " +UNTNumber);
		
	}

	@Test(priority = 37)
	public static void BulkUnitOrder() throws Exception
	
	{
		WebDriverWait wt = new WebDriverWait(driver,100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(order)));
		WebElement Order = driver.findElement(By.xpath(order));
		Assert.assertTrue(Order.isDisplayed(), "Order link is missing");
		log.info("Order link is visible");
		Order.click();
		log.info("Order link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(orderoptions)));
		WebElement UnitOrder = driver.findElement(By.xpath(unitorder));
		Assert.assertTrue(UnitOrder.isDisplayed(), "UnitOrder link is missing");
		log.info("UnitOrder link is visible");
		UnitOrder.click();
		//action Class is not required here for hovering 
		log.info("UnitOrder link is clicked");
		Thread.sleep(5000);		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(vendoroptions)));
		WebElement FirstVendor = driver.findElement(By.xpath(firstVendor));
		Assert.assertTrue(FirstVendor.isDisplayed(), "FirstVendor link is missing");
		log.info("FirstVendor link is visible");
		FirstVendor.click();
		
		Thread.sleep(5000);		
		WebElement OrderunitButton  = driver.findElement(By.xpath(orderunitButton));
		Assert.assertTrue(OrderunitButton.isDisplayed(), "Orderunit Button is missing");
		log.info("Orderunit Button is visible");
		OrderunitButton.click();
		log.info("Orderunit Button is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("MakeUnitOrdering")));
		WebElement MakeUnitOrdering  = driver.findElement(By.id("MakeUnitOrdering"));
		Assert.assertTrue(MakeUnitOrdering.isDisplayed(), "MakeField is missing");
		log.info("MakeField is visible");
		MakeUnitOrdering.sendKeys("Auto");
		Thread.sleep(4000);		

		WebElement MakeFieldDropdown  = driver.findElement(By.id("make0"));
		Assert.assertTrue(MakeFieldDropdown.isDisplayed(), "MakeFieldDropdown is missing");
		log.info("MakeFieldDropdown is visible");
		MakeFieldDropdown.click();
		log.info("MakeField is filled");
		
		
		WebElement ModelUnitOrdering  = driver.findElement(By.id("ModelUnitOrdering"));
		Assert.assertTrue(ModelUnitOrdering.isDisplayed(), "Model Field is missing");
		log.info("Model Field is visible");
		ModelUnitOrdering.sendKeys("Auto");
		Thread.sleep(4000);		

		WebElement ModelFieldDropdown  = driver.findElement(By.id("model0"));
		Assert.assertTrue(ModelFieldDropdown.isDisplayed(), "ModelFieldDropdown is missing");
		log.info("ModelFieldDropdown is visible");
		ModelFieldDropdown.click();
		log.info("ModelField is filled");
		
		
		WebElement SubModelUnitOrdering  = driver.findElement(By.id("SubModelUnitOrdering"));
		Assert.assertTrue(SubModelUnitOrdering.isDisplayed(), "SubModel Field is missing");
		log.info("SubModel Field is visible");
		SubModelUnitOrdering.sendKeys("Auto");
		Thread.sleep(4000);		

		WebElement SubModelFieldDropdown  = driver.findElement(By.id("subModel0"));
		Assert.assertTrue(SubModelFieldDropdown.isDisplayed(), "SubModelFieldDropdown is missing");
		log.info("SubModelFieldDropdown is visible");
		SubModelFieldDropdown.click();
		log.info("SubModelField is filled");	 
		
		
		WebElement YearUnitOrdering  = driver.findElement(By.id("YearUnitOrdering"));
		Assert.assertTrue(YearUnitOrdering.isDisplayed(), "YearUnitOrdering Field is missing");
		log.info("YearUnitOrdering Field is visible");
		YearUnitOrdering.click();
		WebElement YearDropdown  = driver.findElement(By.xpath(yearDropdown));
		Assert.assertTrue(YearDropdown.isDisplayed(), "YearDropdown is missing");
		log.info("YearDropdown is visible");
		YearDropdown.click();
		log.info("Year is selected");
			
		
		WebElement ConditionUnitOrdering  = driver.findElement(By.id("ConditionUnitOrdering"));
		Assert.assertTrue(ConditionUnitOrdering.isDisplayed(), "ConditionUnitOrdering field is missing");
		log.info("ConditionUnitOrdering Field is visible");
		ConditionUnitOrdering.click();
		WebElement ConditionDropdown  = driver.findElement(By.xpath(conditionDropdown));
		Assert.assertTrue(ConditionDropdown.isDisplayed(), "ConditionDropdown is missing");
		log.info("ConditionDropdown is visible");
		ConditionDropdown.click();
		log.info("Condition is selected");
			
		
		WebElement Colorfiled  = driver.findElement(By.xpath(colorfield));
		Assert.assertTrue(Colorfiled.isDisplayed(), "Colorfiled is missing");
		log.info("Colorfiled is visible");
		Colorfiled.sendKeys("Teal");
		log.info("Colorfiled is selected");


		WebElement Factoryfiled  = driver.findElement(By.xpath(factoryfield));
		Assert.assertTrue(Factoryfiled.isDisplayed(), "Factoryfiled is missing");
		log.info("Factoryfiled is visible");
		int num = Random.nextInt(10000);
		Factoryfiled.sendKeys(num + "");
		log.info("Factoryfiled is filled");
		
		WebElement CategoryUnitOrdering  = driver.findElement(By.id("CategoryUnitOrdering"));
		Assert.assertTrue(CategoryUnitOrdering.isDisplayed(), "CategoryUnitOrdering field is missing");
		log.info("CategoryUnitOrdering Field is visible");
		CategoryUnitOrdering.click();
		WebElement CategoryDropdown  = driver.findElement(By.id("category0"));
		Assert.assertTrue(CategoryDropdown.isDisplayed(), "CategoryDropdown is missing");
		log.info("CategoryDropdown is visible");
		CategoryDropdown.click();
		log.info("CategoryDropdown is selected");
		
		JavascriptExecutor ex1 = (JavascriptExecutor) driver;
		ex1.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(5000);
		
//		OrderedDateUnitOrdering
		
		WebElement OrderedDateUnitOrdering  = driver.findElement(By.id("OrderedDateUnitOrdering"));
		Assert.assertTrue(OrderedDateUnitOrdering.isDisplayed(), "OrderedDateUnitOrdering field is missing");
		log.info("OrderedDateUnitOrdering Field is visible");
		OrderedDateUnitOrdering.click();
		Thread.sleep(5000);
		
		WebElement OrderDate = driver.findElement(By.xpath("//a[contains(text(),"+Todaysdate+")]"));
		Assert.assertTrue(OrderDate.isDisplayed(), "OrderDate is missing");
		log.info("OrderDate is visible");
		OrderDate.click();
		log.info("OrderDate is selected");

		
//		ExpectedDateUnitOrdering
		WebElement ExpectedDateUnitOrdering  = driver.findElement(By.id("ExpectedDateUnitOrdering"));
		Assert.assertTrue(ExpectedDateUnitOrdering.isDisplayed(), "ExpectedDateUnitOrdering field is missing");
		log.info("ExpectedDateUnitOrdering Field is visible");
		ExpectedDateUnitOrdering.click();
		Thread.sleep(5000);

		WebElement ExpectDate = driver.findElement(By.xpath("//a[contains(text(),"+Todaysdate+")]"));
		Assert.assertTrue(ExpectDate.isDisplayed(), "ExpectDate is missing");
		log.info("ExpectDate is visible");
		ExpectDate.click();
		log.info("ExpectDate is selected");
		
		WebElement BaseUnitPrice  = driver.findElement(By.xpath(baseUnitPrice));
		Assert.assertTrue(BaseUnitPrice.isDisplayed(), "BaseUnitPrice is missing");
		log.info("BaseUnitPrice is visible");
		BaseUnitPrice.sendKeys(Keys.chord(Keys.CONTROL,"a"),"3000");
		log.info("BaseUnitPrice is filled");
		

		WebElement BaseUnitCost  = driver.findElement(By.xpath(baseUnitCost));
		Assert.assertTrue(BaseUnitCost.isDisplayed(), "BaseUnitCost is missing");
		log.info("BaseUnitCost is visible");
		BaseUnitCost.sendKeys(Keys.chord(Keys.CONTROL,"a"),"2500");
		log.info("BaseUnitCost is filled");
		
		
		WebElement AddPricing  = driver.findElement(By.xpath(addPricing));
		Assert.assertTrue(AddPricing.isDisplayed(), "AddPricing button is missing");
		log.info("AddPricing button is visible");
		AddPricing.click();
		log.info("AddPricing button is clicked");
		Thread.sleep(10000);
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td")));
		WebElement BulkOrder  = driver.findElement(By.xpath("//button[contains(text(),'Bulk')]"));
		Assert.assertTrue(BulkOrder.isDisplayed(), "BulkOrder button is missing");
		log.info("BulkOrder button is visible");
		BulkOrder.click();
		log.info("BulkOrder button is clicked");
		Thread.sleep(10000);
		//wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("bulkHandlingInputId")));
		
		WebElement BulkHandlingInputId  = driver.findElement(By.id("bulkHandlingInputId"));
		Assert.assertTrue(BulkHandlingInputId.isDisplayed(), "BulkHandlingInputId is missing");
		log.info("BulkHandlingInputId is visible");
		BulkHandlingInputId.sendKeys(Keys.chord(Keys.CONTROL,"a"), bulkUnitCount);
		log.info("BulkHandlingInputId is clicked");
		
		
		WebElement ConfirmButton  = driver.findElement(By.id("Confirm"));
		Assert.assertTrue(ConfirmButton.isDisplayed(), "ConfirmButton is missing");
		log.info("ConfirmButton is visible");
		ConfirmButton.click();
		log.info("ConfirmButton is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td/div")));
		
		int Count = driver.findElements(By.xpath("//tr/td[1]/span[1]")).size();
		Count = Count-3;
		Thread.sleep(5000);
		
		for(int i = 0 ; i < Integer.parseInt(bulkUnitCount) ; i++)
		{
			WebElement OrderUnit = driver.findElement(By.xpath("//tr["+(Count-i)+"]/td[1]/span[1]"));
			Assert.assertTrue(OrderUnit.isDisplayed(),"OrderUnit is missing");
			OrderUnit.click();
			log.info("Unit "+(i+1)+" is selected");
		}
		
		log.info("All units are selected");
		
		WebElement Print = driver.findElement(By.xpath("//button[contains(text(),'Print')]"));
		Assert.assertTrue(Print.isDisplayed(), "Print Button is missing");
		log.info("Print Button is visible");
		Print.click();
		log.info("Print Button is clicked");
		
		Set<String> Window = driver.getWindowHandles();
		Iterator<String> it = Window.iterator();
		String ParentID = it.next();
		String ChildID = it.next();
		
		driver.switchTo().window(ChildID);
		Thread.sleep(10000);
		driver.close();
		driver.switchTo().window(ParentID);
		Thread.sleep(3000);
		
		WebElement Receive = driver.findElement(By.xpath("//button[contains(text(),'Receive')]"));
		Assert.assertTrue(Receive.isDisplayed(), "Receive button is missing");
		log.info("Receive button is visible");
		Receive.click();
		log.info("Receive button is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoiceToggle)));
		WebElement InvoiceToggle = driver.findElement(By.xpath(invoiceToggle));
		Assert.assertTrue(InvoiceToggle.isDisplayed(), "InvoiceToggle button is missing");
		log.info("InvoiceToggle button is visible");
		InvoiceToggle.click();
		log.info("InvoiceToggle button is clicked");
		
		
		WebElement InvoiceNumber = driver.findElement(By.xpath(invoiceNumber));
		Assert.assertTrue(InvoiceNumber.isDisplayed(), "InvoiceNumber field is missing");
		log.info("InvoiceNumber Field is visible");
		InvoiceNumber.sendKeys(num +"");
		log.info("InvoiceNumber Field is clicked");
		
		
		WebElement InvoiceDate = driver.findElement(By.id("invoiceDate"));
		Assert.assertTrue(InvoiceDate.isDisplayed(), "InvoiceDate field is missing");
		log.info("InvoiceDate field is visible");
		InvoiceDate.click();
		log.info("InvoiceDate field is clicked");
		Thread.sleep(2000);
		
		WebElement SelectrDate = driver.findElement(By.xpath("//a[contains(text(),"+Todaysdate+")]"));
		Assert.assertTrue(SelectrDate.isDisplayed(), "SelectrDate is missing");
		log.info("SelectrDate is visible");
		SelectrDate.click();
		log.info("SelectrDate is selected");
		
		int VinFieldCount = driver.findElements(By.xpath("//tr/td[2]/input")).size();
		
		for(int i = 1 ; i <= VinFieldCount ; i++)
		{
			WebElement VinField = driver.findElement(By.xpath("//tr["+i+"]/td[2]/input"));
			Assert.assertTrue(VinField.isDisplayed(), "VinField "+i+" is missing");
			VinField.sendKeys(num + "_" +i);
			if(i==3)
			{
				JavascriptExecutor ex2 = (JavascriptExecutor) driver;
				ex2.executeScript("window.scrollBy(0,1000)", "");
			}
			log.info("Vin Field "+i+" is filled");

		}
		
		
		WebElement Confirm = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
		Assert.assertTrue(Confirm.isDisplayed(), "Confirm Button is missing");
		log.info("Confirm button is visible");
		Confirm.click();
		log.info("Confirm button is selected");
		Thread.sleep(5000);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'order history')]"))).click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tr/td[contains(text(),"+num+")])["+VinFieldCount+"]")));
		Thread.sleep(5000);
		
		for(int i = 1; i<=VinFieldCount ; i++)
		{
		
		WebElement ReceivedUnit = driver.findElement(By.xpath("(//tr/td[contains(text(),"+num+")])["+(i)+"]"));
		Assert.assertTrue(ReceivedUnit.getText().contains(num+""), "ReceivedUnit is missing");
		log.info("ReceivedUnit is visible");
		
		WebElement UNTNumber = driver.findElement(By.xpath("//tr/td/span[contains(text(),'UNT')]"));
		Assert.assertTrue(UNTNumber.isDisplayed(), "ReceivedUnit is missing");
		log.info("UNTNumber is " +UNTNumber);
		
		}
		
	}

	@Test(priority = 38)
	public static void PartOrderReceiveInvoice() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver,100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("globalSearchStrInput")));
		WebElement GlobalSearch = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(GlobalSearch.isDisplayed(), "GlobalSearch is missing");
		log.info("GlobalSearch is visible");
		GlobalSearch.sendKeys(searchPart);
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchResult_0")));
		WebElement SearchResult = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(SearchResult.isDisplayed(), "SearchResult is missing");
		log.info("SearchResult is visible");
		SearchResult.click();
		log.info("Part is selected");
		Thread.sleep(20000);

		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(qtyinStock)));
		WebElement QTYinStockBefore = driver.findElement(By.xpath(qtyinStock));
		Assert.assertTrue(QTYinStockBefore.isDisplayed(), "QTYinStockBefore is missing");
		String PartQtytextBefore = QTYinStockBefore.getText();
		int PartQTYBefore = Integer.parseInt(PartQtytextBefore);
		log.info(PartQtytextBefore+" parts are instock");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(order)));
		WebElement Order = driver.findElement(By.xpath(order));
		Assert.assertTrue(Order.isDisplayed(), "Order link is missing");
		log.info("Order link is visible");
		Order.click();
		log.info("Order link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(orderoptions)));
		WebElement PartOrder = driver.findElement(By.xpath(partorder));
		Assert.assertTrue(PartOrder.isDisplayed(), "PartOrder link is missing");
		log.info("PartOrder link is visible");
		PartOrder.click();
		log.info("PartOrder link is clicked");
		Thread.sleep(5000);	
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchCustomer_Input")));
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Select a Vendor')]"))
						.getText().contains("Select a Vendor"), "Header Text is missing" );
		
		WebElement Vendor_Input1 = driver.findElement(By.id("searchCustomer_Input"));
		Assert.assertTrue(Vendor_Input1.isDisplayed(), "Vendor_Input is missing");
		log.info("Vendor_Input is visible");
		Vendor_Input1.sendKeys(vendor_Input);
		log.info("Vendor_Input is filled");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchResult_0")));
		WebElement SearchResult1 = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(SearchResult1.isDisplayed(), "SearchResult is missing");
		log.info("SearchResult is visible");
		SearchResult1.click();
		log.info("SearchResult is selected");
		Thread.sleep(5000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add items')]")));
		WebElement AddItems = driver.findElement(By.xpath("//span[contains(text(),'Add items')]"));
		Assert.assertTrue(AddItems.isDisplayed(), "AddItems link is missing");
		log.info("AddItems link is visible");
		AddItems.click();
		log.info("AddItems link is clicked");
		
		
		WebElement SearchPart  = driver.findElement(By.id("SearchToaddCutomer"));
		Assert.assertTrue(SearchPart.isDisplayed(), "SearchPart field is missing");
		log.info("SearchPart field is visible");
		SearchPart.sendKeys(searchPart);
		log.info("Part Name is entered");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchResult_0")));
		WebElement PartName = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(PartName.isDisplayed(), "PartName is missing");
		log.info("PartName is visible");
		PartName.click();
		log.info("PartName is selected");
		Thread.sleep(10000);
		
		WebElement Need = driver.findElement(By.id("VO_Group_block_grid_container_expend_tbody_tr_td_3_0"));
		Need.sendKeys(Keys.chord(Keys.CONTROL,"a"),"2");
		Thread.sleep(2000);
		WebElement Neededfor = driver.findElement(By.xpath("(//div[contains(text(),'Stock')])[1]"));
		Neededfor.click();
		Thread.sleep(10000);
					
		WebElement ApplyBtn = driver.findElement
		(By.id("vogroup_tbody_expandtr_edit_box_its-heading_edit-body_0_go_btn"));
		Assert.assertTrue(ApplyBtn.isDisplayed(), "ApplyBtn is missing");
		log.info("ApplyBtn is visible");
		ApplyBtn.click();
		log.info("ApplyBtn is clicked");
		Thread.sleep(10000);
		String Status1 = driver.findElement(By.xpath("//label[contains(text(),'Open')]")).getText();
		log.info("The Status is " +Status1);
		
//		JavascriptExecutor ex1 = (JavascriptExecutor) driver;
//		ex1.executeScript("window.scrollBy(0,100)", "");
		
		WebElement SubmitOrder = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		Assert.assertTrue(SubmitOrder.isDisplayed(), "SubmitOrder button is missing");
		log.info("SubmitOrder button is visible");
		SubmitOrder.click();
		log.info("SubmitOrder button is clicked");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String Status2 = driver.findElement(By.xpath("//label[contains(text(),'On Order')]")).getText();
		log.info("The Status is " +Status2);
		
		String VONumber = driver.findElement(By.xpath("//span[contains(text(),'VO-')]")).getText();
		log.info("The Status is " +VONumber);
		
		Order.click();
		log.info("Order link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(orderoptions)));
		WebElement PartReceiving = driver.findElement(By.xpath(partReceiving));
		Assert.assertTrue(PartReceiving.isDisplayed(), "PartReceiving link is missing");
		log.info("PartReceiving link is visible");
		PartReceiving.click();
		log.info("PartReceiving link is clicked");
		Thread.sleep(5000);	
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchCustomer_Input")));
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Select a Vendor')]"))
						.getText().contains("Select a Vendor"), "Header Text is missing" );
		
		WebElement Vendor_Input2 = driver.findElement(By.id("searchCustomer_Input"));
		Assert.assertTrue(Vendor_Input2.isDisplayed(), "Vendor_Input is missing");
		log.info("Vendor_Input is visible");
		Vendor_Input2.sendKeys(vendor_Input);
		log.info("Vendor_Input is filled");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchResult_0")));
		WebElement SearchResult2 = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(SearchResult2.isDisplayed(), "SearchResult is missing");
		log.info("SearchResult is visible");
		SearchResult2.click();
		log.info("SearchResult is selected");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		//span[contains(text(),'In Progress')]
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'In Progress')]")));
		String Status3 = driver.findElement(By.xpath("//span[contains(text(),'In Progress')]")).getText();
		log.info("The Status is " +Status3);
		
		
		WebElement PackingSlipNumber = driver.findElement(By.id("packingSlipNumber"));
		Assert.assertTrue(PackingSlipNumber.isDisplayed(), "PackingSlipNumber is missing");
		log.info("PackingSlipNumber is visible");
		int num = Random.nextInt(100000);
		PackingSlipNumber.sendKeys(num+"");
		log.info("PackingSlipNumber is filled");
		
		WebElement PartCheckbox1 = driver.findElement(By.xpath(partCheckbox));
		Assert.assertTrue(PartCheckbox1.isDisplayed(), "PartCheckbox is missing");
		log.info("PartCheckbox is visible");
		PartCheckbox1.click();
		log.info("PartCheckbox is selected");
		Thread.sleep(10000);
		
		WebElement AddSelectedButton = driver.findElement(By.xpath("//*[@id=\"BP_Home_mainContainer\"]/div[1]/div[1]/div/div[1]/div[2]/div[2]/div[2]/div[1]/div/div/span[3]/div/button"));
		Assert.assertTrue(AddSelectedButton.isDisplayed(), "AddSelectedButton is missing");
		log.info("AddSelectedButton is visible");
		AddSelectedButton.click();
		log.info("AddSelectedButton is clicked");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement PrintReceiving = driver.findElement(By.xpath(printReceiving));
		Assert.assertTrue(PrintReceiving.isDisplayed(), "PrintReceiving button is missing");
		log.info("PrintReceiving button is visible");
		PrintReceiving.click();
		log.info("PrintReceiving button is clicked");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("BrandingLocationInput")));
		WebElement SetBrandingLocationModalWindow = driver.findElement(By.xpath(setBrandingLocationModalWindow));
		Assert.assertTrue(SetBrandingLocationModalWindow.isDisplayed(), "SetBrandingLocationModalWindow is missing");
		log.info("SetBrandingLocationModalWindow is visible");
		Assert.assertTrue(SetBrandingLocationModalWindow.getText().contains("BRANDING LOCATION"));
		
		
		WebElement BrandingLocationInput = driver.findElement(By.id("BrandingLocationInput"));
		Assert.assertTrue(BrandingLocationInput.isDisplayed(), "BrandingLocationInput is missing");
		log.info("BrandingLocationInput is visible");
		BrandingLocationInput.click();
		log.info("BrandingLocationInput is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("BLDropdownDiv")));
		WebElement BLDropdownDiv = driver.findElement(By.id("BLDropdownDiv"));
		Assert.assertTrue(BLDropdownDiv.isDisplayed(), "BLDropdownDiv is missing");
		log.info("BLDropdownDiv is visible");
		BLDropdownDiv.click();
		log.info("BLDropdownDiv is clicked");
		
		WebElement ConfirmButton = driver.findElement(By.xpath(confirmButton));
		Assert.assertTrue(ConfirmButton.isDisplayed(), "ConfirmButton is missing");
		log.info("ConfirmButton is visible");
		ConfirmButton.click();
		log.info("ConfirmButton is clicked");
		Thread.sleep(5000);
		 
//		WebElement PrintReceiving1 = driver.findElement(By.xpath(printReceiving));
//		Assert.assertTrue(PrintReceiving1.isDisplayed(), "PrintReceiving button is missing");
//		log.info("PrintReceiving button is visible");
		//wt.until(ExpectedConditions.elementToBeClickable(By.xpath(printReceiving))).click();
		//PrintReceiving1.click();
		JavascriptExecutor executer1 = (JavascriptExecutor) driver;
		executer1.executeScript("arguments[0].click();", PrintReceiving);
		log.info("PrintReceiving button is clicked");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String ParentID = it.next();
		String ChildID = it.next();
		
		driver.switchTo().window(ChildID);
		Assert.assertTrue(driver.getCurrentUrl().contains("PrintVendorOrderReceiving"));
		log.info("Vendor Order Receiving PDF is generated");
		driver.close();
		driver.switchTo().window(ParentID);
		
		
		WebElement CommitReceivingButton = driver.findElement(By.xpath("//button[contains(text(),'Commit')]"));
		Assert.assertTrue(CommitReceivingButton.isDisplayed(), "Commit Receiving Button is missing");
		log.info("Commit Receiving Button is visible");
		CommitReceivingButton.click();
		log.info("Commit Receiving Button is clicked");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Stocked')]")));
		String Status4 = driver.findElement(By.xpath("//span[contains(text(),'Stocked')]")).getText();
		log.info("The Status is " +Status4);
		
		String VRNumber = driver.findElement(By.xpath("//span[contains(text(),'VR-')]")).getText();
		log.info("The Status is " +VRNumber);
		
		Order.click();
		log.info("Order link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(orderoptions)));
		WebElement PartInvoices = driver.findElement(By.xpath(partInvoices));
		Assert.assertTrue(PartInvoices.isDisplayed(), "PartInvoices link is missing");
		log.info("PartInvoices link is visible");
		PartInvoices.click();
		log.info("PartInvoices link is clicked");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchCustomer_Input")));
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Select a Vendor')]"))
						.getText().contains("Select a Vendor"), "Header Text is missing" );
		log.info("Header Text is visible");
		WebElement Vendor_Input3 = driver.findElement(By.id("searchCustomer_Input"));
		Assert.assertTrue(Vendor_Input3.isDisplayed(), "Vendor_Input is missing");
		log.info("Vendor_Input is visible");
		Vendor_Input3.sendKeys(vendor_Input);
		log.info("Vendor_Input is filled");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchResult_0")));
		WebElement SearchResult3 = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(SearchResult3.isDisplayed(), "SearchResult is missing");
		log.info("SearchResult is visible");
		SearchResult3.click();
		log.info("SearchResult is selected");

		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'In Progress')]")));
		String Status5 = driver.findElement(By.xpath("//span[contains(text(),'In Progress')]")).getText();
		log.info("The Status is " +Status5);		
		
		WebElement InvoiceNumber = driver.findElement(By.id("InvoiceNumber"));
		Assert.assertTrue(InvoiceNumber.isDisplayed(), "InvoiceNumber is missing");
		log.info("InvoiceNumber is visible");
		InvoiceNumber.sendKeys(num+"");
		log.info("InvoiceNumber is filled");
		
		WebElement PartCheckbox2 = driver.findElement(By.xpath(partCheckbox));
		Assert.assertTrue(PartCheckbox2.isDisplayed(), "PartCheckbox is missing");
		log.info("PartCheckbox is visible");
		PartCheckbox2.click();
		log.info("PartCheckbox is selected");
		
		JavascriptExecutor ex1 = (JavascriptExecutor) driver;
		ex1.executeScript("window.scrollBy(0,600)", "");
		Thread.sleep(5000);
				
//		WebElement ItemDesc = driver.findElement(By.xpath("//a[contains(text(),"+searchPart+")]"));
//		Assert.assertTrue(ItemDesc.getText().contains(searchPart), "ItemDesc is missing");
//		log.info(searchPart+ " is visible");
		
		WebElement FinalizeInvoice = driver.findElement(By.xpath("//button[contains(text(),'Finalize')]"));
		Assert.assertTrue(FinalizeInvoice.isDisplayed(), "Finalize Invoice Button is missing");
		log.info("Finalize Invoice Button is visible");
		FinalizeInvoice.click();
		log.info("Finalize Invoice Button is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Invoiced')]")));
		String Status6 = driver.findElement(By.xpath("//span[contains(text(),'Invoiced')]")).getText();
		log.info("The Status is " +Status6);
		
		String VINumber = driver.findElement(By.xpath("//span[contains(text(),'VI-')]")).getText();
		log.info("The Status is " +VINumber);
		
//		WebElement GlobalSearch1 = driver.findElement(By.xpath(order));
//		Assert.assertTrue(GlobalSearch1.isDisplayed(), "GlobalSearch is missing");
//		log.info("GlobalSearch is visible");
		GlobalSearch.sendKeys(searchPart);
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchResult_0")));
		WebElement SearchResult4 = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(SearchResult4.isDisplayed(), "SearchResult is missing");
		log.info("SearchResult is visible");
		SearchResult4.click();
		log.info("Part is selected");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(qtyinStock)));
		WebElement QTYinStockAfter = driver.findElement(By.xpath(qtyinStock));
		Assert.assertTrue(QTYinStockAfter.isDisplayed(), "QTYinStockBefore is missing");
		int PartQTYAfter = Integer.parseInt(QTYinStockAfter.getText());
		log.info(PartQTYAfter+" parts are instock");
		
		int OrderedQty = PartQTYAfter - PartQTYBefore;
		log.info("Succesfully Ordered " +OrderedQty+ " Parts from vendor " +vendor_Input);
		System.out.println("Succesfully Ordered " +OrderedQty+ " Parts from vendor " +vendor_Input);
	}

	@Test(priority = 39)
	public static void PartOrderfromCO() throws Exception
	{
		SelectCustomer();
		WebDriverWait wt = new WebDriverWait(driver, 100);
		WebElement SellPartandAccs = driver.findElement(By.xpath(sellpartandaccs));
		Assert.assertTrue(SellPartandAccs.isDisplayed(), "SellPartandAccs button is missing");
		log.info("SellPartandAccs button is visible");
		SellPartandAccs.click();
		log.info("SellPartandAccs button is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocompleteMerchandiseSectionWrapperId")));
		WebElement Searchbox = driver.findElement(By.id("autocompleteMerchandiseSectionWrapperId"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		log.info("Searchbox is visible");
		
//		Searchbox.sendKeys(Masterdata.NewPart);
		Searchbox.sendKeys(outofstockPart);
		Thread.sleep(10000);
		WebElement Merchentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Merchentity.isDisplayed(), "Merchentity is missing");
		log.info("Merchentity is visible");
		Merchentity.click();
		Thread.sleep(10000);
		log.info("Merchentity is selected");
		
		
//		WebElement PartQty = driver.findElement(By.id("Merchandise_Section_COKitHeader0_COLI0_Qty"));
//		Assert.assertTrue(PartQty.isDisplayed(), "PartQty is missing");
//		log.info("PartQty is visible");
//		PartQty.sendKeys(Keys.chord(Keys.CONTROL,"a"), "1");
//		Thread.sleep(3000);
		
		WebElement PartStatus = driver.findElement(By.xpath(partstatus));
		Assert.assertTrue(PartStatus.isDisplayed(), "PartStatus is missing");
		log.info("PartStatus is visible");
		Assert.assertTrue(PartStatus.getText().contains("Required"),"Part is not required");
		log.info("PartStatus is " +PartStatus.getText());
		
		
		String CONumber = driver.findElement(By.xpath("//h2[contains(text(),'CO-')]")).getText();
		log.info("The CONumber is " +CONumber);
		System.out.println("The CONumber is " +CONumber);
				
		WebElement Order = driver.findElement(By.xpath(order));
		Assert.assertTrue(Order.isDisplayed(), "Order link is missing");
		log.info("Order link is visible");
		Order.click();
		while(true)
		{
			Thread.sleep(10000);
			Order.click();
			if (driver.findElement(By.xpath(partorder)).isDisplayed())
			log.info("Order link is clicked");
			break;
		}
		
		
//		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(orderoptions)));
		WebElement PartOrder = driver.findElement(By.xpath(partorder));
		Assert.assertTrue(PartOrder.isDisplayed(), "PartOrder link is missing");
		log.info("PartOrder link is visible");
		PartOrder.click();
		log.info("PartOrder link is clicked");
		Thread.sleep(5000);	
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchCustomer_Input")));
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Select a Vendor')]"))
						.getText().contains("Select a Vendor"), "Header Text is missing" );
		
		WebElement Vendor_Input1 = driver.findElement(By.id("searchCustomer_Input"));
		Assert.assertTrue(Vendor_Input1.isDisplayed(), "Vendor_Input is missing");
		log.info("Vendor_Input is visible");
		Vendor_Input1.sendKeys(vendor_Input);
		log.info("Vendor_Input is filled");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchResult_0")));
		WebElement SearchResult1 = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(SearchResult1.isDisplayed(), "SearchResult is missing");
		log.info("SearchResult is visible");
		SearchResult1.click();
		log.info("SearchResult is selected");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(partCheckbox)));
		WebElement PartCheckbox1 = driver.findElement(By.xpath("//tr/th/div/label/span"));
		Assert.assertTrue(PartCheckbox1.isDisplayed(), "PartCheckbox is missing");
		log.info("PartCheckbox is visible");
		PartCheckbox1.click();
		log.info("PartCheckbox is selected");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addSelectedButton)));
		WebElement AddSelectedButton = driver.findElement(By.xpath(addSelectedButton));												
		Assert.assertTrue(AddSelectedButton.isDisplayed(), "AddSelectedButton is missing");
		log.info("AddSelectedButton is visible");
		AddSelectedButton.click();
		log.info("AddSelectedButton is clicked");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		JavascriptExecutor ex1 = (JavascriptExecutor) driver;
		ex1.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(5000);
		
		WebElement SubmitOrder = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		Assert.assertTrue(SubmitOrder.isDisplayed(), "SubmitOrder button is missing");
		log.info("SubmitOrder button is visible");
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", SubmitOrder);
//		SubmitOrder.click();
		log.info("SubmitOrder button is clicked");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String Status2 = driver.findElement(By.xpath("//label[contains(text(),'On Order')]")).getText();
		log.info("The Status is " +Status2);
		
		String VONumber = driver.findElement(By.xpath("//span[contains(text(),'VO-')]")).getText();
		log.info("The Status is " +VONumber);
		
		Order.click();
		log.info("Order link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(orderoptions)));
		WebElement PartReceiving = driver.findElement(By.xpath(partReceiving));
		Assert.assertTrue(PartReceiving.isDisplayed(), "PartReceiving link is missing");
		log.info("PartReceiving link is visible");
		PartReceiving.click();
		log.info("PartReceiving link is clicked");
		Thread.sleep(5000);	
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchCustomer_Input")));
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Select a Vendor')]"))
						.getText().contains("Select a Vendor"), "Header Text is missing" );
		
		WebElement Vendor_Input2 = driver.findElement(By.id("searchCustomer_Input"));
		Assert.assertTrue(Vendor_Input2.isDisplayed(), "Vendor_Input is missing");
		log.info("Vendor_Input is visible");
		Vendor_Input2.sendKeys(vendor_Input);
		log.info("Vendor_Input is filled");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchResult_0")));
		WebElement SearchResult2 = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(SearchResult2.isDisplayed(), "SearchResult is missing");
		log.info("SearchResult is visible");
		SearchResult2.click();
		log.info("SearchResult is selected");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		//span[contains(text(),'In Progress')]
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'In Progress')]")));
		String Status3 = driver.findElement(By.xpath("//span[contains(text(),'In Progress')]")).getText();
		log.info("The Status is " +Status3);
		
		
		WebElement PackingSlipNumber = driver.findElement(By.id("packingSlipNumber"));
		Assert.assertTrue(PackingSlipNumber.isDisplayed(), "PackingSlipNumber is missing");
		log.info("PackingSlipNumber is visible");
		int num = Random.nextInt(100000);
		PackingSlipNumber.sendKeys(num+"");
		log.info("PackingSlipNumber is filled");
		
		WebElement PartCheckbox2 = driver.findElement(By.xpath(partCheckbox));
		Assert.assertTrue(PartCheckbox2.isDisplayed(), "PartCheckbox is missing");
		log.info("PartCheckbox is visible");
		PartCheckbox2.click();
		log.info("PartCheckbox is selected");
		Thread.sleep(10000);
		
		WebElement AddSelectedButton2 = driver.findElement(By.xpath("//*[@id=\"BP_Home_mainContainer\"]/div[1]/div[1]/div/div[1]/div[2]/div[2]/div[2]/div[1]/div/div/span[3]/div/button"));
		Assert.assertTrue(AddSelectedButton2.isDisplayed(), "AddSelectedButton is missing");
		log.info("AddSelectedButton is visible");
		AddSelectedButton2.click();
		log.info("AddSelectedButton is clicked");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement PrintReceiving = driver.findElement(By.xpath(printReceiving));
		Assert.assertTrue(PrintReceiving.isDisplayed(), "PrintReceiving button is missing");
		log.info("PrintReceiving button is visible");
		PrintReceiving.click();
		log.info("PrintReceiving button is clicked");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("BrandingLocationInput")));
		WebElement SetBrandingLocationModalWindow = driver.findElement(By.xpath(setBrandingLocationModalWindow));
		Assert.assertTrue(SetBrandingLocationModalWindow.isDisplayed(), "SetBrandingLocationModalWindow is missing");
		log.info("SetBrandingLocationModalWindow is visible");
		Assert.assertTrue(SetBrandingLocationModalWindow.getText().contains("BRANDING LOCATION"));
		
		
		WebElement BrandingLocationInput = driver.findElement(By.id("BrandingLocationInput"));
		Assert.assertTrue(BrandingLocationInput.isDisplayed(), "BrandingLocationInput is missing");
		log.info("BrandingLocationInput is visible");
		BrandingLocationInput.click();
		log.info("BrandingLocationInput is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("BLDropdownDiv")));
		WebElement BLDropdownDiv = driver.findElement(By.id("BLDropdownDiv"));
		Assert.assertTrue(BLDropdownDiv.isDisplayed(), "BLDropdownDiv is missing");
		log.info("BLDropdownDiv is visible");
		BLDropdownDiv.click();
		log.info("BLDropdownDiv is clicked");
		
		WebElement ConfirmButton = driver.findElement(By.xpath(confirmButton));
		Assert.assertTrue(ConfirmButton.isDisplayed(), "ConfirmButton is missing");
		log.info("ConfirmButton is visible");
		ConfirmButton.click();
		log.info("ConfirmButton is clicked");
		
		JavascriptExecutor ex2 = (JavascriptExecutor) driver;
		ex2.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(5000);

		WebElement CommitReceivingButton = driver.findElement(By.xpath("//button[contains(text(),'Commit')]"));
		Assert.assertTrue(CommitReceivingButton.isDisplayed(), "Commit Receiving Button is missing");
		log.info("Commit Receiving Button is visible");
		CommitReceivingButton.click();
		log.info("Commit Receiving Button is clicked");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Stocked')]")));
		String Status4 = driver.findElement(By.xpath("//span[contains(text(),'Stocked')]")).getText();
		log.info("The Status is " +Status4);
		
		String VRNumber = driver.findElement(By.xpath("//span[contains(text(),'VR-')]")).getText();
		log.info("The Status is " +VRNumber);
		
		WebElement GlobalSearch = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(GlobalSearch.isDisplayed(), "GlobalSearch is missing");
		log.info("GlobalSearch is visible");
		GlobalSearch.sendKeys(CONumber);
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchResult_0")));
		WebElement SearchResult = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(SearchResult.isDisplayed(), "SearchResult is missing");
		log.info("SearchResult is visible");
		SearchResult.click();
		log.info("Part is selected");
		Thread.sleep(10000);
				
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(partstatus)));
		WebElement PartStatusAfter = driver.findElement(By.xpath(partstatus));
		Assert.assertTrue(PartStatusAfter.isDisplayed(), "PartStatus is missing");
		log.info("PartStatus is visible");
		Assert.assertTrue(PartStatusAfter.getText().contains("In Stock"),"Part is not in stock");
		log.info("PartStatus is " +PartStatusAfter.getText());
		
		
		WebElement Checkout_Button = driver.findElement(By.xpath(checkout_button));
		Assert.assertTrue(Checkout_Button.isDisplayed(), "Checkout_Button is missing");
		log.info("Checkout_Button is visible");
		Checkout_Button.click();
		Thread.sleep(10000);

		if(driver.findElement(By.xpath(setCashDrawerModalWindow)).isDisplayed())
		{
			driver.findElement(By.id("cashDrawer")).click();
			driver.findElement(By.id("cashDrawerDropdownDiv")).click();
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
		Thread.sleep(10000);
		
		WebElement FinalizeButton = driver.findElement(By.xpath(finalizebutton));
		Assert.assertTrue(FinalizeButton.isDisplayed(), "Finalize Button is missing");
		log.info("Finalize Button is visible");
		FinalizeButton.click();
		log.info("Finalize Button is clicked");
		Thread.sleep(10000);
		
		WebElement InvoiceWindow = driver.findElement(By.xpath(invoicewindow));
		
		Assert.assertTrue(InvoiceWindow.isDisplayed(), "Invoice Window is missing");
		log.info("Invoice Window is visible");
		
//		WebElement Cancel = driver.findElement(By.xpath(cancel));
//		Cancel.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoiceclosebutton)));
		WebElement InvoiceCloseButton = driver.findElement(By.xpath(invoiceclosebutton));
		Assert.assertTrue(InvoiceCloseButton.isDisplayed(), "Invoice Close Button is missing");
		log.info("Invoice Close Button is visible");
		
		// element size zero error
		JavascriptExecutor executer2 = (JavascriptExecutor) driver;
		executer2.executeScript("arguments[0].click();",InvoiceCloseButton );
		log.info("Invoice Close Button is clicked");
		
		Thread.sleep(10000);
		WebElement COStatus = driver.findElement(By.xpath(costatus));
		
		Assert.assertTrue(COStatus.isDisplayed(), "CO Status is missing");
		log.info("CO Status is visible");
		COStatus.getText();
		Assert.assertEquals(COStatus.getText(), "Closed");
		log.info("CO Status is Closed");

	}
	
	@Test(priority = 40)
	public static void SpecialOrder() throws Exception
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
//		Searchbox.sendKeys(Masterdata.NewPart);
		Searchbox1.sendKeys(outofstockPart);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityInfo_0")));
		WebElement Merchentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Merchentity.isDisplayed(), "Merchentity is missing");
		log.info("Merchentity is visible");
		Merchentity.click();
		log.info("Merchentity is selected");

		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("createSpecialOrderActionBtn")));
		WebElement OversoldPopUpText = driver.findElement(By.xpath(oversoldPopUpText));
		Assert.assertTrue(OversoldPopUpText.isDisplayed(), "OversoldPopUpText is missing");
		log.info("OversoldPopUpText is visible");
		Assert.assertTrue(OversoldPopUpText.getText()
		.contains("exceed the amount"),"Oversold Pop Up Text is correctly displayed");
		log.info("OversoldPopUpText is correct");

		
		WebElement CreateSpecialOrderActionBtn = driver.findElement(By.id("createSpecialOrderActionBtn"));
		Assert.assertTrue(CreateSpecialOrderActionBtn.isDisplayed(), "Create Special Order Action Btn is missing");
		log.info("Create Special Order Action Btn is visible");
		CreateSpecialOrderActionBtn.click();
		log.info("Create Special Order Action Btn is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocompleteCustomer")));
		WebElement SelectCustomerField = driver.findElement(By.id("autocompleteCustomer"));
		Assert.assertTrue(SelectCustomerField.isDisplayed(), "Select Customer Field is missing");
		log.info("Select Customer Field is visible");
		SelectCustomerField.sendKeys(defaultUser);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerInfo_0")));
		WebElement CustomerInfo = driver.findElement(By.id("customerInfo_0"));
		Assert.assertTrue(CustomerInfo.isDisplayed(), "CustomerInfo is missing");
		log.info("CustomerInfo is visible");
		CustomerInfo.click();
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(merchandise_Section)));
		String CONumber = driver.findElement(By.xpath("//h2[contains(text(),'CO-')]")).getText();
		log.info("The CONumber is " +CONumber);
		System.out.println("The CONumber is " +CONumber);
				
		WebElement Order = driver.findElement(By.xpath(order));
		Assert.assertTrue(Order.isDisplayed(), "Order link is missing");
		log.info("Order link is visible");
		Order.click();
		log.info("Order link is clicked");

//		while(true)
//		{
//			Thread.sleep(10000);
//			Order.click();
//			if (driver.findElement(By.xpath(partorder)).isDisplayed())
//			log.info("Order link is clicked");
//			break;
//		}
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(orderoptions)));
		WebElement PartOrder = driver.findElement(By.xpath(partorder));
		Assert.assertTrue(PartOrder.isDisplayed(), "PartOrder link is missing");
		log.info("PartOrder link is visible");
		PartOrder.click();
		log.info("PartOrder link is clicked");
		Thread.sleep(5000);	
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchCustomer_Input")));
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Select a Vendor')]"))
						.getText().contains("Select a Vendor"), "Header Text is missing" );
		
		WebElement Vendor_Input1 = driver.findElement(By.id("searchCustomer_Input"));
		Assert.assertTrue(Vendor_Input1.isDisplayed(), "Vendor_Input is missing");
		log.info("Vendor_Input is visible");
		Vendor_Input1.sendKeys(vendor_Input);
		log.info("Vendor_Input is filled");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchResult_0")));
		WebElement SearchResult1 = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(SearchResult1.isDisplayed(), "SearchResult is missing");
		log.info("SearchResult is visible");
		SearchResult1.click();
		log.info("SearchResult is selected");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(partCheckbox)));
		WebElement PartCheckbox1 = driver.findElement(By.xpath("//tr/th/div/label/span"));
		Assert.assertTrue(PartCheckbox1.isDisplayed(), "PartCheckbox is missing");
		log.info("PartCheckbox is visible");
		PartCheckbox1.click();
		log.info("PartCheckbox is selected");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addSelectedButton)));
		WebElement AddSelectedButton = driver.findElement(By.xpath(addSelectedButton));												
		Assert.assertTrue(AddSelectedButton.isDisplayed(), "AddSelectedButton is missing");
		log.info("AddSelectedButton is visible");
		AddSelectedButton.click();
		log.info("AddSelectedButton is clicked");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		JavascriptExecutor ex1 = (JavascriptExecutor) driver;
		ex1.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(5000);
		
		WebElement SubmitOrder = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		Assert.assertTrue(SubmitOrder.isDisplayed(), "SubmitOrder button is missing");
		log.info("SubmitOrder button is visible");
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", SubmitOrder);
//		SubmitOrder.click();
		log.info("SubmitOrder button is clicked");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String Status2 = driver.findElement(By.xpath("//label[contains(text(),'On Order')]")).getText();
		log.info("The Status is " +Status2);
		
		String VONumber = driver.findElement(By.xpath("//span[contains(text(),'VO-')]")).getText();
		log.info("The Status is " +VONumber);
		
		Order.click();
		log.info("Order link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(orderoptions)));
		WebElement PartReceiving = driver.findElement(By.xpath(partReceiving));
		Assert.assertTrue(PartReceiving.isDisplayed(), "PartReceiving link is missing");
		log.info("PartReceiving link is visible");
		PartReceiving.click();
		log.info("PartReceiving link is clicked");
		Thread.sleep(5000);	
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchCustomer_Input")));
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Select a Vendor')]"))
						.getText().contains("Select a Vendor"), "Header Text is missing" );
		
		WebElement Vendor_Input2 = driver.findElement(By.id("searchCustomer_Input"));
		Assert.assertTrue(Vendor_Input2.isDisplayed(), "Vendor_Input is missing");
		log.info("Vendor_Input is visible");
		Vendor_Input2.sendKeys(vendor_Input);
		log.info("Vendor_Input is filled");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchResult_0")));
		WebElement SearchResult2 = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(SearchResult2.isDisplayed(), "SearchResult is missing");
		log.info("SearchResult is visible");
		SearchResult2.click();
		log.info("SearchResult is selected");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		//span[contains(text(),'In Progress')]
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'In Progress')]")));
		String Status3 = driver.findElement(By.xpath("//span[contains(text(),'In Progress')]")).getText();
		log.info("The Status is " +Status3);
		
		
		WebElement PackingSlipNumber = driver.findElement(By.id("packingSlipNumber"));
		Assert.assertTrue(PackingSlipNumber.isDisplayed(), "PackingSlipNumber is missing");
		log.info("PackingSlipNumber is visible");
		int num = Random.nextInt(100000);
		PackingSlipNumber.sendKeys(num+"");
		log.info("PackingSlipNumber is filled");
		
		WebElement PartCheckbox2 = driver.findElement(By.xpath(partCheckbox));
		Assert.assertTrue(PartCheckbox2.isDisplayed(), "PartCheckbox is missing");
		log.info("PartCheckbox is visible");
		PartCheckbox2.click();
		log.info("PartCheckbox is selected");
		Thread.sleep(10000);
		
		WebElement AddSelectedButton2 = driver.findElement(By.xpath("//*[@id=\"BP_Home_mainContainer\"]/div[1]/div[1]/div/div[1]/div[2]/div[2]/div[2]/div[1]/div/div/span[3]/div/button"));
		Assert.assertTrue(AddSelectedButton2.isDisplayed(), "AddSelectedButton is missing");
		log.info("AddSelectedButton is visible");
		AddSelectedButton2.click();
		log.info("AddSelectedButton is clicked");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement PrintReceiving = driver.findElement(By.xpath(printReceiving));
		Assert.assertTrue(PrintReceiving.isDisplayed(), "PrintReceiving button is missing");
		log.info("PrintReceiving button is visible");
		PrintReceiving.click();
		log.info("PrintReceiving button is clicked");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("BrandingLocationInput")));
		WebElement SetBrandingLocationModalWindow = driver.findElement(By.xpath(setBrandingLocationModalWindow));
		Assert.assertTrue(SetBrandingLocationModalWindow.isDisplayed(), "SetBrandingLocationModalWindow is missing");
		log.info("SetBrandingLocationModalWindow is visible");
		Assert.assertTrue(SetBrandingLocationModalWindow.getText().contains("BRANDING LOCATION"));
		
		
		WebElement BrandingLocationInput = driver.findElement(By.id("BrandingLocationInput"));
		Assert.assertTrue(BrandingLocationInput.isDisplayed(), "BrandingLocationInput is missing");
		log.info("BrandingLocationInput is visible");
		BrandingLocationInput.click();
		log.info("BrandingLocationInput is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("BLDropdownDiv")));
		WebElement BLDropdownDiv = driver.findElement(By.id("BLDropdownDiv"));
		Assert.assertTrue(BLDropdownDiv.isDisplayed(), "BLDropdownDiv is missing");
		log.info("BLDropdownDiv is visible");
		BLDropdownDiv.click();
		log.info("BLDropdownDiv is clicked");
		
		WebElement ConfirmButton = driver.findElement(By.xpath(confirmButton));
		Assert.assertTrue(ConfirmButton.isDisplayed(), "ConfirmButton is missing");
		log.info("ConfirmButton is visible");
		ConfirmButton.click();
		log.info("ConfirmButton is clicked");
		
		JavascriptExecutor ex2 = (JavascriptExecutor) driver;
		ex2.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(5000);

		WebElement CommitReceivingButton = driver.findElement(By.xpath("//button[contains(text(),'Commit')]"));
		Assert.assertTrue(CommitReceivingButton.isDisplayed(), "Commit Receiving Button is missing");
		log.info("Commit Receiving Button is visible");
		CommitReceivingButton.click();
		log.info("Commit Receiving Button is clicked");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Stocked')]")));
		String Status4 = driver.findElement(By.xpath("//span[contains(text(),'Stocked')]")).getText();
		log.info("The Status is " +Status4);
		
		String VRNumber = driver.findElement(By.xpath("//span[contains(text(),'VR-')]")).getText();
		log.info("The Status is " +VRNumber);
		
		WebElement GlobalSearch = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(GlobalSearch.isDisplayed(), "GlobalSearch is missing");
		log.info("GlobalSearch is visible");
		GlobalSearch.sendKeys(CONumber);
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchResult_0")));
		WebElement SearchResult = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(SearchResult.isDisplayed(), "SearchResult is missing");
		log.info("SearchResult is visible");
		SearchResult.click();
		log.info("Part is selected");
		Thread.sleep(10000);
				
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(partstatus)));
		WebElement PartStatusAfter = driver.findElement(By.xpath(partstatus));
		Assert.assertTrue(PartStatusAfter.isDisplayed(), "PartStatus is missing");
		log.info("PartStatus is visible");
		Assert.assertTrue(PartStatusAfter.getText().contains("In Stock"),"Part is not in stock");
		log.info("PartStatus is " +PartStatusAfter.getText());
		
		
		WebElement Checkout_Button = driver.findElement(By.xpath(checkout_button));
		Assert.assertTrue(Checkout_Button.isDisplayed(), "Checkout_Button is missing");
		log.info("Checkout_Button is visible");
		Checkout_Button.click();
		Thread.sleep(10000);

		if(driver.findElement(By.xpath(setCashDrawerModalWindow)).isDisplayed())
		{
			driver.findElement(By.id("cashDrawer")).click();
			driver.findElement(By.id("cashDrawerDropdownDiv")).click();
			driver.findElement(By.xpath(selectdrawerbutton)).click();
			Thread.sleep(10000);
			Checkout_Button.click();
			Thread.sleep(10000);
		}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cashoption)));
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
		Thread.sleep(10000);
		
		WebElement FinalizeButton = driver.findElement(By.xpath(finalizebutton));
		Assert.assertTrue(FinalizeButton.isDisplayed(), "Finalize Button is missing");
		log.info("Finalize Button is visible");
		FinalizeButton.click();
		log.info("Finalize Button is clicked");
		Thread.sleep(10000);
		
		WebElement InvoiceWindow = driver.findElement(By.xpath(invoicewindow));
		
		Assert.assertTrue(InvoiceWindow.isDisplayed(), "Invoice Window is missing");
		log.info("Invoice Window is visible");
		
//		WebElement Cancel = driver.findElement(By.xpath(cancel));
//		Cancel.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoiceclosebutton)));
		WebElement InvoiceCloseButton = driver.findElement(By.xpath(invoiceclosebutton));
		Assert.assertTrue(InvoiceCloseButton.isDisplayed(), "Invoice Close Button is missing");
		log.info("Invoice Close Button is visible");
		
		// element size zero error
		JavascriptExecutor executer2 = (JavascriptExecutor) driver;
		executer2.executeScript("arguments[0].click();",InvoiceCloseButton );
		log.info("Invoice Close Button is clicked");
		
		Thread.sleep(10000);
		WebElement COStatus = driver.findElement(By.xpath(costatus));
		
		Assert.assertTrue(COStatus.isDisplayed(), "CO Status is missing");
		log.info("CO Status is visible");
		COStatus.getText();
		Assert.assertEquals(COStatus.getText(), "Closed");
		log.info("CO Status is Closed");
	
	}
	
	@Test(priority = 41)
	public static void Oversold() throws Exception
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
//		Searchbox.sendKeys(Masterdata.NewPart);
		Searchbox1.sendKeys(outofstockPart);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityInfo_0")));
		WebElement Merchentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Merchentity.isDisplayed(), "Merchentity is missing");
		log.info("Merchentity is visible");
		Merchentity.click();
		log.info("Merchentity is selected");

		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("oversoldActionBtn")));
		WebElement OversoldPopUpText = driver.findElement(By.xpath(oversoldPopUpText));
		Assert.assertTrue(OversoldPopUpText.isDisplayed(), "OversoldPopUpText is missing");
		log.info("OversoldPopUpText is visible");
		Assert.assertTrue(OversoldPopUpText.getText()
		.contains("exceed the amount"),"Oversold Pop Up Text is correctly displayed");
		log.info("OversoldPopUpText is correct");

		
		WebElement OversoldActionBtn = driver.findElement(By.id("oversoldActionBtn"));
		Assert.assertTrue(OversoldActionBtn.isDisplayed(), "Oversold Action Btn is missing");
		log.info("Oversold Action Btn is visible");
		OversoldActionBtn.click();
		log.info("Oversold Action Btn is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Oversold')]")));
		WebElement Checkout_Button = driver.findElement(By.xpath(checkout_button));
		Assert.assertTrue(Checkout_Button.isDisplayed(), "Checkout_Button is missing");
		log.info("Checkout_Button is visible");
		Checkout_Button.click();
		Thread.sleep(10000);
		
		if(driver.findElement(By.xpath(setCashDrawerModalWindow)).isDisplayed())
		{
			driver.findElement(By.id("cashDrawer")).click();
			driver.findElement(By.id("cashDrawerDropdownDiv")).click();
			driver.findElement(By.xpath(selectdrawerbutton)).click();
			Thread.sleep(5000);
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
		Thread.sleep(10000);
		
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
		
		WebElement Cancel = driver.findElement(By.xpath(cancel));
		Cancel.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoiceclosebutton)));
		WebElement InvoiceCloseButton = driver.findElement(By.xpath(invoiceclosebutton));
		Assert.assertTrue(InvoiceCloseButton.isDisplayed(), "Invoice Close Button is missing");
		log.info("Invoice Close Button is visible");
		
		// element size zero error
		JavascriptExecutor executer2 = (JavascriptExecutor) driver;
		executer2.executeScript("arguments[0].click();",InvoiceCloseButton );
		log.info("Invoice Close Button is clicked");
		
		Thread.sleep(10000);
		WebElement COStatus = driver.findElement(By.xpath(costatus));
		
		Assert.assertTrue(COStatus.isDisplayed(), "CO Status is missing");
		log.info("CO Status is visible");
		COStatus.getText();
		Assert.assertEquals(COStatus.getText(), "Closed");
		log.info("CO Status is Closed");

	}
	
	@Test(priority = 42)
	public static void PartReturntoVendor() throws Exception
	{
		//debugging remaining
		WebDriverWait wt = new WebDriverWait(driver,100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("globalSearchStrInput")));
		WebElement GlobalSearch = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(GlobalSearch.isDisplayed(), "GlobalSearch is missing");
		log.info("GlobalSearch is visible");
		GlobalSearch.sendKeys(searchPart);
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchResult_0")));
		WebElement SearchResult = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(SearchResult.isDisplayed(), "SearchResult is missing");
		log.info("SearchResult is visible");
		SearchResult.click();
		log.info("Part is selected");
		Thread.sleep(25000);

		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(qtyinStock)));
		WebElement QTYinStockBefore = driver.findElement(By.xpath(qtyinStock));
		Assert.assertTrue(QTYinStockBefore.isDisplayed(), "QTYinStockBefore is missing");
		String PartQtytextBefore = QTYinStockBefore.getText();
		int PartQTYBefore = Integer.parseInt(PartQtytextBefore);
		log.info(PartQtytextBefore+" parts are instock");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(order)));
		WebElement Order = driver.findElement(By.xpath(order));
		Assert.assertTrue(Order.isDisplayed(), "Order link is missing");
		log.info("Order link is visible");
		Order.click();
		log.info("Order link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(orderoptions)));
		WebElement PartReturn = driver.findElement(By.xpath(partReturn));
		Assert.assertTrue(PartReturn.isDisplayed(), "PartReturn link is missing");
		log.info("PartReturn link is visible");
		PartReturn.click();
		log.info("PartReturn link is clicked");
		Thread.sleep(5000);	
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchCustomer_Input")));
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Select a Vendor')]"))
						.getText().contains("Select a Vendor"), "Header Text is missing" );
		
		WebElement Vendor_Input1 = driver.findElement(By.id("searchCustomer_Input"));
		Assert.assertTrue(Vendor_Input1.isDisplayed(), "Vendor_Input is missing");
		log.info("Vendor_Input is visible");
		Vendor_Input1.sendKeys(vendor_Input);
		log.info("Vendor_Input is filled");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchResult_0")));
		WebElement SearchResult1 = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(SearchResult1.isDisplayed(), "SearchResult is missing");
		log.info("SearchResult is visible");
		SearchResult1.click();
		log.info("SearchResult is selected");
		Thread.sleep(5000);
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'In Progress')]")));
		String Status1 = driver.findElement(By.xpath("//span[contains(text(),'In Progress')]")).getText();
		log.info("The Status is " +Status1);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add items')]")));
		WebElement AddItems = driver.findElement(By.xpath("//span[contains(text(),'Add items')]"));
		Assert.assertTrue(AddItems.isDisplayed(), "AddItems link is missing");
		log.info("AddItems link is visible");
		AddItems.click();
		log.info("AddItems link is clicked");
		
		
		WebElement SearchPart  = driver.findElement(By.id("SearchToaddCutomer"));
		Assert.assertTrue(SearchPart.isDisplayed(), "SearchPart field is missing");
		log.info("SearchPart field is visible");
		SearchPart.sendKeys(searchPart);
		log.info("Part Name is entered");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchResult_0")));
		WebElement PartName = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(PartName.isDisplayed(), "PartName is missing");
		log.info("PartName is visible");
		PartName.click();
		log.info("PartName is selected");
		Thread.sleep(10000);
			
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("returnQty_0")));
		WebElement ReturnQty = driver.findElement(By.id("returnQty_0"));
		Assert.assertTrue(ReturnQty.isDisplayed(), "ReturnQty field is missing");
		log.info("ReturnQty field is visible");
		ReturnQty.sendKeys(Keys.chord(Keys.CONTROL,"a"), "1");
		log.info("ReturnQty is filled");
		driver.findElement(By.xpath("(//*[@id='VO_Group_block_grid_container_tbody_tr_td_7_0'])[2]")).click();
		
		JavascriptExecutor ex1 = (JavascriptExecutor) driver;
		ex1.executeScript("window.scrollBy(0,-500)", "");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(rma)));
		WebElement RMA = driver.findElement(By.xpath(rma));
		Assert.assertTrue(RMA.isDisplayed(), "RMA field is missing");
		log.info("RMA field is visible");
		int num = Random.nextInt(100000);
		RMA.sendKeys(num + "");
		
		
		WebElement CreditMemo = driver.findElement(By.xpath(creditMemo));
		Assert.assertTrue(CreditMemo.isDisplayed(), "CreditMemo field is missing");
		log.info("CreditMemo field is visible");
		CreditMemo.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Saved')]")));
		CreditMemo.sendKeys(num + "");
		log.info("RMA field is filled");
		log.info("CreditMemo field is filled");
		
		
			
		WebElement SubmitReturn = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		Assert.assertTrue(SubmitReturn.isDisplayed(), "Submit Return Button is missing");
		log.info("Submit Return Button is visible");
		SubmitReturn.click();
		log.info("Submit Return Button is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Submitted')]")));
		String Status2 = driver.findElement(By.xpath("//span[contains(text(),'Submitted')]")).getText();
		log.info("The Status is " +Status2);
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'Approved')]")));
		WebElement SetAsApproved = driver.findElement(By.xpath("//button[contains(text(),'Approved')]"));
		Assert.assertTrue(SetAsApproved.isDisplayed(), "Set As Approved Button is missing");
		log.info("Set As Approved Button is visible");
		SetAsApproved.click();
		log.info("Set As Approved Button is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Approved')]")));
		String Status3 = driver.findElement(By.xpath("//span[contains(text(),'Approved')]")).getText();
		log.info("The Status is " +Status3);
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'Credit')]")));
		WebElement ProcessCredit = driver.findElement(By.xpath("//button[contains(text(),'Credit')]"));
		Assert.assertTrue(ProcessCredit.isDisplayed(), "Process Credit Button is missing");
		log.info("Process Credit Button is visible");
		ProcessCredit.click();
		log.info("Process Credit Button is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'Credited')]")));
		String Status4 = driver.findElement(By.xpath("//span[contains(text(),'Credited')]")).getText();
		log.info("The Status is " +Status4);
		
		GlobalSearch.sendKeys(searchPart);
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchResult_0")));
		WebElement SearchResult2 = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(SearchResult2.isDisplayed(), "SearchResult is missing");
		log.info("SearchResult is visible");
		SearchResult2.click();
		log.info("Part is selected");
		Thread.sleep(20000);

		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(qtyinStock)));
		WebElement QTYinStockAfter = driver.findElement(By.xpath(qtyinStock));
		Assert.assertTrue(QTYinStockAfter.isDisplayed(), "QTYinStockBefore is missing");
		String PartQtytextAfter = QTYinStockAfter.getText();
		int PartQTYAfter = Integer.parseInt(PartQtytextAfter);
		log.info(PartQtytextAfter+" parts are instock");

		int ReturnedQty = (PartQTYAfter - PartQTYBefore);
		log.info("Succesfully returned " +ReturnedQty+ " Parts to vendor " +vendor_Input);
		System.out.println("Succesfully returned " +ReturnedQty+ " Parts to vendor " +vendor_Input);

		
	}
	
}

