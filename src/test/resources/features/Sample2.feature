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

  @test1 @test
  Scenario: My second scenario
    Given I am on action page
    When I enter "This is a text" text
    And I click the result button
    Then I see correct result with text "This is a text"

  @test1 @test
  Scenario: My second scenario bonus
    Given I am on action page
    When I enter number 5
    And I click the number result button
    Then I see correct result with number 5