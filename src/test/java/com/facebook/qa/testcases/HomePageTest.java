package com.facebook.qa.testcases;

/**
 * @author Udaianand
 *
 */
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.HomePage;
import com.facebook.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		intialization();
		loginPage = new LoginPage();
		homePage = new HomePage();

	}

	@Test
	public void verifyPostMessage() {

		loginPage.loginApp();
		homePage.postStatusMessage("Hello World");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
