package com.amazon.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.amazon.commom.BaseTest;
import com.amazon.page.GiftCardPage;
import com.amazon.page.HomePage;

public class GiftCardPageTest extends BaseTest {
	HomePage hm;
	GiftCardPage gc;

	@BeforeClass
	public void before() {
		hm = new HomePage(driver);
		gc = hm.ClickGiftPage();
	}

	@Test
	public void testLogint() {
		Assert.assertEquals(6, gc.GiftCardPageFunction());

	}

}
