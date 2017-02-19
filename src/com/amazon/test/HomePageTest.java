package com.amazon.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.amazon.commom.BaseTest;
import com.amazon.page.GiftCardPage;
import com.amazon.page.HomePage;
import com.amazon.page.SiginPage;

public class HomePageTest extends BaseTest {

	HomePage hm;

	@BeforeClass
	public void before() {
		hm = new HomePage(driver);

	}

	@Test
	public void testnavlinks() {
		Assert.assertEquals(0, hm.HeaderNavLinks());
	}

	@Test
	public void testserachbox() {
		Assert.assertEquals(
				"Amazon.com: laptop - Traditional Laptops / Laptops: Electronics",
				hm.searchbox());
	}

	@Test
	public void SiginClick() {
		SiginPage lp = hm.ClickSiginPage();
		Assert.assertEquals("Amazon Sign In", lp.getTitle());
	}

	@Test
	public void GiftCardClick() {

		GiftCardPage gc = hm.ClickGiftPage();
		Assert.assertEquals("Gift Cards & Registry @ Amazon.com", gc.getTitle());
	}
}
