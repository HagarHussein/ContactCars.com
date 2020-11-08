package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarDetailsPage extends AbstractPage {

	private By monthlyInstallment = By.cssSelector("div:nth-child(5) > a");

	public CarDetailsPage(WebDriver driver) {
		super(driver);
	}

	public String getmonthlyInstallment() {
		getWait().until(ExpectedConditions.presenceOfElementLocated(monthlyInstallment));
		WebElement monthlyInstallmentElement = getDriver().findElement(monthlyInstallment);
		scrollDownToElement(monthlyInstallmentElement);
		return getDriver().findElement(monthlyInstallment).getText();
	}
}
