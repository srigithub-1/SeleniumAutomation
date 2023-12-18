package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetUp;

public class ItemCheckoutstepDefinition {
	
		//Define global driver
		public WebDriver driver;
		
		//Define variables
		public Boolean ApplyBtnExistResult, PlaceOrderBtnExistResult;
		public String ItemCount;
		
		//Create an instance of the "TestContextSetUp" constructor
		TestContextSetUp testContextSetUp;
		
		//Create an instance of the "LandingPage"
		CheckoutPage checkoutPage;
		
		
	//Create a user-defined constructor for landing page and pass instance of TestContextSetUp class. ALWAYS CONSTRUCTOR EXECUTED FIRST
	public ItemCheckoutstepDefinition(TestContextSetUp testContextSetUp)
	{
		this.testContextSetUp=testContextSetUp;
		this.checkoutPage =testContextSetUp.pageObjectManager.itemCheckout();
		this.driver =testContextSetUp.pageObjectManager.driver;
	}	
	
	//Pass Paremeterized values
	@Then("^user adds the item (.+) times$")
	public void user_adds_the_item(String ItemCount) throws InterruptedException {
				    
			//Call the meethod to Increment item count
			checkoutPage.IncrementItem(ItemCount);					
			}	
		
	//Pass Paremeterized values
	@Then("user adds the item to cart")
	public void user_adds_the_item_to_cart() throws InterruptedException {			    
		   
		
			//Call the addtoCart Page Object
			checkoutPage.AddToCart();
			}	
		
	@And("user checkout the item")
	public void user_checkout_the_item() throws InterruptedException {
			    
			//Call the addtoCart Page Object
			checkoutPage.AddToCart();
			
			//Initiate the checkout of the item
			checkoutPage.initiateCheckOut();
			
			//Verify that the Place Order button exists
			ApplyBtnExistResult = checkoutPage.verifyApplybtnexist();
			Assert.assertTrue(ApplyBtnExistResult);
			
			//Verify that the Apply button exists
			PlaceOrderBtnExistResult = checkoutPage.verifyPlaceOrderbtnexist();
			Assert.assertTrue(PlaceOrderBtnExistResult);
			
			//Complete the checkout of the item
			checkoutPage.completeCheckout();
			}	

}
