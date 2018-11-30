package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages_sample.AgePage;
import sun.awt.windows.WEmbeddedFrame;

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

    @Then("^I see message: \"(.*)\"$")
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
        String someText = "good";
        WebElement textBox = driver.findElement(By.id("text"));
        textBox.clear();
        textBox.sendKeys(someText);
    }

    @And("^I click result button$")
    public void iClickResultButton() throws Throwable {
        driver.findElement(By.id("result_button_text")).click();
    }

    @Then("^I see correct result text$")
    public void iSeeCorrectResultText() throws Throwable {
        String text = "You entered text: \"good\"";
        assertEquals(text, driver.findElement(By.id("result_text")).getText());
    }

    @When("^I enter \"([^\"]*)\" text$")
    public void iEnterText(String text) throws Throwable {
        WebElement textBox = driver.findElement(By.id("text"));
        textBox.clear();
        textBox.sendKeys(text);
    }

    @Then("^I see correct result with text \"([^\"]*)\"$")
    public void iSeeCorrectResultWithText(String text) throws Throwable {
        assertEquals("You entered text: \"" + text + "\"", driver.findElement(By.id("result_text")).getText());

    }

    @When("^I enter number (\\d+)$")
    public void iEnterNumber(int number) throws Throwable {
        WebElement numberBox = driver.findElement(By.id("number"));
        numberBox.clear();
        numberBox.sendKeys(String.valueOf(number));
    }

    @And("^I click result number button$")
    public void iClickResultNumberButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("result_button_number")).click();
    }

    @Then("^I see correct result with text (\\d+)$")
    public void iSeeCorrectResultWithText(int number) throws Throwable {
        assertEquals("You entered number: \"" + String.valueOf(number) + "\"", driver.findElement(By.id("result_number")).getText());
    }

    @When("^I am on enter a number page$")
    public void iAmOnEnterANumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @Then("^I enter a number: (\\d+)$")
    public void iEnterANumber(int number) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(number));
    }

    @And("^I click submit button$")
    public void iClickSubmitButton() throws Throwable {
        driver.findElement(By.cssSelector(".w3-btn")).click();
    }

    @And("^I check alert message$")
    public void iCheckAlertMessage() throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 64 is 8.00", alert.getText());
    }

    @Then("^I click OK in alert message$")
    public void iClickOKInAlertMessage() throws Throwable {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Then("^I enter an incorrect number \"([^\"]*)\"$")
    public void iEnterAnIncorrectNumber(String number) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(number);
    }

    @And("^I check error message \"([^\"]*)\"$")
    public void iCheckErrorMessage(String text) throws Throwable {
        assertEquals(text, driver.findElement(By.id("ch1_error")).getText());

    }

    @Then("^I see error if I enter numbers:$")
    public void iSeeErrorIfIEnterNumbers(Map<String, String> numbersToEnter) throws Throwable {
        for (Map.Entry<String, String> firstchecks : numbersToEnter.entrySet()) {
            driver.findElement(By.id("numb")).clear();
            driver.findElement(By.id("numb")).sendKeys(firstchecks.getKey());
            driver.findElement(By.cssSelector(".w3-btn")).click();
            assertEquals(firstchecks.getValue(), driver.findElement(By.id("ch1_error")).getText());
            System.out.println("number is " + firstchecks.getKey());
            System.out.println("error is " + firstchecks.getValue());
        }
    }

    @Given("^I am on people with job list page$")
    public void iAmOnPeopleWithJobListPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs");
    }

    @Then("^I click Add person button$")
    public void iClickAddPersonButton() throws Throwable {
        WebElement addPersonButton = driver.findElement(By.cssSelector("[onclick=\"openModalForAddPersonWithJob()\"]"));
        addPersonButton.click();
    }

    @And("^I enter firstname: \"([^\"]*)\"$")
    public void iEnterFirstname(String firstname) throws Throwable {
        driver.findElement(By.id("name")).sendKeys(firstname);

    }

    @And("^I enter job: \"([^\"]*)\"$")
    public void iEnterJob(String job) throws Throwable {
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @Then("^I click Add button$")
    public void iClickAddButton() throws Throwable {
        WebElement addButton = driver.findElement(By.cssSelector("[onclick='addPersonWithJobToList()']"));
        addButton.click();
    }

    @Then("^I check the added person \"([^\"]*)\" and \"([^\"]*)\" is in the list$")
    public void iCheckTheAddedPersonAndIsInTheList(String name, String job) throws Throwable {
        WebElement nameInList = driver.findElement(By.cssSelector("#person3 > .w3-xlarge"));
        assertEquals(name, nameInList.getText());
        WebElement jobInList = driver.findElement(By.cssSelector("#person3 > .job"));
        assertEquals(job, jobInList.getText());

    }

    @And("^I click edit person button$")
    public void iClickEditPersonButton() throws Throwable {
        driver.findElement(By.cssSelector("[onclick='openModalForEditPersonWithJob(3)']")).click();
    }

    @And("^I change name to: \"([^\"]*)\"$")
    public void iChangeNameTo(String newname) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(newname);
    }

    @And("^I change job to: \"([^\"]*)\"$")
    public void iChangeJobTo(String newjob) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(newjob);
    }

    @Then("^I click edit button$")
    public void iClickEditButton() throws Throwable {
        driver.findElement(By.cssSelector("[onclick='editPersonWithJob(3)']")).click();
    }

    @And("^I check the edited person name \"([^\"]*)\" and job \"([^\"]*)\" in the list$")
    public void iCheckTheEditedPersonNameAndJobInTheList(String newname, String newjob) throws Throwable {
        WebElement nameInList = driver.findElement(By.cssSelector("#person3 > .w3-xlarge"));
        assertEquals(newname, nameInList.getText());
        WebElement jobInList = driver.findElement(By.cssSelector("#person3 > .job"));
        assertEquals(newjob, jobInList.getText());
    }


    @Then("^I click delete button$")
    public void iClickDeleteButton() throws Throwable {
        driver.findElement(By.cssSelector("[onclick='deletePerson(0)']")).click();
    }

    @And("^I check the deleted person disappeared from list$")

    public void iCheckTheDeletedPersonDisappearedFromList() throws Throwable {
        assertEquals(0, driver.findElements(By.cssSelector("#person0")).size());
    }


    @And("^click reset button$")
    public void clickResetButton() throws Throwable {
        driver.findElement(By.cssSelector("[onclick='resetListOfPeople()']")).click();
    }

    @And("^check the added person dissapeared$")
    public void checkTheAddedPersonDissapeared() throws Throwable {
        assertEquals(0, driver.findElements(By.cssSelector("#person3")).size());
    }


    @And("^check the edited person dissapeared$")
    public void checkTheEditedPersonDissapeared() throws Throwable {
        assertEquals(0, driver.findElements(By.cssSelector("#person3")).size());
    }

    @Then("^I check the list is correct$")
    public void iCheckTheListIsCorrect() throws Throwable {
        assertEquals("Mike", driver.findElement(By.cssSelector("#person0 > .name")).getText());
        assertEquals("Web Designer", driver.findElement(By.cssSelector("#person0 > .job")).getText());
        assertEquals("Jill", driver.findElement(By.cssSelector("#person1 > .name")).getText());
        assertEquals("Support", driver.findElement(By.cssSelector("#person1 > .job")).getText());
        assertEquals("Jane", driver.findElement(By.cssSelector("#person2 > .name")).getText());
        assertEquals("Accountant", driver.findElement(By.cssSelector("#person2 > .job")).getText());
    }


    @Then("^I click clear all button$")
    public void iClickClearAllButton() throws Throwable {
        driver.findElement(By.cssSelector("[onclick='openModalForAddPersonWithJob()']")).click();
    }

    @And("^I check name and job fields are empty$")
    public void iCheckNameAndJobFieldsAreEmpty() throws Throwable {
        assertEquals("", driver.findElement(By.id("name")).getAttribute("value"));
        assertEquals("", driver.findElement(By.id("job")).getAttribute("value"));
    }
}
