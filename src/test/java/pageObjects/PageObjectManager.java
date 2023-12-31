package pageObjects;

import org.openqa.selenium.WebDriver;

import utils.GenericUtils;
import utils.TestBase;
import utils.TestContextSetUp;

public class PageObjectManager extends TestBase
{
	//Define the global driver variable
	//public WebDriver driver;
	
	//Create the variable for object creation
	public LandingPage landingPage;
	public OffersPage offersPage;
	public CheckoutPage checkoutPage;
	public FlightBookingpage flightPage;
	TestContextSetUp testContextSetUp;
	
	//Create constructor
//	public PageObjectManager(WebDriver driver)
//	{
//		this.driver = driver;
//	}	
	
	//Create the object of Landing Page and return the object
	public LandingPage getLandingPage()
	{
		landingPage = new LandingPage();		
		return landingPage;
	}
	
	//Create the object of Offers Page and return the object
	public OffersPage getOffersPage()
	{
		offersPage = new OffersPage();
		return offersPage;
	}
	
	//Create the object of checkout Page and return the object
	public CheckoutPage itemCheckout()
	{
		checkoutPage = new CheckoutPage();
		return checkoutPage;
	}
	
	//Create the object of flight booking Page and return the object
	public FlightBookingpage getFlightBooking()
	{
		//this.testContextSetUp = testContextSetUp;
		flightPage = new FlightBookingpage();//testContextSetUp);
		return flightPage;
	}
	
}
