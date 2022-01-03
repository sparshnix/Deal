package Dealership;

import static org.testng.Assert.expectThrows;

/**
 * BlackPurl Automation
 * Creation date 7-dec-2021
 * By Sparsh Shrivastava
 */

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
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

public class Sell extends POM {
	
	private static Logger log = LogManager.getLogger(POM.class.getName());
	
	@Test(priority = 13)
	public static void sell() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 20);
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
//		SelectCustomerDropdown.sendKeys(Masterdata.NewCustomer);
		SelectCustomerField.sendKeys("sparsh-08_12_202112_53_04 shrivastava");
		Thread.sleep(10000);
		WebElement CustomerInfo = driver.findElement(By.id("customerInfo_0"));
		Assert.assertTrue(CustomerInfo.isDisplayed(), "CustomerInfo is missing");
		log.info("CustomerInfo is visible");
		CustomerInfo.click();
		Thread.sleep(10000);

		if(driver.findElement(By.xpath(activeorders)).isDisplayed()) 
		{
			//*[@id="ActiveOrder"]/div[2]/div/div[2]/div/div[5]/button
			driver.findElement(By.xpath(activeorderbutton)).click();
			Thread.sleep(10000);
		}
		
		WebElement SellPartandAccs = driver.findElement(By.xpath(sellpartandaccs));
		Assert.assertTrue(SellPartandAccs.isDisplayed(), "SellPartandAccs button is missing");
		log.info("SellPartandAccs button is visible");
		SellPartandAccs.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocompleteMerchandiseSectionWrapperId")));
		WebElement Searchbox = driver.findElement(By.id("autocompleteMerchandiseSectionWrapperId"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		log.info("Searchbox is visible");
		
//		Searchbox.sendKeys(Masterdata.NewPart);
		Searchbox.sendKeys("Part-21_12_202104_14_55");
		Thread.sleep(10000);
		WebElement Merchentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Merchentity.isDisplayed(), "Merchentity is missing");
		log.info("Merchentity is visible");
		Merchentity.click();
		Thread.sleep(10000);

//		Searchbox.sendKeys(Masterdata.NewFee);
		Searchbox.sendKeys("Qafee-");
		Thread.sleep(10000);	
		WebElement Feeentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Feeentity.isDisplayed(), "Feeentity is missing");
		log.info("Feeentity is visible");
		Feeentity.click();
		Thread.sleep(10000);		

