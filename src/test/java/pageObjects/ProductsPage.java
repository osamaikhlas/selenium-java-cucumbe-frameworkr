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
	
	
	@FindBy(css = "[data-test='add-to-cart-sauce-labs-backpack']")
	WebElement addBackPack;
	
	@FindBy(css = "[data-test='remove-sauce-labs-backpack']")
	WebElement removeBackPack;
	
	@FindBy(css = "[data-test='add-to-cart-sauce-labs-bike-light']")
	WebElement addLight;
	
	@FindBy(css = "[data-test='remove-sauce-labs-bike-light']")
	WebElement removeLight;
	
			
	@FindBy(css = "[class='shopping_cart_link']")
	WebElement cartButton;

	public boolean isProductPageExists()   // MyAccount Page heading display status
	{
		try {
			return (productHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
	
	public void addProducts() {
		addBackPack.click();
		addLight.click();
	}
	
	public void removeProducts() {
		
		removeLight.click();

	}
	
	public void clickOnCart() {
		cartButton.click();
	}

	
	
}
