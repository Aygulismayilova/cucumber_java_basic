package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages_sample.AgePage;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @When("^I enter text$")
    public void iEnterText() throws Throwable {
        String textInput = "asdf";
        WebElement textBox = driver.findElement(By.id("text"));
        textBox.clear();
        textBox.sendKeys(textInput);
    }

    @Then("^I see correct result text$")
    public void iSeeCorrectResultText() throws Throwable {
        String text = "You entered text: \"asdf\"";
        assertEquals(text, driver.findElement(By.id("result_text")).getText());
    }

    @When("^I enter \"([^\"]*)\" text$")
    public void iEnterText(String text) throws Throwable {
        driver.findElement(By.id("text")).clear();
        driver.findElement(By.id("text")).sendKeys(text);
    }

    @Then("^I see correct result with text \"([^\"]*)\"$")
    public void iSeeCorrectResultWithText(String text) throws Throwable {
        assertEquals("You entered text: \"" + text + "\"", driver.findElement(By.cssSelector("#result_text")).getText());
    }

    @When("^I enter number (\\d+)$")
    public void iEnterNumber(int number) throws Throwable {
        driver.findElement(By.id("text")).clear();
        driver.findElement(By.id("text")).sendKeys(String.valueOf(number));
    }

    @And("^I click the result number button$")
    public void iClickTheResultNumberButton() throws Throwable {
        driver.findElement(By.id("result_button_number")).click();
    }

    @Then("^I see correct result with text (\\d+)$")
    public void iSeeCorrectResultWithText(int number) throws Throwable {
        assertEquals("You entered number: \"" + number + "\"", driver.findElement(By.cssSelector("#result_number")).getText());
    }


    @Then("^I see my correct result text \"([^\"]*)\"$")
    public void iSeeMyCorrectResultText(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(driver.findElement(By.id("ch1_error")).isDisplayed());
    }


    @Given("^I am on new action page$")
    public void iAmOnNewActionPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number \"([^\"]*)\"$")
    public void iEnterNumber(String string) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("numb")).clear();

        driver.findElement(By.id("numb")).sendKeys(string);
    }

    @And("^I click the submit button$")
    public void iClickTheSubmitButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector("body > div.w3-row > div > div > div.w3-container.w3-card-4 > button")).click();

    }

    @When("^I enter <hello> text$")
    public void iEnterHelloText() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I click on result button$")
    public void iClickOnResultButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I am om enter page$")
    public void iAmOmEnterPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    @Then("^I see error if i enter numbers$")
    public void iSeeErrorIfIEnterNumbers(Map<String, String> numberToEnter) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        for (Map.Entry<String, String> firstChecks : numberToEnter.entrySet()) {
            driver.findElement(By.id("numb")).clear();
            driver.findElement(By.id("numb")).sendKeys(firstChecks.getKey()); // 3
            driver.findElement(By.cssSelector(".w3-btn")).click();
            assertEquals(firstChecks.getValue(), driver.findElement(By.id("ch1_error")).getText()); // Number is too small
        }
    }

    @Given("^I am on jobs page$")
    public void iAmOnJobsPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html");
    }

    @When("^I enter name one: \"([^\"]*)\"$")
    public void iEnterNameOne(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter job one: \"([^\"]*)\"$")
    public void iEnterJobOne(String job) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @Given("^I am on Prople with jobs page$")
    public void iAmOnPropleWithJobsPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html");

    }

    @When("^I click on Add people button$")
    public void iClickOnAddPeopleButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("modal_button")).click();
    }





    @Given("^I am on another  page$")
    public void iAmOnAnotherPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html");
    }

    @When("^I enter name(\\d+): \"([^\"]*)\"$")
    public void iEnterName(int arg0, String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter job(\\d+): \"([^\"]*)\"$")
    public void iEnterJob(int arg0, String job ) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @Given("^I am on a various  page$")
    public void iAmOnAVariousPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }

    @When("^I click delete a person$")
    public void iClickDeleteAPerson() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@class=\"w3-closebtn closebtn w3-padding w3-margin-right w3-medium\"][1])")).click();
    }

    @Given("^I am on different  page$")
    public void iAmOnDifferentPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }

    @When("^I click Rest List$")
    public void iClickRestList() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@class=\"w3-closebtn closebtn w3-padding w3-margin-right w3-medium\"][1])")).click();
    }

    @And("^I go to Reset page$")
    public void iGoToResetPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(driver.findElement(By.id("person0")).isDisplayed());
        assertTrue(driver.findElement(By.id("person1")).isDisplayed());
        assertTrue(driver.findElement(By.id("person2")).isDisplayed());
    }

    @Given("^I am on People with jobs editing page$")
    public void iAmOnPeopleWithJobsEditingPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html");
    }

    @When("^I enter nametwo: \"([^\"]*)\"$")
    public void iEnterNametwo(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
        
    }

    @And("^I enter jobtwo: \"([^\"]*)\"$")
    public void iEnterJobtwo(String job) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @Then("^I reset the list$")
    public void iResetTheList() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@class=\"w3-btn w3-white w3-border w3-left w3-margin\"][1])")).click();
    }

    @Then("^I didnt see the name and job$")
    public void iDidntSeeTheNameAndJob() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertFalse(driver.findElement(By.className("w3-xlarge name")).isDisplayed());
        assertFalse(driver.findElement(By.className("job")).isDisplayed());
    }

    @Given("^I am on  different action page$")
    public void iAmOnDifferentActionPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }

    @When("^I deleting a person$")
    public void iDeletingAPerson() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.className("w3-closebtn closebtn w3-padding w3-margin-right w3-medium")).click();
    }

    @And("^I click on the reset button$")
    public void iClickOnTheResetButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.className("w3-btn w3-white w3-border w3-left w3-margin")).click();
    }

    @Then("^I see the result$")
    public void iSeeTheResult() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertFalse(driver.findElement(By.className("w3-xlarge name")).isDisplayed());
        assertFalse(driver.findElement(By.className("w3-input")).isDisplayed());

    }

    @Given("^I am on add n ame page$")
    public void iAmOnAddNAmePage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html");

    }

    @When("^I enter new name(\\d+): \"([^\"]*)\"$")
    public void iEnterNewName( String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter new job: \"<job>$")
    public void iEnterNewJobJob(String job) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @And("^i click clear all button$")
    public void iClickClearAllButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.className("w3-btn w3-white w3-border w3-left")).click();
    }

    @Then("^All fields are clear$")
    public void allFieldsAreClear() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertFalse(driver.findElement(By.className("w3-input")).isDisplayed());
        assertFalse(driver.findElement(By.className("w3-input")).isDisplayed());
    }

}



















