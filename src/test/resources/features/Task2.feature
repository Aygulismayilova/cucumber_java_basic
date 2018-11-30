
Feature: Cucumber Task 2: People with job list

  Background:
    Given I am on page people with Job list

    Scenario:
      When I click on add person
      And I add a person name
      Then I give a job to the person
      And I add the person to the list
      Then I check the created person

    Scenario:
       When I click the Edit button
       Then I delete name
      And I enter a new name
       Then I change the persons Job
      And I confirm Edit
      Then I check the Edited fields

    Scenario:
      When I click on delete button
      Then I check if the person is deleted

   Scenario:
     When I add a new person
     Then I reset the list
     And I check if the person is still there

   Scenario:
     Then I edit a person
     And I check the list for changes
     Then I reset the list
     And I check the list for changes again

   Scenario:
     When I delete a person
     And check the list for the person
     Then I reset the list
     And check the list for the person once more

   Scenario:
     When I create a person
     Then I enter name
     And I enter a Job
     Then I use clear all fields button
     And I check if the fields are clear now


