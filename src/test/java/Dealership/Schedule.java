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
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appointmentNane)));
			WebElement AppointmentNane = driver.findElement(By.xpath(appointmentNane));
			if(AppointmentNane.getText().contains("Appointment -")) 
			{
				log.info("The Appointment Name is " +AppointmentNane.getText());
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
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appointmentNane)));
			WebElement AppointmentNane = driver.findElement(By.xpath(appointmentNane));
			if(AppointmentNane.getText().contains("Appointment -")) 
			{
				log.info("The Appointment Name is " +AppointmentNane.getText());
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
		
//		CreateAppointment();
		
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
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(appointmentNane)));
			WebElement AppointmentNane = driver.findElement(By.xpath(appointmentNane));
			if(AppointmentNane.getText().contains("Appointment -")) 
			{
				log.info("The Appointment Name is " +AppointmentNane.getText());
				WebElement AppointmentTime = driver.findElement(By.xpath(appointmentTime));
				log.info("Appointment " +AppointmentTime.getText());
				WebElement MoveTo = driver.findElement(By.xpath(moveto));
				action.dragAndDrop(MyAppoitnment, MoveTo).perform();
				Thread.sleep(10000);
				log.info("Appointment's new time " +AppointmentTime.getText());
				Thread.sleep(10000);
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
		log.info("Appointment is successfully moved");
		

	}
	
}