//		Searchbox.sendKeys(POM.NewKit);
		Searchbox.sendKeys("qakit465");
		Thread.sleep(10000);
		WebElement Kitentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Kitentity.isDisplayed(), "Kitentity is missing");
		log.info("Kitentity is visible");
		Kitentity.click();
		Thread.sleep(10000);
		
		WebElement MerchandiseSectionId = driver.findElement(By.xpath(merchandiseSectionId));
		JavascriptExecutor executer = (JavascriptExecutor) driver;
		executer.executeScript("window.scrollBy(0,550)", MerchandiseSectionId);
		
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
		
		WebElement Cancel = driver.findElement(By.xpath(cancel));
		Cancel.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoiceclosebutton)));
		WebElement InvoiceCloseButton = driver.findElement(By.xpath(invoiceclosebutton));
		Assert.assertTrue(InvoiceCloseButton.isDisplayed(), "Invoice Close Button is missing");
		log.info("Invoice Close Button is visible");
		
		// element size zero error
		JavascriptExecutor executer1 = (JavascriptExecutor) driver;
		executer1.executeScript("arguments[0].click();",InvoiceCloseButton );
		log.info("Invoice Close Button is clicked");
		
		Thread.sleep(10000);
		WebElement COStatus = driver.findElement(By.xpath(costatus));
		
		Assert.assertTrue(COStatus.isDisplayed(), "CO Status is missing");
		log.info("CO Status is visible");
		COStatus.getText();
		Assert.assertEquals(COStatus.getText(), "Closed");
		log.info("CO Status is Closed");
		
	}
	
	@Test(priority = 14)
	public static void servicejob() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 20);
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
//		SelectCustomerDropdown.sendKeys(Masterdata.NewCustomer);
		SelectCustomerField.sendKeys("sparsh-08_12_202104_01_51 shrivastava");
		Thread.sleep(10000);
		WebElement CustomerInfo = driver.findElement(By.id("customerInfo_0"));
		Assert.assertTrue(CustomerInfo.isDisplayed(), "CustomerInfo is missing");
		log.info("CustomerInfo is visible");
		CustomerInfo.click();
		log.info("CustomerInfo is selected");
		Thread.sleep(15000);
		
		
		if(driver.findElement(By.xpath(activeorders)).isDisplayed()) 
		{	
			//*[@id="ActiveOrder"]/div[2]/div/div[2]/div/div[5]/button
			driver.findElement(By.xpath(activeorderbutton)).click();
			Thread.sleep(20000);
		}
		
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
		

		
//		WebElement ServiceJobDropdown = driver.findElement(By.xpath(servicejobdropdown));
//		Assert.assertTrue(ServiceJobDropdown.isDisplayed(), "ServiceJobDropdown is missing");
//		log.info("ServiceJobDropdown is visible");
//		ServiceJobDropdown.click();
		
		WebElement ServiceJobDetails = driver.findElement(By.xpath(servicejobdetails));
		Assert.assertTrue(ServiceJobDetails.isDisplayed(), "ServiceJobDetails is missing");
		log.info("ServiceJobDetails is visible");
		ServiceJobDetails.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("Concern0")));
		
		

		//		if(driver.findElement(By.xpath(addcustomerunit)).isDisplayed())
		if(!driver.findElement(By.xpath(customerownedunit)).isDisplayed())

		{
		//*[@id="ServiceJob0_DetailsSectionId"]/div/div/div[1]/div[1]/div/div/entity-card/div/div/div/button
		WebElement AddCustomerUnit = driver.findElement(By.xpath(addcustomerunit));
		AddCustomerUnit.click();
		Thread.sleep(10000);

		WebElement TempUnitMmodalWindow = driver.findElement(By.xpath(tempUnitMmodalWindow));
		Assert.assertEquals(TempUnitMmodalWindow.getText(), "ADD A NEW CUSTOMER OWNED UNIT");
		log.info("Temp Unit Mmodal Window  is visible");

		WebElement VIN_Unit = driver.findElement(By.id("VIN_Unit"));
		Assert.assertTrue(VIN_Unit.isDisplayed(), "VIN_Unit field is missing");
		int num = random.nextInt(1000);
		log.info("VIN_Unit field is visible");
		VIN_Unit.sendKeys("Vin" +num);
		log.info("VIN number is filed");
		
		WebElement MakeUnitOrdering = driver.findElement(By.id("MakeUnitOrdering"));
		Assert.assertTrue(MakeUnitOrdering.isDisplayed(), "Make field is missing");
		log.info("Make field is visible");
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
		
		}
		
		if(driver.findElement(By.xpath(customerownedunit)).isDisplayed())
		{
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
		Odometer_on_arrival.sendKeys("6000");
		log.info("Odometer_on_arrival field is filled");

		WebElement Odometer_on_departure = driver.findElement(By.xpath(odometer_on_departure));
		Assert.assertTrue(Odometer_on_departure.isDisplayed(), "Odometer_on_departure field is missing");
		log.info("Odometer_on_departure field is visible");
		Odometer_on_departure.sendKeys("6100");
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
		WebElement Searchbox2 = driver.findElement(By.id("autocompleteServiceJob0"));
//		Searchbox2.sendKeys(Masterdata.NewFee);
		Searchbox2.sendKeys("Qafee-");
		Thread.sleep(10000);	
		WebElement Feeentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Feeentity.isDisplayed(), "Feeentity is missing");
		log.info("Feeentity is visible");
		Feeentity.click();
		Thread.sleep(20000);		

		driver.findElement(By.xpath(searchentitytext)).click();
		Thread.sleep(10000);
		WebElement Searchbox3 = driver.findElement(By.id("autocompleteServiceJob0"));
//		Searchbox3.sendKeys(POM.NewKit);
		Searchbox3.sendKeys("qakit465");
		Thread.sleep(10000);
		WebElement Kitentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Kitentity.isDisplayed(), "Kitentity is missing");
		log.info("Kitentity is visible");
		Kitentity.click();
		Thread.sleep(20000);

		driver.findElement(By.xpath(searchentitytext)).click();
		Thread.sleep(10000);
		WebElement Searchbox4 = driver.findElement(By.id("autocompleteServiceJob0"));
//		Searchbox4.sendKeys(Masterdata.NewLabor);
		Searchbox4.sendKeys("Qalabor-14_12_202112_21_06");
		Thread.sleep(10000);
		WebElement Laborentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Laborentity.isDisplayed(), "Laborentity is missing");
		log.info("Laborentity is visible");
		Laborentity.click();
		Thread.sleep(20000);

