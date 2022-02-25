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
import java.util.List;
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
import org.openqa.selenium.Dimension;
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

public class SystemSettings extends POM	{
	
	public static int categoryTypeSize = 9, saleTypeSize = 4;
	public static Random random = new Random();
	
	@Test(priority = 49)
	public static void AccountingIntegration() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings.click();
		log.info("SystemSettings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles)
			if(Tile.getText().contains("Accounting integration"))
			{
				Tile.click();
				break;
			}
			
		log.info("Accounting integration link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(accheader)));
		WebElement AccHeader1 = driver.findElement(By.xpath(accheader));
		Assert.assertTrue(AccHeader1.isDisplayed(), "AccHeader is missing");
		log.info("AccHeader is visible");
		Assert.assertTrue(AccHeader1.getText().contains("Accounting Provider"));
		log.info("AccHeader Text is verified");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(accountingDropDown)));
		WebElement AccountingDropDown = driver.findElement(By.xpath(accountingDropDown));
		Assert.assertTrue(AccountingDropDown.isDisplayed(), "AccountingDropDown is missing");
		log.info("AccountingDropDown is visible");
		AccountingDropDown.click();
		log.info("AccountingDropDown is clicked");
		
		List<WebElement> Accountingoptions = driver.findElements(By.xpath(accountingoptions));
		for(WebElement AccountingOption : Accountingoptions )
		{
			if(AccountingOption.getText().contains("Xero"))
			{
				log.info("The First option is "+AccountingOption.getText());
			}
			
			else if(AccountingOption.getText().contains("QuickBooks"))
			{
				log.info("The Second option is "+AccountingOption.getText());
			}
			
			else if(AccountingOption.getText().contains("MYOB"))
			{
				log.info("The Third option is "+AccountingOption.getText());
			}
			
			else if(AccountingOption.getText().contains("No"))
			{
				log.info("The Forth option is "+AccountingOption.getText());
			}
			
		}
		
