import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DriverManagerTests {
	
	WebDriverManager webDriver;
	WebDriver driver;
	
	@AfterMethod
	public void AfterMethod() {
		webDriver.quitDriver();		
	}
	
	@Test
    public void chromeDriverManagerTest() throws IOException {
		webDriver = DriverManagerFactory.getManager("chrome");
		driver = webDriver.getDriver();
		
        var expectedValue = "https://ampeg.com/index.html";
        
        driver.get(expectedValue);
        
        var actualValue = driver.getCurrentUrl();
        
        Assert.assertEquals(actualValue, expectedValue, "Should be ampeg homepage");
    }
	
	@Test
    public void edgeDriverManagerTest() throws IOException {
		webDriver = DriverManagerFactory.getManager("edge");
		driver = webDriver.getDriver();
		
        var expectedValue = "https://ampeg.com/index.html";
        
        driver.get(expectedValue);
        
        var actualValue = driver.getCurrentUrl();
        
        Assert.assertEquals(actualValue, expectedValue, "Should be ampeg homepage");
    }
}
