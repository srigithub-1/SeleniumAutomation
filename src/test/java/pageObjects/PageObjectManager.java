package pageObjects;

import org.openqa.selenium.WebDriver;

import utils.GenericUtils;

public class PageObjectManager 
{
	//Define the global driver variable
	public WebDriver driver;
	
	//Create the variable for object creation
	public LandingPage landingPage;
	public OffersPage offersPage;
	public CheckoutPage checkoutPage;
	public FlightBookingpage flightPage;
	public GenericUtils genericUtils;
	
	//Create constructor
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}	
	
	//Create the object of Landing Page and return the object
	public LandingPage getLandingPage()
	{
		landingPage = new LandingPage(driver);		
		return landingPage;
	}
	
	//Create the object of Offers Page and return the object
	public OffersPage getOffersPage()
	{
		offersPage = new OffersPage(driver);
		return offersPage;
	}
	
	//Create the object of checkout Page and return the object
	public CheckoutPage itemCheckout()
	{
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	
	//Create the object of flight booking Page and return the object
	public FlightBookingpage getFlightBooking()
	{
		flightPage = new FlightBookingpage(driver);
		return flightPage;
	}
	
	//Create the object of generic utils class and return the object
	public GenericUtils getGenericUtils()
	{
		genericUtils = new GenericUtils(driver);
		return genericUtils;
	}
}
