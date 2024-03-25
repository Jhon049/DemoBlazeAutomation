# new feature
# Tags: optional

Feature: Demo blaze regression test

  As a final user
  I want to test the principal features in the system
  So we can validate the functionality of the system

  Scenario: LogIn With Existing User
    Given User is in home page
    When User login in system
    Then User verifies that is logged into system

  Scenario: LogIn with a No-Existing User
    Given User is in home page
    When User tries to make LogIn with No Existing User
    Then User verifies that not exist in system