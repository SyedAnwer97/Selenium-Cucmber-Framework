@E2E
Feature: Swag Labs application logout functionality

  Background:
    Given User should navigate to the application

  @smoke @reg @dev_chrome @aut_Syed
  Scenario: Logout from the Swag labs
    And User should login as "standard_user" and "secret_sauce"
    And User should click the hamburger menu button
    And User click the logout button
    And User should logout from Swag Labs