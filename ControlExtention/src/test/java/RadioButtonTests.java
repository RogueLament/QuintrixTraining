import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonTests extends TestBase {
	private RadioButton yesButton;
	private RadioButton impressiveButton;
	private RadioButton noButton;
	private RadioGroup radioGroup;
	
	@BeforeMethod
	public void launch() {
		this.driver.navigate().to(baseURL+"radio-button/");
		radioGroup = new RadioGroup(driver,baseURL+"radio-button/");
		yesButton = radioGroup.getButton("Yes");
		impressiveButton = radioGroup.getButton("Impressive");
		noButton = radioGroup.getButton("No");
	}
	
	@Test
	public void yesButtonTest() {
		var expectedValue = "Yes";
		yesButton.select();
		var actualValue = radioGroup.getSelected();

		Assert.assertEquals(actualValue, expectedValue, "the value should be the same as the getButton.");
	}
	
	@Test
	public void impressiveButtonTest() {
		var expectedValue = "Impressive";
		impressiveButton.select();
		var actualValue = radioGroup.getSelected();

		Assert.assertEquals(actualValue, expectedValue, "the value should be the same as the getButton.");
	}
	
	@Test
	public void noButtonTest() {
		String expectedValue = null;
		noButton.select();
		var actualValue = radioGroup.getSelected();

		Assert.assertEquals(actualValue, expectedValue, "the value should be null.");
	}
}
