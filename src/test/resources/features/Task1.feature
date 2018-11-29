#Task 1
#In Task1.feature create 1 scenario outline and 1 scenario for page "https://kristinek.github.io/site/tasks/enter_a_number"
#
#For error cases: 1.1) enter number too small 1.2) enter number too big 1.3) enter text intead of the number
#Enter correct number

  Feature: Cucumber Task 1: scenario outline and scenario

    #Scenario Outline
  @Task1
  Scenario Outline: Task 1 Scenario outline: Number too small | Number too big | Number is text
    Given I am on enter a number page
    When I enter a number: "<number>"
    And I click submit number
    Then I see an error: "<error>"

    Examples:
    | number | error                 |
    | 3      | Number is too small   |
    | 123456 | Number is too big     |
    | number | Please enter a number |

    #Scenario
   @Task1
   Scenario: Task 1 Scenario: Number is correct
     Given I am on enter a number page
     When I enter a number: "64"
     And I click submit number
     Then I see popup message
     And I close the popup
