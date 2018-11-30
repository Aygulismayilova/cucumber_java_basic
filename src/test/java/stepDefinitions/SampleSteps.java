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

    @Then("^I should see the home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page", driver.findElement(By.id("h1")).getText());
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
        // Write code here that turns the phrase above into concrete actions
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @When("^I enter \"([^\"]*)\" text$")
    public void iEnterText(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String textInput = "asdf";
        WebElement textBox = driver.findElement(By.id("text"));
        textBox.clear();
        textBox.sendKeys(textInput);

    }

    @And("^I click the result button$")
    public void iClickTheResultButton() throws Throwable {
        driver.findElement(By.id("result_button_text")).click();
    }

    @Then("^I see correct result with text \"([^\"]*)\"$")
    public void iSeeCorrectResultWithText(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String text = "You entered text: \"asdf\"";
        assertEquals(text, driver.findElement(By.id("result_text")).getText());
    }


    @When("^I enter number (\\d+)$")
    public void EnterNumber(int number) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("text")).clear();
        driver.findElement(By.id("text")).sendKeys(String.valueOf(number));
    }


    @And("^I click the result number button$")
    public void iClickTheResultNumberButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("result_button_number")).click();
    }

    @Then("^I see correct result with text (\\d+)$")
    public void iSeeCorrectResultWithText(int number) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("You entered number: \"" + number + "\"", driver.findElement(By.cssSelector("#result_number")).getText());
    }

    @Then("^I see the correct result with text \"([^\"]*)\"$")
    public void iSeeTheCorrectResultWithText(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("You entered name: \"" + name + "\"", driver.findElement(By.cssSelector("#result_name")).getText());
    }


