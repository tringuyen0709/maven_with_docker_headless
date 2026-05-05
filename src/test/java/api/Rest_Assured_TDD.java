package api;

import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Rest_Assured_TDD {
	
// Link API: https://api.anhtester.com/swagger/index.html#/

	@Test
	public static void TC_01_GET() {
		RestAssured.baseURI = "https://api.anhtester.com";
		Response response = RestAssured.given().get("/api/user?username=davidnguyen");
		
		//Verify response code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		// Verify JSON response (including body and header)
		Headers allHeaders = response.getHeaders(); // trả về tất cả headers
		allHeaders.forEach(header -> System.out.println(header.getName() + ": " + header.getValue()));

		
		List<Header> allHeader = response.getHeaders().asList(); // trả về tất cả headers
		System.out.println("get Headers = " + allHeader);
		
		System.out.println("getContentType = " + response.getContentType());
		System.out.println("getStatusCode = " + response.getStatusCode());
		System.out.println("getTime = " + response.getTime());
		
		System.out.println("Lay gia tri id = " + response.jsonPath().getString("response.id"));
		System.out.println("Lay gia tri username = " + response.jsonPath().getString("response.username"));
		System.out.println("Lay gia tri firstName = " + response.jsonPath().getString("response.firstName"));
		System.out.println("Lay gia tri lastName = " + response.jsonPath().getString("response.lastName"));
		System.out.println("Lay gia tri email = " + response.jsonPath().getString("response.email"));
		System.out.println("Lay gia tri phone = " + response.jsonPath().getString("response.phone"));
		System.out.println("Lay gia tri userStatus = " + response.jsonPath().getString("response.userStatus"));
		
		System.out.println("Lay gia tri userStatus = " + response.jsonPath().getString("response"));
		
		System.out.println("Lay gia tri userStatus = " + response.getBody().asString());

	}

	 //@Test
	public static void TC_02_POST() {

		// Base URI
		RestAssured.baseURI = "https://api.anhtester.com";

        // Tạo JSON body với username/password
		JSONObject requestBody = new JSONObject();
		requestBody.put("username", "davidnguyen");
		requestBody.put("password", "55555");
		
		
		String body = requestBody.toString();
		
		System.out.println("In ra body = " + body);

		// Gửi POST request
		Response response = RestAssured.given().header("Content-Type", "application/json").body(requestBody.toString()).post("/api/login");

		// In status code
//		int statusCode = response.getStatusCode();
//        System.out.println("Status code: " + response.getStatusCode());
//		Assert.assertEquals(statusCode, 200);

//		Headers allHeaders = response.getHeaders(); // trả về tất cả headers
//		allHeaders.forEach(header -> System.out.println(header.getName() + ": " + header.getValue()));

		String responseBody = response.getBody().asString(); // String toàn bộ body
		
		System.out.println("Response Body 111: " + responseBody);

		// In response body
		System.out.println("Response body: " + response.getBody().asString());

		// In ra response time (ms)
//		System.out.println("Response time: " + response.getTime() + " ms");

		// Lấy token nếu API trả về
//		if (response.getStatusCode() == 200) {
//			String token = response.jsonPath().getString("token");
//			System.out.println("Login token: " + token);
//		}

	}
}
