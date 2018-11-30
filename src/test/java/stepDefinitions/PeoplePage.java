package stepDefinitions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.junit.Assert.*;

public class PeoplePage {
    @FindBy(how = How.ID, using = "name")
    private WebElement nameInput;
    @FindBy(how = How.ID, using = "job")
    private WebElement jobInput;
    @FindBy(how = How.CSS, using = "[onclick=\"openModalForAddPersonWithJob()\"]")
    private WebElement addButton;
    @FindBy(how = How.CSS, using = "onclick=\"window.history.back()\"")
    private WebElement cancelButton;
    @FindBy(how = How.CSS, using = "[onclick=\"addPersonWithJobToList()\"]")
    private WebElement addButtonSecondPage;
    @FindBy(how = How.CSS, using = "[onclick=\"resetListOfPeople()\"]")
    private WebElement resetButton;
    @FindBy(how = How.CSS, using = "[onclick=\"openModalForEditPersonWithJob(2)\"] .fa.fa-pencil")
    private WebElement edditPersona;
    @FindBy(how = How.CSS, using = "#name")
    private WebElement nameSeconPage;
    @FindBy(how = How.CSS, using = "#modal_button")
    private WebElement cancelPersonaSecondPage;
    @FindBy(how = How.CSS, using = "[onclick=\"deletePerson(2)\"]")
    private WebElement deleteThirdPerson;
    @FindBy(how = How.CSS, using = "#addPersonBtn")
    private WebElement clearAllFields;
    @FindBy(how = How.CSS, using = "#person3 .w3-xlarge.name")
    private WebElement newPersonasName;
    @FindBy(how = How.CSS, using = "#person3 .job")
    private WebElement newPersonasJob;
    @FindBy(how = How.CSS, using = "#person2 [class = 'w3-xlarge name']")
    private WebElement janeName;

    public String getPageUrlOne() {
        return "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html";
    }


    public void enterName(String name) {

        nameInput.sendKeys(name);
    }

    public void enterJob(String job) {
        jobInput.sendKeys(job);
    }

    public void cancelClick() {
        cancelButton.click();
    }

    public void addClick() {
        addButton.click();
    }

    public void addClickOnSecondPage() {
        addButtonSecondPage.click();
    }

    public void resetOnPage() {
        resetButton.click();
    }

    public void edditOnFirstPage() {
        edditPersona.click();
    }

    public void enterNameSecondPage(String name) {
        nameSeconPage.clear();
        nameSeconPage.sendKeys(name);
    }
    public String textNameSecondPage() {
       return nameSeconPage.getText();

    }

    public void cancelSecondPage() {
        cancelPersonaSecondPage.click();
    }

    public void deleteTheLastPerson() {
        deleteThirdPerson.click();
    }

    public void clickClearAllFields() {
        clearAllFields.click();
    }
    public String textNewPersonasName() {
        return newPersonasName.getText();
    }

    public String textNewPersonasJob() {
        return newPersonasJob.getText();
    }
    public String janePersonasName() {
        return janeName.getText();
    }
    public String  enterJob() {
       return jobInput.getText();
    }
}