import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import foundation.TestBase;

@Listeners(ListenerTest.class)

public class SearchTests extends TestBase {
  @Test
  public void canFindItemWithExactName() {
	  driver.navigate().to(this.baseURL);
	  var expectedURL = "https://ampeg.com/products/heritage/svt-50thAnniversary/";
	  
	  new HomePage(this.driver,this.baseURL)
	  .clickSearch()
	  .search("HERITAGE 50TH ANNIVERSARY SVT");
	  
	  new SearchPage(this.driver,this.baseURL)
	  .clickFirstResult();
	  
	  var actualURL = this.driver.getCurrentUrl();
	  
	  Assert.assertEquals(actualURL, expectedURL, "Should navigate to");
  }

  @Test
  public void canFindItemWithVagueSearch() {
	  driver.navigate().to(this.baseURL);
	  var expectedURL = Arrays.asList("https://ampeg.com/software/","https://shop.ampeg.com/software/","https://shop.ampeg.com/software/plug-ins/");
	  
	  new HomePage(this.driver,this.baseURL)
	  .clickSearch()
	  .search("software");
	  
	  new SearchPage(this.driver,this.baseURL)
	  .clickFirstResult();
	  
	  var resultOne = this.driver.getCurrentUrl();
	  
	  new SearchPage(this.driver,this.baseURL)
	  .goBackPage().clickSecondResult();
	  
	  var resultTwo = this.driver.getCurrentUrl();
	  
	  new SearchPage(this.driver,this.baseURL)
	  .goBackPage().clickThirdResult();
	  
	  var resultThree = this.driver.getCurrentUrl();
	  
	  var actualURL = Arrays.asList(resultOne,resultTwo,resultThree);
	  
	  Assert.assertEquals(actualURL, expectedURL, "Should navigate to");
  }
}