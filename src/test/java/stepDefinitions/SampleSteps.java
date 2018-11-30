package stepDefinitions;

import com.sun.org.glassfish.external.statistics.annotations.Reset;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.En;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;
import java.util.NoSuchElementException;

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
        WebElement textBox =  driver.findElement(By.id("text"));
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

    //(--------------------//-------------------------))

    @Given("^I am on enter a number page$")
    public void iAmOnEnterANumberPage() throws Throwable {

        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter a number: \"([^\"]*)\"$")
    public void iEnterANumber(String num) throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"numb\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"numb\"]")).sendKeys(num);
    }

    @And("^I click submit number$")
    public void iClickSubmitNumber() throws Throwable {

        driver.findElement(By.className("w3-orange")).click();
    }

    @Then("^I see an error: \"([^\"]*)\"$")
        public void iSeeAnError(String error) throws Throwable {

        assertTrue(driver.findElement(By.xpath("//*[@id=\"ch1_error\"]")).isDisplayed());
        assertEquals(driver.findElement(By.xpath("//*[@id=\"ch1_error\"]")).getText(), "Please enter a number");

    }

    @Then("^I see popup message$")
    public void iSeePopupMessage() throws Throwable {

        Alert alert = driver.switchTo().alert();
        assertEquals("Square root of 64 is 8.00", alert.getText());
    }

    @And("^I close the popup$")
    public void iCloseThePopup() throws Throwable {

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    @When("^I am on enter number page$")
    public void IamOnEnterNumberPage () throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");

    }

    @Then("^I see error if I enter numbers:$")
    public void iSeeErrorIfIEnterNumbers(Map<String, String> numberToEnter) throws Throwable {
        for (Map.Entry<String, String> firstChecks : numberToEnter.entrySet()) {
            driver.findElement(By.id("numb")).clear();
            driver.findElement(By.id("numb")).sendKeys(firstChecks.getKey());
            driver.findElement(By.cssSelector(".w3-btn")).click();
            assertEquals(firstChecks.getValue(), driver.findElement(By.id("ch1_error")).getText());
        }
    }

    @When("^I am on number page$")
    public void iAmOnNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }
