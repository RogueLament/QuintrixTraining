
import org.openqa.selenium.WebElement;

public class RadioButton{

	private WebElement button;
	
	public RadioButton(WebElement button) {
		this.button = button;
	}
	
	public void select() {
		button.click();
	}
}
