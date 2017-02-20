package com.amazon.commom;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.amazon.helper.WebUIDriver;

public class BaseTest {

	public WebDriver driver;

	@BeforeSuite
	public void BeforeSuite() 
	{
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "H://Users//Hanshika//gomathy_java//SeleniumAutomationLearns//resources//drivers//geckodriver.exe"
		 * ); driver = new FirefoxDriver();
		 */

		try {

			WebUIDriver.loadProperties("Config.properties");
		} catch (IOException e) {

			e.printStackTrace();
		}
		driver = WebUIDriver.getDriver();
		driver.get(WebUIDriver.appUrl);

	}

	@AfterSuite
	public void aftersutie() 
	{
		driver.quit();
	}

}
