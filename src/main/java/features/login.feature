@E2E
Feature: Swag Labs application demo

  Background:
    Given User should navigate to the application

  @smoke @dev_chrome @aut_Syed
  Scenario:Login should be success
    And user should enter the username as "standard_user"
    And User should enter the password as "secret_sauce"
    And User should click the login button
    Then login should be success

  @smoke @reg @dev_chrome @aut_Syed
  Scenario:Login should be fail
    And user should enter the username as "failuser"
    And User should enter the password as "failpass"
    And User should click the login button
    But login should be fail
