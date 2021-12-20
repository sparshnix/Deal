package Dealership;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	
	public static String NewKit, NewSublet, NewDeal_Product, NewFinancing_Product, NewWarranty_Plan; 
	private static Logger log = LogManager.getLogger(POM.class.getName());
	public static Random random = new Random();
	@SuppressWarnings("deprecation")
	
	
	
	public static void Login() throws Exception {
		

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
			driver = new FirefoxDriver();
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
		 
		WebElement LoginButton =  driver.findElement(By.id("Login"));
		Assert.assertTrue(LoginButton.isDisplayed(), "Login Button is missing");
		log.info("Login Button is visible");
		LoginButton.sendKeys(Keys.RETURN);
		log.info("Login Button is clicked");
		Thread.sleep(25000);
 
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
	
	
	
//	{
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source =ts.getScreenshotAs(OutputType.FILE);
//		String destinationfile =  C:\\Users\\Sparsh\\eclipse-workspace\\DealTest\\Screenshots + testCaseName+ ".png";
//		FileUtils.copyFile(source, new File(destinationfile));
//		
//	}
	
	

}
