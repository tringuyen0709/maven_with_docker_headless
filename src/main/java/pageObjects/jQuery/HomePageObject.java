package pageObjects.jQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingPageByName(String pageName) {
		waitForElementClickAble(driver, HomePageUI.PAGING_LINK_BY_NUMBER, pageName);
		clickToElement(driver, HomePageUI.PAGING_LINK_BY_NUMBER, pageName);
		sleepInSecond(3);
	}

	public boolean isPageActiveByName(String pageName) {
		waitForElementVisible(driver, HomePageUI.PAGING_LINK_ACTIVE_BY_NUMBER, pageName);
		return isElementDisplayed(driver, HomePageUI.PAGING_LINK_ACTIVE_BY_NUMBER, pageName);
	}

	public void enterToHeaderTextBoxByName(String headerName, String value) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, headerName);
		sendKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, value, headerName);
		sendKeyBoardToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_NAME, Keys.ENTER, headerName);
	}

	public boolean isRowValuesDisplayed(String female, String country, String male, String total) {
		waitForElementVisible(driver, HomePageUI.ROW_BY_ALL_VALUES, female, country, male, total);		
		return isElementDisplayed(driver, HomePageUI.ROW_BY_ALL_VALUES, female, country, male, total);
	}

	public void clickToRowActionByCountry(String country, String actionName) {
		waitForElementClickAble(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_AND_NAME, country, actionName);
		clickToElement(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_AND_NAME, country, actionName);
		
	}

	public void enterToHeaderTextBoxAtCollumnNameAndRowNumber(String columnName, String rowNumber, String textboxValue) {
		waitForElementVisible(driver, HomePageUI.COLLUMN_NAME_POSITION, columnName);
		String  columnNamePosition = String.valueOf(getElementSize(driver, HomePageUI.COLLUMN_NAME_POSITION, columnName) + 1);
		waitForElementVisible(driver, HomePageUI.TEXTBOX_AT_COLLUMN_NAME_AND_ROW_NUMBER, rowNumber, columnNamePosition);
		sendKeyToElement(driver, HomePageUI.TEXTBOX_AT_COLLUMN_NAME_AND_ROW_NUMBER, textboxValue, rowNumber, columnNamePosition);
	}

	public void selectDropdownAtColumnNameAndRowNumber(String columnName, String rowNumber, String dropdownItem) {
		waitForElementVisible(driver, HomePageUI.COLLUMN_NAME_POSITION, columnName);
		String  columnNamePosition = String.valueOf(getElementSize(driver, HomePageUI.COLLUMN_NAME_POSITION, columnName) + 1);
		
		waitForElementClickAble(driver, HomePageUI.DROPDOWN_AT_COLLUMN_NAME_AND_ROW_NUMBER, rowNumber, columnNamePosition);
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_AT_COLLUMN_NAME_AND_ROW_NUMBER, dropdownItem, rowNumber, columnNamePosition);
		
	}

	public void clickToIconButtonAtRowNumber(String rowNumber, String iconName) {
		waitForElementClickAble(driver, HomePageUI.ICON_ACTION_AT_ROW, rowNumber, iconName);
		clickToElement(driver, HomePageUI.ICON_ACTION_AT_ROW, rowNumber, iconName);
	}

}
