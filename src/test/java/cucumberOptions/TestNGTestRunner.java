package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Path of the file
//dryRun-> check if keywords have mapping to stepDefinitions
//monochrome=true -> better reporting
//glue-> map to stepDefinitions
//features--> path where feature files exist

@CucumberOptions(features="src/test/java/features",glue="stepDefinition",
monochrome=true,tags="@FlightBooking or @OffersPage or @CheckOutPage",plugin= {"html:target/cucumber.html" , "json:target/cucumber.json",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//rerun failed tests
"rerun:target/failed_scenarios.txt"})

//AbstractTestNGCucumberTests -> To notify Cucumber that we will use testNG framework
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
	//extent reports aventstack in maven repository. Use "com.aventstack » extentreports"cls
	
	//grasshopper in maven repository. Use "tech.grasshopper » extentreports-cucumber7-adapter"

	//To run tests in parallel
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
}
