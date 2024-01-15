package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import utils.ExplicitWait;
import utils.TestBase;

public class FlightBookingpage extends TestBase{

	public List<String> origCity = new ArrayList<>();
	public List<String> destCity = new ArrayList<>();
	public List<WebElement> destArray;
	public List<WebElement> fromDate;
	public List<WebElement> monthSelector, dateSelector;
	public List<WebElement> origCitytext;
	public List<WebElement> destCitytext;
	public Boolean flightMenuOptionDisplayed, originatingCityDropdownDisplayed, destinationCityDropdowndisplayed;
	public Boolean flightDetailsPageDisplayed, flightDetailsPageNoResultsDisplayed, flightDetailsPageSearchResultsSuccessful;
	public String startDate;


	//Locators

	By flightBookingPageIsDisplayed = By.xpath("//a[@href='https://phptravels.net/flights']");
	By originatingCityDropdown = By.xpath("//div[@class='input-items from_flights show active']");
	By destinationCityDropdown = By.xpath("//div[@class='input-items flights_arrival to_flights']");
	By originatingCityTextBox = By.xpath("//input[@role='searchbox']");
	By destinationCityTextBox = By.xpath("//input[@role='searchbox']");
	By departDate = By.id("departure");
	//By departDate = By.xpath("//div[@class='datepicker-days']//table[@class=' table-condensed']//th[@class='next']");
	By searchBox = By.xpath("//button[@id='flights-search']");
	By flightDetailsPageDisplay = By.xpath("//a[@href='https://phptravels.net/flights']");
	By flightDetailsPageNoResultsText = By.xpath("//img[@alt='no results']");
	By flightDetailsPageSuccessfulSearchText = By.xpath("//label[text()=' All Flights']");

	//Methods
	public void verifythatflightBookingHomePageIsShown(WebDriver driver) throws IOException
	{

		flightMenuOptionDisplayed = driver.findElement(flightBookingPageIsDisplayed).isDisplayed();
		if (flightMenuOptionDisplayed == true)
		{

			driver.manage().window().maximize();
		}
		else if (flightMenuOptionDisplayed == false)
		{
		System.out.println("The Flight Booking page is not displayed");
		}
	}

	public void enterFromAndToCities(String source, String destination, WebDriver driver) throws InterruptedException, IOException
	{

		driver.findElement(originatingCityDropdown).click();
		driver.findElement(originatingCityTextBox).sendKeys(source);
		Thread.sleep(2000);
		driver.findElement(originatingCityTextBox).sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		driver.findElement(destinationCityDropdown).click();
		driver.findElement(destinationCityTextBox).sendKeys(destination);
		Thread.sleep(2000);
		driver.findElement(destinationCityTextBox).sendKeys(Keys.RETURN);

	}

	public void enterTravelDate(String departuredate, WebDriver driver) throws InterruptedException, IOException
	{
		driver.findElement(departDate).click();
		driver.findElement(departDate).clear();
		//Click on the next month in the date picker calendar
		//driver.findElement(By.cssSelector("#fadein > div:nth-child(21) > div.datepicker-days > table > thead > tr:nth-child(1) > th.next > svg")).click();

		//monthSelector.get(0).click();
		//Select the date
		//dateSelector = driver.findElements(By.xpath("//td[text()='15']"));
		//dateSelector.get(0).click();

		driver.findElement(departDate).sendKeys(departuredate);
		driver.findElement(departDate).click();
		Thread.sleep(2000);

	}

	public void readFromExcel() throws IOException
	{


	}

	public void searchForFlights(WebDriver driver) throws IOException
	{
		driver.findElement(searchBox).click();

	}

	public void flightDetailsPageDisplay(WebDriver driver) throws IOException, InterruptedException
	{
		//Create object of the Explicit Wait class
		ExplicitWait expWait = new ExplicitWait();
		//Wait until the Flights menu option is shown on the flights search results page
		expWait.waitforElementDisplay(driver).until(ExpectedConditions.visibilityOfElementLocated(flightDetailsPageDisplay));
		flightDetailsPageDisplayed = driver.findElement(flightDetailsPageDisplay).isDisplayed();

		flightDetailsPageNoResultsDisplayed= driver.findElement(flightDetailsPageNoResultsText).isDisplayed();


		if(flightDetailsPageDisplayed==true)
		{

			if(flightDetailsPageNoResultsDisplayed==true)
			{
				Assert.fail("I am sorry. Flight search results not shown. Retry after some time");
			}
			else
			{
				expWait.waitforElementDisplay(driver).until(ExpectedConditions.visibilityOfElementLocated(flightDetailsPageSuccessfulSearchText));
				flightDetailsPageSearchResultsSuccessful = driver.findElement(flightDetailsPageSuccessfulSearchText).isDisplayed();
				Assert.assertTrue(flightDetailsPageSearchResultsSuccessful);
				System.out.println("Enjoy. Your flights are shown");
			}
		}
		else
		{
			Assert.fail("Flight Details page not loaded successfully. Please exit and try after some time");
		}


	}







}
