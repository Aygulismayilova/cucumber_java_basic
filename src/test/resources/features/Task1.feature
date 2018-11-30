@test
Feature: create 1 scenario outline and 1 scenario for page
  As a test engineer
  I want to be able to write and execute a scenario outline

  Scenario Outline: enter a number page
    Given I am on number page
    When I enter number: "<number>"
    And I click submit button
    Then I see message "<message>"

    Examples:
     | number | message              |
     | 5      | Number is too small  |
     | 33     | Number is too small  |
     | 122    | Number is too big    |
     | 200    | Number is too big    |
     | test   | Please enter a number|


@test
  Scenario: enter correct number
    Given I am on number page
    When I enter number 55
    And I click submit button
    Then I see correct "Square root of 55 is 7.42"
    Then I see accept alarm message
