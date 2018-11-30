@test
Feature: Task2
  As a test engineer
  I want to be able to write and execute a scenario with steps that have tables

  Background:
    Given I am on job page

@test
   Scenario Outline: add a new person
     When I click add person button
     Then new person card "People with jobs" is displayed
     And name and job input field are displayed
     And buttons: add, cancel and clear are displayed
     When I enter new name: "<name>"
     And I enter new job: "<job>"
     And click Add button
    Then new person card with "<name>" "<job>" is created

     Examples:
       | name  | job        |
       | Alex  | Tester     |
       | Sam   | Engineer   |
       | Pol   | Accountant |
       | Kate  | Beauty     |

@test1
  Scenario: editing a person
        When I click edit person button
        Then person card "People with jobs" is displayed
        When I edit job name as: "Student"
        And  And save changes
        Then Changes are saved successfully as: "Student"

@test1
   Scenario: deleting a person
        When I click delete person button for "Mike"
        Then The person is successfully deleted

@test1
   Scenario: reset original list after adding a person
        Given I click add person button
        When I enter new name: "Sam"
        And I enter new job: "Spaceman"
        And click Add button
        Then Click reset list button
        Then The job list becomes resetted

@test1
  Scenario: reset original list after editing a person
        When I click edit person button
        And person card "People with jobs" is displayed
        When I edit job name as: "Student"
        And  And save changes
        Then Click reset list button
        And The job list becomes resetted

@test1
    Scenario: reset original list after removing a person
        When I click delete person button for "Mike"
        Then The person is successfully deleted
        When Click reset list button
        Then The job list becomes resetted

@test1
     Scenario: check that clear button on adding a user works correctly
        Given I click add person button
        When I enter new name: "Sam"
        And I enter new job: "Spaceman"
        Then I click clear all fields button
        And The fields become empty