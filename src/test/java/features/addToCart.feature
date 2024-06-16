@UAT
Feature: Swag Labs application Demo

  Background:
    Given User should navigate to the application Swag Labs

  @reg
  Scenario Outline: Add a product to the cart
    And User should login as "<username>" and "<password>"
    And User should add the "<product>" to the cart
    Then The cart badge should be updated

    @dev
    Examples:
      | username      | password     | product                  |
      | standard_user | secret_sauce | Sauce Labs Fleece Jacket |
      | standard_user | secret_sauce | Sauce Labs Onesie        |

    @test
    Examples:
      | username      | password     | product                 |
      | standard_user | secret_sauce | Sauce Labs Bolt T-Shirt |
