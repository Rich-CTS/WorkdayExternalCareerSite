package test;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import base.CsvDataProvider;

import pages.LogInPage;
import pages.UserHomePage;
import pages.JobsPage;
import pages.JobPostingPage;
import pages.MyInformationPage;

public class TestScript extends BaseTest {

		@Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class, priority = 1, groups = { "regression" })
		public void CareerSiteCountryFieldTest(Map<String, String> testData) {
			String testNumber = testData.get("no");
			String email = testData.get("email");
			String password = testData.get("password");
			String country = testData.get("country");

			log.info("Test No #" + testNumber + " for " + country + ":\n");
			// Initialise logInPage
			LogInPage logInPage = new LogInPage(driver, log);
			// Open LogIn page
			logInPage.openLogInPage();
			logInPage.waitForLogInPageToLoad();
			// Populate email and password
			logInPage.populateEmailAndPassword(email, password);
			// Click Sign In button
			UserHomePage userHomePage = logInPage.clickSignInButton();
			// Click Search for Jobs
			userHomePage.waitForUserHomePageToLoad();
			JobsPage jobsPage = userHomePage.clickSearchForJobsButton();
			// Initialise jobsPage
			// Click a job
			jobsPage.waitForJobsPageToLoad();
			JobPostingPage jobPostingPage = jobsPage.clickFirstJobPosting();
			// Initialise jobPostingPage
			// Click Apply
			jobPostingPage.waitForJobPostingPageToLoad();
			jobPostingPage.clickApplyButton();
			// Click Manually Apply
			jobPostingPage.waitForApplicationPopupToLoad();
			MyInformationPage myInformationPage = jobPostingPage.clickApplyManuallyButton();
			// Select country from csv and assert expected address fields are displayed
			myInformationPage.waitForAddressFieldsToToLoad();
			myInformationPage.selectCountry(country);
			myInformationPage.waitForAddressFieldsToToLoad();
			Assert.assertEquals(true, myInformationPage.elementsPresent());			
		}

}
