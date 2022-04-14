package Dealership;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;



public class POM extends Variables {
	

	public static String NewKit, NewSublet, NewDeal_Product,
						 NewFinancing_Product, NewWarranty_Plan; 
	public static String Todaysdate = new SimpleDateFormat("d").format(new Date());
	public static int TodaysDateInt = Integer.parseInt(Todaysdate);
	public static Logger log = LogManager.getLogger(POM.class.getName());
	public static Random random = new Random();
	
	@SuppressWarnings("deprecation")
	
	public static void Login() throws Exception 
	{
		
		/*
		 * String projectpath = System.getProperty("user.dir") + File.separator
		 * +"chromedriver.exe" ; System.setProperty("webdriver.chrome.driver",
		 * projectpath); WebDriver driver = new ChromeDriver();
		 */
		// call property class and get the value of browser string from config.properties file

		Property.testProperty();

		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		if (browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		log.info("Windows maximized");

		driver.get(url); 
		log.info("URL entered");

		WebElement Username = driver.findElement(By.id("username"));
		Assert.assertTrue(Username.isDisplayed(), "Username field is missing");
		log.info("Username field is visible");
		Username.sendKeys(username);
		
		WebElement Password = driver.findElement(By.id("password"));
		Assert.assertTrue(Password.isDisplayed(), "Password field is missing");
		log.info("Password field is visible");
		Password.sendKeys(password);
		Password.sendKeys(Keys.RETURN);
		Thread.sleep(15000);
		
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(closebutton)));
		WebElement Closebutton = driver.findElement(By.xpath(closebutton));
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", Closebutton);
		Thread.sleep(5000);
	}
	
	public static void Logout() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet2 = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet2.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet2.click();
		log.info("Account and Settings link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Logout')]")));
		WebElement Logout = driver.findElement(By.xpath("//span[contains(text(),'Logout')]"));
		Assert.assertTrue(Logout.isDisplayed(), "Logout link is missing");
		log.info("Logout link is visible");
		Logout.click();
		log.info("Logout link is clicked");
		Thread.sleep(10000);
	}
	
	public static void SelectCustomer() throws Exception
	
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
//		SelectCustomerDropdown.sendKeys(Masterdata.NewCustomer);
		SelectCustomerField.sendKeys(defaultUser);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerInfo_0")));
		WebElement CustomerInfo = driver.findElement(By.id("customerInfo_0"));
		Assert.assertTrue(CustomerInfo.isDisplayed(), "CustomerInfo is missing");
		log.info("CustomerInfo is visible");
		CustomerInfo.click();
		Thread.sleep(20000);

		if(driver.findElement(By.xpath(sectionHeader)).getText().contains("SELECT CUSTOMER")) 
		{
			//*[@id="ActiveOrder"]/div[2]/div/div[2]/div/div[5]/button
			driver.findElement(By.xpath(activeorderbutton)).click();
			Thread.sleep(10000);
		}

		
	}

	public static void SelectCustomer2() throws Exception
	
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
		SelectCustomerField.sendKeys("BP Customer");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerInfo_0")));
		WebElement CustomerInfo = driver.findElement(By.id("customerInfo_0"));
		Assert.assertTrue(CustomerInfo.isDisplayed(), "CustomerInfo is missing");
		log.info("CustomerInfo is visible");
		CustomerInfo.click();
		Thread.sleep(20000);

		if(driver.findElement(By.xpath(sectionHeader)).getText().contains("SELECT CUSTOMER")) 
		{
			//*[@id="ActiveOrder"]/div[2]/div/div[2]/div/div[5]/button
			driver.findElement(By.xpath(activeorderbutton)).click();
			Thread.sleep(10000);
		}

	}
	
	public static void DeleteCOU() throws Exception

	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
		WebElement Searchbox = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		Searchbox.sendKeys(defaultUser);
		log.info("Customer name is entered in seachbox");
		Thread.sleep(10000);
		
		
		WebElement SearcResult = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(SearcResult.isDisplayed(), "SearcResult is missing");
		log.info("SearcResults are displayed");
		SearcResult.click();
		log.info("SearcResult0 is clicked");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(infogeneral)));
		WebElement CM_Owned_Units = driver.findElement(By.id("CM_Owned_Units_block_grid_container_tbody_tr_td_2_0"));
		Assert.assertTrue(CM_Owned_Units.isDisplayed(), "CM_Owned_Units is missing");
		log.info("CM_Owned_Units are displayed");
		CM_Owned_Units.click();
		log.info("CM_Owned_Units is clicked");
		
		
		WebElement RemoveLink = driver.findElement(By.id("optionsRadios4"));
		Assert.assertTrue(RemoveLink.isDisplayed(), "RemoveLink is missing");
		log.info("RemoveLink is displayed");
		RemoveLink.click();
		log.info("RemoveLink is checked");
		
		
		WebElement GoButton = driver.findElement(By.id("CM_Owned_Units_block_grid_container_tbody_expandtr_edit_box_its-heading_edit-body_0_go_btn"));
		Assert.assertTrue(GoButton.isDisplayed(), "GoButton is missing");
		log.info("GoButton is displayed");
		GoButton.click();
		log.info("GoButton is clicked");
		
		
		WebElement COUStatus = driver.findElement(By.id("CM_Owned_UnitsGrid_Empty_Div"));
		wt.until(ExpectedConditions.visibilityOf(COUStatus));
		Assert.assertTrue(COUStatus.isDisplayed(), "COUStatus is missing");
		String COUStatusText = COUStatus.getText();
		Assert.assertTrue(COUStatusText.contains("No Records Found"));
		log.info("COU is Deleted successfully");

	}

	public static void DeleteCOU2() throws Exception
	
	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
		WebElement Searchbox = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		Searchbox.sendKeys("BP Customer");
		log.info("Customer name is entered in seachbox");
		Thread.sleep(10000);
		
		
		WebElement SearcResult = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(SearcResult.isDisplayed(), "SearcResult is missing");
		log.info("SearcResults are displayed");
		SearcResult.click();
		log.info("SearcResult0 is clicked");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(infogeneral)));
		WebElement CM_Owned_Units = driver.findElement(By.id("CM_Owned_Units_block_grid_container_tbody_tr_td_2_0"));
		Assert.assertTrue(CM_Owned_Units.isDisplayed(), "CM_Owned_Units is missing");
		log.info("CM_Owned_Units are displayed");
		CM_Owned_Units.click();
		log.info("CM_Owned_Units is clicked");
		
		
		WebElement RemoveLink = driver.findElement(By.id("optionsRadios4"));
		Assert.assertTrue(RemoveLink.isDisplayed(), "RemoveLink is missing");
		log.info("RemoveLink is displayed");
		RemoveLink.click();
		log.info("RemoveLink is checked");
		
		
		WebElement GoButton = driver.findElement(By.id("CM_Owned_Units_block_grid_container_tbody_expandtr_edit_box_its-heading_edit-body_0_go_btn"));
		Assert.assertTrue(GoButton.isDisplayed(), "GoButton is missing");
		log.info("GoButton is displayed");
		GoButton.click();
		log.info("GoButton is clicked");
		
		
		WebElement COUStatus = driver.findElement(By.id("CM_Owned_UnitsGrid_Empty_Div"));
		wt.until(ExpectedConditions.visibilityOf(COUStatus));
		Assert.assertTrue(COUStatus.isDisplayed(), "COUStatus is missing");
		String COUStatusText = COUStatus.getText();
		Assert.assertTrue(COUStatusText.contains("No Records Found"));
		log.info("COU is Deleted successfully");

	}

	
	public static void Kitwithoutlabor() throws Exception
	
	{
		Login();
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
		int num = random.nextInt(1000);
		NewKit = kitcode + num;
		KitCode.sendKeys(NewKit);
		log.info("Kit code is entered");

		
		WebElement KitDescription = driver.findElement(By.id("txtdescription"));
		Assert.assertTrue(KitDescription.isDisplayed(), "Description field is missing");
		log.info("Description field is displayed");
		String Description = "Test Description";
		KitDescription.sendKeys(Description);
		log.info("Kit Description is entered");
		
		
		WebElement Savekit = driver.findElement(By.xpath(savekit));
		Assert.assertTrue(Savekit.isDisplayed(), "SaveButton is missing");
		log.info("Save button is displayed");
		Savekit.click();
		log.info("Save button is clicked");
		Thread.sleep(10000);
		
		
		WebElement KitItemPlusicon = driver.findElement(By.xpath(kititemplusicon));
		KitItemPlusicon.click();
		WebElement Attachpart = driver.findElement(By.id("SearchResult_0"));
		Attachpart.click();
		WebElement Searchpart = driver.findElement(By.id("SearchToAddKit"));
		Searchpart.sendKeys("Part-");
		Thread.sleep(10000);
		WebElement selectonepart = driver.findElement(By.id("SearchResult_2"));
		WebElement Go = driver.findElement(By.id("CustomerOrder_SpecialOrderGrid_tbody_expandtr_td_1_1_edit-body_gobtn"));
		Go.click();	
		
	}
	
	public static void Sublet() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 20);
		Login();
		WebElement Searchbox = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
