Feature: Task 2_2 by Svetlana


  Background:
    Given I am on People list page

  @test1
  Scenario: my scenario 1
    When I click on Add person
    Then I enter Name : "Lena"
    Then I enter Surname : "ASDF"
    And I enter Job :"Economist"
    And I enter Date of Birth: "11/01/1990"
    And press English
    Then press : "Female"
    And in Employee status choose Intern
    Then I click on Add button
    Then i see new person in person list

  @test2
  Scenario: my scenario 2
    When I click on Pencil button
    Then I edit name:"Jomn"
    Then I edit surname:"DFG"
    Then I click Edit
    And compare new data

  @test3
  Scenario: my scenario 3
    When I press x to delete person
    Then check the person data is deleted

  @test4
  Scenario: my scenario 4
    When I click on Add person
    Then I enter Name : "Human"
    Then I enter Surname : "ASDE"
    And I enter Job :"Economist"
    And I enter Date of Birth: "11/01/1990"
    And press English
    Then press : "Female"
    And in Employee status choose Intern
    Then I click on Add button
    And press on Reset List