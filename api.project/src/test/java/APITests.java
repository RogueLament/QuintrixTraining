import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.time.Instant;

import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;

public class APITests {
  @Test
  public void apiReturnsCorrectEmail() {
	  RestAssured.given().when()
	  			.get("https://reqres.in/api/users/2")
	  			.then()
	  			.body("data.email", IsEqual.equalTo("janet.weaver@reqres.in"));
  }
  
  @Test
  public void loginReturnsCorrectStatusCode() {
	  RestAssured.given().when()
	  			.get("https://reqres.in/api/login")
	  			.then()
	  			.statusCode(200);
  }
  
  @Test
  public void deleteGivesCorrectResponse() {
	  int response = RestAssured.given().baseUri("https://reqres.in/api")
				.header("Content-Type", "application/json")
				.delete("/delete/users/2")
				.getStatusCode();
      Assert.assertEquals(response, 204);
      
	  //Response 204 (No Content) means the request succeeded but the client stayed on the current page.
  }
  
  @Test
  public void canUpdateWithPatch() {
	  RestAssured.given()
	  			.baseUri("https://reqres.in/api/users/2")
				.contentType(ContentType.JSON)
				.body("{\"name\": \"Morpheus2\"}")
				.when()
				.patch()
				.then()
				.assertThat()
				.statusCode(200)
				.body("name", Matchers.equalTo("Morpheus2"))
				.body("updatedAt", Matchers.notNullValue());
  }
  
  @Test
  public void canUpdateWithPut() {
	  RestAssured.given()
			  	.baseUri("https://reqres.in/api")
				.contentType(ContentType.JSON)
				.body("{\"name\": \"Morpheus2\"}")
				.put("/users/2/name/morpheus")
				.then()
				.assertThat()
				.statusCode(200)
				.body("name", Matchers.equalTo("Morpheus2"))
				.body("updatedAt", Matchers.notNullValue());
  }
  
  @Test
  public void canDeserializeIntoObject() {
	  Response response = RestAssured.given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
	  			.when()
				.get("https://reqres.in/api/users/2")
				.then()
				.contentType(ContentType.JSON)
				.extract()
				.response();
	  
	  User user = response.jsonPath().getObject("data", User.class);
	  
	  Assert.assertEquals(user.getId(), 2);
	  Assert.assertEquals(user.getEmail(), "janet.weaver@reqres.in");
	  Assert.assertEquals(user.getFirst_name(), "Janet");
	  Assert.assertEquals(user.getLast_name(), "Weaver");
	  Assert.assertEquals(user.getAvatar(), "https://reqres.in/img/faces/2-image.jpg");
  }
  
  @Test
  public void canDeserializeIntoCollection() {
	  Response response = RestAssured.given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
				.when()
				.get("https://reqres.in/api/users?page=2")
				.then()
				.contentType(ContentType.JSON)
				.extract()
				.response();

	  User[] user = response.jsonPath().getObject("data", User[].class);
	  
	  Assert.assertEquals(user[0].getId(), 7);
	  Assert.assertEquals(user[0].getEmail(), "michael.lawson@reqres.in");
	  Assert.assertEquals(user[0].getFirst_name(), "Michael");
	  Assert.assertEquals(user[0].getLast_name(), "Lawson");
	  Assert.assertEquals(user[0].getAvatar(), "https://reqres.in/img/faces/7-image.jpg");
	  
	  Assert.assertEquals(user[1].getId(), 8);
	  Assert.assertEquals(user[1].getEmail(), "lindsay.ferguson@reqres.in");
	  Assert.assertEquals(user[1].getFirst_name(), "Lindsay");
	  Assert.assertEquals(user[1].getLast_name(), "Ferguson");
	  Assert.assertEquals(user[1].getAvatar(), "https://reqres.in/img/faces/8-image.jpg");
	  
	  Assert.assertEquals(user[2].getId(), 9);
	  Assert.assertEquals(user[2].getEmail(), "tobias.funke@reqres.in");
	  Assert.assertEquals(user[2].getFirst_name(), "Tobias");
	  Assert.assertEquals(user[2].getLast_name(), "Funke");
	  Assert.assertEquals(user[2].getAvatar(), "https://reqres.in/img/faces/9-image.jpg");
	  
	  Assert.assertEquals(user[3].getId(), 10);
	  Assert.assertEquals(user[3].getEmail(), "byron.fields@reqres.in");
	  Assert.assertEquals(user[3].getFirst_name(), "Byron");
	  Assert.assertEquals(user[3].getLast_name(), "Fields");
	  Assert.assertEquals(user[3].getAvatar(), "https://reqres.in/img/faces/10-image.jpg");
	  
	  Assert.assertEquals(user[4].getId(), 11);
	  Assert.assertEquals(user[4].getEmail(), "george.edwards@reqres.in");
	  Assert.assertEquals(user[4].getFirst_name(), "George");
	  Assert.assertEquals(user[4].getLast_name(), "Edwards");
	  Assert.assertEquals(user[4].getAvatar(), "https://reqres.in/img/faces/11-image.jpg");
	  
	  Assert.assertEquals(user[5].getId(), 12);
	  Assert.assertEquals(user[5].getEmail(), "rachel.howell@reqres.in");
	  Assert.assertEquals(user[5].getFirst_name(), "Rachel");
	  Assert.assertEquals(user[5].getLast_name(), "Howell");
	  Assert.assertEquals(user[5].getAvatar(), "https://reqres.in/img/faces/12-image.jpg");
  }
}
