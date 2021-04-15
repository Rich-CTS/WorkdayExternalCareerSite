package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePageObject;

	public class MyInformationPage extends BasePageObject<MyInformationPage> {

		// Define elements
		private By country = By.xpath("//a[@data-automation-id='countryDropdown']");
		private By streetName = By.xpath("//a[@data-automation-id='addressSection_addressLine1']");
		private By city = By.xpath("//a[@data-automation-id='addressSection_city']");
		private By postalCode = By.xpath("//a[@data-automation-id='addressSection_postalCode']");
		// Initiate web page
		public MyInformationPage(WebDriver driver, Logger log) {
			super(driver, log);
		}
		// Wait for elements to load
		public void waitForAddressFieldsToToLoad() {
			log.info("Waiting for address fields to load");
			waitForVisibilityOf(country);
			waitForVisibilityOf(streetName);
			waitForVisibilityOf(city);
			waitForVisibilityOf(postalCode);
		}
		// Change country
		public void selectCountry(String text) {
			log.info("Function to select a country.");
			select(text,country);
		}
		// Assert all elements present.
		public boolean elementsPresent() {
			log.info("Function to assert Street Name, City and Postal Code fields are present.");
			boolean boolStreetName = assertElementPresent(streetName);
			boolean boolCity = assertElementPresent(city);
			boolean boolPostalCode = assertElementPresent(postalCode);
			boolean assertPresent = boolStreetName && boolCity && boolPostalCode;
			return assertPresent;
		}
		
		
}
