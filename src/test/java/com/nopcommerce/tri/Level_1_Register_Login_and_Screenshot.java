package com.nopcommerce.tri;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.TestListener;
import pageObject.nopCommerce.tri.AddressesPageObjectTri;
import pageObject.nopCommerce.tri.HomePageObjectTri;
import pageObject.nopCommerce.tri.LoginPageObjectTri;
import pageObject.nopCommerce.tri.OrdersPageObjectTri;
import pageObject.nopCommerce.tri.PageGeneratorTri;
import pageObject.nopCommerce.tri.RegisterPageObjectTri;
import pageObject.nopCommerce.tri.RewardPointPageObjectTri;

@Listeners(TestListener.class)
public class Level_1_Register_Login_and_Screenshot extends BaseTest {

	WebDriver driver;
	
	HomePageObjectTri homePage;
	LoginPageObjectTri loginPage;
	RegisterPageObjectTri registerPage;
	OrdersPageObjectTri ordersPage;
	AddressesPageObjectTri addressesPage;
	RewardPointPageObjectTri rewardPointPage;

	String firstName, lastName, day, month, year, emailAddress, companyName, password, emailAddress_dummy;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("Pre-Condition - Open browser '" + browserName + "' and navigate to '" + url + "'");

		driver = getBrowserDriver(browserName, url);
		
		homePage = PageGeneratorTri.getHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		day = "10";
		month = "May";
		year = "1960";
		emailAddress = "afc" + getRandomNumber() + "@mail.net";
		emailAddress_dummy = "dafdfdsgvdf";
		companyName = "Automation FC";
		password = "123456";
	}

	
	@Test
	public void TC_01_Register() {
		log.info("TC_01_Register: Click on register link from Home Page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Click to Gender Male Radio");
		registerPage.clickToGenderMaleRadio();
		
		log.info("Enter First Name Textbox");
		registerPage.enterToFirstNameTextBox(firstName);
		
		log.info("Enter Last Name Textbox");
		registerPage.enterToLastNameTextBox(lastName);
		
		log.info("Select Day from Dropdown");
		registerPage.selectDayDropdown(day);
		
		log.info("Select Month from Dropdown");
		registerPage.selectMonthDropdown(month);
		
		log.info("Select Year from Dropdown");
		registerPage.selectYearDropdown(year);
				
		log.info("Enter Email Adress from Textbox");
		registerPage.enterToEmailTextBox(emailAddress);
		
		log.info("Enter Company Name from Textbox");
		registerPage.enterToCompanyTextBox(companyName);
		
		log.info("Enter Password from Textbox");
		registerPage.enterToPasswordTextBox(password);
		
		log.info("Enter Confirm Password from Textbox");
		registerPage.enterToConfirmTextBox(password);
		
		log.info("Click To Register Button");
		registerPage.clickToRegisterButon();
		registerPage.sleepInSecond(3);
		
		log.info("Verify the register is successfully");
		verifyTrue(registerPage.isSuccessMessageDisplayed());
		
		log.info("Click To Logout Button");
		homePage = registerPage.clickToLogout();
		


	}
	
	@Test
	public void TC_02_Login() {
		log.info("TC_02_Login: Click on Login link from Home Page");
		loginPage = homePage.clickToLoginLink();
		
		log.info("Enter Email Address from Textbox");
		loginPage.enterYourEmail(emailAddress);
		
		log.info("Enter Password from Textbox");
		loginPage.enterYourPassword(password);
		
		log.info("Click To Login Button");
		homePage = loginPage.clickToLogin();
		
		log.info("Verify the login is successfully");
		verifyTrue(homePage.verifyWelcomePageDisplayed());
		
		
		
	}

	@AfterClass
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		driver.quit();

	}

}