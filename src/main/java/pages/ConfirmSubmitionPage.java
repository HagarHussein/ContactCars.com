package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmSubmitionPage extends AbstractPage {

	private By confirmationMsg = By.cssSelector("p.alert-box");

	public ConfirmSubmitionPage(WebDriver driver) {
		super(driver);
	}

	public String getConfirmationTxt() {
		return getDriver().findElement(confirmationMsg).getText();
	}
}
