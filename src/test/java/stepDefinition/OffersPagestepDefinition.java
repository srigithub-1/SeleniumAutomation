//Main scripts (Java class) that calls all the stepDefinitions in feature files

package stepDefinition;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import pageObjects.OffersPage;
import utils.TestBase;
import utils.TestContextSetUp;

public class OffersPagestepDefinition extends TestBase
{
	public WebDriver driver;
	public String productName, TextShown, offersPageProductName;
	TestContextSetUp testContextSetUp;
	//Create an instance of the "OffersPage"
	OffersPage offersPage;
	
	//Create a constructor and pass instance of TestContextSetUp class
	public OffersPagestepDefinition(TestContextSetUp testContextSetUp) throws IOException
	{
		this.testContextSetUp=testContextSetUp;
		this.offersPage =testContextSetUp.pageObjectManager.getOffersPage();
		this.driver =testContextSetUp.testBase.WebDriverManager();
	}

	
	//Pass Parameterized values
	
	@Then("^user search with short name (.+) in offers page to check if product exists$")
	public void user_search_with_short_name_in_offers_page_to_check_if_product_exists(String shortName) throws InterruptedException {	   
		
		//Click on the offers link
		driver.findElement(By.xpath("//a[@class='cart-header-navlink'][1]")).click();
		
		ArrayList<String> winHandles = new ArrayList<String>(driver.getWindowHandles()); 
		
		//Switch to the offers page
		switchtoChildwindow(winHandles);
		
		//Call the Offers Page Page Object
		//OffersPage offersPage = new OffersPage(driver);
		offersPage.SearchItem(shortName, driver);
		//Fetch the text of the Product shown
		TextShown = offersPage.productOffersdisplay;
		
		//Initial product name fetch. For this, switch to parent window	
		switchtoParentwindow(winHandles);
		offersPageProductName = driver.findElement(By.xpath("//h4[@class='product-name']")).getText().split("-")[0].trim();
		System.out.println("Product Name extracted is: "+offersPageProductName);	
		
		//Compare the product names from landing and offers page
		Assert.assertEquals(offersPageProductName, TextShown);
	}
	
	public void switchtoChildwindow(ArrayList<String> winHandles)
	{	
		
		//switch to the child window i.e. the Offers page 
		driver.switchTo().window(winHandles.get(1));
		driver.manage().window().maximize();	

	}
	
	public void switchtoParentwindow(ArrayList<String> winHandles)
	{		
		//switch to the parent window i.e. the Green Kart landing page 
		driver.switchTo().window(winHandles.get(0));
		driver.manage().window().maximize();					
	}
		

	
}
