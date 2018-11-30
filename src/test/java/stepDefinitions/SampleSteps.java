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
import org.openqa.selenium.support.ui.Select;
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
        driver.findElement(By.className("w3-navbar")).isDisplayed();
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @When("^I enter text$")
    public void iEnterText() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/actions");
        throw new PendingException();
    }

    @And("^I click the result button$")
    public void iClickTheResultButton() throws Throwable {
        driver.findElement(By.id("result_button_text_area")).click();
    }

    @Then("^I see correct result text$")
    public void iSeeCorrectResultText() throws Throwable {
        String text = "You entered text area: \"Cucumber\"";
        assertEquals(text, driver.findElement(By.xpath("//*[@id=\"result_text_area\"]")).getText());
    }

    @When("^I enter text into text field$")
    public void iEnterTextIntoTextField() throws Throwable {
        WebElement enterText = driver.findElement(By.id("text_area"));
        enterText.clear();
        enterText.sendKeys("Cucumber");
    }

    @When("^I enter text \"([^\"]*)\" into text field$")
    public void iEnterIntoTextField(String text) throws Throwable {
        driver.findElement(By.id("text_area")).clear();
        driver.findElement(By.id("text_area")).sendKeys(text);
    }

    @Then("^I see correct result text with text \"([^\"]*)\"$")
    public void iSeeCorrectResultTextWithText(String resultText) throws Throwable {
        assertEquals("You entered text area: \"" + resultText + "\"", driver.findElement(By.xpath("//*[@id=\"result_text_area\"]")).getText());
    }

    @When("^I enter number (\\d+)$")
    public void iEnterNumber(int number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(number));
    }

    @Then("^I see correct result text with text (\\d+)$")
    public void iSeeCorrectResultTextWithText(int resultNumber) throws Throwable {
        assertEquals("You entered text area: \"" + resultNumber + "\"", driver.findElement(By.xpath("//*[@id=\"result_text_area\"]")).getText());
    }

    @When("^I enter number <number>$")
    public void iEnterNumberNumber1(int number) throws Throwable {
        driver.findElement(By.id("text_area")).clear();
        driver.findElement(By.id("text_area")).sendKeys(String.valueOf(number));
    }

    @Then("^I see correct result text with text <resultNumber>$")
    public void iSeeCorrectResultTextWithTextResultNumber(int resultNumber) throws Throwable {
        assertEquals("You entered text area: \"" + resultNumber + "\"", driver.findElement(By.xpath("//*[@id=\"result_text_area\"]")).getText());

    }

    @Given("^I am on enter a number page$")
    public void iAmOnEnterANumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number \"([^\"]*)\"$")
    public void iEnterNumber(String myNumber) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(myNumber));
    }

    @And("^I click the submit button$")
    public void iClickTheSubmitButton() throws Throwable {
        driver.findElement(By.className("w3-orange")).click();
    }


    @Then("^I see error message text \"([^\"]*)\"$")
    public void iSeeErrorMessageText(String errorMessage) throws Throwable {
        assertEquals(errorMessage, driver.findElement(By.className("error")).getText());
    }


    @Then("^I see result is \"([^\"]*)\"$")
    public void iSeeResultIs(String correctMessage) throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals(correctMessage, alert.getText());
    }

    @Then("^I see error if I enter numbers:$")
    public void iSeeErrorIfIEnterNumbers(Map<String, String> numbersToEnter) throws Throwable {
        for (Map.Entry<String, String> firstChecks : numbersToEnter.entrySet()) {
            driver.findElement(By.id("numb")).clear();
            driver.findElement(By.id("numb")).sendKeys(firstChecks.getKey());
            driver.findElement(By.className("w3-btn")).click();
            assertEquals(firstChecks.getValue(), driver.findElement(By.id("ch1_error")).getText());
        }
    }

    @Given("^I am on people list page$")
    public void iAmOnPeopleListPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }

    @When("^I click add person button$")
    public void iClickAddPersonButton() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @Then("^I click add button$")
    public void iClickAddButton() throws Throwable {
        driver.findElement(By.id("modal_button")).click();
    }


    @And("^I enter surname: \"([^\"]*)\"$")
    public void iEnterSurname(String surname) throws Throwable {
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys(surname);
    }

    @And("^I enter person name: \"([^\"]*)\"$")
    public void iEnterPersonName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }


    @And("^I enter job title: \"([^\"]*)\"$")
    public void iEnterJobTitle(String jobTitle) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(jobTitle);
    }


    @And("^I choose date of birth: \"([^\"]*)\"$")
    public void iChooseDateOfBirth(String dateOfBirth) throws Throwable {

        WebElement dateBox = driver.findElement(By.id("dob"));
        assertEquals("", dateBox.getAttribute("value"));

        dateBox.clear();
        dateBox.sendKeys(dateOfBirth);
        assertEquals(dateOfBirth, dateBox.getAttribute("value"));
    }

    @And("^I select employee status: \"([^\"]*)\"$")



    @Then("^I see new person in a list$")
    public void iSeeNewPersonInAList() throws Throwable {
        assertTrue(driver.findElement(By.id("person3")).isDisplayed());
    }


    @And("^I choose language:$")
    public void iSelectLanguages() throws Throwable {
        assertTrue(driver.findElement(By.cssSelector(".w3-check[id='english'][type='checkbox']")).isSelected());
    }


    @And("^I choose employee status: \"([^\"]*)\"$")
    public void iSelectEmployeeStatus(String status) throws Throwable {
        Select dropdown = new Select(driver.findElement(By.id("status")));
        assertEquals("Employee", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Contractor");
        assertEquals("Contractor", dropdown.getFirstSelectedOption().getText());
    }

    @And("^I choose gender: \"([^\"]*)\"$")
    public void iSelectGender(String gender) throws Throwable {
        WebElement female = driver.findElement(By.id("female"));
        assertFalse(female.isSelected());
        female.click();
    }


    @When("^I click on edit button$")
    public void iClickOnEditButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id='person2']/span[2]")).click();
    }

    @Given("^I am on entered person page$")
    public void iAmOnEnteredPersonPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_new_person.html");
    }

    @Then("^I see editing page$")
    public void iSeeEditingPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_new_person.html?id=2");
    }


    @And("^I edit surname to: \"([^\"]*)\"$")
    public void iEditSurnameTo(String surnameEdit) throws Throwable {
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys("Pupkin");
    }

    @And("^I click edit button$")
    public void iClickEditButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id='modal_button']")).click();
    }

    @Then("^I see edited person in a list$")
    public void iSeeEditedPersonInAList() throws Throwable {
        assertEquals(driver.findElement(By.xpath("//*[@id='person2']/div/span[1]")).getText(), "Vasja");
        assertEquals(driver.findElement(By.xpath("//*[@id='person2']/div/span[2]")).getText(), "Pupkin");
    }


    @And("^I click on delete button$")
    public void iClickOnDeleteButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id='person0']/span[1]")).click();
    }


    @Then("^I see a list without a deleted person$")
    public void iSeeAListWithoutADeletedPerson() throws Throwable {
        assertTrue(driver.findElements(By.cssSelector(".w3-closebtn[onclick='deletePerson(0)']")).isEmpty());
    }


    @And("^I edit name to: \"([^\"]*)\"$")
    public void andIEditNameTo(String nameEdit) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Vasja");
    }

    @And("^I click on reset list button$")
    public void iClickOnResetListButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id='addPersonBtn'][2]"));
    }

    @Then("^I see list is reset$")
    public void iSeeListIsReset() throws Throwable {
       assertTrue(driver.findElement(By.id("person0")).isDisplayed());
        assertTrue(driver.findElement(By.id("person1")).isDisplayed());
        assertTrue(driver.findElement(By.id("person2")).isDisplayed());
    }

    @Then("^I see list is reset correctly$")
    public void iSeeListIsResetCorrectly() throws Throwable {
        assertTrue(driver.findElement(By.id("person1")).isDisplayed());
        assertTrue(driver.findElement(By.id("person2")).isDisplayed());
    }

    @And("^I click on clear all button$")
    public void iClickOnClearAllButton() throws Throwable {
        driver.findElement(By.id("addPersonBtn"));
    }

    @Then("^I see list is clear$")
    public void iSeeListIsClear() throws Throwable {
        assertEquals("", driver.findElement(By.id("name")).getText());
        assertEquals("", driver.findElement(By.id("surname")).getText());
    }
}







