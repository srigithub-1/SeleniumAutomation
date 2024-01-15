package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage{

	//Define xpath
	By search = By.xpath("//input[@type='search']");

	//Search the element and send the Name from LandingPageStepDefinition.java file
	public void SearchItem(String passedFirstName, WebDriver driver)
	{
		//If element not found, refresh the page
		if(driver.findElement(search).isDisplayed()!= true)
		{

			driver.navigate().refresh();
		}

		driver.findElement(search).sendKeys(passedFirstName);
	}

	public String getTitleLandingPage(WebDriver driver)
	{
		return driver.getTitle();
	}
}
