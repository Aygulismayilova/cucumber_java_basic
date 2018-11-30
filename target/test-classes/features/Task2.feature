@regression @testFinal
Feature: Task 2 for Cucumber
  As a test engineer
  I want to be able to write and execute a scenario with steps

  Background:
    Given I am on people list page

  @testAddPerson @testFinal
  Scenario Outline: adding a new person
    When I click add person button
    And I enter person name: "<name>"
    And I enter surname: "<surname>"
    And I enter job title: "<jobTitle>"
    And I choose date of birth: "<dateOfBirth>"
    And I choose language:
    And I choose gender: "<gender>"
    And I choose employee status: "<status>"
    Then I click add button

    Examples:
      | name | surname | jobTitle  | dateOfBirth | gender | status     |
      | Lisa | Carol   | Developer | 12/15/2014  | female | Contractor |


  @testFinal
  Scenario: edit a person
    When I click on edit button
    Then I see editing page
    And I edit name to: "Vasja"
    And I edit surname to: "Pupkin"
    And I click edit button
    Then I see edited person in a list


  @testFinal
  Scenario: Deleting a person
    And I click on delete button
    Then I see a list without a deleted person

  @testFinal2

  Scenario Outline: adding a new person and resetting the list
    When I click add person button
    And I enter person name: "<name>"
    And I enter surname: "<surname>"
    And I enter job title: "<jobTitle>"
    And I choose date of birth: "<dateOfBirth>"
    And I choose language:
    And I choose gender: "<gender>"
    And I choose employee status: "<status>"
    Then I click add button
    And I click on reset list button
    Then I see list is reset


    Examples:
      | name | surname | jobTitle  | dateOfBirth | gender | status     |
      | Lisa | Carol   | Developer | 12/15/2014  | female | Contractor |

  @testFinal3
  Scenario: editing a person and resetting the list
    When I click on edit button
    Then I see editing page
    And I edit name to: "Vasja"
    And I edit surname to: "Pupkin"
    And I click edit button
    Then I see edited person in a list
    And I click on reset list button
    Then I see list is reset

  @testFinal4
  Scenario:
    And I click on delete button
    Then I see a list without a deleted person
    And I click on reset list button
    Then I see list is reset correctly

  @testFinal5
  Scenario Outline: adding a new person and resetting the list
    When I click add person button
    And I enter person name: "<name>"
    And I enter surname: "<surname>"
    And I enter job title: "<jobTitle>"
    And I choose date of birth: "<dateOfBirth>"
    And I choose language:
    And I choose gender: "<gender>"
    And I choose employee status: "<status>"
    Then I click add button
    Then I am on entered person page
    And I click on clear all button
    Then I see list is clear


    Examples:
      | name | surname | jobTitle  | dateOfBirth | gender | status     |
      | Lisa | Carol   | Developer | 12/15/2014  | female | Contractor |
