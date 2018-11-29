@testTask
Feature: Task 1 by Olga

  @testTask1
  Scenario Outline: my task1 scenario
    Given I am on enter a number page
    When I enter number "<myNumber>"
    And I click the submit button
    Then I see error message text "<error>"
  @bug
    Examples:
      | myNumber | error                 |
      | 1        | Number is too small   |
      | 200      | Number is too big     |
      | text     | Please enter a number |

  @testTask2
  Scenario: my second task1 scenario
    Given I am on enter a number page
    When I enter number 55
    And I click the submit button
    Then I see result is "Square root of 55 is 7.42"
