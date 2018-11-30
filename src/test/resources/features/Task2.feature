@task2

Feature: Task 2 scenarios

  Background:
    Given I am on People with jobs page

   Scenario: add a new person
     When I click on Add person button
     And I enter two values:
      | name | Sarah    |
      | job  | Manager  |
     And I click Add button
     Then I see person in list:
      | Sarah  | Manager |

   Scenario Outline: edit a person
      Given I check the first person "<name>" and "<job>"
      When I click on edit button
      And I correct first person name "<new name>"
      And I correct first person job "<new job>"
      And I click on confirm edit button
      Then I see corrected first person "<new name>" and "<new job>" in list

    Examples:
      | name | job          | new name | new job   |
      | Mike | Web Designer | Josh     | Developer |
      | Mike | Web Designer | Steve    | Teacher   |
      | Mike | Web Designer | Sarah    | Manager   |

   Scenario: remove a person
        When I click remove first person button
        Then I check that first person is removed

   Scenario: add a person and reset list
         When I click on Add person button
         And I enter two values:
          | name | Sarah    |
          | job  | Manager  |
         And I click Add button
         And I click reset button
         Then I check that my person is removed
         Then I check the all persons

   Scenario: edit a person and reset list
         Given I check the all persons
         When I click on edit button
         And I correct first person name "Josh"
         And I correct first person job "Developer"
         And I click on confirm edit button
         And I click reset button
         Then I check the all persons are not corrected

    Scenario: remove a person and reset list
         Given I check the all persons
         When I click remove first person button
         And I click reset button
         Then I check the all persons are not removed

    Scenario Outline: add a person and press clear button
         When I click on Add person button
         And I enter first name: "<name>"
         And I enter job: "<job>"
         And I click on clear button
         Then I check thet fields are empty

         Examples:
          | name    | job       |
          | Sarah   | Manager   |
          | George  | Inspector |
          | Mike    | Engineer  |

