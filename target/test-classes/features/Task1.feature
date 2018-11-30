Feature: Task by Svetlana Fadeeva


  @test123
  Scenario Outline: scenario 1
    Given I am on number page
    When I enter number "<number>"
    And press submit
    Then I see error: "<error>"
    Examples:

      | number | error                   |
      | 1      | Number is too small       |
      | 101    | Number is too big         |
      | text     | Please enter a number     |


  @test111
  Scenario: scenario 1
    Given I am on number page
    When I type number: "81"
    And press submit
    Then I see result: "Square root of 81 is 9.00"

