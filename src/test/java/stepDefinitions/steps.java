package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckOutPages;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.ProductsPage;



public class steps {
     WebDriver driver;
     LoginPage lp;
     ProductsPage pp;
     CheckOutPages cop;
     LogoutPage lop;

     List<HashMap<String, String>> datamap; //Data driven

     public Logger logger; //for logging
     public ResourceBundle rb; // for reading properties file
     public String br; //to store browser name



    @Before
    public void setup() throws IOException    //Junit hook - executes once before starting
    {
        //for logging
        logger= LogManager.getLogger(this.getClass());
        
        File src = new File(".//resources//config.properties");
		FileInputStream fis = new FileInputStream(src);
		Properties pro = new Properties();
		pro.load(fis);
		br = pro.getProperty("browser");
       
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Scenario status ======>"+scenario.getStatus());
        if(scenario.isFailed()) {
             byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenario.getName());
            }
       driver.quit();
    }

    @Given("User Launch browser")	
    public void user_launch_browser() {
        if(br.equals("chrome"))
        {       
           driver=new ChromeDriver();
        }
        else if (br.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (br.equals("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Given("opens URL {string}")
    public void opens_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String pwd) {
    	lp=new LoginPage(driver);
         
    	lp.setEmail(email);
        logger.info("Provided Email ");
        lp.setPassword(pwd);
        logger.info("Provided Password ");
    }

    @When("Click on Login button")
    public void click_on_login_button() {
        lp.clickLogin();
        logger.info("Clicked on Login button");
    }

    
    @Given("Navigate to Prdouct Page")
    public void navigate_to_prdouct_page() {
    	pp=new ProductsPage(driver);
		boolean targetpage=pp.isProductPageExists();
	
        if(targetpage)
        {
            logger.info("Login Success ");
            Assert.assertTrue(true);
        }
        else
        {
            logger.error("Login Failed ");
            Assert.assertTrue(false);
        }
       
    }

    @Given("Add some Products")
    public void add_some_products() {
    	pp.addProducts();
        
    }

    @Given("Remove a Product")
    public void remove_a_product() {
        pp.removeProducts();
    }

    @Given("Click on Cart button")
    public void click_on_cart_button() {
    	pp.clickOnCart();
    	cop = new CheckOutPages(driver);
        
    }

    @Given("Click on Checkout button")
    public void click_on_checkout_button() {
    	cop.clickOnCheckOut();
      
    }
    
    @Given("Fillout the Checkout form First Name as {string} Last Name as {string} and Zip\\/PostalCode as {string}")
    public void fillout_the_checkout_form_first_name_as_last_name_as_and_zip_postal_code_as(String string, String string2, String string3) {
        cop.fillForm(string, string2, string3);

    }

    
    @Given("Click on Coninue button")
    public void click_on_coninue() {
        cop.clickOnContinue();
    }

    @Given("Click on Finish button")
    public void click_on_finish_button() {
       cop.finishShopping();
       lop = new LogoutPage(driver);
       
    }

    @Then("Logout")
    public void logout() {
    	lop.clickLogout();
    }

}
