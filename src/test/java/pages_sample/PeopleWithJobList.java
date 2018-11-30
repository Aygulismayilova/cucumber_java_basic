package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PeopleWithJobList {
    @FindBy(how = How.CSS, using = "[onclick=\"openModalForAddPersonWithJob()\"]")
    private WebElement addPersonButton;

    @FindBy(how = How.ID, using = "name")
    private WebElement nameInput;

    @FindBy(how = How.ID, using = "job")
    private WebElement jobInput;

    @FindBy(how = How.CSS, using = "[onclick='addPersonWithJobToList()']")
    private WebElement addButton;


    public void clickAddPersonButton() {
        addPersonButton.click();
    }

    public void enterName(String name) {
        nameInput.sendKeys(name);
    }
    public void enterJob (String job) {
        jobInput.sendKeys(job);
    }
    public void clickAddButton (){
        addButton.click();
    }
        public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people_with_jobs";
    }
}
