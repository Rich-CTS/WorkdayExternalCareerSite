package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePageObject;

public class UserHomePage extends BasePageObject<UserHomePage> {

	// Define elements
	private By searchForJobsButton = By.xpath("//button[@data-automation-id='navigationItem-Search for Jobs']");
	// Initiate web page
	public UserHomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	// Wait for elements to load
	public void waitForUserHomePageToLoad() {
		log.info("Waiting for User Home page to load");
		waitForVisibilityOf(searchForJobsButton);
	}
	// Function to click Search for Jobs button
	public JobsPage clickSearchForJobsButton() {
		log.info("Clicking on Search for Jobs button");
		click(searchForJobsButton);
		return new JobsPage(driver,log);
	}

}
