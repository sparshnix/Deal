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
		log.info("FormHeader is " +FormHeader.getText() );
		
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
	
	@Test(priority = 60)
	public static void MakeAndModel() throws Exception
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
			if(Tile.getText().contains("Make & model"))
			{
				Tile.click();
				break;
			}
			
		log.info("Make & model link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(allMakes)));
		Thread.sleep(5000);
		
		WebElement AddNewMakebtn = driver.findElement(By.xpath("//span[contains(text(),'Add new make')]"));
		Assert.assertTrue(AddNewMakebtn.isDisplayed(), "AddNewMakebtn is missing");
		log.info("AddNewMakebtn is visible");
		AddNewMakebtn.click();
		log.info("AddNewMakebtn is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Add a new make')]")));
		Thread.sleep(3000);
		WebElement AddNewMakeField = driver.findElement(By.xpath("//input[@placeholder = 'Enter make name']"));
		Assert.assertTrue(AddNewMakeField.isDisplayed(), "AddNewMakeField is missing");
		log.info("AddNewMakeField is visible");
		int num = random.nextInt(1000);
		AddNewMakeField.sendKeys("make_" + num);
		log.info("AddNewMakeField is filled");
		
		WebElement SaveNewMakebtn = driver.findElement(By.xpath(saveNewMakebtn));
		Assert.assertTrue(SaveNewMakebtn.isDisplayed(), "SaveNewMakebtn is missing");
		log.info("SaveNewMakebtn is visible");
		SaveNewMakebtn.click();
		log.info("SaveNewMakebtn is clicked");
		Thread.sleep(5000);
		
		int Count = driver.findElements(By.xpath(allMakes)).size();
		for(int i = 1 ; i <= Count ; i++)
		{
			WebElement Make = driver.findElement(By.xpath("("+allMakes+")["+i+"]"));
			if(Make.getText().contains("make_" + num))
			{
				log.info("Make is successfully created");
				
				WebElement AddNewModel = driver.findElement(By.xpath("(//a[contains(text(),'Add new model')])["+i+"]"));
				Assert.assertTrue(AddNewModel.isDisplayed(), "AddNewModel is missing");
				log.info("AddNewModel is visible");
				AddNewModel.click();
				log.info("AddNewModel is clicked");
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Add a new model')]")));
				Thread.sleep(3000);
				WebElement AddNewModelField = driver.findElement(By.xpath("//input[@placeholder = 'Enter model name']"));
				Assert.assertTrue(AddNewModelField.isDisplayed(), "AddNewModelField is missing");
				log.info("AddNewModelField is visible");
				AddNewModelField.sendKeys("model_" + num);
				log.info("AddNewModelField is filled");
				
				WebElement ModelDesc = driver.findElement(By.id("ModelDesc"));
				Assert.assertTrue(ModelDesc.isDisplayed(), "ModelDesc is missing");
				log.info("ModelDesc is visible");
				ModelDesc.sendKeys("model_Desc");
				log.info("ModelDesc is filled");
				
				WebElement ModelCategory = driver.findElement(By.id("ModelCategory"));
				Assert.assertTrue(ModelCategory.isDisplayed(), "ModelCategory is missing");
				log.info("ModelCategory is visible");
				ModelCategory.click();
				log.info("ModelCategory is clicked");
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("modelCategory0")));
				WebElement ModelCategory0 = driver.findElement(By.id("modelCategory0"));
				Assert.assertTrue(ModelCategory0.isDisplayed(), "ModelCategory0 is missing");
				log.info("ModelCategory0 is visible");
				ModelCategory0.click();
				log.info("ModelCategory0 is filled");
				
				WebElement SaveNewModelbtn = driver.findElement(By.xpath(saveNewMakebtn));
				Assert.assertTrue(SaveNewModelbtn.isDisplayed(), "SaveNewModelbtn");
				log.info("SaveNewModelbtn is visible");
				SaveNewModelbtn.click();
				log.info("SaveNewModelbtn is clicked");
				Thread.sleep(5000);
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),"+("model_" + num)+")]")));
				log.info("Model is successfully created");
				
				WebElement AddNewSubModel = driver.findElement(By.xpath("(//a[contains(text(),'Add new sub-model')])["+i+"]"));
				Assert.assertTrue(AddNewSubModel.isDisplayed(), "AddNewSubModel is missing");
				log.info("AddNewSubModel is visible");
				AddNewSubModel.click();
				log.info("AddNewSubModel is clicked");		
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Add a new sub-model')]")));
				Thread.sleep(3000);
				WebElement AddNewSubModelField = driver.findElement(By.xpath("//input[@placeholder = 'Enter sub-model name']"));
				Assert.assertTrue(AddNewSubModelField.isDisplayed(), "AddNewSubModelField is missing");
				log.info("AddNewSubModelField is visible");
				AddNewSubModelField.sendKeys("submodel_" + num);
				log.info("AddNewSubModelField is filled");
				
				WebElement SubModelDesc = driver.findElement(By.id("ModelDesc"));
				Assert.assertTrue(SubModelDesc.isDisplayed(), "SubModelDesc is missing");
				log.info("SubModelDesc is visible");
				SubModelDesc.sendKeys("submodel_Desc");
				log.info("SubModelDesc is filled");
				
				WebElement SubModelCategory = driver.findElement(By.id("SubModelCategory"));
				Assert.assertTrue(SubModelCategory.isDisplayed(), "SubModelCategory is missing");
				log.info("SubModelCategory is visible");
				SubModelCategory.click();
				log.info("SubModelCategory is clicked");
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("submodelCategory0")));
				WebElement SubModelCategory0 = driver.findElement(By.id("modelCategory0"));
				Assert.assertTrue(SubModelCategory0.isDisplayed(), "SubModelCategory0 is missing");
				log.info("SubModelCategory0 is visible");
				SubModelCategory0.click();
				log.info("SubModelCategory0 is filled");
				
				WebElement SaveNewSubModelbtn = driver.findElement(By.xpath(saveNewMakebtn));
				Assert.assertTrue(SaveNewSubModelbtn.isDisplayed(), "SaveNewSubModelbtn is missing");
				log.info("SaveNewSubModelbtn is visible");
				SaveNewSubModelbtn.click();
				log.info("SaveNewSubModelbtn is clicked");
				Thread.sleep(5000);
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),"+("submodel_" + num)+")]")));
				log.info("Sub-Model is successfully created");
				
				WebElement Editmake = driver.findElement(By.xpath("("+editmake+")["+i+"]"));
				Assert.assertTrue(Editmake.isDisplayed(), "Editmake is missing");
				log.info("Editmake is visible");
				Editmake.click();
				log.info("Editmake is clicked");
				Thread.sleep(5000);
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Edit make')]")));
				Thread.sleep(3000);
				driver.findElement(By.xpath(saveNewMakebtn)).click();
				Thread.sleep(3000);
				
				WebElement Deletemake = driver.findElement(By.xpath("("+deletemake+")["+i+"]"));
				Assert.assertTrue(Deletemake.isDisplayed(), "Deletemake is missing");
				log.info("Deletemake is visible");
				Deletemake.click();
				log.info("Deletemake is clicked");
				Thread.sleep(5000);
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Yes, delete')]")));
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[contains(text(),'Yes, delete')]")).click();
				Thread.sleep(3000);
				break;
			}	
			
			int Count2 = driver.findElements(By.xpath(allMakes)).size();
			Assert.assertNotEquals(Count, Count2, "Make is not deleted");
			log.info("Make is deleted successfully");		
		}
	}
	
	@Test(priority = 61)
	public static void ProductLocations() throws Exception
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
		
