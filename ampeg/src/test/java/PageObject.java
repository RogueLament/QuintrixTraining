import org.openqa.selenium.WebDriver;

public abstract class PageObject {
	protected WebDriver driver;
	protected String baseURL;
	private String uRL;
	
	public PageObject(WebDriver driver, String baseURL) {
		this.driver = driver;
		this.baseURL = baseURL;
	}
	
	protected void navigateDirectURL() {
		this.driver.navigate().to(this.baseURL+getURL());
	}

	public String getURL() {
		return uRL;
	}

	public void setURL(String uRL) {
		this.uRL = uRL;
	}
}
