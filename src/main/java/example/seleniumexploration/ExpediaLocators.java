package example.seleniumexploration;

import org.openqa.selenium.By;

public class ExpediaLocators {
	
	protected static final By flightsHeaderLink = By.id("primary-header-flight");
	protected static final By flightsImageButton = By.xpath("//button[@data-lob='flight']");
	protected static final By roundTripButton = By.id("flight-type-roundtrip-label-flp");
	protected static final By flyingFromInput = By.id("flight-origin-flp");
	protected static final By goingToInput = By.id("flight-destination-flp");
	protected static final By departingDateField = By.id("flight-departing-flp");
	protected static final By returningDateField = By.id("flight-returning-flp");
	protected static final By travelersButton = By.xpath("//div[@id='traveler-selector-flp']//button[@data-control='menu']");
	protected static final By addChildButton = By.xpath("(//span[text()='Add Child']/parent::button)[1]");
	protected static final By addInfantButton = By.xpath("(//span[text()='Add Infant']/parent::button)[1]");
	protected static final By searchButton = By.xpath("(//button[@type='submit']/span[text()='Search'])[1]/parent::button/parent::label");
	protected static final By childAgeSelect = By.xpath("//select[@id='flight-age-select-1-flp' and contains(@class, 'gcw-child-age-1-1-sa')]");
	protected static final By infantAgeSelect = By.xpath("//select[@data-gcw-storeable-name='gcw-infant-age-1-1' and contains(@class,'gcw-infant-age-1-sa')]");
	protected static final By stopsFilter = By.id("stops-legend");
	protected static final By airlinesIncludedFilter = By.id("airlines-included-legend");
	protected static final By nonstopCheckbox = By.id("stopFilter_stops-0");

	protected static By dropdownOptionByText(String text) {
		return By.xpath("//div/strong/fl[text()='"+text+"']");
	}
	
	protected static By dateButton(String year, String month, String day) {
		return By.xpath("//button[@data-year='"+year+"' and @data-month='"+month+"' and @data-day='"+day+"']");
	}
}
