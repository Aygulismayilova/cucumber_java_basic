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

    @Given("^I am ont action page$")
    public void iAmOntActionPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/actions");
//        throw new PendingException();
    }


    //     throw new PendingException();


    @And("^I click th result button$")
    public void iClickThResultButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("result_button_text")).click();
        //    throw new PendingException();
    }


    @Given("^I am on action page$")
    public void iAmOnActionPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/examples/actions");
//        throw new PendingException();
    }



    @And("^I click the result button$")
    public void iClickTheResultButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("result_button_text")).click();
//        throw new PendingException();
    }



    @Then("^I see correct result with text: \"([^\"]*)\"$")
    public void iSeeCorrectResultWithText(String text) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(text, driver.findElement(By.id("result_text")).getText());
      //  throw new PendingException();
    }

    @Then("^I see correct result with text: \"([^\"]*)\"Text\"([^\"]*)\"$")
    public void iSeeCorrectResultWithTextText(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("You entered text: \"Text\"", driver.findElement(By.id("result_text")).getText());
        //throw new PendingException();
    }



    @Then("^I see correct result text: \"([^\"]*)\"$")
    public void iSeeCorrectResultText(String arg0) throws Throwable {
        assertEquals("You entered text: \"" + arg0 + "\"", driver.findElement(By.id("result_text")).getText());
      //  throw new PendingException();
    }

    @When("^I enter text \"([^\"]*)\"$")
    public void iEnterText(String arg0) throws Throwable {
        driver.findElement(By.id("text")).clear();
        driver.findElement(By.id("text")).sendKeys(arg0);
      //  throw new PendingException();
    }


    //Task1 steps


    @Given("^I am on number page$")
    public void iAmOnNumberPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
       //throw new PendingException();
    }

    @When("^I enter number \"([^\"]*)\"$")
    public void iEnterNumber(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("numb")).sendKeys(arg0);
      //  throw new PendingException();
    }

    @And("^press submit$")
    public void pressSubmit() throws Throwable {
        driver.findElement(By.className("w3-btn")).click();
       // throw new PendingException();
    }



    @Then("^error message should appear \"([^\"]*)\"$")
    public void errorMessageShouldAppear(String arg0) throws Throwable {
       assertEquals(arg0,driver.findElement(By.id("ch1_error")).getText());
      //  throw new PendingException();
    }

    @When("^I enter number (\\d+)$")
    public void iEnterNumber(int arg0) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(arg0));
       // throw new PendingException();
    }

    @Then("^alert Message should appear \"([^\"]*)\"$")
    public void alertMessageShouldAppear(String arg0) throws Throwable {
        Alert firstAlert = driver.switchTo().alert();
        assertEquals(arg0,firstAlert.getText());
        //throw new PendingException();
    }
}
