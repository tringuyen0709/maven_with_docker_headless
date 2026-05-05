package api;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Rest_Assured2 {
	
// Link API: https://api.anhtester.com/swagger/index.html#/

//	@Test
	public static void TC_01_GET() {
		
		
		Response response = apiUtility.sendGetRequest("https://api.anhtester.com");
		
		RestAssured.baseURI = "https://api.anhtester.com";
//		Response response = RestAssured.given().get("/api/user?username=davidnguyen");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders().asList());
		System.out.println(response.getBody().asString());
		System.out.println(response.getTime() + " ms");
	}
	

	//	int n = 4;
	@Test(description = "In ra xxx")
	public static void TC_02_GET_ALL_USER() {
		
		RestAssured.baseURI = "https://api.anhtester.com";
		Response response = RestAssured.given().get("/api/users");
		
		System.out.println("In ra status code " + response.getStatusCode());
		System.out.println("In ra body " + response.jsonPath().getString("response[0]"));
		System.out.println("In ra kich co size = " + response.jsonPath().getList("response").size());
	}
	
	

//	 @Test
	public static void TC_02_POST() {


	}
}
