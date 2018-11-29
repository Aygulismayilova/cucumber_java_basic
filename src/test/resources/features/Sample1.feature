Feature: Introduction to cucumber part 1
  As a test engineer
  I want to be able to write and execute a simple scenario

  @part1 @test_two
  Scenario: Simple scenario
    When I am on the home page
    Then I should see home page header
    And I should see home page description
    And i should see menu

  @test_two
  Scenario: My first scenario
    Given I am on action page
      #go to homepage
    When I enter text
      #write text in text box
    And i click the result button
    #click on result button
    Then I see correct result text
    #check result text "text"
