package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static org.junit.Assert.*;

public class Task2Page {
    @FindBy(how = How.CSS, using = "[onclick=\"openModalForAddPerson()\"]")
    private WebElement addPersonButton;
    @FindBy(how = How.CSS, using = "[onclick=\"resetListOfPeople()\"]")
    private WebElement resetListButton;
    @FindBy(how = How.CSS, using = "[onclick=\"openModalForEditPerson(0)\"]")
    private WebElement editPerson1;
    @FindBy(how = How.CSS, using = "[onclick=\"deletePerson(2)\"]")
    private WebElement deletePerson3;
    @FindBy(how = How.CSS, using = "#person3 > div > span.name")
    private WebElement person4Name;
    @FindBy(how = How.CSS, using = "#person3 > div > span.surname")
    private WebElement person4Surname;
    @FindBy(how = How.CSS, using = "#person3 > span.job")
    private WebElement person4Job;
    @FindBy(how = How.CSS, using = "#person3 > span.dob")
    private WebElement person4DOB;
    @FindBy(how = How.CSS, using = "#person3 > span.language")
    private WebElement person4Language;
    @FindBy(how = How.CSS, using = "#person3 > span.gender")
    private WebElement person4Gender;
    @FindBy(how = How.CSS, using = "#person3 > span.status")
    private WebElement person4Status;
    @FindBy(how = How.CSS, using = "#person0 > div > span.name")
    private WebElement person1Name;
    @FindBy(how = How.CSS, using = "#person0 > div > span.surname")
    private WebElement person1Surname;
    @FindBy(how = How.CSS, using = "#person0 > span.job")
    private WebElement person1Job;
    @FindBy(how = How.CSS, using = "#person0 > span.dob")
    private WebElement person1DOB;
    @FindBy(how = How.CSS, using = "#person0 > span.language")
    private WebElement person1Language;
    @FindBy(how = How.CSS, using = "#person0 > span.gender")
    private WebElement person1Gender;
    @FindBy(how = How.CSS, using = "#person0 > span.status")
    private WebElement person1Status;
    @FindBy(how = How.CSS, using = "[id=\"person2\"")
    private List<WebElement> person3;
    @FindBy(how = How.CSS, using = "[id=\"person2\"")
    private WebElement personJaneDoe;
    @FindBy(how = How.CSS, using = "[id=\"person3\"")
    private List<WebElement> person4;

    public String getPageURL(){
        return "https://kristinek.github.io/site/tasks/list_of_people";
    }

    public void clickAddPersonButton(){
        addPersonButton.click();
    }

    public void clickEditPersonButton(){
        editPerson1.click();
    }

    public void clickDeletePersonButton(){
        deletePerson3.click();
    }

    public void clickResetListButton(){
        resetListButton.click();
    }

    public void checkPersonInfoIsCorrect(){
        assertEquals("John", person4Name.getText());
        assertEquals("Doe", person4Surname.getText());
        assertEquals("Janitor", person4Job.getText());
        assertEquals("09/01/1939", person4DOB.getText());
        assertEquals("English, spanish,", person4Language.getText());
        assertEquals("male", person4Gender.getText());
        assertEquals("intern", person4Status.getText());
    }

    public void checkPersonInfoIsCorrectAfterEdit(){
        assertEquals("Mike", person1Name.getText());
        assertEquals("Adult", person1Surname.getText());
        assertEquals("Web Designer", person1Job.getText());
        assertEquals("12/25/1986", person1DOB.getText());
        assertEquals("English, Spanish", person1Language.getText());
        assertEquals("male", person1Gender.getText());
        assertEquals("employee", person1Status.getText());
    }

    public void deletePerson3(){
        deletePerson3.click();
    }

    public void checkIfPerson3IsDeleted(){
        assertEquals(0, person3.size());
    }

    public void resetList(){
        resetListButton.click();
    }

    public void checkPersonInfoIsCorrectAfterReset(){
        assertEquals("Mike", person1Name.getText());
        assertEquals("Kid", person1Surname.getText());
        assertEquals("Web Designer", person1Job.getText());
        assertEquals("12/25/1986", person1DOB.getText());
        assertEquals("English", person1Language.getText());
        assertEquals("male", person1Gender.getText());
        assertEquals("contractor", person1Status.getText());
    }

    public void checkIfPerson4IsDeleted(){
        assertEquals(0, person4.size());
    }

    public void checkIfJaneDoeIsBack(){
        assertTrue(personJaneDoe.isDisplayed());
    }

}
