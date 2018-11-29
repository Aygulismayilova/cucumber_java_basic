Feature: Task 1 scenarios

  @error @task
  Scenario Outline: scenario for error
    Given I am on Enter a number page
    When I enter an input: "<input>"
    And I click submit button
    Then I see error message "<message>"

    Examples:
      | input  | message               |
      | 25     | Number is too small   |
      | 7      | Number is too small   |
      | 125    | Number is too big     |
      | 200    | Number is too big     |
      | hello  | Please enter a number |
      | yyyyy  | Please enter a number |

    @correct @task
    Scenario: scenario for correct number
      Given I am on Enter a number page
      When I enter an input: "76"
      And I click submit button
      Then I see alert message "Square root of 76 is 8.72"
      Then I accept alert window

