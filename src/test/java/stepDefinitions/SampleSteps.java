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
        WebElement text =  driver.findElement(By.cssSelector("#text"));
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


    @Given("^I am on enterNumber page$")
    public void iAmOnEnterNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number in Number page: \"([^\"]*)\"$")
    public void iEnterNumb(String number) throws Throwable {
        driver.findElement(By.cssSelector("#numb")).clear();
        driver.findElement(By.cssSelector("#numb")).sendKeys(number);

    }
    @And("^I click submit number$")
    public void iClickTheNumberButton() throws Throwable {
        driver.findElement(By.cssSelector("body > div.w3-row > div > div > div.w3-container.w3-card-4 > button")).click();
    }

    @Then("^I see correct result text Notification: \"(.*)\"$")
    public void iSeeMessage1(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }
    @Then("^Accept the alert: \"(.*)\"$")
    public void iAcceptAlert(String message) throws Throwable {
        Alert alert = driver.switchTo().alert();

        assertEquals(message, alert.getText());
    }
    @Then("^I enter numbers i see a message error$")
    public void iEntValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id("numb")).clear();
            driver.findElement(By.id("numb")).sendKeys(e.getKey());
            iClickTheNumberButton();

        iSeeMessage1(e.getValue());

        }
    }
                    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    @Given("^I am on People with Jobs page$")
    public void iAmOnPeopleJobPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs");
    }
    @When("^I click on add a new person$")
    public void iClickaddanewPer() throws Throwable {
        driver.findElement(By.cssSelector("#addPersonBtn")).click();
    }
    @And("^I enter valuess and Submit:$")
    public void iEnterValuess(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            Thread.sleep(1000);
        } driver.findElement(By.cssSelector("#modal_button")).click();
    }


    @Then("^go back to Jobs Page check if new Person Is added$")
    public void goBackToJobsPageCheckIfNewPersonIsAdded() throws Throwable {
        Thread.sleep(1000);
        assertEquals("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html",driver.getCurrentUrl());
        assertTrue(driver.findElement(By.id("person3")).isDisplayed());
}

    @When("^I click on edit a person$")
    public void iClickOnEditAPerson() throws Throwable {
        driver.findElement(By.cssSelector("#person0 > span.w3-closebtn.editbtn.w3-padding.w3-margin-right.w3-medium")).click();
        Thread.sleep(2000);
    }

    @Then("^go back to Jobs Page check if Information were Updated$")
    public void goBackToJobsPageCheckIfInformationWereUpdated() throws Throwable {
        Thread.sleep(1000);
        assertEquals("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html",driver.getCurrentUrl());

        assertEquals("Faycel",driver.findElement(By.cssSelector("#person0 > span.w3-xlarge.name")).getText());
        assertEquals("Banks",driver.findElement(By.cssSelector("#person0 > span.job")).getText());

    }

    @When("^I click on delete a person$")
    public void iClickOnDeleteAPerson() throws Throwable {
        driver.findElement(By.cssSelector("#person0 > span.w3-closebtn.closebtn.w3-padding.w3-margin-right.w3-medium")).click();
    }

    @Then("^go back to Jobs Page check if the person was deleted$")
    public void goBackToJobsPageCheckIfThePersonWasDeleted() throws Throwable {
        Thread.sleep(2000);
        assertEquals("https://kristinek.github.io/site/tasks/list_of_people_with_jobs",driver.getCurrentUrl());
        assertEquals(0,driver.findElements(By.id("person0")).size());
    }

    @And("^I click on reset$")
    public void iClickOnReset() throws Throwable {

        driver.findElement(By.cssSelector("#addPersonBtn:nth-child(3)")).click();
        Thread.sleep(2000);

    }

    @Then("^check the original list$")
    public void checkTheOriginalList() throws Throwable {
        assertEquals(3,driver.findElements(By.className("w3-padding-16")).size());

    }

    @And("^I enter valuess :$")
    public void iEnteValuess(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            Thread.sleep(1000);}
}

    @And("^I click on clearAllFields$")
    public void iClickOnClearAllFields() throws Throwable {
        driver.findElement(By.cssSelector("#addPersonBtn:nth-child(1)")).click();
        Thread.sleep(2000);
    }

    @Then("^i check fields$")
    public void iCheckFields() throws Throwable {
        assertEquals("",driver.findElement(By.id("name")).getText());
        assertEquals("",driver.findElement(By.id("job")).getText());

    }
}

