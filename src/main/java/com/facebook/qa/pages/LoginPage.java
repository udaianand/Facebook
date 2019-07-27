package com.facebook.qa.pages;

/**
 * @author Udaianand
 *
 */
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebook.qa.base.TestBase;
import com.facebook.qa.util.TestUtil;

public class LoginPage extends TestBase {

	// locators

	@FindBy(css = "[data-testid='royal_email']")
	WebElement username;

	@FindBy(css = "[data-testid='royal_pass']")
	WebElement password;

	@FindBy(css = "[data-testid='royal_login_button']")
	WebElement loginButton;

	// Initialize

	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions

	public void loginApp() {

		Actions actions = new Actions(driver);
		actions.moveToElement(username);
		actions.click().sendKeys(prop.getProperty("username")).build().perform();

		TestUtil.clickOn(driver, password, TestUtil.TIME_OUT);
		password.sendKeys(prop.getProperty("password"));

		TestUtil.clickOn(driver, loginButton, TestUtil.TIME_OUT);

	}
}
