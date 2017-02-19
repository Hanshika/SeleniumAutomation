package com.amazon.helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebUIDriver {
	public static String browserName;
	public static String appUrl;

	public static void loadProperties(String fileName)
			throws FileNotFoundException, IOException {
		Properties prop = ConfigUtils.loadProperties(fileName);
		browserName = prop.getProperty("browser");
		appUrl = prop.getProperty("appUrl");

	}

	public static WebDriver getDriver() {
		// returning read object based on input is factory pattern in java
		WebDriver driver;

		switch (browserName) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")
							+ "\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "\\resources\\chromedriver.exe");

			driver = new ChromeDriver();

			break;
		default:
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")
							+ "\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		return driver;
	}
}
