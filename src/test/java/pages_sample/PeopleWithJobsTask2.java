package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PeopleWithJobsTask2 {
    @FindBy(how = How.CSS, using = ".w3-margin[onclick='openModalForAddPersonWithJob()']")
    private WebElement addPersonButton;

    @FindBy(how = How.ID, using = "name")
    private WebElement nameInput;

    @FindBy(how = How.ID, using = "job")
    private WebElement jobInput;

    @FindBy(how = How.CSS, using = ".w3-btn[onclick='addPersonWithJobToList()']")
    private WebElement addSubmitButton;

    @FindBy(how = How.CSS, using = "#person3 > .name")
    private WebElement checkCorrectNameInput;

    @FindBy(how = How.CSS, using = "#person3 > .job")
    private WebElement checkCorrectJobInput;

    @FindBy(how = How.CSS, using = ".w3-closebtn[onclick='openModalForEditPersonWithJob(3)']")
    private WebElement myEditButton;

    @FindBy(how = How.CSS, using = ".w3-btn[onclick='editPersonWithJob(3)']")
    private WebElement editButtonInList;

    @FindBy(how = How.ID, using = "name")
    private WebElement nameEdit;

    @FindBy(how = How.ID, using = "job")
    private WebElement jobEdit;

    @FindBy(how = How.CSS, using = "#person3 > .name")
    private WebElement checkCorrectEditName;

    @FindBy(how = How.CSS, using = "#person3 > .job")
    private WebElement checkCorrectEditJob;

    @FindBy(how = How.CSS, using = ".w3-closebtn[onclick='deletePerson(3)']")
    private WebElement deleteButton;

    @FindBy(how = How.ID, using = "person3")
    private List<WebElement> personDisappeared;

    @FindBy(how = How.CSS, using = ".w3-btn[onclick='resetListOfPeople()']")
    private WebElement resetListButton;

    @FindBy(how = How.CSS, using = "#person0 > .name")
    private List<WebElement> firstPersonNameOfListIsCorrect;

    @FindBy(how = How.CSS, using = "#person1 > .name")
    private List<WebElement> secondPersonNameOfListIsCorrect;

    @FindBy(how = How.CSS, using = "#person2 > .name")
    private List<WebElement> thirdPersonNameOfListIsCorrect;

    @FindBy(how = How.CSS, using = "#person0 > .job")
    private List<WebElement> firstPersonJobOfListIsCorrect;

    @FindBy(how = How.CSS, using = "#person1 > .job")
    private List<WebElement> secondPersonJobOfListIsCorrect;

    @FindBy(how = How.CSS, using = "#person2 > .job")
    private List<WebElement> thirdPersonJobOfListIsCorrect;

    @FindBy(how = How.CSS, using = ".w3-btn[onclick='openModalForAddPersonWithJob()']")
    private WebElement clearFieldButton;

    @FindBy(how = How.CSS, using = ".w3-input[id='name']")
    private WebElement nameFieldIsEmpty;

    @FindBy(how = How.CSS, using = ".w3-input[id='job']")
    private WebElement jobFieldIsEmpty;

    public PeopleWithJobsTask2() {
    }

    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people_with_jobs";
    }

    public void clickAddPersonButton() {
        addPersonButton.click();
    }

    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterJob(String job) {
        jobInput.clear();
        jobInput.sendKeys(job);
    }

    public void clickAddSubmitButton() {
        addSubmitButton.click();
    }

    public void checkCorrectNameInput(String name) {
        assertEquals(name, checkCorrectNameInput.getText());

    }

    public void checkCorrectJobInput(String job) {
        assertEquals(job, checkCorrectJobInput.getText());
    }

    public void clickOnMyEditButton() {
        myEditButton.click();
    }

    public void clickOnEditButtonInList() {
        editButtonInList.click();
    }

    public void enterEditName(String name) {
        nameEdit.clear();
        ;
        nameEdit.sendKeys(name);
    }

    public void enterEditJob(String job) {
        jobEdit.clear();
        jobEdit.sendKeys(job);
    }

    public void checkCorrectEditName(String name) {
        assertEquals(name, checkCorrectEditName.getText());
    }

    public void checkCorrectEditJob(String job) {
        assertEquals(job, checkCorrectEditJob.getText());
    }

    public void clickOnDeleteButton() {
        deleteButton.click();
    }

    public void checkThatPersonDisappeared() {
        assertEquals(0, personDisappeared.size());
    }

    public void clickOnResetListButton() {
        resetListButton.click();
    }

    public void checkFirstPersonNameOfListIsCorrect() {
        assertEquals(1, firstPersonNameOfListIsCorrect.size());
    }

    public void checkSecondPersonNameOfListIsCorrect() {
        assertEquals(1, secondPersonNameOfListIsCorrect.size());
    }

    public void checkThirdPersonNameOfListIsCorrect() {
        assertEquals(1, thirdPersonNameOfListIsCorrect.size());
    }

    public void checkFirstPersonJobOfListIsCorrect() {
        assertEquals(1, firstPersonJobOfListIsCorrect.size());
    }

    public void checkSecondPersonJobOfListIsCorrect() {
        assertEquals(1, secondPersonNameOfListIsCorrect.size());
    }

    public void checkThirdPersonJobOfListIsCorrect() {
        assertEquals(1, thirdPersonJobOfListIsCorrect.size());
    }

    public void clickOnClearFieldButton() {
        clearFieldButton.click();
    }

    public void checkThatNameFieldIsEmpty() {
        assertEquals("", nameInput.getAttribute("value"));
    }

    public void checkThatJobFieldIsEmpty() {
        assertEquals("", jobInput.getAttribute("value"));
    }
}
