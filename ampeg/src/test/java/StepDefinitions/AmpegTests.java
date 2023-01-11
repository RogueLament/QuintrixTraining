package StepDefinitions;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AmpegTests {
	protected WebDriver driver;
	protected String baseURL;
	
	@BeforeMethod
	public void beforeMethod() throws Throwable {
		this.launchDriver();
	}
	
	@AfterMethod
	public void cleanUp() {
		if(this.driver == null) {
			return;
		}
		this.driver.quit();
	}
	
	protected void launchDriver() throws Throwable {
		var driverPath = "C:\\Users\\Nate\\chromedriver.exe";
		baseURL = "https://www.ampeg.com/";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		this.driver = new ChromeDriver();
		this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		this.driver.manage().window().maximize();
	}
}
