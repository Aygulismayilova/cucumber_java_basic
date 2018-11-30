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
        driver.get("https://kristinek.github.io/site/examples/age");
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

    @And("^I click the result button$")
    public void iClickTheResultButton() throws Throwable {
        driver.findElement(By.id("result_button_text")).click();
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

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on number page$")
    public void iAmOnNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @And("^I click submit button$")
    public void iClickSubmitButton() throws Throwable {
        driver.findElement(By.cssSelector(".w3-btn")).click();
    }

    @When("^I see error if I enter numbers$")
    public void iSeeErrorIfIEnterNumbers(Map<String, String> numbersToEnter) throws Throwable {
        for (Map.Entry<String, String> firstChecks : numbersToEnter.entrySet()) {
            //    firstChecks.getKey();
            driver.findElement(By.id("numb")).clear();
            driver.findElement(By.id("numb")).sendKeys(firstChecks.getKey());
            driver.findElement(By.cssSelector(".w3-btn")).click();
            assertEquals(firstChecks.getValue(), driver.findElement(By.id("ch1_error")).getText());

        }
    }

    //  for Task 2


    @Given("^I am on job page$")
    public void iAmOnJobPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs");
    }

    @When("^I click add person button$")
    public void iClickAddPersonButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id='addPersonBtn'][1]")).click();
    }

    @Then("^new person card \"([^\"]*)\" is displayed$")
    public void newPersonCardIsDisplayed(String jobForm) throws Throwable {
        assertEquals(jobForm, driver.findElement(By.cssSelector("body h2")).getText());
        assertTrue(driver.findElement(By.cssSelector("body h2")).isDisplayed());
    }

    @And("^name and job input field are displayed$")
    public void nameAndJobInputFieldAreDisplayed() throws Throwable {
        assertTrue(driver.findElement(By.id("name")).isDisplayed());
        assertTrue(driver.findElement(By.id("job")).isDisplayed());
    }

    @And("^buttons: add, cancel and clear are displayed$")
    public void buttonsAddCancelAndClearAreDisplayed() throws Throwable {
        assertTrue(driver.findElement(By.cssSelector("div #modal_button:nth-child(1)")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("div #modal_button:nth-child(2)")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("div #addPersonBtn")).isDisplayed());
    }

    @When("^I enter new name: \"([^\"]*)\"$")
    public void iEnterNewName(String name) throws Throwable {
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter new job: \"([^\"]*)\"$")
    public void iEnterNewJob(String job) throws Throwable {
        driver.findElement(By.id("job")).sendKeys(job);

    }

    @And("^click Add button$")
    public void clickAddButton() throws Throwable {
        driver.findElement(By.cssSelector("div #modal_button:nth-child(1)")).click();
        Thread.sleep(1500);
    }

    @Then("^new person card with \"([^\"]*)\" \"([^\"]*)\" is created$")
    public void newPersonCardWithIsCreated(String name, String job) throws Throwable {
        assertTrue(driver.findElement(By.id("person3")).isDisplayed());
        assertEquals(name, driver.findElement(By.cssSelector("#person3 .name")).getText());
        assertEquals(job, driver.findElement(By.cssSelector("#person3 > .job")).getText());
    }
    // Editing a person

    @When("^I click edit person button$")
    public void iClickEditPersonButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id='person0']/span[2]")).click();
    }

    @Then("^person card \"([^\"]*)\" is displayed$")
    public void personCardIsDisplayed(String editForm) throws Throwable {
        assertEquals(editForm, driver.findElement(By.cssSelector("body h2")).getText());
        assertTrue(driver.findElement(By.cssSelector("#addEditPerson")).isDisplayed());
    }

    @When("^I edit job name as: \"([^\"]*)\"$")
    public void iEditJobNameAs(String editJobName) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(editJobName);
    }

    @And("^And save changes$")
    public void andSaveChanges() throws Throwable {
        driver.findElement(By.cssSelector("#modal_button")).click();
    }

    @Then("^Changes are saved successfully as: \"([^\"]*)\"$")
    public void changesAreSavedSuccessfullyAs(String editJobName) throws Throwable {
        assertEquals(editJobName, driver.findElement(By.cssSelector("#person0 > .job")).getText());
    }

    @When("^I click delete person button$")
    public void iClickDeletePersonButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id='person0']/span[1]")).click();
    }

    @When("^I click delete person button for \"([^\"]*)\"$")
    public void iClickDeletePersonButtonFor(String name) throws Throwable {
        driver.findElement(By.xpath("//*[@id='person0']/span[1]")).click();
    }

    @Then("^The person is successfully deleted$")
    public void thePersonIsSuccessfullyDeleted() throws Throwable {
        assertTrue(driver.findElements(By.cssSelector("#person0 > .name")).isEmpty());
    }

    @And("^Click reset list button$")
    public void clickResetListButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id='addPersonBtn'][2]")).click();
    }

    @Then("^The job list becomes resetted$")
    public void theJobListBecomesResetted() throws Throwable {
        assertEquals("Mike", driver.findElement(By.cssSelector("#person0 > .name")).getText());
        assertEquals("Jill", driver.findElement(By.cssSelector("#person1 > .name")).getText());
        assertEquals("Jane", driver.findElement(By.cssSelector("#person2 > .name")).getText());
        assertEquals("Web Designer", driver.findElement(By.cssSelector("#person0 > .job")).getText());
        assertEquals("Support", driver.findElement(By.cssSelector("#person1 > .job")).getText());
        assertEquals("Accountant", driver.findElement(By.cssSelector("#person2 > .job")).getText());
        assertTrue(driver.findElements(By.cssSelector("#person3 > .name")).isEmpty());

    }

    @Then("^I click clear all fields button$")
    public void iClickClearAllFieldsButton() throws Throwable {
       driver.findElement(By.id("addPersonBtn")).click();
    }

    @And("^The fields become empty$")
    public void theFieldsBecomeEmpty() throws Throwable {
        assertEquals("", driver.findElement(By.id("name")).getText());
        assertEquals("", driver.findElement(By.id("job")).getText());
    }
}
