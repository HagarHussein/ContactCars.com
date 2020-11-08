package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage extends AbstractPage {

	private By car = By.linkText("1.6 A/T H/L New Shape Sedan");

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}

	public String getTitle() {
		getWait().until(ExpectedConditions.titleContains("ContactCars.com"));
		return getDriver().getTitle();
	}

	public CarDetailsPage showCarDetails() {
		clickLink();
		return new CarDetailsPage(getDriver());
	}

	private void clickLink() {
		getWait().until(ExpectedConditions.presenceOfElementLocated(car));
		WebElement carElement = getDriver().findElement(car);
		scrollDownToElement(carElement);
		carElement.click();
	}

}