//		Searchbox.click();
//		Thread.sleep(10000);	
////		Searchbox.sendKeys(POM.NewSublet);
//		Searchbox.sendKeys("sublet01");
//		Thread.sleep(10000);
//		WebElement Subletentity = driver.findElement(By.id("entityInfo_0"));
//		Assert.assertTrue(Subletentity.isDisplayed(), "Subletentity is missing");
//		log.info("Subletentity is visible");
//		Subletentity.click();
//		Thread.sleep(20000);
		
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
		
		WebElement Documents = driver.findElement(By.xpath(documents));
		Documents.click();
		Thread.sleep(5000);
		
//		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addforms)));
//		
//		WebElement AddForms = driver.findElement(By.xpath(addforms));
//		Assert.assertTrue(AddForms.isDisplayed(), "AddForms button is missing");
//		log.info("AddForms button is visible");
//		AddForms.click();
//		Thread.sleep(10000);
//		
//		WebElement DocumentFormModalWindowHeader = driver.findElement(By.xpath(documentFormModalWindowHeader));
//		
//		Assert.assertEquals(DocumentFormModalWindowHeader.getText(), "ADD FORMS");
//		log.info("Document Form Modal Window button is opened");
//
//		WebElement DocCheckbox = driver.findElement(By.xpath(docCheckbox));
//		
//		Assert.assertTrue(DocCheckbox.isDisplayed(), "Doc Checkbox is missing");
//		log.info("Doc Checkbox is visible");
//		DocCheckbox.click();
//		log.info("Doc Checkbox is selected");
//
//		WebElement AddSelected = driver.findElement(By.xpath(addselected));
//		Assert.assertTrue(AddSelected.isDisplayed(), "Add Selected button is missing");
//		log.info("Add Selected button is visible");
//		AddSelected.click();
//		log.info("Add Selected button is clicked");
//		Thread.sleep(10000);
		

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
		
		WebElement Cancel = driver.findElement(By.xpath(cancel));
		Cancel.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoiceclosebutton)));
		WebElement InvoiceCloseButton = driver.findElement(By.xpath(invoiceclosebutton));
		Assert.assertTrue(InvoiceCloseButton.isDisplayed(), "Invoice Close Button is missing");
		log.info("Invoice Close Button is visible");
		
		//when the size of element is zero
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("arguments[0].click();", SaveJobStatus);
		
		log.info("Invoice Close Button is clicked");
		Thread.sleep(10000);
		
		WebElement COStatus = driver.findElement(By.xpath(costatus));
		
		Assert.assertTrue(COStatus.isDisplayed(), "CO Status is missing");
		log.info("CO Status is visible");
		COStatus.getText();
		Assert.assertEquals(COStatus.getText(), "Closed");
		log.info("CO Status is Closed");
		
		}
		
	
	}

	@Test(priority = 15)
	public static void UnitDeal() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 20);
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
//		SelectCustomerDropdown.sendKeys(Masterdata.NewCustomer);
		SelectCustomerField.sendKeys("sparsh-08_12_202112_53_04 shrivastava");
		Thread.sleep(10000);
		WebElement CustomerInfo = driver.findElement(By.id("customerInfo_0"));
		Assert.assertTrue(CustomerInfo.isDisplayed(), "CustomerInfo is missing");
		log.info("CustomerInfo is visible");
		CustomerInfo.click();
		log.info("CustomerInfo is selected");
		Thread.sleep(10000);
		
		
		if(driver.findElement(By.xpath(activeorders)).isDisplayed()) 
		{	
			//*[@id="ActiveOrder"]/div[2]/div/div[2]/div/div[5]/button
			driver.findElement(By.xpath(activeorderbutton)).click();
			Thread.sleep(20000);
		}
		
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
		SearchStockunit.sendKeys("Mahindra SUV 2019, DCZXCZXCXZCXZ");
		Thread.sleep(10000);
		WebElement UnitInfo = driver.findElement(By.id("entityInfo_0"));
		UnitInfo.click();
		log.info("Unit1 is selected");	
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitName)));
		WebElement Option_Fee = driver.findElement(By.xpath(option_fee));
		Assert.assertTrue(Option_Fee.isDisplayed(), "Option_Fee field is missing");
		log.info("Option_Fee field is visible");
		
		JavascriptExecutor executer =  (JavascriptExecutor) driver;		
		executer.executeScript("window.scrollBy(0,550)", "");//window.scrollBy(550)
		
		WebElement OptionsAndFee = driver.findElement(By.xpath(optionaAndfee));
		//*[@id="Deal_DU0_SectionId"]/div/div[2]/div[1]/div[1]/h2
		Assert.assertTrue(OptionsAndFee.isDisplayed(), "Options And Fee field is missing");
		log.info("Options And Fee field is visible");
		OptionsAndFee.click();

		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("autocompleteDealUnit0")));
		WebElement SearchOptions = driver.findElement(By.id("autocompleteDealUnit0"));
		Assert.assertTrue(SearchOptions.isDisplayed(), "SearchOptions field is missing");
		log.info("SearchOptions field is visible");
		SearchOptions.sendKeys("Part-21_12_202104_14_55");
		Thread.sleep(10000);
		WebElement OptionInfo = driver.findElement(By.id("entityInfo_0"));
		OptionInfo.click();
		log.info("Option 1 is selected");	
		Thread.sleep(20000);
		
		WebElement ScanandSearch = driver.findElement(By.xpath(scanandsearch));
		ScanandSearch.click();
		Thread.sleep(10000);

		WebElement NotesForCustomer = driver.findElement(By.xpath(notesforcustomer));
		Assert.assertTrue(NotesForCustomer.isDisplayed(), "Notes For Customer field is missing");
		log.info("Notes For Customer field is visible");
		NotesForCustomer.click();
		log.info("Notes For Customer is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("Notes")));
		WebElement Notes = driver.findElement(By.id("Notes"));
		Assert.assertTrue(Notes.isDisplayed(), "Notes field is missing");
		log.info("Notes field is visible");
		Notes.sendKeys("This is a test note");
		log.info("Note is filled");

		
		WebElement Summary = driver.findElement(By.xpath(summary));
		Assert.assertTrue(Summary.isDisplayed(), "Summary is missing");
		log.info("Summary is visible");
		Summary.click();
		log.info("Summary is opened");
		Thread.sleep(5000);
		Summary.click();
		log.info("Summary is closed");
		
		UnitDealStatus.click();
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(dealstatuswindow)));
		WebElement InProgressCheckbox = driver.findElement(By.xpath(inprogresscheckbox));
