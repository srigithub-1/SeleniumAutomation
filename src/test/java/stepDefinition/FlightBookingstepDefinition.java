package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.FlightBookingpage;
import utils.GenericUtils;
import utils.TestContextSetUp;
import utils.TestInput;

public class FlightBookingstepDefinition{

	//Create a public driver variable
	public WebDriver driver;
	//Create a reference to the TestContextSetUp util class
	TestContextSetUp testContextSetUp;
	//Create a reference to FlightBookingpage
	FlightBookingpage flightpage;
	//Create a reference to GenericUtils
	GenericUtils childWindowobj;
	//Input variables from excel
	//String origination,  destination, depDate;
	public String InputInfo[][];


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

	@When("^I enter the FromCity and ToCity with Departure Date from sheet (.+) with rowNumber (.+)$")
	public void i_enter_the_fromCity_and_toCity_with_departure_date_from_sheet_name_with_rowNumber(String sheetname, int rowNum) throws InterruptedException, IOException
	{
	    // Enter source and destination cities
		TestInput tI = new TestInput();
		tI.ReadTestDataFromExcel(rowNum);
		//Enter input search criteria
	    flightpage.enterFromAndToCities(tI.origination,tI.destination, driver);
	    flightpage.enterTravelDate(tI.depDate, driver);
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
