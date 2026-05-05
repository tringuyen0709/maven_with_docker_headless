package com.nopcommerce.tri;

import java.time.Duration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commons.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Level_4_Practice_Automation_Cucumber extends BaseTest {

	WebDriver driver;
	Actions action;
	WebDriverWait explicitWait; 
	
	
	@Given("user is on login page with user = {string} and pass = {string}")
	public void openWebPage(String name, String pass) throws InterruptedException {
		// Hover chuột
		Log log;
		log = LogFactory.getLog(getClass());
		
		log.info("debug 111");
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://automationfc.github.io/basic-form/index.html");
//		explicitWait = new WebDriverWait(driver, 30);
		
		System.out.println("username = " + name + " and pass = " + pass);

		driver.get("https://automationfc.github.io/basic-form/index.html");
	}
		
	@When("user enters username and password")
	public void hoverChuot() throws InterruptedException {
		
		action = new Actions(driver);
		Thread.sleep(1000);
		
		// Cach 1: Dung javacript truoc khi hover chuot
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement(By.xpath("//img[@alt='User Avatar 05']")));
	
		Thread.sleep(1000);
		// Hove chuot
		action.moveToElement(driver.findElement(By.xpath("//img[@alt='User Avatar 05']"))).perform();
		
	}
	
	@Then("user is redirected to homepage") 
	public void verify() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.xpath("//h5[text()='Name: User5']")).getText(), "Name: User5");
		Thread.sleep(1000);
	}
	
	
	@After
	public void tearDown() {
	    driver.quit();
	}

}