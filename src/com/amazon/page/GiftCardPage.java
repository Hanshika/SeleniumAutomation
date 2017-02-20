package com.amazon.page;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GiftCardPage 
{
	WebDriver driver;

	public GiftCardPage(WebDriver driver) 
	{
		this.driver = driver;

	}

	public String getTitle() {
		return driver.getTitle();
	}

	public int GiftCardPageFunction() {
		driver.findElement(By.xpath(".//*[@id='nav-xshop']/a[3]")).click();
		List<WebElement> element1 = driver.findElements(By
				.cssSelector(".bxc-grid__image.bxc-grid__image--light"));
		return element1.size();

	}

}
