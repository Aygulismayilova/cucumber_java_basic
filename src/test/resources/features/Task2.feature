Feature: Task 2 by Svetlana Fadeeva
  Subtask1 - People with job list

  Background:
    Given I am on People with jobs page

  @test101
  Scenario: scenario 1
    When I click on Add person button
    Then I enter name: "Paul"
    And I enter job "Engineer"
    And press Add Person button


  @test102
  Scenario: scenario 2
    When I click on Pencil
    Then I edit name: "Michail"
    Then I edit Job: "Designer"
    Then I click on Edit button

  @test103
  Scenario: scenario 3
    When I click on Delete button
    And check the person is deleted

  @test104
  Scenario: scenario 4
    When I click on Add person button
    Then I enter name: "Paul"
    And I enter job "Engineer"
    And press Add Person button
    And press on Reset List button

  @test105
  Scenario: scenario 5
    When I click on Pencil
    Then I edit name: "Philip"
    Then I edit Job: "Master"
    Then I click on Edit button
    And press on Reset List button

  @test106
  Scenario: scenario 6
    When I click on Delete button
    And press on Reset List button

  @test107
  Scenario: scenario 7
    When I click on Add person button
    Then I enter name: "Stefi"
    And I enter job "Chef"
    Then I press on button Clear all fields
    And I see all the fields are empty


