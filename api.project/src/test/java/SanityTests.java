import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SanityTests {
	@Test
	public void canUseVar() {
		String myString = "TaylorDennis";
		var myVarString = "Dennis";			  
	}
	
	@Test
	public void canAccessAPI() {
		RestAssured.given().when().get("https://reqres.in/api/users?page=3").then().log()
			  .all();
	}
}
