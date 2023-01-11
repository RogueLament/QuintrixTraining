package StepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends PageObject {
	public final String uRL = "https://duckduckgo.com/?ia=web";

	public SearchPage(WebDriver driver, String baseURL) {
		super(driver, baseURL);
		setURL(uRL);
	}
	
	public SearchPage clickFirstResult() {
		return clickResult(1);
	}

	public SearchPage clickSecondResult() {
		return clickResult(2);
	}

	public SearchPage clickThirdResult() {
		return clickResult(3);
		
	}
	
	private SearchPage clickResult(int i) {
		var link = this.driver.findElement(By.xpath("//div[@id='links']/div[" + i + "]/article/div[2]"));
		
		link.click();
		
		return this;
	}
	public SearchPage goBackPage() {
		driver.navigate().back();

		return this;
	}
}