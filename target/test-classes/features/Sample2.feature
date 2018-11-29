Feature: Introduction to cucumber part 2
  As a test engineer
  I want to be able to write and execute a scenario with parameters

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

  @testTwo
  Scenario: My second scenario 1
    Given I am on actions page
    When I enter "abcd" text
    And I click the result button
    Then I see correct result with text "abcd"

  @testTwo
  Scenario: My second scenario 2
    Given I am on actions page
    When I enter number 5
    And I click the result number button
    Then I see correct result with number 5
