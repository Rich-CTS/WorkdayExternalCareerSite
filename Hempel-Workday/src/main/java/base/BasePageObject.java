package base;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Logger log;

	protected BasePageObject(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
		wait = new WebDriverWait(driver, 40);
	}

	@SuppressWarnings("unchecked")
	protected T getPage(String url) {
		driver.get(url);
		return (T) this;
	}

	protected void type(String text, By element) {
		find(element).sendKeys(text);
	}

	protected void typeInFirst(String text, By element) {
		findFirst(element).sendKeys(text);
	}

	protected void select(String text, By element) {
		Select drpDownMenu = new Select(find(element));
		drpDownMenu.selectByVisibleText(text);
	}

	protected void click(By element) {
		find(element).click();
	}

	protected void clickFirst(By element) {

		findFirst(element).click();
	}

	private WebElement find(By element) {
		return driver.findElement(element);
	}
	
	private WebElement findFirst(By element) {
		WebElement firstElement = null;
		List<WebElement> elements = driver.findElements(element);
		for (WebElement el : elements) {
			firstElement = el;
			break;
		}
		return firstElement;
	}

	protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}

	protected void waitForVisibilityOfFirst(By locator, Integer... timeOutInSeconds) {
		WebElement firstElement = null;
		List<WebElement> elements = driver.findElements(locator);
		for (WebElement el : elements) {
			firstElement = el;
			break;
		}		
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOf(firstElement),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
	}	
	
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	protected String getText(By element) {
		return find(element).getText();
	}

	protected String getTextFromFirst(By element) {
		return findFirst(element).getText();
	}
	
	protected boolean assertElementPresent(By element) {
		boolean assertPresent = find(element).isDisplayed();
		return assertPresent;
	}
}