//		Searchbox.sendKeys(Masterdata.NewVendor);
		Searchbox.sendKeys("qavendor");
		log.info("email is entered in searchbox");
		Thread.sleep(10000);
		
		WebElement Verifyemail = driver.findElement(By.xpath(verifyemail));
		Assert.assertTrue(Verifyemail.isDisplayed(), "No relevent data appeared");
		Verifyemail.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("VV_Product_block_heading_panel_left_sub_h1_text_plus_icon")));
		
		WebElement Products = driver.findElement(By.id("VV_Product_block_heading_panel_left_sub_h1_text_plus_icon"));
		Assert.assertTrue(Products.isDisplayed(), "Product menu is missing");
		log.info("Product menu is displayed");
		Products.click();
		log.info("Product menu is clicked");

		WebElement ProductWindow = driver.findElement(By.xpath(productwindow));
		Assert.assertEquals(ProductWindow.getText(), "New Product");
		log.info("New Product window is opened");
		
		WebElement Type = driver.findElement(By.id("type"));
		Assert.assertTrue(Type.isDisplayed(), "Type is missing");
		Select select1 = new Select(Type);
		select1.selectByVisibleText("Sublet");
		log.info("Sublet is selected in Type");

		WebElement Code = driver.findElement(By.id("code"));
		Assert.assertTrue(Code.isDisplayed(), "Code is missing");
		log.info("Code is displayed");
		int num = random.nextInt(1000);
		Code.sendKeys("Code"+num);
		log.info("Code is filled");
		
		WebElement Description = driver.findElement(By.id("description"));
		Assert.assertTrue(Description.isDisplayed(), "Description is missing");
		log.info("Description is displayed");
		Description.sendKeys("The Description");
		log.info("Description is filled");
		

		WebElement Cost = driver.findElement(By.id("Cost"));
		Assert.assertTrue(Cost.isDisplayed(), "Cost is missing");
		log.info("Cost is displayed");
		Cost.sendKeys("10");
		log.info("Cost is filled");


		WebElement Price = driver.findElement(By.id("Price"));
		Assert.assertTrue(Price.isDisplayed(), "Price is missing");
		log.info("Price is displayed");
		Price.sendKeys("20");
		log.info("Price is filled");
		
		WebElement ProductSaveBtn = driver.findElement(By.id("productSaveBtn"));
		Assert.assertTrue(ProductSaveBtn.isDisplayed(), "ProductSaveBtn is missing");
		log.info("ProductSaveBtn is displayed");
		ProductSaveBtn.click();
		log.info("ProductSaveBtn is filled");
		
		NewSublet = "Code"+num + "The Description";
	}
		
	public static void Deal_Product() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 20);
		Login();
		WebElement Searchbox = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
