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
  Scenario: My second scenario
    Given I am on act page
    # go to https://kristinek.github.io/site/examples/actions
    When I enter "hello" text
    # enter any text in the text box "hello"
    And I click the result
     # click on result button
    Then I see correct result with text "hello"
    # check the result is "hello"

  @test
  Scenario: My bonus scenario
    Given I am on act page
    # go to https://kristinek.github.io/site/examples/actions
    When I enter number 5
    And I click the result
    Then I see correct result text with number 5
    # check the result is "hello"