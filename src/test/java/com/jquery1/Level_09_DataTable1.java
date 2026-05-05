package com.jquery1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGenerator;


public class Level_09_DataTable1 extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGenerator.getHomePage(driver);
	}

	@Test
	public void TC_01_Paging() {
		
		homePage.openPagingPageByName("15");
		Assert.assertTrue(homePage.isPageActiveByName("15")); 
		
		homePage.openPagingPageByName("10");
		Assert.assertTrue(homePage.isPageActiveByName("10")); 
		
		homePage.openPagingPageByName("24");
		Assert.assertTrue(homePage.isPageActiveByName("24")); 
		
		homePage.openPagingPageByName("1");
		Assert.assertTrue(homePage.isPageActiveByName("1")); 
	}
		
		@Test
		public void TC_02_Search() {
			homePage.enterToHeaderTextBoxByName("Country", "Argentina" );
			homePage.enterToHeaderTextBoxByName("Females", "338282" );
			homePage.enterToHeaderTextBoxByName("Males", "349238" );
			homePage.enterToHeaderTextBoxByName("Total", "687522" );
			
			
		}
		
		
		
		
		@Test
		public void TC_03_Verify_Row() {
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
