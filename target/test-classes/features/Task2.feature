Feature:   Task 2




  @Test
  Scenario Outline: case 1


    Given I am on jobs page
    When I enter name one: "<name>"
    And I enter job one: "<job>"



  @test

    Examples:
      | name  | job      |
      | Nithin| Engineer |

  @test2

  Scenario: case2
    Given I am on Prople with jobs page
    When I click on Add people button


  @test3
  Scenario Outline: Editing a person

    Given  I am on another  page
    When I enter name1: "<name>"
    And I enter job1: "<job>"

  @test4
    Examples:

      | name   | job   |
      | Ramesh | Doctor|


  @test5
  Scenario: Deleting a person
    Given  I am on a various  page
    When I click delete a person

  @test6
  Scenario: Adding a person and reset
    Given  I am on different  page
    When  I click Rest List
    And  I go to Reset page
  @test7

  Scenario Outline: Editing a person and reseting

    Given I am on People with jobs editing page
    When I enter nametwo: "<name>"
    And I enter jobtwo: "<job>"
    Then  I reset the list
    Then I didnt see the name and job

  @test8
    Examples:

      | name   | job      |
      | John   | Business |

  @test9
  Scenario: Deleting a person then reset
    Given I am on  different action page
    When  I deleting a person
    And  I click on the reset button
    Then  I see the result

    @test10
    Scenario Outline: Checking clear all button
      Given  I am on add n ame page
       When I enter new name1: "<name>"
      And  I enter new job: "<job>
      And  i click clear all button
      Then  All fields are clear

      @test11
      Examples:

        | name   | job        |
        | Dave   | Footballer |




