package foundation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {
	protected DriverManager manager;
	protected String browserType;
	protected String baseURL;
	protected WebDriver driver;

	@BeforeMethod
	public void setup() {
		baseURL = "https://www.ampeg.com/";
		this.manager = DriverManagerFactory.getManager("chrome");
		this.manager.createDriver();
		this.driver = manager.getDriver();
		var manage = this.driver.manage();
		manage.window().maximize();
		manage.timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void cleanup() {
		if(this.driver != null) {
			this.manager.quitDriver();
		}
	}
}
