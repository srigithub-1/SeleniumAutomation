package pageObjects;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.it.Date;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.GenericUtils;
import utils.TestContextSetUp;

public class FlightBookingpage {
	
	public WebDriver driver;
	public List<String> origCity = new ArrayList<>();
	public List<String> destCity = new ArrayList<>();
	public List<WebElement> destArray;
	public List<WebElement> fromDate;
	public List<WebElement> origCitytext;
	public List<WebElement> destCitytext;
	public Boolean flightMenuOptionDisplayed, originatingCityDropdownDisplayed, destinationCityDropdowndisplayed, flightDetailsPageElementDisplayed;
	public String startDate;
	TestContextSetUp testContextSetUp;
	GenericUtils genericUtils;
	public WebDriverWait waitforElement;
	
	
	//Create a constructor and pass instance of TestContextSetUp driver	
	public FlightBookingpage(WebDriver driver)//, TestContextSetUp testContextSetUp)
	{			
		this.driver = driver;		
		
	}
		
	//Locators

	By flightBookingPageIsDisplayed = By.xpath("//a[@href='https://phptravels.net/flights']");
	By originatingCityDropdown = By.xpath("//div[@class='input-items from_flights show active']");
	By destinationCityDropdown = By.xpath("//div[@class='input-items flights_arrival to_flights']");
	By originatingCityTextBox = By.xpath("//input[@role='searchbox']");
	By destinationCityTextBox = By.xpath("//input[@role='searchbox']");
	By departDate = By.id("departure");
	By searchBox = By.xpath("//button[@id='flights-search']");
	By flightDetailsPage = By.xpath("//label[text()=' All Flights']");
	

	
	public void verifythatflightBookingHomePageIsShown()
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
	
	public void enterFromAndToCities(String source, String destination) throws InterruptedException
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
	
	public void enterTravelDate(String departuredate) throws InterruptedException
	{
		driver.findElement(departDate).click();		
		driver.findElement(departDate).clear();
		driver.findElement(departDate).sendKeys(departuredate);
		driver.findElement(departDate).click();	
		Thread.sleep(2000);
		
	}
	
	public void searchForFlights()
	{
		driver.findElement(searchBox).click();		
		
	}
	
	public void flightDetailsPageDisplay()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()=' All Flights']")));
		flightDetailsPageElementDisplayed = driver.findElement(flightDetailsPage).isDisplayed();	
				
	}
	
	
	
	
	
	

}
