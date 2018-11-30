

Feature: Introduction to cucumber part 1




Scenario Outline: my first scenario
Given I am on enter a number page
  When I enter number <number>
  And I click the result button
Then I see message: "<string>" using PO
  Examples:

  | number| string                  |
  | 12    | Number is too small     |
  | 508   |  Number is too big      |
  | text  | Please enter a number   |

  Scenario: for correct number
    Given I am on enter a number page
    When I enter number "68"
    And I click the result button
    Then I see correct result with text



