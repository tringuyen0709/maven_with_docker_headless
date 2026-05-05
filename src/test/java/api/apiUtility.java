package api;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class apiUtility {
//	Response response = RestAssured.given().get("sadsad");
	
	
//	public static void login() {
//		JSONObject requestBody = new JSONObject();
//		requestBody.put("username", "davidnguyen");
//		requestBody.put("password", "55555");
//	}
	

	
	public static Response sendGetRequest(String url) {
		return RestAssured.given().get(url);
	}
	
	public static Response sendRegisterRequest(String url) {
		JSONObject registerBody = new JSONObject();
		registerBody.put("username", "stephennguyen2812");
		registerBody.put("firstName", "stephen");
		registerBody.put("lastName", "nguyen");
		registerBody.put("email", "stephennguyen2812@fmail.com");
		registerBody.put("password", "9987642");
		registerBody.put("phone", "0988237110");
		registerBody.put("userStatus", 1);

		return RestAssured.given().contentType(ContentType.JSON).body(registerBody.toString()).post(url);
	}
	
	public static Response sendLoginRequest(String loginUser, String passwordLogin, String url) {
		JSONObject requestBody = new JSONObject();
		requestBody.put("username", loginUser);
		requestBody.put("password", passwordLogin);
		return RestAssured.given().header("Content-Type", "application/json").body(requestBody.toString()).post(url);
	}
	
	public static Response sendUpdateRequestWithPut(String token, String url) {

		JSONObject updateBody = new JSONObject();
		updateBody.put("username", "stephennguyen2812");
		updateBody.put("firstName", "stephen");
		updateBody.put("lastName", "nguyen");
		updateBody.put("email", "stephennguyen2812@fmail.com");
		updateBody.put("password", "9987642");
		updateBody.put("phone", "0988237119");
		updateBody.put("userStatus", 1);
		
	  
		return RestAssured.given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(updateBody.toString()).put(url);
	}
	
	public static Response sendUpdateRequestWithPatch(String token, String url) {

		JSONObject updateBody = new JSONObject();
		updateBody.put("phone", "0988237113");

		return RestAssured.given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).body(updateBody.toString()).patch(url);
	}
	
	public static Response sendDeleteRequest(String token, String url) {
		return RestAssured.given().header("Authorization", "Bearer " + token).contentType(ContentType.JSON).delete(url);
	}
	
	public static int getStatusCode(Response response) {
		int getCode = response.getStatusCode();
//		System.out.println("Status code tra ve la: " + getCode);
		return getCode;
	}
	
	public static void verifyStatusCode(int statusCode, Response response) {
		int getCode = response.getStatusCode();
//		System.out.println("Status code tra ve la: " + getCode);
//		System.out.println("Status code mong muon la: " + statusCode);
		Assert.assertEquals(getCode, statusCode);
	}
	
	
	
	public static String getJsonResponseBodyByString(String path, Response response) {
		return response.jsonPath().getString(path);	  
	}
	
	public static List<Map<String, Object>> getJsonResponseBodyByList(String key, Response response) {
		List<Map<String, Object>> body = response.jsonPath().getList(key);
		return body;	  
	}
	
	public static int getJsonResponseBodyById(String path, Response response) {
		return response.jsonPath().getInt(path);	  
	}
	
	public static long getResponseTime(Response response) {
//		System.out.println("ResponseTime = " + response.getTime() + " ms");
		return response.getTime();
	}

}
