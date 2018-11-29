Feature: Introduction to cucumber part 1
  As a test engineer
  I want to be able to write and execute a simple scenario

  @part1
  Scenario: Simple scenario
    When I am on the home page
    Then I should see home page header
    And I should see home page description
    And I should see menu

@smoke
  Scenario: My first scenario
    Given I am on action page
    # got o homepage https://kristinek.github.io/site/examples/actions
    When I enter text
    #enter any text in the text box (text)
    And I click the result button
    #click on result button
    Then I see correct result text
    #you enteres text : "text"

  # test(s) with "@smokeTest"
  # tags = {"@smokeTest"}
    # test(s) with "@regressionTest"
  # tags = {"@regressionTest"}
    # test(s) with "@sanityTest" or "@smokeTest"
  # tags = {"@sanityTest, @smokeTest"}
    # test(s) with "@sanityTest" and "@smokeTest"
  # tags = {"@sanityTest" and "@smokeTest"}
    # test(s) with "@regressionTest", but not "@smokeTest"
  # tags = {"@regressionTest", "~@smokeTest"}



