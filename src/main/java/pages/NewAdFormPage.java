package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewAdFormPage extends AbstractPage {

	private By make = By.id("newadmake");
	private By model = By.id("ModelID");
	private By shapeType = By.id("ShapeTypeID");
	private By makeYear = By.id("MakeYear");
	private By cc = By.id("CC");
	private By km = By.id("KiloMeters");
	private By price = By.id("Price");
	private By gearBoxAut = By.cssSelector("[tabindex='7']");
	private By gearBoxMan = By.cssSelector("[tabindex='8']");
	private By doorsSum4 = By.cssSelector("input[value='4']");
	private By doorsSum2 = By.cssSelector("input[value='2']");

	private By notes = By.id("NotesAr");
	private By pickFiles = By.id("ImgSaved");

	private By telephone = By.id("Telephones");
	private By city = By.id("cities_1");
	private By agreeBox = By.id("newadagree");
	private By captcha = By.xpath("//div[contains(text(), \"تم التحقق منك\")]");
	private By submitBtn = By.id("btnSub");

	public NewAdFormPage(WebDriver driver) {
		super(driver);
	}

	public void fillForm(String makeValue, String modelValue, String shapeTypeValue, String makeYearValue,
			String ccValue, String kmValue, String priceValue, String gearbox, String doorsSum, String notesValue,
			String telephoneValue, String cityValue) {
		selectCarMake(makeValue);
		selectCarModel(modelValue);
		selectCarShapeType(shapeTypeValue);
		selectCarMakeYear(makeYearValue);
		fillCC(ccValue);
		fillKM(kmValue);
		fillPrice(priceValue);
		chooseGearBox(gearbox);
		chooseDoorsSum(doorsSum);
		fillnotes(notesValue);
		fillTelephone(telephoneValue);
		selectCarCity(cityValue);
		uploadPictures();
		validateCaptcha();
		checkAgreeBox();
		SubmitAd();
	}

	public void selectCarMake(String makeValue) {
		getWait().until(ExpectedConditions.presenceOfElementLocated(make));
		findDropdownElement(make).selectByVisibleText(makeValue);
	}

	public void selectCarModel(String modelValue) {
		findDropdownElement(model).selectByVisibleText(modelValue);
	}

	public void selectCarShapeType(String shapeTypeValue) {
		findDropdownElement(shapeType).selectByVisibleText(shapeTypeValue);
	}

	public void selectCarMakeYear(String makeYearValue) {
		findDropdownElement(makeYear).selectByVisibleText(makeYearValue);
	}

	public void fillCC(String ccValue) {
		getDriver().findElement(cc).sendKeys(ccValue);
	}

	public void fillKM(String kmValue) {
		getDriver().findElement(km).sendKeys(kmValue);
	}

	public void fillPrice(String priceValue) {
		getDriver().findElement(price).sendKeys(priceValue);
	}

	public void chooseGearBox(String gearbox) {
		if (gearbox == "Manual")
			getDriver().findElement(gearBoxMan).click();
		else if (gearbox == "Auto")
			getDriver().findElement(gearBoxAut).click();
	}

	public void chooseDoorsSum(String doors) {
		if (doors == "2")
			getDriver().findElement(doorsSum2).click();
		else if (doors == "4")
			getDriver().findElement(doorsSum4).click();
	}

	public void fillnotes(String notesValue) {
		getDriver().findElement(notes).sendKeys(notesValue);
	}

	public void uploadPictures() {
		String absolutePathpic1 = "E:\\960x0.jpg";
		String absolutePathpic2 = "E:\\960x0.jpg";
//		getWait().until(ExpectedConditions.visibilityOfElementLocated(pickFiles));
		WebElement elem = getDriver().findElement(pickFiles);
		scrollDownToElement(elem);
		String paths = absolutePathpic1 + "\n " + absolutePathpic2;
		elem.sendKeys(absolutePathpic1 + "\n " + absolutePathpic2);
	}

	public void fillTelephone(String telephoneValue) {
		getDriver().findElement(telephone).sendKeys(telephoneValue);
	}

	public void selectCarCity(String cityValue) {
		findDropdownElement(city).selectByValue(cityValue);
	}

	public void validateCaptcha() {
//		getWait().until(ExpectedConditions.presenceOfElementLocated(captcha));
		getWait().until(ExpectedConditions.textToBePresentInElementLocated(captcha, "تم التحقق منك"));
//		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void checkAgreeBox() {
		getDriver().findElement(agreeBox).click();
	}

	public ConfirmSubmitionPage SubmitAd() {
		getDriver().findElement(submitBtn).click();
		return new ConfirmSubmitionPage(getDriver());
	}
}
