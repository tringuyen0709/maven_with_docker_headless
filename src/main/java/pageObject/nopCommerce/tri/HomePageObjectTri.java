package pageObject.nopCommerce.tri;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerceTri.HomePageUITri;

public class HomePageObjectTri extends BasePage {
	private WebDriver driver;
	
	public HomePageObjectTri(WebDriver _driver) {
		driver = _driver;
//		System.out.println("Driver ID at Page Object Class: " + driver.toString());
		
	}

	public RegisterPageObjectTri clickToRegisterLink() {
		waitForElementClickAble(driver, HomePageUITri.REGISTER_LINK);
		clickToElement(driver, HomePageUITri.REGISTER_LINK);
		return PageGeneratorTri.getRegisterPage(driver);
	}

	public LoginPageObjectTri clickToLoginLink() {
		waitForElementClickAble(driver, HomePageUITri.LOGIN_LINK);
		clickToElement(driver, HomePageUITri.LOGIN_LINK);
		return PageGeneratorTri.getLoginPage(driver);
	}

	public boolean verifyWelcomePageDisplayed() {
		waitForElementVisible(driver, HomePageUITri.SUCCESS_LOGIN_MESSAGE);
		return isElementDisplayed(driver, HomePageUITri.SUCCESS_LOGIN_MESSAGE);
	}

}
