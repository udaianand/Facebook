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

public class HomePage extends TestBase {

	// Objects

	@FindBy(xpath = "// span[@class='_5qtp']")
	WebElement createPostFrame;

	@FindBy(xpath = "//div[@class='_1mf _1mj']")
	WebElement messageInputArea;

	@FindBy(css = "[data-testid='react-composer-post-button']")
	WebElement shareButton;

	// initialize
	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	// Actions

	// 1.Post the status message

	public void postStatusMessage(String message) {

		TestUtil.clickOn(driver, createPostFrame, TestUtil.TIME_OUT);
		Actions action = new Actions(driver);
		action.moveToElement(messageInputArea).click().sendKeys(message).build().perform();

		TestUtil.waitForClickable(driver, shareButton, TestUtil.TIME_OUT);
		TestUtil.clickOn(driver, shareButton, TestUtil.TIME_OUT);

	}

}