//		Searchbox.sendKeys(Masterdata.NewVendor);
		Searchbox.sendKeys("qavendor");
		log.info("email is entered in searchbox");
		Thread.sleep(10000);
		
		WebElement Verifyemail = driver.findElement(By.xpath(verifyemail));
		Assert.assertTrue(Verifyemail.isDisplayed(), "No relevent data appeared");
		Verifyemail.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("VV_Product_block_heading_panel_left_sub_h1_text_plus_icon")));
		
		WebElement Products = driver.findElement(By.id("VV_Product_block_heading_panel_left_sub_h1_text_plus_icon"));
		Assert.assertTrue(Products.isDisplayed(), "Product menu is missing");
		log.info("Product menu is displayed");
		Products.click();
		log.info("Product menu is clicked");

		WebElement ProductWindow = driver.findElement(By.xpath(productwindow));
		Assert.assertEquals(ProductWindow.getText(), "New Product");
		log.info("New Product window is opened");
		
		WebElement Type = driver.findElement(By.id("type"));
		Assert.assertTrue(Type.isDisplayed(), "Type is missing");
		Select select1 = new Select(Type);
		select1.selectByVisibleText("Deal Product");
		log.info("Sublet is selected in Type");

		WebElement Code = driver.findElement(By.id("code"));
		Assert.assertTrue(Code.isDisplayed(), "Code is missing");
		log.info("Code is displayed");
		int num = random.nextInt(1000);
		Code.sendKeys("Code"+num);
		log.info("Code is filled");
		
		WebElement Description = driver.findElement(By.id("description"));
		Assert.assertTrue(Description.isDisplayed(), "Description is missing");
		log.info("Description is displayed");
		Description.sendKeys("The Description");
		log.info("Description is filled");
		

		WebElement Cost = driver.findElement(By.id("Cost"));
		Assert.assertTrue(Cost.isDisplayed(), "Cost is missing");
		log.info("Cost is displayed");
		Cost.sendKeys("10");
		log.info("Cost is filled");


		WebElement Price = driver.findElement(By.id("Price"));
		Assert.assertTrue(Price.isDisplayed(), "Price is missing");
		log.info("Price is displayed");
		Price.sendKeys("20");
		log.info("Price is filled");
		
		WebElement ProductSaveBtn = driver.findElement(By.id("productSaveBtn"));
		Assert.assertTrue(ProductSaveBtn.isDisplayed(), "ProductSaveBtn is missing");
		log.info("ProductSaveBtn is displayed");
		ProductSaveBtn.click();
		log.info("ProductSaveBtn is filled");		

		NewDeal_Product = "Code"+num + "The Description";
		
	}
	
	public static void Financing_Product() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 20);
		Login();
		WebElement Searchbox = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
