@task2
Feature: Task2
In people lists making scenarios, that will: add new person, edit a person, delete a person,
add person, then reset list, edit person, then reset the list,delete a person, then reset list,
checking clear all button on adding a person

  Background:
    Given I am on People list

    Scenario: addingPerson
      When i click on add new person button
      Then I enter name: "John"
      And i enter surname "Johnson"
      And i enter Job "Mechanic"
      And i enter date of birth "11/11/11"
      And check known languages
      And check gender
      And choose status
      And i click on add
      Then i should see new person in person list


      Scenario: editPerson
        When i click on pen icon next to person
        Then I edit persons name to "Dick"
        And change status to intern
        Then i click edit button


   Scenario: deletePerson
    When i click on add new person button
    Then I enter name: "John"
    And i enter surname "Johnson"
    And i enter Job "Mechanic"
    And i enter date of birth "11/11/11"
    And check known languages
    And check gender
    And choose status
    And i click on add
    And i should see new person in person list
    Then then i press x button
    And person will be deleted


  Scenario: addingPersonAndResetList
    When i click on add new person button
    Then I enter name: "John"
    And i enter surname "Johnson"
    And i enter Job "Mechanic"
    And i enter date of birth "11/11/11"
    And check known languages
    And check gender
    And choose status
    And i click on add
    And i should see new person in person list
    Then I press reset list
    And added person is gone


  Scenario: editPersonAndResetList
    When i click on pen icon next to Mike
    Then I edit persons name to "Dick"
    And change status to intern
    Then i click edit button
    Then I press reset list
    And edits are gone


  Scenario: deletePersonAndResetList
    When then i press x button on Mike
    Then person will be deleted
    And I press reset list
    Then Mike is back

