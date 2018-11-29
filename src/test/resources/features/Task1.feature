Feature: Introduction to cucumber task1
  As a test engineer
  I want to be able to write and execute a scenario outline


  Scenario: Correct number scenario
    When I am on enter a number page
    Then I enter a number: 64
    And I click submit button
    And I check alert message
    Then I click OK in alert message

  @testtwo
  Scenario Outline: Incorrect number scenario
    When I am on enter a number page
    Then I enter an incorrect number "<number>"
    And I click submit button
    And I check error message "<text>"

    Examples:
      | number | text                  |
      | 25     | Number is too small   |
      | 121    | Number is too big     |
      | njhkl  | Please enter a number |
      | 16     | Number is too small   |
      | 101    | Number is too big     |
      | 3k     | Please enter a number |