//		Searchbox.sendKeys(Masterdata.NewVendor);
		Searchbox.sendKeys("qavendor");
		log.info("email is entered in searchbox");
		Thread.sleep(10000);
		
		WebElement Verifyemail = driver.findElement(By.xpath(verifyemail));
		Assert.assertTrue(Verifyemail.isDisplayed(), "No relevent data appeared");
		Verifyemail.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("VV_Product_block_heading_panel_left_sub_h1_text_plus_icon")));
		
		WebElement Products = driver.findElement(By.id("VV_Product_block_heading_panel_left_sub_h1_text_plus_icon"));
		Assert.assertTrue(Products.isDisplayed(), "Product menu is missing");
		log.info("Product menu is displayed");
		Products.click();
		log.info("Product menu is clicked");

		WebElement ProductWindow = driver.findElement(By.xpath(productwindow));
		Assert.assertEquals(ProductWindow.getText(), "New Product");
		log.info("New Product window is opened");
		
		WebElement Type = driver.findElement(By.id("type"));
		Assert.assertTrue(Type.isDisplayed(), "Type is missing");
		Select select1 = new Select(Type);
		select1.selectByVisibleText("Financing Product");
		log.info("Sublet is selected in Type");

		WebElement Code = driver.findElement(By.id("code"));
		Assert.assertTrue(Code.isDisplayed(), "Code is missing");
		log.info("Code is displayed");
		int num = random.nextInt(1000);
		Code.sendKeys("Code"+num);
		log.info("Code is filled");
		
		WebElement Description = driver.findElement(By.id("description"));
		Assert.assertTrue(Description.isDisplayed(), "Description is missing");
		log.info("Description is displayed");
		Description.sendKeys("The Description");
		log.info("Description is filled");
		

		WebElement Cost = driver.findElement(By.id("Cost"));
		Assert.assertTrue(Cost.isDisplayed(), "Cost is missing");
		log.info("Cost is displayed");
		Cost.sendKeys("10");
		log.info("Cost is filled");


		WebElement Price = driver.findElement(By.id("Price"));
		Assert.assertTrue(Price.isDisplayed(), "Price is missing");
		log.info("Price is displayed");
		Price.sendKeys("20");
		log.info("Price is filled");
		
		WebElement ProductSaveBtn = driver.findElement(By.id("productSaveBtn"));
		Assert.assertTrue(ProductSaveBtn.isDisplayed(), "ProductSaveBtn is missing");
		log.info("ProductSaveBtn is displayed");
		ProductSaveBtn.click();
		log.info("ProductSaveBtn is filled");		
		
		NewFinancing_Product = "Code"+num + "The Description";

	}
	
	public static void Warranty_Plan() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 20);
		Login();
		WebElement Searchbox = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
