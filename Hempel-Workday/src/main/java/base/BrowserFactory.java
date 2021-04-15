package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	public static WebDriver getDriver(String browser, Logger log) {
		WebDriver driver;
		log.info("Starting " + browser + " driver");

		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			// Always check version of Chrome against Chrome Driver
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;

		default:
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		driver.manage().window().maximize();
		return driver;
	}

}
