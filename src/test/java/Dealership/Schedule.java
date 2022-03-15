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
import org.openqa.selenium.interactions.Action;
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


public class Schedule extends POM {
	
	@Test(priority = 43)
	public static void CreateEditDeleteAppointment() throws Exception
	
	{		
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(schedule)));
		WebElement Schedule = driver.findElement(By.xpath(schedule));
		Assert.assertTrue(Schedule.isDisplayed(), "Schedule link is missing");
		log.info("Schedule link is visible");
		Schedule.click();
		log.info("Schedule link is clicked");
		
		CreateAppointment();
		EditAppointment();
		DeleteAppointment();
		
	}
	
	@Test(priority = 44)
	public static void CreateandView() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(schedule)));
		WebElement Schedule = driver.findElement(By.xpath(schedule));
		Assert.assertTrue(Schedule.isDisplayed(), "Schedule link is missing");
		log.info("Schedule link is visible");
		Schedule.click();
		log.info("Schedule link is clicked");
		
		CreateAppointment();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Day view')]")));
		Thread.sleep(10000);
		WebElement DayViewLink = driver.findElement(By.xpath("//a[contains(text(),'Day view')]"));
		Assert.assertTrue(DayViewLink.isDisplayed(), "DayViewLink is missing");
		log.info("DayViewLink is visible");
		DayViewLink.click();
		log.info("DayViewLink is opened");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td/div")));
		Thread.sleep(5000);
		
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
				log.info("The Appointment Name is " +AppointmentName.getText());
				break;
			}
		}
		
		log.info("Appointment is verified in 'Day View' mode");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Week view')]")));
		Thread.sleep(5000);
		JavascriptExecutor ex1 = (JavascriptExecutor) driver;
		ex1.executeScript("window.scrollBy(0, -600)", "");
		WebElement WeekViewLink = driver.findElement(By.xpath("//a[contains(text(),'Week view')]"));
		Assert.assertTrue(WeekViewLink.isDisplayed(), "WeekViewLink is missing");
		log.info("WeekViewLink is visible");
		WeekViewLink.click();
		log.info("WeekViewLink is opened");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appointmenttable2)));
		Thread.sleep(5000);
		String Todaysdate = new SimpleDateFormat("d").format(new Date());
		int TodaysDateInt = Integer.parseInt(Todaysdate);
		
		for(int i = 3 ; i <= 7 ; i++)
		{
			String Appointmentdate = driver.findElement(By.xpath("//*[@id=\"j_id0:j_id2\"]/div/div[1]/div["+i+"]/div[1]/span")).getText();
			int AppointmentdateInt = Integer.parseInt(Appointmentdate);
						
			if(AppointmentdateInt == (TodaysDateInt))
			{
				WebElement AppoitnmentCount = driver.findElement(By.xpath("//*[@id=\"j_id0:j_id2\"]/div/div[1]/div["+i+"]/div[2]/div[1]/div[2]/span"));
				Assert.assertTrue(AppoitnmentCount.isDisplayed(), "AppoitnmentCount is missing");
				log.info("AppoitnmentCount is visible");
				Assert.assertTrue(AppoitnmentCount.getText().contains("1 appointment"), "AppoitnmentCount is incorrect");			
				log.info("AppoitnmentCount is correct");	
				Thread.sleep(5000);
				break;
			}	
		}
		
		log.info("Appointment is verified in 'Week View' mode");
		
		//tr[2]/td[2]/span

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Month view')]")));
		Thread.sleep(10000);
		WebElement MonthViewLink = driver.findElement(By.xpath("//a[contains(text(),'Month view')]"));
		Assert.assertTrue(MonthViewLink.isDisplayed(), "MonthViewLink is missing");
		log.info("MonthViewLink is visible");
		MonthViewLink.click();
		log.info("MonthViewLink is opened");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[2]/td[2]/span")));
		Thread.sleep(5000);
				
		List<WebElement> AllAppointmentsMonthly = driver.findElements(By.xpath("//tr[2]/td[2]/span"));
