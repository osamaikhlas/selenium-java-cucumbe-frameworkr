package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {
		super(driver);
	} 
	
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	WebElement menuButton;
	
	@FindBy(css = "[id='logout_sidebar_link']")
	WebElement logoutButton;
	
	public void clickLogout() {
		menuButton.click();
		logoutButton.click();
		

	}

}
