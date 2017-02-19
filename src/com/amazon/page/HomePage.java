package com.amazon.page;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver; // dependency injection:injecting driver all over the
						// framework using driver object using constructor

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public int HeaderNavLinks() {
		List<WebElement> elements = driver.findElements(By
				.cssSelector(".nav-line-2"));
		return elements.size();

	}

	public SearchPage searchbox() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");

		WebDriverWait wait = new WebDriverWait(driver, 45);
		WebElement ele = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@value='Go']")));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		ele.click();

		return new SearchPage(driver);
	}

	public SiginPage ClickSiginPage() {

		WebDriverWait wait = new WebDriverWait(driver, 25);
		WebElement ele = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("nav-link-accountList")));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ele.click();

		return new SiginPage(driver);

	}

	public GiftCardPage ClickGiftPage() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement ele = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By
						.xpath(".//*[@id='nav-xshop']/a[3]")));
		ele.click();
		return new GiftCardPage(driver);

	}
}
