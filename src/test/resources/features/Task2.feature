@tasktwo
Feature: Introduction to cucumber task2
  As a test engineer
  I want to be able to write and execute a scenario

  Background:
    Given I am on people with job list page

  Scenario Outline: 1) add a new person
    Then I click Add person button
    And I enter firstname: "<name>"
    And I enter job: "<job>"
    Then I click Add button
    Then I check the added person "<name>" and "<job>" is in the list
    Examples:
      | name    | job       |
      | Marie   | Assistant |
      | Lucas   | Driver    |
      | Michael | Tester    |


  Scenario Outline: 2) edit a person
    Then I click Add person button
    And I enter firstname: "<name>"
    And I enter job: "<job>"
    Then I click Add button
    Then I check the added person "<name>" and "<job>" is in the list
    And I click edit person button
    And I change name to: "<newname>"
    And I change job to: "<newjob>"
    Then I click edit button
    And I check the edited person name "<newname>" and job "<newjob>" in the list

    Examples:
      | name    | job       | newname | newjob    |
      | Marie   | Assistant | Elisa   | Driver    |
      | Lucas   | Driver    | Alina   | Assistant |



    Scenario: 3) delete a person
      Then I click delete button
      And I check the deleted person disappeared from list


    Scenario Outline: 4) Add a person, then reset the list
      Then I click Add person button
      And I enter firstname: "<name>"
      And I enter job: "<job>"
      Then I click Add button
      Then I check the added person "<name>" and "<job>" is in the list
      And click reset button
      And check the added person dissapeared
      Then I check the list is correct
      Examples:
        | name    | job       |
        | Marie   | Assistant |
        | Lucas   | Driver    |

      Scenario Outline: 5) Edit the person, then reset the list
        Then I click Add person button
        And I enter firstname: "<name>"
        And I enter job: "<job>"
        Then I click Add button
        Then I check the added person "<name>" and "<job>" is in the list
        And I click edit person button
        And I change name to: "<newname>"
        And I change job to: "<newjob>"
        Then I click edit button
        And click reset button
        And check the edited person dissapeared
        Then I check the list is correct
        Examples:
          | name    | job       | newname | newjob    |
          | Marie   | Assistant | Elisa   | Driver    |
          | Lucas   | Driver    | Alina   | Assistant |

  @tasktwo
Scenario: 6) delete a person, then reset the list
  Then I click delete button
  And I check the deleted person disappeared from list
  And click reset button
  Then I check the list is correct



    Scenario Outline: 7) check clear all button on adding a person
      Then I click Add person button
      And I enter firstname: "<name>"
      And I enter job: "<job>"
      Then I click clear all button
      And I check name and job fields are empty
      Examples:
        | name    | job       |
        | Marie   | Assistant |