#Task 1
#In Task1.feature create 1 scenario outline and 1 scenario for page "https://kristinek.github.io/site/tasks/enter_a_number"
#
#Scenario outline for error cases:
#enter number too small
#enter number too big
#enter text intead of the number
#Scenario for correct number

Feature: task 1

  @taskOne
  Scenario: task scenario
    Given I am on enter a number page
    When I enter correct number: 81
    Then I click submit button
    And Check alert message text
    Then I click OK button in alert message

  @taskOne
  Scenario Outline: task scenario outline
    Given I am on enter a number page
    When I enter an incorrect number "<incorrect number>"
    Then I click submit button
    And I check correct error message "<error message>"

    Examples:
      | incorrect number | error message         |
      | 5                | Number is too small   |
      | 250              | Number is too big     |
      | xswq             | Please enter a number |