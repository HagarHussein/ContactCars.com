package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

	private By carMake = By.id("ncmakes");
	private By careModel = By.id("ncmodels");
	private By searchBtn = By.id("btnnewsearch");
	private By addAd = By.cssSelector("a.add_ad");

	private By addAnAdd = By.cssSelector("a.add_ad");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clickSearchButton() {
		clickButton(searchBtn);
	}

	// TODO: Test Driven Data: implement a key, value pair with the possible options
	// with their corresponding value and pass it to this function
	// from the test case.
	public void chooseCarMake() {
		findDropdownElement(carMake).selectByValue("10");
	}

	public void chooseCarModel() {
		findDropdownElement(careModel).selectByValue("10");
	}

	public SearchResultsPage clickSearch() {
		clickButton(searchBtn);
		return new SearchResultsPage(getDriver());
	}

	public ChooseAdPage clickAddAnAdButton() {
		clickButton(addAnAdd);
		return new ChooseAdPage(getDriver());
	}

}
