package api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Rest_Assured_BDD {
	
// Link API: https://api.anhtester.com/swagger/index.html#/
	
	

	@Test
	public void TC_01_GET() {
	
//		Response response = 
		given()
			.baseUri("https://api.anhtester.com")
			.basePath("/api/user")
			.queryParam("username", "davidnguyen")
		.when()
			.get()
		.then()
			.statusCode(200)
			.body("response.username", equalTo("davidnguyen"));
		
		
//		String res = response.asString();
//		System.out.println("Tra loi = " + res);
//		
//		response.then().body("response.username", equalTo("davidnguyen"));
		
	}

	
}
