package TestScenarios;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.CarDetailsPage;
import pages.SearchResultsPage;

public class SearchTestScenario extends BaseTest {
	private SearchResultsPage searchResultsPage;
	private CarDetailsPage carDetailsPage;

	@Test
	public void searchForACarModel() {
		homePage.chooseCarMake();
		homePage.chooseCarModel();
		searchResultsPage = homePage.clickSearch();
		assertEquals(searchResultsPage.getTitle(), "بحث السيارات الجديدة - ContactCars.com");
		carDetailsPage = searchResultsPage.showCarDetails();
		assertEquals(carDetailsPage.getmonthlyInstallment(), "7,634 ج.م./شهر");
	}

}