//Task 1


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

    @Then("^I see error: \"([^\"]*)\"$")
    public void iSeeError(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }


    @When("^I enter a correct number: \"([^\"]*)\"$")
    public void iEnterACorrectNumber(String number) throws Throwable {
        driver.findElement(By.cssSelector(".w3-light-grey")).sendKeys(number);
    }


    @When("^I type number: \"([^\"]*)\"$")
    public void iTypeNumber(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("numb")).sendKeys(arg0);
    }

    @Then("^I see result: \"([^\"]*)\"$")
    public void iSeeResult(String result) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(result, driver.switchTo().alert().getText());

    }
    //Task 1 is finished
    @Then("^I see error if I enter number:$")

    // Write code here that turns the phrase above into concrete actions
    public void iSeeErrorIfIEnterNumbers(Map<String, String> numberToEnter) throws Throwable {
        for (Map.Entry<String, String> firstChecks : numberToEnter.entrySet()) {
            driver.findElement(By.id("numb")).clear();
            driver.findElement(By.id("numb")).sendKeys(firstChecks.getKey()); // 3
            driver.findElement(By.cssSelector(".w3-btn")).click();
            assertEquals(firstChecks.getValue(), driver.findElement(By.id("ch1_error")).getText());
            //firstChecks.getKey(); //3
           // firstChecks.getValue();// numbers is too small
//                |3 | Number is too small |
//                |103 | Number is too big |
                   // driver.findElement(By.id("numb")).clear();
          //  driver.findElement(By.id("ch1_error").sendKeys(getMessage()));
           // System.out.println("numb is " + e.getKey());
           // System.out.println("ch1_error is " + e.getValue());
        }

    }

    // Task 2
    @Given("^I am on People with jobs page$")
    public void iAmOnPeopleWithJobsPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs");
    }


    @When("^I click on Add person button$")
    public void iClickOnAddPersonButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]")).click();
    }


    @And("^I enter job \"([^\"]*)\"$")
    public void iEnterJob(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String textInput = "Engineer";
        WebElement textBox = driver.findElement(By.id("job"));
        textBox.clear();
        textBox.sendKeys(textInput);
    }

    @And("^press Add Person button$")
    public void pressAddPerson() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
            driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"][1]")).click();

    }




    @Then("^I edit name: \"([^\"]*)\"$")
    public void iEditName(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String textInput = "Michail";
        WebElement textBox = driver.findElement(By.id("name"));
        textBox.clear();
        textBox.sendKeys(textInput);
    }
    @Then("^I edit Job: \"([^\"]*)\"$")
    public void iEditJob(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String textInput = "Designer";
        WebElement textBox = driver.findElement(By.id("job"));
        textBox.clear();
        textBox.sendKeys(textInput);
    }

    @Then("^I click on Edit button$")
    public void iClickOnEditButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"modal_button\"]")).click();
    }

    @When("^I click on Pencil$")
    public void iClickOnPencil() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector("#person0 > span.w3-closebtn.editbtn.w3-padding.w3-margin-right.w3-medium > i")).click();
    }


    @When("^I click on Delete button$")
    public void iClickOnDeleteButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[1]")).click();
    }

    @And("^check the person is deleted$")
    public void checkThePersonIsDeleted() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^press on Reset List button$")
    public void pressOnResetListButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"][2]")).click();
    }

    @Then("^I press on button Clear all fields$")
    public void iPressOnButtonClearAllFields() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]")).click();
    }

    @And("^I see all the fields are empty$")
    public void iSeeAllTheFieldsAreEmpty() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement textBox = driver.findElement(By.id("name"));
        textBox.sendKeys("name");
        WebElement test = driver.findElement(By.id("job"));
        textBox.sendKeys("job");
    }
    


    //SubTask2


    @Given("^I am on People list page$")
    public void iAmOnPeopleListPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/tasks/list_of_people.html");
    }

    @Then("^I enter Name : \"([^\"]*)\"$")
    public void EnterName(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String textInput = "Lena";
        WebElement textBox = driver.findElement(By.id("name"));
        textBox.sendKeys(textInput);
    }

    @Then("^I enter Surname : \"([^\"]*)\"$")
    public void iEnterSurname(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String textInput = "ASDF";
        WebElement textBox = driver.findElement(By.id("surname"));
        textBox.sendKeys(textInput);
    }

    @And("^I enter Job :\"([^\"]*)\"$")
    public void EnterJob(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String textInput = "Economist";
        WebElement textBox = driver.findElement(By.id("job"));
        textBox.sendKeys(textInput);
    }


    @And("^I enter Date of Birth: \"([^\"]*)\"$")
    public void iEnterDateOfBirth(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String dateToEnter = "11/01/1990";
        WebElement dateBox = driver.findElement(By.id("dob"));
        assertEquals("", dateBox.getAttribute("value"));

        dateBox.clear();
        dateBox.sendKeys(dateToEnter);
        assertEquals(dateToEnter, dateBox.getAttribute("value"));

    }

    @And("^press English$")
    public void pressEnglish() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement text = driver.findElement(By.id("english"));
        WebElement showButton = driver.findElement(By.id("english"));
        assertTrue(showButton.isEnabled());
        showButton.click();
        assertTrue(text.isDisplayed());
    }

    @Then("^press : \"([^\"]*)\"$")
    public void press(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        WebElement text = driver.findElement(By.xpath("//*[@id=\"addEditPerson\"]/p[6]/label[3]"));
        WebElement showButton = driver.findElement(By.xpath("//*[@id=\"addEditPerson\"]/p[6]/label[3]"));
        assertTrue(showButton.isEnabled());
        showButton.click();
        assertTrue(text.isDisplayed());
    }

    @And("^in Employee status choose Intern$")
    public void inEmployeeStatusChooseIntern() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> checkBoxes = driver.findElements(By.id("status"));
        for (WebElement checkBox : checkBoxes) {
            checkBox.click();
            WebElement option1 = driver.findElement(By.xpath("//*[@id=\"status\"]/option[2]"));
            option1.click();
            assertTrue(option1.isSelected());
        }

    }

    @Then("^I click on Add button$")
    public void iClickOnAddButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"modal_button\"][1]")).click();
    }


    @Then("^i see new person in person list$")
    public void iSeeNewPersonInPersonList() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(driver.findElement(By.xpath("//*[@id=\"person3\"]/div")).isDisplayed());
    }


    @When("^I click on Add person$")
    public void iClickOnAddPerson() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"][1]")).click();
    }

    @When("^I click on Pencil button$")
    public void iClickOnPencilButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[2]")).click();
    }

    @Then("^I edit name:\"([^\"]*)\"$")
    public void EditName(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String textInput = "Jomn";
        WebElement textBox = driver.findElement(By.id("name"));
        textBox.sendKeys(textInput);
    }

    @Then("^I edit surname:\"([^\"]*)\"$")
    public void iEditSurname(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String textInput = "DFG";
        WebElement textBox = driver.findElement(By.id("surname"));
        textBox.sendKeys(textInput);
    }

    @Then("^I click Edit$")
    public void iClickEdit() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"modal_button\"][1]")).click();
    }

    @And("^compare new data$")
    public void compareNewData() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys();
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys();
    }

    @When("^I press x to delete person$")
    public void iPressXToDeletePerson() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[1]")).click();
    }

    @Then("^check the person data is deleted$")
    public void checkThePersonDataIsDeleted() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
         WebElement deleteFirsterson;
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[1]]")).click();

    }

    @And("^press on Reset List$")
    public void pressOnResetList() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"][2]")).click();
    }
}






















