package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
public WebDriver driver;
public String productOffersdisplay;
	
	//Create a constructor and pass instance of TestContextSetUp driver	
	public OffersPage(WebDriver driver)
	{
		
		this.driver = driver;
	}

	//Define xpath
	By search = By.xpath("//input[@type='search']");
	
	//Search the element and send the Name from LandingPageStepDefinition.java file
	public String SearchItem(String passedShortName)
	{
		driver.findElement(search).sendKeys(passedShortName);
		productOffersdisplay = driver.findElement(By.xpath("//div[@class='tableWrapper']/div/table/tbody/tr/td[1]")).getText();
		return productOffersdisplay;
	}
}
