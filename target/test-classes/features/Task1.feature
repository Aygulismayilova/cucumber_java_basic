

Feature: Cucumber Task 1: scenario outline and scenario


  @Task1
  Scenario Outline: Task 1 Scenario
    Given I am on enter a number page
    When I enter a number: "<number>"
    And I click submit number
    Then I see an error: "<error>"

    Examples:
      | number | error   |
      | 5      | small   |
      | 1000   | big     |
      | Text   | Text    |


  @Task2
  Scenario: Task 1 Scenario: Number is correct
    Given I am on enter a number page
    When I enter a number: "64"
    And I click submit number
    Then I see popup message
    And I close the popup