package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverManager {
	protected WebDriver driver;
	protected abstract void startService() throws IOException;
	protected abstract void stopService();
	protected abstract void createDriver();
	
	public void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	public WebDriver getDriver() throws IOException {
		if (driver == null) {
			startService();
			createDriver();
		}
		return driver;
	}
}
