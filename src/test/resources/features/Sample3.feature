
Feature: Introduction to cucumber part 3
  As a test engineer
  I want to be able to write and execute a scenario outline


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
# @not_working
#   Examples:
#     | name | age | message                   |
#     | Tom  | 15  | Hello, Tom, you are a kid |

  @Test
    Scenario Outline: My third scenario
      #Give i am on action page
    Given I am on action page
    When I enter "<text>"
      #When i enter "changes" text
    Then I click the reeslut page
      #And i click the result button
    And I check the correct result with the "<text>"
      #Then i see correct result with text "changes"

      Examples:
        | text |
        | Boop |
        |7     |
    Examples:
    | text |




