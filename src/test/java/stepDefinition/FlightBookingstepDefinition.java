package stepDefinition;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FlightBookingpage;
import utils.GenericUtils;
import utils.TestContextSetUp;

public class FlightBookingstepDefinition {
	
	//Create a public driver variable
	public WebDriver driver;
	//Create a reference to the TestContextSetUp util class
	TestContextSetUp testContextSetUp;
	//Create a reference to FlightBookingpage
	FlightBookingpage flightpage;
	//Create a reference to GenericUtils
	GenericUtils childWindowobj;
	
	//Create a constructor of the parent class
	public FlightBookingstepDefinition(TestContextSetUp testContextSetUp)
	{
		this.testContextSetUp=testContextSetUp;
		this.flightpage =testContextSetUp.pageObjectManager.getFlightBooking();
		this.childWindowobj = testContextSetUp.pageObjectManager.getGenericUtils();
		this.driver =testContextSetUp.pageObjectManager.driver;
	}	
	
	@Given("I navigate to the Flight Booking Home Page")
	public void i_navigate_to_the_flight_booking_home_page() 
	{		
		//Click on the flight booking link
		flightpage.flightBookingLinkClick();
		
		//Switch to the flight booking home page
		childWindowobj.switchtoFlightBookingPage();
		
		//Verify that the flight booking page is displayed successfully
		flightpage.flightBookingHomePage();	    
	}
	
	@When("I enter the Toronto and Bangalore with Departure Date <DepartDate>")
	public void i_enter_the_toronto_and_bangalore_with_departure_date_depart_date()
	{
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Hello");
	}
	
	@And("I click on the Search button")
	public void i_click_on_the_search_button()
	{
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside");
	}
	
	@Then("All the flights matching the Search Criteria should be shown")
	public void all_the_flights_matching_the_search_criteria_should_be_shown()
	{
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("The step Definition file");
	}
	
}
