package com.nopcommerce.tri;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;


@Test
public class Level_3_Practice_Automation extends BaseTest {

	WebDriver driver;
	WebDriverWait explicitWait; 
	
	
	@BeforeClass
	public void beforeClass() {
		
		Log log;
		log = LogFactory.getLog(getClass());
		
		log.info("debug 111");

//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//		WebDriverManager.firefoxdriver().driverVersion("0.33.0").setup();		
		
//		driver = new FirefoxDriver(firefoxOptions);
		
//		WebDriverManager.firefoxdriver().driverVersion("0.33.0").setup();
		
		
//		FirefoxOptions firefoxOptions = new FirefoxOptions();
//		WebDriverManager.firefoxdriver().driverVersion("0.33.0").setup();
//		driver = new FirefoxDriver(firefoxOptions);
		
		
		
		
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//		WebDriverManager.firefoxdriver().driverVersion("0.33.0").setup();			
//		driver = new FirefoxDriver(firefoxOptions);
		
		
		
		
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");          // chạy không giao diện
        chromeOptions.addArguments("--disable-gpu");       // thường dùng cho Windows
        chromeOptions.addArguments("--window-size=1920,1080");

		
		
		
		
		WebDriverManager.chromedriver().setup();
		
//		driver = DriverManager.getDriver();
//		driver = new ChromeDriver();
		driver = new ChromeDriver(chromeOptions);
		driver.get("http://tuoitre.vn");
		
//		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		
	}
	
	
//	@Test 
	public void dropdownDefault() throws InterruptedException {
		Select select;
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu");
		Thread.sleep(1000);		
		
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[test()='user']")));

		select = new Select(driver.findElement(By.xpath("//select")));
		select.selectByVisibleText("Viet Nam");
		
	}
	
//	@Test
	public void dropdownCustom() throws InterruptedException {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//span[text()='Medium']")).click();
		
		Thread.sleep(2000);
		List<WebElement> items = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		
		for (WebElement item : items) {
			System.out.println("Cac item = " + item);
			
			if (item.getText().equals("Faster")) {
				item.click();
				Thread.sleep(2000);
				break;
			}
		}
		
	}
	
	
//	@Test
	public void alert() throws InterruptedException {
		Alert alert;
		WebDriverWait explicitWait;
		explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
		
		alert = driver.switchTo().alert();
		explicitWait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		alert.accept();
		
		
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		explicitWait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(4000);
		alert.dismiss();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		explicitWait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(4000);
		alert.sendKeys("Yes Yes");
		
		
		
		
		
		

		
		
		
	}
	
//	@Test
	public void userInteraction1() throws InterruptedException {
		// Hover chuột
		Actions action;
		action = new Actions(driver);
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		Thread.sleep(10000);
		
		// Cach 1: Dung javacript truoc khi hover chuot
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement(By.xpath("//img[@alt='User Avatar 05']")));
	
		// Hove chuot
		action.moveToElement(driver.findElement(By.xpath("//img[@alt='User Avatar 05']"))).perform();
		
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//h5[text()='Name: User5']")).getText(), "Name: User5");
	}
	
//	@Test
	public void userInteraction2() throws InterruptedException {
		// Double click
		Actions action;
		action = new Actions(driver);
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		Thread.sleep(10000);
		
		// Cach 1: Dung javacript truoc khi hover chuot
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", driver.findElement(By.xpath("//button[text()='Double click me']")));
		Thread.sleep(2000);
		
		action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
		
		Assert.assertEquals(driver.findElement(By.xpath("//p[text()='Hello Automation Guys!']")).getText(), "Hello Automation Guys!");
		
		Thread.sleep(2000);
		action.contextClick().perform();
		
		Thread.sleep(3000);
		
		
		// Keys.UP, Keys.DOWN
		action.keyDown(Keys.CONTROL).sendKeys("A").perform();
		
		Thread.sleep(5000);
	}
	
//	@Test
	public void clickAndHold() throws InterruptedException {
		// Click and Hold
		Actions action;
		
		driver.get("https://jqueryui.com/resources/demos/selectable/display-grid.html");
		Thread.sleep(3000);
		action = new Actions(driver);
		
		WebElement element_1 = driver.findElement(By.xpath("//li[text()='1']"));
		WebElement element_2 = driver.findElement(By.xpath("//li[text()='4']"));
		action.clickAndHold(element_1).moveToElement(element_2).release().perform();
		Thread.sleep(3000);
	}
	
	
//	@Test
	public void dragAndDrop() throws InterruptedException {
		Actions action;
		driver.get("https://automationfc.github.io/drag-drop-html5");
		Thread.sleep(3000);
		
		action = new Actions(driver);
		
		WebElement element_1 = driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement element_2 = driver.findElement(By.xpath("//div[@id='column-b']"));
		
		action.dragAndDrop(element_1, element_2).perform();
		Thread.sleep(3000);
		
	}
	
//	@Test
	public void iFrame() throws InterruptedException {
		driver.get("https://testing.qaautomationlabs.com/iframe.php");
		Thread.sleep(3000);
		
		WebElement element_1 = driver.findElement(By.xpath("//iframe[@name='iframe1']"));
		
		driver.switchTo().frame(element_1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='CLick Me']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();
		Assert.assertEquals(driver.findElement(By.xpath("//p[@id='message']")).getText(), "You have clicked on iframe 1 button");
		Thread.sleep(3000);
	}
	
//	@Test
	public void shadow() throws InterruptedException {
		
		driver.get("https://testing.qaautomationlabs.com/shadow-dom.php");
		Thread.sleep(2000);
		
		WebElement shadowHost = driver.findElement(By.cssSelector("#shadow-host"));
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement elementInside = (WebElement) js.executeScript("return arguments[0].shadowRoot.querySelector('.box')", shadowHost);
		
//		SearchContext shadowRoot = shadowHost.getShadowRoot();
//		WebElement elementInside = shadowRoot.findElement(By.cssSelector(".box"));
		
		Assert.assertEquals(elementInside.getText(), "Hello from Shadow DOM!");
		
		System.out.println("Lay ra text = " + elementInside.getText());
	}
	
	
	@Test
	public void Window() throws InterruptedException { 
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		Thread.sleep(1000);
		String home = driver.getWindowHandle();
		System.out.println("ID CUA HOME : " + home);
		
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
		Thread.sleep(10000);
		
		Set<String> windowID = driver.getWindowHandles();
		
		for (String id : windowID) {
			driver.switchTo().window(id);
			String url = driver.getCurrentUrl();
			System.out.println("URL trang hien tai = " + url);
		}
	}
	
	
	//@Test
	public void uploadFile() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
		uploadFile.sendKeys("/abc/xxx.jmg");
		
		
		
		driver.getCurrentUrl();
		
		
	}
	
//	@Test (enabled = true)
//	@Parameters({"browser"})
//	@Test (enabled = true)

	@AfterClass
	public void afterClass() {
		log.info("Post-Condition: Close browser");
		driver.quit();

	}

}