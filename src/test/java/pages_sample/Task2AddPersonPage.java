package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

public class Task2AddPersonPage {
    @FindBy(how = How.CSS, using = "[onclick=\"openModalForAddPerson()\"]")
    private WebElement clearAllFieldsButton;
    @FindBy(how = How.ID, using = "name")
    private WebElement personName;
    @FindBy(how = How.ID, using = "surname")
    private WebElement personSurname;
    @FindBy(how = How.ID, using = "job")
    private WebElement personJob;
    @FindBy(how = How.ID, using = "dob")
    private WebElement personDOB;
    @FindBy(how = How.ID, using = "spanish")
    private WebElement checkboxSpanish;
    @FindBy(how = How.ID, using = "english")
    private WebElement checkboxEnglish;
    @FindBy(how = How.ID, using = "french")
    private WebElement checkboxFrench;
    @FindBy(how = How.ID, using = "male")
    private WebElement radioMale;
    @FindBy(how = How.ID, using = "female")
    private WebElement radioFemale;
    @FindBy(how = How.ID, using = "status")
    private WebElement dropdownSelect;
    @FindBy(how = How.CSS, using = "[onclick=\"addPersonToList()\"]")
    private WebElement addPersonButton;
    @FindBy(how = How.CSS, using = "[onclick=\"editPerson(0)\"]")
    private WebElement editPersonButton;
    @FindBy(how = How.CSS, using = "[onclick=\"window.history.back()\"")
    private WebElement cancelButton;

    public void clickClearAllFieldsButton(){
        clearAllFieldsButton.click();
    }

    public void inputPersonName(String name){
        personName.clear();
        personName.sendKeys(name);
    }

    public void inputPersonSurname(String surname){
        personSurname.clear();
        personSurname.sendKeys(surname);
    }

    public void inputPersonJob(String job){
        personJob.clear();
        personJob.sendKeys(job);
    }

    public void inputPersonDOB(String dob){
        personDOB.clear();
        personDOB.sendKeys(dob);
    }

    public void checkLanguageSpanish(){
        checkboxSpanish.click();
    }

    public void checkGenderMale(){
        radioMale.click();
    }

    public Select selectPersonStatus(){
        return new Select(dropdownSelect);
    }

    public void setOption(int value)
    {
        selectPersonStatus().selectByIndex(value);
    }

    public void clickAddPersonButton(){
        addPersonButton.click();
    }

    public void clickEditPersonButton(){
        editPersonButton.click();
    }

    public void checkFieldsAreEmpty(){
        assertEquals("", personName.getAttribute("value"));
        assertEquals("", personSurname.getAttribute("value"));
        assertEquals("", personJob.getAttribute("value"));
        assertEquals("", personDOB.getAttribute("value"));
        assertTrue(checkboxEnglish.isSelected());
        assertFalse(checkboxFrench.isSelected());
        assertFalse(checkboxSpanish.isSelected());
        assertFalse(radioMale.isSelected());
        assertFalse(radioFemale.isSelected());
        assertEquals("employee", dropdownSelect.getAttribute("value"));
    }

    public void clickCancelButton(){
        cancelButton.click();
    }
}
