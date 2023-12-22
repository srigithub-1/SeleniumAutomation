package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetUp;

public class hooks {
	//Call TestContextSetUp constructor
	TestContextSetUp testContextSetUp;
	
	//Create constructor to access TestContextSetUp	
	public hooks(TestContextSetUp testContextSetUp)
	{
		this.testContextSetUp= testContextSetUp;
	}
	
	//Close the browser after each scenario execution
	@After
	public void AfterScenario() throws IOException
	{
		testContextSetUp.testBase.WebDriverManager().quit();	
	}
	
	//Executes after each step in the test scenario
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver = testContextSetUp.testBase.WebDriverManager();
		//Capture screenshot for failed scenario
		//if(scenario.isFailed())
		//{
			File sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		//}
		
	}
}
