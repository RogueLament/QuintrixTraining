import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.windows.WindowsDriver;

public class Calculator {
	private WindowsDriver<WebElement> driver;
	private AppiumServiceBuilder builder;
	
	public Calculator(AppiumServiceBuilder builder) {
		this.builder = builder;
	}
	
	private String getMapping(String buttonLabel) {
		HashMap<String, String> idsByLabel = new HashMap<String, String>();
		idsByLabel.put("1", "num1Button");
		idsByLabel.put("3", "num3Button");
		idsByLabel.put("+", "plusButton");
		idsByLabel.put("=", "equalButton");
		idsByLabel.put("-", "minusButton");
		
		return idsByLabel.get(buttonLabel);
	}
	
	public void Launch() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
		capabilities.setCapability("deviceName", "WindowsPC");
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
		this.driver = new WindowsDriver<WebElement>(service, capabilities);
	}
	
	public void cleanup() {
		this.driver.close();
	}
	
	public String add(String first, String second) {
		return doOperation(first, second, "+");
	}
	
	public String subtract(String first, String second) {
		return doOperation(first, second, "-");
	}
	
	private String doOperation(String first, String second, String operation) {
		this.driver.findElementByAccessibilityId(getMapping(first)).click();
		this.driver.findElementByAccessibilityId(getMapping(operation)).click();
		this.driver.findElementByAccessibilityId(getMapping(second)).click();
		this.driver.findElementByAccessibilityId(getMapping("=")).click();
		
		WebElement element = this.driver.findElementByAccessibilityId("CalculatorResults");
		return element.getText().replace("Display is ", "");
	}
}
