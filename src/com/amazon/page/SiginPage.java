package com.amazon.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SiginPage {
	WebDriver driver;

	public SiginPage(WebDriver driver) {
		this.driver = driver;

	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String login(String uname, String pwd) throws InterruptedException {
		String result = null;
		WebElement user = driver.findElement(By.id("ap_email"));
		user.clear();
		user.sendKeys(uname);
		Thread.sleep(6000);

		WebElement pass = driver.findElement(By.id("ap_password"));
		pass.clear();
		pass.sendKeys(pwd);
		Thread.sleep(6000);

		driver.findElement(By.id("signInSubmit")).click();

		result = driver.getTitle();
		return result;

	}

}
