@regression
Feature: Introduction to cucumber part 3
  As a test engineer
  I want to be able to write and execute a scenario outline

  @test
  Scenario Outline: a new scenario outline
    Given I am on age page
    When I enter name: "<name>"
    And I enter age: <age>
    And I click submit age
    Then I see message: "<message>"

    Examples:
      | name  | age | message                        |
      | Ann   | 5   | Hello, Ann, you are a kid      |
      | Marry | 50  | Hello, Marry, you are an adult |
      | Bob   | 61  | Hello, Bob, you are an adult   |


  @test1
  Scenario Outline: my third scenario 1
    Given I am on action page
    When I enter "<test>" text
    And I click the result button
    Then I see correct result with text "test"

    Examples:
      | test |
      | 6    |
      | 7    |

    Examples:
      | test |
      | 8    |
      | 9    |

   # Scenario Outline: my second scenario 1
   #  Given I am on action page
   #  When I enter "changes" text
    #  And I click the result button
   #   Then I see the correct result with text "changes"

      #Examples:
       # | name | age | message                   |
       # | Tom  | 15  | Hello, Tom, you are a kid |
