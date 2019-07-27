package com.facebook.qa.testcases;

/**
 * @author Udaianand
 *
 */
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		intialization();
		loginPage = new LoginPage();

	}

	@Test(groups = "Sanity")
	public void loginFaceBook() {
		loginPage.loginApp();
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Facebook", "Page title mismatch found. Please Check");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
