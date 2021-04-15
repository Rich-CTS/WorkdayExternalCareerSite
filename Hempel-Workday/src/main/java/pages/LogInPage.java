package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePageObject;

// Set as page name as the class and <T>
public class LogInPage extends BasePageObject<LogInPage> {
	// Define URL and xpaths for Email field, Password field and Sign In button
	private static final String URL = "https://hempel3.wd3.myworkdayjobs-impl.com/en-US/hempelcareers/login";
	// Find if xpath unique in console $x("//button[@data-automation-id='signInSubmitButton']") and press Enter
	// to see how many times xpath is in webpage
	private By emailField = By.xpath("//input[@data-automation-id='email']");
	private By passwordField = By.xpath("//input[@data-automation-id='password']");
	private By signInButton = By.xpath("//button[@data-automation-id='signInSubmitButton']");
	// Function to initiate web browser
	
	public LogInPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
    // Function to open web page
	public void openLogInPage() {
		getPage(URL);
	}
	// Function to wait for Email field, Password field and Sign In button to load
	public void waitForLogInPageToLoad() {
		log.info("Waiting for Login page to load");
		waitForVisibilityOf(emailField);
		waitForVisibilityOf(passwordField);
		waitForVisibilityOf(signInButton, 10);
	}
	// Function to populate Email field and Password field
	public void populateEmailAndPassword(String email, String password) {
		log.info("Populating email and password");
		type(email, emailField);
		type(password, passwordField);
	}
	// Function to click Sign In button
	public UserHomePage clickSignInButton() {
		log.info("Clicking on Sign In button");
		click(signInButton);
		return new UserHomePage(driver,log);
	}

}
