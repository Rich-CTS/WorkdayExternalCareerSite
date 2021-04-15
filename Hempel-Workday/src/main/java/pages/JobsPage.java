package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePageObject;

public class JobsPage extends BasePageObject<JobsPage> {

	// Define elements
	private By jobPosting = By.xpath("//button[@data-automation-id='navigationItem-Search for Jobs']");
	// Initiate web page
	public JobsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	// Wait for elements to load
	public void waitForJobsPageToLoad() {
		log.info("Waiting for Jobs page to load");
		waitForVisibilityOfFirst(jobPosting);
	}
	// Function to click on the first job posting
	public JobPostingPage clickFirstJobPosting() {
		log.info("Clicking on the first job posting");
		clickFirst(jobPosting);
		return new JobPostingPage(driver,log);
	}

}
