package com.nopcommerce.tri;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommerce.tri.AddressesPageObjectTri;
import pageObject.nopCommerce.tri.HomePageObjectTri;
import pageObject.nopCommerce.tri.LoginPageObjectTri;
import pageObject.nopCommerce.tri.OrdersPageObjectTri;
import pageObject.nopCommerce.tri.PageGeneratorTri;
import pageObject.nopCommerce.tri.RegisterPageObjectTri;
import pageObject.nopCommerce.tri.RewardPointPageObjectTri;
import utils.ExcelUtils;




//@Listeners(TestListener.class)
public class Level_2_Login_Practice_Automation extends BaseTest {

	WebDriver driver;
	
	HomePageObjectTri homePage;
	LoginPageObjectTri loginPage;
	RegisterPageObjectTri registerPage;
	OrdersPageObjectTri ordersPage;
	AddressesPageObjectTri addressesPage;
	RewardPointPageObjectTri rewardPointPage;

//	String username, password;
	


	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) throws InterruptedException {
		log.info("Pre-Condition - Open browser '" + browserName + "' and navigate to '" + url + "'");

		driver = getBrowserDriver(browserName, url);
		
//		homePage = PageGeneratorTri.getHomePage(driver);
		loginPage = PageGeneratorTri.getLoginPage(driver);
		
		Thread.sleep(5000);
		
//		username = "student";
//		password = "Password123";
		
		log.info("debug 111");

	}
	
	@DataProvider(name = "loginData")
    public Object[][] loginData() throws Exception {
		log.info("debug 222");
        return ExcelUtils.getExcelData("src/test/resources/LoginData.xlsx", "Login");
    }


	@Test(dataProvider = "loginData")
	public void TC_01_Login(String username, String password, String expected) throws InterruptedException {
		
	    System.out.println("username = " + username);
	    System.out.println("password = " + password);
	    System.out.println("expected = " + expected);
		
//		Thread.sleep(30000);
		
		log.info("Enter UserName from Textbox");
		loginPage.enterYourUserName(username );
		
		log.info("Enter Password from Textbox");
		loginPage.enterYourPass(password);
		
		log.info("Click To Login Button");
		loginPage.clickLogin();
		
		Thread.sleep(2000);
		
		if (expected.equals("SUCCESS")) {
			log.info("Verify Login is successfully");
			Assert.assertEquals("Logged In Successfully", driver.findElement(By.xpath("//h1[text()='Logged In Successfully']")).getText());
			
			log.info("Click To Logout Button");
			loginPage.clickLogout();
			
		} else {
			log.info("Verify Login is failed as expected");
			Assert.assertEquals("Your username is invalid!", driver.findElement(By.xpath("//div[text()='Your username is invalid!']")).getText());
		}
			Thread.sleep(2000);
	}

	@AfterClass
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		driver.quit();

	}

}