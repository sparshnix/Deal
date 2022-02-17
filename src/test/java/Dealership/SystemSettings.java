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
		
		
	}
}
