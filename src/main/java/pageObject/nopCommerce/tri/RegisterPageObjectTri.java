package pageObject.nopCommerce.tri;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerceTri.RegisterPageUITri;

public class RegisterPageObjectTri extends BasePage {
	private WebDriver driver;
	
	public RegisterPageObjectTri(WebDriver _driver) {
	driver =_driver;
	}

	public void clickToGenderMaleRadio() {
		waitForElementClickAble(driver, RegisterPageUITri.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUITri.GENDER_MALE_RADIO);
	}

	public void enterToFirstNameTextBox(String firstNameTri) {
		waitForElementVisible(driver, RegisterPageUITri.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUITri.FIRST_NAME_TEXTBOX, firstNameTri);
		
	}

	public void enterToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, RegisterPageUITri.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUITri.LAST_NAME_TEXTBOX, lastName);
	}

	public void selectDayDropdown(String day) {
		waitForElementVisible(driver, RegisterPageUITri.DATE_DROPDOWN);
		selectItemInDefaultDropdown(driver, RegisterPageUITri.DATE_DROPDOWN, day);	
	}
	
	public void selectMonthDropdown(String month) {
		waitForElementVisible(driver, RegisterPageUITri.MONTH_DROPDOWN);
		selectItemInDefaultDropdown(driver, RegisterPageUITri.MONTH_DROPDOWN, month);	
	}
	
	public void selectYearDropdown(String year) {
		waitForElementVisible(driver, RegisterPageUITri.YEAR_DROPDOWN);
		selectItemInDefaultDropdown(driver, RegisterPageUITri.YEAR_DROPDOWN, year);	
	}

	public void enterToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUITri.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUITri.EMAIL_TEXTBOX, emailAddress);
		
	}

	public void enterToCompanyTextBox(String companyName) {
		waitForElementVisible(driver, RegisterPageUITri.COMPANY_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUITri.COMPANY_TEXTBOX, companyName);
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(driver, RegisterPageUITri.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUITri.PASSWORD_TEXTBOX, password);
	}

	public void enterToConfirmTextBox(String password) {
		waitForElementVisible(driver, RegisterPageUITri.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUITri.CONFIRM_PASSWORD_TEXTBOX, password);
	}

	public void clickToRegisterButon() {
		waitForElementClickAble(driver, RegisterPageUITri.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUITri.REGISTER_BUTTON);
		
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUITri.SUCCESS_REGISTER_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUITri.SUCCESS_REGISTER_MESSAGE);
	}

	public HomePageObjectTri clickToLogout() {
		waitForElementClickAble(driver, RegisterPageUITri.LOGOUT_BUTTON);
		clickToElement(driver, RegisterPageUITri.LOGOUT_BUTTON);
		return PageGeneratorTri.getHomePage(driver);
	}


	




}
