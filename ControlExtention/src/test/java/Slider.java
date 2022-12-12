import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Slider extends PageObject{
	private WebElement slider;

	public Slider(WebDriver driver, String baseURL) {
		super(driver, baseURL);
		slider = driver.findElement(By.xpath("//input[@type='range']"));
	}

	public void setValue(String value) {
		int amount = Integer.valueOf(value) - 25;
		if (amount > 0) {
			for (int i = 0; i < amount; i++) {
				slider.sendKeys(Keys.ARROW_RIGHT);
			}
		}
		else {
			for (int i = 0; i > amount; i--) {
				slider.sendKeys(Keys.ARROW_LEFT);
			}
		}
	}

	public String getValue() {
		var value = driver.findElement(By.id("sliderValue"));
		return value.getAttribute("value");
	}
}
