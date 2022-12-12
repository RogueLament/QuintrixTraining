import org.openqa.selenium.WebElement;

public class HyperLink{
	private WebElement element;

	public HyperLink(WebElement element) {
		this.element = element;
	}
	
	public void click() {
		element.click();
	}

}