//		JavascriptExecutor ex1 = (JavascriptExecutor) driver;
//		ex1.executeScript("window.scrollBy(0,500)", "");
		
		List<WebElement> SettingsTiles = driver.findElements(By.xpath(settingsTiles));
		for(WebElement Tile : SettingsTiles)
			if(Tile.getText().contains("Product locations"))
			{
				Tile.click();
				log.info("Product locations link is clicked");
				break;
			}
			
	
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(plHeader)));
		WebElement PLHeader = driver.findElement(By.xpath(plHeader));
		Assert.assertTrue(PLHeader.isDisplayed(), "Product locations Header is missing");
		log.info("Product locations Header is visible");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("createNewTagId")));
		WebElement AddLocationField = driver.findElement(By.id("createNewTagId"));
		Assert.assertTrue(AddLocationField.isDisplayed(), "Add Location Field is missing");
		log.info("Add Location Field is visible");
		AddLocationField.sendKeys(Keys.chord("Auto Location",Keys.ENTER));
		log.info("Add Location Field is filled");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Auto Location')]")));
		WebElement AutoLocation = driver.findElement(By.xpath("//span[contains(text(),'Auto Location')]"));
		Assert.assertTrue(AutoLocation.isDisplayed(), "AutoLocation is missing");
		log.info("AutoLocation is visible");
		AutoLocation.click();
				
		WebElement EditLocationfield = driver.findElement(By.xpath(editLocationfield));
		Assert.assertTrue(EditLocationfield.isDisplayed(), "EditLocationfield is missing");
		log.info("EditLocationfield is visible");
		EditLocationfield.sendKeys(Keys.chord(Keys.CONTROL, "a"),"Auto Location 1");
		EditLocationfield.sendKeys(Keys.ENTER);
		log.info("Location is edited");
		
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(addnew)));
		WebElement Addnew = driver.findElement(By.xpath(addnew));
		Assert.assertTrue(Addnew.isDisplayed(), "Button is missing");
		log.info("Addnew button is displayed");
		Addnew.click();
		Assert.assertTrue(Addnew.isEnabled(), "Button is not clicked");
		log.info("Addnew button is clicked");
		
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(part)));
		WebElement Part = driver.findElement(By.xpath(part));
		Assert.assertTrue(Part.isDisplayed(), "Button is missing");
		log.info("Part button is displayed");
		Part.click();
		Assert.assertTrue(Part.isEnabled(), "Button is not clicked");
		log.info("Part button is clicked");
		
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(partheader)));
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
		int num = random.nextInt(1000);
		PartNumber.sendKeys("Part_"+num);
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
		Thread.sleep(10000);
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
		
		
		WebElement Category_Input = driver.findElement(By.id("Category_Input"));
		Assert.assertTrue(Category_Input.isDisplayed(), "Category_Input field is missing");
		log.info("Category_Input field is displayed");
		Category_Input.clear();
		Category_Input.sendKeys("part");
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchToaddCutomerSuggestions")));
		WebElement Category_List = driver.findElement(By.id("SearchToaddCutomerSuggestions"));
		Category_List.click();
		log.info("Category_Input is entered");	
        
		WebElement Tags = driver.findElement(By.xpath(tags));
		Assert.assertTrue(Tags.isDisplayed(), "Tags field is missing");
		log.info("Tagsfield is displayed");
		Tags.sendKeys("auto");
		Thread.sleep(2000);
		WebElement Select_tag = driver.findElement(By.id("tag_0"));
		Select_tag.click();
		log.info("Tag is selected");
		
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		
		WebElement ApplicableTax = driver.findElement(By.id("applicableTaxId"));	
        Select select = new Select(ApplicableTax);
        select.selectByIndex(0);
		log.info("ApplicableTax is selected");
		
		
		WebElement Location = driver.findElement(By.xpath(location));
		Assert.assertTrue(Location.isDisplayed(), "Location field is missing");
		log.info("Location field is displayed");
		Location.sendKeys("Auto Location 1");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchToaddCutomerSuggestions")));
		Thread.sleep(5000);
		WebElement Location_List = driver.findElement(By.id("SearchToaddCutomerSuggestions"));
		Location_List.click();
		log.info("Location_input is entered");	
		
		
		WebElement InStockQty = driver.findElement(By.xpath(inStockQty));
		Assert.assertTrue(InStockQty.isDisplayed(), "Qty field is missing");
		log.info("Qty field is displayed");
		InStockQty.sendKeys("10");
		log.info("Qty is entered");

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

		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locationinfo)));
		Thread.sleep(5000);
		WebElement Locationinfo = driver.findElement(By.xpath(locationinfo));
		Assert.assertTrue(Locationinfo.getText().contains("Auto Location 1"), "Locationinfo is missing");
		log.info("Locationinfo is successfully verified");
		
		driver.navigate().back();
		Thread.sleep(5000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Auto Location 1')]")));
		int Count = driver.findElements(By.xpath(allLocations)).size();
		for(int i = 1 ; i <= Count ; i++)
		{
			WebElement MyLocation = driver.findElement(By.xpath("("+allLocations+"/span)["+i+"]"));
			Assert.assertTrue(MyLocation.isDisplayed(), "MyLocation is missing");
			if(MyLocation.getText().contains("Auto Location 1"))
			{
				WebElement RemoveIcon = driver.findElement(By.xpath("("+allLocations+"/span/i)["+i+"]"));
				Assert.assertTrue(RemoveIcon.isDisplayed(), "RemoveIcon is missing");
				RemoveIcon.click();
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Yes, Delete')]")));
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[contains(text(),'Yes, Delete')]")).click();
				Thread.sleep(5000);
				break;
			}
		}
		
		int Count2 = driver.findElements(By.xpath(allLocations)).size();
		Assert.assertNotEquals(Count, Count2, "Location is not removed");
		log.info("Location is successfully removed");

	}
	
	@Test(priority = 62)
	public static void Tagmanagement() throws Exception
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
			if(Tile.getText().contains("Tag management"))
			{
				Tile.click();
				log.info("Tag management link is clicked");
				break;
			}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tagHeader)));
		WebElement TagHeader = driver.findElement(By.xpath(tagHeader));
		Assert.assertTrue(TagHeader.isDisplayed(), "PTagHeader is missing");
		log.info("TagHeader is visible");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("createNewTagId")));
		WebElement AddTagField = driver.findElement(By.id("createNewTagId"));
		Assert.assertTrue(AddTagField.isDisplayed(), "AddTagField is missing");
		log.info("AddTagField is visible");
		AddTagField.sendKeys(Keys.chord("Auto Tag",Keys.ENTER));
		log.info("AddTagField is filled");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Auto Tag')]")));
		WebElement AutoTag = driver.findElement(By.xpath("//span[contains(text(),'Auto Tag')]"));
		Assert.assertTrue(AutoTag.isDisplayed(), "AutoTag is missing");
		log.info("AutoTag is visible");
		AutoTag.click();
				
		WebElement EditTagfield = driver.findElement(By.xpath(editTagfield));
		Assert.assertTrue(EditTagfield.isDisplayed(), "EditTagfield is missing");
		log.info("EditTagfield is visible");
		EditTagfield.sendKeys(Keys.chord(Keys.CONTROL, "a"),"Auto Tag 1");
		EditTagfield.sendKeys(Keys.ENTER);
		log.info("Tag is edited");
		
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(addnew)));
		WebElement Addnew = driver.findElement(By.xpath(addnew));
		Assert.assertTrue(Addnew.isDisplayed(), "Button is missing");
		log.info("Addnew button is displayed");
		Addnew.click();
		Assert.assertTrue(Addnew.isEnabled(), "Button is not clicked");
		log.info("Addnew button is clicked");
		
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(part)));
		WebElement Part = driver.findElement(By.xpath(part));
		Assert.assertTrue(Part.isDisplayed(), "Button is missing");
		log.info("Part button is displayed");
		Part.click();
		Assert.assertTrue(Part.isEnabled(), "Button is not clicked");
		log.info("Part button is clicked");
		
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(partheader)));
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
		int num = random.nextInt(10000);
		PartNumber.sendKeys("Part_"+num);
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
		Thread.sleep(10000);
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
		
		
		WebElement Category_Input = driver.findElement(By.id("Category_Input"));
		Assert.assertTrue(Category_Input.isDisplayed(), "Category_Input field is missing");
		log.info("Category_Input field is displayed");
		Category_Input.clear();
		Category_Input.sendKeys("part");
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchToaddCutomerSuggestions")));
		Thread.sleep(2000);
		WebElement Category_List = driver.findElement(By.id("SearchToaddCutomerSuggestions"));
		Category_List.click();
		log.info("Category_Input is entered");	
        
		WebElement Tags = driver.findElement(By.xpath(tags));
		Assert.assertTrue(Tags.isDisplayed(), "Tags field is missing");
		log.info("Tagsfield is displayed");
		Tags.sendKeys("Auto Tag 1");
		Thread.sleep(2000);
		WebElement Select_tag = driver.findElement(By.id("tag_0"));
		Select_tag.click();
		log.info("Tag is selected");
		
		((JavascriptExecutor) driver).executeScript("scroll(0,500)");
		
		WebElement ApplicableTax = driver.findElement(By.id("applicableTaxId"));	
        Select select = new Select(ApplicableTax);
        select.selectByIndex(0);
		log.info("ApplicableTax is selected");
		
