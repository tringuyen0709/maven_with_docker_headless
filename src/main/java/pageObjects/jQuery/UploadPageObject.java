package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.UploadPageUI;

public class UploadPageObject extends BasePage {
	
	WebDriver driver;
	
	public UploadPageObject(WebDriver _driver) {
		driver = _driver;
	}
	
	
	public void uploadFiles(String... fileNames) {
		
		uploadMultipleFiles(driver, UploadPageUI.UPLOAD_FILE, fileNames);
		
	}


	public void clickToStartButtonByFileName(String... fileNames) {		
		waitForElementClickAble(driver, UploadPageUI.START_BUTTON, fileNames);		
		clickToElement(driver, UploadPageUI.START_BUTTON, fileNames);	
	}


	public boolean isFileNameLoadedSuccess(String... fileNames) {
		waitForElementVisible(driver, UploadPageUI.FILE_NAME, fileNames);
		return isElementDisplayed(driver, UploadPageUI.FILE_NAME, fileNames);
	}


	public boolean isFileUploadedSuccess(String... fileNames) {
		waitForElementVisible(driver, UploadPageUI.DELETE_BUTTON, fileNames);
		return isElementDisplayed(driver, UploadPageUI.DELETE_BUTTON, fileNames);
	}

}
