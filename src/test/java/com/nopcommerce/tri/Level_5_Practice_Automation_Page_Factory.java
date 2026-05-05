package com.nopcommerce.tri;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Level_5_Practice_Automation_Page_Factory extends BaseTest {

	WebDriver driver;
	Actions action;
	WebDriverWait explicitWait;

	@BeforeClass
	public void openWebPage() throws InterruptedException {
		// Hover chuột
		Log log;
		log = LogFactory.getLog(getClass());

		log.info("debug 111");
		
	    ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");          // chạy không giao diện
        chromeOptions.addArguments("--disable-gpu");       // thường dùng cho Windows
        chromeOptions.addArguments("--window-size=1920,1080");

		
	

		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		driver = new ChromeDriver(chromeOptions);
		driver.get("https://automationfc.github.io/basic-form/index.html");

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='User Avatar 05']")
	private WebElement hoverLink;

	@Test
	public void hoverChuot() throws InterruptedException {

		action = new Actions(driver);
		Thread.sleep(1000);

		// Cach 1: Dung javacript truoc khi hover chuot
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", hoverLink);

		Thread.sleep(3000);
		// Hove chuot
//		action.moveToElement(driver.findElement(By.xpath("//img[@alt='User Avatar 05']"))).perform();

		action.moveToElement(hoverLink).perform();

		Thread.sleep(5000);
		
		String abc = hoverLink.getText();
		System.out.println("lay text ra = " + abc);

		Assert.assertEquals(driver.findElement(By.xpath("//h5[text()='Name: User5']")).getText(), "Name: User5");
		Thread.sleep(1000);

	}

	@AfterClass
	public void tearDown() { 
		driver.quit();
	}

}