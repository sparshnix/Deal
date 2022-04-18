package Dealership;

/**
 * BlackPurl Automation
 * Creation date 10-jan-2022
 * By Sparsh Shrivastava
 **/


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

public class DeleteCustomerOnCO extends POM {
	

	
	@Test(priority = 18)
	public static void ConvertintoCashSale() throws Exception 
	{
		SelectCustomer();
		WebDriverWait wt = new WebDriverWait(driver, 20);
		WebElement CustomerHeader = driver.findElement(By.xpath(customerHeader));
		Assert.assertTrue(CustomerHeader.isDisplayed(), "Customer Header is missing");
		log.info("Customer Header is visible");
		CustomerHeader.click();
		log.info("Customer Header is clicked");
		
		WebElement CustomerName = driver.findElement(By.xpath(customerName));
		Assert.assertEquals(CustomerName.getText(), "sparsh-08_12_202112_53_04 shrivastava");
		log.info("Customer Name is correctly displayed");
		
		//Ensure that after clicking delete button, 
		//it will remove customer from CO and CO will become Cash Sale type CO.
		log.info("Ensure that after clicking delete button, "
				+ "it will remove customer from CO and CO will become Cash Sale type CO.");
	
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
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customerlabel)));
		WebElement Customerlabel = driver.findElement(By.xpath(customerlabel));
		Assert.assertEquals(Customerlabel.getText(), "Cash Sale");		
		
		WebElement SectionHeader = driver.findElement(By.xpath(sectionHeader));
		Assert.assertEquals(SectionHeader.getText(), "CASH SALE");
		log.info("CO is Converted into Cash Sale Type");
		
		}	

	@Test(priority = 19)
	public static void DeleteWhenCOClosed() throws Exception 
	{
		SelectCustomer();
		WebDriverWait wt = new WebDriverWait(driver, 20);
	
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(sellpartandaccs)));
		WebElement SellPartandAccs = driver.findElement(By.xpath(sellpartandaccs));
		Assert.assertTrue(SellPartandAccs.isDisplayed(), "SellPartandAccs button is missing");
		log.info("SellPartandAccs button is visible");
		SellPartandAccs.click();
		log.info("SellPartandAccs button is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocompleteMerchandiseSectionWrapperId")));
		WebElement Searchbox = driver.findElement(By.id("autocompleteMerchandiseSectionWrapperId"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		log.info("Searchbox is visible");
		
		Searchbox.sendKeys("Part-21_12_202104_14_55");
		Thread.sleep(10000);
		WebElement Merchentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Merchentity.isDisplayed(), "Merchentity is missing");
		log.info("Merchentity is visible");
		Merchentity.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(merchandiseSectionId)).click();
		Thread.sleep(10000);
		
		
		WebElement Checkout_Button = driver.findElement(By.xpath(checkout_button));
		
		Assert.assertTrue(Checkout_Button.isDisplayed(), "Checkout_Button is missing");
		log.info("Checkout_Button is visible");
		Checkout_Button.click();
		Thread.sleep(10000);

		if(driver.findElement(By.xpath(setCashDrawerModalWindow)).isDisplayed())
		{
			driver.findElement(By.id("cashDrawer")).click();
			driver.findElement(By.id("cashDrawerDropdownDiv")).click();
			driver.findElement(By.id("terminal")).click();
			driver.findElement(By.id("terminalDropdownDiv")).click();
			driver.findElement(By.xpath(selectdrawerbutton)).click();
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
		
		WebElement Cancel = driver.findElement(By.xpath(cancel));
		Cancel.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoiceclosebutton)));
		WebElement InvoiceCloseButton = driver.findElement(By.xpath(invoiceclosebutton));
		Assert.assertTrue(InvoiceCloseButton.isDisplayed(), "Invoice Close Button is missing");
		log.info("Invoice Close Button is visible");
		
		//when the size of element is zero
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("arguments[0].click();", InvoiceCloseButton);
		
		log.info("Invoice Close Button is clicked");
		Thread.sleep(10000);
		
		WebElement COStatus = driver.findElement(By.xpath(costatus));
		
		Assert.assertTrue(COStatus.isDisplayed(), "CO Status is missing");
		log.info("CO Status is visible");
		COStatus.getText();
		Assert.assertEquals(COStatus.getText(), "Closed");
		log.info("CO Status is Closed");

		WebElement CustomerHeader = driver.findElement(By.xpath(customerHeader));
		Assert.assertTrue(CustomerHeader.isDisplayed(), "Customer Header is missing");
		log.info("Customer Header is visible");
		CustomerHeader.click();
		log.info("Customer Header is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deleteButton)));
		WebElement DeleteButton = driver.findElement(By.xpath(deleteButton));
		Assert.assertTrue(DeleteButton.isDisplayed(), "Delete Button is missing");
		log.info("Delete Button is visible");
		DeleteButton.click();
		log.info("Delete Button is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customerErrorModal)));
		WebElement ErrorMessage = driver.findElement(By.xpath(errorMessage));
		String ErrorMessageText = ErrorMessage.getText();
		Assert.assertTrue(ErrorMessageText.contains("An invoice has been generated from the CO."), "Error mesage is missing");	
		log.info("We can't change CO to Cash Sale type CO as an invoice has been generated from the CO.");
		
		WebElement OkButton1 = driver.findElement(By.xpath(okButton1));
		Assert.assertTrue(OkButton1.isDisplayed(), "Ok Button is missing");
		OkButton1.click();
		log.info("OK Button is clicked");

		
	}

	@Test(priority = 20)
	public static void DeleteWhenStoreCredit() throws Exception
	{
		SelectCustomer();
		WebDriverWait wt = new WebDriverWait(driver, 20);
		
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(sellpartandaccs)));
		WebElement SellPartandAccs = driver.findElement(By.xpath(sellpartandaccs));
		Assert.assertTrue(SellPartandAccs.isDisplayed(), "SellPartandAccs button is missing");
		log.info("SellPartandAccs button is visible");
		SellPartandAccs.click();
		log.info("SellPartandAccs button is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocompleteMerchandiseSectionWrapperId")));
		WebElement Searchbox = driver.findElement(By.id("autocompleteMerchandiseSectionWrapperId"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		log.info("Searchbox is visible");
		
		Searchbox.sendKeys("Part-21_12_202104_14_55");
		Thread.sleep(10000);
		WebElement Merchentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Merchentity.isDisplayed(), "Merchentity is missing");
		log.info("Merchentity is visible");
		Merchentity.click();
		Thread.sleep(5000);
		
		WebElement EntityQty = driver.findElement(By.xpath(entityQty));
		Assert.assertTrue(EntityQty.isDisplayed(), "EntityQty is missing");
		log.info("EntityQty is visible");
		EntityQty.sendKeys(Keys.chord(Keys.CONTROL,"a"),"-1");
		driver.findElement(By.xpath(merchandiseSectionId)).click();
		Thread.sleep(10000);
		
		
		WebElement PartStatus = driver.findElement(By.xpath(partStatus));
		Assert.assertTrue(PartStatus.isDisplayed(), "PartStatus is missing");
		String PartStatusText = PartStatus.getText();
		Assert.assertTrue(PartStatusText.contains("Return"), "PartStatusText is missing");
		log.info("Part is rady to be returned");

		driver.findElement(By.xpath(merchandiseSectionId)).click();
		Thread.sleep(10000);
		
		WebElement Checkout_Button = driver.findElement(By.xpath(checkout_button));
		Assert.assertTrue(Checkout_Button.isDisplayed(), "Checkout_Button is missing");
		log.info("Checkout_Button is visible");
		Checkout_Button.click();
		Thread.sleep(10000);

		if(driver.findElement(By.xpath(setCashDrawerModalWindow)).isDisplayed())
		{
			driver.findElement(By.id("cashDrawer")).click();
			driver.findElement(By.id("cashDrawerDropdownDiv")).click();
			driver.findElement(By.id("terminal")).click();
			driver.findElement(By.id("terminalDropdownDiv")).click();
			driver.findElement(By.xpath(selectdrawerbutton)).click();
			Checkout_Button.click();
			Thread.sleep(10000);
		}

		WebElement StroreCreditOption = driver.findElement(By.xpath(stroreCreditOption));
		Assert.assertTrue(StroreCreditOption.isDisplayed(), "Strore Credit Option is missing");
		log.info("Strore Credit Option is visible");
		StroreCreditOption.click();
		log.info("Strore Credit Option is selected");
		
		WebElement RefundPayment = driver.findElement(By.xpath(addpayment));
		Assert.assertTrue(RefundPayment.isDisplayed(), "RefundPayment is missing");
		log.info("RefundPayment is visible");
		RefundPayment.click();
		log.info("RefundPayment is selected");
		Thread.sleep(10000);
		
		WebElement ClosePaymentWindow = driver.findElement(By.xpath(closePaymentWindow));
		Assert.assertTrue(ClosePaymentWindow.isDisplayed(), "ClosePaymentWindow is missing");
		log.info("ClosePaymentWindow is visible");
		JavascriptExecutor executer1 = (JavascriptExecutor) driver;
		executer1.executeScript("arguments[0].click();", ClosePaymentWindow);
		log.info("Payment Window is closed");
		Thread.sleep(10000);
		
		WebElement CustomerHeader = driver.findElement(By.xpath(customerHeader));
		Assert.assertTrue(CustomerHeader.isDisplayed(), "Customer Header is missing");
		log.info("Customer Header is visible");
		CustomerHeader.click();
		log.info("Customer Header is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deleteButton)));
		WebElement DeleteButton = driver.findElement(By.xpath(deleteButton));
		Assert.assertTrue(DeleteButton.isDisplayed(), "Delete Button is missing");
		log.info("Delete Button is visible");
		DeleteButton.click();
		log.info("Delete Button is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customerErrorModal)));
		WebElement ErrorMessage = driver.findElement(By.xpath(errorMessage));
		String ErrorMessageText = ErrorMessage.getText();
		Assert.assertTrue(ErrorMessageText.contains("store credit"), "Error mesage is missing");	
		log.info(ErrorMessageText);
		
		WebElement OkButton1 = driver.findElement(By.xpath(okButton1));
		Assert.assertTrue(OkButton1.isDisplayed(), "Ok Button is missing");
		OkButton1.click();
		log.info("OK Button is clicked");

		
		
	}

	@Test(priority = 21)
	public static void DeleteWhenServicejob() throws Exception
	
	{
		SelectCustomer();
		WebDriverWait wt = new WebDriverWait(driver, 20);		
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
		
		WebElement CustomerHeader = driver.findElement(By.xpath(customerHeader));
		Assert.assertTrue(CustomerHeader.isDisplayed(), "Customer Header is missing");
		log.info("Customer Header is visible");
		CustomerHeader.click();
		log.info("Customer Header is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deleteButton)));
		WebElement DeleteButton = driver.findElement(By.xpath(deleteButton));
		Assert.assertTrue(DeleteButton.isDisplayed(), "Delete Button is missing");
		log.info("Delete Button is visible");
		DeleteButton.click();
		log.info("Delete Button is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customerErrorModal)));
		WebElement ErrorMessage = driver.findElement(By.xpath(errorMessage));
		String ErrorMessageText = ErrorMessage.getText();
		Assert.assertTrue(ErrorMessageText.contains("Service Jobs"), "Error mesage is missing");	
		log.info("CO contains Service Jobs.");
		
		WebElement OkButton5 = driver.findElement(By.xpath(okButton5));
		Assert.assertTrue(OkButton5.isDisplayed(), "Ok Button is missing");
		OkButton5.click();
		log.info("OK Button is clicked");
		
		
	}

			
	@Test(priority = 22)
	public static void DeleteWhenCompletestatus() throws Exception
	
	{
		SelectCustomer();
		WebDriverWait wt = new WebDriverWait(driver, 20);		
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
		Thread.sleep(10000);

		WebElement TempUnitMmodalWindow = driver.findElement(By.xpath(tempUnitMmodalWindow));
		Assert.assertEquals(TempUnitMmodalWindow.getText(), "ADD A NEW CUSTOMER OWNED UNIT");
		log.info("Temp Unit Mmodal Window  is visible");

		WebElement VIN_Unit = driver.findElement(By.id("VIN_Unit"));
		Assert.assertTrue(VIN_Unit.isDisplayed(), "VIN_Unit field is missing");
		log.info("VIN_Unit field is visible");
//		VIN_Unit.sendKeys("Vin" +num);
//		log.info("VIN number is filed");
		
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
		YearAddEditUnit.sendKeys("2020");
		log.info("Year is filed");
		
		WebElement Addbutton = driver.findElement(By.xpath(addbutton));
		Assert.assertTrue(Addbutton.isDisplayed(), "Addbutton is missing");
		log.info("Addbutton is visible");
		Addbutton.click();
		log.info("Addbutton is clicked");
		Thread.sleep(10000);
		
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
		Cause.sendKeys("Fix breaks");
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
		
//		Searchbox.sendKeys(Masterdata.NewPart);
		Searchbox1.sendKeys("Part-21_12_202104_14_55");
		Thread.sleep(10000);
		WebElement Merchentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Merchentity.isDisplayed(), "Merchentity is missing");
		log.info("Merchentity is visible");
		Merchentity.click();
		Thread.sleep(10000);

		driver.findElement(By.xpath(searchentitytext)).click();
		Thread.sleep(10000);
		
		WebElement Notes_For_Customers = driver.findElement(By.xpath(notes_for_customers));
		Notes_For_Customers.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("Notes0")));
		WebElement Notes = driver.findElement(By.id("Notes0"));
		Assert.assertTrue(Notes.isDisplayed(), "Notes field is missing");
		log.info("Notes field is visible");
		Notes.sendKeys("This is a test note");
		
		WebElement TechnicianTime = driver.findElement(By.xpath(techniciantime));
		TechnicianTime.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("Assign_Tech_But_Id_0")));
		WebElement Assign_Tech = driver.findElement(By.id("Assign_Tech_But_Id_0"));
		Assert.assertTrue(Assign_Tech.isDisplayed(), "Assign_Tech button is missing");
		log.info("Assign_Tech button is visible");
		Assign_Tech.click();
		
		WebElement ClockingStaffPopupforCO = driver.findElement(By.xpath(clockingStaffPopupforCO));
		Assert.assertTrue(ClockingStaffPopupforCO.isDisplayed(), "ClockingStaffPopupforCO is missing");
		log.info("ClockingStaffPopupforCO is visible");
		
		WebElement Technician1 = driver.findElement(By.xpath(technician1));
		Technician1.click();
		Thread.sleep(10000);
		WebElement VerifyTechnician = driver.findElement(By.xpath(verifyTechnician));
		Assert.assertTrue(VerifyTechnician.isDisplayed(), "Technician is missing");
		log.info("Technician is successfully assigned");

		WebElement CustomerApproval = driver.findElement(By.xpath(customerapproval));
		Assert.assertTrue(CustomerApproval.isDisplayed(), "Customer Approval button is missing");
		log.info("Customer Approval button is visible");
		CustomerApproval.click();
		log.info("Customer Approval button is clicked");
		Thread.sleep(30000);

		//Moving onto different tab
		Set<String> Windows = driver.getWindowHandles();
		Iterator<String> It = Windows.iterator();
		String ParentID = It.next();
		String ChildID = It.next();
		driver.switchTo().window(ChildID);
		
		WebElement SaveCustomerApproval = driver.findElement(By.xpath(saveCustomerApproval));
		Assert.assertTrue(SaveCustomerApproval.isDisplayed(), "Save Customer Approval button is missing");
		log.info("Save Customer Approval button is visible");
		SaveCustomerApproval.click();
		log.info("Save Customer Approval button is clicked");
		Thread.sleep(10000);
		driver.switchTo().window(ParentID);

		
		WebElement ApprovalID = driver.findElement(By.xpath(approvalID));
		Assert.assertTrue(ApprovalID.isDisplayed(), "Approval ID is missing");
		log.info("Approval ID is " +ApprovalID.getText());
		Thread.sleep(5000);
		//scroll up and click on servicejob tile
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ServicejobElement = driver.findElement(By.xpath(servicejobelement));
		js.executeScript("window.scrollBy(0,-550)", ServicejobElement);
		ServicejobElement.click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(servicejobstatus)));
		WebElement ServiceJobStatus2 = driver.findElement(By.xpath(servicejobstatus));
		Assert.assertTrue(ServiceJobStatus2.isDisplayed(), "Service Job Status is missing");
		log.info("Status is " +ServiceJobStatus2.getText());
		ServiceJobStatus2.click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobstatus)));
		WebElement CompleteStatus = driver.findElement(By.xpath(completestatus));
		Assert.assertTrue(CompleteStatus.isDisplayed(), "Complete Status is missing");
		log.info("Complete Status is displayed");
		
		//when the size of element is zero
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", CompleteStatus);
		log.info("Complete Status is checked");
		
		
		WebElement SaveJobStatus = driver.findElement(By.xpath(savejobstatus));
		Assert.assertTrue(SaveJobStatus.isDisplayed(), "Save button  is missing");
		log.info("Save button is displayed");
		
		//when the size of element is zero
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].click();", SaveJobStatus);
		
		log.info("Save buttton is clicked");
		Thread.sleep(10000);

		WebElement CustomerHeader = driver.findElement(By.xpath(customerHeader));
		Assert.assertTrue(CustomerHeader.isDisplayed(), "Customer Header is missing");
		log.info("Customer Header is visible");
		CustomerHeader.click();
		log.info("Customer Header is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deleteButton)));
		WebElement DeleteButton = driver.findElement(By.xpath(deleteButton));
		Assert.assertTrue(DeleteButton.isDisplayed(), "Delete Button is missing");
		log.info("Delete Button is visible");
		DeleteButton.click();
		log.info("Delete Button is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customerErrorModal)));
		WebElement ErrorMessage = driver.findElement(By.xpath(errorMessage));
		String ErrorMessageText = ErrorMessage.getText();
		Assert.assertTrue(ErrorMessageText.contains("Service Jobs"), "Error mesage is missing");	
		log.info("CO contains Service Jobs.");
		
		WebElement OkButton5 = driver.findElement(By.xpath(okButton5));
		Assert.assertTrue(OkButton5.isDisplayed(), "Ok Button is missing");
		OkButton5.click();
		log.info("OK Button is clicked");
		
		DeleteCOU();
		
	}
	
	@Test(priority = 23)
	public static void DeleteWhenUnitDeal() throws Exception
	
	{
		SelectCustomer();
		WebDriverWait wt = new WebDriverWait(driver, 20);
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

		WebElement CustomerHeader = driver.findElement(By.xpath(customerHeader));
		Assert.assertTrue(CustomerHeader.isDisplayed(), "Customer Header is missing");
		log.info("Customer Header is visible");
		CustomerHeader.click();
		log.info("Customer Header is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deleteButton)));
		WebElement DeleteButton = driver.findElement(By.xpath(deleteButton));
		Assert.assertTrue(DeleteButton.isDisplayed(), "Delete Button is missing");
		log.info("Delete Button is visible");
		DeleteButton.click();
		log.info("Delete Button is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customerErrorModal)));
		WebElement ErrorMessage = driver.findElement(By.xpath(errorMessage));
		String ErrorMessageText = ErrorMessage.getText();
		Assert.assertTrue(ErrorMessageText.contains("Deal"), "Error mesage is missing");	
		log.info("CO contains Deal.");
		
		WebElement OkButton4 = driver.findElement(By.xpath(okButton4));
		Assert.assertTrue(OkButton4.isDisplayed(), "Ok Button is missing");
		JavascriptExecutor executer1 = (JavascriptExecutor) driver;
		executer1.executeScript("arguments[0].click();", OkButton4);
		log.info("OK Button is clicked");
		

	}

	@Test(priority = 24)
	public static void DeleteWhenStockUnit() throws Exception
	{
		SelectCustomer();
		WebDriverWait wt = new WebDriverWait(driver, 20);
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
//		SearchStockunit.sendKeys(Masterdata.NewUnit);
		SearchStockunit.sendKeys("unit");
		Thread.sleep(10000);
		WebElement UnitInfo = driver.findElement(By.id("entityInfo_0"));
		UnitInfo.click();
		log.info("Unit1 is selected");	
		Thread.sleep(5000);
		
		WebElement CustomerHeader = driver.findElement(By.xpath(customerHeader));
		Assert.assertTrue(CustomerHeader.isDisplayed(), "Customer Header is missing");
		log.info("Customer Header is visible");
		CustomerHeader.click();
		log.info("Customer Header is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deleteButton)));
		WebElement DeleteButton = driver.findElement(By.xpath(deleteButton));
		Assert.assertTrue(DeleteButton.isDisplayed(), "Delete Button is missing");
		log.info("Delete Button is visible");
		DeleteButton.click();
		log.info("Delete Button is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customerErrorModal)));
		WebElement ErrorMessage = driver.findElement(By.xpath(errorMessage));
		String ErrorMessageText = ErrorMessage.getText();
		Assert.assertTrue(ErrorMessageText.contains("Deal"), "Error mesage is missing");	
		log.info("CO contains Deal.");
		
		WebElement OkButton4 = driver.findElement(By.xpath(okButton4));
		Assert.assertTrue(OkButton4.isDisplayed(), "Ok Button is missing");
		JavascriptExecutor executer1 = (JavascriptExecutor) driver;
		executer1.executeScript("arguments[0].click();", OkButton4);
		log.info("OK Button is clicked");
	
		
		
	}

	@Test(priority = 25)
	public static void DeleteWhenTemporaryUnit() throws Exception
	
	{
		SelectCustomer();
		WebDriverWait wt = new WebDriverWait(driver, 20);
		WebElement QuoteToggle = driver.findElement(By.xpath(quotetoggle));
		Assert.assertTrue(QuoteToggle.isDisplayed(), "Quote Toggle button is missing");
		log.info("Quote Toggle button is visible");
		QuoteToggle.click();
		log.info("Quote Toggle button is clicked");
		Thread.sleep(10000);
		
		WebElement COstatus = driver.findElement(By.xpath(costatus));
		Assert.assertEquals(COstatus.getText(), "Quote");
		log.info("The status of CO is Quote");
		
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
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settempunit)));

		WebElement SetTempUnit = driver.findElement(By.xpath(settempunit));
		Assert.assertTrue(SetTempUnit.isDisplayed(), "Set Temp Unit button is missing");
		log.info("Set Temp Unit button is visible");
		SetTempUnit.click();
		log.info("Set Temp Unit button is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tempUnitModelWindow)));
		Thread.sleep(5000);
		WebElement MakeUnitOrdering = driver.findElement(By.id("MakeUnitOrdering"));
		Assert.assertTrue(MakeUnitOrdering.isDisplayed(), "Make field is missing");
		log.info("Make field is visible");
		int num1 = random.nextInt(1000);
		String TempMakeName = "Temporary Make " + num1;
		MakeUnitOrdering.sendKeys(TempMakeName);
		log.info("Make field is filled");
		
		WebElement ModelUnitOrdering = driver.findElement(By.id("ModelUnitOrdering"));
		Assert.assertTrue(ModelUnitOrdering.isDisplayed(), "Model field is missing");
		log.info("Model field is visible");
		String TempModelName = "Temporary Model " + num1;
		ModelUnitOrdering.sendKeys(TempModelName);
		log.info("Model field is filled");
		
		
		WebElement SubModelUnitOrdering = driver.findElement(By.id("SubModelUnitOrdering"));
		Assert.assertTrue(SubModelUnitOrdering.isDisplayed(), "Sub Model field is missing");
		log.info("Sub Model field is visible");
		String TempSubModelName = "Temporary Sub Model " + num1;
		SubModelUnitOrdering.sendKeys(TempSubModelName);
		log.info("Sub Model field is filled");
		

		WebElement YearAddEditUnit = driver.findElement(By.id("YearAddEditUnit"));
		Assert.assertTrue(YearAddEditUnit.isDisplayed(), "Year field is missing");
		log.info("Year field is visible");
		YearAddEditUnit.sendKeys("2022");
		log.info("Year field is filled");
		
		WebElement ExteriorColor = driver.findElement(By.xpath(exteriorcolor));
		Assert.assertTrue(ExteriorColor.isDisplayed(), "Exterior Color field is missing");
		log.info("Exterior Color field is visible");
		String Exteriorcolor = "Grey";
		ExteriorColor.sendKeys(Exteriorcolor);
		log.info("Exterior Color field is filled");
		
		WebElement NextButton = driver.findElement(By.xpath(nextButton));
		Assert.assertTrue(NextButton.isDisplayed(), "Next Button is missing");
		log.info("Next Button is visible");
		NextButton.click();
		log.info("Next Button is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("Price_0")));
		
		WebElement Totalprice = driver.findElement(By.id("Price_0"));
		Assert.assertTrue(Totalprice.isDisplayed(), "Totalprice field is missing");
		log.info("Totalprice field is visible");
		Totalprice.sendKeys("2500");
		log.info("Totalprice field is filled");

		WebElement Totalcost = driver.findElement(By.id("Cost_0"));
		Assert.assertTrue(Totalcost.isDisplayed(), "Totalcost field is missing");
		log.info("Totalcost field is visible");
		Totalcost.sendKeys("2000");
		log.info("Totalcost field is filled");
		
		WebElement SavePrice = driver.findElement(By.xpath(savePrice));
		Assert.assertTrue(SavePrice.isDisplayed(), "Save Button is missing");
		log.info("Save Button is visible");
		SavePrice.click();
		log.info("Save Button is clicked");
		Thread.sleep(5000);
		
		WebElement SaveTempUnit = driver.findElement(By.xpath(saveTempUnit));
		Assert.assertTrue(SaveTempUnit.isDisplayed(), "SaveTempUnit Button is missing");
		log.info("SaveTempUnit Button is visible");
		SaveTempUnit.click();
		log.info("SaveTempUnit Button is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(temporaryunit1)));

		WebElement TempUnitName = driver.findElement(By.xpath(tempUnitName));
		Assert.assertTrue(TempUnitName.isDisplayed(), "TempUnitName is missing");
		log.info("TempUnitName is visible");
		Assert.assertTrue(TempUnitName.getText().contains(TempMakeName));
		Assert.assertTrue(TempUnitName.getText().contains(TempModelName));
		log.info("Unit name is displayed correctly");
		Thread.sleep(5000);
		
		WebElement CustomerHeader = driver.findElement(By.xpath(customerHeader));
		Assert.assertTrue(CustomerHeader.isDisplayed(), "Customer Header is missing");
		log.info("Customer Header is visible");
		CustomerHeader.click();
		log.info("Customer Header is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deleteButton)));
		WebElement DeleteButton = driver.findElement(By.xpath(deleteButton));
		Assert.assertTrue(DeleteButton.isDisplayed(), "Delete Button is missing");
		log.info("Delete Button is visible");
		DeleteButton.click();
		log.info("Delete Button is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customerErrorModal)));
		WebElement ErrorMessage = driver.findElement(By.xpath(errorMessage));
		String ErrorMessageText = ErrorMessage.getText();
		Assert.assertTrue(ErrorMessageText.contains("Deal"), "Error mesage is missing");	
		log.info("CO contains Deal.");
		
		WebElement OkButton4 = driver.findElement(By.xpath(okButton4));
		Assert.assertTrue(OkButton4.isDisplayed(), "Ok Button is missing");
		JavascriptExecutor executer1 = (JavascriptExecutor) driver;
		executer1.executeScript("arguments[0].click();", OkButton4);
		log.info("OK Button is clicked");
	

		
	}

	@Test(priority = 26)
	public static void DeleteWhenTradeinUnit() throws Exception
	
	{
		SelectCustomer();
		WebDriverWait wt = new WebDriverWait(driver, 20);
		WebElement QuoteToggle = driver.findElement(By.xpath(quotetoggle));
		Assert.assertTrue(QuoteToggle.isDisplayed(), "Quote Toggle button is missing");
		log.info("Quote Toggle button is visible");
		QuoteToggle.click();
		log.info("Quote Toggle button is clicked");
		Thread.sleep(10000);
		
		WebElement COstatus = driver.findElement(By.xpath(costatus));
		Assert.assertEquals(COstatus.getText(), "Quote");
		log.info("The status of CO is Quote");
		
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
		
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(5000);
		
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
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tempUnitMmodalWindow)));
		JavascriptExecutor ex1 = (JavascriptExecutor) driver;
		ex1.executeScript("window.scrollBy(0,-500)", "");
		WebElement TempUnitMmodalWindow = driver.findElement(By.xpath(tempUnitMmodalWindow));
		Assert.assertEquals(TempUnitMmodalWindow.getText(), "ADD A NEW CUSTOMER OWNED UNIT");
		log.info("Temp Unit Mmodal Window  is visible");
		Thread.sleep(5000);
		
//		WebElement VIN_Unit = driver.findElement(By.id("VIN_Unit"));
//		Assert.assertTrue(VIN_Unit.isDisplayed(), "VIN_Unit field is missing");
//		int num = random.nextInt(1000);
//		log.info("VIN_Unit field is visible");
//		VIN_Unit.sendKeys("Vin" +num);
//		log.info("VIN number is filed");
		
		WebElement MakeUnitOrdering1 = driver.findElement(By.id("MakeUnitOrdering"));
		Assert.assertTrue(MakeUnitOrdering1.isDisplayed(), "Make field is missing");
		log.info("Make field is visible");
		int num = random.nextInt(1000);
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
			
		WebElement CustomerHeader = driver.findElement(By.xpath(customerHeader));
		Assert.assertTrue(CustomerHeader.isDisplayed(), "Customer Header is missing");
		log.info("Customer Header is visible");
		CustomerHeader.click();
		log.info("Customer Header is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deleteButton)));
		WebElement DeleteButton = driver.findElement(By.xpath(deleteButton));
		Assert.assertTrue(DeleteButton.isDisplayed(), "Delete Button is missing");
		log.info("Delete Button is visible");
		DeleteButton.click();
		log.info("Delete Button is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customerErrorModal)));
		WebElement ErrorMessage = driver.findElement(By.xpath(errorMessage));
		String ErrorMessageText = ErrorMessage.getText();
		Assert.assertTrue(ErrorMessageText.contains("Deal"), "Error mesage is missing");	
		log.info("CO contains Deal.");
		
		WebElement OkButton4 = driver.findElement(By.xpath(okButton4));
		Assert.assertTrue(OkButton4.isDisplayed(), "Ok Button is missing");
		JavascriptExecutor executer1 = (JavascriptExecutor) driver;
		executer1.executeScript("arguments[0].click();", OkButton4);
		log.info("OK Button is clicked");
	

		
		
	}

}