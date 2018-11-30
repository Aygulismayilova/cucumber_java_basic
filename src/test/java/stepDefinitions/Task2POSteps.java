package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.*;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Task2POSteps {
    private WebDriver driver;
    static Task2Page task2Page;
    static Task2AddPersonPage task2AddPersonPage;

    public Task2POSteps() {
        this.driver = Hooks.driver;
        task2Page = PageFactory.initElements(Hooks.driver, Task2Page.class);
        task2AddPersonPage = PageFactory.initElements(Hooks.driver, Task2AddPersonPage.class);
    }

    @Given("^I (?:am on|open) list of people page$")
    public void iAmOnListOfPeoplePage() throws Throwable{
        driver.get(task2Page.getPageURL());
    }

    @When("^I click Add Person$")
    public void iClickAddPerson() throws Throwable {
        task2Page.clickAddPersonButton();
    }

    @Then("^I input my name: \"([^\"]*)\"$")
    public void iInputMyName(String name) throws Throwable {
        task2AddPersonPage.inputPersonName(name);
    }

    @And("^I input my surname: \"([^\"]*)\"$")
    public void iInputMySurname(String surname) throws Throwable {
        task2AddPersonPage.inputPersonSurname(surname);
    }

    @And("^I input my job: \"([^\"]*)\"$")
    public void iInputMyJob(String job) throws Throwable {
        task2AddPersonPage.inputPersonJob(job);
    }

    @And("^I input my dob: \"([^\"]*)\"$")
    public void iInputMyDob(String dob) throws Throwable {
        task2AddPersonPage.inputPersonDOB(dob);
    }

    @And("^I check Spanish language$")
    public void iSelectCheckSpanishLanguage() throws Throwable {
        task2AddPersonPage.checkLanguageSpanish();
    }

    @And("^I select my gender$")
    public void iSelectMyGender() throws Throwable {
        task2AddPersonPage.checkGenderMale();
    }

    @And("^I select my employee status: (\\d+)$")
    public void iSelectMyEmployeeStatus(int option) throws Throwable {
        task2AddPersonPage.setOption(option);
    }

    @Then("^I click Add button$")
    public void iClickAddButton() throws Throwable {
        task2AddPersonPage.clickAddPersonButton();
    }

    @And("^I check my information is correct$")
    public void iCheckMyInformationIsCorrect() throws Throwable {
        task2Page.checkPersonInfoIsCorrect();
    }

    @When("^I click pencil edit button$")
    public void iClickPencilEditButton() throws Throwable {
        task2Page.clickEditPersonButton();
    }

    @Then("^I click Edit button$")
    public void iClickEditButton() throws Throwable {
        task2AddPersonPage.clickEditPersonButton();
    }

    @And("^I check my information is correct after edit$")
    public void iCheckMyInformationIsCorrectAfterEdit() throws Throwable {
        task2Page.checkPersonInfoIsCorrectAfterEdit();
    }

    @When("^I click delete x button$")
    public void iClickDeleteXButton() throws Throwable {
        task2Page.deletePerson3();
    }

    @And("^I click reset list button$")
    public void iClickResetListButton() throws Throwable {
        task2Page.resetList();
    }

    @And("^I check my information is correct after reset$")
    public void iCheckMyInformationIsCorrectAfterReset() throws Throwable {
        task2Page.checkPersonInfoIsCorrectAfterReset();
    }

    @Then("^I check if person is deleted$")
    public void iCheckIfPersonIsDeleted() throws Throwable {
        task2Page.checkIfPerson3IsDeleted();
    }

    @And("^I check added person is gone$")
    public void iCheckAddedPersonIsGone() throws Throwable {
        task2Page.checkIfPerson4IsDeleted();
    }

    @And("^I check person is there$")
    public void iCheckPersonIsThere() throws Throwable {
        task2Page.checkIfJaneDoeIsBack();
    }

    @Then("^I press clear all fields$")
    public void iPressClearAllFields() throws Throwable {
        task2AddPersonPage.clickClearAllFieldsButton();
    }

    @And("^I check if all fields are cleared$")
    public void iCheckIfAllFieldsAreCleared() throws Throwable {
        task2AddPersonPage.checkFieldsAreEmpty();
    }

    @And("^I click cancel$")
    public void iClickCancel() throws Throwable {
        task2AddPersonPage.clickCancelButton();
    }
}
