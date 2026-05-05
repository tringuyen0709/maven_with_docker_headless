package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.nopcommerce.tri.TestListener;

import commons.BaseTest;
import commons.TestListener;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGenerator;

@Listeners(TestListener.class)
public class Level_09_DataTable extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		log.info("before Class");
		driver = getBrowserDriver(browserName, url);
		homePage = PageGenerator.getHomePage(driver);
	}

	@Test
	public void TC_01_Paging() {
		
		log.info("TC_01_Paging - Step 1: Verify PageActiveByName is 15");
		homePage.openPagingPageByName("15");
		Assert.assertTrue(homePage.isPageActiveByName("15")); 
		
		log.info("TC_01_Paging - Step 2: Verify PageActiveByName is 10");
		homePage.openPagingPageByName("10");
		Assert.assertTrue(homePage.isPageActiveByName("10")); 
		
		log.info("TC_01_Paging - Step 3: Verify PageActiveByName is 24");
		homePage.openPagingPageByName("24");
		Assert.assertTrue(homePage.isPageActiveByName("24")); 
		
		log.info("TC_01_Paging - Step 4: Verify PageActiveByName is 1");
		homePage.openPagingPageByName("1");
		Assert.assertTrue(homePage.isPageActiveByName("1"));
		verifyTrue(false);   // co tinh set 'false' de test case FAILED
	}
		
		@Test
		public void TC_02_Search() {
			log.info("TC_02_Search");
			homePage.enterToHeaderTextBoxByName("Country", "Argentina" );
			homePage.enterToHeaderTextBoxByName("Females", "338282" );
			homePage.enterToHeaderTextBoxByName("Males", "349238" );
			homePage.enterToHeaderTextBoxByName("Total", "687522" );
			
			
		}
		
		
		
		
		@Test
		public void TC_03_Verify_Row() {
			log.info("TC_03_Verify_Row");
			homePage.enterToHeaderTextBoxByName("Country", "Argentina" );
			homePage.enterToHeaderTextBoxByName("Males", "349238" );
			homePage.enterToHeaderTextBoxByName("Total", "687522" );
			homePage.enterToHeaderTextBoxByName("Females", "338282" );
			Assert.assertTrue(homePage.isRowValuesDisplayed("338282","Argentina","349238","687522"));
			
			homePage.refreshCurrentPage(driver);
			homePage.enterToHeaderTextBoxByName("Country", "Albania");
			Assert.assertTrue(homePage.isRowValuesDisplayed("24128","Albania","25266","49397"));
			
			homePage.refreshCurrentPage(driver);
			homePage.enterToHeaderTextBoxByName("Total", "553353");
			Assert.assertTrue(homePage.isRowValuesDisplayed("276880","Angola","276472","553353"));
					
			
		}
		
		
		@Test
		public void TC_04_Action() {
			log.info("TC_04_Action");
			homePage.clickToRowActionByCountry("Angola","remove");
			homePage.clickToRowActionByCountry("Argentina","remove");
			homePage.clickToRowActionByCountry("Albania","remove");
			homePage.clickToRowActionByCountry("Afghanistan","remove");
			
			homePage.clickToRowActionByCountry("Algeria","edit");
	
		}
		
	
		


	@AfterClass
	public void afterClass() {
		driver.quit();

	}

}
