import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import foundation.TestBase;

@Listeners(ListenerTest.class)

public class CartTests extends TestBase {
	  @Test
	  public void canAddtoCart() {
		  driver.navigate().to(this.baseURL);
		  var expectedValue = true;
		  
		  new HomePage(this.driver,this.baseURL)
		  .clickShop();
		  
		  new ShopPage(this.driver,this.baseURL)
		  .clickSoftware();
		  
		  new SVTSuitePage(this.driver,this.baseURL)
		  .clickAddtoCart();
		  
		  var actualValue = new CartPage(this.driver,this.baseURL)
				  .verifyAddToCart();
				  
		  Assert.assertEquals(actualValue, expectedValue, "Should navigate to");
	  }
}
