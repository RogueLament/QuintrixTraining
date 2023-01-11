package StepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageObject {
	public final String uRL = "index.html";
	
	public HomePage(WebDriver driver, String baseURL) {
		super(driver, baseURL);
		setURL(uRL);
	}
	
	public HomePage navigateDirect() {
		navigateDirectURL();
		
		return this;
	}
	
	public HomePage clickShop() {
		var shopLink = this.driver.findElement(By.xpath("//a[@title='Shop']"));
		
		shopLink.click();
		
		return this;
	}
	
	public HomePage clickSearch() {
		var searchLink = this.driver.findElement(By.xpath("//a[@title='Search']"));
		
		searchLink.click();
		
		return this;
	}
	
	public HomePage search(String query) {
		var searchBox = this.driver.findElement(By.id("searchq"));
		
		searchBox.sendKeys(query);
		searchBox.submit();
		
		return this;
	}
}
