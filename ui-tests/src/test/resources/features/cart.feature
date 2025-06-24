Feature: Shopping Cart Functionality

  Scenario: User adds a product to the cart
    Given The user is logged in
    When The user adds a product to the cart
    And The user navigates to the cart page
    Then The product should be visible in the cart


  Scenario: User logs out successfully
    Given The user is logged in
    When The user logs out
    Then The user should be returned to the login page


  Scenario: User removes a product from the cart
    Given The user is logged in and has a product in the cart
    When The user removes the product from the cart
    Then The cart should be empty