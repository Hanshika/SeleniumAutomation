package com.amazon.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.amazon.commom.BaseTest;
import com.amazon.page.HomePage;
import com.amazon.page.SearchPage;

public class SearchPageTest extends BaseTest {
	HomePage hm;
	SearchPage sp;

	@BeforeClass
	public void before() {
		hm = new HomePage(driver);
		sp = hm.searchbox();
	}

	@Test
	public void testLogint() {
		Assert.assertEquals(
				"Amazon.com: laptop - Traditional Laptops / Laptops: Electronics",
				sp.SearchFunction());

	}

}
