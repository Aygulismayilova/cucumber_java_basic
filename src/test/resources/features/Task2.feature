@completed
Feature: Task2
  As a test engineer
  I want to be able to write and execute a scenario with steps that have tables

Background:
  Given I am on page Poeple

  Scenario: my Task2_1
    Then I click on Add person
    Then In new page I enter name: "Alina"
    And In new page I enter job: "Without job"
    Then I click on Add in the second page
    Then I compare added new person in the list
@ok
  Scenario: my Task2_2
    Then I click on EditPerson
    Then I Edit person data
    Then I compare all new data

  Scenario: my Task2_3
    Then I click on Delete a new person
    Then I compare that persona is deleted

  Scenario: my Task2_4
    Then I click on Add person
    Then In new page I enter name: "Alina"
    And In new page I enter job: "Without job"
    Then I click on Add in the second page
    Then I reset the page
    Then I compare tree persons in the page


  Scenario: my Task2_5
    Then I click on Delete a new person
    Then I compare that persona is deleted
    Then I reset the page
    Then I compare tree persons in the page

  Scenario: my Task2_6
    Then I click on Delete a new person
    Then I compare that persona is deleted
    Then I reset the page
    Then I compare tree persons in the page

  Scenario: my Task2_7
    Then I click on Add person
    Then In new page I enter name: "Alina"
    When Click on Clear all fields
    Then Compare that the fields are empty
    Then In new page I enter job: "Without job"
    When Click on Clear all fields