//		Searchbox.sendKeys(Masterdata.NewVendor);
		Searchbox.sendKeys("qavendor");
		log.info("email is entered in searchbox");
		Thread.sleep(10000);
		
		WebElement Verifyemail = driver.findElement(By.xpath(verifyemail));
		Assert.assertTrue(Verifyemail.isDisplayed(), "No relevent data appeared");
		Verifyemail.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("VV_Product_block_heading_panel_left_sub_h1_text_plus_icon")));
		
		WebElement Products = driver.findElement(By.id("VV_Product_block_heading_panel_left_sub_h1_text_plus_icon"));
		Assert.assertTrue(Products.isDisplayed(), "Product menu is missing");
		log.info("Product menu is displayed");
		Products.click();
		log.info("Product menu is clicked");

		WebElement ProductWindow = driver.findElement(By.xpath(productwindow));
		Assert.assertEquals(ProductWindow.getText(), "New Product");
		log.info("New Product window is opened");
		
		WebElement Type = driver.findElement(By.id("type"));
		Assert.assertTrue(Type.isDisplayed(), "Type is missing");
		Select select1 = new Select(Type);
		select1.selectByVisibleText("Warranty Plan");
		log.info("Sublet is selected in Type");

		WebElement Code = driver.findElement(By.id("code"));
		Assert.assertTrue(Code.isDisplayed(), "Code is missing");
		log.info("Code is displayed");
		int num = random.nextInt(1000);
		Code.sendKeys("Code"+num);
		log.info("Code is filled");
		
		WebElement Description = driver.findElement(By.id("description"));
		Assert.assertTrue(Description.isDisplayed(), "Description is missing");
		log.info("Description is displayed");
		Description.sendKeys("The Description");
		log.info("Description is filled");
		

		WebElement Cost = driver.findElement(By.id("Cost"));
		Assert.assertTrue(Cost.isDisplayed(), "Cost is missing");
		log.info("Cost is displayed");
		Cost.sendKeys("10");
		log.info("Cost is filled");


		WebElement Price = driver.findElement(By.id("Price"));
		Assert.assertTrue(Price.isDisplayed(), "Price is missing");
		log.info("Price is displayed");
		Price.sendKeys("20");
		log.info("Price is filled");
		
		WebElement ProductSaveBtn = driver.findElement(By.id("productSaveBtn"));
		Assert.assertTrue(ProductSaveBtn.isDisplayed(), "ProductSaveBtn is missing");
		log.info("ProductSaveBtn is displayed");
		ProductSaveBtn.click();
		log.info("ProductSaveBtn is filled");		
		NewWarranty_Plan = "Code"+num + "The Description";
	}
		
	public static void CreateAppointment() throws Exception
	{	

		WebDriverWait wt = new WebDriverWait(driver, 100);

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'New Appointment')]")));
		Thread.sleep(10000);
		WebElement NewAppointmentButton = driver.findElement(By.xpath("//button[contains(text(), 'New Appointment')]"));
		Assert.assertTrue(NewAppointmentButton.isDisplayed(), "New Appointment Button is missing");
		log.info("New Appointment Button is visible");
		NewAppointmentButton.click();
		log.info("New Appointment Button is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("appointment_schedule_content")));
		WebElement Appointment_schedule_content = driver.findElement(By.id("appointment_schedule_content"));
		Assert.assertTrue(Appointment_schedule_content.isDisplayed(), "Appointment_schedule_content is missing");
		log.info("Appointment_schedule_content is visible");
		Appointment_schedule_content.click();
		log.info("Appointment_schedule_content is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appointmenttable1)));
		Thread.sleep(5000);
		
		for(int i = 3 ; i <= 7 ; i++)
		{
			String Appointmentdate = driver.findElement(By.xpath("//*[@id='j_id0:AddeditAppoitment']/div/div[1]/div["+i+"]/div[1]/span")).getText();
			int AppointmentdateInt = Integer.parseInt(Appointmentdate);
						
			if(AppointmentdateInt == (TodaysDateInt))
			{
				WebElement AppoitnmentBar = driver.findElement(By.xpath("//*[@id='j_id0:AddeditAppoitment']/div/div[1]/div["+i+"]/div[2]/div[1]/div[1]/span/i"));
				Assert.assertTrue(AppoitnmentBar.isDisplayed(), "AppoitnmentBar is missing");
				log.info("AppoitnmentBar is visible");
				AppoitnmentBar.click();
				log.info("AppoitnmentBar is clicked");	
				Thread.sleep(5000);
				break;
			}
		}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appointment_schedule_contentText)));
		WebElement Appointment_schedule_contentText = driver.findElement(By.xpath(appointment_schedule_contentText));
		Assert.assertTrue(Appointment_schedule_contentText.isDisplayed(), "Appointment_schedule_contentText is missing");
		log.info("Appointment_schedule_contentText is visible");
		String AppointmentDate = Appointment_schedule_contentText.getText();
		log.info("Appointment date is " +AppointmentDate);	
		
		
		WebElement AppointmentTitleId = driver.findElement(By.id("appointmentTitleId"));
		Assert.assertTrue(AppointmentTitleId.isDisplayed(), "AppointmentTitleId is missing");
		log.info("AppointmentTitleId is visible");
		String timestamp = new SimpleDateFormat(" - dd_MM_yyyy hh_mm_ss ").format(new Date());
		AppointmentTitleId.sendKeys(Keys.chord(Keys.CONTROL,"a"), "Appointment"+timestamp);
		log.info("AppointmentTitleId is Renamed");	
		
		
		WebElement CustonameField = driver.findElement(By.id("autocompleteCustomer"));
		Assert.assertTrue(CustonameField.isDisplayed(), "CustonameField is missing");
		log.info("CustonameField is visible");
		CustonameField.sendKeys(appointmentCustomer);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerInfo_0")));
		WebElement CustomerInfo = driver.findElement(By.id("customerInfo_0"));
		Assert.assertTrue(CustomerInfo.isDisplayed(), "CustomerInfo is missing");
		log.info("CustomerInfo is visible");
		CustomerInfo.click();		
		log.info("CustonameField is filled");	
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customernamecard)));	
		WebElement UnitselectionField = driver.findElement(By.id("autocompleteCustomerOwnedUnit"));
		Assert.assertTrue(UnitselectionField.isDisplayed(), "UnitselectionField is missing");
		log.info("UnitselectionField is visible");
		UnitselectionField.click();		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("couInfo_0")));	
		WebElement CouInfo = driver.findElement(By.id("couInfo_0"));
		Assert.assertTrue(CouInfo.isDisplayed(), "CouInfo is missing");
		log.info("CouInfo is visible");
		CouInfo.click();	
		log.info("UnitselectionField is filled");	
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitnamecard)));	
		
		WebElement ConcernNewTag = driver.findElement(By.id("ConcernNewTag"));
		Assert.assertTrue(ConcernNewTag.isDisplayed(), "ConcernNewTag is missing");
		log.info("ConcernNewTag is visible");
		ConcernNewTag.sendKeys("Break loose");
		log.info("ConcernNewTag is filled");	
		
		
		WebElement EstimatedHours = driver.findElement(By.id("estimatedHoursInputId"));
		Assert.assertTrue(EstimatedHours.isDisplayed(), "EstimatedHours is missing");
		log.info("EstimatedHours is visible");
		EstimatedHours.sendKeys(Keys.chord(Keys.CONTROL,"a"), "1");
		log.info("EstimatedHours is filled");	
		EstimatedHours.sendKeys(Keys.TAB);
		

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("Unit-check-in-content")));
		WebElement UnitCheckinTab = driver.findElement(By.id("Unit-check-in-content"));
		Assert.assertTrue(UnitCheckinTab.isDisplayed(), "UnitCheckinTab is missing");
		log.info("UnitCheckinTab is visible");
		UnitCheckinTab.click();
		log.info("UnitCheckinTab is Clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dateDueInField)));
		WebElement DateDueInField = driver.findElement(By.xpath(datePromisedField));
		Assert.assertTrue(DateDueInField.isDisplayed(), "DateDueInField is missing");
		log.info("DateDueInField is visible");
		DateDueInField.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td/a")));
		WebElement DateDueIn = driver.findElement(By.xpath("//tr/td/a[contains(text(), "+TodaysDateInt+")]"));
		Assert.assertTrue(DateDueIn.isDisplayed(), "DateDueIn is missing");
		log.info("DateDueIn is visible");
		DateDueIn.click();
		log.info("DateDueIn is selected");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(datePromisedField)));
		WebElement DatePromisedField = driver.findElement(By.xpath(datePromisedField));
		Assert.assertTrue(DatePromisedField.isDisplayed(), "DatePromisedField is missing");
		log.info("DatePromisedField is visible");
		DatePromisedField.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td/a")));
		WebElement DatePromised = driver.findElement(By.xpath("//tr/td/a[contains(text(), "+TodaysDateInt+")]"));
		Assert.assertTrue(DatePromised.isDisplayed(), "DatePromised is missing");
		log.info("DatePromised is visible");
		DatePromised.click();
		log.info("DatePromised is selected");
		
		
		WebElement UnitCheckinCloseArrow = driver.findElement(By.xpath(unitCheckinCloseArrow));
		Assert.assertTrue(UnitCheckinCloseArrow.isDisplayed(), "UnitCheckinCloseArrow is missing");
		log.info("UnitCheckinCloseArrow is visible");
		UnitCheckinCloseArrow.click();
		log.info("UnitCheckinTab is Closed");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("assign-technician-content")));
		WebElement AssignTechTab = driver.findElement(By.id("assign-technician-content"));
		Assert.assertTrue(AssignTechTab.isDisplayed(), "AssignTechTab is missing");
		log.info("AssignTechTab is visible");
		AssignTechTab.click();
		log.info("AssignTechTab is Clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Add technician')]")));
		
		WebElement Assign_tech_input_Field = driver.findElement(By.id("assign-tech-input"));
		Assert.assertTrue(Assign_tech_input_Field.isDisplayed(), "Assign_tech_input_Field is missing");
		log.info("Assign_tech_input_Field is visible");
		Assign_tech_input_Field.click();
		
		List<WebElement> Assign_tech_inputs = driver.findElements(By.xpath(assign_tech_inputs));
		Iterator<WebElement> it = Assign_tech_inputs.iterator();
		while(it.hasNext())
		{
			WebElement RequiredTech = it.next();
			String RequiredTechName = RequiredTech.getText();			
			if(RequiredTechName.contains(defaultTechnician))
			{
				RequiredTech.click();
				log.info(RequiredTech+" Tech is selected");
				break;
			}
			
		}
	
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Confirm')]")));
		Thread.sleep(5000);
		WebElement ConfirmButton = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
		Assert.assertTrue(ConfirmButton.isDisplayed(), "ConfirmButton is missing");
		log.info("ConfirmButton is visible");
		JavascriptExecutor executer1 = (JavascriptExecutor) driver;
		executer1.executeScript("arguments[0].click();", ConfirmButton);
		log.info("ConfirmButton is clicked");
		Thread.sleep(5000);

		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("time-slot-input")));
		WebElement TimeSlotInput = driver.findElement(By.id("time-slot-input"));
		Assert.assertTrue(TimeSlotInput.isDisplayed(), "TimeSlotInput is missing");
		log.info("TimeSlotInput is visible");
		TimeSlotInput.click();
		Thread.sleep(5000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("timeslot_0")));
		WebElement TimeSlot = driver.findElement(By.id("timeslot_0"));
		Assert.assertTrue(TimeSlot.isDisplayed(), "TimeSlot is missing");
		log.info("TimeSlot is visible");
		TimeSlot.click();
		log.info("TimeSlot is Selected");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td/div/a")));
		Thread.sleep(5000);
		WebElement SaveAppointmentButton = driver.findElement(By.xpath("//button[contains(text(),'Save Appointment')]"));
		Assert.assertTrue(SaveAppointmentButton.isDisplayed(), "SaveAppointmentButton is missing");
		log.info("SaveAppointmentButton is visible");
		SaveAppointmentButton.click();
		log.info("SaveAppointmentButton is Clicked");
		Thread.sleep(5000);
		log.info("Appointment is Created successfully");	

				
		
	}

	public static void EditAppointment() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Day view')]")));
		Thread.sleep(10000);
		WebElement DayViewLink = driver.findElement(By.xpath("//a[contains(text(),'Day view')]"));
		Assert.assertTrue(DayViewLink.isDisplayed(), "DayViewLink is missing");
		log.info("DayViewLink is visible");
		DayViewLink.click();
		log.info("DayViewLink is opened");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td/div")));
		Thread.sleep(5000);
		
		//appointment name - //*[@id="appointmentInfoPopup"]/div/div[2]/div[1]
		
		List<WebElement> AllAppointments = driver.findElements(By.xpath("//tr/td/div"));
