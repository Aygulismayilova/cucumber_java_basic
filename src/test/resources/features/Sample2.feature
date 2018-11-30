Feature: Introduction to cucumber part 2
  As a test engineer
  I want to be able to write and execute a scenario with parameters


  Scenario: my first scenario
    Given I am on action page
    When I enter "TEST" text
    And I click the result button
    Then I see correct result with text "TEST"

  @test
  Scenario: my first scenario
    Given I am on action page
    When I enter a number 5
    And I click the age esult button
    Then I see correct result with text 5

  Scenario: a new scenario 1 with regex
    Given I am on age page
    When I enter name: "Ann"
    And I enter age: 5
    And I click submit age
    Then I see message: "Hello, Ann, you are a kid"

  Scenario: a new scenario 2 with regex
    Given I open age page
    When I enter name: "Bob"
    And I enter age: 61
    And I click submit age
    Then I see message: "Hello, Bob, you are an adult"
