package TestScenarios;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.ChooseAdPage;
import pages.ConfirmSubmitionPage;
import pages.LoginPage;
import pages.NewAdFormPage;

public class AddAnAdScenarios extends BaseTest {
	private ChooseAdPage chooseAdPage;
	private LoginPage loginPage;
	private NewAdFormPage newAdFormPage;
	private ConfirmSubmitionPage confirmSubmitionPage;

	@Test
	public void addAnAd() {
		chooseAdPage = homePage.clickAddAnAdButton();
		loginPage = chooseAdPage.clickAddUsedCarBtn();
		newAdFormPage = loginPage.fillLoginData("test.147963.test@gmail.com", "123456");

		newAdFormPage.fillForm("ألفا روميو", "147", "4x4", "2020", "1600", "10000", "2000000", "Auto", "4",
				"some notes....", "01111111111", "189");

		assertTrue(confirmSubmitionPage.getConfirmationTxt().contains("شكرا لإتمام بيانات إعلانك"));

	}

}
