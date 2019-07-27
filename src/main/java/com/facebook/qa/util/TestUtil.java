package com.facebook.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.facebook.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICITLY_WAIT = 40;
	public static int TIME_OUT = 70;

	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}

	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

	public static void waitFor(WebDriver driver, WebElement locator, int timeOut) {
		new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeSelected(locator));
	}

	public static void waitForPresence(WebDriver driver, By locator, int timeOut) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static void waitForClickable(WebDriver driver, By locator, int timeOut) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void waitForClickable(WebDriver driver, WebElement locator, int timeOut) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	public static void scrollPageUp(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,250)", "");

	}

}