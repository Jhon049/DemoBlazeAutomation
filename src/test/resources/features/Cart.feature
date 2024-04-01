Feature: Cart Demo blaze

  As a final user
  I want to test the principal features in the system
  So we can validate the functionality of the system

  @Cart
  Scenario: User puts elements in cart
    Given An Existing User access to home page
    When User puts items into the cart
    Then User validates cart is not empty

  @Cart1
  Scenario: User deletes element in cart
    Given An Existing User access to home page
    When User puts items into the cart
    Then User deletes and validates the item is not longer into cart