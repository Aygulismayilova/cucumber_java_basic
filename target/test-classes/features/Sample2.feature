Feature: Introduction to cucumber part 2
  As a test engineer
  I want to be able to write and execute a scenario with parameters


  Scenario: a new scenario 1 with regex
    Given I am on age page
    When I enter name: "Ann Tomson"
    And I enter age: 5
    And I click submit age
    Then I see message: "Hello, Ann, you are a kid"

  Scenario: a new scenario 2 with regex
    Given I open age page
    When I enter name: "Bob"
    And I enter age: 61
    And I click submit age
    Then I see message: "Hello, Bob, you are an adult"


  Scenario: My second scenario
    Given I am on action page
      # go to https://kristinek.github.io/site/examples/actions
    When  I enter "asdf" text
      # enter text in text box
    And I click result button
    Then I see correct result with text "asdf"


  Scenario: My third scenario
    Given I am on action page
      # go to https://kristinek.github.io/site/examples/actions
    When  I enter number 5
      # enter text in text box
    And I click result number button
    Then I see correct result with text 5
