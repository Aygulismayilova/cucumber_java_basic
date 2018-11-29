@regression
Feature: Introduction to cucumber part 3
  As a test engineer
  I want to be able to write and execute a scenario outline

  @debugs
  Scenario Outline: a new scenario outline
    Given I am on age page
    When I enter name: "<name>"
    And I enter age: <age>
    And I click submit age
    Then I see message: "<message>"
  @working
    Examples:
      | name  | age | message                        |
      | Ann   | 5   | Hello, Ann, you are a kid      |
      | Marry | 50  | Hello, Marry, you are an adult |
      | Bob   | 61  | Hello, Bob, you are an adult   |
  @not_working
    Examples:
      | name | age | message                   |
      | Tom  | 15  | Hello, Tom, you are a kid |


  Scenario Outline: my third scenario
    Given I am on action page
    When I enter text "<text>" in Text box
    And I click the result button
    Then I see correct result text: "<text>"

    Examples:
    | text      |
    | Hi, guys  |
    | more text |
    | find me   |
  @scenario
    Examples:
    | text    |
    | kkkkkkk |