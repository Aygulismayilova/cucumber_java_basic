Feature: Task 2-1
  Testing People with job list

  Background:
    Given I am on people job list

  @testA
  Scenario: adding a New Person
    When I click Add person button
    And I write down Name
    And I write down Job
    And I click Add
    Then I see that person record is added correctly

  @testB
  Scenario: editing Person
    When I click Edit person button with pen
    And I delete name and surname
    And I write down Name
    And I write down Job
    And I click Add
    Then I see that new person record is added correctly

  @testC
  Scenario: deleting adding a New Person (delete)
    When I click Add person button
    And I write down Name
    And I write down Job
    And I click Cancel button
    Then I see that all information is deleted

  @testD
  Scenario: adding a person, then resseting list
    When I click Add person button
    And I write down Name
    And I write down Job
    And I click Add
    And I reset the list
    Then I see that all information is deleted

  @testE
  Scenario: edit person, then reset the list
    When I click Edit person button with pen
    And I delete name and surname
    And I write down Name
    And I write down Job
    And I click Add
    Then I see that all information is added correctrly
    And I reset the list
    Then I see that all information reseted back

  @testF
  Scenario: delete person then rest the page
    When I click delete cross next to person name
    And I see that name is deleted
    And I reset the list
    Then I see that all information is reseted

  @testG
  Scenario: use clear all button on adding person
    When I click Add person button
    And I write down Name
    And I write down Job
    And I click Clear all fields buttonN
    Then all previously filled fields are empty
