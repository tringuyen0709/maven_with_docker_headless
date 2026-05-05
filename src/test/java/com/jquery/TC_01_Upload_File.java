package com.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.PageGenerator;
import pageObjects.jQuery.UploadPageObject;

public class TC_01_Upload_File extends BaseTest {
	
	WebDriver driver;
	UploadPageObject uploadPage;
	String macbookName = "Macbook.jpg";
	String DellXPSName = "Dell XPS.jpg";
	
	
	@Parameters ({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		
		log.info("before Class");
		
		driver = getBrowserDriver(browserName, url);
		
		uploadPage = PageGenerator.getUploadPage(driver);
	}
	
	@Test
	public void TC_01_Upload_One_File() throws InterruptedException {
		
		// Upload with ten file
		log.info("Upload with 2 file");
		uploadPage.uploadFiles(macbookName, DellXPSName);
		
		Thread.sleep(5000);
		
		// Verify ten file dc load thanh cong
		log.info("Kiem tra load 2 file");
		Assert.assertTrue(uploadPage.isFileNameLoadedSuccess(macbookName));
	    Assert.assertTrue(uploadPage.isFileNameLoadedSuccess(DellXPSName));
	    
	    Thread.sleep(5000);
	
	    log.info("Bam nut start cho file thu 1");
		uploadPage.clickToStartButtonByFileName(macbookName);
		log.info("Bam nut start cho file thu 2");
		uploadPage.clickToStartButtonByFileName(DellXPSName);
		
		Thread.sleep(5000);
	
		// Verify file name is uploaded successfully
		log.info("Kiem tra upload cho file thu 1");
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(macbookName));
		
		log.info("Kiem tra upload cho file thu 2");
		Assert.assertTrue(uploadPage.isFileUploadedSuccess(DellXPSName));
		 
		 Thread.sleep(5000);
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	

}