//		Iterator<WebElement> it = AllAppointments.iterator();
		for(WebElement MyAppoitnment : AllAppointmentsMonthly )
		{
			Actions action = new Actions(driver);
			action.moveToElement(MyAppoitnment).build().perform();
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appointmentName)));
			WebElement AppointmentName = driver.findElement(By.xpath(appointmentName));
			if(AppointmentName.getText().contains("Appointment -")) 
			{
				log.info("The Appointment Name is " +AppointmentName.getText());
				log.info("Appointment is verified in 'Month View' mode");	
				MyAppoitnment.click();
				Thread.sleep(10000);				
				break;
			}
		}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("estimatedHoursInputId")));
		WebElement EstimatedHours = driver.findElement(By.id("estimatedHoursInputId"));
		Assert.assertTrue(EstimatedHours.isDisplayed(), "EstimatedHours is missing");
		log.info("EstimatedHours is visible");	
		EstimatedHours.sendKeys(Keys.TAB);
		
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

	}

	@Test(priority = 45)
	public static void MoveAppointment() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(schedule)));
		WebElement Schedule = driver.findElement(By.xpath(schedule));
		Assert.assertTrue(Schedule.isDisplayed(), "Schedule link is missing");
		log.info("Schedule link is visible");
		Schedule.click();
		log.info("Schedule link is clicked");
		
		CreateAppointment();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Day view')]")));
		Thread.sleep(10000);
		WebElement DayViewLink = driver.findElement(By.xpath("//a[contains(text(),'Day view')]"));
		Assert.assertTrue(DayViewLink.isDisplayed(), "DayViewLink is missing");
		log.info("DayViewLink is visible");
		DayViewLink.click();
		log.info("DayViewLink is opened");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td/div")));
		Thread.sleep(5000);
		
		List<WebElement> AllAppointments = driver.findElements(By.xpath("//tr/td/div"));
		for(WebElement MyAppoitnment : AllAppointments )
		{
			Actions action = new Actions(driver);
			action.moveToElement(MyAppoitnment).build().perform();
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appointmentName)));
			WebElement AppointmentName = driver.findElement(By.xpath(appointmentName));
			if(AppointmentName.getText().contains("Appointment -")) 
			{
				log.info("The Appointment Name is " +AppointmentName.getText());
				WebElement AppointmentTime = driver.findElement(By.xpath(appointmentTime));
				log.info("Appointment " +AppointmentTime.getText());
				WebElement MoveTo = driver.findElement(By.xpath(moveto));
				action.dragAndDrop(MyAppoitnment, MoveTo).perform();
				Thread.sleep(10000);
				log.info("Appointment's new time " +AppointmentTime.getText());
				Thread.sleep(10000);
				log.info("Appointment is successfully moved");
				break;
			}				
		}
		
		
		driver.navigate().refresh();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Day view')]")));
		Thread.sleep(10000);
		WebElement DayViewLink2 = driver.findElement(By.xpath("//a[contains(text(),'Day view')]"));
		Assert.assertTrue(DayViewLink2.isDisplayed(), "DayViewLink is missing");
		log.info("DayViewLink is visible");
		DayViewLink2.click();
		log.info("DayViewLink is opened");
		
		DeleteAppointment();	
		

	}
	
	@Test(priority = 46)
	public static void UnassignedAppointment() throws Exception
	{
		
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(schedule)));
		WebElement Schedule = driver.findElement(By.xpath(schedule));
		Assert.assertTrue(Schedule.isDisplayed(), "Schedule link is missing");
		log.info("Schedule link is visible");
		Schedule.click();
		log.info("Schedule link is clicked");
	
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Day view')]")));
		Thread.sleep(10000);
		WebElement DayViewLink = driver.findElement(By.xpath("//a[contains(text(),'Day view')]"));
		Assert.assertTrue(DayViewLink.isDisplayed(), "DayViewLink is missing");
		log.info("DayViewLink is visible");
		DayViewLink.click();
		log.info("DayViewLink is opened");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(allTech)));
		Thread.sleep(10000);
		
		WebElement UAarrow = driver.findElement(By.xpath(uaarrow));
		Assert.assertTrue(UAarrow.isDisplayed(), "Un-assigned Appointments link is missing");
		log.info("Un-assigned Appointments link is visible");
		UAarrow.click();
		log.info("Un-assigned Appointments are opened");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(apSearchfield)));
		Thread.sleep(5000);
		WebElement APSearchfield = driver.findElement(By.xpath(apSearchfield));
		Assert.assertTrue(APSearchfield.isDisplayed(), "APSearchfield is missing");
		log.info("APSearchfield is visible");
		APSearchfield.sendKeys("test");
		log.info("APSearchfield is filled");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(testAppointment)));
		WebElement TestAppointment = driver.findElement(By.xpath(testAppointment));
		Assert.assertTrue(TestAppointment.isDisplayed(), "TestAppointment is missing");
		log.info("TestAppointment is visible");
		
		Actions act1 = new Actions(driver);
		act1.moveToElement(TestAppointment).build().perform();
		WebElement TestAptinfo = driver.findElement(By.xpath(appointmentinfo));
		String TestAptName = TestAptinfo.getText();
		
		WebElement MoveTo = driver.findElement(By.xpath(moveto));
		Actions action1 = new Actions(driver);
		action1.dragAndDrop(TestAppointment, MoveTo).perform();
		log.info("TestAppointment is assigned to a Technician");
		Thread.sleep(10000);
		
		driver.navigate().refresh();
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Day view')]")));
		Thread.sleep(10000);
		WebElement DayViewLink2 = driver.findElement(By.xpath("//a[contains(text(),'Day view')]"));
		Assert.assertTrue(DayViewLink2.isDisplayed(), "DayViewLink is missing");
		log.info("DayViewLink is visible");
		DayViewLink2.click();
		log.info("DayViewLink is opened");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td/div")));
		Thread.sleep(5000);
		
		List<WebElement> AllAppointments = driver.findElements(By.xpath("//tr/td/div"));
		int NumberofAppointmentBefore = driver.findElements(By.xpath("//tr/td/div")).size();
		log.info(NumberofAppointmentBefore+" appointments are present");
		for(WebElement MyAppoitnment : AllAppointments )
		{
			Actions action = new Actions(driver);
			action.moveToElement(MyAppoitnment).build().perform();
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appointmentName)));
			WebElement AppointmentNane = driver.findElement(By.xpath(appointmentName));
			if(AppointmentNane.getText().contains(TestAptName)) 
			{
				MyAppoitnment.click();
				log.info("Appointment is clicked");
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

	@Test(priority = 47)
	public static void ServiceJobAppointment() throws Exception 
	{
		WebDriverWait wt = new WebDriverWait(driver, 100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sell)));
		WebElement Sell = driver.findElement(By.xpath(sell));
		Assert.assertTrue(Sell.isDisplayed(), "Sell link is missing");
		log.info("Sell link is visible");
		Sell.click();
		log.info("Sell link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selectcustomerdropdown)));
		WebElement SelectCustomerDropdown = driver.findElement(By.xpath(selectcustomerdropdown));
		Assert.assertTrue(SelectCustomerDropdown.isDisplayed(), "Select Customer Dropdown is missing");
		log.info("Select Customer Dropdown is visible");
		SelectCustomerDropdown.click();
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocompleteCustomer")));
		WebElement SelectCustomerField = driver.findElement(By.id("autocompleteCustomer"));
		Assert.assertTrue(SelectCustomerField.isDisplayed(), "Select Customer Field is missing");
		log.info("Select Customer Field is visible");
		SelectCustomerField.sendKeys(appointmentCustomer);
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("customerInfo_0")));
		WebElement CustomerInfo = driver.findElement(By.id("customerInfo_0"));
		Assert.assertTrue(CustomerInfo.isDisplayed(), "CustomerInfo is missing");
		log.info("CustomerInfo is visible");
		CustomerInfo.click();
