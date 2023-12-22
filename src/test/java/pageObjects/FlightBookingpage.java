package pageObjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.it.Date;
import org.openqa.selenium.support.ui.Select;

public class FlightBookingpage {
	
	public WebDriver driver;
	public List<String> origCity = new ArrayList<>();
	public List<String> destCity = new ArrayList<>();
	public List<WebElement> destArray;
	public List<WebElement> fromDate;
	public List<WebElement> origCitytext;
	public List<WebElement> destCitytext;
	public Boolean hotelMenuOptionDisplayed, destinationElementdisplayed;
	
	
	//Create a constructor and pass instance of TestContextSetUp driver	
	public FlightBookingpage(WebDriver driver)
	{
			
		this.driver = driver;
	}
		
	//Locators
	By flightBookingLink = By.xpath("//a[text()='Flight Booking']");
	By hotelsMenuOption = By.xpath("//span[contains(text(), 'Hotels')]");
	By originatingCity = By.id("ctl00_mainContent_ddl_originStation1_CTXTaction");
	By originatingCitytextValue = By.xpath("//div[@id='dropdownGroup1']/div/ul/li/a");
	By destinationCity = By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction");
	By destinationCityTextBox = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
	By destinationCitytextValue = By.xpath("//div[@id='dropdownGroup1']/div/ul/li/a");
	By departDate = By.xpath("//input[@id='ctl00_mainContent_view_date1'][1]");
	By clickOnPage = By.id("flightSearchContainer");
	
	
	public void flightBookingLinkClick()
	{
		driver.findElement(flightBookingLink).click();
	}
	
	public void verifythatflightBookingHomePageIsShown()
	{
		hotelMenuOptionDisplayed = driver.findElement(hotelsMenuOption).isDisplayed();
		if (hotelMenuOptionDisplayed == true)
		{
			driver.manage().window().maximize();
		}
		else if (hotelMenuOptionDisplayed == false)
		{
		System.out.println("The Flight Booking page is not displayed");
		}
	}
	
	public void enterFromAndToCities(String source, String destination) throws InterruptedException
	{
		driver.findElement(originatingCity).click();
		origCitytext = driver.findElements(originatingCitytextValue);
		for (int i=0;i<origCitytext.size();i++)
		{
			origCity.add(origCitytext.get(i).getText());
			if(origCity.get(i).contains(source))
			{
				driver.findElement(By.xpath("//div[@id='dropdownGroup1']/div/ul/li/a[contains(@text,'"+source+"')]")).click();
				Thread.sleep(2000);
			}		
		}
//		driver.findElement(destinationCity).click();
//		Thread.sleep(2000);
//		driver.findElement(destinationCity).click();
//		Thread.sleep(2000);
		
		destCitytext = driver.findElements(destinationCitytextValue);
		for (int i=0;i<destCitytext.size();i++)
		{
			destCity.add(destCitytext.get(i).getText());
			if(destCity.get(i).contains(destination))
			{
				destArray=driver.findElements(By.xpath("//div[@id='dropdownGroup1']/div/ul/li/a[contains(@text,'"+destination+"')]"));
				destArray.get(1).click();
				Thread.sleep(2000);
			}		
			
		}
		
		
	}
	
	public void enterTravelDate(String departuredate) throws InterruptedException
	{
		driver.findElement(departDate).click();
		Thread.sleep(2000);
		fromDate = driver.findElements(By.xpath("//input[@id='ctl00_mainContent_view_date1']"));
		fromDate.get(1).sendKeys(departuredate);
		Thread.sleep(2000);
//		driver.findElement(departDate).sendKeys(departuredate);
//		Thread.sleep(5000);		
		
	}
	
	
	
	

}
