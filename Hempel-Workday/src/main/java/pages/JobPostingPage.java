package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePageObject;

	public class JobPostingPage extends BasePageObject<JobPostingPage> {

		// Define elements
		private By applyButton = By.xpath("//a[@data-automation-id='adventureButton']");
		private By applyManuallyButton = By.xpath("//a[@data-automation-id='applyManually']");
		// Initiate web page
		public JobPostingPage(WebDriver driver, Logger log) {
			super(driver, log);
		}
		// Wait for elements to load
		public void waitForJobPostingPageToLoad() {
			log.info("Waiting for Job Posting page to load");
			waitForVisibilityOf(applyButton);
		}
		// Function to click on the apply button
		public void clickApplyButton() {
			log.info("Clicking on the apply button");
			click(applyButton);
		}		
		// Wait for application popup to load
		public void waitForApplicationPopupToLoad() {
			log.info("Waiting for application popup to load");
			waitForVisibilityOf(applyManuallyButton);
		}
		// Function to click apply manually button
		public MyInformationPage clickApplyManuallyButton() {
			log.info("Clicking on the apply button");
			click(applyManuallyButton);
			return new MyInformationPage(driver,log);
		}
}
