package com.amazon.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.amazon.commom.BaseTest;
import com.amazon.helper.ExcelHelper;
import com.amazon.page.HomePage;
import com.amazon.page.SiginPage;

public class siginPageTest extends BaseTest {

	SiginPage lp;
	HomePage hm;

	Logger logger = LogManager.getLogger(siginPageTest.class);

	@BeforeClass
	public void before() {
		hm = new HomePage(driver);

		// lp=new SiginPage(driver);

		lp = hm.ClickSiginPage();

	}

	@DataProvider(name = "logindata")
	public Object[][] testData() {
		Object[][] data = ExcelHelper.getData();
		return data;
	}

	@Test(dataProvider = "logindata")
	public void testLogint(String uname, String pwd) {
		logger.info("In the test login method....");
		try {
			Assert.assertNotNull(lp.login(uname, pwd));
		} catch (InterruptedException e) {
			logger.error("exception in login screen");
			e.printStackTrace();
		}

	}

}
