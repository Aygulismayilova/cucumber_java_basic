Feature: Introduction to cucumber part 1
  As a test engineer
  I want to be able to write and execute a simple scenario

  Scenario: Simple scenario
    When I am on the home page
    Then I should see home page header
    And I should see home page description
    And I should see menu

  @textOne
  Scenario: My first scenario
    Given I am on actions page
        # go to https://kristinek.github.io/site/examples/actions
    When I enter text
        # enter any text in text box ("abcd")
    And I click the result button
        # click on the result button
    Then I see correct result text
        # check that text is seen("abcd")




