@regression
Feature: Scenario Final Task

  @test
  Scenario Outline: Adding a new person
    Given I am on people with jobs page
    When I click add person button
    And I add name: "<name>"
    And I add surname: "<surname>"
    And I add a job: "<job>"
    And I add date of birth: "<birthday>"
    And I select languages
    And I select gender: "<gender>"
    And I select employee status: "<status>"
    And I click add button
    Then I see new person in a list

    Examples:
      | name | surname  | job    | birthday   | gender | status     |
      | Jana | Logunova | tester | 12/15/2014 | female | contractor |


  @test
  Scenario: Editing a person
    Given I am on people with jobs page
    When I click on edit button
    And I edit name to: "Anna"
    And I edit surname to: "Zippen"
    And I click edit button
    Then I see edited person in a list


  @test
  Scenario: Deleting a person
    Given I am on people with jobs page
    And I click on delete button
    Then I see a list without a deleted person


  @test
  Scenario Outline: Adding a person, then resetting the list
    Given I am on people with jobs page
    When I click add person button
    And I add name: "<name>"
    And I add surname: "<surname>"
    And I add a job: "<job>"
    And I add date of birth: "<birthday>"
    And I select languages
    And I select gender: "<gender>"
    And I select employee status: "<status>"
    And I click add button
    Then I see new person in a list
    And I click reset button
    Then I see basic job list

    Examples:
      | name | surname  | job    | birthday   | gender | status     |
      | Anna | Logunova | tester | 12/15/2014 | female | contractor |

  @test
  Scenario: Editing a person, then resseting the list
    Given I am on people with jobs page
    When I click on edit button
    And I edit name to: "Anna"
    And I edit surname to: "Zippen"
    And I click edit button
    Then I see edited person in a list
    And I click reset button
    Then I see basic job list


  @test
  Scenario: Deleting a person, then resetting the list
    Given I am on people with jobs page
    And I click on delete button
    Then I see a list without a deleted person
    And I click reset button
    Then I see basic job list

  @test
  Scenario Outline: Fill whole form, check the Clear All Fields button
    Given I am on people with jobs page
    When I click add person button
    And I add name: "<name>"
    And I add surname: "<surname>"
    And I add a job: "<job>"
    And I add date of birth: "<birthday>"
    And I select languages
    And I select gender: "<gender>"
    And I select employee status: "<status>"
    And I click clear all button
    Then I see empty fields

    Examples:
      | name | surname  | job    | birthday   | gender | status     |
      | Anna | Logunova | tester | 12/15/2014 | female | contractor |


