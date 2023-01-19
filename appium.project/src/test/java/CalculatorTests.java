import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.service.local.AppiumServiceBuilder;

public class CalculatorTests {
	private Calculator calculator;

	@BeforeTest
	public void startup() {
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.usingPort(4723);
		builder.withIPAddress("127.0.0.1");
		this.calculator = new Calculator(builder);
		this.calculator.Launch();
	}
	
	@AfterTest
	public void cleanup() {
		this.calculator.cleanup();
	}

	@Test
	public void canAdd() {
		String one = "1";
		String three = "3";
		String expectedResult = "4";
		
		String actualResult = this.calculator.add(one, three);
		
		assertEquals(actualResult, expectedResult, "Result should be 4");
	}

	@Test
	public void canSubtract() {
		String one = "1";
		String three = "3";
		String expectedResult = "-2";
		
		String actualResult = this.calculator.subtract(one, three);
		
		assertEquals(actualResult, expectedResult, "Result should be -2");
	}
}
