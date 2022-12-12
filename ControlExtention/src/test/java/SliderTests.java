import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTests extends TestBase {

	@BeforeMethod
	public void launch() {
		this.driver.navigate().to(baseURL+"slider/");
	}
	@Test
	public void moveSliderTo80() {
		String expectedValue = "80";
		Slider slider = new Slider(driver,baseURL+"sliver/");
		slider.setValue(expectedValue);
		String actualValue = slider.getValue();
		
		Assert.assertEquals(actualValue, expectedValue, "the value should be the number passed to slider");
	}
	@Test
	public void moveSliderTo17() {
		String expectedValue = "17";
		Slider slider = new Slider(driver,baseURL+"sliver/");
		slider.setValue(expectedValue);
		String actualValue = slider.getValue();

		Assert.assertEquals(actualValue, expectedValue, "the value should be the number passed to slider");
	}
	@Test
	public void moveSliderTo0() {
		String expectedValue = "0";
		Slider slider = new Slider(driver,baseURL+"sliver/");
		slider.setValue(expectedValue);
		String actualValue = slider.getValue();

		Assert.assertEquals(actualValue, expectedValue, "the value should be the number passed to slider");
	}
	@Test
	public void moveSliderTo100() {
		String expectedValue = "100";
		Slider slider = new Slider(driver,baseURL+"sliver/");
		slider.setValue(expectedValue);
		String actualValue = slider.getValue();

		Assert.assertEquals(actualValue, expectedValue, "the value should be the number passed to slider");
	}
}
