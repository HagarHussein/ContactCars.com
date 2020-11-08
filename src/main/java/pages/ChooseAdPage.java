package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChooseAdPage extends AbstractPage {

	private By addUsedCar = By.cssSelector("a.ad-car");

	public ChooseAdPage(WebDriver driver) {
		super(driver);
	}

	public LoginPage clickAddUsedCarBtn() {
		clickButton(addUsedCar);
		return new LoginPage(getDriver());
	}

}
