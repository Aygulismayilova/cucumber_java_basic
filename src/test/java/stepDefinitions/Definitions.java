package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class Definitions {
    private WebDriver driver;

    public Definitions() {
        this.driver = Hooks.driver;
    }


    @Given("^I am on People list$")
    public void iAmOnPeopleList() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/site/tasks/list_of_people.html");
    }


    @When("^i click on add new person button$")
    public void iClickOnAddNewPersonButton() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();


    }

    @And("^i enter surname \"([^\"]*)\"$")
    public void iEnterSurname(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("surname")).sendKeys(arg0);

    }

    @And("^i enter Job \"([^\"]*)\"$")
    public void iEnterJob(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("job")).sendKeys(arg0);
    }

    @And("^i enter date of birth \"([^\"]*)\"$")
    public void iEnterDateOfBirth(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("dob")).sendKeys(arg0);


    }

    @And("^check known languages$")
    public void checkKnownLanguages() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector(".w3-check[id='spanish'][type='checkbox']")).click();


    }

    @And("^check gender$")
    public void checkGender() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector(".w3-radio[id='male'][type='radio'")).click();
    }

    @And("^choose status$")
    public void chooseStatus() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Select dropdown = new Select(driver.findElement(By.id("status")));
        dropdown.selectByValue("contractor");

    }

    @Then("^i click on add$")
    public void iClickOnAdd() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("modal_button")).click();

    }

    @Then("^i should see new person in person list$")
    public void iShouldSeeNewPersonInPersonList() throws Throwable {
        assertTrue(driver.findElement(By.id("person3")).isDisplayed());

    }

    @When("^i click on pen icon next to person$")
    public void iClickOnPenIconNextToPerson() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.className("editbtn")).click();
    }



    @And("^I edit persons name to \"([^\"]*)\"$")
    public void iEditPersonsNameTo(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(arg0);
    }

    @And("^change status to intern$")
    public void changeStatusToIntern() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Select dropdown = new Select(driver.findElement(By.id("status")));
        dropdown.selectByValue("intern");
    }

    @Then("^i click edit button$")
    public void iClickEditButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("modal_button")).click();

    }


    @Then("^I press reset list$")
    public void iPressResetList() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//button[2]")).click();

    }

    @When("^i press x button on Mike$")
    public void iPressXButtonOnMike() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector("[onclick='deletePerson(0)']")).click();

    }

    @Then("^then i press x button$")
    public void thenIPressXButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector("[onclick='deletePerson(3)']")).click();

    }


    @When("^i click on pen icon next to Mike$")
    public void iClickOnPenIconNextToMike() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector("[onclick='openModalForEditPerson(0)']")).click();

    }

    @And("^edits are gone$")
    public void editsAreGone() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("Mike",driver.findElement(By.className("name")).getText());
        assertEquals("contractor",driver.findElement(By.className("status")).getText());


    }

    @And("^added person is gone$")
    public void addedPersonIsGone() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(0,driver.findElements(By.id("person3")).size());
    }

    @And("^person will be deleted$")
    public void personWillBeDeleted() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(0,driver.findElements(By.id("person3")).size());
    }

    @When("^then i press x button on Mike$")
    public void thenIPressXButtonOnMike() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector("[onclick='deletePerson(0)']")).click();
    }

    @Then("^Mike is back$")
    public void mikeIsBack() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        assertEquals("Mike",driver.findElement(By.className("name")).getText());
    }
}
