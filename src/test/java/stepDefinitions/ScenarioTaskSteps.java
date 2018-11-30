package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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


    // FINAL TASK

    @Given("^I am on people with jobs page$")
    public void iAmOnPeopleWithJobsPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }


    @When("^I click add person button$")
    public void iClickAddPersonButton() throws Throwable {
        driver.findElement(By.xpath("//*[@class='w3-btn w3-white w3-border w3-left w3-margin'][1]")).click();
    }


    @And("^I add name: \"([^\"]*)\"$")
    public void iAddName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I add surname: \"([^\"]*)\"$")
    public void iAddSurname(String surname) throws Throwable {
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys(surname);
    }


    @And("^I add a job: \"([^\"]*)\"$")
    public void iAddAJob(String job) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }


    @And("^I add date of birth: \"([^\"]*)\"$")
    public void iAddDateOfBirth(String date) throws Throwable {

        Calendar cal = Calendar.getInstance();

//    go back 10 month
        cal.add(Calendar.MONTH, -10);
        String result = new SimpleDateFormat("MM/15/yyyy").format(cal.getTime());

        WebElement dateBox = driver.findElement(By.id("dob"));
        assertEquals("", dateBox.getAttribute("value"));

        dateBox.click();
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));

//    go back 10 month in calendar on page
        for (int i = 0; i < 10; i++) {
            dateWidget.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
        }

//    select date 15
        dateWidget.findElement(By.xpath("//a[text()='15']")).click();

        assertEquals(result, dateBox.getAttribute("value"));
        dateBox.clear();

    }

    @And("^I select languages$")
    public void iSelectLanguages() throws Throwable {
        assertTrue(driver.findElement(By.cssSelector(".w3-check[id='english'][type='checkbox']")).isSelected());
    }

    @And("^I select gender: \"([^\"]*)\"$")
    public void iSelectGender(String gender) throws Throwable {
        WebElement female = driver.findElement(By.id("female"));
        assertFalse(female.isSelected());
        female.click();
    }

    @And("^I select employee status: \"([^\"]*)\"$")
    public void iSelectEmployeeStatus(String status) throws Throwable {
        Select dropdown = new Select(driver.findElement(By.id("status")));
        assertEquals("Employee", dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Contractor");
        assertEquals("Contractor", dropdown.getFirstSelectedOption().getText());
    }

    @And("^I click add button$")
    public void iClickAddButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"modal_button\"][1]")).click();
    }

    @Then("^I see new person in a list$")
    public void iSeeNewPersonInAList() throws Throwable {
        assertTrue(driver.findElement(By.id("person3")).isDisplayed());
    }

    @When("^I click on edit button$")
    public void iClickOnEditButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id='person2']/span[2]")).click();
    }

    @And("^I edit name to: \"([^\"]*)\"$")
    public void iEditNameTo(String nameEdit) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Anna");
    }

    @And("^I edit surname to: \"([^\"]*)\"$")
    public void iEditSurnameTo(String surnameEdit) throws Throwable {
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys("Zippen");
    }

    @And("^I click edit button$")
    public void iClickEditButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id='modal_button']")).click();
    }

    @Then("^I see edited person in a list$")
    public void iSeeEditedPersonInAList() throws Throwable {
        assertEquals(driver.findElement(By.xpath("//*[@id='person2']/div/span[1]")).getText(), "Anna");
        assertEquals(driver.findElement(By.xpath("//*[@id='person2']/div/span[2]")).getText(), "Zippen");
    }


    @And("^I click on delete button$")
    public void iClickOnDeleteButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id='person0']/span[1]")).click();
    }


    @Then("^I see a list without a deleted person$")
    public void iSeeAListWithoutADeletedPerson() throws Throwable {
        assertTrue(driver.findElements(By.cssSelector(".w3-closebtn[onclick='deletePerson(0)']")).isEmpty());
    }

    @Then("^I click reset button$")
    public void iClickResetButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id='addPersonBtn'][2]")).click();
    }

    @Then("^I see basic job list$")
    public void iSeeBasicJobList() throws Throwable {
        assertTrue(driver.findElement(By.id("person0")).isDisplayed());
        assertTrue(driver.findElement(By.id("person1")).isDisplayed());
        assertTrue(driver.findElement(By.id("person2")).isDisplayed());
    }


    @And("^I click clear all button$")
    public void iClickClearAllButton() throws Throwable {
        driver.findElement(By.cssSelector(".w3-btn[onclick='openModalForAddPerson()']")).click();
    }

    @Then("^I see empty fields$")
    public void iSeeEmptyFields() throws Throwable {
        assertEquals("", driver.findElement(By.id("name")).getText());
        assertEquals("", driver.findElement(By.id("surname")).getText());
        assertEquals("", driver.findElement(By.id("job")).getText());
    }
}