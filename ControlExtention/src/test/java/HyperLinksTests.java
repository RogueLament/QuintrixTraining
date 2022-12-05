import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HyperLinksTests extends TestBase{

	@BeforeMethod
	public void launch() {
		this.driver.navigate().to(baseURL+"links/");
	}
	@Test
	public void clickHyperLinkTest() {
		var expectedValue = "Link has responded with staus 200 and status text OK";
		var element = driver.findElement(By.id("created"));
		HyperLink hyperlink = new HyperLink(element);
		hyperlink.click();
		WebDriverWait wait = new WebDriverWait(this.driver,10);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("linkResponse")));
		var response = driver.findElements(By.id("linkResponse"));
		String actualValue = null;
		
		if (response.size() != 0) {
			actualValue = response.get(0).getText();
		}
		
		Assert.assertEquals(actualValue, expectedValue, "the value should include the status and text of link");
	}
}