//		Assert.assertTrue(InProgressCheckbox.isDisplayed(), "In Progress Checkbox is missing");
		log.info("In Progress Checkbox is displayed");
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", InProgressCheckbox);
		log.info("In Progress Checkbox is clicked");
		
		WebElement SaveStatus = driver.findElement(By.xpath(saveStatus));
		Assert.assertTrue(SaveStatus.isDisplayed(), "Save button is missing");
		log.info("Save button is displayed");
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].click();", SaveStatus);
		log.info("Save button is clicked");
		Thread.sleep(10000);
		
		UnitOptionsStatus.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionstatuswindow)));
		WebElement CommitOptions = driver.findElement(By.xpath(commitoptions));
		Assert.assertTrue(CommitOptions.isDisplayed(), "Commit Option  is missing");
		log.info("Commit Option is displayed");
		CommitOptions.click();
		log.info("Commit Options is clicked");
		Thread.sleep(10000);
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dealservice1)));
		WebElement DealService1 = driver.findElement(By.xpath(dealservice1));
		Assert.assertTrue(DealService1.isDisplayed(), "Deal Service section is missing");
		log.info("Deal Service section is displayed");
		DealService1.click();
		log.info("Deal Service section is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(serviceitems)));
		WebElement ServiceItems = driver.findElement(By.xpath(serviceitems));
		Assert.assertTrue(ServiceItems.isDisplayed(), "Service Items section is missing");
		log.info("Service Items section is displayed");
		ServiceItems.click();
		log.info("Service Items section is clicked");
		
//		WebElement ItemDescription = driver.findElement(By.id("ServiceJob_SOHeader0_SOKitHeader0_SOLI0_itemDesc"));
//		Assert.assertTrue(ItemDescription.isDisplayed(), "Item Description is missing");
//		log.info("Item Description is displayed");
		
		
		WebElement Serviceoption = driver.findElement(By.xpath(serviceoption));
		Assert.assertTrue(Serviceoption.isDisplayed(), "Service Option section is missing");
		log.info("Service Option section is displayed");
		Serviceoption.click();
		log.info("Service Option section is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobstatus)));
		WebElement CompleteStatus = driver.findElement(By.xpath(completeStatus));
		Assert.assertTrue(CompleteStatus.isDisplayed(), "Complete Status is missing");
		log.info("Complete Status is displayed");
		JavascriptExecutor executer3 = (JavascriptExecutor) driver;
		executer3.executeScript("arguments[0].click();", CompleteStatus);
		log.info("Complete Status is checked");
		
		
		WebElement SaveJobStatus = driver.findElement(By.xpath(savejobstatus));
		Assert.assertTrue(SaveJobStatus.isDisplayed(), "Save button  is missing");
		log.info("Save button is displayed");
		JavascriptExecutor executer4 = (JavascriptExecutor) driver;
		executer4.executeScript("arguments[0].click();", SaveJobStatus);
		log.info("Save buttton is clicked");
		Thread.sleep(5000);
		
		DealService1.click();
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("serviceJobAction1")));
		WebElement FinalizeJob = driver.findElement(By.id("serviceJobAction1"));
		Assert.assertTrue(FinalizeJob.isDisplayed(), "Finalize Job buton is missing");
		log.info("Finalize Job button is displayed");
		FinalizeJob.click();
		log.info("Finalize Job button is clicked");
		
	
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(savefinalizejob)));
		WebElement SaveFinalizeJob = driver.findElement(By.xpath(savefinalizejob));
		Assert.assertTrue(SaveFinalizeJob.isDisplayed(), "Save Finalize Job button is missing");
		log.info("Save Finalize Job button is displayed");
		SaveFinalizeJob.click();
		log.info("Save Finalize Job button is clicked");
		Thread.sleep(15000);
	
		//Need fixes below
		
		WebElement CancelBrnding = driver.findElement(By.xpath(cancelbranding));
		Assert.assertTrue(CancelBrnding.isDisplayed(), "Cancel Brnding button is missing");
		log.info("Cancel Brnding button is displayed");
		JavascriptExecutor executer5 = (JavascriptExecutor) driver;
		executer5.executeScript("arguments[0].click();", CancelBrnding);
		log.info("CancelBrnding button is clicked");

		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(internalhistory)));
		
		Assert.assertTrue(UnitOptionsStatus.isDisplayed(), "UnitOptionsStatus is missing");
		log.info("UnitOptionsStatus is visible");
		log.info("UnitOptionsStatus is " +UnitOptionsStatus.getText());
		Assert.assertEquals(UnitOptionsStatus.getText(), "Option:");
		
		UnitDealStatus.click();
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(approvecheckbox)));
		WebElement ApproveCheckbox = driver.findElement(By.xpath(approvecheckbox));
