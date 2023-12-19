package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightBookingpage {
	
	public WebDriver driver;
	public Boolean hotelMenuOptionDisplayed;
	
	//Create a constructor and pass instance of TestContextSetUp driver	
	public FlightBookingpage(WebDriver driver)
	{
			
		this.driver = driver;
	}
		
	By flightBookingLink = By.xpath("//a[text()='Flight Booking']");
	By hotelsMenuOption = By.xpath("//span[contains(text(), 'Hotels')]");
	
	
	public void flightBookingLinkClick()
	{
		driver.findElement(flightBookingLink).click();
	}
	
	public void flightBookingHomePage()
	{
		hotelMenuOptionDisplayed = driver.findElement(hotelsMenuOption).isDisplayed();
		if (hotelMenuOptionDisplayed == true)
		{
			System.out.println("The Flight Booking page along with Menu options is displayed");
		}
		else if (hotelMenuOptionDisplayed == false)
		{
		System.out.println("The Flight Booking page is not displayed");
		}
	}
	
	

}
