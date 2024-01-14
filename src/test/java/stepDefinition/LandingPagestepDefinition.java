//All step definitions defined in files within this package
package stepDefinition;

import java.io.IOException;

//import drivers, PO and utils
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestBase;
import utils.TestContextSetUp;

//Main Class
public class LandingPagestepDefinition extends TestBase
{
	//Define global driver
	public WebDriver driver;
	//Define variables
	public String productOffersdisplay, productName;
	
	//Create an instance of the "TestContextSetUp" constructor
	TestContextSetUp testContextSetUp;
	
	//Create an instance of the "LandingPage"
	LandingPage landingPage;
	
	
//Create a user-defined constructor for landing page and pass instance of TestContextSetUp class. ALWAYS CONSTRUCTOR EXECUTED FIRST
public LandingPagestepDefinition(TestContextSetUp testContextSetUp) throws IOException
{
	this.testContextSetUp=testContextSetUp;
	this.landingPage =testContextSetUp.pageObjectManager.getLandingPage();
	this.driver =testContextSetUp.testBase.WebDriverManager();
}

@Given("User is on Green cart landing page") //User is on Green cart landing page
public void User_is_on_green_cart_landing_page() throws InterruptedException {		    

		Assert.assertTrue(landingPage.getTitleLandingPage(driver).contains("GreenKart"));		
		}
		
	
//Pass Paremeterized values
@When("^user search with short name (.+) and extract the actual name of the product$")
public void user_search_with_short_name_and_extract_the_actual_name_of_the_product(String FirstName) throws InterruptedException {
		    
		//Call the Landing Page Page Object
		landingPage.SearchItem(FirstName, driver);
		//LandingPage landpage = new LandingPage(driver);
		//Send the Name from the Feature file to the Page Object
		//landpage.SearchItem(FirstName);				
		}	
	
}
