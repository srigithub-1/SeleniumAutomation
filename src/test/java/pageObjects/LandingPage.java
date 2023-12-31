package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestBase;

public class LandingPage extends TestBase{
	//public WebDriver driver;
	
	//Create a constructor and pass instance of TestContextSetUp driver	
//	public LandingPage(WebDriver driver)
//	{
//		
//		this.driver = driver;
//	}

	//Define xpath
	By search = By.xpath("//input[@type='search']");
	
	//Search the element and send the Name from LandingPageStepDefinition.java file
	public void SearchItem(String passedFirstName)
	{
		//If element not found, refresh the page
		if(driver.findElement(search).isDisplayed()!= true)
		{
			
			driver.navigate().refresh();
		}
		
		driver.findElement(search).sendKeys(passedFirstName);
	}
	
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}
}
