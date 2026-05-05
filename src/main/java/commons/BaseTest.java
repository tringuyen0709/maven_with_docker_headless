package commons;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driver;
	protected final Log log;

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName, String url) {
		Browser browser = Browser.valueOf(browserName.toUpperCase());

		switch (browser) {
		case FIREFOX:
//			WebDriverManager.firefoxdriver().setup();
//			System.setProperty("webdriver.gecko.driver", "E:\\SELENIUM\\repo\\maven_project\\browserDrivers\\geckodriver.exe");
			
			// Chay headless => Ko hien giao dien GUI
	        FirefoxOptions firefoxOptions = new FirefoxOptions();
//	        firefoxOptions.addArguments("--headless");          // chạy không giao diện
//	        firefoxOptions.addArguments("--disable-gpu");       // thường dùng cho Windows
			WebDriverManager.firefoxdriver().driverVersion("0.33.0").setup();			
			driver = new FirefoxDriver(firefoxOptions);
			break;
		case CHROME:
//			WebDriverManager.chromedriver().driverVersion("131.0.6778.204").setup();
//			System.setProperty("webdriver.chrome.driver", "E:\\SELENIUM\\repo\\maven_project\\browserDrivers\\chromedriver.exe");
			
			WebDriverManager.chromedriver().setup();
			// Chay headless => Ko hien giao dien GUI
	        ChromeOptions chromeOptions = new ChromeOptions();
//	        chromeOptions.addArguments("--headless");          // chạy không giao diện
//	        chromeOptions.addArguments("--disable-gpu");       // thường dùng cho Windows
//	        chromeOptions.addArguments("--window-size=1920,1080");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);			
			break;
		case COCCOC:
			WebDriverManager.chromedriver().driverVersion("81.0.4196.37").setup();
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files (x86)\\CocCoc\\Browser\\Application\\browser.exe");
			driver = new ChromeDriver(options);
			break;
		case OPERA:
			WebDriverManager.operadriver().setup();
//			driver = new OperaDriver();
			break;
		default:
			throw new RuntimeException("Browser name is not correct!");
		}
	
		driver.get(url);
			
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	public WebDriver getWebDriver() {
		return this.driver;
	}

	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}
	
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}


@BeforeTest
	public void deleteAllFilesInReportNGScreenshot() {
		log.info("---------- START delete file in folder ----------");
		try {
			String workingDir = System.getProperty("user.dir");
			String pathFolderDownload = workingDir + "\\screenshotReportNG";
			File file = new File(pathFolderDownload);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
			
		log.info("---------- END delete file in folder ----------");
	}

}
