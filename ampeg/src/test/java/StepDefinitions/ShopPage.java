package StepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage extends PageObject{

	public ShopPage(WebDriver driver, String baseURL) {
		super(driver, baseURL);
	}
	
	public ShopPage clickSoftware() {
		var softwareLink = this.driver.findElement(By.xpath("//a[@aria-label='Software']"));
		
		softwareLink.click();
		
		return this;
	}
}
