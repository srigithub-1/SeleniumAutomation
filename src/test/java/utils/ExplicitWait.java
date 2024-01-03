package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait extends TestBase{


	public WebDriverWait waitforElementDisplay()
	{
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		return explicitWait;
	}
		
}


