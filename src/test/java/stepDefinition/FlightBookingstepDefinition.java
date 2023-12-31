package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Date;
import pageObjects.FlightBookingpage;
import utils.GenericUtils;
import utils.TestBase;
import utils.TestContextSetUp;

public class FlightBookingstepDefinition{
	
	//Create a public driver variable
	public WebDriver driver;
	//Create a reference to the TestContextSetUp util class
	TestContextSetUp testContextSetUp;
	//Create a reference to FlightBookingpage
	FlightBookingpage flightpage;
	//Create a reference to GenericUtils
	GenericUtils childWindowobj;
	
	//Create a constructor of the parent class
	public FlightBookingstepDefinition(TestContextSetUp testContextSetUp) throws IOException
	{
		this.testContextSetUp=testContextSetUp;
		this.flightpage =testContextSetUp.pageObjectManager.getFlightBooking();		
		this.childWindowobj = testContextSetUp.genericUtils.getGenericUtils();
		this.driver =testContextSetUp.testBase.WebDriverManager();
	}	
	
	@Given("I navigate to the Flight Booking Home Page")
	public void i_navigate_to_the_flight_booking_home_page() throws IOException 
	{		
		//Click on the flight booking link
		//flightpage.flightBookingLinkClick();
		
		//Switch to the flight booking home page
		//childWindowobj.switchtoFlightBookingPage();
		
		//Verify that the flight booking page is displayed successfully
		flightpage.verifythatflightBookingHomePageIsShown(driver);	    
		
	}
	
	@When("^I enter the (.+) and (.+) with Departure Date (.+)$")
	public void i_enter_the_toronto_and_bangalore_with_departure_date_depart_date(String origination, String destination, String depDate) throws InterruptedException, IOException
	{
	    // Enter source and destination cities
	    flightpage.enterFromAndToCities(origination, destination, driver);
	    flightpage.enterTravelDate(depDate, driver);
	}
	
	@And("I click on the Search button")
	public void i_click_on_the_search_button() throws IOException
	{
	    // Call the search flights method
		flightpage.searchForFlights(driver);
	}
	
	@Then("All the flights matching the Search Criteria should be shown")
	public void all_the_flights_matching_the_search_criteria_should_be_shown() throws IOException, InterruptedException
	{
		 // Verify that flight search results are shown
		flightpage.flightDetailsPageDisplay(driver);
	}
	
}
