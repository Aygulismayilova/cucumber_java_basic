package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.PeopleWithJobsTask2;

public class PeopleWithJobsStepsTask2 {
    private WebDriver driver;
    static PeopleWithJobsTask2 peopleWithJobs;
    public PeopleWithJobsStepsTask2() {
        this.driver = Hooks.driver;
        peopleWithJobs = PageFactory.initElements(Hooks.driver, PeopleWithJobsTask2.class);
    }

    @When("^I click on button Add person$")
    public void iClickOnButtonAddPerson() throws Throwable {
        peopleWithJobs.clickAddPersonButton();
    }

    @Then("^I enter new my name: \"([^\"]*)\"$")
    public void iEnterNewMyName(String name) throws Throwable {
        peopleWithJobs.enterName(name);
    }

    @Then("^I enter new my job: \"([^\"]*)\"$")
    public void iEnterNewMyJob(String job) throws Throwable {
        peopleWithJobs.enterJob(job);
    }

    @And("^I click button Add$")
    public void iClickButtonAdd() throws Throwable {
        peopleWithJobs.clickAddSubmitButton();
    }

    @Then("^I check that correct name: \"([^\"]*)\" is in the list$")
    public void iCheckThatCorrectNameIsInTheList(String name) throws Throwable {
        peopleWithJobs.checkCorrectNameInput(name);
    }

    @Then("^I check that correct job: \"([^\"]*)\" is in the list$")
    public void iCheckThatCorrectJobIsInTheList(String job) throws Throwable {
        peopleWithJobs.checkCorrectJobInput(job);
    }

    @When("^I click on button edit$")
    public void iClickOnButtonEdit() throws Throwable {
        peopleWithJobs.clickOnMyEditButton();
    }

    @Then("^I change my name to: \"([^\"]*)\"$")
    public void iChangeMyNameTo(String name) throws Throwable {
        peopleWithJobs.enterEditName(name);
    }

    @And("^I change my job to: \"([^\"]*)\"$")
    public void iChangeMyJobTo(String job) throws Throwable {
        peopleWithJobs.enterEditJob(job);
    }

    @Then("^I click button Edit$")
    public void iClickButtonEdit() throws Throwable {
        peopleWithJobs.clickOnEditButtonInList();
    }

    @And("^I check that edit person is with correct name: \"([^\"]*)\" is in the list$")
    public void iCheckThatEditPersonIsWithCorrectNameIsInTheList(String editName) throws Throwable {
        peopleWithJobs.checkCorrectEditName(editName);
    }

    @And("^I check that edit person is with correct job: \"([^\"]*)\" is in the list$")
    public void iCheckThatEditPersonIsWithCorrectJobIsInTheList(String editJob) throws Throwable {
        peopleWithJobs.checkCorrectEditJob(editJob);
    }

    @And("^I click on button delete$")
    public void iClickOnButtonDelete() throws Throwable {
        peopleWithJobs.clickOnDeleteButton();
    }

    @Then("^I check that person disappeared$")
    public void iCheckThatPersonDisappeared() throws Throwable {
        peopleWithJobs.checkThatPersonDisappeared();
    }

    @When("^I click on button reset list$")
    public void iClickOnButtonResetList() throws Throwable {
        peopleWithJobs.clickOnResetListButton();
    }

    @And("^I check that all list of people is correct$")
    public void iCheckThatAllListOfPeopleIsCorrect() throws Throwable {
        peopleWithJobs.checkFirstPersonNameOfListIsCorrect();
        peopleWithJobs.checkSecondPersonNameOfListIsCorrect();
        peopleWithJobs.checkThirdPersonNameOfListIsCorrect();

        peopleWithJobs.checkFirstPersonJobOfListIsCorrect();
        peopleWithJobs.checkSecondPersonJobOfListIsCorrect();
        peopleWithJobs.checkThirdPersonJobOfListIsCorrect();
    }

    @And("^I click on button clear all fields$")
    public void iClickOnButtonClearAllFields() throws Throwable {
        peopleWithJobs.clickOnClearFieldButton();
    }

    @Then("^I check that field name is empty$")
    public void iCheckThatFieldNameIsEmpty() throws Throwable {
        peopleWithJobs.checkThatNameFieldIsEmpty();
    }

    @Then("^I check that field job is empty$")
    public void iCheckThatFieldJobIsEmpty() throws Throwable {
        peopleWithJobs.checkThatJobFieldIsEmpty();
    }
}
