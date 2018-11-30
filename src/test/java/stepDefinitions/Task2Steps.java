package stepDefinitions;

import cucumber.api.PendingException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

public class Task2Steps {
    private WebDriver driver;

    public Task2Steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on People with jobs page$")
    public void iAmOnPeopleWithJobsPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs");
    }


    @When("^I click on Add person button$")
    public void iClickOnAddPersonButton() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @And("^I enter two values:$")
    public void iEnterTwoValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> value : valuesToEnter.entrySet()) {
            driver.findElement(By.id(value.getKey())).sendKeys(value.getValue());
        }
    }

    @And("^I click Add button$")
    public void iClickAddButton() throws Throwable {
        driver.findElement(By.cssSelector("[onclick='addPersonWithJobToList()']")).click();
    }

    @Then("^I see person in list:$")
    public void iSeePersonInList(Map <String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> value : valuesToEnter.entrySet()) {
            assertEquals(value.getKey(), driver.findElement(By.cssSelector("#person3 > span.w3-xlarge.name")).getText());
            assertEquals(value.getValue(), driver.findElement(By.cssSelector("#person3 > span.job")).getText());
        }
    }

    @Given("^I check the first person \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iCheckTheFirstPersonAnd(String name, String job) throws Throwable {
        assertEquals(name, driver.findElement(By.cssSelector("#person0 > span.w3-xlarge.name")).getText());
        assertEquals(job, driver.findElement(By.cssSelector("#person0 > span.job")).getText());
    }

    @When("^I click on edit button$")
    public void iClickOnEditButton() throws Throwable {
        driver.findElement(By.cssSelector("#person0> span.editbtn")).click();
    }

    @And("^I correct first person name \"([^\"]*)\"$")
    public void iCorrectFirstPersonName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I correct first person job \"([^\"]*)\"$")
    public void iCorrectFirstPersonJob(String job) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @And("^I click on confirm edit button$")
    public void iClickOnConfirmEditButton() throws Throwable {
        driver.findElement(By.cssSelector("[onclick='editPersonWithJob(0)']")).click();
    }

    @Then("^I see corrected first person \"([^\"]*)\" and \"([^\"]*)\" in list$")
    public void iSeeCorrectedFirstPersonAndInList(String name, String job) throws Throwable {
        assertEquals(name, driver.findElement(By.cssSelector("#person0 > span.w3-xlarge.name")).getText());
        assertEquals(job, driver.findElement(By.cssSelector("#person0 > span.job")).getText());
    }

    @When("^I click remove first person button$")
    public void iClickRemovePersonButton() throws Throwable {
        driver.findElement(By.cssSelector("#person0> span.closebtn")).click();
    }

    @Then("^I check that first person is removed$")
    public void iCheckThatPersonIsRemoved() throws Throwable {
        assertEquals(0, driver.findElements(By.cssSelector("#person0")).size());
    }

    @And("^I click reset button$")
    public void iClickResetButton() throws Throwable {
        driver.findElement(By.cssSelector("[onclick='resetListOfPeople()']")).click();
    }

    @Then("^I check that my person is removed$")
    public void iCheckThatMyPersonIsRemoved() throws Throwable {
        assertEquals(0, driver.findElements(By.cssSelector("#person3")).size());
    }


    @Given("^I check the all persons$")
    public void iCheckTheAllPersons() throws Throwable {
        assertEquals("Mike", driver.findElement(By.cssSelector("#person0 > span.w3-xlarge.name")).getText());
        assertEquals("Web Designer", driver.findElement(By.cssSelector("#person0 > span.job")).getText());
        assertEquals("Jill", driver.findElement(By.cssSelector("#person1 > span.w3-xlarge.name")).getText());
        assertEquals("Support", driver.findElement(By.cssSelector("#person1 > span.job")).getText());
        assertEquals("Jane", driver.findElement(By.cssSelector("#person2 > span.w3-xlarge.name")).getText());
        assertEquals("Accountant", driver.findElement(By.cssSelector("#person2 > span.job")).getText());
    }


    @Then("^I check the all persons are not corrected$")
    public void iCheckTheAllPersonsAreNotCorrected() throws Throwable {
        assertEquals("Mike", driver.findElement(By.cssSelector("#person0 > span.w3-xlarge.name")).getText());
        assertEquals("Web Designer", driver.findElement(By.cssSelector("#person0 > span.job")).getText());
        assertEquals("Jill", driver.findElement(By.cssSelector("#person1 > span.w3-xlarge.name")).getText());
        assertEquals("Support", driver.findElement(By.cssSelector("#person1 > span.job")).getText());
        assertEquals("Jane", driver.findElement(By.cssSelector("#person2 > span.w3-xlarge.name")).getText());
        assertEquals("Accountant", driver.findElement(By.cssSelector("#person2 > span.job")).getText());
    }

    @Then("^I check the all persons are not removed$")
    public void iCheckTheAllPersonsAreNotRemoved() throws Throwable {
        assertEquals("Mike", driver.findElement(By.cssSelector("#person0 > span.w3-xlarge.name")).getText());
        assertEquals("Web Designer", driver.findElement(By.cssSelector("#person0 > span.job")).getText());
        assertEquals("Jill", driver.findElement(By.cssSelector("#person1 > span.w3-xlarge.name")).getText());
        assertEquals("Support", driver.findElement(By.cssSelector("#person1 > span.job")).getText());
        assertEquals("Jane", driver.findElement(By.cssSelector("#person2 > span.w3-xlarge.name")).getText());
        assertEquals("Accountant", driver.findElement(By.cssSelector("#person2 > span.job")).getText());
    }


    @And("^I enter first name: \"([^\"]*)\"$")
    public void iEnterFirstName(String name) throws Throwable {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter job: \"([^\"]*)\"$")
    public void iEnterJob(String job) throws Throwable {
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @And("^I click on clear button$")
    public void iClickOnClearButton() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @Then("^I check thet fields are empty$")
    public void iCheckThetFieldsAreEmpty() throws Throwable {
        assertEquals("", driver.findElement(By.id("name")).getText());
        assertEquals("", driver.findElement(By.id("job")).getText());
    }
}