package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPages extends BasePage {

	public CheckOutPages(WebDriver driver) {
		super(driver);
	} 
	
	@FindBy(css = "[data-test='checkout']")
	WebElement checkoutButton;
	
	@FindBy(css = "[data-test='firstName']")
	WebElement firstNameTextBox;
	
	@FindBy(css = "[data-test='lastName']")
	WebElement lastNameTextBox;
	
	@FindBy(css = "[data-test='postalCode']")
	WebElement postCodeTextBox;
			
	@FindBy(css = "[data-test='continue']")
	WebElement continueButton;
	
	@FindBy(css = "[data-test='finish']")
	WebElement finishButton;
	
	
	
	
	
	public void clickOnCheckOut() {
		checkoutButton.click();
	}
	public void fillForm(String firstName,String lastName,String postalCode)   // MyAccount Page heading display status
	{
		firstNameTextBox.sendKeys(firstName);
		lastNameTextBox.sendKeys(lastName);
		postCodeTextBox.sendKeys(postalCode);
	}
	
	public void clickOnContinue() {
		continueButton.click();
	}
	public void finishShopping() {
		finishButton.click();
	}
	
	
}
