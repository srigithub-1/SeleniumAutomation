package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	public GenericUtils genericUtils;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Create the object of generic utils class and return the object
	public GenericUtils getGenericUtils()
	{
		genericUtils = new GenericUtils(driver);
		return genericUtils;
	}

	public void SwitchWindowToChild()
	{
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1 =s1.iterator();
		String parentWindow = i1.next();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
	}
	
	public void switchtoFlightBookingPage()
	{						
		//Get the count of child windows
		Set<String> windhandles = driver.getWindowHandles();
						
		//Iterate through all the windows in the page
		Iterator<String>i1 = windhandles.iterator();
						
		//Access the parent window
		String parentWindow = i1.next();
						
		//Access the child window
		String childWindow = i1.next();
						
		//Switch to the child window
		driver.switchTo().window(childWindow);		
		
	}
	
}
