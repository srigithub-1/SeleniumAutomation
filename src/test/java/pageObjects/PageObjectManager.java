package pageObjects;

import java.io.IOException;

import utils.TestInput;

public class PageObjectManager
{
	//Create the instance for all the page objects
	public LandingPage landingPage;
	public OffersPage offersPage;
	public CheckoutPage checkoutPage;
	public FlightBookingpage flightPage;
	public TestInput testInput;

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
		flightPage = new FlightBookingpage();
		return flightPage;
	}

	//Create the object of Input Test Data sheet and return the object
	public TestInput getTestInput(int rowNum) throws IOException
	{
		testInput = new TestInput();
		testInput.ReadTestDataFromExcel(rowNum);
		return testInput;

	}

}
