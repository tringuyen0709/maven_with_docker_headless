package pageObject.nopCommerce.tri;

import org.openqa.selenium.WebDriver;

public class PageGeneratorTri {

	public static HomePageObjectTri getHomePage(WebDriver driver) {
		
		return new HomePageObjectTri(driver);
	}
	
	public static RegisterPageObjectTri getRegisterPage(WebDriver driver) {

		return new RegisterPageObjectTri(driver);
	}
	
	public static LoginPageObjectTri getLoginPage(WebDriver driver) {

		return new LoginPageObjectTri(driver);
	}


}