//		WebElement Location = driver.findElement(By.xpath(location));
//		Assert.assertTrue(Location.isDisplayed(), "Location field is missing");
//		log.info("Location field is displayed");
//		Location.sendKeys("Auto Location 1");
//		
//		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchToaddCutomerSuggestions")));
//		Thread.sleep(5000);
//		WebElement Location_List = driver.findElement(By.id("SearchToaddCutomerSuggestions"));
//		Location_List.click();
//		log.info("Location_input is entered");	
		
		
		WebElement InStockQty = driver.findElement(By.xpath(inStockQty));
		Assert.assertTrue(InStockQty.isDisplayed(), "Qty field is missing");
		log.info("Qty field is displayed");
		InStockQty.sendKeys("10");
		log.info("Qty is entered");

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

		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(taginfo)));
		Thread.sleep(5000);
		WebElement Taginfo = driver.findElement(By.xpath(taginfo));
		Assert.assertTrue(Taginfo.getText().contains("Auto Tag 1"), "Taginfo is missing");
		log.info("Taginfo is successfully verified");
		
		driver.navigate().back();
		Thread.sleep(5000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Auto Tag 1')]")));
		int Count = driver.findElements(By.xpath(allTags)).size();
		for(int i = 1 ; i <= Count ; i++)
		{
			WebElement MyTag = driver.findElement(By.xpath("("+allTags+"/span)["+i+"]"));
			Assert.assertTrue(MyTag.isDisplayed(), "MyTag is missing");
			if(MyTag.getText().contains("Auto Tag 1"))
			{
				WebElement RemoveIcon = driver.findElement(By.xpath("("+allTags+"/span/i)["+i+"]"));
				Assert.assertTrue(RemoveIcon.isDisplayed(), "RemoveIcon is missing");
				RemoveIcon.click();
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Yes, Delete')]")));
				Thread.sleep(3000);
				driver.findElement(By.xpath("//button[contains(text(),'Yes, Delete')]")).click();
				Thread.sleep(5000);
				break;
			}
		}
		
		int Count2 = driver.findElements(By.xpath(allTags)).size();
		Assert.assertNotEquals(Count, Count2, "Tag is not removed");
		log.info("Tag is successfully removed");

	}

	@Test(priority = 63)
	public static void Taxmanagement() throws Exception
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
			if(Tile.getText().contains("Tax management"))
			{
				Tile.click();
				log.info("Tax management link is clicked");
				break;
			}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(taxHeader)));
		WebElement TaxHeader = driver.findElement(By.xpath(taxHeader));
		Assert.assertTrue(TaxHeader.isDisplayed(), "TaxHeader is missing");
		log.info("TaxHeader is visible");

		//*[@id="BP_Home_mainContainer"]/div[1]/div[1]/div[2]/div[2]/label/i[1]
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(taxrates)));
		Thread.sleep(10000);
		WebElement TaxRates = driver.findElement(By.xpath(taxrates));
		Assert.assertTrue(TaxRates.isDisplayed(), "TaxRates link is missing");
		log.info("TaxRates link is visible");
		TaxRates.click();
		log.info("TaxRates link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Add new rate')])[1]")));
		WebElement AddNewSellingTaxRate = driver.findElement(By.xpath("(//*[contains(text(),'Add new rate')])[1]"));
		Assert.assertTrue(AddNewSellingTaxRate.isDisplayed(), "AddNewSellingTaxRate link is missing");
		log.info("AddNewSellingTaxRate link is visible");
		AddNewSellingTaxRate.click();
		log.info("AddNewSellingTaxRate link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'New selling tax rate')]")));
		Thread.sleep(3000);
		WebElement TaxName = driver.findElement(By.xpath(taxname));
		Assert.assertTrue(TaxName.isDisplayed(), "TaxName is missing");
		log.info("TaxName is visible");
		int num = random.nextInt(1000);
		String STR = "sellingtaxrate_"+num;
		TaxName.sendKeys(STR);
		log.info("TaxName is filled");
		
		
		WebElement FormsLabel = driver.findElement(By.xpath(formslabel));
		Assert.assertTrue(FormsLabel.isDisplayed(), "FormsLabel is missing");
		log.info("FormsLabel is visible");
		FormsLabel.sendKeys(STR);
		log.info("FormsLabel is filled");

		WebElement Rate = driver.findElement(By.xpath(rate));
		Assert.assertTrue(Rate.isDisplayed(), "Rate is missing");
		log.info("Rate is visible");
		Rate.sendKeys(Keys.chord(Keys.CONTROL, "a"), "10");
		log.info("Rate is filled");
		
		WebElement SaveButton1 = driver.findElement(By.xpath("(//a[contains(text(), 'Save')])[1]"));
		Assert.assertTrue(SaveButton1.isDisplayed(), "SaveButton is missing");
		log.info("SaveButton is visible");
		SaveButton1.click();
		log.info("SaveButton is clicked");
		driver.navigate().refresh();
		Thread.sleep(15000);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(taxrates))).click();
		
		List<WebElement> TaxrateList = driver.findElements(By.xpath(taxratelist));
		int Count1 = TaxrateList.size();
		System.out.println(Count1);
		for(int k = 1 ; k<=Count1 ; k++)
		{
			System.out.println(k);
			WebElement NewTaxrate = driver.findElement(By.xpath("("+taxratelist+")["+k+"]"));
			System.out.println(k+ " = " +NewTaxrate.getText());
			if(NewTaxrate.getText().contains(STR))
			{
				log.info(STR+" is added successfully");
				driver.navigate().refresh();
				break;
			}
		}
		

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(taxcodes)));
		Thread.sleep(5000);
		WebElement TaxCodes = driver.findElement(By.xpath(taxcodes));
		Assert.assertTrue(TaxCodes.isDisplayed(), "TaxCodes link is missing");
		log.info("TaxCodes link is visible");
		TaxCodes.click();
		log.info("TaxCodes link is clicked");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Add a new tax code')])[1]")));
		WebElement AddNewSellingTaxCode = driver.findElement(By.xpath("(//*[contains(text(),'Add a new tax code')])[1]"));
		Assert.assertTrue(AddNewSellingTaxCode.isDisplayed(), "AddNewSellingTaxCode link is missing");
		log.info("AddNewSellingTaxCode link is visible");
		AddNewSellingTaxCode.click();
		log.info("AddNewSellingTaxCode link is clicked");
				
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'New selling tax code')]")));
		Thread.sleep(3000);
		WebElement TaxCodeName = driver.findElement(By.xpath(taxCodeName));
		Assert.assertTrue(TaxCodeName.isDisplayed(), "TaxCodeName is missing");
		log.info("TaxCodeName is visible");
		String STC = "sellingtaxcode_"+num;
		TaxCodeName.sendKeys(STC);
		log.info("TaxCodeName is filled");
		
		WebElement FormsLabelCode = driver.findElement(By.xpath(formslabelcode));
		Assert.assertTrue(FormsLabelCode.isDisplayed(), "FormsLabelCode is missing");
		log.info("FormsLabelCode is visible");
		FormsLabelCode.sendKeys(STC);
		log.info("FormsLabelCode is filled");
	
		WebElement ActiveToggle = driver.findElement(By.xpath(activeToggle));
		Assert.assertTrue(ActiveToggle.isDisplayed(), "ActiveToggle is missing");
		log.info("ActiveToggle is visible");
		ActiveToggle.click();
		log.info("ActiveToggle is clicked");
		
		WebElement SaveButton2 = driver.findElement(By.xpath("(//a[contains(text(), 'Save')])[2]"));
		Assert.assertTrue(SaveButton2.isDisplayed(), "SaveButton is missing");
		log.info("SaveButton is visible");
		SaveButton2.click();
		log.info("SaveButton is clicked");
		Thread.sleep(15000);
		
		List<WebElement> TaxcodeList = driver.findElements(By.xpath(taxcodelist));
		int Count2 = TaxcodeList.size();
		System.out.println(Count2);
		for(int i = 1 ; i<=Count2 ; i++)
		{
			System.out.println(i);
			WebElement NewTaxcode = driver.findElement(By.xpath("("+taxcodelist+")["+i+"]"));
			System.out.println(i+ " = " +NewTaxcode.getText());
			if(NewTaxcode.getText().contains(STC))
			{
				System.out.println(i);
				Assert.assertTrue(NewTaxcode.isDisplayed(), "NewTaxCode is missing");
				log.info("NewTaxCode is visible");
				NewTaxcode.click();
				log.info("NewTaxCode is clicked");
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("("+assignTaxRateButton+")["+i+"]")));
				Thread.sleep(2000);
				WebElement AssignTaxRateButton = driver.findElement(By.xpath("("+assignTaxRateButton+")["+i+"]"));
				Assert.assertTrue(AssignTaxRateButton.isDisplayed(), "AssignTaxRateButton is missing");
				log.info("AssignTaxRateButton is visible");
				AssignTaxRateButton.click();
				log.info("AssignTaxRateButton is clicked");
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Assign tax rates')]")));
				Thread.sleep(12000);
				
				int C = driver.findElements(By.xpath(assignedRate)).size();
				System.out.println(C);
				for(int j = 1; j<=C ; j++)
				{
					WebElement AssignedRate = driver.findElement(By.xpath("("+assignedRate+")["+j+"]"));
					System.out.println(j+ " = " + AssignedRate.getText());
					if(AssignedRate.getText().contains("Sellingtaxrate_"+num))
					{
						
						WebElement AssignedrateCheckbox = driver.findElement(By.xpath("("+assignedrateCheckbox+")["+j+"]"));
						Assert.assertTrue(AssignedrateCheckbox.isDisplayed(), "AssignedrateCheckbox is missing");
						JavascriptExecutor ex1 = (JavascriptExecutor) driver;
						ex1.executeScript("arguments[0].click();", AssignedRate);
						log.info("AssignedrateCheckbox is selected");
						Thread.sleep(5000);
						driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
						log.info("Update button is clicked");
						Thread.sleep(20000);
						break;
					}
				}				
				
				WebElement RateInclude = driver.findElement(By.xpath("("+rateinclude+")["+i+"]"));
				Assert.assertTrue(RateInclude.getText().contains("Sellingtaxrate_"+num), "RateInclude is missing");
				log.info("Tax rate has been successfully assigned");
				Thread.sleep(5000);
				break;
			}
		}
		
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(addnew)));
		WebElement Addnew = driver.findElement(By.xpath(addnew));
		Assert.assertTrue(Addnew.isDisplayed(), "Button is missing");
		log.info("Addnew button is displayed");
		Addnew.click();
		Assert.assertTrue(Addnew.isEnabled(), "Button is not clicked");
		log.info("Addnew button is clicked");
		
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(part)));
		WebElement Part = driver.findElement(By.xpath(part));
		Assert.assertTrue(Part.isDisplayed(), "Button is missing");
		log.info("Part button is displayed");
		Part.click();
		Assert.assertTrue(Part.isEnabled(), "Button is not clicked");
		log.info("Part button is clicked");
		
		wt.until(ExpectedConditions.elementToBeClickable(By.xpath(partheader)));
        Thread.sleep(5000);
        WebElement PartHeader = driver.findElement(By.xpath(partheader));
        Assert.assertTrue(PartHeader.isDisplayed(), "Part header is missing");
        String PartHeadertext = PartHeader.getText();
		System.out.println(PartHeadertext);
		Assert.assertEquals(PartHeadertext, "New Merchandise");
		log.info("Part creation window is opened");
        
				
		WebElement ApplicableTax = driver.findElement(By.id("applicableTaxId"));	
        Select select = new Select(ApplicableTax);
        select.selectByVisibleText(STC);
		log.info("ApplicableTax is selected");
		log.info("Tax code is verified");
		
				
		WebElement PartCancelBtn = driver.findElement(By.id("partCancelBtn"));
		Assert.assertTrue(PartCancelBtn.isDisplayed(), "Part Cancel Button is missing");
		log.info("Part Cancel Button  is displayed");
		PartCancelBtn.click();
		log.info("Cancel button is clicked");
		driver.navigate().refresh();
		Thread.sleep(5000);

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(taxcodes)));
		Thread.sleep(5000);
		WebElement TaxCodes2 = driver.findElement(By.xpath(taxcodes));
		Assert.assertTrue(TaxCodes2.isDisplayed(), "TaxCodes link is missing");
		log.info("TaxCodes link is visible");
		TaxCodes2.click();
		log.info("TaxCodes link is clicked");
		
		List<WebElement> TaxcodeList3 = driver.findElements(By.xpath(taxcodelist));
		int Count3 = TaxcodeList3.size();
		System.out.println(Count3);
		for(int i = 1 ; i<=Count3 ; i++)
		{
			System.out.println(i);
			WebElement NewTaxcode = driver.findElement(By.xpath("("+taxcodelist+")["+i+"]"));
			System.out.println(i+ " = " +NewTaxcode.getText());
			if(NewTaxcode.getText().contains(STC))
			{
				System.out.println(i);
				Assert.assertTrue(NewTaxcode.isDisplayed(), "NewTaxCode is missing");
				log.info("NewTaxCode is visible");
				NewTaxcode.click();
				log.info("NewTaxCode is clicked");
				Thread.sleep(2000);

				WebElement Activetaxtoggle = driver.findElement(By.xpath("("+activetaxtoggle+")["+i+"]"));
				Activetaxtoggle.click();
				log.info("Activetaxtoggle is clicked");
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("("+taxcodesavebtn+")["+i+"]")));
				WebElement Taxcodesavebtn = driver.findElement(By.xpath("("+taxcodesavebtn+")["+i+"]"));
				Taxcodesavebtn.click();
				log.info("Tax code is deactivated");
				Thread.sleep(12000);
				
				WebElement NewTaxcode2 = driver.findElement(By.xpath("("+taxcodelist+")["+i+"]"));
				Assert.assertTrue(NewTaxcode2.isDisplayed(), "NewTaxCode is missing");
				log.info("NewTaxCode is visible");
				NewTaxcode2.click();
				log.info("NewTaxCode is clicked");
				Thread.sleep(2000);
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("("+assignTaxRateButton+")["+i+"]")));
				WebElement AssignTaxRateButton = driver.findElement(By.xpath("("+assignTaxRateButton+")["+i+"]"));
				Assert.assertTrue(AssignTaxRateButton.isDisplayed(), "AssignTaxRateButton is missing");
				log.info("AssignTaxRateButton is visible");
				AssignTaxRateButton.click();
				log.info("AssignTaxRateButton is clicked");
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Assign tax rates')]")));
				Thread.sleep(12000);
				
				int C = driver.findElements(By.xpath(assignedRate)).size();
				System.out.println(C);
				for(int j = 1; j<=C ; j++)
				{
					WebElement AssignedRate = driver.findElement(By.xpath("("+assignedRate+")["+j+"]"));
					System.out.println(j+ " = " + AssignedRate.getText());
					if(AssignedRate.getText().contains("Sellingtaxrate_"+num))
					{
						
						WebElement AssignedrateCheckbox = driver.findElement(By.xpath("("+assignedrateCheckbox+")["+j+"]"));
						Assert.assertTrue(AssignedrateCheckbox.isDisplayed(), "AssignedrateCheckbox is missing");
						JavascriptExecutor ex1 = (JavascriptExecutor) driver;
						ex1.executeScript("arguments[0].click();", AssignedRate);
						log.info("AssignedrateCheckbox is deselected");
						Thread.sleep(5000);
						driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
						log.info("Update button is clicked");
						Thread.sleep(20000);
						break;
					}
				}	
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("("+taxcodedeletebtn+")["+i+"]")));
				WebElement Taxcodedeletebtn = driver.findElement(By.xpath("("+taxcodedeletebtn+")["+i+"]"));
				Taxcodedeletebtn.click();
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Yes')]")));
				Thread.sleep(5000);
				driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
				Thread.sleep(10000);
				break;
			}
		}
		
		int Count4 = driver.findElements(By.xpath(taxcodelist)).size();
		Assert.assertNotEquals(Count3, Count4, "taxcode is not removed");
		log.info("taxcode is successfully removed");
		driver.navigate().refresh();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(taxrates)));
		Thread.sleep(15000);
		WebElement TaxRates2 = driver.findElement(By.xpath(taxrates));
		Assert.assertTrue(TaxRates2.isDisplayed(), "TaxRates link is missing");
		log.info("TaxRates link is visible");
		TaxRates2.click();
		log.info("TaxRates link is clicked");
		
		List<WebElement> TaxrateList2 = driver.findElements(By.xpath(taxratelist));
		int Count5 = TaxrateList2.size();
		System.out.println(Count5);
		for(int k = 1 ; k<=Count5 ; k++)
		{
			System.out.println(k);
			WebElement NewTaxrate = driver.findElement(By.xpath("("+taxratelist+")["+k+"]"));
			System.out.println(k+ " = " +NewTaxrate.getText());
			if(NewTaxrate.getText().contains(STR))
			{
				WebElement EditTaxrate = driver.findElement(By.xpath("("+editTaxrate+")["+k+"]"));
				Assert.assertTrue(EditTaxrate.isDisplayed(), "EditTaxrate link is missing");
				log.info("EditTaxrate link is visible");
				EditTaxrate.click();
				log.info("EditTaxrate link is clicked");
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Edit selling tax rate')]")));
				Thread.sleep(5000);
				WebElement Editsavetaxrates = driver.findElement(By.xpath(editsavetaxrates));
				Assert.assertTrue(Editsavetaxrates.isDisplayed(), "Editsavetaxrates link is missing");
				log.info("Editsavetaxrates link is visible");
				Editsavetaxrates.click();
				log.info("Editsavetaxrates link is clicked");
				Thread.sleep(8000);
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("("+deletetaxrate+")["+k+"]")));
				WebElement Deletetaxrate = driver.findElement(By.xpath("("+deletetaxrate+")["+k+"]"));
				Assert.assertTrue(Deletetaxrate.isDisplayed(), "Deletetaxrate link is missing");
				log.info("Deletetaxrate link is visible");
				Deletetaxrate.click();
				log.info("Deletetaxrate link is clicked");
				
				wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Yes')]")));
				Thread.sleep(5000);
				driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
				Thread.sleep(10000);
				break;
			}
		}
		
		int Count6 = driver.findElements(By.xpath(taxratelist)).size();
		Assert.assertNotEquals(Count5, Count6, "taxrate is not removed");
		log.info("taxrate is successfully removed");

	}
	
	@Test(priority = 64)
	public static void Textmessagetemplates() throws Exception
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
			if(Tile.getText().contains("Text message templates"))
			{
				Tile.click();
				log.info("Text message templates link is clicked");
				break;
			}
	
		//*[@id="BP_Home_mainContainer"]/div[1]/div[1]/div[1]/div/div/h1
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(templetHeader)));
		WebElement TempletHeader = driver.findElement(By.xpath(templetHeader));
		Assert.assertTrue(TempletHeader.isDisplayed(), "TempletHeader link is missing");
		log.info("TempletHeader link is visible");
		TempletHeader.click();
		log.info("TempletHeader link is clicked");
		Thread.sleep(21000);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(plusicon)));
		WebElement PlusIcon = driver.findElement(By.xpath(plusicon));
		Assert.assertTrue(PlusIcon.isDisplayed(), "PlusIcon link is missing");
		log.info("PlusIcon link is visible");
		PlusIcon.click();
		log.info("PlusIcon link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'New text template')]")));
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder = 'Template name']")));
		WebElement TempletName = driver.findElement(By.xpath("//input[@placeholder = 'Template name']"));
		Assert.assertTrue(TempletName.isDisplayed(), "TempletName is missing");
		log.info("TempletName is visible");
		TempletName.sendKeys("Automated Template");
		log.info("TempletName is filled");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Type your message here']")));
		WebElement TemplateMsg = driver.findElement(By.xpath("//*[@placeholder='Type your message here']"));
		Assert.assertTrue(TemplateMsg.isDisplayed(), "TemplateMsg is missing");	
		log.info("TemplateMsg is visible");
		TemplateMsg.sendKeys(templateMsg);
		log.info("TemplateMsg is filled");
		
		
		WebElement Savebutton = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
		Assert.assertTrue(Savebutton.isDisplayed(), "Savebutton is missing");
		log.info("Savebutton is visible");
		Savebutton.click();
		log.info("Savebutton is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Automated Template')]")));
		log.info("New template is successfully created");
		
		
		WebElement Searchbox = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		Searchbox.sendKeys(defaultUser);
		log.info("email is entered in seachbox");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyemail)));
		
		WebElement Verifyemail = driver.findElement(By.xpath(verifyemail));
		Assert.assertTrue(Verifyemail.isDisplayed(), "No relevent data appeared");
		Verifyemail.click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'send a text')]")));
		log.info("Customer's profile is opened");
		WebElement SendAText = driver.findElement(By.xpath("//button[contains(text(),'send a text')]"));
		Assert.assertTrue(SendAText.isDisplayed(), "SendAText button is missing");
		SendAText.click();
		log.info("SendAText button is clicked");
		

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Send a text to customer')]")));
		Thread.sleep(5000);
		
		
		WebElement SmsTemplate = driver.findElement(By.id("smsTemplate"));
		Assert.assertTrue(SmsTemplate.isDisplayed(), "SendAText button is missing");
		SmsTemplate.click();
		log.info("SendAText button is clicked");
		
		List<WebElement> TemplateList = driver.findElements(By.xpath(templateList));
		Iterator<WebElement> it = TemplateList.iterator();
		while(it.hasNext())
		{
			WebElement Template = it.next();
			if(Template.getText().contains("Automated"))
			{
				Assert.assertTrue(Template.isDisplayed(), "Template is missing");
				log.info("The template is visible");
				Template.click();
				log.info("The template is verified");
				break;
			}
		}
		
		driver.navigate().back();
		Thread.sleep(10000);
		int Count1 = driver.findElements(By.xpath(templatename)).size();
		for(int i = 1 ; i <= Count1 ; i++)
		{
			WebElement Templatename = driver.findElement(By.xpath("("+templatename+")["+i+"]"));
			if(Templatename.getText().contains("Automated"))
			{
				WebElement DeleteTemplate = driver.findElement(By.xpath("("+deleteTemplate+")["+i+"]"));
				Assert.assertTrue(DeleteTemplate.isDisplayed(), "DeleteTemplate is missing");
				log.info("DeleteTemplate button is visible");
				DeleteTemplate.click();
				log.info("DeleteTemplate button is clicked");
				Thread.sleep(5000);
				break;				
			}
		}
		int Count2 = driver.findElements(By.xpath(templatename)).size();
		Assert.assertNotEquals(Count1, Count2, "The template is not removed");
		log.info("Template is removed successfully");
	
	}

	@Test(priority = 65)
	public static void Unitpricingandoptions() throws Exception
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
			if(Tile.getText().contains("Unit pricing and options"))
			{
				Tile.click();
				log.info("Unit pricing and options link is clicked");
				break;
			}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitpricingheader)));
		WebElement Unitpricingheader = driver.findElement(By.xpath(unitpricingheader));
		Assert.assertTrue(Unitpricingheader.isDisplayed(), "Unitpricingheader link is missing");
		log.info("Unitpricingheader link is " +Unitpricingheader.getText());
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Auto_Make')]")));
		Thread.sleep(5000);
		WebElement Auto_Make = driver.findElement(By.xpath("//div[contains(text(),'Auto_Make')]"));
		Assert.assertTrue(Auto_Make.isDisplayed(), "Auto_Make link is missing");
		log.info("Auto_Make link is visible");
		Auto_Make.click();
		log.info("Auto_Make link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(makeheader)));
		WebElement Makeheader = driver.findElement(By.xpath(makeheader));
		Assert.assertTrue(Makeheader.isDisplayed(), "Makeheader link is missing");
		log.info("Makeheader link is " +Makeheader.getText());
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Code'])[1]")));
		Thread.sleep(5000);
		WebElement Codefield = driver.findElement(By.xpath("(//input[@placeholder='Code'])[1]"));
		Assert.assertTrue(Codefield.isDisplayed(), "Codefield is missing");
		log.info("Codefield is visible");
		Codefield.sendKeys(random.nextInt(10000)+"");
		log.info("Codefield is filled");
		
		
		WebElement Descriptionfield = driver.findElement(By.xpath("(//input[@placeholder='Description'])[1]"));
		Assert.assertTrue(Descriptionfield.isDisplayed(), "Descriptionfield is missing");
		log.info("Descriptionfield is visible");
		Descriptionfield.sendKeys(random.nextInt(10000)+"");
		log.info("Descriptionfield is filled");
		
		
		WebElement Auto_Model = driver.findElement(By.xpath("//div[contains(text(),'Auto_Model')]"));
		Assert.assertTrue(Auto_Model.isDisplayed(), "Auto_Model is missing");
		log.info("Auto_Model is visible");
		Auto_Model.click();
		log.info("Auto_Model is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Auto_SubModel')]")));
		Thread.sleep(5000);
		WebElement Auto_SubModel = driver.findElement(By.xpath("//a[contains(text(),'Auto_SubModel')]"));
		Assert.assertTrue(Auto_SubModel.isDisplayed(), "Auto_SubModel is missing");
		log.info("Auto_SubModel is visible");
		Auto_SubModel.click();
		log.info("Auto_SubModel is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("Price_1")));
		Thread.sleep(5000);
		WebElement Baseunitprice = driver.findElement(By.id("Price_1"));
		Assert.assertTrue(Baseunitprice.isDisplayed(), "Baseunitprice is missing");
		log.info("Baseunitprice is visible");
		Baseunitprice.sendKeys(Keys.chord(Keys.CONTROL, "a"), "300");
		log.info("Baseunitprice is filled");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("UnitCost_1")));
		WebElement CostPrice = driver.findElement(By.id("UnitCost_1"));
		Assert.assertTrue(CostPrice.isDisplayed(), "CostPrice is missing");
		log.info("CostPrice is visible");
		CostPrice.sendKeys(Keys.chord(Keys.CONTROL, "a"), "200");
		log.info("CostPrice is filled");
		
		
		WebElement Auto_SubModel2 = driver.findElement(By.xpath("//a[contains(text(),'Auto_SubModel')]"));
		Assert.assertTrue(Auto_SubModel2.isDisplayed(), "Auto_SubModel is missing");
		log.info("Auto_SubModel is visible");
		Auto_SubModel2.click();
		log.info("Auto_SubModel is clicked");
		
		
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
		int num = random.nextInt(10000);
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

		JavascriptExecutor ex2 = (JavascriptExecutor) driver;
		ex2.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(5000);
		
		WebElement AddPricing  = driver.findElement(By.xpath(addPricing));
		Assert.assertTrue(AddPricing.isDisplayed(), "AddPricing button is missing");
		log.info("AddPricing button is visible");
		AddPricing.click();
		log.info("AddPricing button is clicked");
		Thread.sleep(10000);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td")));

		
		WebElement TotalPrice  = driver.findElement(By.xpath("//td/span[contains(text(),'300')]"));
		Assert.assertTrue(TotalPrice.getText().contains("300"), "TotalPrice is missing");
		log.info("TotalPrice is successfully verified");
		
		WebElement TotalCost  = driver.findElement(By.xpath("//td/span[contains(text(),'200')]"));
		Assert.assertTrue(TotalCost.getText().contains("200"), "TotalCost is missing");
		log.info("TotalCost is successfully verified");
				
		
	}

	@Test(priority = 66)
	public static void Userpermissions() throws Exception
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
			if(Tile.getText().contains("User permissions"))
			{
				Tile.click();
				log.info("User permissions link is clicked");
				break;
			}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userpermissionheader)));
		WebElement Userpermissionheader = driver.findElement(By.xpath(userpermissionheader));
		Assert.assertTrue(Userpermissionheader.isDisplayed(), "Userpermissionheader is missing");
		log.info("Userpermissionheader is " +Userpermissionheader);

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Create new group')]")));
		Thread.sleep(5000);
		WebElement CreateButton = driver.findElement(By.xpath("//button[contains(text(),'Create new group')]"));
		Assert.assertTrue(CreateButton.isDisplayed(), "CreateButton is missing");
		log.info("CreateButton is visible");
		CreateButton.click();
		log.info("CreateButton is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("GroupNameInput")));
		Thread.sleep(5000);
		WebElement GroupNameInput = driver.findElement(By.id("GroupNameInput"));
		Assert.assertTrue(GroupNameInput.isDisplayed(), "GroupNameInput is missing");
		log.info("GroupNameInput is visible");
		GroupNameInput.sendKeys("Automation group");
		log.info("GroupName is entered");
		
		
		WebElement Assigncolor = driver.findElement(By.xpath(assigncolor));
		Assert.assertTrue(Assigncolor.isDisplayed(), "Assigncolor is missing");
		log.info("Assigncolor is visible");
		Assigncolor.click();
		log.info("Color is assigned");
		
		WebElement CreateButton2 = driver.findElement(By.xpath("(//button[contains(text(), 'Create')])[2]"));
		Assert.assertTrue(CreateButton2.isDisplayed(), "CreateButton is missing");
		log.info("CreateButton is visible");
		CreateButton2.click();
		log.info("group is created");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(newgroupname)));
		Thread.sleep(5000);
		WebElement Newgroupname = driver.findElement(By.xpath(newgroupname));
		Assert.assertTrue(Newgroupname.getText().contains("Automation group"), "Newgroupname is missing");
		log.info("Newgroupname is "+Newgroupname.getText());
		log.info("Newgroupname is veriied");
		
		
		WebElement MembersLink = driver.findElement(By.xpath("//a[contains(text(),'Members')]"));
		Assert.assertTrue(MembersLink.isDisplayed(), "MembersLink is missing");
		log.info("MembersLink is visible");
		MembersLink.click();
		log.info("MembersLink is veriied");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(text(),'Assign members')]")));
		Thread.sleep(5000);
		WebElement AssignMembers = driver.findElement(By.xpath("//button[contains(text(),'Assign members')]"));
		Assert.assertTrue(AssignMembers.isDisplayed(), "AssignMembers button is missing");
		log.info("AssignMembers button is visible");
		AssignMembers.click();
		log.info("AssignMembers button is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'Assign users to')]")));
		Thread.sleep(5000);
		WebElement SearchUserField = driver.findElement(By.xpath("//input[@placeholder = 'Search users']"));
		Assert.assertTrue(SearchUserField.isDisplayed(), "SearchUserField is missing");
		log.info("SearchUserField is visible");
		SearchUserField.sendKeys(adminUser);

		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userslist))).click();
		driver.findElement(By.xpath("//button[contains(text(),'Assign to')]")).click();
		log.info("Assign button is clicked");
		Thread.sleep(5000);
		
		//div[contains(text(),"+adminUser+")]
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),"+"'"+adminUser+"'"+")]")));
		log.info("User is assigned to group");
		
		Logout();
		
		WebElement Username = driver.findElement(By.id("username"));
		Assert.assertTrue(Username.isDisplayed(), "Username field is missing");
		log.info("Username field is visible");
		Username.sendKeys(adminusername);
		
		WebElement Password = driver.findElement(By.id("password"));
		Assert.assertTrue(Password.isDisplayed(), "Password field is missing");
		log.info("Password field is visible");
		Password.sendKeys(adminpassword);
		Password.sendKeys(Keys.RETURN);
		Thread.sleep(15000);

		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(),'Schedule')]")));
		Thread.sleep(5000);
		WebElement DisableScheduleLink = driver.findElement(By.xpath("(//a[@class='disabld-nav-bar-action'])[contains(text(),'Schedule')]"));
		Assert.assertTrue(DisableScheduleLink.isDisplayed(), "Disable Schedule Link is missing");
		log.info("Schedule Link is not clickable");
		
		Logout();
		
		WebElement Username2 = driver.findElement(By.id("username"));
		Assert.assertTrue(Username2.isDisplayed(), "Username field is missing");
		log.info("Username field is visible");
		Username2.sendKeys(username);
		
		WebElement Password2 = driver.findElement(By.id("password"));
		Assert.assertTrue(Password2.isDisplayed(), "Password field is missing");
		log.info("Password field is visible");
		Password2.sendKeys(password);
		Password2.sendKeys(Keys.RETURN);
		Thread.sleep(15000);
		
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
			if(Tile.getText().contains("User permissions"))
			{
				Tile.click();
				log.info("User permissions link is clicked");
				break;
			}

		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstgroup)));
		Thread.sleep(5000);
		WebElement Firstgroup = driver.findElement(By.xpath(firstgroup));
		Assert.assertTrue(Firstgroup.isDisplayed(), "Firstgroup is missing");
		log.info("Firstgroupn is visible");
		Firstgroup.click();
		log.info("Firstgroup is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'View')]")));
		WebElement ViewAndEdit = driver.findElement(By.xpath("//button[contains(text(), 'View')]"));
		Assert.assertTrue(ViewAndEdit.isDisplayed(), "ViewAndEdit button is missing");
		log.info("ViewAndEdit button is visible");
		ViewAndEdit.click();
		log.info("ViewAndEdit button is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Members')]")));
		WebElement Members = driver.findElement(By.xpath("//a[contains(text(),'Members')]"));
		Assert.assertTrue(Members.isDisplayed(), "Members button is missing");
		log.info("Members button is visible");
		Members.click();
		log.info("Members button is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(plusicon2)));
		WebElement PlusIcon = driver.findElement(By.xpath(plusicon2));
		Assert.assertTrue(PlusIcon.isDisplayed(), "PlusIcon is missing");
		log.info("PlusIcon is visible");
		PlusIcon.click();
		log.info("PlusIcon is clicked");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'Assign users to')]")));
		Thread.sleep(5000);
		WebElement SearchUserField2 = driver.findElement(By.xpath("//input[@placeholder = 'Search users']"));
		Assert.assertTrue(SearchUserField2.isDisplayed(), "SearchUserField is missing");
		log.info("SearchUserField is visible");
		SearchUserField2.sendKeys(adminUser);

		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(userslist))).click();
		driver.findElement(By.xpath("//button[contains(text(),'Assign to')]")).click();
		log.info("Assign button is clicked");
		Thread.sleep(5000);
		
		//div[contains(text(),"+adminUser+")]
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),"+"'"+adminUser+"'"+")]")));
		log.info("User is assigned to group");
		
		
		WebElement BackLink = driver.findElement(By.xpath("//a[contains(text(),'Back')]"));
		Assert.assertTrue(BackLink.isDisplayed(), "BackLink is missing");
		log.info("BackLink is visible");
		BackLink.click();
		log.info("BackLink is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sorticon)));
		Thread.sleep(5000);
		WebElement SortIcon = driver.findElement(By.xpath(sorticon));
		Assert.assertTrue(SortIcon.isDisplayed(), "SortIcon is missing");
		log.info("SortIcon is visible");
		SortIcon.click();
		log.info("SortIcon is clicked");
		
		WebElement Firstgroup2 = driver.findElement(By.xpath(firstgroup));
		Assert.assertTrue(Firstgroup2.isDisplayed(), "Firstgroup is missing");
		log.info("Firstgroup is visible");
		Firstgroup2.click();
		log.info("Firstgroup is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(deleteicon)));
		Thread.sleep(5000);
		WebElement Deleteicon = driver.findElement(By.xpath(deleteicon));
		Assert.assertTrue(Deleteicon.isDisplayed(), "Deleteicon is missing");
		log.info("Deleteicon is visible");
		Deleteicon.click();
		log.info("Deleteicon is clicked");
		
		
	}
	
	

}
