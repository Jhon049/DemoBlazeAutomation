# new feature
# Tags: optional

Feature: Demo blaze regression test

  As a final user
  I want to test the principal features in the system
  So we can validate the functionality of the system

  Scenario: Create New USer
    Given User is in home page
    When User makes registration
    Then User successfully sign up

  Scenario: Create a pre existing user
    Given User is in home page
    When User tries to make a registration with an existing name user
    Then System indicates that the user exists