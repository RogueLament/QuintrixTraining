import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SVTSuitePage extends PageObject{
	public final String uRL = "software/svt-suite.html";
	
	public SVTSuitePage(WebDriver driver, String baseURL) {
		super(driver, baseURL);
		setURL(uRL);
	}
	
	public SVTSuitePage clickAddtoCart() {
		var cartLink = this.driver.findElement(By.className("box-tocart"));
		
		cartLink.click();
		
		return this;
	}
	
	public int getCartCounterLabel() {
	    WebDriverWait wait = new WebDriverWait(this.driver,10);
	    //this span does not show up until the counter displays a number
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='counter-label']/span")));
	    
		var label = this.driver.findElement(By.className("counter-label"));		
		
		return Integer.parseInt(label.getText());
	}
}
