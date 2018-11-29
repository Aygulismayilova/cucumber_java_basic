@regression
Feature: Introduction to cucumber part 2
  As a test engineer
  I want to be able to write and execute a scenario with parameters
  @test
  Scenario: a new scenario 1 with regex
    Given I am on a
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

  @test_two
  Scenario: My second scenario
    Given I am on action page
      #go to homepage
    When I enter "asdf" text
      #write text in text box
    And i click the result button
    #click on result button
    Then I see correct result text "asdf"
    #check result text "text"

