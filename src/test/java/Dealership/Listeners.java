package Dealership;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

//ITestListeners interface which implements TestNG Listeners

public class Listeners extends Masterdata implements ITestListener {
	
	private static Logger log = LogManager.getLogger(POM.class.getName());


	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Running Test : " +result.getName());
		try {
			POM.Login();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("Test Method is : " +result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("Status of execution : " +result.getStatus());
		log.info("Test case " +result.getName()+ " passes successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		try {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat(" - dd_MM_yyyy hh_mm_ss ").format(new Date());
			String destination = System.getProperty("user.dir") 
					+ File.separator
					+ "\\Screenshots\\"
					+ result.getName() 
					+ timestamp
					+ "screenshot.png";
			FileUtils.copyFile(file, new File(destination));
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			System.setProperty("org.uncommons.reportng.title", "Blackpurl Test Results");
			Reporter.log("<a title=\"Automation Testing\" href=\""+destination+"\">Screenshot</a>");

			System.out.println("*******Screenshot captured********");
			Reporter.log("Test Failed - screenshot captured for Method : " +result.getName());
			Reporter.log("Status of execution : " +result.getStatus());
			log.fatal("Test Failed - screenshot captured for Method : " +result.getName());
			
			} 
			catch(Exception e) {
			e.printStackTrace();
	}
	

//		String testMethodName = result.getMethod().getMethodName();
//		
//		try {
//			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			getScreenshotpath(testMethodName,driver);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		driver.close();
		
	}

}
