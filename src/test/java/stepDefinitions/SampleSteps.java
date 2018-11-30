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


    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        assertTrue(driver.findElement(By.cssSelector(".w3-navbar")).isDisplayed());
    }


    @When("^I enter text$")
    public void iEnterText() throws Throwable {

        WebElement enterText = driver.findElement(By.xpath("//*[@id='text']"));
        enterText.clear();
        String textInput = "bla";
        enterText.sendKeys(textInput);
    }

    @And("^I click the result$")
    public void iClickTheResult() throws Throwable {
        driver.findElement(By.xpath("//*[@id='result_button_text']")).click();
    }

    @Then("^I see correct result text$")
    public void iSeeCorrectResultText() throws Throwable {
        WebElement result = driver.findElement(By.xpath("//*[@id='result_text']"));
        assertEquals("You entered text: \"bla\"", result.getText());
    }

    @When("^I enter \"([^\"]*)\" text$")
    public void iEnterText(String text) throws Throwable {
        WebElement enterText = driver.findElement(By.xpath("//*[@id='text']"));
        enterText.clear();
        enterText.sendKeys(text);
    }

    @Then("^I see correct result with text \"([^\"]*)\"$")
    public void iSeeCorrectResultWithText(String text) throws Throwable {
        WebElement result = driver.findElement(By.xpath("//*[@id='result_text']"));
        assertEquals("You entered text: \"hello\"", result.getText());
    }

    @When("^I enter number (\\d+)$")
    public void iEnterNumber(int number) throws Throwable {
        driver.findElement(By.id("number")).clear();
        driver.findElement(By.id("number")).sendKeys(String.valueOf(number));

    }

    @Then("^I see correct result text with number (\\d+)$")
    public void iSeeCorrectResultTextWithNumber(int number) throws Throwable {
        WebElement result = driver.findElement(By.xpath("//*[@id='result_number']"));
        assertEquals("You entered number: \"number\"", result.getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }


    @Given("^I am on act page$")
    public void iAmOnActPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @Then("^I see correct result with text: \"([^\"]*)\"$")
    public void iSeeCorrectResultWithText1(String text) throws Throwable {
        WebElement enterText = driver.findElement(By.xpath("//*[@id='text']"));
        enterText.clear();
        enterText.sendKeys(text);
    }


    @When("^I enter text: \"([^\"]*)\"$")
    public void iEnterText1(String text) throws Throwable {
        WebElement enterText = driver.findElement(By.xpath("//*[@id='text']"));
        enterText.clear();
        enterText.sendKeys(text);
    }

    // SAMPLE_4

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


    @When("^I am on number page$")
    public void iAmOnNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @Then("^I see error if I enter numbers:$")
    public void iSeeErrorIfIEnterNumbers(Map<String, String> numberToEnter) throws Throwable {
        for (Map.Entry<String, String> firstChecks : numberToEnter.entrySet()) {
            driver.findElement(By.id("numb")).clear();
            driver.findElement(By.id("numb")).sendKeys(firstChecks.getKey()); // 3
            driver.findElement(By.cssSelector(".w3-btn")).click();
            assertEquals(firstChecks.getValue(), driver.findElement(By.id("ch1_error")).getText()); // Number is too small
        }
    }
}

