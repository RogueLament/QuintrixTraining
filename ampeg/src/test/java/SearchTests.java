import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTests extends AmpegTests {
  @Test
  public void canFindItemWithExactName() {
	  var expectedURL = "https://ampeg.com/products/heritage/svt-50thAnniversary/";
	  
	  new HomePage(this.driver,this.baseURL)
	  .clickSearch()
	  .sendSearchBox("HERITAGE 50TH ANNIVERSARY SVT");
	  
	  new SearchPage(this.driver,this.baseURL)
	  .clickFirstResult();
	  
	  var actualURL = this.driver.getCurrentUrl();
	  
	  Assert.assertEquals(actualURL, expectedURL, "Should navigate to");
  }

  @Test
  public void canFindItemWithVagueSearch() {
	  var expectedURL = Arrays.asList("https://ampeg.com/software/","https://shop.ampeg.com/software/","https://shop.ampeg.com/software/plug-ins/");
	  
	  new HomePage(this.driver,this.baseURL)
	  .clickSearch()
	  .sendSearchBox("software");
	  
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
