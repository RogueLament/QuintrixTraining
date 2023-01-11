package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
 
public class StepDefinitions extends AmpegTests{
	
	HomePage homePage;
	ShopPage shopPage;
	SVTSuitePage sVTSuitePage;
	CartPage cartPage;
	SearchPage searchPage;
	
	public StepDefinitions() throws Throwable {
    	launchDriver();
		homePage = new HomePage(this.driver,this.baseURL);
		shopPage = new ShopPage(this.driver,this.baseURL);
		sVTSuitePage = new SVTSuitePage(this.driver,this.baseURL);
		cartPage = new CartPage(this.driver,this.baseURL);
		searchPage = new SearchPage(this.driver,this.baseURL);
	}
 
    @Given("^user is on the home page$")
    public void user_is_on_the_home_page() throws Throwable {
		this.driver.navigate().to(baseURL);
    }
 
    @When("^user clicks the shop button$")
    public void user_clicks_the_shop_button() throws Throwable {
    	homePage.clickShop();
    }
 
    @When("^user clicks the software button$")
    public void user_clicks_the_software_button() throws Throwable {
        shopPage.clickSoftware();
    }
 
    @When("^user clicks add to cart$")
    public void user_clicks_add_to_cart() throws Throwable {
    	sVTSuitePage.clickAddtoCart();
    }
    
    @Then("^AVT Suite should be added to cart$")
    public void avt_Suite_should_be_added_to_cart() throws Throwable {
        if (cartPage.verifyAddToCart()) {
            System.out.println("Successfully added to cart!");
        } else {
            System.out.println("Not added to cart.");
 
        }
        cleanUp();
    }
    
    @When("user clicks the search button")
    public void user_clicks_the_search_button() {
        homePage.clickSearch();
    }

    @When("user searches {string}")
    public void user_searches_HERITAGE_TH_ANNIVERSARY_SVT(String string) {
        homePage.search(string);
    }

    @When("user clicks first result")
    public void user_clicks_first_result() {
    	searchPage.clickFirstResult();
    }

    @Then("HERITAGE {int}TH ANNIVERSARY SVT should be displayed")
    public void heritage_TH_ANNIVERSARY_SVT_should_be_displayed(Integer int1) {
    	if (this.driver.getCurrentUrl().equals("https://ampeg.com/products/heritage/svt-50thAnniversary/")) {
            System.out.println("Successfully Searched!");
        } else {
            System.out.println("Failed to find item");
        }
        cleanUp();
    }
    
    @Then("software page should be displayed")
    public void software_page_should_be_displayed() {
    	if (this.driver.getCurrentUrl().equals("https://ampeg.com/software/")) {
            System.out.println("Successfully Searched!");
        } else if (this.driver.getCurrentUrl().equals("https://shop-us.ampeg.com/software/")) {
            System.out.println("Successfully Searched!");        	
        } else {
            System.out.println("Failed to find page");
        }
    }

    @When("user goes back")
    public void user_goes_back() {
    	searchPage.goBackPage();
    }

    @When("user clicks second result")
    public void user_clicks_second_result() {
    	searchPage.clickSecondResult();
    }

    @When("user clicks third result")
    public void user_clicks_third_result() {
    	searchPage.clickThirdResult();
    }

    @Then("plug-ins page should be displayed")
    public void plug_ins_page_should_be_displayed() {
    	if (this.driver.getCurrentUrl().equals("https://shop-us.ampeg.com/software/plug-ins/")) {
            System.out.println("Successfully Searched!");
        } else {
            System.out.println("Failed to find item");
        }
        cleanUp();
    }
}