import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
	protected WebDriver driver;
	protected String baseURL;
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		this.launchDriver();
	}
	
	@AfterMethod
	public void cleanUp() {
		if(this.driver == null) {
			return;
		}
		this.driver.quit();
	}
	
	private void launchDriver() throws IOException {
		baseURL = "https://demoqa.com/";
		WebDriverManager webDriver = DriverManagerFactory.getManager("chrome");
		driver = webDriver.getDriver();
	}
}
