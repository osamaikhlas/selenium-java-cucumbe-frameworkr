Feature: Ecommerce End to End Flow

  @sanity @regression
  Scenario: Successful Login with Valid Credentials
    Given User Launch browser
    And opens URL "https://www.saucedemo.com/"
    And User enters Email as "standard_user" and Password as "secret_sauce"
    And Click on Login button
    And Navigate to Prdouct Page
    And Add some Products
    And Remove a Product
    And Click on Cart button
    And Click on Checkout button
    And Fillout the Checkout form First Name as "Ossama" Last Name as "Ikhlas" and Zip/PostalCode as "75980"
    And Click on Coninue button
    And Click on Finish button
    Then Logout 
