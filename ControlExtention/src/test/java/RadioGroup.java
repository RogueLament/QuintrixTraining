import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioGroup extends PageObject {
	private WebElement radioGroupElement;

	public RadioGroup(WebDriver driver, String baseURL) {
		super(driver, baseURL);
		radioGroupElement = driver.findElement(By.cssSelector("[class='col-12 mt-4 col-md-6']"));
	}
	
	public RadioButton getButton(String label) {
		var radioButton = radioGroupElement.findElement(By.xpath("//label[text()='"+label+"']"));
		
		return new RadioButton(radioButton);
	}
	
	public String getSelected() {
		String label = null;
		var selected = radioGroupElement.findElements(By.cssSelector("span[class='text-success']"));
		if (selected.size() != 0) {
			label = selected.get(0).getText();
		}
		return label;
	}

}
