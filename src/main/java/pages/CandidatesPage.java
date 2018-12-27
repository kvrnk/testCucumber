package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CandidatesPage {
    private WebDriver driver;

    public CandidatesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "menu_recruitment_viewRecruitmentModule")
    private WebElement recruitmentTab;

    @FindBy(id = "menu_recruitment_viewCandidates")
    private WebElement candidatesTab;

    @FindBy(id = "btnAdd")
    private WebElement buttonAdd;

    @FindBy(css = "ol li input")
    private List<WebElement> inputFields;

    @FindBy(id = "btnSave")
    private WebElement buttonSave;

    public void toFormCandidates() {
        recruitmentTab.click();
        candidatesTab.click();
    }

    public void addCandidate() {
        buttonAdd.click();
        inputFields.get(0).sendKeys("Mary");
        inputFields.get(2).sendKeys("Christmas");
        inputFields.get(3).sendKeys("hahahahe@mda.com");

        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(buttonSave));

        buttonSave.click();
    }
}
