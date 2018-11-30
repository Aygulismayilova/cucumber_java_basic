
@test
Feature: Introduction to cucumber part 1
  As a test engineer
  I want to be able to write and execute a simple scenario

  Background:
    Given I am on the people with job list page
    Scenario Outline: my scenario out line for Add a new person
      And click on Add button
    When I enter values for person
      | name | <pname> |
      | job   | <job>   |

    Examples:
      | pname  | job        |
      | anju   |  tester    |
      | anu    |  developer |

  Scenario: my second scenario edit a preson
    Then  I click edit button
    Then I clear both name and job field
    Then  I enter the new details
    And  I click on edit
    Then I check it is correct

  Scenario: my third scenario for delete a person
  When I click on delete button

  Scenario Outline: my scenario out line for Add a new person and Resetting list
    And click on Add button
    When I enter values for person
      | name | <pname> |
      | job   | <job>  |
    Then I click resetting the list
    Then I check new person is not present in list

    Examples:
      | pname  | job        |
      | manu   |  support   |

Scenario: my scenario for editing a person and resetting
  Then  I click edit button
  Then I clear both name and job field
  Then  I enter the new details
  And  I click on edit
  Then I check it is correct
  Then I click resetting the list
  Then I check new person is not present in list

  Scenario: my scenario for deleting a person and resetting list
    When I click on delete button
    Then  I click resetting the list
    Then  I check page is showing correct list

  Scenario Outline:check that clear button on adding a user works correctly
    And click on Add button
    When I enter values for person
      | name | <pname> |
      | job   | <job>  |
    Then  I click on clear button
    Then  I check feild is empty
    Examples:
      | pname   | job        |
      | kukku   |  support   |