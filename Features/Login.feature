Feature: Login with Valid Credentials

  @sanity @regression
  Scenario: Successful Login with Valid Credentials
    Given User Launch browser
    And opens URL "https://www.saucedemo.com/"
    And User enters Email as "standard_user" and Password as "secret_sauce"
    And Click on Login button
    Then User navigates to MyAccount Page
