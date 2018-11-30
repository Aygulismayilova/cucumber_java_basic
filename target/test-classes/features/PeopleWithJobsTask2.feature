@taskTwoObject
Feature: task 2 with object

  Background:
    Given I am on People with jobs list page

  @partOneObject
  Scenario Outline: Part 1, scenario add person
    When I click on button Add person
    Then I enter new my name: "<name>"
    Then I enter new my job: "<job>"
    And I click button Add
    Then I check that correct name: "<name>" is in the list
    Then I check that correct job: "<job>" is in the list

    Examples:
      | name | job        |
      | Alex | managerOne |
      | Olga | managerTwo |

  @partTwoObject
  Scenario Outline: Part 2, scenario edit person
    When I click on button Add person
    Then I enter new my name: "<name>"
    Then I enter new my job: "<job>"
    And I click button Add
    Then I check that correct name: "<name>" is in the list
    Then I check that correct job: "<job>" is in the list
    When I click on button edit
    Then I change my name to: "<new name>"
    And I change my job to: "<new job>"
    Then I click button Edit
    And I check that edit person is with correct name: "<new name>" is in the list
    And I check that edit person is with correct job: "<new job>" is in the list

    Examples:
      | name | job        | new name | new job      |
      | Alex | managerOne | Kate     | managerThree |
      | Olga | managerTwo | John     | managerFour  |

  @partThreeObject
  Scenario Outline: Part 3, scenario delete person
    When I click on button Add person
    Then I enter new my name: "<name>"
    Then I enter new my job: "<job>"
    And I click button Add
    Then I check that correct name: "<name>" is in the list
    Then I check that correct job: "<job>" is in the list
    And I click on button delete
    Then I check that person disappeared

    Examples:
      | name | job        |
      | Alex | managerOne |
      | Olga | managerTwo |

  @partFourObject
  Scenario Outline: Part 1, scenario add person and click reset list button
    When I click on button Add person
    Then I enter new my name: "<name>"
    Then I enter new my job: "<job>"
    And I click button Add
    Then I check that correct name: "<name>" is in the list
    Then I check that correct job: "<job>" is in the list
    When I click on button reset list
    Then I check that person disappeared
    And I check that all list of people is correct

    Examples:
      | name | job        |
      | Alex | managerOne |
      | Olga | managerTwo |

  @partFiveObject
  Scenario Outline: Part 5, scenario edit person and click reset
    When I click on button Add person
    Then I enter new my name: "<name>"
    Then I enter new my job: "<job>"
    And I click button Add
    Then I check that correct name: "<name>" is in the list
    Then I check that correct job: "<job>" is in the list
    When I click on button edit
    Then I change my name to: "<new name>"
    And I change my job to: "<new job>"
    Then I click button Edit
    And I check that edit person is with correct name: "<new name>" is in the list
    And I check that edit person is with correct job: "<new job>" is in the list
    When I click on button reset list
    Then I check that person disappeared
    And I check that all list of people is correct

    Examples:
      | name | job        | new name | new job      |
      | Alex | managerOne | Kate     | managerThree |
      | Olga | managerTwo | John     | managerFour  |

  @partSixObject
  Scenario Outline: Part 6, scenario delete person and click reset button
    When I click on button Add person
    Then I enter new my name: "<name>"
    Then I enter new my job: "<job>"
    And I click button Add
    Then I check that correct name: "<name>" is in the list
    Then I check that correct job: "<job>" is in the list
    And I click on button delete
    Then I check that person disappeared
    When I click on button reset list
    Then I check that person disappeared
    And I check that all list of people is correct

    Examples:
      | name | job        |
      | Alex | managerOne |
      | Olga | managerTwo |

  @partSevenObject
  Scenario Outline: Part 7, scenario add person and click clear all fields
    When I click on button Add person
    Then I enter new my name: "<name>"
    Then I enter new my job: "<job>"
    And I click on button clear all fields
    Then I check that field name is empty
    Then I check that field job is empty

    Examples:
      | name | job        |
      | Alex | managerOne |
      | Olga | managerTwo |