//		Iterator<WebElement> it = AllAppointments.iterator();
		for(WebElement MyAppoitnment : AllAppointments )
		{
			Actions action = new Actions(driver);
			action.moveToElement(MyAppoitnment).build().perform();
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appointmentName)));
			WebElement AppointmentName = driver.findElement(By.xpath(appointmentName));
			if(AppointmentName.getText().contains("Appointment -")) 
			{
				MyAppoitnment.click();
				Thread.sleep(10000);
				break;
			}
		}
		
		log.info("Appointment is opened");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitnamecard)));	
		
		WebElement ConcernNewTag = driver.findElement(By.id("ConcernNewTag"));
		Assert.assertTrue(ConcernNewTag.isDisplayed(), "ConcernNewTag is missing");
		log.info("ConcernNewTag is visible");
		ConcernNewTag.sendKeys(Keys.chord(Keys.CONTROL,"a"), "Break loose");
		log.info("ConcernNewTag is filled");	
		
		
		WebElement EstimatedHours = driver.findElement(By.id("estimatedHoursInputId"));
		Assert.assertTrue(EstimatedHours.isDisplayed(), "EstimatedHours is missing");
		log.info("EstimatedHours is visible");
		EstimatedHours.sendKeys(Keys.chord(Keys.CONTROL,"a"), "1");
		log.info("EstimatedHours is filled");	
		EstimatedHours.sendKeys(Keys.TAB);
		
		
		WebElement TechNameandTime = driver.findElement(By.xpath(techNameandTime));
		Assert.assertTrue(TechNameandTime.isDisplayed(), "TechNameandTime is missing");
		log.info("TechNameandTime is " +TechNameandTime.getText());
		
		WebElement SaveAppointmentButton = driver.findElement(By.xpath("//button[contains(text(),'Save Appointment')]"));
		Assert.assertTrue(SaveAppointmentButton.isDisplayed(), "SaveAppointmentButton is missing");
		log.info("SaveAppointmentButton is visible");
		SaveAppointmentButton.click();
		log.info("SaveAppointmentButton is Clicked");
		Thread.sleep(5000);
		log.info("Appointment is edited successfully");	
	}
	
	public static void DeleteAppointment() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
