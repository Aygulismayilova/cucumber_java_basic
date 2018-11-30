package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.*;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SamplePOSteps {
    private WebDriver driver;
    static AgePage agePage;
    static AgeSubmittedPage ageSubmittedPage;

    public SamplePOSteps() {
        this.driver = Hooks.driver;
        agePage = PageFactory.initElements(Hooks.driver, AgePage.class);
        ageSubmittedPage = PageFactory.initElements(Hooks.driver, AgeSubmittedPage.class);
    }

    @When("^I enter name: \"([^\"]*)\" using PO$")
    public void iEnterName(String name) throws Throwable {
        agePage.enterName(name);
    }

    @And("^I enter age: (\\d+) using PO$")
    public void iEnterAge(int age) throws Throwable {
        agePage.enterAge(age);
    }

    @Given("^I (?:am on|open) age page using PO$")
    public void iAmOnAgePage() throws Throwable {
        driver.get(agePage.getPageUrl());
    }

    @And("^I click submit age using PO$")
    public void iClickSubmitAge() throws Throwable {
        agePage.clickSubmit();
    }

    @Then("^I see message: \"(.*)\" using PO$")
    public void iSeeMessage(String message) throws Throwable {
        ageSubmittedPage.checkMessageText(message);
    }

    @When("^I enter values using PO:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        agePage.enterName(valuesToEnter.get("name"));
        agePage.enterAge(valuesToEnter.get("age"));
    }

    @Given("^I am on enter a number page$")
    public void iAmOnEnterANumberPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number <number>$")
    public void iEnterNumberNumber() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("numb")).sendKeys();
    }

  //  @When("^I click the result button$")
  //  public void iEnterNumber(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
   //     driver.findElement(By.cssSelector("body > div.w3-row > div > div > div.w3-container.w3-card-4 > button")).click();
  //  }

 //   @And("^I click the result button$")
 //   public void iClickTheResultButton() throws Throwable {
   //     driver.findElement(By.id("result_button_text")).click();
    //}


    @Then("^I see correct result with text$")
    public void iSeeCorrectResultWithText() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue( driver.findElement(By.id("ch1_error")).isDisplayed());
    }
}
