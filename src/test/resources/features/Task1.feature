@regression
Feature: blabla




  @debugs
Scenario Outline: a new scenario for error cases
    Given I am on enterNumber page
    When I enter number in Number page: "<number>"
    And I click submit number
    Then I see correct result text Notification: "<message>"

Examples:
  | number | message                |
  | 5      | Number is too small    |
  | 5878   | Number is too big      |
  | mehd   | Please enter a number  |

@second
  Scenario: Scenario for correct number
    Given I am on enterNumber page
    When I enter number in Number page: "81"
    And I click submit number
    Then Accept the alert: "Square root of 81 is 9.00"