//		Thread.sleep(10000);

		if(wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(activeorders))).isDisplayed()) 
		{
			Thread.sleep(10000);
			driver.findElement(By.xpath(activeorderbutton)).click();
			Thread.sleep(10000);
		}

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(servicejob)));
		Thread.sleep(5000);
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
			
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'CO-')]")));
		WebElement CONumber = driver.findElement(By.xpath("//h2[contains(text(),'CO-')]"));
		Assert.assertTrue(CONumber.isDisplayed(), "CONumber is missing");
		log.info("CONumber is visible");
		String CONumbertext = CONumber.getText();
		log.info("CONumber is " +CONumbertext);
		
		WebElement ServiceJobDetails = driver.findElement(By.xpath(servicejobdetails));
		wt.until(ExpectedConditions.visibilityOf(ServiceJobDetails));
		Assert.assertTrue(ServiceJobDetails.isDisplayed(), "ServiceJobDetails is missing");
		log.info("ServiceJobDetails is visible");
		ServiceJobDetails.click();
		log.info("ServiceJobDetails is clicked");
		Thread.sleep(5000);
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropDownInputId")));
		WebElement UnitDropDown = driver.findElement(By.id("dropDownInputId"));
		Assert.assertTrue(UnitDropDown.isDisplayed(), "UnitDropDown is missing");
		log.info("UnitDropDown is visible");
		UnitDropDown.click();
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropDownresult)));
		WebElement DropDownresult = driver.findElement(By.xpath(dropDownresult));
		Assert.assertTrue(DropDownresult.isDisplayed(), "DropDownresult is missing");
		log.info("DropDownresult is visible");
		DropDownresult.click();
		log.info("Unit is Selected");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(createApt)));
		WebElement CreateApt = driver.findElement(By.xpath(createApt));
		Assert.assertTrue(CreateApt.isDisplayed(), "CreateApt link is missing");
		log.info("CreateApt link is visible");
		CreateApt.click();
		log.info("CreateApt link is clicked");
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),"+"'"+CONumbertext+"'"+")]")));
		Thread.sleep(5000);
		
		
		WebElement AppointmentTitleId = driver.findElement(By.id("appointmentTitleId"));
		Assert.assertTrue(AppointmentTitleId.isDisplayed(), "AppointmentTitleId is missing");
		log.info("AppointmentTitleId is visible");
		AppointmentTitleId.sendKeys(Keys.chord(Keys.CONTROL,"a"), "New Appointment");
		log.info("EstimatedHours is filled");	
		AppointmentTitleId.sendKeys(Keys.TAB);
		
		WebElement EstimatedHours = driver.findElement(By.id("estimatedHoursInputId"));
		Assert.assertTrue(EstimatedHours.isDisplayed(), "EstimatedHours is missing");
		log.info("EstimatedHours is visible");
		EstimatedHours.sendKeys(Keys.chord(Keys.CONTROL,"a"), "1");
		log.info("EstimatedHours is filled");	
		EstimatedHours.sendKeys(Keys.TAB);
		
		
		
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
		Thread.sleep(5000);
		
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
				Thread.sleep(5000);
				break;
			}
			
		}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(), 'Confirm')])[5]")));
		Thread.sleep(5000);
		WebElement ConfirmButton = driver.findElement(By.xpath("(//button[contains(text(), 'Confirm')])[5]"));
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
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td/div/a)[4]")));
		Thread.sleep(5000);
		WebElement SaveAppointmentButton = driver.findElement(By.xpath("//button[contains(text(),'Save Appointment')]"));
		Assert.assertTrue(SaveAppointmentButton.isDisplayed(), "SaveAppointmentButton is missing");
		log.info("SaveAppointmentButton is visible");
		SaveAppointmentButton.click();
		log.info("SaveAppointmentButton is Clicked");
		Thread.sleep(5000);
		log.info("Appointment is Created successfully");	
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(aptonCO)));
		WebElement AptonCO = driver.findElement(By.xpath(aptonCO));
		Assert.assertTrue(AptonCO.isDisplayed(), "AptonCO is missing");
		log.info("AptonCO is visible");
		log.info("Appointment is created for " +AptonCO.getText());
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(schedule)));
		WebElement Schedule = driver.findElement(By.xpath(schedule));
		Assert.assertTrue(Schedule.isDisplayed(), "Schedule link is missing");
		log.info("Schedule link is visible");
		Schedule.click();
		log.info("Schedule link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Day view')]")));
		Thread.sleep(10000);
		WebElement DayViewLink = driver.findElement(By.xpath("//a[contains(text(),'Day view')]"));
		Assert.assertTrue(DayViewLink.isDisplayed(), "DayViewLink is missing");
		log.info("DayViewLink is visible");
		DayViewLink.click();
		log.info("DayViewLink is opened");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td/div")));
		Thread.sleep(5000);
		
		List<WebElement> AllAppointments = driver.findElements(By.xpath("//tr/td/div"));