		AccountingDropDown.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'TEST CONNECTION')]")));
		WebElement TestButton = driver.findElement(By.xpath("//button[contains(text(),'TEST CONNECTION')]"));
		Assert.assertTrue(TestButton.isDisplayed(), "TestButton is missing");
		log.info("TestButton is visible");
		TestButton.click();
		log.info("TestButton is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Connected successfully')]")));
		WebElement Notification1 = driver.findElement(By.xpath("//div[contains(text(),'Connected successfully')]"));
		Assert.assertTrue(Notification1.isDisplayed(), "Notification is missing");
		log.info("Notification is visible");
		Assert.assertTrue(Notification1.getText().contains("Connected successfully"));
		log.info("Connection is tested");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'NEXT')]")));
		WebElement NextButton1 = driver.findElement(By.xpath("//button[contains(text(),'NEXT')]"));
		Assert.assertTrue(NextButton1.isDisplayed(), "NextButton is missing");
		log.info("NextButton is visible");
		NextButton1.click();
		log.info("NextButton is clicked");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(accheader)));
		WebElement AccHeader2 = driver.findElement(By.xpath(accheader));
		Assert.assertTrue(AccHeader2.isDisplayed(), "AccHeader is missing");
		log.info("AccHeader is visible");
		Assert.assertTrue(AccHeader2.getText().contains("Chart of Accounts"));
		log.info("AccHeader Text is verified");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lastSyncTime)));
		WebElement LastSyncTimeBefore = driver.findElement(By.xpath(lastSyncTime));
		Assert.assertTrue(LastSyncTimeBefore.isDisplayed(), "AccHeader is missing");
		log.info("LastSyncTime is visible");
		String LastSyncTimeValueBefore = LastSyncTimeBefore.getText();
		log.info("LastSyncTime is " +LastSyncTimeValueBefore);
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'SYNC NOW')]")));
		WebElement SyncNowButton = driver.findElement(By.xpath("//button[contains(text(),'SYNC NOW')]"));
		Assert.assertTrue(SyncNowButton.isDisplayed(), "SyncNowButton is missing");
		log.info("SyncNowButton is visible");
		SyncNowButton.click();
		log.info("SyncNowButton is clicked");

		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Accounts synced successfully')]")));
		WebElement Notification2 = driver.findElement(By.xpath("//div[contains(text(),'Accounts synced successfully')]"));
		Assert.assertTrue(Notification2.isDisplayed(), "Notification is missing");
		log.info("Notification is visible");
		Assert.assertTrue(Notification2.getText().contains("Accounts synced successfully"));
		
		WebElement LastSyncTimeAfter = driver.findElement(By.xpath(lastSyncTime));
		Assert.assertTrue(LastSyncTimeAfter.isDisplayed(), "AccHeader is missing");
		log.info("LastSyncTime is visible");
		String LastSyncTimeValueAfter = LastSyncTimeAfter.getText();
		log.info("LastSyncTime is " +LastSyncTimeValueAfter);

		Assert.assertNotEquals(LastSyncTimeValueBefore, LastSyncTimeAfter);
		log.info("Account is Synced successfully");

		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'VIEW')]")));
		WebElement ViewButton = driver.findElement(By.xpath("//button[contains(text(),'VIEW')]"));
		Assert.assertTrue(ViewButton.isDisplayed(), "ViewButton is missing");
		log.info("ViewButton is visible");
		ViewButton.click();
		log.info("ViewButton is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//thead//tr")));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement AccountsListPopUp = driver.findElement(By.xpath(accountsListPopUp));
		Assert.assertTrue(AccountsListPopUp.isDisplayed(), "AccountsListPopUp is missing");
		log.info("AccountsListPopUp is visible");
		Assert.assertTrue(AccountsListPopUp.getText().contains("User Supplied List Of Accounts"));
		log.info("AccountsListPopUp is verified");
		
		
		WebElement OKButton = driver.findElement(By.xpath(okButton));
		Assert.assertTrue(ViewButton.isDisplayed(), "OKButton is missing");
		log.info("OKButton is visible");
		OKButton.click();
		log.info("OKButton is clicked");
		Thread.sleep(5000);

		WebElement NextButton2 = driver.findElement(By.xpath("//button[contains(text(),'NEXT')]"));
		Assert.assertTrue(NextButton2.isDisplayed(), "NextButton is missing");
		log.info("NextButton is visible");
		NextButton2.click();
		log.info("NextButton is clicked");
		Thread.sleep(10000);
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(accheader2)));
		WebElement AccHeader3 = driver.findElement(By.xpath(accheader2));
		Assert.assertTrue(AccHeader3.isDisplayed(), "AccHeader is missing");
		log.info("AccHeader is visible");
		Assert.assertTrue(AccHeader3.getText().contains("Control Accounts"));
		log.info("AccHeader Text is verified");
		
		
		List<WebElement> ControlAccFields = driver.findElements(By.xpath(controlAccFields));
		Iterator<WebElement> it_1 = ControlAccFields.iterator();
		int i = 1;
		while(it_1.hasNext())
		{	
			
			WebElement ControlAccField = it_1.next();
			Assert.assertTrue(ControlAccField.isDisplayed(), i+++ "ControlAccField is missing");
		}
		log.info("ControlAccFields are visible");

		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'NEXT')]")));
		WebElement NextButton3 = driver.findElement(By.xpath("//button[contains(text(),'NEXT')]"));
		Assert.assertTrue(NextButton3.isDisplayed(), "NextButton is missing");
		log.info("NextButton is visible");
		JavascriptExecutor ex1 = (JavascriptExecutor) driver;
		ex1.executeScript("arguments[0].scrollIntoView(true);", NextButton3);
		NextButton3.click();
		log.info("NextButton is clicked");
		Thread.sleep(10000);
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(accheader2)));
		WebElement AccHeader4 = driver.findElement(By.xpath(accheader2));
		Assert.assertTrue(AccHeader4.isDisplayed(), "AccHeader is missing");
		log.info("AccHeader is visible");
		Assert.assertTrue(AccHeader4.getText().contains("Undeposited Funds"));
		log.info("AccHeader Text is verified");
		
		
		List<WebElement> UndepositedFundsFields = driver.findElements(By.xpath(undepositedFundsFields));
		Iterator<WebElement> it_2 = UndepositedFundsFields.iterator();
		int j = 1;
		while(it_2.hasNext())
		{	
			
			WebElement UndepositedFundsField = it_2.next();
			Assert.assertTrue(UndepositedFundsField.isDisplayed(), j+++ "UndepositedFundsField is missing");
		}

		log.info("UndepositedFundsFields are visible");
		
		WebElement NextButton4 = driver.findElement(By.xpath("//button[contains(text(),'NEXT')]"));
		Assert.assertTrue(NextButton4.isDisplayed(), "NextButton is missing");
		log.info("NextButton is visible");
		NextButton4.click();
		log.info("NextButton is clicked");
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(accheader2)));
		WebElement AccHeader5 = driver.findElement(By.xpath(accheader2));
		Assert.assertTrue(AccHeader5.isDisplayed(), "AccHeader is missing");
		log.info("AccHeader is visible");
		Assert.assertTrue(AccHeader5.getText().contains("Default Accounts"));
		log.info("AccHeader Text is verified");
		
		
		List<WebElement> DefaultAccountsFields = driver.findElements(By.xpath(defaultAccountsFields));
		Iterator<WebElement> it_3 = DefaultAccountsFields.iterator();
		int k = 1;
		while(it_3.hasNext())
		{	
			
			WebElement DefaultAccountsField = it_3.next();
			Assert.assertTrue(DefaultAccountsField.isDisplayed(), k+++ "DefaultAccountsField is missing");
		}
		
		log.info("DefaultAccountsFields are visible");
		
		WebElement NextButton5 = driver.findElement(By.xpath("//button[contains(text(),'NEXT')]"));
		Assert.assertTrue(NextButton5.isDisplayed(), "NextButton is missing");
		log.info("NextButton is visible");
		NextButton5.click();
		log.info("NextButton is clicked");
		Thread.sleep(10000);
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(accheader2)));
		WebElement AccHeader6 = driver.findElement(By.xpath(accheader2));
		Assert.assertTrue(AccHeader6.isDisplayed(), "AccHeader is missing");
		log.info("AccHeader is visible");
		Assert.assertTrue(AccHeader6.getText().contains("Categories"));
		log.info("AccHeader Text is verified");
		
		
		for (int c = 1 ; c <= categoryTypeSize ; c++)
		{
			
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addCategorybutton)));
			WebElement AddCategorybutton = driver.findElement(By.xpath(addCategorybutton));
			Assert.assertTrue(AddCategorybutton.isDisplayed(), "AddCategorybutton is missing");
			log.info("AddCategorybutton is visible");
			JavascriptExecutor ex2 = (JavascriptExecutor) driver;
			ex2.executeScript("arguments[0].scrollIntoView(true);", AddCategorybutton);
			AddCategorybutton.click();
			log.info("AddCategorybutton is clicked");
			
			
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addCategoryWindow)));
			Thread.sleep(5000);
			
			WebElement AddCategoryType = driver.findElement(By.xpath(addCategoryType));
			Assert.assertTrue(AddCategoryType.isDisplayed(), "AddCategoryType is missing");
			log.info("AddCategoryType is visible");
			AddCategoryType.click();
			log.info("AddCategoryType is clicked");
			Thread.sleep(3000);
			log.info("Category Types are opened");
			
			WebElement Category = driver.findElement(By.xpath("//*[@id=\"addEditCategory\"]/div[2]/div/div/div/div[2]/div[1]/div/ul/li["+c+"]/a/span"));
			Assert.assertTrue(Category.isDisplayed(), "Category is missing");
			log.info("Category is visible");
			Category.click();
			log.info("Category type "+c+" is selected");
			
			WebElement CategoryName = driver.findElement(By.xpath(categoryName));
			Assert.assertTrue(CategoryName.isDisplayed(), "CategoryName is missing");
			log.info("CategoryName is visible");
			String Category_Name = "Auto_"+c;
			CategoryName.sendKeys(Category_Name);
			log.info("CategoryName is entered");
			
			
			WebElement SaveCategory = driver.findElement(By.xpath("//button[contains(text(),'SAVE')]"));
			Assert.assertTrue(SaveCategory.isDisplayed(), "SaveCategory is missing");
			log.info("SaveCategory is visible");
			SaveCategory.click();
			log.info("Category is Saved");
			
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+Category_Name+"')]")));
			WebElement NewCategory = driver.findElement(By.xpath("//td[contains(text(),'"+Category_Name+"')]"));
			Assert.assertTrue(NewCategory.isDisplayed(), "NewCategory is missing");
			log.info("NewCategory is visible");

			
			int count = driver.findElements(By.xpath("//tr/td/div/i")).size();
			WebElement Editicon = driver.findElement(By.xpath("//tr["+count+"]/td/div/i"));
			Assert.assertTrue(Editicon.isDisplayed(), "Editicon is missing");
			log.info("Editicon is visible");
			Editicon.click();
			log.info("Editicon is clicked");
			
			
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Edit Category')]")));
			Thread.sleep(5000);

			WebElement CategoryName1 = driver.findElement(By.xpath(categoryName));
			Assert.assertTrue(CategoryName1.isDisplayed(), "CategoryName is missing");
			log.info("CategoryName is visible");
			String Category_Name1 = Category_Name + "Edit";
			CategoryName1.sendKeys(Keys.chord(Keys.CONTROL,"a"), Category_Name1);
			log.info("CategoryName is entered");
			
			WebElement SaveEdits = driver.findElement(By.xpath("//button[contains(text(),'SAVE')]"));
			Assert.assertTrue(SaveEdits.isDisplayed(), "SaveEdits button is missing");
			log.info("SaveEdits button is visible");
			SaveEdits.click();
			log.info("SaveEdits buton is clicked");
			
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+Category_Name1+"')]")));
			WebElement EditedCategory = driver.findElement(By.xpath("//td[contains(text(),'"+Category_Name1+"')]"));
			Assert.assertTrue(EditedCategory.isDisplayed(), "EditedCategory is missing");
			log.info("Category is successfully edited");
			
			
			WebElement Deleteicon = driver.findElement(By.xpath("//tr["+count+"]/td/div/img"));
			Assert.assertTrue(Deleteicon.isDisplayed(), "Deleteicon is missing");
			log.info("Deleteicon is visible");
			Deleteicon.click();
			log.info("Deleteicon is clicked");
			
			
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Remove Category')]")));
			Thread.sleep(5000);
			

			WebElement DeleteButton = driver.findElement(By.xpath("(//button[contains(text(),'CONFIRM')])[4]"));
			Assert.assertTrue(DeleteButton.isDisplayed(), "DeleteButton is missing");
			log.info("DeleteButton is visible");
			DeleteButton.click();
			log.info("DeleteButton is clicked");	
			Thread.sleep(5000);
			
			Assert.assertFalse(CategoryName1.isDisplayed());
			log.info("Category is successfully deleted");

		}
		
		WebElement NextButton6 = driver.findElement(By.xpath("//button[contains(text(),'NEXT')]"));
		Assert.assertTrue(NextButton6.isDisplayed(), "NextButton is missing");
		log.info("NextButton is visible");
		NextButton6.click();
		log.info("NextButton is clicked");
		Thread.sleep(10000);
		

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(accheader2)));
		WebElement AccHeader7 = driver.findElement(By.xpath(accheader2));
		Assert.assertTrue(AccHeader7.isDisplayed(), "AccHeader is missing");
		log.info("AccHeader is visible");
		Assert.assertTrue(AccHeader7.getText().contains("Transaction Type"));
		log.info("AccHeader Text is verified");
		
		for (int c = 0 ; c < saleTypeSize ; c++)
		{
			
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addCategorybutton)));
			WebElement AddSaleTypebutton = driver.findElement(By.xpath(addCategorybutton));
			Assert.assertTrue(AddSaleTypebutton.isDisplayed(), "AddSaleTypebutton is missing");
			log.info("AddSaleTypebutton is visible");
			JavascriptExecutor ex2 = (JavascriptExecutor) driver;
			ex2.executeScript("arguments[0].scrollIntoView(true);", AddSaleTypebutton);
			AddSaleTypebutton.click();
			log.info("AddSaleTypebutton is clicked");
			
			
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addSaleTypeWindow)));
			Thread.sleep(5000);
			

			WebElement Code = driver.findElement(By.tagName("textarea"));
			Assert.assertTrue(Code.isDisplayed(), "Code is missing");
			log.info("Code is visible");
			int r = random.nextInt(10000);
			Code.sendKeys("AutoCode_"+r);
			log.info("Code is entered");
			Code.sendKeys(Keys.chord(Keys.LEFT_SHIFT, Keys.TAB));
			
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("serviceJobType_"+c)));
			WebElement AddSaleType = driver.findElement(By.id("serviceJobType_"+c));
			Assert.assertTrue(AddSaleType.isDisplayed(), "AddSaleType is missing");
			log.info("AddSaleType is visible");
			AddSaleType.click();
			log.info("Category type "+c+" is selected");
			
			WebElement PartCategories = driver.findElement(By.id("service-job-part-category"));
			Assert.assertTrue(PartCategories.isDisplayed(), "PartCategories is missing");
			log.info("PartCategories is visible");
			PartCategories.click();
			
			WebElement PartCategory = driver.findElement(By.id("serviceJobPartCategory_0"));
			Assert.assertTrue(PartCategory.isDisplayed(), "PartCategory is missing");
			log.info("PartCategory is visible");
			PartCategory.click();
			log.info("PartCategory is selected");

			if(c == 0)
			{
				
				WebElement LaborCategories = driver.findElement(By.id("service-job-labor-category"));
				Assert.assertTrue(LaborCategories.isDisplayed(), "LaborCategories is missing");
				log.info("LaborCategories is visible");
				LaborCategories.click();
				
				WebElement LaborCategory = driver.findElement(By.id("serviceJobLaborCategory_0"));
				Assert.assertTrue(LaborCategory.isDisplayed(), "LaborCategory is missing");
				log.info("LaborCategory is visible");
				LaborCategory.click();
				log.info("LaborCategory is selected");
			}
			
			if(c == 1)
			{
				WebElement LaborCategories = driver.findElement(By.id("service-job-labor-category"));
				Assert.assertTrue(LaborCategories.isDisplayed(), "LaborCategories is missing");
				log.info("LaborCategories is visible");
				LaborCategories.click();
				
				WebElement LaborCategory = driver.findElement(By.id("serviceJobLaborCategory_0"));
				Assert.assertTrue(LaborCategory.isDisplayed(), "LaborCategory is missing");
				log.info("LaborCategory is visible");
				LaborCategory.click();
				log.info("LaborCategory is selected");
				
				WebElement Providers = driver.findElement(By.id("service-job-provider"));
				Assert.assertTrue(Providers.isDisplayed(), "Providers is missing");
				log.info("Providers is visible");
				Providers.click();
				
				WebElement Provider = driver.findElement(By.id("serviceJobProvider_0"));
				Assert.assertTrue(Provider.isDisplayed(), "Provider is missing");
				log.info("Provider is visible");
				Provider.click();
				log.info("Provider is selected");
				
			}	
			if (c == 2)
			{
				
				
				WebElement LaborCategories = driver.findElement(By.id("service-job-labor-category"));
				Assert.assertTrue(LaborCategories.isDisplayed(), "LaborCategories is missing");
				log.info("LaborCategories is visible");
				LaborCategories.click();
				
				WebElement LaborCategory = driver.findElement(By.id("serviceJobLaborCategory_0"));
				Assert.assertTrue(LaborCategory.isDisplayed(), "LaborCategory is missing");
				log.info("LaborCategory is visible");
				LaborCategory.click();
				log.info("LaborCategory is selected");
				
				WebElement InternalCategories = driver.findElement(By.id("service-job-internal-category"));
				Assert.assertTrue(InternalCategories.isDisplayed(), "InternalCategories is missing");
				log.info("InternalCategories is visible");
				InternalCategories.click();
				
				WebElement InternalCategory = driver.findElement(By.id("serviceJobInternalCategory_0"));
				Assert.assertTrue(InternalCategory.isDisplayed(), "InternalCategory is missing");
				log.info("InternalCategory is visible");
				InternalCategory.click();
				log.info("InternalCategory is selected");
				
			}
			
			WebElement SaveSaleType = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
			Assert.assertTrue(SaveSaleType.isDisplayed(), "SaveSaleType button is missing");
			log.info("SaveSaleType button  is visible");
			SaveSaleType.click();
			log.info("SaveSaleType button is clicked");
			Thread.sleep(10000);
			
			for(int tr = 1 ; true ; tr++)
			{
				WebElement CodeName = driver.findElement(By.xpath("//*[@id='AccountingSetupController']/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr["+tr+"]/td[2]"));
				if(CodeName.getText().contains("AutoCode_"+r))
				{
					WebElement EditLink = driver.findElement(By.xpath("//*[@id='AccountingSetupController']/div[2]/div[1]/div[1]/div[2]/div[2]/table/tbody/tr["+tr+"]/td[9]/div[1]/i[1]"));
					Assert.assertTrue(EditLink.isDisplayed(), "EditLink is missing");
					log.info("EditLink  is visible");
					JavascriptExecutor ex3 = (JavascriptExecutor) driver;
					ex3.executeScript("arguments[0].click();", EditLink);
					log.info("EditLink is clicked");
					
					if(c == 0)
					{
						wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-job-labor-category")));
						WebElement LaborCategories = driver.findElement(By.id("service-job-labor-category"));
						Assert.assertTrue(LaborCategories.isDisplayed(), "LaborCategories is missing");
						log.info("LaborCategories is visible");
						LaborCategories.sendKeys(Keys.TAB);
					}
					
					if(c == 1)
					{
						wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-job-provider")));
						WebElement Providers = driver.findElement(By.id("service-job-provider"));
						Assert.assertTrue(Providers.isDisplayed(), "Providers is missing");
						log.info("Providers is visible");
						Providers.sendKeys(Keys.TAB);
					}
					
					if(c == 2)
					{
						wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("service-job-internal-category")));
						WebElement InternalCategories = driver.findElement(By.id("service-job-internal-category"));
						Assert.assertTrue(InternalCategories.isDisplayed(), "InternalCategories is missing");
						log.info("InternalCategories is visible");
						InternalCategories.sendKeys(Keys.TAB);
					}
					
					WebElement SaveEdits = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
					wt.until(ExpectedConditions.visibilityOf(SaveEdits));
					Assert.assertTrue(SaveEdits.isDisplayed(), "SaveEdits button is missing");
					log.info("SaveEdits button  is visible");
					SaveEdits.click();
					log.info("SaveEdits button is clicked");
					Thread.sleep(5000);
					break;
				}
			}
		}
		
		WebElement Finishbutton = driver.findElement(By.xpath("//button[contains(text(),'FINISH')]"));
		wt.until(ExpectedConditions.visibilityOf(Finishbutton));
		Assert.assertTrue(Finishbutton.isDisplayed(), "Finishbutton is missing");
		log.info("Finishbutton  is visible");
		Finishbutton.click();
		log.info("Finishbutton is clicked");
		Thread.sleep(5000);
	}
	
	@Test(priority = 50)
	public static void BrandingManagement() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings.click();
		log.info("SystemSettings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles)
			if(Tile.getText().contains("Branding management"))
			{
				Tile.click();
				break;
			}
		
		log.info("Branding management link is clicked");
		Thread.sleep(10000);
				
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(listoflocations)));
		WebElement BrandHeader1 = driver.findElement(By.xpath(brandHeader));
		Assert.assertTrue(BrandHeader1.isDisplayed(), "BrandHeader link is missing");
		log.info("BrandHeader is " +BrandHeader1.getText());
		
		List<WebElement> Listoflocations = driver.findElements(By.xpath(listoflocations));
		int Count = Listoflocations.size();
		for(int i = 1; i <= Count; i++ )
		{
			if(i == Count)
			{
			WebElement AddNewLocationIcon = driver.findElement(By.xpath("("+listoflocations+")["+Count+"]"));
			Assert.assertTrue(AddNewLocationIcon.isDisplayed(), "AddNewLocationIcon  is missing");
			log.info("AddNewLocationIcon  is visible");
			AddNewLocationIcon.click();
			log.info("AddNewLocationIcon  is clicked");
			break;
			}	
		}
			
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(allinputfields)));
		WebElement BrandHeader2 = driver.findElement(By.xpath(brandHeader));
		Assert.assertTrue(BrandHeader2.isDisplayed(), "BrandHeader link is missing");
		log.info("BrandHeader is " +BrandHeader2.getText());
		
		WebElement BusinessName = driver.findElement(By.xpath(businessname));
		Assert.assertTrue(BusinessName.isDisplayed(), "BusinessName  is missing");
		log.info("BusinessName  is visible");
		BusinessName.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		BusinessName.sendKeys("The BlackPurl Inc.");
		log.info("BusinessName  is filled");
		
		WebElement BusinessPhone = driver.findElement(By.xpath(businessPhone));
		Assert.assertTrue(BusinessPhone.isDisplayed(), "BusinessPhone  is missing");
		log.info("BusinessPhone  is visible");
		BusinessPhone.sendKeys(Keys.chord(Keys.CONTROL, "a"), random.nextInt(1000000000)+"");
		log.info("BusinessPhone  is filled");		
		
		WebElement BusinessEmail = driver.findElement(By.xpath(businessEmail));
		Assert.assertTrue(BusinessEmail.isDisplayed(), "BusinessEmail  is missing");
		log.info("BusinessEmail  is visible");
		BusinessEmail.sendKeys(Keys.chord(Keys.CONTROL, "a"), "blackpurlinc@metacube.com");
		log.info("BusinessEmail  is filled");
		
		WebElement TaxID = driver.findElement(By.xpath(taxID));
		Assert.assertTrue(TaxID.isDisplayed(), "TaxID  is missing");
		log.info("TaxID  is visible");
		TaxID.sendKeys(Keys.chord(Keys.CONTROL, "a"), random.nextInt(1000000000)+"");
		log.info("TaxID  is filled");
		
		WebElement Streetaddress1 = driver.findElement(By.xpath(streetaddress1));
		Assert.assertTrue(Streetaddress1.isDisplayed(), "Streetaddress1  is missing");
		log.info("Streetaddress1  is visible");
		Streetaddress1.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Street1");
		log.info("Streetaddress1  is filled");
			
		WebElement Streetaddress2 = driver.findElement(By.xpath(streetaddress2));
		Assert.assertTrue(Streetaddress2.isDisplayed(), "Streetaddress2  is missing");
		log.info("Streetaddress2  is visible");
		Streetaddress2.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Street2");
		log.info("Streetaddress2  is filled");
		
		WebElement City = driver.findElement(By.xpath(city));
		Assert.assertTrue(City.isDisplayed(), "City  is missing");
		log.info("City  is visible");
		City.sendKeys(Keys.chord(Keys.CONTROL, "a"), "Toronto");
		log.info("City  is filled");
		
		WebElement Pincode = driver.findElement(By.xpath(pincode));
		Assert.assertTrue(Pincode.isDisplayed(), "Pincode  is missing");
		log.info("Pincode  is visible");
		Pincode.sendKeys(Keys.chord(Keys.CONTROL, "a"), random.nextInt(100000)+"");
		log.info("Pincode  is filled");
		
		JavascriptExecutor ex1 = (JavascriptExecutor) driver;
		ex1.executeScript("window.scrollBy(0, 500)", "");
		
		WebElement ChooseAfilebutton = driver.findElement(By.xpath("//input[@type = 'file']"));
		ChooseAfilebutton.sendKeys("C:/Users/Sparsh/eclipse-workspace/Deal/" + filename);
		Thread.sleep(3000);
		WebElement FileLabel = driver.findElement(By.xpath(filelabel));
		Assert.assertTrue(FileLabel.getText().contains(filename), "FileLabel  is missing");
		log.info("FileLabel is " +FileLabel.getText());
		
		
		WebElement FileSize = driver.findElement(By.xpath(fileSize));
		Assert.assertTrue(FileSize.isDisplayed(), "FileSize  is missing");
		log.info("FileSize is " +FileSize.getText());
		

		WebElement CustomerInvoiceTextField = driver.findElement(By.xpath(customerInvoiceTextField));
		Assert.assertTrue(CustomerInvoiceTextField.isDisplayed(), "Customer Invoice Text Field  is missing");
		log.info("Customer Invoice Text Field  is visible");
		CustomerInvoiceTextField.sendKeys(Keys.chord(Keys.CONTROL, "a"), "This is an Automated Invoice");
		log.info("Customer Invoice Text Field  is filled");
		
		
		WebElement ServiceJobDisclaimerSlider = driver.findElement(By.xpath(serviceJobDisclaimerSlider));
		Assert.assertTrue(ServiceJobDisclaimerSlider.isDisplayed(), "Service Job Disclaimer Slider  is missing");
		log.info("Service Job Disclaimer Slider is visible");
		ServiceJobDisclaimerSlider.click();
		log.info("Service Job Disclaimer Slider is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(serviceJobTextField)));
		WebElement ServiceJobTextField = driver.findElement(By.xpath(serviceJobTextField));
		Assert.assertTrue(ServiceJobTextField.isDisplayed(), "Service Job Text Field  is missing");
		log.info("Service JobText Field  is visible");
		ServiceJobTextField.sendKeys(Keys.chord(Keys.CONTROL, "a"), "This is an Automated ServiceJob disclaimer");
		log.info("Service Job Text Field  is filled");
		
		
		WebElement OrderDipositDisclaimerSlider = driver.findElement(By.xpath(orderDipositDisclaimerSlider));
		Assert.assertTrue(OrderDipositDisclaimerSlider.isDisplayed(), "Order Deposit Disclaimer Slider  is missing");
		log.info("Order Deposit Disclaimer Slider is visible");
		OrderDipositDisclaimerSlider.click();
		log.info("Order Deposit Disclaimer Slider is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(orderDepositTextField)));
		WebElement OrderDepositTextField = driver.findElement(By.xpath(orderDepositTextField));
		Assert.assertTrue(OrderDepositTextField.isDisplayed(), "Order Deposit Text Field  is missing");
		log.info("Order Deposit Text Field is visible");
		OrderDepositTextField.sendKeys(Keys.chord(Keys.CONTROL, "a"), "This is an Automated Order Deposit disclaimer");
		log.info("Order Deposit Text Field is filled");
		
		
//		WebElement DealDocumentDisclaimerSlider = driver.findElement(By.xpath(dealDocumentDisclaimerSlider));
//		Assert.assertTrue(DealDocumentDisclaimerSlider.isDisplayed(), "Deal Document Disclaimer Slider  is missing");
//		log.info("Deal Document Disclaimer Slider is visible");
//		DealDocumentDisclaimerSlider.click();
//		log.info("Deal Document Disclaimer Slider is clicked");
		
		
		WebElement DealDocumentTextField = driver.findElement(By.xpath(dealDocumentTextField));
		Assert.assertTrue(DealDocumentTextField.isDisplayed(), "Deal Document Text Field  is missing");
		log.info("Deal Document Text Field is visible");
		DealDocumentTextField.sendKeys(Keys.chord(Keys.CONTROL, "a"), "This is an Automated Deal Document disclaimer");
		log.info("Deal Document Text Field is filled");
		
		
		WebElement ReceiptAddSignatureSlider = driver.findElement(By.xpath(receiptAddSignatureSlider));
		Assert.assertTrue(ReceiptAddSignatureSlider.isDisplayed(), "Receipt Add Signature Slider  is missing");
		log.info("Receipt Add Signature Slider is visible");
		ReceiptAddSignatureSlider.click();
		log.info("Receipt Add Signature Slider is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(receiptDisclaimerSlider)));
		WebElement ReceiptDisclaimerSlider = driver.findElement(By.xpath(receiptDisclaimerSlider));
		Assert.assertTrue(ReceiptDisclaimerSlider.isDisplayed(), "Receipt Disclaimer Slider  is missing");
		log.info("Receipt Disclaimer Slider is visible");
		ReceiptDisclaimerSlider.click();
		log.info("Receipt Disclaimer Slider is clicked");
		
		
		WebElement ReceiptTextField = driver.findElement(By.xpath(receiptTextField));
		Assert.assertTrue(ReceiptTextField.isDisplayed(), "Receipt Text Field  is missing");
		log.info("Receipt Text Field is visible");
		ReceiptTextField.sendKeys(Keys.chord(Keys.CONTROL, "a"), "This is an Automated Receipt disclaimer");
		log.info("Receipt Text Field is filled");
		
		
		WebElement CreateButton = driver.findElement(By.xpath("//span[contains(text(),'Create')]"));
		Assert.assertTrue(CreateButton.isDisplayed(), "CreateButton is missing");
		log.info("CreateButton is visible");
		CreateButton.click();
		log.info("CreateButton is clicked");
		Thread.sleep(10000);
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(listoflocations)));
		List<WebElement> BrandingHeaders = driver.findElements(By.xpath(brandingHeaders));
		Iterator<WebElement> it = BrandingHeaders.iterator();
		while(it.hasNext())
		{
			WebElement BrandingHeader = it.next();
			if(BrandingHeader.getText().contains("The BlackPurl Inc."))
			{
				log.info("The New Branding location is successfully created");
				break;
			}
		}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sell)));
		WebElement Sell = driver.findElement(By.xpath(sell));
		Assert.assertTrue(Sell.isDisplayed(), "Sell link is missing");
		log.info("Sell link is visible");
		Sell.click();
		log.info("Sell link is clickable");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sellpart)));
		Thread.sleep(5000);
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
		Searchbox1.sendKeys("Part-21_12_202104_14_55");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityInfo_0")));
		WebElement Merchentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Merchentity.isDisplayed(), "Merchentity is missing");
		log.info("Merchentity is visible");
		Merchentity.click();
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
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoicewindow)));
		WebElement InvoiceWindow = driver.findElement(By.xpath(invoicewindow));
		Assert.assertTrue(InvoiceWindow.isDisplayed(), "Invoice Window is missing");
		log.info("Invoice Window is visible");
		
		
		WebElement BrandingLocationId = driver.findElement(By.id("BrandingLocationId"));
		Assert.assertTrue(BrandingLocationId.isDisplayed(), "BrandingLocationId is missing");
		log.info("BrandingLocationId is visible");
		BrandingLocationId.click();
		Thread.sleep(3000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("brandingLocationDropdownDiv")));
		
		List<WebElement> BrandingNames = driver.findElements(By.xpath(brandingNames));
		for(WebElement BrandingName : BrandingNames)
		{
			if(BrandingName.getText().contains("The BlackPurl Inc."))
			{
				BrandingName.click();
				Thread.sleep(1000);
				driver.findElement(By.xpath(confirmbrandingbutton)).click();
				Thread.sleep(5000);
				break;
			}
		}
		
		WebElement InvoiceCheckBox = driver.findElement(By.xpath(invoiceCheckBox));
		Assert.assertTrue(InvoiceCheckBox.isDisplayed(), "InvoiceCheckBox is missing");
		log.info("InvoiceCheckBox is visible");
		InvoiceCheckBox.click();
		log.info("InvoiceCheckBox is clicked");
		
		WebElement PrintReceiptCheckBox = driver.findElement(By.xpath(printReceiptCheckBox));
		Assert.assertTrue(PrintReceiptCheckBox.isDisplayed(), "PrintReceiptCheckBox is missing");
		log.info("PrintReceiptCheckBox is visible");
		PrintReceiptCheckBox.click();
		log.info("PrintReceiptCheckBox is clicked");
		
		
		WebElement PrintSelectedButton = driver.findElement(By.xpath("//span[contains(text(),'Print Selected')]"));
		Assert.assertTrue(PrintSelectedButton.isDisplayed(), "PrintSelectedButton is missing");
		log.info("PrintSelectedButton is visible");
		PrintSelectedButton.click();
		log.info("PrintSelectedButton is clicked");
		
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it2 = window.iterator();
		String ParentID = it2.next();
		String ChildID = it2.next();
		driver.switchTo().window(ChildID);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(printHeader)));
		WebElement PrintHeader = driver.findElement(By.xpath(printHeader));
		Assert.assertTrue(PrintHeader.getText().contains("The BlackPurl Inc."), "PrintHeader is missing");
		log.info("PrintHeader is Verified");
		driver.close();
		driver.switchTo().window(ParentID);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invoiceclosebutton)));
		WebElement InvoiceCloseButton = driver.findElement(By.xpath(invoiceclosebutton));
		Assert.assertTrue(InvoiceCloseButton.isDisplayed(), "Invoice Close Button is missing");
		log.info("Invoice Close Button is visible");
		//when the size of element is zero
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", InvoiceCloseButton);
		log.info("Invoice Close Button is clicked");
		Thread.sleep(2000);
		
		//Deleting branding location
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet2 = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet2.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet2.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings2 = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings2.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings2.click();
		log.info("SystemSettings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles2 = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles2)
			if(Tile.getText().contains("Branding management"))
			{
				Tile.click();
				break;
			}
		
		log.info("Branding management link is clicked");
		Thread.sleep(10000);
				
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(listoflocations)));
		WebElement BrandHeader3  = driver.findElement(By.xpath(brandHeader));
		Assert.assertTrue(BrandHeader3.isDisplayed(), "BrandHeader link is missing");
		log.info("BrandHeader is " +BrandHeader3.getText());
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(listoflocations)));
		List<WebElement> BrandingHeaders2 = driver.findElements(By.xpath(brandingHeaders));
		int Count2 = BrandingHeaders2.size();
		for(int i = 0; i< Count2; i++)
		{
			WebElement BrandingHeader = driver.findElement(By.xpath("(" + brandingHeaders +")"+"["+(i+1)+"]"));
			if(BrandingHeader.getText().contains("The BlackPurl Inc."))
			{
				WebElement DeleteBtn = driver.findElement(By.id("deleteBLRow_"+i));
				DeleteBtn.click();
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Yes, delete')]")));
				Thread.sleep(1000);
				WebElement YesDelete = driver.findElement(By.xpath("//button[contains(text(),'Yes, delete')]"));
				Assert.assertTrue(YesDelete.isDisplayed(), "YesDelete link is missing");
				log.info("YesDelete link is visible");
				YesDelete.click();
				log.info("YesDelete link is clicked");
				log.info("Branding Location is successfully Deleted");
				break;
			}
		}
	}

	@Test(priority = 51)
	public static void Businessprofile() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings.click();
		log.info("SystemSettings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles)
			if(Tile.getText().contains("Business profile"))
			{
				Tile.click();
				break;
			}
			
		log.info("Business profile link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(profileHeader)));
		WebElement ProfileHeader = driver.findElement(By.xpath(profileHeader));
		Assert.assertTrue(ProfileHeader.isDisplayed(), "ProfileHeader is missing");
		log.info("ProfileHeader is " +ProfileHeader.getText());
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(businessName)));
		WebElement BusinessName = driver.findElement(By.xpath(businessName));
		Assert.assertTrue(BusinessName.isDisplayed(), "BusinessName is missing");
		String businessname = BusinessName.getText();
		log.info("BusinessName is visible" );
		BusinessName.sendKeys(Keys.chord(Keys.CONTROL,"a"), "BlackPurl Inc.");
		log.info("BusinessName is filled");

		
		WebElement ABRBusinessName = driver.findElement(By.xpath(abrbusinessName));
		Assert.assertTrue(ABRBusinessName.isDisplayed(), "Abbreviated business name is missing");
		log.info("Abbreviated business name is visible" );
		ABRBusinessName.sendKeys(Keys.chord(Keys.CONTROL,"a"), "BLACKPURL");
		log.info("Abbreviated business name is filled");
		
		
		WebElement ShippingAddress = driver.findElement(By.xpath(shippingAddress));
		Assert.assertTrue(ShippingAddress.isDisplayed(), "ShippingAddress is missing");
		log.info("ShippingAddress is visible" );
		ShippingAddress.click();
		log.info("ShippingAddress is clicked");
		
		Select select = new Select(ShippingAddress);
		select.selectByVisibleText("No");
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		Thread.sleep(5000);
		driver.navigate().refresh();
		log.info("Business profile is updated successfully");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(businessName)));
		WebElement BusinessName2 = driver.findElement(By.xpath(businessName));
		BusinessName2.sendKeys(Keys.chord(Keys.CONTROL,"a"), "Grey Rock MotoSports Inc.");
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
	
	}
	
	@Test(priority = 52)
	public static void Cashdrawers() throws Exception
	{
		
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings.click();
		log.info("SystemSettings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles)
			if(Tile.getText().contains("Cash drawers"))
			{
				Tile.click();
				break;
			}
			
		log.info("Cash drawers link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(listofdrawers)));
		WebElement DrawerHeader = driver.findElement(By.xpath(drawerHeader));
		Assert.assertTrue(DrawerHeader.isDisplayed(), "DrawerHeader is missing");
		log.info("DrawerHeader is "+DrawerHeader.getText());
		
		
		WebElement CreateNewButton = driver.findElement(By.xpath("//span[contains(text(),'Create new')]"));
		Assert.assertTrue(CreateNewButton.isDisplayed(), "Create New Button is missing");
		log.info("Create New Button is visible");
		CreateNewButton.click();
		log.info("Create New Button is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addnewDrawerheader)));
		WebElement AddnewDrawerheader = driver.findElement(By.xpath(addnewDrawerheader));
		Assert.assertTrue(AddnewDrawerheader.isDisplayed(), "Addnew Drawerheader is missing");
		log.info("AddnewDrawerheader is " +AddnewDrawerheader.getText());
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(drawerNameField)));
		WebElement DrawerNameField = driver.findElement(By.xpath(drawerNameField));
		Assert.assertTrue(DrawerNameField.isDisplayed(), "DrawerNameField is missing");
		log.info("DrawerNameField is visible" );
		DrawerNameField.sendKeys("Automation Drawer");
		log.info("DrawerNameField is filled");
		
		WebElement Createdrawerbutton = driver.findElement(By.xpath(createdrawerbutton));
		Assert.assertTrue(Createdrawerbutton.isDisplayed(), "Createdrawerbutton is missing");
		log.info("Createdrawerbutton is visible" );
		Createdrawerbutton.click();
		log.info("Createdrawerbutton is clicked");
		Thread.sleep(10000);
		
		List<WebElement> CashDrawers = driver.findElements(By.xpath(cashDrawers));
		Iterator<WebElement> it = CashDrawers.iterator();
		while(it.hasNext())
		{
			WebElement CashDrawer = it.next();
			if(CashDrawer.getText().contains("Automation Drawer"))
				{
					log.info("Cash Drawer "+CashDrawer.getText()+" is created successfully");
					break;
				}
		}
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sell)));
		WebElement Sell = driver.findElement(By.xpath(sell));
		Assert.assertTrue(Sell.isDisplayed(), "Sell link is missing");
		log.info("Sell link is visible");
		Sell.click();
		log.info("Sell link is clickable");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sellpart)));
		Thread.sleep(5000);
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
		Searchbox1.sendKeys("Part-21_12_202104_14_55");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityInfo_0")));
		WebElement Merchentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Merchentity.isDisplayed(), "Merchentity is missing");
		log.info("Merchentity is visible");
		Merchentity.click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkout_button)));
		Thread.sleep(5000);
		WebElement Checkout_Button = driver.findElement(By.xpath(checkout_button));
		Assert.assertTrue(Checkout_Button.isDisplayed(), "Checkout_Button is missing");
		log.info("Checkout_Button is visible");
		Checkout_Button.click();
		Thread.sleep(10000);

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(setCashDrawerModalWindow)));
		driver.findElement(By.id("cashDrawer")).click();
		Thread.sleep(3000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("cashDrawerDropdownDiv")));
		List<WebElement> DrawerNames = driver.findElements(By.xpath(drawerNames));
		Iterator<WebElement> IT = DrawerNames.iterator();
		while(IT.hasNext())
		{
			WebElement DrawerName = IT.next();
			if(DrawerName.getText().contains("Automation"))
			{
				DrawerName.click();
				Thread.sleep(3000);
				driver.findElement(By.xpath(selectdrawerbutton)).click();
				Thread.sleep(5000);
				log.info("The Cash drawer is successfully verified on CO");
				break;
			}
		}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet2 = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet2.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet2.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings2 = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings2.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings2.click();
		log.info("SystemSettings link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles2 = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles2)
			if(Tile.getText().contains("Cash drawers"))
			{
				Tile.click();
				break;
			}
			
		log.info("Cash drawers link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cashDrawers)));
		int Count = driver.findElements(By.xpath(cashDrawers)).size();

		for(int i = 2 ; i<=Count ; i++)
		{
			WebElement AutomationDrawer = driver.findElement(By.xpath
			("//*[@id='BP_Home_mainContainer']/div[1]/div/div[3]/div["+i+"]/p"));
			if(AutomationDrawer.getText().contains("Automation Drawer"))
			{
				driver.findElement(By.xpath("//*[@id='BP_Home_mainContainer']/div[1]/div/div[3]/div["+i+"]/div/i"))
				.click();
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(drawerNameField)))
				.sendKeys("Automation Drawer edit");
				driver.findElement(By.xpath("//span[contains(text(),'Save')]"))
				.click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id='BP_Home_mainContainer']/div[1]/div/div[3]/div["+i+"]/div/i"))
				.click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//span[contains(text(),'Delete cash drawer')]"))
				.click();
				Thread.sleep(5000);
				break;
			}
		}
		
		List<WebElement> CashDrawers2 = driver.findElements(By.xpath(cashDrawers));
		Iterator<WebElement> it2 = CashDrawers2.iterator();
		while(it2.hasNext())
		{
			WebElement CashDrawer = it2.next();
			if(CashDrawer.getText().contains("Automation Drawer"))
				{
					Assert.assertTrue(false,"Cash drawer still exist" );
					break;
				}
		}
		
		log.info("Cash drawers is deleted successfully");	
	}
	
	@Test(priority = 53)
	public static void LinkedfeeforDeal() throws Exception
	{

		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings.click();
		log.info("SystemSettings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles)
			if(Tile.getText().contains("Linked fee management"))
			{
				Tile.click();
				break;
			}
			
		log.info("Linked fee management link is clicked");
		Thread.sleep(10000);
		
		WebElement LFeeHeader = driver.findElement(By.xpath(lFeeHeader));
		Assert.assertTrue(LFeeHeader.isDisplayed(), "LFeeHeader is missing");
		log.info("LFeeHeade is " +LFeeHeader.getText() );
				
		WebElement DealFeesection = driver.findElement(By.xpath(dealFeesection));
		Assert.assertTrue(DealFeesection.isDisplayed(), "Deal Feesection is missing");
		log.info("DealFeesection is visible");
		DealFeesection.click();
		log.info("DealFeesection is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'Link a fee')]")));
		WebElement LinkAFeeBtn = driver.findElement(By.xpath("//button[contains(text(),'Link a fee')]"));
		Assert.assertTrue(LinkAFeeBtn.isDisplayed(), "LinkAFeeBtn is missing");
		log.info("LinkAFeeBtn is visible");
		LinkAFeeBtn.click();
		log.info("LinkAFeeBtn is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("feeCodeInput")));
		Thread.sleep(5000);
		WebElement FeeCodeInput = driver.findElement(By.id("feeCodeInput"));
		Assert.assertTrue(FeeCodeInput.isDisplayed(), "FeeCodeInput is missing");
		log.info("FeeCodeInput is visible");
		FeeCodeInput.sendKeys(linkedfee);
		log.info("FeeCodeInput is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("tag_0")));
		WebElement FeeCode = driver.findElement(By.id("tag_0"));
		Assert.assertTrue(FeeCode.isDisplayed(), "Fee Code results are missing");
		log.info("Fee Code results is visible");
		FeeCode.click();
		log.info("FeeCode is selected");
		
		driver.findElement(By.xpath("//button[contains(text(),'Link fee')]")).click();
		Thread.sleep(5000);
		
	
		List<WebElement> Feelist = driver.findElements(By.xpath(feelist));
		for(WebElement DealFee : Feelist)
			if(DealFee.getText().contains(linkedfee))
			{
				log.info("The Deal fee is successfully created");
				break;
			}
		
		//need to fix scrolling issue
		SelectCustomer();
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
		SearchStockunit.sendKeys("sku");
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityInfo_0")));
		WebElement UnitInfo = driver.findElement(By.id("entityInfo_0"));
		UnitInfo.click();
		log.info("Unit1 is selected");	
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitName)));
		Thread.sleep(20000);

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
		
		List<WebElement> FeelistCO = driver.findElements(By.xpath(feelistCO));
		for(WebElement DealFee : FeelistCO)
			if(DealFee.getText().contains(linkedfee))
			{
				log.info("The Deal fee is successfully Verified");
				break;
			}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet2 = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet2.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet2.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings2 = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings2.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings2.click();
		log.info("SystemSettings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles2 = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles2)
			if(Tile.getText().contains("Linked fee management"))
			{
				Tile.click();
				break;
			}
			
		log.info("Linked fee management link is clicked");
		Thread.sleep(10000);
		
		WebElement LFeeHeader2 = driver.findElement(By.xpath(lFeeHeader));
		Assert.assertTrue(LFeeHeader2.isDisplayed(), "LFeeHeader is missing");
		log.info("LFeeHeade is " +LFeeHeader2.getText() );
				
		WebElement DealFeesection2 = driver.findElement(By.xpath(dealFeesection));
		Assert.assertTrue(DealFeesection2.isDisplayed(), "Deal Feesection is missing");
		log.info("DealFeesection is visible");
		DealFeesection2.click();
		log.info("DealFeesection is clicked");
		Thread.sleep(10000);
		
		int Count = driver.findElements(By.xpath("//tr[1]/td[1]")).size();
		for(int i = 1 ; i <= Count ; i++)
		{
			WebElement Dealfee = driver.findElement(By.xpath("//tr["+i+"]/td[1]"));
			if(Dealfee.getText().contains(linkedfee))
			{
				driver.findElement(By.xpath("//tr["+i+"]/td[4]/i[1]"))
				.click();
				wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("PriceInput")));
				driver.findElement(By.id("PriceInput")).sendKeys(Keys.chord(Keys.CONTROL,"a"),"100");
				driver.findElement(By.xpath("//button[contains(text(),'Save')]"))
				.click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//tr["+i+"]/td[4]/i[2]"))
				.click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//button[contains(text(),'Delete')]"))
				.click();
				Thread.sleep(5000);
				break;
			}
		}
		
		List<WebElement> Feelist2 = driver.findElements(By.xpath(feelist));
		Iterator<WebElement> it2 = Feelist2.iterator();
		while(it2.hasNext())
		{
			WebElement DealFee = it2.next();
			if(DealFee.getText().contains(linkedfee))
				{
					Assert.assertTrue(false,"Deal Fee still exist" );
					break;
				}
		}
		
		log.info("Deal Fee is deleted successfully");	
		
		
	}
	
	@Test(priority = 54)
	public static void LinkedfeeforServiceJobs() throws Exception
	{

		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings.click();
		log.info("SystemSettings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles)
			if(Tile.getText().contains("Linked fee management"))
			{
				Tile.click();
				break;
			}
			
		log.info("Linked fee management link is clicked");
		Thread.sleep(10000);
		
		WebElement LFeeHeader = driver.findElement(By.xpath(lFeeHeader));
		Assert.assertTrue(LFeeHeader.isDisplayed(), "LFeeHeader is missing");
		log.info("LFeeHeade is " +LFeeHeader.getText() );
		
		
		WebElement ServicejobFeesection = driver.findElement(By.xpath(servicejobFeesection));
		Assert.assertTrue(ServicejobFeesection.isDisplayed(), "ServicejobFeesection is missing");
		log.info("ServicejobFeesection is visible");
		ServicejobFeesection.click();
		log.info("ServicejobFeesection is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'Link a fee')]")));
		WebElement LinkAFeeBtn = driver.findElement(By.xpath("//button[contains(text(),'Link a fee')]"));
		Assert.assertTrue(LinkAFeeBtn.isDisplayed(), "LinkAFeeBtn is missing");
		log.info("LinkAFeeBtn is visible");
		LinkAFeeBtn.click();
		log.info("LinkAFeeBtn is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("feeCodeInput")));
		Thread.sleep(5000);
		WebElement FeeCodeInput = driver.findElement(By.id("feeCodeInput"));
		Assert.assertTrue(FeeCodeInput.isDisplayed(), "FeeCodeInput is missing");
		log.info("FeeCodeInput is visible");
		FeeCodeInput.sendKeys(linkedfee);
		log.info("FeeCodeInput is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("tag_0")));
		WebElement FeeCode = driver.findElement(By.id("tag_0"));
		Assert.assertTrue(FeeCode.isDisplayed(), "Fee Code results are missing");
		log.info("Fee Code results is visible");
		FeeCode.click();
		log.info("FeeCode is selected");
		
		driver.findElement(By.xpath("//button[contains(text(),'Link fee')]")).click();
		Thread.sleep(5000);
		
	
		List<WebElement> Feelist = driver.findElements(By.xpath(feelist));
		for(WebElement JobFee : Feelist)
			if(JobFee.getText().contains(linkedfee))
			{
				log.info("The ServiceJob fee is successfully created");
				break;
			}
		
		SelectCustomer();
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

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lpjItems))).click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocompleteServiceJob0")));
		
		List<WebElement> FeelistCO = driver.findElements(By.xpath(feelistCO));
		for(WebElement JobFee : FeelistCO)
			if(JobFee.getText().contains(linkedfee))
			{
				log.info("The ServiceJob fee is successfully Verified");
				break;
			}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet2 = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet2.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet2.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings2 = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings2.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings2.click();
		log.info("SystemSettings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles2 = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles2)
			if(Tile.getText().contains("Linked fee management"))
			{
				Tile.click();
				break;
			}
			
		log.info("Linked fee management link is clicked");
		Thread.sleep(10000);
		
		WebElement LFeeHeader2 = driver.findElement(By.xpath(lFeeHeader));
		Assert.assertTrue(LFeeHeader2.isDisplayed(), "LFeeHeader is missing");
		log.info("LFeeHeade is " +LFeeHeader2.getText() );
				
		WebElement ServicejobFeesection2 = driver.findElement(By.xpath(servicejobFeesection));
		Assert.assertTrue(ServicejobFeesection.isDisplayed(), "ServicejobFeesection is missing");
		log.info("ServicejobFeesection is visible");
		ServicejobFeesection2.click();
		log.info("ServicejobFeesection is clicked");
		Thread.sleep(10000);
		
		int Count = driver.findElements(By.xpath("//tr[1]/td[1]")).size();
		for(int i = 1 ; i <= Count ; i++)
		{
			WebElement Jobfee = driver.findElement(By.xpath("//tr["+i+"]/td[1]"));
			if(Jobfee.getText().contains(linkedfee))
			{
				driver.findElement(By.xpath("//tr["+i+"]/td[4]/i[1]"))
				.click();
				wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("PriceInput")));
				driver.findElement(By.id("PriceInput")).sendKeys(Keys.chord(Keys.CONTROL,"a"),"100");
				driver.findElement(By.xpath("//button[contains(text(),'Save')]"))
				.click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//tr["+i+"]/td[4]/i[2]"))
				.click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//button[contains(text(),'Delete')]"))
				.click();
				Thread.sleep(5000);
				break;
			}
		}
		
		List<WebElement> Feelist2 = driver.findElements(By.xpath(feelist));
		Iterator<WebElement> it2 = Feelist2.iterator();
		while(it2.hasNext())
		{
			WebElement JobFee = it2.next();
			if(JobFee.getText().contains(linkedfee))
				{
					Assert.assertTrue(false,"ServiceJob Fee still exist" );
					break;
				}
		}
		
		log.info("ServiceJob Fee is deleted successfully");	

	}

	@Test(priority = 55)
	public static void LinkedfeeforMarchendise() throws Exception
	{

		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings.click();
		log.info("SystemSettings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles)
			if(Tile.getText().contains("Linked fee management"))
			{
				Tile.click();
				break;
			}
			
		log.info("Linked fee management link is clicked");
		Thread.sleep(10000);
		
		WebElement LFeeHeader = driver.findElement(By.xpath(lFeeHeader));
		Assert.assertTrue(LFeeHeader.isDisplayed(), "LFeeHeader is missing");
		log.info("LFeeHeade is " +LFeeHeader.getText() );
		
		WebElement MerchandiseFeesection = driver.findElement(By.xpath(merchandiseFeesection));
		Assert.assertTrue(MerchandiseFeesection.isDisplayed(), "MerchandiseFeesection is missing");
		log.info("MerchandiseFeesection is visible");
		MerchandiseFeesection.click();
		log.info("MerchandiseFeesection is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'Link a fee')]")));
		WebElement LinkAFeeBtn = driver.findElement(By.xpath("//button[contains(text(),'Link a fee')]"));
		Assert.assertTrue(LinkAFeeBtn.isDisplayed(), "LinkAFeeBtn is missing");
		log.info("LinkAFeeBtn is visible");
		LinkAFeeBtn.click();
		log.info("LinkAFeeBtn is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("feeCodeInput")));
		Thread.sleep(5000);
		WebElement FeeCodeInput = driver.findElement(By.id("feeCodeInput"));
		Assert.assertTrue(FeeCodeInput.isDisplayed(), "FeeCodeInput is missing");
		log.info("FeeCodeInput is visible");
		FeeCodeInput.sendKeys(linkedfee);
		log.info("FeeCodeInput is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("tag_0")));
		WebElement FeeCode = driver.findElement(By.id("tag_0"));
		Assert.assertTrue(FeeCode.isDisplayed(), "Fee Code results are missing");
		log.info("Fee Code results is visible");
		FeeCode.click();
		log.info("FeeCode is selected");
		
		driver.findElement(By.xpath("//button[contains(text(),'Link fee')]")).click();
		Thread.sleep(5000);
		
	
		List<WebElement> Feelist = driver.findElements(By.xpath(feelist));
		for(WebElement MerchFee : Feelist)
			if(MerchFee.getText().contains(linkedfee))
			{
				log.info("The Merchandise fee is successfully created");
				break;
			}

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sell)));
		WebElement Sell = driver.findElement(By.xpath(sell));
		Assert.assertTrue(Sell.isDisplayed(), "Sell link is missing");
		log.info("Sell link is visible");
		Sell.click();
		log.info("Sell link is clickable");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sellpart)));
		Thread.sleep(5000);
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
		Searchbox1.sendKeys("Part-21_12_202104_14_55");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("entityInfo_0")));
		WebElement Merchentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Merchentity.isDisplayed(), "Merchentity is missing");
		log.info("Merchentity is visible");
		Merchentity.click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocompleteMerchandiseSectionWrapperId")));
		Thread.sleep(10000);
		
		List<WebElement> FeelistCO = driver.findElements(By.xpath(feelistCO));
		for(WebElement MerchFee : FeelistCO)
			if(MerchFee.getText().contains(linkedfee))
			{
				log.info("The Merchandise fee is successfully Verified");
				break;
			}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet2 = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet2.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet2.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings2 = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings2.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings2.click();
		log.info("SystemSettings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles2 = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles2)
			if(Tile.getText().contains("Linked fee management"))
			{
				Tile.click();
				break;
			}
			
		log.info("Linked fee management link is clicked");
		Thread.sleep(10000);
		
		WebElement LFeeHeader2 = driver.findElement(By.xpath(lFeeHeader));
		Assert.assertTrue(LFeeHeader2.isDisplayed(), "LFeeHeader is missing");
		log.info("LFeeHeade is " +LFeeHeader2.getText() );
				
		WebElement MerchandiseFeesection2 = driver.findElement(By.xpath(merchandiseFeesection));
		Assert.assertTrue(MerchandiseFeesection2.isDisplayed(), "MerchandiseFeesection is missing");
		log.info("MerchandiseFeesection is visible");
		MerchandiseFeesection2.click();
		log.info("MerchandiseFeesection is clicked");
		Thread.sleep(10000);
		
		int Count = driver.findElements(By.xpath("//tr[1]/td[1]")).size();
		for(int i = 1 ; i <= Count ; i++)
		{
			WebElement MerchFee = driver.findElement(By.xpath("//tr["+i+"]/td[1]"));
			if(MerchFee.getText().contains(linkedfee))
			{
				driver.findElement(By.xpath("//tr["+i+"]/td[4]/i[1]"))
				.click();
				wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("PriceInput")));
				driver.findElement(By.id("PriceInput")).sendKeys(Keys.chord(Keys.CONTROL,"a"),"100");
				driver.findElement(By.xpath("//button[contains(text(),'Save')]"))
				.click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//tr["+i+"]/td[4]/i[2]"))
				.click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//button[contains(text(),'Delete')]"))
				.click();
				Thread.sleep(5000);
				break;
			}
		}
		
		List<WebElement> Feelist2 = driver.findElements(By.xpath(feelist));
		Iterator<WebElement> it2 = Feelist2.iterator();
		while(it2.hasNext())
		{
			WebElement MerchFee = it2.next();
			if(MerchFee.getText().contains(linkedfee))
				{
					Assert.assertTrue(false,"Merchandise Fee still exist" );
					break;
				}
		}
		
		log.info("Merchandise Fee is deleted successfully");	

	}
	
	@Test(priority = 56)
	public static void LinkedformforDeal() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings.click();
		log.info("SystemSettings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles)
			if(Tile.getText().contains("Linked form management"))
			{
				Tile.click();
				break;
			}
			
		log.info("Linked form management link is clicked");
		Thread.sleep(10000);
		
		WebElement FormHeader = driver.findElement(By.xpath(formHeader));
		Assert.assertTrue(FormHeader.isDisplayed(), "FormHeader is missing");
		log.info("LFeeHeade is " +FormHeader.getText() );
		
		WebElement DealFormsection = driver.findElement(By.xpath(dealFormsection));
		Assert.assertTrue(DealFormsection.isDisplayed(), "DealFormsection is missing");
		log.info("DealFormsection is visible");
		DealFormsection.click();
		log.info("DealFormsection is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'Link a form')]")));
		Thread.sleep(5000);
		WebElement LinkAFormBtn = driver.findElement(By.xpath("//button[contains(text(),'Link a form')]"));
		Assert.assertTrue(LinkAFormBtn.isDisplayed(), "LinkAFormBtn is missing");
		log.info("LinkAFormBtn is visible");
		LinkAFormBtn.click();
		log.info("LinkAFormBtn is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("form-rec")));
		Thread.sleep(5000);
		WebElement FormInput = driver.findElement(By.id("form-rec"));
		Assert.assertTrue(FormInput.isDisplayed(), "FormInput is missing");
		log.info("FormInput is visible");
		FormInput.sendKeys("dummy");
		log.info("FormInput is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("form-rec-dropdown-div")));
		Thread.sleep(5000);
		WebElement Formdropdown = driver.findElement(By.id("form-rec-dropdown-div"));
		Assert.assertTrue(Formdropdown.isDisplayed(), "Formdropdown is missing");
		log.info("Formdropdown is visible");
		Formdropdown.click();
		Thread.sleep(3000);
		log.info("Formdropdown is clicked");

		WebElement LinktoDealBtn = driver.findElement(By.xpath("//button[contains(text(),'Link to Deal')]"));
		Assert.assertTrue(LinktoDealBtn.isDisplayed(), "LinktoDealBtn is missing");
		log.info("LinktoDealBtn is visible");
		LinktoDealBtn.click();
		log.info("LinktoDealBtn is clicked");
		Thread.sleep(5000);
		
		List<WebElement> Formlist = driver.findElements(By.xpath(formlist));
		for(WebElement DealForm : Formlist)
			if(DealForm.getText().contains("dummy"))
			{
				log.info("Deal form is successfully created");
				break;
			}
	
		SelectCustomer();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sellAUnit)));
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
		driver.navigate().refresh();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Documents')]")));
		WebElement Documents = driver.findElement(By.xpath("//h2[contains(text(),'Documents')]"));
		JavascriptExecutor ex1 = (JavascriptExecutor) driver;
		ex1.executeScript("arguments[0].scrollIntoView(true);", Documents);
		Assert.assertTrue(Documents.isDisplayed(), "Documents is missing");
		log.info("Documents is visible");
		Documents.click();
		log.info("Documents is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add forms')]")));
		List<WebElement> FormlistCO = driver.findElements(By.xpath(formlistco));
		for(WebElement DealForm : FormlistCO)
			if(DealForm.getText().contains("dummy"))
			{
				log.info("Deal form is successfully verified on CO");
				break;
			}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet2 = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet2.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet2.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings2 = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings2.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings2.click();
		log.info("SystemSettings link is clicked");
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles2 = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles2)
			if(Tile.getText().contains("Linked form management"))
			{
				Tile.click();
				break;
			}
			
		log.info("Linked form management link is clicked");
		Thread.sleep(10000);
		
		WebElement FormHeader2 = driver.findElement(By.xpath(formHeader));
		Assert.assertTrue(FormHeader2.isDisplayed(), "LFeeHeader is missing");
		log.info("LFeeHeade is " +FormHeader2.getText() );
				
		WebElement DealFormsection2 = driver.findElement(By.xpath(dealFormsection));
		Assert.assertTrue(DealFormsection2.isDisplayed(), "Deal Formsection is missing");
		log.info("Deal Formsection is visible");
		DealFormsection2.click();
		log.info("Deal Formsection is clicked");
		Thread.sleep(10000);
		
		int Count = driver.findElements(By.xpath(formlist)).size();
		for(int i = 1 ; i <= (Count) ; i++)
		{
			WebElement Dealform = driver.findElement(By.xpath("("+formlist+")["+i+"]"));
			if(Dealform.getText().contains("dummy"))
			{
				WebElement Unlink = driver.findElement(By.xpath("("+unlink+")["+i+"]"));
				Assert.assertTrue(Unlink.isDisplayed(), "Unlink is missing");
				log.info("Unlink is visible");
				JavascriptExecutor ex2 = (JavascriptExecutor) driver;
				ex2.executeScript("arguments[0].click();", Unlink);
				log.info("Unlink is clicked");
				Thread.sleep(10000);
				break;
			}
		}
		
		List<WebElement> Formlist2 = driver.findElements(By.xpath(formlist));
		Iterator<WebElement> it2 = Formlist2.iterator();
		while(it2.hasNext())
		{
			WebElement DealForm = it2.next();
			if(DealForm.getText().contains("dummy"))
				{
					Assert.assertTrue(false,"Deal Form still exist" );
					break;
				}
		}
		
		log.info("Deal Form is deleted successfully");	

	}
	
	@Test(priority = 57)
	public static void LinkedformforFinancing() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings.click();
		log.info("SystemSettings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles)
			if(Tile.getText().contains("Linked form management"))
			{
				Tile.click();
				break;
			}
			
		log.info("Linked form management link is clicked");
		Thread.sleep(10000);
		
		WebElement FormHeader = driver.findElement(By.xpath(formHeader));
		Assert.assertTrue(FormHeader.isDisplayed(), "FormHeader is missing");
		log.info("LFeeHeade is " +FormHeader.getText() );
		
		WebElement FinancingFormsection = driver.findElement(By.xpath(financingFormsection));
		Assert.assertTrue(FinancingFormsection.isDisplayed(), "FinancingFormsection is missing");
		log.info("FinancingFormsection is visible");
		FinancingFormsection.click();
		log.info("FinancingFormsection is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'Link a form')]")));
		Thread.sleep(5000);
		WebElement LinkAFormBtn = driver.findElement(By.xpath("//button[contains(text(),'Link a form')]"));
		Assert.assertTrue(LinkAFormBtn.isDisplayed(), "LinkAFormBtn is missing");
		log.info("LinkAFormBtn is visible");
		LinkAFormBtn.click();
		log.info("LinkAFormBtn is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("form-rec")));
		Thread.sleep(5000);
		WebElement FormInput = driver.findElement(By.id("form-rec"));
		Assert.assertTrue(FormInput.isDisplayed(), "FormInput is missing");
		log.info("FormInput is visible");
		FormInput.sendKeys("dummy");
		log.info("FormInput is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("form-rec-dropdown-div")));
		Thread.sleep(5000);
		WebElement Formdropdown = driver.findElement(By.id("form-rec-dropdown-div"));
		Assert.assertTrue(Formdropdown.isDisplayed(), "Formdropdown is missing");
		log.info("Formdropdown is visible");
		Formdropdown.click();
		Thread.sleep(3000);
		log.info("Formdropdown is clicked");

		WebElement LinktoFinancingBtn = driver.findElement(By.xpath("//button[contains(text(),'Link to Financing')]"));
		Assert.assertTrue(LinktoFinancingBtn.isDisplayed(), "LinktoFinancingBtn is missing");
		log.info("LinktoFinancingBtn is visible");
		LinktoFinancingBtn.click();
		log.info("LinktoFinancingBtn is clicked");
		Thread.sleep(5000);
		
		List<WebElement> Formlist = driver.findElements(By.xpath(formlist));
		for(WebElement FinancingForm : Formlist)
			if(FinancingForm.getText().contains("dummy"))
			{
				log.info("Financing form is successfully created");
				break;
			}
	
		SelectCustomer();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sellAUnit)));
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
		driver.navigate().refresh();

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(adddealfinancing)));
		WebElement Aadddealfinancing = driver.findElement(By.xpath(adddealfinancing));
		Assert.assertTrue(Aadddealfinancing.isDisplayed(), "Aadddealfinancing button is missing");
		log.info("Aadddealfinancing button is visible");
		Aadddealfinancing.click();
		log.info("Aadddealfinancing button is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2[contains(text(), 'Documents')])[2]")));
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//h2[contains(text(),'Summary')])[2]")).click();
		WebElement FinancingDoc = driver.findElement(By.xpath("(//h2[contains(text(), 'Documents')])[2]"));
		Assert.assertTrue(FinancingDoc.isDisplayed(), "FinancingDoc button is missing");
		log.info("FinancingDoc button is visible");
		FinancingDoc.click();
		log.info("FinancingDoc button is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Add forms')])[2]")));
		List<WebElement> DFFormlistCO = driver.findElements(By.xpath(dfformlistco));
		for(WebElement FinancingForm : DFFormlistCO)
			if(FinancingForm.getText().contains("dummy"))
			{
				log.info("Financing Form is successfully verified on CO");
				break;
			}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet2 = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet2.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet2.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings2 = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings2.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings2.click();
		log.info("SystemSettings link is clicked");
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles2 = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles2)
			if(Tile.getText().contains("Linked form management"))
			{
				Tile.click();
				break;
			}
			
		log.info("Linked form management link is clicked");
		Thread.sleep(10000);
		
		WebElement FormHeader2 = driver.findElement(By.xpath(formHeader));
		Assert.assertTrue(FormHeader2.isDisplayed(), "LFeeHeader is missing");
		log.info("LFeeHeade is " +FormHeader2.getText() );
				
		WebElement FinancingFormsection2 = driver.findElement(By.xpath(financingFormsection));
		Assert.assertTrue(FinancingFormsection2.isDisplayed(), "Financing Formsection is missing");
		log.info("Financing Formsection is visible");
		FinancingFormsection2.click();
		log.info("Financing Formsection is clicked");
		Thread.sleep(10000);
		
		int Count = driver.findElements(By.xpath(formlist)).size();
		for(int i = 1 ; i <= (Count) ; i++)
		{
			WebElement Dealform = driver.findElement(By.xpath("("+formlist+")["+i+"]"));
			if(Dealform.getText().contains("dummy"))
			{
				WebElement Unlink = driver.findElement(By.xpath("("+unlink+")["+i+"]"));
				Assert.assertTrue(Unlink.isDisplayed(), "Unlink is missing");
				log.info("Unlink is visible");
				JavascriptExecutor ex2 = (JavascriptExecutor) driver;
				ex2.executeScript("arguments[0].click();", Unlink);
				log.info("Unlink is clicked");
				Thread.sleep(10000);
				break;
			}
		}
		
		List<WebElement> Formlist2 = driver.findElements(By.xpath(formlist));
		Iterator<WebElement> it2 = Formlist2.iterator();
		while(it2.hasNext())
		{
			WebElement FinancingForm = it2.next();
			if(FinancingForm.getText().contains("dummy"))
				{
					Assert.assertTrue(false,"Financing Form still exist" );
					break;
				}
		}
		
		log.info("Financing Form is deleted successfully");	

		
		
	}
	
	@Test(priority = 58)
	public static void LinkedformforService() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings.click();
		log.info("SystemSettings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles)
			if(Tile.getText().contains("Linked form management"))
			{
				Tile.click();
				break;
			}
			
		log.info("Linked form management link is clicked");
		Thread.sleep(10000);
		
		WebElement FormHeader = driver.findElement(By.xpath(formHeader));
		Assert.assertTrue(FormHeader.isDisplayed(), "FormHeader is missing");
		log.info("LFeeHeade is " +FormHeader.getText() );
		
		WebElement ServiceFormsection = driver.findElement(By.xpath(serviceFormsection));
		Assert.assertTrue(ServiceFormsection.isDisplayed(), "ServiceFormsection is missing");
		log.info("ServiceFormsection is visible");
		ServiceFormsection.click();
		log.info("ServiceFormsection is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'Link a form')]")));
		Thread.sleep(5000);
		WebElement LinkAFormBtn = driver.findElement(By.xpath("//button[contains(text(),'Link a form')]"));
		Assert.assertTrue(LinkAFormBtn.isDisplayed(), "LinkAFormBtn is missing");
		log.info("LinkAFormBtn is visible");
		LinkAFormBtn.click();
		log.info("LinkAFormBtn is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("form-rec")));
		Thread.sleep(5000);
		WebElement FormInput = driver.findElement(By.id("form-rec"));
		Assert.assertTrue(FormInput.isDisplayed(), "FormInput is missing");
		log.info("FormInput is visible");
		FormInput.sendKeys("dummy");
		log.info("FormInput is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("form-rec-dropdown-div")));
		Thread.sleep(5000);
		WebElement Formdropdown = driver.findElement(By.id("form-rec-dropdown-div"));
		Assert.assertTrue(Formdropdown.isDisplayed(), "Formdropdown is missing");
		log.info("Formdropdown is visible");
		Formdropdown.click();
		Thread.sleep(3000);
		log.info("Formdropdown is clicked");

		WebElement LinktoServiceBtn = driver.findElement(By.xpath("//button[contains(text(),'Link to Service')]"));
		Assert.assertTrue(LinktoServiceBtn.isDisplayed(), "LinktoServiceBtn is missing");
		log.info("LinktoServiceBtn is visible");
		LinktoServiceBtn.click();
		log.info("LinktoServiceBtn is clicked");
		Thread.sleep(5000);
		
		List<WebElement> Formlist = driver.findElements(By.xpath(formlist));
		for(WebElement ServiceForm : Formlist)
			if(ServiceForm.getText().contains("dummy"))
			{
				log.info("Service form is successfully created");
				break;
			}

		SelectCustomer();
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
		driver.navigate().refresh();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Documents')]")));
		Thread.sleep(5000);
		WebElement Documents = driver.findElement(By.xpath("//h2[contains(text(),'Documents')]"));
		Assert.assertTrue(Documents.isDisplayed(), "Documents tab is missing");
		log.info("Documents tab is visible");
		Documents.click();
		log.info("Documents tab is clicked");
		Thread.sleep(5000);
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(servieformlistco)));
		List<WebElement> ServiceFormlistCO = driver.findElements(By.xpath(servieformlistco));
		for(WebElement ServiceForm : ServiceFormlistCO)
			if(ServiceForm.getText().contains("dummy"))
			{
				log.info("Service Form is successfully verified on CO");
				break;
			}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet2 = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet2.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet2.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings2 = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings2.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings2.click();
		log.info("SystemSettings link is clicked");
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles2 = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles2)
			if(Tile.getText().contains("Linked form management"))
			{
				Tile.click();
				break;
			}
			
		log.info("Linked form management link is clicked");
		Thread.sleep(10000);
		
		WebElement FormHeader2 = driver.findElement(By.xpath(formHeader));
		Assert.assertTrue(FormHeader2.isDisplayed(), "LFeeHeader is missing");
		log.info("LFeeHeade is " +FormHeader2.getText() );
				
		WebElement ServiceFormsection2 = driver.findElement(By.xpath(serviceFormsection));
		Assert.assertTrue(ServiceFormsection2.isDisplayed(), "Service Formsection is missing");
		log.info("Service Formsection is visible");
		ServiceFormsection2.click();
		log.info("Service Formsection is clicked");
		Thread.sleep(10000);
		
		int Count = driver.findElements(By.xpath(formlist)).size();
		for(int i = 1 ; i <= (Count) ; i++)
		{
			WebElement Dealform = driver.findElement(By.xpath("("+formlist+")["+i+"]"));
			if(Dealform.getText().contains("dummy"))
			{
				WebElement Unlink = driver.findElement(By.xpath("("+unlink+")["+i+"]"));
				Assert.assertTrue(Unlink.isDisplayed(), "Unlink is missing");
				log.info("Unlink is visible");
				JavascriptExecutor ex2 = (JavascriptExecutor) driver;
				ex2.executeScript("arguments[0].click();", Unlink);
				log.info("Unlink is clicked");
				Thread.sleep(10000);
				break;
			}
		}
		
		List<WebElement> Formlist2 = driver.findElements(By.xpath(formlist));
		Iterator<WebElement> it2 = Formlist2.iterator();
		while(it2.hasNext())
		{
			WebElement FinancingForm = it2.next();
			if(FinancingForm.getText().contains("dummy"))
				{
					Assert.assertTrue(false,"Service Form still exist" );
					break;
				}
		}
		
		log.info("Service Form is deleted successfully");	
		
		
	}
	
	@Test(priority = 59)
	public static void LinkedformforVP() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings.click();
		log.info("SystemSettings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles)
			if(Tile.getText().contains("Linked form management"))
			{
				Tile.click();
				break;
			}
			
		log.info("Linked form management link is clicked");
		Thread.sleep(10000);
		
		WebElement FormHeader = driver.findElement(By.xpath(formHeader));
		Assert.assertTrue(FormHeader.isDisplayed(), "FormHeader is missing");
		log.info("LFeeHeade is " +FormHeader.getText() );
		
		WebElement VPFormsection = driver.findElement(By.xpath(vpFormsection));
		Assert.assertTrue(VPFormsection.isDisplayed(), "VPFormsection is missing");
		log.info("VPFormsection is visible");
		VPFormsection.click();
		log.info("VPFormsection is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'Link a form')]")));
		Thread.sleep(5000);
		WebElement LinkAFormBtn = driver.findElement(By.xpath("//button[contains(text(),'Link a form')]"));
		Assert.assertTrue(LinkAFormBtn.isDisplayed(), "LinkAFormBtn is missing");
		log.info("LinkAFormBtn is visible");
		LinkAFormBtn.click();
		log.info("LinkAFormBtn is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("form-rec")));
		Thread.sleep(5000);
		WebElement FormInput = driver.findElement(By.id("form-rec"));
		Assert.assertTrue(FormInput.isDisplayed(), "FormInput is missing");
		log.info("FormInput is visible");
		FormInput.sendKeys("dummy");
		log.info("FormInput is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("form-rec-dropdown-div")));
		Thread.sleep(5000);
		WebElement Formdropdown = driver.findElement(By.id("form-rec-dropdown-div"));
		Assert.assertTrue(Formdropdown.isDisplayed(), "Formdropdown is missing");
		log.info("Formdropdown is visible");
		Formdropdown.click();
		Thread.sleep(3000);
		log.info("Formdropdown is clicked");
		
		
		WebElement VendorProduct = driver.findElement(By.id("vendor-product"));
		Assert.assertTrue(VendorProduct.isDisplayed(), "VendorProduct is missing");
		log.info("VendorProduct is visible");
		VendorProduct.sendKeys("QA_Sublet");
		Thread.sleep(3000);
		log.info("Formdropdown is clicked");
		
		
		WebElement ProductDropdown = driver.findElement(By.id("vendor-product-dropdown-div"));
		Assert.assertTrue(ProductDropdown.isDisplayed(), "ProductDropdown is missing");
		log.info("ProductDropdown is visible");
		ProductDropdown.click();
		Thread.sleep(3000);
		log.info("ProductDropdown is clicked");
		
		
		WebElement LinktoVPBtn = driver.findElement(By.xpath("//button[contains(text(),'Link to Vendor product')]"));
		Assert.assertTrue(LinktoVPBtn.isDisplayed(), "LinktoVPBtn is missing");
		log.info("LinktoVPBtn is visible");
		LinktoVPBtn.click();
		log.info("LinktoVPBtn is clicked");
		Thread.sleep(5000);
		
		List<WebElement> Formlist = driver.findElements(By.xpath(formlist));
		for(WebElement VPForm : Formlist)
			if(VPForm.getText().contains("dummy"))
			{
				log.info("Vendor Product form is successfully created");
				break;
			}
		
		SelectCustomer();
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
		driver.navigate().refresh();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Documents')]")));
		Thread.sleep(5000);
		WebElement Documents = driver.findElement(By.xpath("//h2[contains(text(),'Documents')]"));
		Assert.assertTrue(Documents.isDisplayed(), "Documents tab is missing");
		log.info("Documents tab is visible");
		Documents.click();
		log.info("Documents tab is clicked");
		Thread.sleep(5000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(servieformlistco)));
		List<WebElement> ServiceFormlistCO = driver.findElements(By.xpath(servieformlistco));
		for(WebElement VPForm : ServiceFormlistCO)
			if(VPForm.getText().contains("dummy"))
			{
				log.info("Vendor product form is already added");
				Assert.assertTrue(false, "Vendor product form is already added");
			}
		
		WebElement LPJItems = driver.findElement(By.xpath(lpjItems));
		LPJItems.click();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocompleteServiceJob0")));
		WebElement Searchbox1 = driver.findElement(By.id("autocompleteServiceJob0"));
		Assert.assertTrue(Searchbox1.isDisplayed(), "Searchbox is missing");
		log.info("Searchbox is visible");
		Searchbox1.sendKeys("QA_Sublet");
		Thread.sleep(10000);
		
		WebElement Merchentity = driver.findElement(By.id("entityInfo_0"));
		Assert.assertTrue(Merchentity.isDisplayed(), "Merchentity is missing");
		log.info("Merchentity is visible");
		Merchentity.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(searchentitytext)).click();
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Documents')]")));
		Thread.sleep(5000);
		WebElement Documents2 = driver.findElement(By.xpath("//h2[contains(text(),'Documents')]"));
		Assert.assertTrue(Documents2.isDisplayed(), "Documents tab is missing");
		log.info("Documents tab is visible");
		Documents2.click();
		log.info("Documents tab is clicked");
		Thread.sleep(5000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(servieformlistco)));
		List<WebElement> ServiceFormlistCO2 = driver.findElements(By.xpath(servieformlistco));
		for(WebElement VPForm : ServiceFormlistCO2)
			if(VPForm.getText().contains("dummy"))
			{
				log.info("Vendor product form is successfully verified on CO");
				break;
			}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(acandset)));
		WebElement ACandSet2 = driver.findElement(By.xpath(acandset));
		Assert.assertTrue(ACandSet2.isDisplayed(), "Account and Settings link is missing");
		log.info("Account and Settings link is visible");
		ACandSet2.click();
		log.info("Account and Settings link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'System settings')]")));
		WebElement SystemSettings2 = driver.findElement(By.xpath("//span[contains(text(),'System settings')]"));
		Assert.assertTrue(SystemSettings2.isDisplayed(), "SystemSettings link is missing");
		log.info("SystemSettings link is visible");
		SystemSettings2.click();
		log.info("SystemSettings link is clicked");
		Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(settingsTiles)));
		
		List<WebElement> SettingsTiles2 = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles2)
			if(Tile.getText().contains("Linked form management"))
			{
				Tile.click();
				break;
			}
			
		log.info("Linked form management link is clicked");
		Thread.sleep(10000);
		
		WebElement FormHeader2 = driver.findElement(By.xpath(formHeader));
		Assert.assertTrue(FormHeader2.isDisplayed(), "LFeeHeader is missing");
		log.info("LFeeHeade is " +FormHeader2.getText() );
				
		WebElement VPFormsection2 = driver.findElement(By.xpath(vpFormsection));
		Assert.assertTrue(VPFormsection2.isDisplayed(), "VP Formsection is missing");
		log.info("VP Formsection is visible");
		VPFormsection2.click();
		log.info("VP Formsection is clicked");
		Thread.sleep(10000);
		
		int Count = driver.findElements(By.xpath(formlist)).size();
		for(int i = 1 ; i <= (Count) ; i++)
		{
			WebElement Dealform = driver.findElement(By.xpath("("+formlist+")["+i+"]"));
			if(Dealform.getText().contains("dummy"))
			{
				WebElement Unlink = driver.findElement(By.xpath("("+unlink+")["+i+"]"));
				Assert.assertTrue(Unlink.isDisplayed(), "Unlink is missing");
				log.info("Unlink is visible");
				JavascriptExecutor ex2 = (JavascriptExecutor) driver;
				ex2.executeScript("arguments[0].click();", Unlink);
				log.info("Unlink is clicked");
				Thread.sleep(10000);
				break;
			}
		}
		
		List<WebElement> Formlist2 = driver.findElements(By.xpath(formlist));
		Iterator<WebElement> it2 = Formlist2.iterator();
		while(it2.hasNext())
		{
			WebElement VPForm = it2.next();
			if(VPForm.getText().contains("dummy"))
				{
					Assert.assertTrue(false,"Vendor product Form still exist" );
					break;
				}
		}
		
		log.info("Vendor product is deleted successfully");	
		
		
	}
	
}
