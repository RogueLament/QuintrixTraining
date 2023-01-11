package StepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageObject{

	public CartPage(WebDriver driver, String baseURL) {
		super(driver, baseURL);
	}
	
	public boolean verifyAddToCart() {
		var headerLink = this.driver.findElement(By.xpath("//h1[@class='page-heading']"));
		boolean verification = false;
		if (headerLink.getText().equals("Your Cart (1 item)")) {
			verification = true;
		}
		return verification;
	}
}