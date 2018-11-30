@regression
Feature: Scenario Task
  I want to be able to write and execute a scenario outline

  @test @debugs
  Scenario Outline: a new scenario outline
    Given I am on 'enter a number' page
    When I enter a number: "<number>"
    And I click submit number
    Then I see error: "<error>"

  @test
    Examples:
      | number | error                 |
      | 23     | Number is too small   |
      | 6      | Number is too small   |
      | 155    | Number is too big     |
      | 230    | Number is too big     |
      | test   | Please enter a number |
      | text   | Please enter a number |

  @test
  Scenario: Correct result
    Given I am on 'enter a number' page
    When I enter a correct number: "69"
    And I click submit number
    Then I see result: "Square root of 69 is 8.31"










