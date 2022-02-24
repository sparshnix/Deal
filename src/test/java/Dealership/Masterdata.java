package Dealership;

/**
 * BlackPurl Automation
 * Creation date 17-nov-2021
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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.*;
import org.testng.Reporter;

@Listeners(Dealership.Listeners.class)

public class Masterdata extends POM {
//	private static Logger log = LogManager.getLogger(POM.class.getName());
	public static String timestamp = new SimpleDateFormat("-dd_MM_yyyyhh_mm_ss").format(new Date());
	public static String phonenumber = new SimpleDateFormat("MMyyyymmss").format(new Date());
	public static String NewCustomer, NewVendor, NewPart, NewLabor, NewKit, NewFee, NewUnit;
	
	;

	
	@SuppressWarnings("deprecation")
	
	@Test(priority = 1)
	public static void AddCustomer() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver,100);
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(addnew)));
		WebElement Addnew = driver.findElement(By.xpath(addnew));
		Assert.assertTrue(Addnew.isDisplayed(), "Button is missing");
		log.info("Addnew button is displayed");
		Addnew.click();
		Assert.assertTrue(Addnew.isEnabled(), "Button is not clicked");
		log.info("Addnew button is clicked");
		
		WebElement Customer = driver.findElement(By.xpath(customer));
		Assert.assertTrue(Customer.isDisplayed(), "Button is missing");
		log.info("Customer button is displayed");
		Customer.click();
		Assert.assertTrue(Customer.isEnabled(), "Button is not clicked");
		log.info("Customer button is clicked");
        Thread.sleep(10000);
		
		WebElement Smallheader = driver.findElement(By.xpath(smallheader));
		Assert.assertTrue(Smallheader.isDisplayed(), "Button is missing");
		String Smallheadertext = Smallheader.getText();
		System.out.println(Smallheadertext);
		Assert.assertEquals(Smallheadertext, "CREATE NEW CUSTOMER");
		log.info("Customer creation window is opened");
		
		WebElement Firstname = driver.findElement(By.id("new-customer-first-name"));
		Assert.assertTrue(Firstname.isDisplayed(), "Firstname field is missing");
		log.info("Firstname field is visible");
		NewCustomer = firstname + timestamp;
		Firstname.sendKeys(NewCustomer);
		log.info("Firstname  is filled");
		
		WebElement Lastname = driver.findElement(By.id("new-customer-last-name"));
		Assert.assertTrue(Lastname.isDisplayed(), "Lastname field is missing");
		log.info("Lastname field is visible");
		Lastname.sendKeys(lastname);
		log.info("Lastname  is filled");
		
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(accounttypedropdown)));
		WebElement Accounttypedropdown = driver.findElement(By.xpath(accounttypedropdown));
		Assert.assertTrue(Accounttypedropdown.isDisplayed(), "Account type field is missing");
		log.info("Account type field is visible");
		Accounttypedropdown.click();
		log.info("Account type  is clicked");
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(accounttypevalue)));
		WebElement Accounttypevalue = driver.findElement(By.xpath(accounttypevalue));
		Assert.assertTrue(Accounttypevalue.isDisplayed(), "Account type value is missing");
		Accounttypevalue.click();
		log.info("Account type  is selected");
		
		
		WebElement Email = driver.findElement(By.id("customer-email"));
		Assert.assertTrue(Email.isDisplayed(), "Email field is missing");
		log.info("Email field is visible");
		String email = firstname + timestamp + "@test.com";
		Email.sendKeys(email);
		log.info("Email  is filled");
		
		WebElement Mobilenumber = driver.findElement(By.id("customer-mobile-number"));
		Assert.assertTrue(Mobilenumber.isDisplayed(), "Mobilenumber field is missing");
		log.info("Mobilenumber field is visible");
		Mobilenumber.sendKeys(phonenumber);
		log.info("Mobilenumber  is filled");
		
		
		WebElement Address = driver.findElement(By.id("customer-Address"));
		Assert.assertTrue(Address.isDisplayed(), "Address field is missing");
		WebElement Address2 = driver.findElement(By.id("customer-Address2"));
		Assert.assertTrue(Address2.isDisplayed(), "Address field is missing");
		log.info("Address field is visible");
		Address.sendKeys("Sample text");
		Address2.sendKeys("Sample text");
		log.info("Address  is filled");
		
		WebElement Country = driver.findElement(By.xpath(country));
		Assert.assertTrue(Country.isDisplayed(), "Country field is missing");
		log.info("Country field is visible");
		Country.click();
		log.info("Country is clicked");
		WebElement CountryName = driver.findElement(By.xpath(countryname));
		Assert.assertTrue(CountryName.isDisplayed(), "Country Name value is missing");
		CountryName.click();
		log.info("Country Name is selected");
		
		WebElement City = driver.findElement(By.id("customer-City"));
		Assert.assertTrue(City.isDisplayed(), "City Name value is missing");
		City.sendKeys("Sydney");
		log.info("City Name is selected");
		
//		WebElement State = driver.findElement(By.xpath(state));
//		Assert.assertTrue(State.isDisplayed(), "State field is missing");
//		log.info("State field is visible");
//		State.click();
//		log.info("State is clicked");	
//		WebElement Statename = driver.findElement(By.xpath(statename));
//		Assert.assertTrue(Statename.isDisplayed(), "State Name value is missing");
//		Statename.click();
//		log.info("State Name is selected");
		
		
		WebElement PostCode = driver.findElement(By.id("customer-Postcode"));
		Assert.assertTrue(PostCode.isDisplayed(), "Postcode value is missing");
		PostCode.sendKeys("001234");
		log.info("Postcode is selected");
		
		WebElement Create = driver.findElement(By.xpath(create));
		Assert.assertTrue(Create.isDisplayed(), "Create button is missing");
		Create.click();
		log.info("Create button is clicked");
		Thread.sleep(10000);
		
		WebElement Searchbox = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		Searchbox.sendKeys(email);
		log.info("email is entered in seachbox");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyemail)));
		
		WebElement Verifyemail = driver.findElement(By.xpath(verifyemail));
		Assert.assertTrue(Verifyemail.isDisplayed(), "No relevent data appeared");
		Verifyemail.getText();
		log.info("the text is " + Verifyemail.getText());
		Assert.assertEquals(email,Verifyemail.getText(), "User not found");
		log.info("User is successfully created");	
		
	}
	
	
	@Test(priority = 2)
	public static void AddVendor() throws InterruptedException
	
	{
		WebDriverWait wt = new WebDriverWait(driver,100);
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(addnew)));
		WebElement Addnew = driver.findElement(By.xpath(addnew));
		Assert.assertTrue(Addnew.isDisplayed(), "Button is missing");
		log.info("Addnew button is displayed");
		Addnew.click();
		Assert.assertTrue(Addnew.isEnabled(), "Button is not clicked");
		log.info("Addnew button is clicked");
		
		WebElement Vendor = driver.findElement(By.xpath(vendor));
		Assert.assertTrue(Vendor.isDisplayed(), "Button is missing");
		log.info("Vendor button is displayed");
		Vendor.click();
		Assert.assertTrue(Vendor.isEnabled(), "Button is not clicked");
		log.info("Vendor button is clicked");

		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(vendorHeader)));
        WebElement VendorHeader = driver.findElement(By.xpath(vendorHeader));
		Assert.assertTrue(VendorHeader.isDisplayed(), "Button is missing");
		String VendorHeadertext = VendorHeader.getText();
		System.out.println(VendorHeadertext);
		Assert.assertEquals(VendorHeadertext, "New Vendor");
		log.info("Vendor creation window is opened");
      //*[@id="newVendor"]/div[2]/div/div/div[1]/div[4]/div[1]/h1[2]
        
        
        WebElement Vendorname = driver.findElement(By.id("vendorName"));
        Assert.assertTrue(Vendorname.isDisplayed(), "Vendor name field is missing");
        NewVendor = companyname + timestamp;
        Vendorname.sendKeys(NewVendor);
        log.info("Company name is entered");
        Thread.sleep(1000);
        
        WebElement VendorAccountNumber = driver.findElement(By.id("vendorAccountNumber"));
        Assert.assertTrue(VendorAccountNumber.isDisplayed(), "Vendor Account Number field is missing");
        VendorAccountNumber.sendKeys(vendorAccountNumber);
        log.info("Vendor Account Number is entered");
        
        WebElement WorkEmail = driver.findElement(By.id("workEmail"));
        Assert.assertTrue(WorkEmail.isDisplayed(), "Email field is missing");
        String workEmail = companyname + timestamp + "@gmail.com";
        WorkEmail.sendKeys(workEmail);
        log.info("Work Email is entered");
        
        WebElement WorkPhone = driver.findElement(By.id("workPhone"));
        Assert.assertTrue(WorkPhone.isDisplayed(), "Phone number is missing");
        log.info("Phone number field is visible");
        WorkPhone.sendKeys(phonenumber);
		log.info("Phone number  is filled");
		
		WebElement Billingaddress1 = driver.findElement(By.id("billingAddress1"));
		Assert.assertTrue(Billingaddress1.isDisplayed(), "Billing address1 field is missing");
		WebElement Billingaddress2 = driver.findElement(By.id("billingAddress2"));
		Assert.assertTrue(Billingaddress2.isDisplayed(), "Billing address2 field is missing");
		log.info("Billingaddress field is visible");
		Billingaddress1.sendKeys("Sample text");
		Billingaddress2.sendKeys("Sample text");
		log.info("Billingaddress  is filled");
		
		WebElement BillingCity = driver.findElement(By.id("billingCity"));
		Assert.assertTrue(BillingCity.isDisplayed(), "City field is missing");
		BillingCity.sendKeys("Sydney");
		log.info("City Name is selected");
		
		WebElement BillingState = driver.findElement(By.id("billingState"));
		Assert.assertTrue(BillingState.isDisplayed(), "Billing State value is missing");
		Select select1 = new Select(BillingState);
		select1.selectByIndex(1);
		log.info("Billing State is selected");
		
		
		WebElement BillingCountry = driver.findElement(By.id("billingCountry"));
		Assert.assertTrue(BillingCountry.isDisplayed(), "Billing Country value is missing");
		Select select2 = new Select(BillingCountry);
		select2.selectByIndex(1);
		log.info("Billing Country is selected");
		
		WebElement PostCode = driver.findElement(By.id("exampleInputEmail1"));
		Assert.assertTrue(PostCode.isDisplayed(), "Postcode value is missing");
		PostCode.sendKeys("001234");
		log.info("Postcode is selected");
		
//		WebElement Shippingaddressflag = driver.findElement(By.xpath(shippingaddressflag));
//		Assert.assertTrue(Shippingaddressflag.isDisplayed(), "Shippingaddressflag checkbox is missing");
//		log.info("Shippingaddressflag checkbox is displayed");
//		Shippingaddressflag.click();
//		log.info("Shippingaddressflag is same as billing address");
		
//		WebElement  Part_Purchases = driver.findElement(By.xpath(part_Purchases));
//		Assert.assertTrue(Part_Purchases.isDisplayed(), "Part_Purchases checkbox is missing");
//		Part_Purchases.click();
//		
//		WebElement	Merchandise_Purchases = driver.findElement(By.xpath(merchandise_Purchases));
//		Assert.assertTrue(Merchandise_Purchases.isDisplayed(), "Merchandise_Purchases checkbox is missing");
//		Merchandise_Purchases.click();
//		
//		WebElement	Unit_Purchases = driver.findElement(By.xpath(unit_Purchases));
//		Assert.assertTrue(Unit_Purchases.isDisplayed(), "Unit_Purchases checkbox is missing");
//		Unit_Purchases.click();
//		
//		WebElement	Sublet_Purchases = driver.findElement(By.xpath(sublet_Purchases));
//		Assert.assertTrue(Sublet_Purchases.isDisplayed(), "Sublet_Purchases checkbox is missing");
//		Sublet_Purchases.click();
//		
//		WebElement	Claims_for_Service_Work = driver.findElement(By.xpath(claims_for_Service_Work));
//		Assert.assertTrue(Claims_for_Service_Work.isDisplayed(), "Claims_for_Service_Work checkbox is missing");
//		Claims_for_Service_Work.click();
//		
//		WebElement	Deal_Products = driver.findElement(By.xpath(deal_Products));
//		Assert.assertTrue(Deal_Products.isDisplayed(), "Deal_Products checkbox is missing");
//		Deal_Products.click();
//		
//		WebElement	Flooring_Company = driver.findElement(By.xpath(flooring_Company));
//		Assert.assertTrue(Flooring_Company.isDisplayed(), "Flooring_Company checkbox is missing");
//		Flooring_Company.click();
//		
//		WebElement	Finance_Company = driver.findElement(By.xpath(finance_Company));
//		Assert.assertTrue(Finance_Company.isDisplayed(), "Finance_Company checkbox is missing");
//		Finance_Company.click();
//		
//		WebElement	Financing_Products = driver.findElement(By.xpath(financing_Products));
//		Assert.assertTrue(Financing_Products.isDisplayed(), "Financing_Products checkbox is missing");
//		Financing_Products.click();
		
		WebElement PurchaseTaxLevel = driver.findElement(By.xpath(purchaseTaxLevel));
		Assert.assertTrue(PurchaseTaxLevel.isDisplayed(), "PurchaseTaxLevel value is missing");
		Select select3 = new Select(PurchaseTaxLevel);
		select3.selectByIndex(1);
		log.info("PurchaseTaxLevel is selected");
		
		WebElement VendorAccountTypeIcon = driver.findElement(By.xpath(vendorAccountTypeIcon));
		Assert.assertTrue(VendorAccountTypeIcon.isDisplayed(), "VendorAccountTypeIcon value is missing");
		Select select4 = new Select(VendorAccountTypeIcon);
		select4.selectByIndex(1);
		log.info("VendorAccountTypeIcon is selected");
		
		
		WebElement SaveVendor = driver.findElement(By.xpath(saveVendor));
		Assert.assertTrue(SaveVendor.isDisplayed(), "Save button is missing");
		log.info("Save button is displayed");
		SaveVendor.click();
		log.info("Save button is clicked");
		Thread.sleep(10000);
		
		WebElement Searchbox = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		Searchbox.sendKeys(workEmail);
		log.info("email is entered in searchbox");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyemail)));

		WebElement Verifyemail = driver.findElement(By.xpath(verifyemail));
		Assert.assertTrue(Verifyemail.isDisplayed(), "No relevent data appeared");
		Verifyemail.getText();
		log.info("the text is " + Verifyemail.getText());
		Assert.assertEquals(workEmail,Verifyemail.getText(), "User not found");
		log.info("User is successfully created");
	}
	

	@Test(priority = 3)
	public static void AddPart() throws InterruptedException 
	{
		WebDriverWait wt = new WebDriverWait(driver,100);
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(addnew)));
		WebElement Addnew = driver.findElement(By.xpath(addnew));
		Assert.assertTrue(Addnew.isDisplayed(), "Button is missing");
		log.info("Addnew button is displayed");
		Addnew.click();
		Assert.assertTrue(Addnew.isEnabled(), "Button is not clicked");
		log.info("Addnew button is clicked");
		
		WebElement Part = driver.findElement(By.xpath(part));
		Assert.assertTrue(Part.isDisplayed(), "Button is missing");
		log.info("Part button is displayed");
		Part.click();
		Assert.assertTrue(Part.isEnabled(), "Button is not clicked");
		log.info("Part button is clicked");
		
        Thread.sleep(5000);
        
        WebElement PartHeader = driver.findElement(By.xpath(partheader));
        Assert.assertTrue(PartHeader.isDisplayed(), "Part header is missing");
        String PartHeadertext = PartHeader.getText();
		System.out.println(PartHeadertext);
		Assert.assertEquals(PartHeadertext, "New Merchandise");
		log.info("Part creation window is opened");
        
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("partNumber")));
		WebElement PartNumber = driver.findElement(By.id("partNumber"));
		Assert.assertTrue(PartNumber.isDisplayed(), "Part Number field is missing");
		log.info("Part number field is displayed");
		NewPart = "Part"+ timestamp;
		PartNumber.sendKeys(NewPart);
		log.info("Part number is entered");
		
		WebElement PartDescription = driver.findElement(By.id("partDescription"));
		Assert.assertTrue(PartDescription.isDisplayed(), "Part Description  field is missing");
		log.info("Part Description field is displayed");
		String Description = "Test Description";
		PartDescription.sendKeys(Description);
		log.info("Part Description is entered");
		
		WebElement Vendor_Input = driver.findElement(By.id("Vendor_Input"));
		Assert.assertTrue(Vendor_Input.isDisplayed(), "Vendor_Input field is missing");
		log.info("Vendor_Input field is displayed");
//		Vendor_Input.sendKeys(NewVendor);
		Vendor_Input.sendKeys("Qavendor");
		Thread.sleep(5000);
		WebElement VendorList = driver.findElement(By.id("SearchToaddCutomerSuggestions"));
		VendorList.click();
		log.info("Vendor_Input is entered");	
		
		
		WebElement MfgPart = driver.findElement(By.id("mfgPart"));
		Assert.assertTrue(MfgPart.isDisplayed(), "Mfg Part field is missing");
		log.info("Mfg Part field is displayed");
		MfgPart.sendKeys("#Mfg_test");
		log.info("Mfg Part is entered");
		
		WebElement SKUNumber = driver.findElement(By.id("SKUNumber"));
		Assert.assertTrue(SKUNumber.isDisplayed(), "SKU Number is missing");
		log.info("SKU Number field is displayed");
		SKUNumber.sendKeys("#SKU_test");
		log.info("SKU Number is entered");
		
//		WebElement PartType = driver.findElement(By.id(parttype));	
//        Select select1 = new Select(PartType);
//        select1.deselectByIndex(0);
//		log.info("Part type is selected");
		
		
		WebElement Category_Input = driver.findElement(By.id("Category_Input"));
		Assert.assertTrue(Category_Input.isDisplayed(), "Category_Input field is missing");
		log.info("Category_Input field is displayed");
		Thread.sleep(2000);	
//		Vendor_Input.sendKeys(NewVendor);
		Category_Input.clear();
		Category_Input.sendKeys("part");
		Thread.sleep(5000);	
		WebElement Category_List = driver.findElement(By.id("SearchToaddCutomerSuggestions"));
		Category_List.click();
		log.info("Category_Input is entered");	
        
		WebElement Tags = driver.findElement(By.xpath(tags));
		Assert.assertTrue(Tags.isDisplayed(), "Tags field is missing");
		log.info("Tagsfield is displayed");
		Tags.click();
		WebElement Select_tag = driver.findElement(By.id("tag_0"));
		Select_tag.click();
		log.info("Tag is selected");
		
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		
//		WebElement ApplicableTax = driver.findElement(By.id("applicableTaxId"));	
//        Select select2 = new Select(ApplicableTax);
//        select2.deselectByIndex(0);
//		log.info("ApplicableTax is selected");
//		
		
//		WebElement Location = driver.findElement(By.xpath(location));
//		Assert.assertTrue(Location.isDisplayed(), "Location field is missing");
//		log.info("Location field is displayed");
//		Location.click();
//		Thread.sleep(5000);
//		
//	
//		WebElement SelectLocation = driver.findElement(By.id("taglistcontainer"));
//		Actions action = new Actions(driver);
//		action.moveToElement(SelectLocation).click().perform();
//		Thread.sleep(5000);
//		WebElement Select_Location = driver.findElement(By.xpath(tag_1));
//		Select_Location.click();
//		log.info("Location is selected");
		
		
		WebElement InStockQty = driver.findElement(By.xpath(inStockQty));
		Assert.assertTrue(InStockQty.isDisplayed(), "Qty field is missing");
		log.info("Qty field is displayed");
		InStockQty.sendKeys("10");
		log.info("Qty is entered");
		
//		WebElement PriceMethod = driver.findElement(By.id("priceMethod"));	
//        Select select3 = new Select(PriceMethod);
//        select3.deselectByIndex(0);
//		log.info("Price Method is selected");
		
		WebElement MSRP = driver.findElement(By.id("msrp"));
		Assert.assertTrue(MSRP.isDisplayed(), "MSRP field is missing");
		log.info("MSRP field is displayed");
		MSRP.sendKeys("500");
		log.info("MSRP is entered");
		
		WebElement Retail = driver.findElement(By.id("retail"));
		Assert.assertTrue(Retail.isDisplayed(), "Retail field is missing");
		log.info("Retail field is displayed");
		Retail.sendKeys("400");
		log.info("Retail is entered");
		
		WebElement SalePrice = driver.findElement(By.id("SalePrice"));
		Assert.assertTrue(SalePrice.isDisplayed(), "SalePrice field is missing");
		log.info("SalePrice field is displayed");
		SalePrice.sendKeys("450");
		log.info("SalePrice is entered");
		
		WebElement EnviroFee = driver.findElement(By.id("enviroFee"));
		Assert.assertTrue(EnviroFee.isDisplayed(), "Environmental Fee field is missing");
		log.info("Environmental Fee field is displayed");
		EnviroFee.sendKeys("30");
		log.info("Environmental Fee is entered");
		
		WebElement PartSaveBtn = driver.findElement(By.id("partSaveBtn"));
		Assert.assertTrue(PartSaveBtn.isDisplayed(), "Part Save Button is missing");
		log.info("Part Save Button  is displayed");
		PartSaveBtn.click();
		log.info("save button is clicked");
		Thread.sleep(20000);
		
		WebElement Searchbox = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		Searchbox.sendKeys(NewPart);
		log.info("New Part Name is entered in searchbox");
		Thread.sleep(5000);

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyPart)));
		WebElement VerifyPart = driver.findElement(By.xpath(verifyPart));		
		Assert.assertTrue(VerifyPart.isDisplayed(), "No relevent data appeared");
		VerifyPart.getText();
		log.info("the text is " + VerifyPart.getText());		
		Assert.assertEquals(NewPart + " - " +Description,VerifyPart.getText(), "Part not found");
		log.info("part is successfully created");
		
	}
	
	@Test(priority = 4)
	public static void AddLabor() throws InterruptedException
	
	{
		WebDriverWait wt = new WebDriverWait(driver,100);
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(addnew)));
		WebElement Addnew = driver.findElement(By.xpath(addnew));
		Assert.assertTrue(Addnew.isDisplayed(), "Button is missing");
		log.info("Addnew button is displayed");
		Addnew.click();
		Assert.assertTrue(Addnew.isEnabled(), "Button is not clicked");
		log.info("Addnew button is clicked");
		
		WebElement Labor = driver.findElement(By.xpath(labor));
		Assert.assertTrue(Labor.isDisplayed(), "Button is missing");
		log.info("Labor button is displayed");
		Labor.click();
		Assert.assertTrue(Labor.isEnabled(), "Button is not clicked");
		log.info("Labor button is clicked");
        Thread.sleep(5000);
		
        WebElement Laborheader = driver.findElement(By.xpath(laborheader));
		Assert.assertTrue(Laborheader.isDisplayed(), "Button is missing");
		String Laborheadertext = Laborheader.getText();
		System.out.println(Laborheadertext);
		Assert.assertEquals(Laborheadertext, "New Labor");
		log.info("Labor creation window is opened");
		
		
		WebElement LaborCode = driver.findElement(By.id("Code"));
		Assert.assertTrue(LaborCode.isDisplayed(), "LaborCode field is missing");
		log.info("Labor code field is displayed");
		NewLabor = laborcode + timestamp;
		LaborCode.sendKeys(NewLabor);
		log.info("labor code is entered");
		
		WebElement LaborDescription = driver.findElement(By.id("Description"));
		Assert.assertTrue(LaborDescription.isDisplayed(), "Description field is missing");
		log.info("Description field is displayed");
		String Description = "Test Description";
		LaborDescription.sendKeys(Description);
		log.info("Description is entered");
		
		WebElement Hours = driver.findElement(By.id("Hours"));
		Assert.assertTrue(Hours.isDisplayed(), "Hours field is missing");
		log.info("Hours field is displayed");
		Hours.sendKeys("8");
		log.info("Hours entered");
		
		WebElement Rate = driver.findElement(By.id("Rate"));
		Assert.assertTrue(Rate.isDisplayed(), "Rate field is missing");
		log.info("Rate field is displayed");
		Rate.sendKeys(Keys.chord(Keys.CONTROL,"a"),"20");
		log.info("Rate entered");
		
		WebElement Category_Input = driver.findElement(By.id("Category_Input"));
		Assert.assertTrue(Category_Input.isDisplayed(), "Category_Input field is missing");
		log.info("Category_Input field is displayed");
		Category_Input.clear();
		Category_Input.sendKeys(Keys.chord(Keys.CONTROL,"a"),"labor");
		Thread.sleep(10000);
		WebElement LaborList = driver.findElement(By.id("SearchToaddCutomerSuggestions"));
		Thread.sleep(5000);
		Assert.assertTrue(LaborList.isDisplayed(), "LaborList is missing");
		LaborList.click();
		log.info("Category_Input entered");
		
//		WebElement FormsTag = driver.findElement(By.xpath(formstag));
//		Assert.assertTrue(FormsTag.isDisplayed(), "FormsTag field is missing");
//		log.info("FormsTag field is displayed");
//		FormsTag.sendKeys("Test");	
//		log.info("FormsTag is entered");
		
//		WebElement selectTag = driver.findElement(By.xpath(selecttag));
//		Assert.assertTrue(selectTag.isDisplayed(), "select Tag field is missing");
//		log.info("selectTag field is displayed");
//		selectTag.click();
//		log.info("selectTag is entered");
		
		WebElement Applicabletax = driver.findElement(By.xpath(applicabletax));
		Assert.assertTrue(Applicabletax.isDisplayed(), "Applicabletax field is missing");
		log.info("Applicabletax field is displayed");
		Select select = new Select(Applicabletax);
		select.selectByIndex(1);
		log.info("Applicabletax is entered");
		
		
		WebElement SaveButton = driver.findElement(By.xpath(savebutton));
		Assert.assertTrue(SaveButton.isDisplayed(), "SaveButton is missing");
		log.info("SaveButton is displayed");
		SaveButton.click();
		log.info("SaveButton is clicked");
		Thread.sleep(10000);
		
		WebElement Searchbox = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		Searchbox.sendKeys(NewLabor);
		log.info("Labor Name is entered in searchbox");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifylabor)));

		WebElement Verifylabor = driver.findElement(By.xpath(verifylabor));		
		Assert.assertTrue(Verifylabor.isDisplayed(), "No relevent data appeared");
		log.info("the text is " + Verifylabor.getText());		
		Assert.assertEquals(NewLabor + " - " +Description,Verifylabor.getText(), "Labor not found");
		log.info("Labor is successfully created");
		
	}
	
	@Test(priority = 5)
	public static void AddKit() throws InterruptedException
	
	{
		WebDriverWait wt = new WebDriverWait(driver,100);
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(addnew)));
		WebElement Addnew = driver.findElement(By.xpath(addnew));
		Assert.assertTrue(Addnew.isDisplayed(), "Button is missing");
		log.info("Addnew button is displayed");
		Addnew.click();
		Assert.assertTrue(Addnew.isEnabled(), "Button is not clicked");
		log.info("Addnew button is clicked");
		
		WebElement Kit = driver.findElement(By.xpath(kit));
		Assert.assertTrue(Kit.isDisplayed(), "Button is missing");
		log.info("Kit button is displayed");
		Kit.click();
		Assert.assertTrue(Kit.isEnabled(), "Button is not clicked");
		log.info("Kit button is clicked");
        Thread.sleep(5000);
		
        WebElement Kitheader = driver.findElement(By.xpath(kitheader));
		Assert.assertTrue(Kitheader.isDisplayed(), "Button is missing");
		log.info("Kit header is displayed");
		String Kitheadertext = Kitheader.getText();
		System.out.println(Kitheadertext);
		Assert.assertEquals(Kitheadertext, "New Kit");
		log.info("Kit creation window is opened");
		
		
		WebElement KitCode = driver.findElement(By.id("feeCodeInput"));
		Assert.assertTrue(KitCode.isDisplayed(), "KitCode is missing");
		log.info("KitCode is displayed");
		NewKit = kitcode + timestamp;
		KitCode.sendKeys(NewKit);
		log.info("Kit code is entered");

		WebElement KitDescription = driver.findElement(By.id("txtdescription"));
		Assert.assertTrue(KitDescription.isDisplayed(), "Description field is missing");
		log.info("Description field is displayed");
		String Description = "Test Description";
		KitDescription.sendKeys(Description);
		log.info("Kit Description is entered");
		
		WebElement Servicekitchechbox = driver.findElement(By.xpath(servicekitchechbox));
		Assert.assertTrue(Servicekitchechbox.isDisplayed(), "Service kit chechbox is missing");
		log.info("Service kit chechbox is displayed");
		Servicekitchechbox.click();
		log.info("Service kit chechbox is clicked");
		Thread.sleep(5000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtconcern")));
		WebElement Concern = driver.findElement(By.id("txtconcern"));
		Assert.assertTrue(Concern.isDisplayed(), "Concern field is missing");
		log.info("Concern field is displayed");
		Concern.sendKeys("Test concern");
		log.info("Concern is filled");
		
		WebElement Cause = driver.findElement(By.id("txtcause"));
		Assert.assertTrue(Cause.isDisplayed(), "Cause field is missing");
		log.info("Cause field is displayed");
		Cause.sendKeys("Test cause");
		log.info("Cause is filled");
		
		WebElement Correction = driver.findElement(By.id("txtcorrection"));
		Assert.assertTrue(Correction.isDisplayed(), "Correction field is missing");
		log.info("Correction field is displayed");
		Correction.sendKeys("Test correction");
		log.info("Correction is filled");
		
		WebElement Make = driver.findElement(By.xpath(make));
		Assert.assertTrue(Make.isDisplayed(), "Make field is missing");
		log.info("Make field is displayed");
		Make.click();
		Thread.sleep(5000);
		
		WebElement Makeoption = driver.findElement(By.xpath(makeoption));
		Makeoption.click();
		log.info("Make is filled");
		
		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		
		WebElement Model = driver.findElement(By.xpath(model));
		Assert.assertTrue(Model.isDisplayed(), "Model field is missing");
		log.info("Model field is displayed");
		Model.click();
		Thread.sleep(5000);
		
		WebElement Modeloption = driver.findElement(By.xpath(modeloption));
		Modeloption.click();
		log.info("Model is filled");
		
		WebElement SubModel = driver.findElement(By.xpath(submodel));
		Assert.assertTrue(SubModel.isDisplayed(), "SubModel field is missing");
		log.info("SubModel field is displayed");
		SubModel.click();
		Thread.sleep(5000);
		
		WebElement SubModeloption = driver.findElement(By.xpath(submodeloption));
		SubModeloption.click();
		log.info("SubModel is filled");
		
		Thread.sleep(5000);
		
		WebElement Savekit = driver.findElement(By.xpath(savekit));
		Assert.assertTrue(Savekit.isDisplayed(), "SaveButton is missing");
		log.info("Save button is displayed");
		Savekit.click();
		log.info("Save button is clicked");
		Thread.sleep(10000);
		
		WebElement Searchbox = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		Searchbox.sendKeys(NewKit);
		log.info("Kit Name is entered in searchbox");
		Thread.sleep(5000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifykit)));

		WebElement Verifykit = driver.findElement(By.xpath(verifykit));		
		Assert.assertTrue(Verifykit.isDisplayed(), "No relevent data appeared");
		log.info("the text is " + Verifykit.getText());		
		Assert.assertEquals(NewKit + " - " +Description,Verifykit.getText(), "Kit not found");
		log.info("Kit is successfully created");
		
	}
	
	@Test(priority = 6)
	public static void AddFee() throws InterruptedException 
	{
		WebDriverWait wt = new WebDriverWait(driver,100);
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(addnew)));
		WebElement Addnew = driver.findElement(By.xpath(addnew));
		Assert.assertTrue(Addnew.isDisplayed(), "Button is missing");
		log.info("Addnew button is displayed");
		Addnew.click();
		Assert.assertTrue(Addnew.isEnabled(), "Button is not clicked");
		log.info("Addnew button is clicked");
		
		WebElement Fee = driver.findElement(By.xpath(fee));
		Assert.assertTrue(Fee.isDisplayed(), "Button is missing");
		log.info("Fee button is displayed");
		Fee.click();
		Assert.assertTrue(Fee.isEnabled(), "Button is not clicked");
		log.info("Fee button is clicked");
        Thread.sleep(5000);
		
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(feetype)));
        WebElement Feeheader = driver.findElement(By.xpath(feeheader));
		Assert.assertTrue(Feeheader.isDisplayed(), "Header is missing");
		log.info("Fee header is displayed");
		String Feeheadertext = Feeheader.getText();
		System.out.println(Feeheadertext);
		Assert.assertEquals(Feeheadertext, "New Fee");
		log.info("Fee creation window is opened");
				
		WebElement FeeType = driver.findElement(By.xpath(feetype));
		Assert.assertTrue(FeeType.isDisplayed(), "Field is missing");
		Select select1 = new Select(FeeType);
		select1.selectByIndex(1);
		log.info("Fee type is selected");

        WebElement FeetxtCode = driver.findElement(By.id("feetxtCode"));
		Assert.assertTrue(FeetxtCode.isDisplayed(), "FeetxtCode is missing");
		log.info("FeetxtCode field is displayed");
		NewFee = feecode + timestamp;
		FeetxtCode.sendKeys(NewFee);
		log.info("Fee code is entered");
		
        WebElement FeetxtDescription = driver.findElement(By.id("feetxtDescription"));
		Assert.assertTrue(FeetxtDescription.isDisplayed(), "Fee Description is missing");
		log.info("Fee Description field is displayed");
		String Description = "Test Description";
		FeetxtDescription.sendKeys(Description);
		log.info("Fee Description is entered");
		
		WebElement Price = driver.findElement(By.id("Rate"));
		Assert.assertTrue(Price.isDisplayed(), "Fee Price is missing");
		log.info("Fee Price field is displayed");
		Price.clear();
		Price.sendKeys("50");
		log.info("Fee Price is entered");
		
		
		WebElement CategoryName_Input = driver.findElement(By.id("CategoryName_Input"));
		Assert.assertTrue(CategoryName_Input.isDisplayed(), "CategoryName_Input field is missing");
		log.info("CategoryName_Input field is displayed");
		CategoryName_Input.clear();
		CategoryName_Input.sendKeys("Fee");
		Thread.sleep(5000);	
		WebElement CategoryName_List = driver.findElement(By.id("SearchToaddCutomerSuggestions"));
		CategoryName_List.click();
		log.info("CategoryName_List is entered");
		
		WebElement FeeTags = driver.findElement(By.xpath(Tags_fee));
		Assert.assertTrue(FeeTags.isDisplayed(), "Tags field is missing");
		log.info("Tags field is displayed");
		FeeTags.click();
		Thread.sleep(3000);
		WebElement Select_tag = driver.findElement(By.id("tag_1"));
		Select_tag.click();
		log.info("Tag is selected");
		
		
		//*[@id="Taxable"]/i
		
		WebElement Taxableflag = driver.findElement(By.xpath(taxableflag));
		Assert.assertTrue(Taxableflag.isDisplayed(), "Taxableflag checkbox is missing");
		Taxableflag.click();
		log.info("Fee is taxable");
		
		WebElement Applicable_tax = driver.findElement(By.xpath(applicable_tax));
		Assert.assertTrue(Applicable_tax.isDisplayed(), "Applicable_tax field is missing");
		Thread.sleep(5000);
		Select select2 = new Select(Applicable_tax);
		select2.selectByIndex(2);
		log.info("Applicable_tax is selected");
		
		WebElement Savefee = driver.findElement(By.xpath(savefee));
		Assert.assertTrue(Savefee.isDisplayed(), "Save buttob is missing");
		Savefee.click();
		log.info("Save button is clicked");
		Thread.sleep(10000);
		
		WebElement Searchbox = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		Searchbox.sendKeys(NewFee);
		log.info("Fee Name is entered in searchbox");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyfee)));

		WebElement Verifyfee = driver.findElement(By.xpath(verifyfee));	
		Assert.assertTrue(Verifyfee.isDisplayed(), "No relevent data appeared");
		log.info("the text is " + Verifyfee.getText());		
		Assert.assertEquals(NewFee + " - " +Description,Verifyfee.getText(), "Fee not found");
		log.info("Fee is successfully created");
		
		
	}
	
	@Test(priority = 7)
	public static void AddUnit() throws InterruptedException
	{
		WebDriverWait wt = new WebDriverWait(driver,100);
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(addnew)));
		WebElement Addnew = driver.findElement(By.xpath(addnew));
		Assert.assertTrue(Addnew.isDisplayed(), "Button is missing");
		log.info("Addnew button is displayed");
		Addnew.click();
		Assert.assertTrue(Addnew.isEnabled(), "Button is not clicked");
		log.info("Addnew button is clicked");
		
		WebElement Unit = driver.findElement(By.xpath(unit));
		Assert.assertTrue(Unit.isDisplayed(), "Button is missing");
		log.info("Stock Unit button is displayed");
		Unit.click();
		Assert.assertTrue(Unit.isEnabled(), "Button is not clicked");
		log.info("Stock Unit button is clicked");
        Thread.sleep(5000);
		
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("VINFieldId")));
        WebElement Unitheader = driver.findElement(By.xpath(unitheader));
		Assert.assertTrue(Unitheader.isDisplayed(), "Header is missing");
		log.info("Stock Unit header is displayed");
		String Unitheadertext = Unitheader.getText();
		System.out.println(Unitheadertext);
		Assert.assertEquals(Unitheadertext, "Add Stock Unit");
		log.info("Stock Unit creation window is opened");
		
		WebElement VINFieldId = driver.findElement(By.id("VINFieldId"));
		Assert.assertTrue(VINFieldId.isDisplayed(), "Button is missing");
		log.info("VIN Field Id is displayed");
		NewUnit = unitVIN + timestamp;
		VINFieldId.sendKeys(NewUnit);
		Assert.assertTrue(Unit.isEnabled(), "Button is not clicked");
		log.info("VIN Field Id is filled");
        Thread.sleep(5000);
		
        WebElement UnitMake = driver.findElement(By.xpath(unitmake));
		Assert.assertTrue(UnitMake.isDisplayed(), "Make field is missing");
		log.info("Make field is displayed");
//		UnitMake.click();
//		Thread.sleep(5000);
//		
//		WebElement Makeoption = driver.findElement(By.xpath(makeoption));
//		Makeoption.click();
//		log.info("Make is filled");
		
//		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
		
		WebElement UnitModel = driver.findElement(By.xpath(unitmodel));
		Assert.assertTrue(UnitModel.isDisplayed(), "Model field is missing");
		log.info("Model field is displayed");
//		UnitModel.click();
//		Thread.sleep(5000);
//		
//		WebElement Modeloption = driver.findElement(By.xpath(modeloption));
//		Modeloption.click();
//		log.info("Model is filled");
		
		WebElement UnitSubModel = driver.findElement(By.xpath(unitSubModel));
		Assert.assertTrue(UnitSubModel.isDisplayed(), "SubModel field is missing");
		log.info("SubModel field is displayed");
		UnitSubModel.click();
		Thread.sleep(5000);
		
		WebElement SubModeloption = driver.findElement(By.xpath(submodeloption));
		SubModeloption.click();
		log.info("SubModel is filled");
		Thread.sleep(5000);
		
		WebElement Year = driver.findElement(By.xpath(year));
		Assert.assertTrue(Year.isDisplayed(), 	"Year field is missing");
		Year.click();
		Select select1 = new Select(Year);
		select1.selectByIndex(1);
		log.info("Year is selected");

		WebElement New_unit = driver.findElement(By.xpath(new_unit));
		Assert.assertTrue(New_unit.isDisplayed(), "New_unit checkbox is missing");
		log.info("New_unit flag is displayed");
		New_unit.click();
		log.info("New_unit flag is on");
		
		WebElement Exterior_colour = driver.findElement(By.xpath(exterior_colour));
		Assert.assertTrue(Exterior_colour.isDisplayed(), "Exterior_colour field is missing");
		log.info("Exterior_colour field is displayed");
		Exterior_colour.sendKeys("Celadon");
		log.info("Exterior_colour is selected");
		
		WebElement Stock = driver.findElement(By.xpath(stock));
		Assert.assertTrue(Stock.isDisplayed(), "Stock ID field is missing");
		log.info("Stock ID field is displayed");
		Stock.sendKeys("Sku " + timestamp);
		log.info("Stock ID is selected");
		
		WebElement Cost = driver.findElement(By.id("Cost"));
		Assert.assertTrue(Cost.isDisplayed(), "Cost field is missing");
		log.info("Cost field is displayed");
		Cost.sendKeys("500");
		log.info("Cost is selected");
		
		WebElement Price = driver.findElement(By.id("Price"));
		Assert.assertTrue(Price.isDisplayed(), "Price field is missing");
		log.info("Price field is displayed");
		Price.sendKeys("700");
		log.info("Price is selected");

		WebElement UnitApplicable_tax = driver.findElement(By.xpath(unitApplicable_tax));
		Assert.assertTrue(UnitApplicable_tax.isDisplayed(), "UnitApplicable_tax field is missing");
		Select select2 = new Select(UnitApplicable_tax);
		select2.selectByIndex(1);
		log.info("UnitApplicable_tax is selected");
		
		WebElement TagInputBox = driver.findElement(By.id("tagInputBox"));
		Assert.assertTrue(TagInputBox.isDisplayed(), "TagInputBox field is missing");
		log.info("TagInputBox is displayed");
		TagInputBox.click();
		Thread.sleep(2000);
		WebElement Taginputintem = driver.findElement(By.id("tag_0"));
		Assert.assertTrue(Taginputintem.isDisplayed(), "Taginputlist is missing");
		log.info("Taginputlist is displayed");
		Taginputintem.click();
		log.info("Taginputlist is selected");
		
		WebElement SaveUnit = driver.findElement(By.id("saveButton"));
		Assert.assertTrue(SaveUnit.isDisplayed(), "Save Button is missing");
		log.info("Save Button is displayed");
		SaveUnit.click();
		log.info("Save Button is selected");
		Thread.sleep(10000);
		
		WebElement Searchbox = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		Searchbox.sendKeys(NewUnit);
		log.info("Unit Name is entered in searchbox");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyunit)));

		WebElement Verifyunit = driver.findElement(By.xpath(verifyunit));	
		Assert.assertTrue(Verifyunit.isDisplayed(), "No relevent data appeared");
		log.info("the text is " + Verifyunit.getText());		
		Assert.assertEquals(NewUnit,Verifyunit.getText(), "Unit not found");
		log.info("Unit is successfully created");
		
		
		
	}
	

		
	
	
}
