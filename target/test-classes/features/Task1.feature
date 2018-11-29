
@task1
Feature: Introduction to cucumber part 3


Scenario Outline: my Task1
  Given I am on action page1
  When I tap "<number>" number
  And I click the submit button
  Then I see correct resultaaa  with text "<message>"
  Examples:
  |number| message              |
  |   224| Number is too big    |
  |   4  | Number is too small  |
  |  text| Please enter a number|
  |      |You haven't entered anything|

  Scenario: my Task1_1
    Given I am on action page1
    When I tap "55" number
    And I click the submit button
    Then Accept the alert



