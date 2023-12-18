package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
public WebDriver driver;
LandingPage landpage;
	
	int i = 1, incrementcount;
	
	//Create a constructor and pass instance of TestContextSetUp driver	
	public CheckoutPage(WebDriver driver)
	{
		
		this.driver = driver;
	}

	//Define xpath locators
	By addToCart = By.xpath("//button[contains(text(),'ADD TO CART')]");
	By checkoutIcon = By.xpath("//img[@alt='Cart']");
	By proceedtoCheckout = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By applybtn = By.xpath("//button[text()='Apply']");
	By placeOrderbtn = By.xpath("//button[text()='Place Order']");
	By countryDropdown = By.xpath("//div/select");
	By countrySelection = By.xpath("//option[text()='India']");
	By tnC = By.xpath("//input[@type='checkbox']");
	By proceedbutton = By.xpath("//button[text()='Proceed']");
	
	//Define css locators
	By increment = By.cssSelector("a.increment");
	
	//Increment the item quantity	
	public void IncrementItem(String incrementcount)
	{
		while (i < Integer.parseInt(incrementcount))
		{
			i++;
			if(driver.findElement(increment).isDisplayed() != true)
			{
				driver.navigate().refresh();
			}
			
			driver.findElement(increment).click();
		}
		
	}
	
	//Click the "Add to Cart" button post searching the item
	public void AddToCart()
	{
		driver.findElement(addToCart).click();
	}
	
	
	public void initiateCheckOut()
	{
		driver.findElement(checkoutIcon).click();
		driver.findElement(proceedtoCheckout).click();
		
	}
		
	
	public Boolean verifyApplybtnexist()	
	{
		return driver.findElement(applybtn).isDisplayed();
	}
	
	public Boolean verifyPlaceOrderbtnexist()	
	{
		return driver.findElement(placeOrderbtn).isDisplayed();
	}
	
	public void completeCheckout()
	{
		driver.findElement(placeOrderbtn).click();
		driver.findElement(countryDropdown).click();
		driver.findElement(countrySelection).click();
		driver.findElement(tnC).click();
		driver.findElement(proceedbutton).click();
	}

}