// (------------------------------//-------------------------------------)
    @Given("^I am on page people with Job list$")
    public void IAmOnPagePeopleWithJobList() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs");
    }

    @When ("^I click on add person$")
    public void IClickOnAddPerson() throws Throwable {
        WebElement CreateButton = driver.findElement((By.id("addPersonBtn")));
        CreateButton.click();
        Thread.sleep(1000);
    }
    @And ("^I add a person name$")
    public void AndIAddAPersonName() throws Throwable {
        WebElement NameField = driver.findElement(By.id("name"));
        NameField.sendKeys("John");
        Thread.sleep(1000);
    }
    @Then ("^I give a job to the person$")
    public void IGiveAJobToThePerson() throws Throwable {
        WebElement JobField = driver.findElement(By.id("job"));
        JobField.sendKeys("Knight");
        Thread.sleep(1000);
    }
    @And ("^I add the person to the list$")
    public void IAddThePersonToTheList() throws Throwable {
        WebElement AddButton = driver.findElement(By.id("modal_button"));
        AddButton.click();
        Thread.sleep(1000);
    }
   @Then ("^I check the created person$")
   public void ICheckTheCreatedPerson() throws  Throwable {
        WebElement CreatedPersonName = driver.findElement(By.xpath("//*[@id=\"person3\"]/span[3]"));
       assertEquals(CreatedPersonName.getText(), "John");
       System.out.println(CreatedPersonName.getText());
       WebElement CreatedPersonJob = driver.findElement(By.xpath("//*[@id=\"person3\"]/span[4]"));
       assertEquals(CreatedPersonJob.getText(), "Knight");
       System.out.println(CreatedPersonJob.getText());
       Thread.sleep(1000);
   }
    @When ("^I click the Edit button$")
     public void IClickTheEditButton() throws Throwable {
        WebElement EditButton = driver.findElement(By.xpath("//*[@id=\"person0\"]/span[2]/i"));
        EditButton.click();
        Thread.sleep(1000);
    }
    @Then ("^I delete name$")
    public void IChangeName() throws Throwable {
        WebElement NameChange = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        NameChange.clear();
        Thread.sleep(1000);
    }
    @And ("^I enter a new name$")
    public void IEnterANewName() throws Throwable {
        WebElement NewName = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        NewName.sendKeys("John");
        Thread.sleep(1000);
    }
    @Then ("^I change the persons Job$")
    public void IChangeThePersonsJob() throws Throwable {
        WebElement NewJob = driver.findElement(By.xpath("//*[@id=\"job\"]"));
        NewJob.clear();
        NewJob.sendKeys("Pokemon");
        Thread.sleep(1000);
    }
    @And ("^I confirm Edit$")
    public void IConfirmEdit() throws Throwable {
        WebElement ConfirmEdit = driver.findElement(By.xpath("//*[@id=\"modal_button\"]"));
        ConfirmEdit.click();
        Thread.sleep(1000);
    }
    @Then ("^I check the Edited fields$")
    public void ICheckTheEditedFields() throws Throwable {
        WebElement NewName = driver.findElement(By.xpath("//*[@id=\"person0\"]/span[3]"));
        assertEquals(NewName.getText(), "John");
        WebElement NewJob = driver.findElement((By.xpath("//*[@id=\"person0\"]/span[4]")));
        assertEquals(NewJob.getText(), "Pokemon");
        Thread.sleep(1000);
    }
    @When ("^I click on delete button$")
    public void IClickOnDeleteButton() throws Throwable {
        WebElement Delete = driver.findElement(By.xpath("//*[@id=\"person0\"]/span[1]"));
        Delete.click();
        Thread.sleep(1000);
    }

    @Then ("^I check if the person is deleted$")
    public void ICheckIfThePersonIsDeleted() throws Throwable {
        Boolean Person = driver.findElements(By.id("//*[text()[contains(.,'Mike')]]")).size() == 0;
    }
    @When ("^I add a new person$")
    public void IAddANewPerson() throws Throwable {
        WebElement CreateButton = driver.findElement((By.id("addPersonBtn")));
        CreateButton.click();
        WebElement NameField = driver.findElement(By.id("name"));
        NameField.sendKeys("John");
        WebElement JobField = driver.findElement(By.id("job"));
        JobField.sendKeys("Knight");
        WebElement AddButton = driver.findElement(By.id("modal_button"));
        AddButton.click();
    }
    @Then ("^I reset the list$")
    public void IResetTheList() throws Throwable {
        WebElement ResetButton = driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]"));
        ResetButton.click();
    }
    @And ("^I check if the person is still there$")
    public void ICheckIfThePersonIsStillThere() throws Throwable {
        Boolean ResetPerson = driver.findElements(By.id("//*[text()[contains(.,'John')]]")).size() == 0;
    }
    @Then ("^I edit a person$")
    public void IEditAPerson() throws Throwable {
        WebElement EditButton = driver.findElement(By.xpath("//*[@id=\"person0\"]/span[2]/i"));
        EditButton.click();
        WebElement NameChange = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        NameChange.clear();
        WebElement NewName = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        NewName.sendKeys("John");
        WebElement ConfirmEdit = driver.findElement(By.xpath("//*[@id=\"modal_button\"]"));
        ConfirmEdit.click();
    }
    @Then ("^I check the list for changes$")
    public void ICheckTheListForChanges() throws Throwable{
        Boolean ResetPerson = driver.findElements(By.id("//*[text()[contains(.,'Mike')]]")).size() == 0;
        WebElement NewPerson = driver.findElement(By.xpath("//*[@id=\"person0\"]/span[3]"));
        assertEquals(NewPerson.getText(), "John");
    }
    @And ("^I check the list for changes again$")
    public void ICheckTheListForChangesAgain() throws Throwable{
        Boolean ResetPerson = driver.findElements(By.id("//*[text()[contains(.,'John')]]")).size() == 0;
        WebElement NewPerson = driver.findElement(By.className("name"));
        assertEquals(NewPerson.getText(), "Mike");
    }
    @When ("^I delete a person$")
    public void IDeleteAPerson() throws Throwable{
        WebElement DeleteButton = driver.findElement(By.xpath("//*[@id=\"person0\"]/span[1]"));
        DeleteButton.click();
    }
    @When("^check the list for the person$")
    public void check_the_list_for_the_person() throws Throwable {
        Boolean DeletedPerson = driver.findElements(By.id("//*[text()[contains(.,'Mike')]]")).size() == 0;
    }
    @And ("^check the list for the person once more$")
    public void check_the_list_for_the_person_once_more() throws Throwable {
        WebElement PersonIsThere = driver.findElement(By.xpath("//*[@id=\"person0\"]/span[3]"));
        assertEquals(PersonIsThere.getText(), "Mike");
    }

    @When("^I create a person$")
    public void i_create_a_person() throws Throwable {
WebElement AddPersonButton = driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]"));
AddPersonButton.click();
    }
    @Then("^I enter name$")
    public void i_enter_name() throws Throwable {
      WebElement EnterName = driver.findElement(By.xpath("//*[@id=\"name\"]"));
      EnterName.sendKeys("Andrew");
    }
    @Then("^I enter a Job$")
    public void i_enter_a_Job() throws Throwable {
    WebElement EnterJob = driver.findElement(By.xpath("//*[@id=\"job\"]"));
    EnterJob.sendKeys("Programmer");
    }
    @Then("^I use clear all fields button$")
    public void i_use_clear_all_fields_button() throws Throwable {
    WebElement ClearAllKey = driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]"));
    ClearAllKey.click();
    }
    @Then("^I check if the fields are clear now$")
    public void i_check_if_the_fields_are_clear_now() throws Throwable {
        WebElement EnterName = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        WebElement EnterJob = driver.findElement(By.xpath("//*[@id=\"job\"]"));
        assertEquals(EnterName.getText(), "");
        assertEquals(EnterJob.getText(), "");
    }
}