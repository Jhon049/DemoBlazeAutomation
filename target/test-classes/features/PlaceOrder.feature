Feature: Place Order Demo blaze

  As a final user
  I want to test the principal features in the system
  So we can validate the functionality of the system

  @PlaceOrder
  Scenario: User place order successfully
    Given User access into home page
    When User completes the purchase process
    Then User validates success purchase

  @PlaceOrder
  Scenario: User place order without mandatory information
    Given User access into home page
    When User tries to complete purchase process without information
    Then User validates is not possible place order without information