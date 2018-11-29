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
}
