package Dealership;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class Variables {

	public static WebDriver driver;
	public static String url;
	public static String username;
	public static String password;
	public static String browser;
	
	
	public static void test() throws IOException
	{
	Property.testProperty();
	}
	
}
