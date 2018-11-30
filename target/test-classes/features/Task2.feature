  @Task2
  Feature: Task 2 Objectives:
    add a new person with correct data
    edit a person
    remove a person
    reset original list after
      adding a person
      editing a person
      removing a person
    check that clear button on adding a user works correctly

    Background:
      Given I am on list of people page

#    add a new person with correct data
    @addPerson
      Scenario: Adding Person John Doe
        When I click Add Person
        Then I input my name: "John"
        And I input my surname: "Doe"
        And  I input my job: "Janitor"
        And I input my dob: "09/01/1939"
        And I check Spanish language
        And I select my gender
        And I select my employee status: 1
        Then I click Add button
        And I check my information is correct

#    edit a person
    @editPerson
      Scenario: Editing Person Mike Kid
        When I click pencil edit button
        Then I input my surname: "Adult"
        And I check Spanish language
        And I select my employee status: 0
        Then I click Edit button
        And I check my information is correct after edit

#    remove a person
    @removePerson
      Scenario: Deleting Person Jane Doe
        When I click delete x button
        Then I check if person is deleted

#    reset original list after
#    adding a person
    @resetAfterAdding
      Scenario: Reset list after adding John Doe
        When I click Add Person
        Then I input my name: "John"
        And I input my surname: "Doe"
        And  I input my job: "Janitor"
        And I input my dob: "09/01/1939"
        And I check Spanish language
        And I select my gender
        And I select my employee status: 1
        Then I click Add button
        And I check my information is correct
        And I click reset list button
        And I check added person is gone


#    reset original list after
#    editing a person
    @resetAfterEdit
      Scenario: Reset Mike Kid after Edit
        When I click pencil edit button
        Then I input my surname: "Adult"
        And I check Spanish language
        And I select my employee status: 0
        Then I click Edit button
        And I click reset list button
        And I check my information is correct after reset

#    reset original list after
#    removing a person
    @resetAfterRemove
      Scenario: Reset after Remove
      When I click delete x button
      Then I check if person is deleted
      And I click reset list button
      And I check person is there

#    check that clear button on adding a user works correctly
    @clearButton
      Scenario: Clear button test
        When I click Add Person
        Then I input my name: "John"
        And I input my surname: "Doe"
        And  I input my job: "Janitor"
        And I input my dob: "09/01/1939"
        And I check Spanish language
        And I select my gender
        And I select my employee status: 1
        Then I press clear all fields
        And I check if all fields are cleared
        And I click cancel
