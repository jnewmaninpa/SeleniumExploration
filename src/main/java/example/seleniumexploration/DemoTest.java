package example.seleniumexploration;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTest {
	
	CommonFunctions commonFunctions;
	
	@BeforeTest
	public void startDriver() {
		commonFunctions = new CommonFunctions("chrome", 30);
	}
	
	@Test(priority = 1)
	public void launchUrl() {
        commonFunctions.navigateToUrl("https://expedia.com");
	}
	
	@Test(priority = 2)
	public void clickFlightsHeader() {
		commonFunctions.clickWhenVisible(ExpediaLocators.flightsHeaderLink);
	}
	
	@Test(priority = 3)
	public void clickFlightsImageButton() {
		commonFunctions.clickWhenVisible(ExpediaLocators.flightsImageButton);
	}
	
	@Test(priority = 4)
	public void clickRoundTripButton() {
		commonFunctions.clickWhenVisible(ExpediaLocators.roundTripButton);
	}
	
	@Test(priority = 5)
	public void enterTextInFlyingFrom() {
		String text = "New York";
		commonFunctions.enterTextWhenVisible(ExpediaLocators.flyingFromInput, text);
	}
	
	@Test(priority = 6)
	public void clickTextInFlighingFromDropdown() {
		String text = "New York (NYC - All Airports)";
		commonFunctions.clickWhenVisible(ExpediaLocators.dropdownOptionByText(text));
	}
	
	@Test(priority = 7)
	public void enterTextInGoingTo() {
		String text = "Pittsburgh";
		commonFunctions.enterTextWhenVisible(ExpediaLocators.goingToInput, text);
	}
	
	@Test(priority = 8)
	public void clickTextInGoingToDropdown() {
		String text = "Pittsburgh (PIT - Pittsburgh Intl.)";
		commonFunctions.clickWhenVisible(ExpediaLocators.dropdownOptionByText(text));
	}
	
	@Test(priority = 9)
	public void clickDepartingDateField() {		
		commonFunctions.clickWhenVisible(ExpediaLocators.departingDateField);
	}
	
	@Test(priority = 10)
	public void selectDepartingDate() {
		String year = "2020";
		String month = "3";
		String day = "24";
		commonFunctions.clickWhenVisible(ExpediaLocators.dateButton(year, month, day));
	}
	
	@Test(priority = 11)
	public void clickReturningDateField() {
		commonFunctions.clickWhenVisible(ExpediaLocators.returningDateField);
	}
	
	@Test(priority = 12)
	public void selectReturningDate() {
		String year = "2020";
		String month = "3";
		String day = "25";
		commonFunctions.clickWhenVisible(ExpediaLocators.dateButton(year, month, day));
	}
	
	@Test(priority = 13)
	public void clickTravelersButton() {
		commonFunctions.clickWhenVisible(ExpediaLocators.travelersButton);
	}
	
	@Test(priority = 14)
	public void clickAddChildButton() {
		commonFunctions.clickWhenVisible(ExpediaLocators.addChildButton);
	}
	
	@Test(priority = 15)
	public void selectChildAge() {
		String age = "5";
		commonFunctions.selectByVisibleTextWhenVisible(ExpediaLocators.childAgeSelect, age);
	}
	
	@Test(priority = 16)
	public void clickAddInfantButton() {
		commonFunctions.clickWhenVisible(ExpediaLocators.addInfantButton);
	}
	
	@Test(priority = 17)
	public void selectInfantAge() {
		String age = "Under 1";
		commonFunctions.selectByVisibleTextWhenVisible(ExpediaLocators.infantAgeSelect, age);
	}
	
	@Test(priority = 18)
	public void clickSearchButton() {
		commonFunctions.clickWhenVisible(ExpediaLocators.searchButton);
	}
	
	@Test(priority = 19)
	public void verifyFiltersArePresent() {
		boolean stopsFilterPresent = commonFunctions.checkElementIsDisplayed(ExpediaLocators.stopsFilter);
		assertTrue(stopsFilterPresent, "Stops filter is present");
		
		boolean airlinesIncludedFilterPresent = commonFunctions.checkElementIsDisplayed(ExpediaLocators.airlinesIncludedFilter);
		assertTrue(airlinesIncludedFilterPresent, "Airlines included filter is present");
	}
	
	@Test(priority = 20)
	public void nonstopCheckboxIsWorking() {
		assertFalse(commonFunctions.checkboxIsSelected(ExpediaLocators.nonstopCheckbox), "Nonstop checkbox is not selected");
		commonFunctions.clickWhenVisible(ExpediaLocators.nonstopCheckbox);
		assertTrue(commonFunctions.checkboxIsSelected(ExpediaLocators.nonstopCheckbox), "Nonstop checkbox is not selected");
	}
	
	@AfterTest
	public void stopDriver() {
        commonFunctions.tearDown();
	}

}
