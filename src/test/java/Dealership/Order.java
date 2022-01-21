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
		WebDriverWait wt = new WebDriverWait(driver,20);
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

}
