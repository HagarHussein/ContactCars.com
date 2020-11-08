package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

	private By emailTextBox = By.id("Email");
	private By passwordTextBox = By.id("Password");
	private By loginBtn = By.id("btnlogin");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public NewAdFormPage fillLoginData(String email, String password) {
		getWait().until(ExpectedConditions.presenceOfElementLocated(emailTextBox));
		getDriver().findElement(emailTextBox).sendKeys(email);
		getDriver().findElement(passwordTextBox).sendKeys(password);
		clickButton(loginBtn);
		return new NewAdFormPage(getDriver());
	}

}
