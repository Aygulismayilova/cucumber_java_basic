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
import pages_sample.AgeSubmittedPage;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SampleSteps {
    private WebDriver driver;
    static PeoplePage peoplePage;


    public SampleSteps() {
        this.driver = Hooks.driver;
        peoplePage = PageFactory.initElements(Hooks.driver, PeoplePage.class);
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

    @And("^I shoul see menu$")
    public void iShoulSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.cssSelector(".w3-navbar")).isDisplayed());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @When("^I enter text$")
    public void iEnterText() throws Throwable {
        WebElement text = driver.findElement(By.cssSelector("#text"));
        text.clear();
        text.sendKeys("bla-bla");
    }

    @And("^I click the result button$")
    public void iClickTheResultButton() throws Throwable {
        driver.findElement(By.cssSelector("#result_button_text")).click();
    }

    @Then("^I see correct result text$")
    public void iSeeCorrectResultText() throws Throwable {
        assertEquals("You entered text: \"bla-bla\"", driver.findElement(By.cssSelector("#result_text")).getText());
    }

    @When("^I enter \"([^\"]*)\" text$")
    public void iEnterText(String text) throws Throwable {
        driver.findElement(By.cssSelector("#text")).clear();
        driver.findElement(By.cssSelector("#text")).sendKeys(text);
    }

    @Then("^I see correct result  with text \"([^\"]*)\"$")
    public void iSeeCorrectResultWithText(String text) throws Throwable {
        assertEquals(text, driver.findElement(By.cssSelector("#text")).getAttribute("value"));
    }


    @When("^I enter number \"([^\"]*)\"$")
    public void iEnterNumber(String number) throws Throwable {
        driver.findElement(By.cssSelector("#number")).clear();
        driver.findElement(By.cssSelector("#number")).sendKeys(number);

    }

    @And("^I click the result number button$")
    public void iClickTheResultNumberButton() throws Throwable {
        driver.findElement(By.cssSelector("#result_button_number")).click();
    }

    @Then("^I see correct result  with text the number \"([^\"]*)\"$")
    public void iSeeCorrectResultWithTextTheNumber(String numberText) throws Throwable {
        assertEquals(numberText, driver.findElement(By.cssSelector("#number")).getAttribute("value"));
    }

    @Given("^I am on action page(\\d+)$")
    public void iAmOnActionPage(int arg0) throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I tap \"([^\"]*)\" number$")
    public void iTapNumber(String number) throws Throwable {
        driver.findElement(By.cssSelector("#numb")).sendKeys(number);
    }

    @And("^I click the submit button$")
    public void iClickTheSubmitButton() throws Throwable {
        driver.findElement(By.cssSelector(".w3-btn.w3-orange.w3-margin")).click();
    }


    @Then("^I see correct resultaaa  with text \"([^\"]*)\"$")
    public void iSeeCorrectResultaaaWithText(String ErrorText) throws Throwable {
        assertEquals(ErrorText, driver.findElement(By.id("ch1_error")).getText());
    }

    @Then("^Accept the alert$")
    public void acceptTheAlert() throws Throwable {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        assertEquals("", driver.findElement(By.id("ch1_error")).getText());
    }

    @When("^I enter num and see the error:$")
    public void iTapNumberAndSeeTheError(Map<String, String> myList) throws Throwable {
        for (Map.Entry <String, String> e : myList.entrySet()) {
            driver.findElement(By.id("numb")).clear();
            driver.findElement(By.id("numb")).sendKeys(e.getKey());
            driver.findElement(By.cssSelector(".w3-btn")).click();
            assertEquals(e.getValue(), driver.findElement(By.cssSelector("#ch1_error")).getText());
        }
    }





//----------------------------------------------------------------------------------------------------------------



    @Given("^I am on page Poeple$")
    public void iAmOnPagePoeple() throws Throwable {
       driver.get(peoplePage.getPageUrlOne());
    }

    @Then("^I click on Add person$")
    public void iClickOnAddPerson() throws Throwable {
        peoplePage.addClick();
    }


    @Then("^In new page I enter name: \"([^\"]*)\"$")
    public void inNewPageIEnterName(String name) throws Throwable {
            peoplePage.enterName(name);
    }

    @Then("^In new page I enter job: \"([^\"]*)\"$")
    public void inNewPageIEnterJob(String job) throws Throwable {
        peoplePage.enterJob(job);
    }

    @Then("^I click on Add in the second page$")
    public void iClickOnAddInTheSecondPage() throws Throwable {
       peoplePage.addClickOnSecondPage();
    }

    @Then("^I compare added new person in the list$")
    public void iCompareAddedNewPersonInTheList() throws Throwable {
        assertEquals("Alina", peoplePage.textNewPersonasName());
        assertEquals("Without job", peoplePage.textNewPersonasJob());
    }

    @Then("^I click on EditPerson$")
    public void iClickOnEditPerson() throws Throwable {
        peoplePage.edditOnFirstPage();
    }



    @Then("^I click on Delete a new person$")
    public void iClickOnDeleteANewPerson() throws Throwable {
        peoplePage.deleteTheLastPerson();
    }


    @Then("^I Edit person data$")
    public void iEditPersonData() throws Throwable {
        peoplePage.enterNameSecondPage("Alina");
        peoplePage.cancelSecondPage();
    }

    @Then("^I compare all new data$")
    public void iCompareAllNewData() throws Throwable {
       assertEquals("Alina",peoplePage.janePersonasName());
    }

    @Then("^I compare that persona is deleted$")
    public void iCompareThatPersonaIsDeleted() throws Throwable {
        assertEquals(0, driver.findElements(By.cssSelector("#person2")).size());
    }

    @Then("^I reset the page$")
    public void iResetThePage() throws Throwable {
        peoplePage.resetOnPage();
    }

    @Then("^I compare tree persons in the page$")
    public void iCompareTreePersonsInThePage() throws Throwable {
        assertEquals(3, driver.findElements(By.cssSelector(".w3-padding-16")).size());
    }

    @Then("^Click on Clear all fields$")
    public void clickOnClearAllFields() throws Throwable {
        peoplePage.clickClearAllFields();
    }

    @Then("^Compare that the fields are empty$")
    public void compareThatTheFieldsAreEmpty() throws Throwable {
        assertEquals("", peoplePage.textNameSecondPage());
        assertEquals("", peoplePage.enterJob());
    }
}