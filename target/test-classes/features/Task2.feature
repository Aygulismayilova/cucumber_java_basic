@regression
Feature: blabla



Background:
  Given I am on People with Jobs page

  @add
  Scenario Outline: add a new person
    When I click on add a new person
    And   I enter valuess and Submit:
      | name | <name> |
      | job  | <job>  |
    Then go back to Jobs Page check if new Person Is added
  @working
    Examples:
      | name   | job              |
      | Mahdi   | CEO             |

  @editing
  Scenario Outline: edit a person
    When I click on edit a person
    And   I enter valuess and Submit:
      | name | <name> |
      | job  | <job>  |
    Then go back to Jobs Page check if Information were Updated
  @working
    Examples:
      | name   | job                 |
      | Faycel   | Banks             |

  @delete
  Scenario: delete a person
    When I click on delete a person
    Then go back to Jobs Page check if the person was deleted

  @AddReset
  Scenario: add a person then Reset
    When I click on add a new person
    And   I enter valuess and Submit:
      | name | mahdi |
      | job  | Boss |
    Then go back to Jobs Page check if new Person Is added
    And I click on reset
    Then check the original list

  @EditAndReset
  Scenario: edit a person then Reset
    When I click on edit a person
    And   I enter valuess and Submit:
      | name | Faycel |
      | job  | Banks |
    Then go back to Jobs Page check if Information were Updated
    And I click on reset
    Then check the original list

  @DeleteAndReset
  Scenario: delete a person and reset
    When I click on delete a person
    Then go back to Jobs Page check if the person was deleted
    And I click on reset
    Then check the original list


    @checkClear
    Scenario: delete a person and reset
      When I click on add a new person
      And  I enter valuess :
        | name | mahdi |
        | job  | Boss |
      And I click on clearAllFields
      Then i check fields