//		Iterator<WebElement> it = AllAppointments.iterator();
		for(WebElement MyAppoitnment : AllAppointments )
		{
			
			Actions action = new Actions(driver);
			action.moveToElement(MyAppoitnment).build().perform();
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appointmentCONumber)));
			WebElement AppointmentCONumber = driver.findElement(By.xpath(appointmentCONumber));
			if(AppointmentCONumber.getText().contains(CONumbertext)) 
				
			{
				log.info("The Appointment's CONumber Name is " +AppointmentCONumber.getText());
				log.info("Appointment is verified");
				MyAppoitnment.click();
				Thread.sleep(10000);
				break;
			}
		}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("estimatedHoursInputId")));
		WebElement EstimatedHours2 = driver.findElement(By.id("estimatedHoursInputId"));
		Assert.assertTrue(EstimatedHours2.isDisplayed(), "EstimatedHours is missing");
		log.info("EstimatedHours is visible");	
		EstimatedHours2.sendKeys(Keys.TAB);
		
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
		
	}
	
	@Test(priority = 48)
	public static void DealserviceAppointment() throws Exception
	{
		WebDriverWait wt = new WebDriverWait(driver,100);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("globalSearchStrInput")));
		WebElement GlobalSearch = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(GlobalSearch.isDisplayed(), "GlobalSearch is missing");
		log.info("GlobalSearch is visible");
		GlobalSearch.sendKeys(dealAppointmentCO);
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("SearchResult_0")));
		WebElement SearchResult = driver.findElement(By.id("SearchResult_0"));
		Assert.assertTrue(SearchResult.isDisplayed(), "SearchResult is missing");
		log.info("SearchResult is visible");
		SearchResult.click();
		log.info("CO is selected");
		Thread.sleep(20000);
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(),'New Appointment')]")));
		WebElement DealService = driver.findElement(By.xpath("//span[contains(text(),'New Appointment')]"));
		Assert.assertTrue(DealService.isDisplayed(), "DealService is missing");
		log.info("DealService is visible");
		DealService.click();
		log.info("DealService is opened");
		
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(text(),'Job details')]")));
		Thread.sleep(5000);
		WebElement JobDetails = driver.findElement(By.xpath("//*[contains(text(),'Job details')]"));
		Assert.assertTrue(JobDetails.isDisplayed(), "JobDetails is missing");
		log.info("JobDetails is visible");
		JobDetails.click();
		log.info("JobDetails is opened");
		
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(unitNameonCard)));
		String UnitNameonCard = driver.findElement(By.xpath(unitNameonCard)).getText();
		Thread.sleep(5000);
		wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(createApt)));
		WebElement CreateApt = driver.findElement(By.xpath(createApt));
		Assert.assertTrue(CreateApt.isDisplayed(), "CreateApt is missing");
		log.info("CreateApt is visible");
		CreateApt.click();
		log.info("CreateApt is opened");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),"+"'"+dealAppointmentCO+"'"+")]")));
		Thread.sleep(5000);
		
		WebElement AppointmentTitleId = driver.findElement(By.id("appointmentTitleId"));
		Assert.assertTrue(AppointmentTitleId.isDisplayed(), "AppointmentTitleId is missing");
		log.info("AppointmentTitleId is visible");
		AppointmentTitleId.sendKeys(Keys.chord(Keys.CONTROL,"a"), "New Appointment");
		log.info("EstimatedHours is filled");	
		AppointmentTitleId.sendKeys(Keys.TAB);
		
		WebElement EstimatedHours = driver.findElement(By.id("estimatedHoursInputId"));
		Assert.assertTrue(EstimatedHours.isDisplayed(), "EstimatedHours is missing");
		log.info("EstimatedHours is visible");
		EstimatedHours.sendKeys(Keys.chord(Keys.CONTROL,"a"), "1");
		log.info("EstimatedHours is filled");	
		EstimatedHours.sendKeys(Keys.TAB);
		
		
		
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
		Thread.sleep(5000);
		
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
				Thread.sleep(5000);
				break;
			}
			
		}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(), 'Confirm')])[5]")));
		Thread.sleep(5000);
		WebElement ConfirmButton = driver.findElement(By.xpath("(//button[contains(text(), 'Confirm')])[5]"));
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
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td/div/a)[4]")));
		Thread.sleep(5000);
		WebElement SaveAppointmentButton = driver.findElement(By.xpath("//button[contains(text(),'Save Appointment')]"));
		Assert.assertTrue(SaveAppointmentButton.isDisplayed(), "SaveAppointmentButton is missing");
		log.info("SaveAppointmentButton is visible");
		SaveAppointmentButton.click();
		log.info("SaveAppointmentButton is Clicked");
		Thread.sleep(10000);
		log.info("Appointment is Created successfully");	
		
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(schedule)));
		WebElement Schedule = driver.findElement(By.xpath(schedule));
		Assert.assertTrue(Schedule.isDisplayed(), "Schedule link is missing");
		log.info("Schedule link is visible");
		Schedule.click();
		log.info("Schedule link is clicked");
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Day view')]")));
		Thread.sleep(10000);
		WebElement DayViewLink = driver.findElement(By.xpath("//a[contains(text(),'Day view')]"));
		Assert.assertTrue(DayViewLink.isDisplayed(), "DayViewLink is missing");
		log.info("DayViewLink is visible");
		DayViewLink.click();
		log.info("DayViewLink is opened");

		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td/div")));
		Thread.sleep(5000);
		
		List<WebElement> AllAppointments = driver.findElements(By.xpath("//tr/td/div"));
//		Iterator<WebElement> it = AllAppointments.iterator();
		for(WebElement MyAppoitnment : AllAppointments )
		{
			
			Actions action = new Actions(driver);
			action.moveToElement(MyAppoitnment).build().perform();
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appointmentCONumber)));
			WebElement AppointmentCONumber = driver.findElement(By.xpath(appointmentCONumber));
			if(AppointmentCONumber.getText().contains(dealAppointmentCO)) 
				
			{
				log.info("The Appointment's CONumber Name is " +AppointmentCONumber.getText());
				log.info("Appointment is verified");
				MyAppoitnment.click();
				Thread.sleep(10000);
				break;
			}
		}
		
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("estimatedHoursInputId")));
		WebElement EstimatedHours2 = driver.findElement(By.id("estimatedHoursInputId"));
		Assert.assertTrue(EstimatedHours2.isDisplayed(), "EstimatedHours is missing");
		log.info("EstimatedHours is visible");	
		EstimatedHours2.sendKeys(Keys.TAB);
		
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
		
	}
	
}
