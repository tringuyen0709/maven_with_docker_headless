package api;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Rest_Assured_Real {
	
// Link API: https://api.anhtester.com/swagger/index.html#/
	
//	String url = "https://api.anhtester.com/api/user?username=davidnguyen";
	
	String baseURL = "https://api.anhtester.com";
	String basePath = "/api/user?username=";
	String loginPath = "/api/login";
	String registerPath = "/api/register";
	String deletePath = "/api/user?username=";
	String updatePath= "https://api.anhtester.com/api/user/";
	String token = null;
	int id = 0;
	
	protected Log log;
	
	protected Rest_Assured_Real() {
		log = LogFactory.getLog(getClass());
	}
	
	// {id=22921, username=stephennguyen2812, firstName=stephen, lastName=nguyen, email=stephennguyen2812@fmail.com, phone=0988237110, userStatus=1}
	
	
	@Test (groups = "login", priority = 1)
	public void CHECK_REGISTER() {
		String userName = "stephennguyen2812";
		
		Response response = apiUtility.sendGetRequest(baseURL + basePath + userName);	
		int statusCode = apiUtility.getStatusCode(response);
		if (statusCode == 400) Assert.assertTrue(true);
		else if (statusCode != 400) {
			id = apiUtility.getJsonResponseBodyById("response.id", response);
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(groups = "login", priority = 2, dependsOnMethods = "CHECK_REGISTER")
	public void TC_01_REGISTER() {
		log.info("TC_01_REGISTER: ĐĂNG KÝ USER VỚI PASSWORD");  
		Response response = apiUtility.sendRegisterRequest(baseURL + registerPath);
		apiUtility.verifyStatusCode(200, response);
		
		id = apiUtility.getJsonResponseBodyById("response.id", response);
	}
	
	
	@Test(groups = "login", priority = 3)
	public void TC_02_LOGIN() {
		log.info("TC_02_LOGIN: ĐĂNG NHẬP USER VỚI PASSWORD");
	
		//String userName = "davidnguyen", passWord = "55555";
		String userName = "stephennguyen2812", passWord = "9987642";
		
		Response response = apiUtility.sendLoginRequest(userName, passWord, baseURL + loginPath);
		
		token = apiUtility.getJsonResponseBodyByString("token", response);
		apiUtility.verifyStatusCode(200, response);
		
	}
	
	
	@Test(groups = "login", priority = 4)
	public void TC_02_UPDATE_WITH_PUT() {
		log.info("TC_02_UPDATE_WITH_PUT: CẬP NHẬT THÔNG TIN USER VỚI PUT");
		
		Response response = apiUtility.sendUpdateRequestWithPut(token, updatePath + id);
		apiUtility.verifyStatusCode(200, response);
	}
	
	@Test(groups = "login", priority = 5)
	public void TC_03_UPDATE_WITH_PATCH() {
		log.info("TC_03_UPDATE_WITH_PATCH: CẬP NHẬT THÔNG TIN USER VỚI PATCH");
		
		Response response = apiUtility.sendUpdateRequestWithPatch(token, updatePath + id);
		apiUtility.verifyStatusCode(200, response);
	}
	
	
	@Test(groups = "login", priority = 6)
	public void TC_04_QUERY_ONE() throws InterruptedException {
		log.info("TC_04_QUERY_ONE: QUERY THÔNG TIN USER");
		
		Response response = apiUtility.sendGetRequest("https://api.anhtester.com/api/user?username=stephennguyen2812");
		apiUtility.verifyStatusCode(200, response);
		
		String body = apiUtility.getJsonResponseBodyByString("response", response);
		log.info("In ra body = " + body);
		
	}
	
	
	@Test(groups = "login", priority = 7)
	public void TC_05_QUERY_ALL() throws InterruptedException {
		log.info("TC_04_QUERY_ALL: QUERY THÔNG TIN TẤT CẢ USER");
		
		Response response = apiUtility.sendGetRequest("https://api.anhtester.com/api/users");
		apiUtility.verifyStatusCode(200, response);
		
		List<Map<String, Object>> body = apiUtility.getJsonResponseBodyByList("response", response);
		
		
		for (Map<String, Object> item : body) {
			Integer userID = (Integer) item.get("id"); 
			if (userID == id) {
				System.out.println("In ra item = " + item);
			}
			
		}
	}
	
	@Test(groups = "login", priority = 8)
	public void TC_06_DELETE() throws InterruptedException {
		log.info("TC_05_DELETE: XÓA USER ĐÃ ĐĂNG KÝ");
		String userName = "stephennguyen2812";
		Response response = apiUtility.sendDeleteRequest(token, baseURL + basePath + userName);
		apiUtility.verifyStatusCode(200, response);
	}
	
}
