package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	private static final int TIMEOUT = 100;

	private WebDriver driver;
	private WebDriverWait wait;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, TIMEOUT);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	// Helper functions to be used in all the pages classes
	public void scrollDownToElement(WebElement elem) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(" + elem.getLocation().x + "," + (elem.getLocation().y - 100) + ");");
	}

	public void clickButton(By buttonLocator) {
		try {
			getWait().until(ExpectedConditions.presenceOfElementLocated(buttonLocator));
			try {
				getDriver().findElement(buttonLocator).click();
			} catch (Exception e) {
				throw new AssertionError("There is no such element with the locator " + buttonLocator
						+ " or the element is not clickable.", e);
			}
		} catch (TimeoutException e) {
			throw new AssertionError(
					"Timeout to the presence of the element with the locator " + buttonLocator + "  is reached.", e);
		}
	}

	public Select findDropdownElement(By dropdown) {
		return new Select(getDriver().findElement(dropdown));
	}
}
