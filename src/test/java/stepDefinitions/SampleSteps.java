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
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
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

    @Then("^I see message: \"([^\"]*)\"$")
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

    @Given("^I am on action page$")
    public void iAmOnActionPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @When("^I enter text$")
    public void iEnterText() throws Throwable {
        String textInput = "asdf";
        WebElement textBox = driver.findElement(By.id("text"));
        textBox.clear();
        textBox.sendKeys(textInput);
    }

    @And("^I click the result button$")
    public void iClickTheResultButton() throws Throwable {
        driver.findElement(By.id("result_button_text")).click();
    }

    @Then("^I see correct result text$")
    public void iSeeCorrectResultText() throws Throwable {
        String text = "You entered text: \"asdf\"";
        assertEquals(text, driver.findElement(By.id("result_text")).getText());
    }

    @When("^I enter \"([^\"]*)\" text$")
    public void iEnterText(String text) throws Throwable {
        driver.findElement(By.id("text")).clear();
        driver.findElement(By.id("text")).sendKeys(text);
    }

    @Then("^I see correct result with text \"([^\"]*)\"$")
    public void iSeeCorrectResultWithText(String text) throws Throwable {
        assertEquals("You entered text: \"" + text + "\"", driver.findElement(By.cssSelector("#result_text")).getText());
    }

    @When("^I enter number (\\d+)$")
    public void iEnterNumber(int number) throws Throwable {
        driver.findElement(By.id("text")).clear();
        driver.findElement(By.id("text")).sendKeys(String.valueOf(number));
    }

    @And("^I click the result number button$")
    public void iClickTheResultNumberButton() throws Throwable {
        driver.findElement(By.id("result_button_number")).click();
    }

    @Then("^I see correct result with text (\\d+)$")
    public void iSeeCorrectResultWithText(int number) throws Throwable {
        assertEquals("You entered number: \"" + number + "\"", driver.findElement(By.cssSelector("#result_number")).getText());
    }


    @When("^I enter numberS: (\\d+)$")
    public void iEnterNumberS(int number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(number));
    }

    @And("^I click submitS$")
    public void iClickSubmitS() throws Throwable {

    }

    @Then("^I see correct message with text: \"([^\"]*)\"$")
    public void iSeeCorrectMessageWithText(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I see correct messageS: \"([^\"]*)\"$")
    public void iSeeCorrectMessageS(String arg0) throws Throwable {
        String text = "Number is too small";
        assertEquals(text, driver.findElement(By.id("ch1_error")).getText());
    }

    @When("^I enter numberB: (\\d+)$")
    public void iEnterNumberB(int number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(number));
    }

    @Then("^I see correct message with textB: \"([^\"]*)\"$")
    public void iSeeCorrectMessageWithTextB(String arg0) throws Throwable {
        String text = "Number is too big";
        assertEquals(text, driver.findElement(By.id("ch1_error")).getText());
    }

    @And("^I click submit$")
    public void iClickSubmit() throws Throwable {
        driver.findElement(By.className("w3-orange")).click();
    }

    @When("^I enter textT: T$")
    public void iEnterTextTT() throws Throwable {
        String text = "T";
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(text);
    }

    @Then("^I see correct message with textT: \"([^\"]*)\"$")
    public void iSeeCorrectMessageWithTextT(String arg0) throws Throwable {
        String text = "Please enter a number";
        assertEquals(text, driver.findElement(By.id("ch1_error")).getText());
    }

    @When("^I enter numberT: (\\d+)$")
    public void iEnterNumberT(int number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(number));
    }

    @Then("^I see correct message with textC: \"([^\"]*)\"$")
    public void iSeeCorrectMessageWithTextC(String arg0) throws Throwable {
        Alert alert = driver.switchTo().alert();
        alert.getText();
        assertEquals(alert.getText(), "Square root of 64 is 8.00");
        alert.accept();
    }

    @When("^I enter number: \"([^\"]*)\"$")
    public void iEnterNumber(String number) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(number));
    }

    @And("^I enter text: <T>$")
    public void iEnterTextT() throws Throwable {
        String text = "T";
        driver.findElement(By.id("numb")).sendKeys(text);
    }

    @Then("^I see messageT: \"([^\"]*)\"$")
    public void iSeeMessageT(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

    @And("^I check alert message if there is one$")
    public void iCheckAlertMessageIfThereIsOne() throws Throwable {
        Alert alertMessage = driver.switchTo().alert();
        assertEquals("Alert text : Square root of 64 is 8.00", alertMessage.getText());
    }

    @And("^I click OK button in alert message$")
    public void iClickOKButtonInAlertMessage() throws Throwable {
        driver.switchTo().alert().accept();
    }

    @When("^I am on the number page$")
    public void iAmOnTheNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @Then("^I see an error if I enter the message:: \"([^\"]*)\"$")
    public void iSeeAnErrorIfIEnterTheMessage(String arg0) throws Throwable {
        String text = "Number is too small";
        assertEquals(text, driver.findElement(By.id("ch1_error")).getText());
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

// 2nd Task beggining

    @Given("^I am on people job list$")
    public void iAmOnPeopleJobList() throws Throwable {

        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }

    @When("^I click Add person button$")
    public void iClickAddPersonButton() throws Throwable {

        driver.get("https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html");
        // Thread.sleep(3000);
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @And("^I write down Name$")
    public void iWriteDownName() throws Throwable {

        String name = "John";
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I write down Job$")
    public void iWriteDownJob() throws Throwable {

        String job = "Developer";
        driver.findElement(By.id("job")).sendKeys(job);

    }

    @And("^I click Add$")
    public void iClickAdd() throws Throwable {

        driver.findElement(By.xpath("//*[@id='modal_button'][1]")).click();
    }

    @Then("^I see that person record is added correctly$")
    public void iSeeThatPersonRecordIsAddedCorrectly() throws Throwable {

        String name = "John";
        String job = "Developer";

        assertEquals(name, driver.findElement(By.cssSelector("#person3 > span.w3-xlarge.name")).getText());
        assertEquals(job, driver.findElement(By.cssSelector("#person3 > span.job")).getText());
    }

    @And("^I click Cancel button$")
    public void iClickCancelButton() throws Throwable {

        driver.findElement(By.xpath("//*[@id='modal_button'][2]")).click();
    }

    @Then("^I see that all information is deleted$")
    public void iSeeThatAllInformationIsDeleted() throws Throwable {

        assertTrue(driver.findElement(By.cssSelector("#person0 > span.w3-xlarge.name")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("#person1 > span.w3-xlarge.name")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("#person2 > span.w3-xlarge.name")).isDisplayed());
    }

    @And("^I click Clear all fields button$")
    public void iClickClearAllFieldsButton() throws Throwable {

        driver.findElement(By.cssSelector("//*[@id='addPersonBtn']")).click();
    }

    @When("^I click Edit person button with pen$")
    public void iClickEditPersonButtonWithPen() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[2]")).click();
    }

    @And("^I delete name and surname$")
    public void iDeleteNameAndSurname() throws Throwable {

        driver.get("https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html?id=0");
        // Thread.sleep(2000);
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("job")).clear();
    }

    @Then("^I see that new person record is added correctly$")
    public void iSeeThatNewPersonRecordIsAddedCorrectly() throws Throwable {

        String name = "John";
        String job = "Developer";

        assertEquals(name, driver.findElement(By.xpath("//*[@id=\"person0\"]/span[3]")).getText());
        assertEquals(job, driver.findElement(By.cssSelector("#person0 > span.job")).getText());
    }


    @Then("^I see that all information is added correctrly$")
    public void iSeeThatAllInformationIsAddedCorrectrly() throws Throwable {

        String name = "John";
        String job = "Developer";

        assertEquals(name, driver.findElement(By.xpath("//*[@id=\"person0\"]/span[3]")).getText());
        assertEquals(job, driver.findElement(By.cssSelector("#person0 > span.job")).getText());
    }

    @And("^I reset the list$")
    public void iResetTheList() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"][2]")).click();
    }

    @Then("^I see that all information reseted back$")
    public void iSeeThatAllInformationResetedBack() throws Throwable {

        String name = "Mike";
        String job = "Web Designer";

        assertEquals(name, driver.findElement(By.xpath("//*[@id=\"person0\"]/span[3]")).getText());
        assertEquals(job, driver.findElement(By.cssSelector("#person0 > span.job")).getText());
    }

    @When("^I click delete cross next to person name$")
    public void iClickDeleteCrossNextToPersonName() throws Throwable {

        driver.findElement(By.xpath("//*[@class=\"w3-closebtn closebtn w3-padding w3-margin-right w3-medium\"][1]")).click();
    }

    @And("^I see that name is deleted$")
    public void iSeeThatNameIsDeleted() throws Throwable {

        assertTrue(driver.findElement(By.cssSelector("#person1 > span.w3-xlarge.name")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("#person2 > span.w3-xlarge.name")).isDisplayed());
    }

    @Then("^I see that all information is reseted$")
    public void iSeeThatAllInformationIsReseted() throws Throwable {

        String name = "Mike";
        String job = "Web Designer";

        assertEquals(name, driver.findElement(By.xpath("//*[@id=\"person0\"]/span[3]")).getText());
        assertEquals(job, driver.findElement(By.cssSelector("#person0 > span.job")).getText());

        assertTrue(driver.findElement(By.cssSelector("#person1 > span.w3-xlarge.name")).isDisplayed());
        assertTrue(driver.findElement(By.cssSelector("#person2 > span.w3-xlarge.name")).isDisplayed());
    }

    @And("^I click Clear all fields buttonN$")
    public void iClickClearAllFieldsButtonN() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"][1]")).click();
    }

    @Then("^all previously filled fields are empty$")
    public void allPreviouslyFilledFieldsAreEmpty() throws Throwable {

        assertFalse(driver.findElement(By.xpath("//*[@id=\"name\"]")).isSelected());
        assertFalse(driver.findElement(By.xpath("//*[@id=\"job\"]")).isSelected());
    }
}


