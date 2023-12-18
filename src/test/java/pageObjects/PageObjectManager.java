package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager 
{
	//Define the global driver variable
	public WebDriver driver;
	
	//Create the variable for object creation
	public LandingPage landingPage;
	public OffersPage offersPage;
	public CheckoutPage checkoutPage;
	
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
	
}