//		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Day view')]")));
//		Thread.sleep(10000);
//		WebElement DayViewLink = driver.findElement(By.xpath("//a[contains(text(),'Day view')]"));
//		Assert.assertTrue(DayViewLink.isDisplayed(), "DayViewLink is missing");
//		log.info("DayViewLink is visible");
//		DayViewLink.click();
//		log.info("DayViewLink is opened");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td/div")));
		Thread.sleep(5000);
		
		//appointment name - //*[@id="appointmentInfoPopup"]/div/div[2]/div[1]
		
		List<WebElement> AllAppointments = driver.findElements(By.xpath("//tr/td/div"));
		int NumberofAppointmentBefore = driver.findElements(By.xpath("//tr/td/div")).size();
		log.info(NumberofAppointmentBefore+" appointments are present");
//		Iterator<WebElement> it = AllAppointments.iterator();
		for(WebElement MyAppoitnment : AllAppointments )
		{
			Actions action = new Actions(driver);
			action.moveToElement(MyAppoitnment).build().perform();
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appointmentName)));
			WebElement AppointmentName = driver.findElement(By.xpath(appointmentName));
			if(AppointmentName.getText().contains("Appointment -")) 
			{
				MyAppoitnment.click();
				Thread.sleep(10000);
				break;
			}
		}
		
		log.info("Appointment is opened");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitnamecard)));	
		
		WebElement ConcernNewTag = driver.findElement(By.id("ConcernNewTag"));
		Assert.assertTrue(ConcernNewTag.isDisplayed(), "ConcernNewTag is missing");
		log.info("ConcernNewTag is visible");
		ConcernNewTag.sendKeys(Keys.chord(Keys.CONTROL,"a"), "Break loose");
		log.info("ConcernNewTag is filled");	
		
		
		WebElement EstimatedHours = driver.findElement(By.id("estimatedHoursInputId"));
		Assert.assertTrue(EstimatedHours.isDisplayed(), "EstimatedHours is missing");
		log.info("EstimatedHours is visible");
		EstimatedHours.sendKeys(Keys.chord(Keys.CONTROL,"a"), "1");
		log.info("EstimatedHours is filled");	
		EstimatedHours.sendKeys(Keys.TAB);
		
		WebElement TechNameandTime = driver.findElement(By.xpath(techNameandTime));
		Assert.assertTrue(TechNameandTime.isDisplayed(), "TechNameandTime is missing");
		log.info("TechNameandTime is " +TechNameandTime.getText());
		
		WebElement DeleteAppointmentButton = driver.findElement(By.xpath("//span[contains(text(),'Delete appointment')]"));
		Assert.assertTrue(DeleteAppointmentButton.isDisplayed(), "DeleteAppointmentButton is missing");
		log.info("DeleteAppointmentButton is visible");
		DeleteAppointmentButton.click();
		log.info("DeleteAppointmentButton is Clicked");
		Thread.sleep(5000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("Yes, delete")));	
		WebElement DeleteAppointmentModalWindow = driver.findElement(By.xpath(deleteAppointmentModalWindow));
		Assert.assertTrue(DeleteAppointmentModalWindow.getText().contains("service job"), "Delete Appointment Modal Window is missing");
		log.info("Delete Appointment Modal Window is opened");
		
		WebElement DltAppointmentBtn = driver.findElement(By.id("Yes, delete"));
		Assert.assertTrue(DltAppointmentBtn.isDisplayed(), "Dlt Appointment Btn is missing");
		log.info("Dlt Appointment Btn is visible");
		DltAppointmentBtn.click();
		log.info("Dlt Appointment Btn is Clicked");
		Thread.sleep(10000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				
		int NumberofAppointmentAfter = driver.findElements(By.xpath("//tr/td/div")).size();
		log.info(NumberofAppointmentAfter+" appointments are present");
		if(NumberofAppointmentAfter < NumberofAppointmentBefore)
		log.info("Appointmen is Deleted Successfully");
	
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	{
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source =ts.getScreenshotAs(OutputType.FILE);
//		String destinationfile =  C:\\Users\\Sparsh\\eclipse-workspace\\DealTest\\Screenshots + testCaseName+ ".png";
//		FileUtils.copyFile(source, new File(destinationfile));
//		
//	}
	

//	public static void Todaydate()
//	{
//	String Todaysdate = new SimpleDateFormat("d").format(new Date());
//	int Todaysdate1 = Integer.parseInt(Todaysdate);
//	System.out.println(Todaysdate1);
//	
//	}
}
