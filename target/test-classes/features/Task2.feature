#Task 2
#In Task2.feature create 1 scenario outline and create scenario or scenario outlines for page in order to test that user can
#
#add a new person with correct data
#edit a person
#remove a person
#reset original list after
#adding a person
#editing a person
#removing a person
#check that clear button on adding a user works correctly

@taskTwo
Feature: task 2

  Background:
    Given I am on People with jobs list page

  @partOne
  Scenario Outline: Part 1, scenario add person
    When I click on Add person button
    Then I enter my name: "<my name>"
    Then I enter my job: "<my job>"
    And I click Add button
    Then I check that correct "<my name>" and "<my job>" is in the list

    Examples:
      | my name | my job     |
      | Ann     | managerOne |
      | David   | managerTwo |

  @partTwo
  Scenario Outline: Part 2, scenario edit person
    When I click on Add person button
    Then I enter my name: "<my name>"
    Then I enter my job: "<my job>"
    And I click Add button
    Then I check that correct "<my name>" and "<my job>" is in the list
    When I click on edit button
    Then I change name to: "<new name>"
    And I change job to: "<new job>"
    Then I click Edit button
    And I check that edit person is correct "<new name>" and "<new job>" is in the list

    Examples:
      | my name | my job     | new name | new job      |
      | Ann     | managerOne | Kate     | managerThree |
      | David   | managerTwo | John     | managerFour  |

  @partThree
  Scenario Outline: Part 3, scenario delete person
    When I click on Add person button
    Then I enter my name: "<my name>"
    Then I enter my job: "<my job>"
    And I click Add button
    Then I check that correct "<my name>" and "<my job>" is in the list
    And I click on delete button
    Then I check that my person disappeared

    Examples:
      | my name | my job     |
      | Ann     | managerOne |
      | David   | managerTwo |

  @partFour
  Scenario Outline: Part 4, scenario add person and click reset
    When I click on Add person button
    Then I enter my name: "<my name>"
    Then I enter my job: "<my job>"
    And I click Add button
    Then I check that correct "<my name>" and "<my job>" is in the list
    When I click on reset list button
    Then I check that my person disappeared
    And I check that list of people is correct

    Examples:
      | my name | my job     |
      | Ann     | managerOne |
      | David   | managerTwo |

  @partFive
  Scenario Outline: Part 5, scenario edit person and click reset
    When I click on Add person button
    Then I enter my name: "<my name>"
    Then I enter my job: "<my job>"
    And I click Add button
    Then I check that correct "<my name>" and "<my job>" is in the list
    When I click on edit button
    Then I change name to: "<new name>"
    And I change job to: "<new job>"
    Then I click Edit button
    And I check that edit person is correct "<new name>" and "<new job>" is in the list
    When I click on reset list button
    Then I check that my person disappeared
    And I check that list of people is correct

    Examples:
      | my name | my job     | new name | new job      |
      | Ann     | managerOne | Kate     | managerThree |
      | David   | managerTwo | John     | managerFour  |

  @partSix
  Scenario Outline: Part 6, scenario delete person and click reset button
    When I click on Add person button
    Then I enter my name: "<my name>"
    Then I enter my job: "<my job>"
    And I click Add button
    Then I check that correct "<my name>" and "<my job>" is in the list
    And I click on delete button
    When I click on reset list button
    Then I check that my person disappeared
    And I check that list of people is correct

    Examples:
      | my name | my job     |
      | Ann     | managerOne |
      | David   | managerTwo |

  @partSeven
  Scenario Outline: Part 7, scenario add person and click clear all fields
    When I click on Add person button
    Then I enter my name: "<my name>"
    Then I enter my job: "<my job>"
    And I click on clear all fields button
    Then I check that name field is empty
    Then I check that job field is empty

    Examples:
      | my name | my job     |
      | Ann     | managerOne |
      | David   | managerTwo |