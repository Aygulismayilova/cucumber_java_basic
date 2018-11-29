Feature: Task 1
  As a test engineer
  I want to complete this task

  @test1
  Scenario: Simple scenario with number too small
    Given I am on the home page
    When I enter numberS: 27
    And I click submit
    Then I see correct messageS: "Number is too small"

  @test2
  Scenario: Simple scenario with number too big
    Given I am on the home page
    When I enter numberB: 150
    And I click submit
    Then I see correct message with textB: "Number is too big"

  @test3
  Scenario: Simple scenario with text instead of numbers
    Given I am on the home page
    When I enter textT: T
    And I click submit
    Then I see correct message with textT: "Please enter a number"

  @test4
  Scenario: Simple scenario correct numbers
    Given I am on the home page
    When I enter numberT: 64
    And I click submit
    Then I see correct message with textC: "Square root of 64 is 8.00"

  @testOut
  Scenario Outline: a new scenario outline
    Given I am on the home page
    When I enter number: "<number>"
    And I click submit
    Then I see messageT: "<message>"

  @testOutEx
    Examples:
      | number  | message                   |
      | 27      | Number is too small       |
      | 150     | Number is too big         |
      | T       | Please enter a number     |
      | 64      | Square root of 64 is 8.00 |

#For error cases:
#1.1) enter number too small
#1.2) enter number too big
#1.3) enter text intead of the number
#1.4)Enter correct number
#
#
#
#    Given I am on age page
#    When I enter name: "Ann"
#    And I enter age: 5
#    And I click submit age
#    Then I see message: "Hello, Ann, you are a kid"