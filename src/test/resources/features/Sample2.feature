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

  @test
  Scenario: my second scenario
    Given I am on action page
    When I enter text "hello" in Text box
    And I click the result button
    Then I see correct result text: "hello"

  @test
  Scenario: my second 2 scenario
    Given I am on action page
    When I enter number 5
    And I click the result number button
    Then I see correct result number text: 5