@regression
Feature: Introduction to cucumber part 2
  As a test engineer
  I want to be able to write and execute a scenario with parameters

  @test
  Scenario: a new scenario 1 with regex
    Given I am on age page
    When I enter name: "Ann"
    And I enter age: 5
    And I click submit age
    Then I see message: "Hello, Ann, you are a kid"

  @test
  Scenario: a new scenario 2 with regex
    Given I open age page
    When I enter name: "Bob"
    And I enter age: 61
    And I click submit age
    Then I see message: "Hello, Bob, you are an adult"

  @test
  Scenario: my second scenario
    Given I am on action page
    When I enter text "enterText" into text field
    And I click the result button
    Then I see correct result text with text "text"

  @bug #"@test3,~@bug"

  @test
  Scenario: my second scenario
    Given I am on action page
    When I enter number 5
    And I click the result button
    Then I see correct result text with text 5

  @test3
  Scenario Outline: my third scenario
    Given I am on action page
    When I enter text "<enterText>" into text field
    And I click the result button
    Then I see correct result text with text "<text>"
  @bug #"@test3,~@bug"
    Examples:
      | enterText | text |
      | Ann       | Ann  |

    Examples:
      | enterText | text  |
      | Marry     | Marry |
      | Bob       | Bob   |

  @test4
  Scenario Outline: my third scenario
    Given I am on action page
    When I enter number <number>
    And I click the result button
    Then I see correct result text with text <resultNumber>

  @working
    Examples:
      | number | resultNumber |
      | 5      | 5            |
      | 50     | 50           |
      | 61     | 61           |

