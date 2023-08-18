# selenium-java-cucumbe-frameworkr

#clone the project

#go to src/test/java/testRunner/TestRunner.java

#Right Click and Run as JunitTest

#if chrome driver commpatibility issue occured

#update this file src/test/java/stepDefinitions/steps.java


#update following method and set chromedriver path and add chromedriver path accordingly 
<!--- just 
@Given("User Launch browser")	
    public void user_launch_browser() {
        if(br.equals("chrome"))
        {	
--->        
#System.setProperty("webdriver.chrome.driver", "exact path to your chromedriver"); //This line needs to be added in user_launch_browser()
<!---
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
  --->
        
