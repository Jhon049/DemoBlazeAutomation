Feature: Product Store Demo blaze

  As a final user
  I want to test the principal features in the system
  So we can validate the functionality of the system

  @Product
  Scenario: Select Samsung Galaxy S6
    Given Existing user is in home Page
    When The User selects A product In Phones tab
    Then User validates that phone is in cart

  @Product
  Scenario: Select laptop product
    Given Existing user is in home Page
    When The User selects a product in laptops tab
    Then User validates laptop is in cart