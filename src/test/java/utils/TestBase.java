package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.LandingPage;

public class TestBase {

	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		//Gets browser value from properties file
		String browser_properties = prop.getProperty("browser");
		//Gets browser value from command line
		String browser_maven=System.getProperty("browser");
		
		// result = testCondition ? value1 : value2. This is a java ternary operator
		String browser = browser_maven!=null ? browser_maven : browser_properties;
				
		
		if(driver == null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
		System.setProperty("webdriver.chrome.driver","E://Srinath//Canada//Selenium//Softwares//chromedriver-win32//chromedriver-win32//chromedriver.exe");
		driver = new ChromeDriver();// driver gets the life
			}
//			if(browser.equalsIgnoreCase("firefox"))
//			{
//				System.setProperty("webdriver.gecko.driver","//Users//rahulshetty//Downloads//geckodriver 5");
//				driver = new FirefoxDriver();
//			}
			
			//Implicit wait for the entire browser session
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		}
		
		return driver;
		
	}
	
	
	
}
