package stepDefinitions;

import cucumber.api.PendingException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static junit.framework.TestCase.assertEquals;

public class TaskSteps {
    private WebDriver driver;

    public TaskSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on Enter a number page$")
    public void iAmOnEnterNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter an input: \"([^\"]*)\"$")
    public void iEnterAnInput(String input) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(input);
    }

    @And("^I click submit button$")
    public void iClickSubmitButton() throws Throwable {
        driver.findElement(By.className("w3-orange")).click();
    }

    @Then("^I see error message \"([^\"]*)\"$")
    public void iSeeErrorMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

    @Then("^I see alert message \"([^\"]*)\"$")
    public void iSeeAlertMessage(String message) throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals(message, alert.getText());
    }

    @Then("^I accept alert window$")
    public void iAcceptAlertWindow() throws Throwable {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
