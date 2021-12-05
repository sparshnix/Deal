package Dealership;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property extends Variables {

	public static void testProperty() throws IOException
	
	{
		FileInputStream input = new FileInputStream(System.getProperty("user.dir")+ 
				File.separator + "src" + 
				File.separator + "test" + 
				File.separator + "java" + 
				File.separator + "config.properties");
		Properties prop = new Properties();
		prop.load(input);	
		
		//Fetch the values from config.properties
		Variables.browser = prop.getProperty("browser");
		Variables.url = prop.getProperty("url");
		Variables.username = prop.getProperty("username");
		Variables.password = prop.getProperty("password");	
		
	}
}
