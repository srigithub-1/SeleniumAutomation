//Main scripts (Java class) that calls all the stepDefinitions in feature files

package stepDefinition;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Then;
import pageObjects.OffersPage;
import utils.TestContextSetUp;

public class OffersPagestepDefinition
{
	public WebDriver driver;
	public String productName, TextShown, offersPageProductName;
	TestContextSetUp testContextSetUp;
	//Create an instance of the "OffersPage"
	OffersPage offersPage;
	
	//Create a constructor and pass instance of TestContextSetUp class
	public OffersPagestepDefinition(TestContextSetUp testContextSetUp)
	{
		this.testContextSetUp=testContextSetUp;
		this.offersPage =testContextSetUp.pageObjectManager.getOffersPage();
		this.driver =testContextSetUp.pageObjectManager.driver;
	}

//	@Then("user search with short name {string} in offers page to check if product exists")
//	public void user_search_with_short_name_in_offers_page_to_check_if_product_exists(String shortName) throws InterruptedException {	   
//		
//		switchtoChildwindow();
//		//Call the Offers Page Page Object
//		//OffersPage offersPage = new OffersPage(driver);
//		offersPage.SearchItem(shortName);
//		//Fetch the text of the Product shown
//		TextShown = offersPage.productOffersdisplay;
//		
//		//Initial product name fetch. For this, switch to parent window	
//		switchtoParentwindow();
//		offersPageProductName = driver.findElement(By.xpath("//h4[@class='product-name']")).getText().split("-")[0].trim();
//		System.out.println("Product Name extracted is: "+offersPageProductName);//		

//		
//		//Compare the product names from landing and offers page
//		Assert.assertEquals(offersPageProductName, TextShown);
//	}
	
	//Pass Parameterized values
	
	@Then("^user search with short name (.+) in offers page to check if product exists$")
	public void user_search_with_short_name_in_offers_page_to_check_if_product_exists(String shortName) throws InterruptedException {	   
		
		switchtoChildwindow();
		//Call the Offers Page Page Object
		//OffersPage offersPage = new OffersPage(driver);
		offersPage.SearchItem(shortName);
		//Fetch the text of the Product shown
		TextShown = offersPage.productOffersdisplay;
		
		//Initial product name fetch. For this, switch to parent window	
		switchtoParentwindow();
		offersPageProductName = driver.findElement(By.xpath("//h4[@class='product-name']")).getText().split("-")[0].trim();
		System.out.println("Product Name extracted is: "+offersPageProductName);	
		
		//Compare the product names from landing and offers page
		//Assert.assertEquals(offersPageProductName, TextShown);
	}
	
	public void switchtoChildwindow()
	{
		//Click on the offers link
		driver.findElement(By.xpath("//a[@class='cart-header-navlink'][1]")).click();
						
		//Get the count of child windows
		Set<String> windhandles = driver.getWindowHandles();
						
		//Iterate through all the windows in the page
		Iterator<String>i1 = windhandles.iterator();
						
		//Access the parent window
		String parentWindow = i1.next();
						
		//Access the child window
		String childWindow = i1.next();
						
		//Switch to the child window
		driver.switchTo().window(childWindow);
	}
	
	public void switchtoParentwindow()
	{		
						
		//Get the count of child windows
		Set<String> windhandles = driver.getWindowHandles();
						
		//Iterate through all the windows in the page
		Iterator<String>i1 = windhandles.iterator();
						
		//Access the parent window
		String parentWindow = i1.next();					
								
		//Switch to the child window
		driver.switchTo().window(parentWindow);
	}
		

	
}
