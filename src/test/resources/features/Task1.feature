Feature: Introduction to cucumber part 1
  As a test engineer
  I want to be able to write and execute a simple scenario



  Scenario Outline: my second first scenario
    Given  I am on new action page
    When  I enter number "<number>"
    And I click the submit button
    Then I see my correct result text "<string>"
    Examples:
      | number | string                |
      | 20     | Number is too small   |
      | 200    | Number is too big     |
      | asd    | Please enter a number |

  Scenario: my second scenario
    Given  I am on new action page
    When  I enter number "64"
    And I click the submit button
    Then I see  the exact error message