//		Assert.assertTrue(InProgressCheckbox.isDisplayed(), "In Progress Checkbox is missing");
		log.info("Approve Checkbox is displayed");
		Thread.sleep(10000);
		JavascriptExecutor executor6 = (JavascriptExecutor) driver;
		executor6.executeScript("arguments[0].click();", ApproveCheckbox);
		log.info("Approve Checkbox is clicked");
		
		WebElement SaveStatus2 = driver.findElement(By.xpath(saveStatus));
		Assert.assertTrue(SaveStatus2.isDisplayed(), "Save button is missing");
		log.info("Save button is displayed");
		JavascriptExecutor executor7 = (JavascriptExecutor) driver;
		executor7.executeScript("arguments[0].click();", SaveStatus2);
		log.info("Save button is clicked");
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
		
		WebElement Cancel = driver.findElement(By.xpath(cancel));
		Cancel.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoiceclosebutton)));
		WebElement InvoiceCloseButton = driver.findElement(By.xpath(invoiceclosebutton));
		Assert.assertTrue(InvoiceCloseButton.isDisplayed(), "Invoice Close Button is missing");
		log.info("Invoice Close Button is visible");
		JavascriptExecutor executor8 = (JavascriptExecutor) driver;
		executor8.executeScript("arguments[0].click();", InvoiceCloseButton);
		log.info("Invoice Close Button is clicked");
		Thread.sleep(10000);
		
		WebElement COStatus = driver.findElement(By.xpath(costatus));
		
		Assert.assertTrue(COStatus.isDisplayed(), "CO Status is missing");
		log.info("CO Status is visible");
		COStatus.getText();
		Assert.assertEquals(COStatus.getText(), "Closed");
		log.info("CO Status is Closed");

		
	}
	
}
