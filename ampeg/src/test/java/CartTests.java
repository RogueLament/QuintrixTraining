import org.testng.Assert;
import org.testng.annotations.Test;

import foundation.TestBase;

public class CartTests extends TestBase {
	  @Test
	  public void canAddtoCart() {
		  var expectedValue = 1;
		  
		  new HomePage(this.driver,this.baseURL)
		  .clickSearch()
		  .search("SVT Suite");
		  
		  new SearchPage(this.driver,this.baseURL)
		  .clickSecondResult();
		  
		  var actualValue = new SVTSuitePage(this.driver,this.baseURL)
				  .clickAddtoCart()
				  .getCartCounterLabel();
		  
		  Assert.assertEquals(actualValue, expectedValue, "Should navigate to");
	  }
}
