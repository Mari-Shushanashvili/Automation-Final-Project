Feature: Login Functionality of saucedemo.com

  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters valid username and password
    Then User should be redirected to the products page

  Scenario: Failed login with invalid credentials
    Given User is on the login page
    When User enters invalid username "locked_out_user" and password "secret_sauce"
    Then An error message is displayed