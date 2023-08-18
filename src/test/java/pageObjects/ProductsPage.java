package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class='title']") // MyAccount Page heading
	WebElement productHeading;
	
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	WebElement menuButton;
	
	@FindBy(css = "[id='logout_sidebar_link']")
	WebElement logoutButton;
	

	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (productHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickLogout() {
		menuButton.click();
		logoutButton.click();
		

	}
	
}
