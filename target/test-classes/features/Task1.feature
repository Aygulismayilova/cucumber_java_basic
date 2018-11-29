@task1
Feature: Task1
  Make scenario and scenario outline, where number is too big, too small, and is entered
  instead a number. And also input correct number
  Scenario: scenario1
    Given I am on number page
    When I enter number 50
    And press submit
    Then alert Message should appear "Square root of 50 is 7.07"





  Scenario Outline: scenario 1
    Given I am on number page
    When I enter number "<errorNumbers>"
    And press submit
    Then error message should appear "<errorMessage>"

    Examples:
    |errorNumbers|errorMessage          |
    |48          |Number is too small   |
    |101         |Number is too big     |
    |number      |Please enter a number |

