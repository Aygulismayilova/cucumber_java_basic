package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class ScenarioTaskSteps {
    private WebDriver driver;

    public ScenarioTaskSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on 'enter a number' page$")
    public void i_am_on_enter_a_number_page() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter a number: \"([^\"]*)\"$")
    public void iEnterANumber(String number) throws Throwable {
        driver.findElement(By.cssSelector(".w3-light-grey")).sendKeys(number);

    }

    @When("^I click submit number$")
    public void i_click_submit_number() throws Throwable {
        driver.findElement(By.cssSelector(".w3-btn")).click();
    }

    @Then("^I see error: \"([^\"]*)\"$")
    public void i_see_error(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }


    @When("^I enter a correct number: \"([^\"]*)\"$")
    public void iEnterACorrectNumber(String number) throws Throwable {
        driver.findElement(By.cssSelector(".w3-light-grey")).sendKeys(number);
    }

    @Then("^I see result: \"([^\"]*)\"$")
    public void iSeeResult(String result) throws Throwable {
        assertEquals(result, driver.switchTo().alert().getText());
    }
}
